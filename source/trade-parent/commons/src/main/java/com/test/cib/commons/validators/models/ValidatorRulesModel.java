package com.test.cib.commons.validators.models;

import java.util.List;

public class ValidatorRulesModel {

	private List<ValidatorRuleModel> validationRules;

	public List<ValidatorRuleModel> getValidationRules() {
		return validationRules;
	}

	public void setValidationRules(List<ValidatorRuleModel> validationRules) {
		this.validationRules = validationRules;
	}

	@Override
	public String toString() {
		return "ValidatorRulesModel{" +
				"validationRules=" + validationRules +
				'}';
	}
}
