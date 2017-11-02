package com.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;


import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.OrganizationService;

@Controller
@RequestMapping(value = { "/OrganizationService" })

public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	/**
	* General method to convert JSON format string to Map.
	* 
	* @param jsonStr
	*           JSON input data from WebUI
	* @return java.util.Map
	* @throws org.json.JSONException
	*            occurs when there is an issue with JSON operations
	*/
	public static Map<String, Object> jsonToMap(String jsonStr) throws JSONException
	{
	Map<String, Object> retMap = new HashMap<String, Object>();
	JSONObject jsonObject = new JSONObject(jsonStr);

	if (null != jsonObject)
	{
	 retMap = toMap(jsonObject);
	}
	return retMap;
	}

	/**
	* General method to convert JSON object to Map.
	* 
	* @param object
	*           JSON object input from WebUI
	* @return java.util.Map
	* @throws org.json.JSONException
	*            occurs when there is issue with JSON operations
	*/
	public static Map<String, Object> toMap(JSONObject object) throws JSONException
	{
	Map<String, Object> map = new HashMap<String, Object>();

	Iterator<String> keysItr = object.keys();
	while (keysItr.hasNext())
	{
	 String key = keysItr.next();
	 Object value = object.get(key);
	 if (value instanceof JSONArray)
	 {
	    value = toList((JSONArray) value);
	 }
	 else if (value instanceof JSONObject)
	 {
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
	*           JSON input data from WebUI
	* @return java.util.Map
	* @throws org.json.JSONException
	*            occurs when there is issue with JSON operations
	*/
	public static List<Object> toList(JSONArray array) throws JSONException
	{
	List<Object> list = new ArrayList<Object>();
	for (int i = 0; i < array.length(); i++)
	{
	 Object value = array.get(i);
	 if (value instanceof JSONArray)
	 {
	    value = toList((JSONArray) value);
	 }
	 else if (value instanceof JSONObject)
	 {
	    value = toMap((JSONObject) value);
	 }
	 list.add(value);
	}
	return list;
	}
	
	@RequestMapping(value = { "/show_organization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_organizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.show_organization(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
		
	@RequestMapping(value = { "/show_Reports" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_ReportsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  List<HashMap> emplist =  organizationService.show_Reports(guiMapMessage);			
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	
	@RequestMapping(value = { "/show_selectOrganization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_selectOrganizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);					
			  List<HashMap> emplist =  organizationService.show_selectOrganization(guiMapMessage);						 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/Show_no_of_reports" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Show_no_of_reportsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  List<HashMap> emplist =  organizationService.Show_no_of_reports(guiMapMessage);						 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	@RequestMapping(value = { "/Show_no_of_Organization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Show_no_of_OrganizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);			 
			  List<HashMap> emplist =  organizationService.Show_no_of_Organization(guiMapMessage);					 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  			 			  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	@RequestMapping(value = { "/Show_no_of_users" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Show_no_of_usersEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  List<HashMap> emplist =  organizationService.Show_no_of_users(guiMapMessage);				 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  						  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
                "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}	
	@RequestMapping(value = { "/Show_no_of_Categories" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Show_no_of_CategoriesEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.Show_no_of_Categories(guiMapMessage);						 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  						  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}	
	@RequestMapping(value = { "/AssignOrgReport" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map AssignOrgReportEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);						
			 List<HashMap> emplist =  organizationService.AssignOrgReport(guiMapMessage);						 			 
				  returnMapMessage.put("returncode", "0");
				  returnMapMessage.put("returnMessage", "Success message");
				  returnMapMessage.put("returnData", emplist);											 						 			  						  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("returncode", "-1");
			   returnMapMessage.put(
	               "returnMessage",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	@RequestMapping(value = { "/Create_New_Organization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Create_New_OrganizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);						
			  List<HashMap> emplist =  organizationService.Create_New_Organization(guiMapMessage);						 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	@RequestMapping(value = { "/Delete_Tables" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Delete_TablesEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			 System.out.println("In hereeeee::::"+guiMapMessage);
			  List<HashMap> emplist =  organizationService.Delete_Tables(guiMapMessage);					 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }						  						  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}	
	@RequestMapping(value = { "/Delete_Columns" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Delete_ColumnsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);			  			
			  List<HashMap> emplist =  organizationService.Delete_Columns(guiMapMessage);			 			 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 			  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/Organization_to_Reports" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Organization_to_ReportsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.Organization_to_Reports(guiMapMessage);						 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 
	   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/Selected_organization_reports" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map Selected_organization_reportsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  List<HashMap> emplist =  organizationService.Selected_organization_reports(guiMapMessage);
			
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 		  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	               + e.getMessage());
		   }
	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/GetOrgReportTables" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportTablesEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{			  
			  Map guiMapMessage = jsonToMap(requestBody);
			 // System.out.println("emplist-from gui map msg" + guiMapMessage);
			  List<HashMap> emplist =organizationService.GetOrgReportTables(guiMapMessage);
			//  System.out.println("emplist-from emplist" + emplist);

			
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
				  //System.out.println("org report list" + emplist);
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 		  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	               + e.getMessage());
		   }
	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/show_noof_Organization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_noof_OrganizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.show_noof_Organization(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/UpdateOrgReportTables" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportTablesEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportTables(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/InsertOrganization" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map InsertOrganizationEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.InsertOrganization(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/RemoveOrgReportField" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map RemoveOrgReportFieldEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.RemoveOrgReportField(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	@RequestMapping(value = { "/UpdateOrgReportCriteria" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportCriteriaEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportCriteria(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
			   
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/UpdateOrgReportField" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportFieldEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportField(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	
	@RequestMapping(value = { "/UpdateOrgReportFields" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportFieldsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportFields(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	
	@RequestMapping(value = { "/UpdateOrgReportJoins" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportJoinsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportJoins(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	
	@RequestMapping(value = { "/UpdateOrgReportParameters" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateOrgReportParametersEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.UpdateOrgReportParameters(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/GetOrgReportParameters" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportParametersEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GetOrgReportParameters(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}

	
	@RequestMapping(value = { "/GetOrgReportCriteria" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportCriteriaEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GetOrgReportCriteria(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	@RequestMapping(value = { "/GetOrgReportFields" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportFieldsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GetOrgReportFields(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	
	@RequestMapping(value = { "/GetOrgReportCriteriaByReportId" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportCriteriaByReportIdEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GetOrgReportCriteriaByReportId(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/GetOrgReportJoins" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GetOrgReportJoinsEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GetOrgReportJoins(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/GenerateOrgReport" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map GenerateOrgReportEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.GenerateOrgReport(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/fnGetOrgReportCriteria" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map fnGetOrgReportCriteriaEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.fnGetOrgReportCriteria(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/fnGetOrgFromList" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map fnGetOrgFromListEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.fnGetOrgFromList(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	
	@RequestMapping(value = { "/RemoveOrgReportTables" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map RemoveOrgReportTablesEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.RemoveOrgReportTables(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
	@RequestMapping(value = { "/RemoveOrgReportCriteria" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map RemoveOrgReportCriteriaEntry(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);			
			  List<HashMap> emplist =  organizationService.RemoveOrgReportCriteria(guiMapMessage);				
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("authentication", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }			 			  					  
		   }catch(Exception e) { 
			   e.printStackTrace();
			   returnMapMessage.put("result", "error");
			   returnMapMessage.put(
	               "errortext",
	               "Internal Application Error. Contact Administrator. Error RefId : "
	                     + e.getMessage());
		   }

	   return returnMapMessage;
	}
}
