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
