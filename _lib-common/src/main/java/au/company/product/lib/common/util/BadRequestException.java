package au.company.product.lib.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	private static final long serialVersionUID = 3465043377878838323L;
	private final String code;
	private final String requestContent;
	public BadRequestException(String code,String message) {
		super(message);
		this.code = code;
		this.requestContent = "NA";
	}
	public BadRequestException(Error error,String requestContent) {	
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
