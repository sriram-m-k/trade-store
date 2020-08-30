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
package com.test.cib.commons.validators;

import com.test.cib.commons.data.ModelInterface;
import com.test.cib.commons.validators.models.ValidationModel;
import com.test.cib.commons.validators.utils.ValidationExecutor;
import com.test.cib.commons.validators.utils.ValidatorsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class GenericValidator implements Validator {

	Logger logger = LoggerFactory.getLogger(GenericValidator.class);
	private String validationRuleId = null;

	private ValidatorsUtil validatorsUtil ;

	private ValidationExecutor validationExecutor;
	public GenericValidator(){}

	public GenericValidator(ValidatorsUtil validatorsUtil ,ValidationExecutor validationExecutor, String validationRuleId)	{
		this.validatorsUtil = validatorsUtil;
		this.validationExecutor = validationExecutor;
		this.validationRuleId = validationRuleId;

	}


	@Override
	public boolean supports(Class<?> aClass) {
		return ModelInterface.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object model, Errors errors) {

		List<ValidationModel> validations = validatorsUtil.getValidationsForRule(validationRuleId);

		logger.info("Object ::" + model);
		if (validations == null ) {
			throw new IllegalArgumentException("Invalid Rule Id ::" + validationRuleId);
		}
		try {

			ModelInterface value = (ModelInterface) model;
			for (ValidationModel validationModel : validations) {


				validationExecutor.executeValidation(validationModel, value,errors);
			}
		} catch (InstantiationException exp) {
			throw new RuntimeException("Failed to instantiate the validator",exp);
		}
	}
}
