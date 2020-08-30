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
package com.test.cib.commons.tests.validators;

import com.test.cib.commons.data.ModelInterface;
import com.test.cib.commons.tests.models.TestModel;
import com.test.cib.commons.validators.ValidatorInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Configuration("testModelIdValidator")
public class TestModelIdValidator implements ValidatorInterface {

	public boolean validate(ModelInterface model, Errors errors) 	{

		if(model ==null ||  !(model instanceof TestModel))	{
			throw new IllegalArgumentException("Invalid Object for validation");
		}
		TestModel modelImpl = (TestModel) model;
		if(StringUtils.isEmpty(modelImpl.getTestId()))	{
			return false;
		}
		return true;
	}
}