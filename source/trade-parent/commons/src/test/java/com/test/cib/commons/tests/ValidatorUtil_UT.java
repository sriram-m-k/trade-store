package com.test.cib.commons.tests;


import com.test.cib.commons.tests.validators.TestModelIdValidator;
import com.test.cib.commons.tests.validators.TestModelNameValidator;
import com.test.cib.commons.validators.models.ValidatorRulesModel;
import com.test.cib.commons.validators.utils.ValidatorsUtil;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = {ApplicationContext.class,ValidatorsUtil.class, TestModelIdValidator.class, TestModelNameValidator.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ValidatorUtil_UT {


	@Autowired
	private ValidatorsUtil validatorsUtil;

	@Test
	public void checkIfValidatorsAreLoaded() throws IllegalAccessException {
		ValidatorRulesModel result = (ValidatorRulesModel)ReflectionTestUtils.getField(validatorsUtil,"validatorRules");
		assertEquals("All the rules retrieved",3,result.getValidationRules().size());


	}
	@Test
	public void checkIfGettingValidationRules() throws IllegalAccessException {


		assertEquals("Only one validation  for rule-1 ",1,validatorsUtil.getValidationsForRule("rule-1").size());
		assertEquals("Two validation  for rule-2 ",2,validatorsUtil.getValidationsForRule("rule-2").size());

	}
	@Test
	public void checkIfValueIsNullForNonExistentRule() throws IllegalAccessException {


		assertEquals("No rule should exist. But looks some configuration error ",null,validatorsUtil.getValidationsForRule("rule-5"));


	}
}
