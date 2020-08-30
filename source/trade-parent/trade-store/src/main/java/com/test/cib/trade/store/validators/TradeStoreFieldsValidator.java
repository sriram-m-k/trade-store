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

import java.util.List;

@Configuration("tradeStoreFieldsValidator")
public class TradeStoreFieldsValidator implements ValidatorInterface {

	private static final String VALIDATION_ERROR_CODE ="400";
	Logger logger = LoggerFactory.getLogger(TradeStoreFieldsValidator.class);

	@Override
	public boolean validate(ModelInterface model, Errors errors) {
		logger.info ("----------------Validating Fields-------");
		if( !(model instanceof TradeStoreModel))	{
			throw new IllegalArgumentException("Not a valid input");
		}
		boolean isValid = true;
		TradeStoreModel tradeStoreModel =(TradeStoreModel) model;
		if(Assert.isEmpty(tradeStoreModel.getTradeId()))	{
			logger.info ("----------------Trade Id is Empty-------");
			isValid =false;
			errors.rejectValue("tradeId",VALIDATION_ERROR_CODE,"Invalid trade Id");
		}
		if(Assert.isEmpty(tradeStoreModel.getBookId()))	{
			logger.info ("----------------Book Id is Empty-------");
			isValid = false;
			errors.rejectValue("bookId",VALIDATION_ERROR_CODE,"Invalid BookId");
		}
		if(tradeStoreModel.getVersion()<=0)	{
			logger.info ("----------------Verison is Zero Or Less-------");
			isValid = false;
			errors.rejectValue("version",VALIDATION_ERROR_CODE,"Invalid Version");
		}
		if(Assert.isEmpty(tradeStoreModel.getCounterPartyId()))	{
			isValid = false;
			logger.info ("----------------Counter Party id is Empty-------");
			errors.rejectValue("counterPartyId",VALIDATION_ERROR_CODE,"Invalid Counter Party");
		}
		if(tradeStoreModel.getMaturityDate()== null)	{
			logger.info ("----------------Maturity date is not provided-------");
			isValid = false;
			errors.rejectValue("maturityDate",VALIDATION_ERROR_CODE,"Invalid Maturity Date");
		}

		logger.info ("----------------Validating Fields Completed-------");
		return isValid;
	}
}
