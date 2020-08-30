package com.test.cib.commons.tests;

import com.test.cib.commons.tests.models.TestModel;

import com.test.cib.commons.tests.validators.TestModelIdValidator;
import com.test.cib.commons.tests.validators.TestModelNameValidator;
import com.test.cib.commons.validators.models.ValidationModel;
import com.test.cib.commons.validators.models.ValidationType;
import com.test.cib.commons.validators.utils.ValidationExecutor;
import com.test.cib.commons.validators.utils.ValidatorsUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;


import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ValidationExecutor.class, ValidatorsUtil.class, TestModelIdValidator.class, TestModelNameValidator.class})
@ActiveProfiles("test")
public class ValidationExecutor_UT {

	ValidationExecutor executor = new ValidationExecutor();

/*
	@Test
	public void checkValidationIsSuccess() throws InstantiationException	{

		ValidationModel validationModel = new ValidationModel();
		validationModel.setType(ValidationType.CLASS);
		validationModel.setDataValidationImpl("testModelNameValidator");
		TestModel testModel = new TestModel();
		testModel.setTestId("TestId");
		testModel.setTestName("Testing");
		BindingResult results = mock(BindingResult.class);
		assertTrue(executor.executeValidation(validationModel, testModel,results));

	}
*/
	@Test(expected = InstantiationException.class)
	public void checkIfValidationClassImplNotFound() throws InstantiationException	{
		ValidationModel validationModel = new ValidationModel();
		validationModel.setType(ValidationType.CLASS);
		validationModel.setDataValidationImpl("com.test.cib.commons.tests.validators.TestModelValidator1");
		TestModel testModel = new TestModel();
		testModel.setTestId("TestId");
		testModel.setTestName("Testing");
		BindingResult results = mock(BindingResult.class);
		executor.executeValidation(validationModel, testModel,results);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void checkNotImplementationOfQueryValidationTypes()	throws InstantiationException{
		ValidationModel validationModel = new ValidationModel();
		validationModel.setType(ValidationType.QUERY);
		TestModel testModel = new TestModel();
		testModel.setTestId("TestId");
		testModel.setTestName("Testing");
		BindingResult results = mock(BindingResult.class);
		executor.executeValidation(validationModel, testModel,results);

	}

	public void checkIfValidationOrModelIsNull()	throws InstantiationException{
		BindingResult results = mock(BindingResult.class);
		assertTrue(executor.executeValidation(null, null,results));

	}
}
