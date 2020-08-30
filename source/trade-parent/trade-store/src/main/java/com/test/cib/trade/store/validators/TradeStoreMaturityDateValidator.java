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
package com.test.cib.trade.store.validators;

import com.test.cib.commons.data.ModelInterface;
import com.test.cib.commons.data.mapper.IMapper;
import com.test.cib.commons.validators.ValidatorInterface;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.trade.store.data.models.TradeStoreModel;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import org.apache.logging.log4j.core.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;

import java.util.Date;
import java.util.List;

/**
 *  Validates the Maturity date
 */
@Configuration("tradeStoreMaturityDateValidator")
public class TradeStoreMaturityDateValidator implements ValidatorInterface {

	Logger logger = LoggerFactory.getLogger(TradeStoreMaturityDateValidator.class);

	@Override
	public boolean validate(ModelInterface model, Errors errors) {
		logger.info ("----------------Validating Version-------");
		if( !(model instanceof TradeStoreModel))	{
			throw new IllegalArgumentException("Not a valid input");
		}
		TradeStoreModel tradeStoreModel =(TradeStoreModel) model;
		// getting from locatTime
		Date currentDBTime = new Date();
		logger.info("DB TIME :"+ currentDBTime);
		if(!Assert.isEmpty(currentDBTime) &&
				!Assert.isEmpty(tradeStoreModel.getMaturityDate()) &&
			currentDBTime.after(tradeStoreModel.getMaturityDate()))	{
				errors.rejectValue("MaturityDate", "Maturity date is less than Current Date");
				return false;
		}

		logger.info ("----------------Validating Version successful-------");
		return true;
	}
}
