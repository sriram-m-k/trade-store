/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.commons.validators.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.cib.commons.validators.models.ValidationModel;
import com.test.cib.commons.validators.models.ValidatorRuleModel;
import com.test.cib.commons.validators.models.ValidatorRulesModel;
import org.apache.logging.log4j.core.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ValidatorsUtil {

	Logger logger = LoggerFactory.getLogger(ValidatorsUtil.class);
	// defauled to false by default
	@Value("${test.cib.validation.enabled:false} ")
	private boolean validationEnabled;

	private ValidatorRulesModel validatorRules;

	private static final ObjectMapper mapper = new ObjectMapper();

	@Value("${test.cib.validation.rules-file:validation-rules.json}")
	private String rulesFile;
	@PostConstruct
	public  void init() throws IllegalAccessException {
		logger.info("--------Initializing the rules---------");
		if(!validationEnabled)	{
			return;
		}
		try {
			File file = ResourceUtils.getFile("classpath:" + rulesFile);
			String content = new String(Files.readAllBytes(file.toPath()));
			logger.info("Content ::" + content);
			validatorRules = mapper.readValue(content,ValidatorRulesModel.class);

		} catch(IOException exp)	{

			throw new IllegalAccessException("Error loading file" + rulesFile);

		}

	}

	/**
	 * Returns the list of validation for a rule id. Returns Null if rule does not exist
	 *
	 * @param ruleId
	 * @return
	 */
	public List<ValidationModel> getValidationsForRule(String ruleId)	{


		List<ValidatorRuleModel> results= validatorRules.getValidationRules().stream()
				.filter(item -> item.getRuleId().equals(ruleId))
				.collect(Collectors.toList());
		logger.info("Validator s" + results);
		if(Assert.isEmpty(results) || results.size()>1)	{
			return null;
		}
		return results.get(0).getValidations();
	}

}
