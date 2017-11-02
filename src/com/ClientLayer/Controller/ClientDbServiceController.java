package com.ClientLayer.Controller;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;

	import javax.servlet.http.HttpSession;

	import javax.validation.Valid;

	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

import com.ClientLayer.Dao.ClientDbDao;
import com.ClientLayer.Service.ClientDbService;

	@Controller
	@RequestMapping(value = { "/ClientService" })
	public class ClientDbServiceController {

		private static final String String = null;
	
		
		@Autowired
		ClientDbService clientDbService;
		
		

		public static Map<String, Object> jsonToMap(String jsonStr) throws JSONException {
			Map<String, Object> retMap = new HashMap<String, Object>();
			JSONObject jsonObject = new JSONObject(jsonStr);

			if (null != jsonObject) {
				retMap = toMap(jsonObject);
			}
			return retMap;
		}

		/**
		 * General method to convert JSON object to Map.
		 * 
		 * @param object
		 *            JSON object input from WebUI
		 * @return java.util.Map
		 * @throws org.json.JSONException
		 *             occurs when there is issue with JSON operations
		 */
		public static Map<String, Object> toMap(JSONObject object) throws JSONException {
			Map<String, Object> map = new HashMap<String, Object>();

			Iterator<String> keysItr = object.keys();
			while (keysItr.hasNext()) {
				String key = keysItr.next();
				Object value = object.get(key);
				if (value instanceof JSONArray) {
					value = toList((JSONArray) value);
				} else if (value instanceof JSONObject) {
					value = toMap((JSONObject) value);
				}
				map.put(key, value);
			}
			return map;
		}

		/**
		 * General method to convert JSONArray to Map.
		 * 
		 * @param array
		 *            JSON input data from WebUI
		 * @return java.util.Map
		 * @throws org.json.JSONException
		 *             occurs when there is issue with JSON operations
		 */
		public static List<Object> toList(JSONArray array) throws JSONException {
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < array.length(); i++) {
				Object value = array.get(i);
				if (value instanceof JSONArray) {
					value = toList((JSONArray) value);
				} else if (value instanceof JSONObject) {
					value = toMap((JSONObject) value);
				}
				list.add(value);
			}
			return list;
		}

		@SuppressWarnings("unchecked")
		@RequestMapping(value = { "/getTables" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map getTables(@Valid @RequestBody String requestBody, HttpSession session) {
			Map returnMapMessage = new HashMap();
			try {

				Map guiMapMessage = jsonToMap(requestBody);
				System.out.println(guiMapMessage);
				@SuppressWarnings("rawtypes")
				List<HashMap> obj=clientDbService.getTableList(guiMapMessage);
				  System.out.println(obj);
				  if(!obj.isEmpty()){
					  returnMapMessage.put("returnCode:", "0");
					  returnMapMessage.put("returnMessage:", "success message");
					  returnMapMessage.put("returnData", obj);	
				  }
				  else{
					  returnMapMessage.put("returnCode:", "1");
					  returnMapMessage.put("returnMessage", "failure message");
				  }				
								
			}
			
			catch (Exception e) {
				e.printStackTrace();
				returnMapMessage.put("result", "error");
				returnMapMessage.put("errortext",
						"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
			}

			return returnMapMessage;
		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = { "/getColumns" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map getColumns(@Valid @RequestBody String requestBody, HttpSession session) {
			Map returnMapMessage = new HashMap();
			try {

				Map guiMapMessage = jsonToMap(requestBody);
				System.out.println(guiMapMessage);
				@SuppressWarnings("rawtypes")
				List<HashMap> obj=clientDbService.getColumnList(guiMapMessage);
				  System.out.println(obj);
				  if(!obj.isEmpty()){
					  returnMapMessage.put("returnCode:", "0");
					  returnMapMessage.put("returnMessage:", "success message");
					  returnMapMessage.put("returnData", obj);	
				  }
				  else{
					  returnMapMessage.put("returnCode:", "1");
					  returnMapMessage.put("returnMessage", "failure message");
				  }				
								
			
			}
			
			catch (Exception e) {
				e.printStackTrace();
				returnMapMessage.put("result", "error");
				returnMapMessage.put("errortext",
						"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
			}

			return returnMapMessage;
		}
		
		
		@RequestMapping(value = { "/runExecutefinalQuery" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map runExecutefinaQuery(@Valid @RequestBody String requestBody, HttpSession session) {
			Map returnMapMessage = new HashMap();
			try {

				Map guiMapMessage = jsonToMap(requestBody);
				System.out.println(guiMapMessage);
				@SuppressWarnings("rawtypes")
				List<HashMap> obj=clientDbService.runExecutefinalQuery(guiMapMessage);
				  System.out.println(obj);
				  if(!obj.isEmpty()){
					  returnMapMessage.put("returnCode:", "0");
					  returnMapMessage.put("returnMessage:", "success message");
					  returnMapMessage.put("returnData", obj);	
				  }
				  else{
					  returnMapMessage.put("returnCode:", "1");
					  returnMapMessage.put("returnMessage", "failure message");
				  }				
								
			
			}
			
			catch (Exception e) {
				e.printStackTrace();
				returnMapMessage.put("result", "error");
				returnMapMessage.put("errortext",
						"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
			}

			return returnMapMessage;
		}
		
		
		@RequestMapping(value = { "/executeFinalQuery" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map ExecutefinalQuery(@Valid @RequestBody String requestBody, HttpSession session) {
			Map returnMapMessage = new HashMap();
			try {

				Map guiMapMessage = jsonToMap(requestBody);
				System.out.println(guiMapMessage);
				@SuppressWarnings("rawtypes")
				List<HashMap> obj=clientDbService.executefinalQuery(guiMapMessage);
				  System.out.println(obj);
				  if(!obj.isEmpty()){
					  returnMapMessage.put("returnCode:", "0");
					  returnMapMessage.put("returnMessage:", "success message");
					  returnMapMessage.put("returnData", obj);	
				  }
				  else{
					  returnMapMessage.put("returnCode:", "1");
					  returnMapMessage.put("returnMessage", "failure message");
				  }				
								
			
			}
			
			catch (Exception e) {
				e.printStackTrace();
				returnMapMessage.put("result", "error");
				returnMapMessage.put("errortext",
						"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
			}

			return returnMapMessage;
		}
	
		
		
		
		@RequestMapping(value = { "/executeParamQuery" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map executeParamQuery(@Valid @RequestBody String requestBody, HttpSession session) {
			Map returnMapMessage = new HashMap();
			try {

				Map guiMapMessage = jsonToMap(requestBody);
				System.out.println(guiMapMessage);
				@SuppressWarnings("rawtypes")
				List<HashMap> obj=clientDbService.executeParamQuery(guiMapMessage);
				  System.out.println(obj);
				  if(!obj.isEmpty()){
					  returnMapMessage.put("returnCode:", "0");
					  returnMapMessage.put("returnMessage:", "success message");
					  returnMapMessage.put("returnData", obj);	
				  }
				  else{
					  returnMapMessage.put("returnCode:", "1");
					  returnMapMessage.put("returnMessage", "failure message");
				  }				
								
			
			}
			
			catch (Exception e) {
				e.printStackTrace();
				returnMapMessage.put("result", "error");
				returnMapMessage.put("errortext",
						"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
			}

			return returnMapMessage;
		}
		
		
		
		
		
		
		
		
	}
	
	


