package com.test.cib.commons.validators.models;

import java.util.List;

public class ValidatorRuleModel {

	private String ruleId;
	private String objectType;
	private List<ValidationModel> validations;


	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public List<ValidationModel> getValidations() {
		return validations;
	}

	public void setValidations(List<ValidationModel> validations) {
		this.validations = validations;
	}
}
