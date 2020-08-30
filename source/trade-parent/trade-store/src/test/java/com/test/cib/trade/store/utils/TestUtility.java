package com.test.cib.trade.store.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class TestUtility <T>{


	final static ObjectMapper mapper = new ObjectMapper();
		public String getJson(String jsonName)  throws Throwable {
			String content="";
			try {
				File file = ResourceUtils.getFile("classpath:test/"+ jsonName +".json");
				//Read File Content

				content = new String(Files.readAllBytes(file.toPath()));

			} catch (IOException e) {

				throw new Exception("Error in reading test json file",e);
			}
			System.out.println(content);
			return content;
		}

		public T getModel(String json, Class<T> object) throws Throwable	{
			T returnObj = null;
			try {
				returnObj = mapper.readValue(json, object);
			} catch (JsonMappingException e) {
				throw e;
			} catch (JsonProcessingException e) {
				throw e;
			}
			return returnObj;
		}

	/**
	 * Returns the response as Map for given json string.
	 *
	 * @param json
	 * @return
	 * @throws JsonProcessingException
	 */
		public Map<String,Object> getMapOfJson(String json) throws JsonProcessingException {
			Map<String,Object> responseMap = null;
			try {
				// not handled for complex json structure.
				// works well for flat json.
				responseMap= mapper.readValue(json,Map.class);
			} catch (JsonProcessingException e) {
				throw e;
			}
			return responseMap;
		}
}

