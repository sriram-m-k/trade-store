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

