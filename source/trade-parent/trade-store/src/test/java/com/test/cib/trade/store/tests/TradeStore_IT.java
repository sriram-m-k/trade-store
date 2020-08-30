package com.test.cib.trade.store.tests;

import com.test.cib.commons.data.models.ErrorResponses;
import com.test.cib.trade.store.app.TradeStoreApplication;
import com.test.cib.trade.store.constants.TradeStoreConstants;
import com.test.cib.trade.store.data.entity.TradeStoreEntity;
import com.test.cib.commons.data.mapper.IMapper;
import com.test.cib.trade.store.data.models.TradeStoreModel;
import com.test.cib.trade.store.repository.TradeStoreRepository;
import com.test.cib.trade.store.utils.TestUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeStoreApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TradeStore_IT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	TradeStoreRepository tradeStoreRepository;

	@Autowired
	@Qualifier("tradeStoreMapper")
	private IMapper<TradeStoreModel,TradeStoreEntity> tradeStoreMapper;

	@Test
	public void testFirstNewTrade() throws Throwable {
		String testCaseId = "TradeStore-00001";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isOk())
					.andReturn();

			String responseHeader = result.getResponse().getHeader("Location");
			assertEquals(responseHeader, TradeStoreConstants.TRADE_STORE_URI +"/"+ "1");

		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}



	}
	@Test
	public void testTradeIdCannotBeNullOrEmpty() throws Throwable {
		String testCaseId = "TradeStore-00002";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andReturn();

			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
			String response = result.getResponse().getContentAsString();

			TestUtility<ErrorResponses> utility1 = new TestUtility<>();
			ErrorResponses errorResponses= utility1.getModel(response,ErrorResponses.class);
			assertEquals(errorResponses.getErrorResponses().size(),1);
		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}
	}

	@Test
	public void testBookIdCannotBeNullOrEmpty() throws Throwable {
		String testCaseId = "TradeStore-00003";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andReturn();

			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}
	}

	@Test
	@Sql("classpath:data.sql")
	public void testTradeVersionIsLower() throws Throwable {
		String testCaseId = "TradeStore-00004";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andReturn();

			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}
	}

	@Test
	public void testTradeMaturityDateLessThanCurrentDate() throws Throwable {
		String testCaseId = "TradeStore-00005";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andReturn();

			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}
	}

	@Test
	public void testAllFieldsNullOrEmpty() throws Throwable {
		String testCaseId = "TradeStore-00006";
		TestUtility<TradeStoreModel> utility = new TestUtility<TradeStoreModel>();
		String modelStr  = utility.getJson(testCaseId);

		try {
			MvcResult result =	mockMvc.perform(post("/trade/store")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.content(modelStr))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andReturn();

			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
			String response = result.getResponse().getContentAsString();

			TestUtility<ErrorResponses> utility1 = new TestUtility<>();
			ErrorResponses errorResponses= utility1.getModel(response,ErrorResponses.class);
			assertEquals(errorResponses.getErrorResponses().size(),5);
		} catch (Exception e) {
			throw new Throwable("Error in executing test case :"+ testCaseId,e);
		}
	}


}