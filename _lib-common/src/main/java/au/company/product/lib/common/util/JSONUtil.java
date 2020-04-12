package au.company.product.lib.common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JSONUtil {

	private static final Logger LOG = LogManager.getLogger(JSONUtil.class);

	private JSONUtil() {

	}

	private static final ObjectMapper objectMapper = new ObjectMapper();


	public static synchronized String toString(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return "{}";
	}

	public static synchronized <T> T get(String fileName, Class<T> type) {
		TypeReference<T> typeReference = new TypeReference<T>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(fileName);
		try {
			if(inputStream ==null)
				throw new JsonFileNotFoundException(Error.JSON_FILE_NOT_FOUND.getCode(),fileName);
			Object returnObj = objectMapper.readValue(inputStream, typeReference);
			return objectMapper.convertValue(returnObj, type);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		throw new InvalidJsonContentException(Error.INVALID_JSON_CONTENT.getCode(),Error.DATA_NOT_FOUND.getDescription());
	}

	public static synchronized String get(String fileName) {
		TypeReference<Object> typeReference = new TypeReference<Object>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(fileName);
		try {
			if(inputStream ==null)
				throw new JsonFileNotFoundException(Error.JSON_FILE_NOT_FOUND.getCode(),fileName);
			Object returnObj = objectMapper.readValue(inputStream, typeReference);
			return objectMapper.writeValueAsString(returnObj);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		throw new InvalidJsonContentException(Error.INVALID_JSON_CONTENT.getCode(),Error.DATA_NOT_FOUND.getDescription());
	}
	
	
	public static synchronized <T> List<T> getArray(String fileName, Class<T> type) {
		InputStream inputStream = TypeReference.class.getResourceAsStream(fileName);
		try {
			if(inputStream ==null)
				throw new JsonFileNotFoundException(Error.JSON_FILE_NOT_FOUND.getCode(),fileName);
			CollectionType collectionType = objectMapper.getTypeFactory()
				      .constructCollectionType(List.class, type);
			return objectMapper.readValue(inputStream, collectionType);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		throw new InvalidJsonContentException(Error.INVALID_JSON_CONTENT.getCode(),Error.DATA_NOT_FOUND.getDescription());
	}

	public static synchronized <T>List<T> getArrayOfMetaData(String version,
			Class<T> type) {
		return getArray("/data/meta/" + version + "-" + type.getSimpleName() + ".json",
				type);

	}
	
	public static synchronized <T> T getObject(String object, Class<T> type) {
		try {
			return objectMapper.readValue(object, type);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		throw new BadRequestException(Error.DATA_NOT_FOUND.getCode(),Error.DATA_NOT_FOUND.getDescription());
	}

	public static synchronized void write(String fileName, Object obj) {
		try {
			objectMapper.writeValue(new File(fileName), obj);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
	}
}
