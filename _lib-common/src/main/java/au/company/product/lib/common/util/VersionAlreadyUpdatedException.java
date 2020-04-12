package au.company.product.lib.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VersionAlreadyUpdatedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3870380763379155240L;

	public VersionAlreadyUpdatedException(String message) {
		super(message);
	}
	public VersionAlreadyUpdatedException() {
		super();
	}

}
