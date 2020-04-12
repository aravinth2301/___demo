package au.company.product.lib.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.company.product.lib.common.domain.admin.AppUser;

public interface _Controller {
	static final Logger log = LogManager.getLogger(_Controller.class);
		
	public default <T> ResponseEntity<T> success(T data) {
		if (data instanceof AppUser) {
			((AppUser) data).setPassword(null);
		}
		return respondWith(data, HttpStatus.OK);
	}

	public default <T> ResponseEntity<T> respondWith(T data, HttpStatus statusCode) {
		return new ResponseEntity<>(data, statusCode);
	}


}
