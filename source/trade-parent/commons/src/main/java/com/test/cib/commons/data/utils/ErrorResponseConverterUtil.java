/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.commons.data.utils;

import com.test.cib.commons.data.models.ErrorResponse;
import com.test.cib.commons.data.models.ErrorResponses;
import org.apache.logging.log4j.core.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;


public class ErrorResponseConverterUtil {


	public static ErrorResponses comverErrorResponses(Errors results)	{
		if(Assert.isEmpty(results))	{
			return null;
		}
		ErrorResponses errorResponses = new ErrorResponses();
		List<ObjectError> errors = results.getAllErrors();
		for(ObjectError error : errors)	{
			ErrorResponse errResponse = new ErrorResponse();

			errResponse.setErrorCode(error.getCode());
			if(results.getFieldError()!=null) {
				errResponse.setErrorField(results.getFieldError().getField());
			}
			errResponse.setErrorDescription(error.getDefaultMessage());
			errorResponses.addErrorRespone(errResponse);
		}

		return errorResponses;
	}
}
