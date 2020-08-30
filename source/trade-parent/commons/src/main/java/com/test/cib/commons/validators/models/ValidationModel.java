/*********************************************************************
 Copyright [2020] [Sriram M.K]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 *********************************************************************/
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
