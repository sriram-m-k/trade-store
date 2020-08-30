/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.commons.validators.utils;

import com.test.cib.commons.data.ModelInterface;
import com.test.cib.commons.validators.ValidatorInterface;
import com.test.cib.commons.validators.models.ValidationModel;
import com.test.cib.commons.validators.models.ValidationType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.springframework.validation.Errors;

@Configuration
public class ValidationExecutor {

	@Autowired
	private ApplicationContext сontext;

	Logger logger = LoggerFactory.getLogger(ValidationExecutor.class);

	/**
	 *  Factory interface executing validators
	 *
	 * @param validation
	 * @param model
	 * @return
	 * @throws InstantiationException
	 */
	public boolean executeValidation(ValidationModel validation, ModelInterface model, Errors errors) throws InstantiationException {
		if(validation ==null || model==null)	{
			return true;
		}
		ValidatorInterface validatorInterface = null;
		// ideally use factory to handle get the right implementation

		if(validation.getType()== ValidationType.CLASS)	{
			String validationClass = validation.getDataValidationImpl();

			validatorInterface = getValidator(validationClass);
			return validatorInterface.validate(model,errors);
		} else	{
			throw new UnsupportedOperationException("Not implemented");
		}
	}

	/**
	 *  Gets the validator implementation
	 * @param validatorImpl
	 * @return
	 * @throws InstantiationException
	 */
	private ValidatorInterface getValidator(String validatorImpl) throws InstantiationException {

		ValidatorInterface validator = null;
		try	{

			 validator = (ValidatorInterface)this.сontext.getBean(validatorImpl);

		} catch(Exception exp) {

			throw new InstantiationException("Could not load the Validator class. Check the configuration");
		}
		return validator;
	}
}