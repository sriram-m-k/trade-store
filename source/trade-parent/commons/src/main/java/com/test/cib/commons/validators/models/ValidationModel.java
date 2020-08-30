package com.test.cib.commons.validators.models;

public class ValidationModel {

	private String id;

	private ValidationType type;

	private String failureMessage;

	private String[] failedFields;

	private String dataValidationImpl;

	private String query;

	private String apiURL;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ValidationType getType() {
		return type;
	}

	public void setType(ValidationType type) {
		this.type = type;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public String[] getFailedFields() {
		return failedFields;
	}

	public void setFailedFields(String[] failedFields) {
		this.failedFields = failedFields;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getDataValidationImpl() {
		return dataValidationImpl;
	}

	public void setDataValidationImpl(String dataValidationImpl) {
		this.dataValidationImpl = dataValidationImpl;
	}
}
