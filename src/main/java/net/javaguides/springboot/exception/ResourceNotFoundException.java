package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Step3:To create Exception message given to the Client if resource is not found.

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s is not found %s:'%s'",resourceName,fieldName,fieldValue));//We want message in string format so printing s% is not found s%:fieldValue
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
		
	}
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public long getFieldValue() {
		return fieldValue;
	}
	
	
	

}
