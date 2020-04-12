package au.company.product.lib.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidJsonContentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826703433324279898L;
	private final String code;
	private final String requestContent;
	public InvalidJsonContentException(String code,String message) {
		super(message);
		this.code = code;
		this.requestContent = "NA";
	}
	public InvalidJsonContentException(Error error,String requestContent) {	
		super(error.getDescription());
		this.code = error.getCode();
		this.requestContent = requestContent;
	}
	public String getCode() {
		return code;
	}
	public String getRequestContent() {
		return requestContent;
	}
	
	
}
