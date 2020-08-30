package com.test.cib.commons.tests.validators;

import com.test.cib.commons.data.ModelInterface;
import com.test.cib.commons.tests.models.TestModel;
import com.test.cib.commons.validators.ValidatorInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Configuration("testModelNameValidator")
public class TestModelNameValidator implements ValidatorInterface {

	public boolean validate(ModelInterface model, Errors errors) 	{

		if(model ==null ||  !(model instanceof TestModel))	{
			throw new IllegalArgumentException("Invalid Object for validation");
		}
		TestModel modelImpl = (TestModel) model;
		if(StringUtils.isEmpty(modelImpl.getTestName()))	{
			return false;
		}
		return true;
	}
}