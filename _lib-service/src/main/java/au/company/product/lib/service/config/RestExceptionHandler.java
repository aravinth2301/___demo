package au.company.product.lib.service.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import au.company.product.lib.common.domain.admin.ErrorLog;
import au.company.product.lib.common.dto.ResponseDTO;
import au.company.product.lib.common.util.BadRequestException;
import au.company.product.lib.dao.ErrorLogCRUD;

@RestControllerAdvice
public class RestExceptionHandler {
	static final Logger log = LogManager.getLogger(RestExceptionHandler.class);
	
	@Autowired
	private ErrorLogCRUD errorLogCRUD;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseDTO handleBadRequestException(BadRequestException ex) {
		String msg = ex.getMessage();
		ResponseDTO res = new ResponseDTO();
		res.setError(msg);
		log.log(Level.ERROR, msg);
		ErrorLog errorLog = new ErrorLog(ex.getCode(),ex.getRequestContent());
		errorLogCRUD.save(errorLog);
		return res;
	}
}
