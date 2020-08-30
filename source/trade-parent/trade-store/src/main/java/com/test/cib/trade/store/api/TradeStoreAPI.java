/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */

package com.test.cib.trade.store.api;

import com.test.cib.commons.data.models.ErrorResponses;
import com.test.cib.commons.data.utils.ErrorResponseConverterUtil;
import com.test.cib.commons.validators.GenericValidator;
import com.test.cib.commons.validators.utils.ValidationExecutor;
import com.test.cib.commons.validators.utils.ValidatorsUtil;
import com.test.cib.trade.store.constants.TradeStoreConstants;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.commons.data.mapper.IMapper;
import com.test.cib.trade.store.data.models.TradeStoreModel;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping(path = TradeStoreConstants.TRADE_STORE_URI)
public class TradeStoreAPI {


	Logger logger = LoggerFactory.getLogger(TradeStoreAPI.class);
	@Autowired
	TradeStoreRepository repository;

	@Autowired
	private ValidatorsUtil validatorsUtil;

	@Autowired
	private ValidationExecutor validationExecutor;

	@Autowired
	@Qualifier("tradeStoreMapper")
	private IMapper<TradeStoreModel, TradeStoreEntity> tradeStoreMapper;



	/**
	 * Creates the new trade order in the system. Validates for
	 * correctness before saving the trade.
	 *
	 * @param store
	 * @return
	 */
	@PostMapping(path = "", consumes = {"application/json"}, produces = "application/json")
	public ResponseEntity<?> createTrade(@RequestBody TradeStoreModel store, BindingResult results){

		logger.info("-----------Trade received for processing ---------");
		HttpHeaders headers = null;
		GenericValidator genericValidator = getGenericValidator("tradeStoreAdd");
		genericValidator.validate(store,results);
		logger.info("Binding results ::" + results.hasErrors());
		if(results.hasErrors())	{
			ErrorResponses errorResponses = ErrorResponseConverterUtil.comverErrorResponses(results);
			logger.info("-------------Returning Bad Request----------------");
			return new ResponseEntity<ErrorResponses>(errorResponses,HttpStatus.BAD_REQUEST);
		}
		try {
			TradeStoreEntity entity = tradeStoreMapper.getEntityFromModel(store);


			entity = repository.save(entity);
			logger.info("-----------Trade is successfully saved  ---------");

			// The successful saving is sent with response of
			// id
			headers = new HttpHeaders();
			URI location = URI.create(TradeStoreConstants.TRADE_STORE_URI + "/" + entity.getId());
			headers.setLocation(location);
		} catch (Exception exp) {
			// hardcoded message for this exercise. Ideally replace it
			// with configured log messages
			logger.error("Error in Saving the trade store execution");
			logger.debug("Error in Saving the trade store execution", exp);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TradeStoreModel>(headers, HttpStatus.OK);
	}

	private GenericValidator getGenericValidator(String ruleId)	{
		logger.info("Validators Util ::" + validatorsUtil);
		return new GenericValidator(validatorsUtil,validationExecutor,ruleId);
	}


}
