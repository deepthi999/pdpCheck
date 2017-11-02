package com.controllers;

import org.json.*;
import java.io.IOException;
import java.security.Principal;
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
import java.util.Date;


import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.service.ReportService;

@CrossOrigin(origins = {"http://localhost:8090"}, maxAge = 4800, allowCredentials = "false")
@Controller
@RequestMapping(value = { "/ReportsService" })

public class ReportsController extends JsonSerializer<Date>{

@Autowired
private ReportService employeeService;
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







@RequestMapping(value = { "/CreateReport" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map CreateReportEntry(@Valid @RequestBody String requestBody,HttpSession session)
{  
	Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.CreateReport(guiMapMessage); 
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("create report", "success");
			  returnMapMessage.put("returnData", emplist);	
			  
		  }
		  else{
			  returnMapMessage.put("create report", "failure");
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





















/*@RequestMapping(value = { "/InsertReportTables" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map InsertReportTablesEntry(@Valid @RequestBody String requestBody,HttpSession session)
{  
	       Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  System.out.println(guiMapMessage);
			  List searchMap =(List) guiMapMessage.get("tableList"); 
				 List<HashMap> emplist=  employeeService.InsertReportTables( searchMap);
			   //System.out.println(guiMapMessage);
			   System.out.println(emplist);
				  if(!emplist.isEmpty()){
					 // returnMapMessage.put("authentication", "success");
					  returnMapMessage.putAll( emplist);	
				  }
				  else{
					  returnMapMessage.put("authentication", "failure");
					//  returnMapMessage.put("errorText", "Invalid Credentials");
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
}*/


@RequestMapping(value = { "/InsertReportTables" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map userInsertReportTables(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage =  jsonToMap(requestBody);
		  System.out.println(guiMapMessage);
		  List<HashMap> tableList = (List<HashMap>) guiMapMessage.get("tableList"); 
		  List<HashMap> tableIdListMap = new ArrayList<HashMap>();
		
		 for(HashMap tableObj:tableList){  
			 HashMap tableIdObj =  employeeService.InsertReportTables(tableObj); 
			 System.out.println("Tablealias"+tableIdObj);
			 tableIdListMap.add(tableIdObj);
			} 
		 
		/* returnMapMessage.put("result", "success");
		 
		 returnMapMessage.put("returnData", tableIdListMap);
		  */
		
		 if(!tableIdListMap.isEmpty()){
			 returnMapMessage.put("InsertReportTables", "success");
			 
			 returnMapMessage.put("returnData", tableIdListMap);
			 System.out.println("Tablealias"+tableIdListMap);
			 
			  
		  }
		  else{
			  returnMapMessage.put("InsertReportTables", "failure");
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






@RequestMapping(value = { "/InsertReportColoumns" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map userInsertReportColoumns(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		   Map guiMapMessage =  jsonToMap(requestBody);
			  System.out.println(guiMapMessage);
			  List<HashMap> ColoumnLists = (List<HashMap>) guiMapMessage.get("ColoumnLists"); 
			  List<HashMap> tableIdListMap = new ArrayList<HashMap>();
			
			 for(HashMap ColoumnObj:ColoumnLists){  
				 HashMap tableIdObj =  employeeService.InsertReportColoumns(ColoumnObj); 
				 System.out.println("InsertReportColoumns" + tableIdObj);
				 
				 tableIdListMap.add(tableIdObj);
				} 
			 
			
			 returnMapMessage.put("result", "success");
			 
			 returnMapMessage.put("returnData", tableIdListMap);
			  
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



@RequestMapping(value = { "/InsertReportQuery" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map InsertReportQueryEntry(@Valid @RequestBody String requestBody,HttpSession session)
{  
	       Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			 // Map searchMap = (Map)guiMapMessage.get("search"); 
			  Map emplist = employeeService.InsertReportQuery(guiMapMessage);
			   //System.out.println(guiMapMessage);
			   System.out.println(emplist);
				  if(!emplist.isEmpty()){
					 // returnMapMessage.put("authentication", "success");
					  returnMapMessage.putAll( emplist);	
				  }
				  else{
					  returnMapMessage.put("authentication", "failure");
					//  returnMapMessage.put("errorText", "Invalid Credentials");
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



@RequestMapping(value = { "/InsertmultiplejoinsQuery" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map InsertmultiplejoinsQueryEntry(@Valid @RequestBody String requestBody,HttpSession session)
{  
	       Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			 // Map searchMap = (Map)guiMapMessage.get("search"); 
			  Map emplist = employeeService.InsertmultiplejoinsQuery(guiMapMessage);
			   //System.out.println(guiMapMessage);
			   System.out.println(emplist);
				  if(!emplist.isEmpty()){
					 // returnMapMessage.put("authentication", "success");
					  returnMapMessage.putAll( emplist);	
				  }
				  else{
					  returnMapMessage.put("authentication", "failure");
					//  returnMapMessage.put("errorText", "Invalid Credentials");
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





@RequestMapping(value = { "/show_Category" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_Category(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_Category(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("authentication", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("authentication", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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




@RequestMapping(value = { "/show_databases" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_databases(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_databases(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show_databases", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show_databases", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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


//show tables is for show tables based on given id

@RequestMapping(value = { "/getTables" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_tables(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_tableNamesbasedonid(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show tables on id", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show tables based on id", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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


@RequestMapping(value = { "/show_coloumns" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_coloumns(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage =  jsonToMap(requestBody);
		  List searchMap =(List) guiMapMessage.get("search"); 
		 List<HashMap> emplist=  employeeService.show_coloumns( searchMap);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show_coloumns", "success");
			 returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show_coloumns", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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




@RequestMapping(value = { "/show_fields" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_fields(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  List tableList = (List)guiMapMessage.get("search"); 
		 
		
		  for(Object tableName: tableList)
		  {
			  List<HashMap> emplist =  employeeService.show_fields((Map) tableName);
		  }
		 /* if(!emplist.isEmpty()){
			  returnMapMessage.put("authentication", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("authentication", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }*/
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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




@RequestMapping(value = { "/show_queryPreview" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_queryPreview(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_queryPreview(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show_queryPreview", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show_queryPreview", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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


@RequestMapping(value = { "/show_ReportsList" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_ReportsList(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_ReportsList(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show_ReportsList", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show_ReportsList", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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








@RequestMapping(value = { "/getColumns" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usershow_ColoumnNamesbasedonid(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.show_ColoumnNamesbasedonid(guiMapMessage);
		  
		  System.out.println("show_ColoumnNamesbasedonid"+ emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("show_ColoumnNamesbasedonid", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("show_ColoumnNamesbasedonid", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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

@RequestMapping(value = { "/finalQuery" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map userfinalQuery(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  List<HashMap> emplist =  employeeService.finalQuery(guiMapMessage);
		  System.out.println(emplist);
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("finalQuery", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("finalQuery", "failure");
			  returnMapMessage.put("errorText", "Invalid Credentials");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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

@RequestMapping(value = { "/ExecutefinaQuery" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map userExecutefinaQuery(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		  Map searchMap = (Map)guiMapMessage.get("search"); 
		  System.out.println("In hereeeee::::"+guiMapMessage);
		  List<HashMap> emplist =  employeeService.ExecutefinaQuery(guiMapMessage);
		 
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("ExecutefinaQuery", "success");
			  returnMapMessage.put("returnData", emplist);	
		  }
		  else{
			  returnMapMessage.put("returnData", "Validation Success");
			  returnMapMessage.put("errorText", "Zero Records");
		  }
		 
		  
		 //returnMapMessage.put("result", "success");
		  
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


@RequestMapping(value = { "/runExecutefinaQuery" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map userrunExecutefinaQuery(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage = jsonToMap(requestBody);
		 // Map searchMap = (Map)guiMapMessage.get("search"); 
		  //System.out.println("In hereeeee::::"+guiMapMessage);
		 List<HashMap> emplist =  employeeService.runExecutefinaQuery(guiMapMessage);
		 // System.out.println("output::::::::::::"+emplist);           
          String str = "[";
		 List l = new ArrayList();
		 
		 for(int i=0; i<emplist.size(); i++) {
			 Iterator it = emplist.get(i).entrySet().iterator();
			    while (it.hasNext()){			    	
			    	 Map.Entry pair = (Map.Entry)it.next();
				       //System.out.println(pair.getKey() + " = " + pair.getValue());
				        //it.remove(); // avoids a ConcurrentModificationException
				        //str = "{'"+pair.getKey()+"': "+ pair.getValue() + "}";
				       // System.out.println("val"+str);	
				       if( pair.getValue()==null){
				    	   pair.setValue("");				    	   
				    	   
				       }
			    }
			    if(!emplist.get(i).isEmpty()) {
					 JSONObject jobj = new JSONObject(emplist.get(i));
					// System.out.println("JSON"+jobj.toString());
					 Map<String,Object> result = toMap(jobj);
					 if(jobj.length()!=0) {
						 l.add(result);	
					 
				 }		 
			 }
		 }
		// System.out.println("updated::::::::::::"+emplist); 
		 
/*		 for(int i=0; i<emplist.size(); i++) {
			 if(i>0) str += ", ";

			
			 if(!emplist.get(i).isEmpty()) {
				 JSONObject jobj = new JSONObject(emplist.get(i));
				 System.out.println("JSON"+jobj.toString());
				 Map<String,Object> result = toMap(jobj);
				 if(jobj.length()!=0) {
					 l.add(result);	
				 
			 }
			}  	
			  
		 }*/
		 
 	 
		 
		 str += "]";

		 
		 System.out.println("FINAL"+l.toString());	
		 		 
		 
		  if(!emplist.isEmpty()){
			  returnMapMessage.put("returnCode", "0");
			  returnMapMessage.put("returnData", l);	
			  returnMapMessage.put("returnMessage", "Report Data Found");	
		  }
		  else{
			  returnMapMessage.put("returnCode", "-1");
			  returnMapMessage.put("returnMessage", "Report No Data Found");	
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




@RequestMapping(value = { "/multiplejoinsinsert" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map usermultiplejoinsinsert(@Valid @RequestBody String requestBody,HttpSession session)
{  
    Map returnMapMessage = new HashMap();
	   try{
		  
		  Map guiMapMessage =  jsonToMap(requestBody);
		  List<HashMap> data = (List<HashMap>) guiMapMessage.get("tableList"); 
		  List<HashMap> tableIdListMap = new ArrayList<HashMap>();
		  for(HashMap tableObj:data){ 
			  
			 System.out.println("Each Object:::"+tableObj); 
			 HashMap chkTableIdObj =  employeeService.checkTableId(tableObj);
			 System.out.println("After CHEKING JOINS TABLE:::"+chkTableIdObj);
			 
			 if(chkTableIdObj!=null && !chkTableIdObj.isEmpty()){			 
				 
				 HashMap getTableIdObj =  employeeService.getTableIdObj(tableObj);
				 
				 System.out.println("After GETTING REPORTS TABLE:::"+getTableIdObj);
				 
				 String str1 = getTableIdObj.get((Object) new String("table_alias")).toString();
				 
				 if(getTableIdObj!=null && !getTableIdObj.isEmpty()){
					 
					 Random numGen =new Random();
					 int rNum = Math.abs((100)+numGen.nextInt(100));
					 
					    // Getting a Set of Key-value pairs
					    Set entrySet = getTableIdObj.entrySet();
					 
					    // Obtaining an iterator for the entry set
					    Iterator it = entrySet.iterator();
					 
					    // Iterate through HashMap entries(Key-Value pairs)

					    while(it.hasNext()){
					       Map.Entry me = (Map.Entry)it.next();					       
					       if(me.getKey().equals("table_alias")) {					    	   
					    	   String str = me.getValue() + Integer.toString(rNum);
					    	   me.setValue(str);	
					    	   break;
					       } 
					   }
					 
					   System.out.println("After NEW ALIAS:::"+getTableIdObj);
					   
					   HashMap insTableIdObj =  employeeService.insTableIdObj(getTableIdObj);
					   
					   getTableIdObj =  employeeService.getInsTableIdObj(getTableIdObj);
					   
					   System.out.println("After INSERTION NEW ALIAS:::"+getTableIdObj);
					 
					   
					// Getting a Set of Key-value pairs
					    entrySet = getTableIdObj.entrySet();
					 
					    // Obtaining an iterator for the entry set
					    it = entrySet.iterator();
					 
					    // Iterate through HashMap entries(Key-Value pairs)

					    while(it.hasNext()){
					       Map.Entry me = (Map.Entry)it.next();					       
					       if(me.getKey().equals("table_id")) {					    	   
					    	   //String str = me.getValue() + Integer.toString(rNum);
					    	   tableObj.put((Object) new String("table_1_id"),me.getValue());
					    	   tableObj.put((Object) new String("table_2_id"),me.getValue());
					    	   
					    	   
					    	   String str = tableObj.get((Object) new String("join_condition")).toString();
					    	   System.out.println("str:::"+str);
					    	   str.replace(str1, getTableIdObj.get((Object) new String("table_alias")).toString());
					    	   tableObj.put((Object) new String("join_condition"),str);
					    	   System.out.println("tableObj:::"+tableObj);
					    	   //me.setValue(str);	
					    	   break;
					       } 
					   }
					 
					    System.out.println("NEW TABLE ID FOR MUL JOINS:::"+tableObj);
				 }
				 
				 
				 
			  }

			 HashMap tableIdObj =  employeeService.multiplejoinsinsert(tableObj); 
			 System.out.println("INSIDE MULJOIN"+tableIdObj);
			 tableIdListMap.add(tableIdObj);
			 
		 }
		
		
		 if(!tableIdListMap.isEmpty()){
			 returnMapMessage.put("result", "success");
			 
			 returnMapMessage.put("returnData", tableIdListMap);
			  
		  }
		  else{
			  returnMapMessage.put("result", "failure");
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


//login
/*@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")

@RequestMapping(value = { "/login" }, method = RequestMethod.POST, consumes = "application/json")
public @ResponseBody Map loginEntry(@Valid @RequestBody String requestBody, HttpSession session) {
	Map returnMapMessage = new HashMap();
	try {

		 session.setAttribute("email", "srinivas.g@gmail.com"); 		
		
		Map guiMapMessage = jsonToMap(requestBody);
		System.out.print(guiMapMessage);
		Map searchMap = (Map) guiMapMessage.get("search");
		List<HashMap> studentlist = employeeService.getListOfEmployee(guiMapMessage);

		System.out.println("Hai " + studentlist);
		if (!studentlist.isEmpty()) {
			//session.setAttribute("email", "srinivas.g@gmail.com");
			returnMapMessage.put("authentication", "success");
			returnMapMessage.put("Studentdata", studentlist);
		} else {
			returnMapMessage.put("authentication", "failure");
			returnMapMessage.put("errorText", "Invalid Credentials");
		}
		if (!studentlist.isEmpty()) {
			//session.setAttribute("email", "srinivas.g@gmail.com");
			returnMapMessage.put("returncode == 0", "success");
			returnMapMessage.put("Studentdata", studentlist);
		} else {
			returnMapMessage.put("returncode == -1", "failure");
			returnMapMessage.put("errorText", "Invalid Credentials");
		}
		
		
		

	} catch (Exception e) {
		e.printStackTrace();
		returnMapMessage.put("returncode", "error");
		returnMapMessage.put("returncode",
				"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
	}

	return returnMapMessage;
}
*/
@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
public ModelAndView welcomePage() {

	ModelAndView model = new ModelAndView();
	model.addObject("title", "Spring Security Custom Login Form");
	model.addObject("message", "This is welcome page!");
	model.setViewName("hello");
	return model;

}

@RequestMapping(value = "/admin**", method = RequestMethod.GET)
public ModelAndView adminPage() {

	ModelAndView model = new ModelAndView();
	model.addObject("title", "Spring Security Custom Login Form");
	model.addObject("message", "This is protected page!");
	model.setViewName("admin");

	return model;

}

/*@RequestMapping(value = "/login", method = RequestMethod.GET)
public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	ModelAndView model = new ModelAndView();
	if (error != null) {
		model.addObject("error", "Invalid username and password!");
	}

	if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	}
	model.setViewName("login");

	return model;

}
*/




/*@RequestMapping(value="/index", method = RequestMethod.GET)
public String executeSecurity(ModelMap model, Principal principal ) {

	String name = principal.getName();
	model.addAttribute("author", name);
	model.addAttribute("message", "Welcome To Login Form Based Spring Security Example!!!");
	return "welcome";

}*/

/*@RequestMapping(value="/login", method = RequestMethod.GET)
public String login(ModelMap model) {

	return "login";

}*/
/*
@RequestMapping(value="/fail2login", method = RequestMethod.GET)
public String loginerror(ModelMap model) {

	model.addAttribute("error", "true");
	return "login";

}

@RequestMapping(value="/logout", method = RequestMethod.GET)
public String logout(ModelMap model) {

	return "login";

}

*/



//Logout
/*	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map logoutEntry(@Valid @RequestBody String requestBody, HttpSession session ) {
		

		Map returnMapMessage = new HashMap();
		try {

			Map guiMapMessage = jsonToMap(requestBody);
			System.out.println(guiMapMessage);
			 
			// employeeService.logout(guiMapMessage);
			 

		} catch (Exception e) {
			e.printStackTrace();
			returnMapMessage.put("result", "error");
			returnMapMessage.put("errortext",
					"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
		}

		return returnMapMessage;
	}
*/


	//Dashboard
	@RequestMapping(value = { "/Dashboard" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map DashboardEntry(@Valid @RequestBody String requestBody, HttpSession session) {
		Map returnMapMessage = new HashMap();
		try {

			 session.setAttribute("email", "srinivas.g@gmail.com"); 		
			
			Map guiMapMessage = jsonToMap(requestBody);
			
			System.out.print(guiMapMessage);
			Map searchMap = (Map) guiMapMessage.get("search");
			List<HashMap> studentlist = employeeService.dashboard(guiMapMessage);

			System.out.println("Hai " + studentlist);
			if (!studentlist.isEmpty()) {
				//session.setAttribute("email", "srinivas.g@gmail.com");
				returnMapMessage.put("authentication", "success");
				returnMapMessage.put("dashboarddata", studentlist);
			} else {
				returnMapMessage.put("authentication", "failure");
				returnMapMessage.put("errorText", "Invalid Credentials");
			}
			
			if (!studentlist.isEmpty()) {
				//session.setAttribute("email", "srinivas.g@gmail.com");
				returnMapMessage.put("returncode == 0", "success");
				returnMapMessage.put("Studentdata", studentlist);
			} else {
				returnMapMessage.put("returncode == -1", "failure");
				returnMapMessage.put("errorText", "Invalid Credentials");
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			returnMapMessage.put("returncode", "error");
			returnMapMessage.put("returncode",
					"Internal Application Error. Contact Administrator. Error RefId : " + e.getMessage());
		}

		return returnMapMessage;
	}
	
	
	@RequestMapping(value = { "/show_Reports" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_Reports(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  System.out.println("In hereeeee::::"+guiMapMessage);
			  List<HashMap> emplist =  employeeService.show_Reports(guiMapMessage);
			 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnData", "Validation Success");
				  returnMapMessage.put("errorText", "Zero Records");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	@RequestMapping(value = { "/show_Reportsdetails" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map show_Reportsdetails(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  System.out.println("In hereeeee::::"+guiMapMessage);
			  List<HashMap> emplist =  employeeService.show_Reportsdetails(guiMapMessage);
			 
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("authentication", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnData", "Validation Success");
				  returnMapMessage.put("errorText", "Zero Records");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	

	@RequestMapping(value = { "/deleteTables" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map deleteTables(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  System.out.println(guiMapMessage);
			  List<HashMap> dellist =  employeeService.deleteTablerow(guiMapMessage);
			  System.out.println(dellist);
			  if(dellist!=null){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnMessage", "success message");	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("returnMessage", "failure message");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	@RequestMapping(value = { "/deleteColumns" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map deleteColumns(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  System.out.println(guiMapMessage);
			  List<HashMap> dellist =  employeeService.deleteColumnrow(guiMapMessage);
			  System.out.println(dellist);
			  if(dellist!=null){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnMessage", "success message");	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("returnMessage", "failure message");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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

	
	
	
	@RequestMapping(value = { "/getjoins" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map getjoins(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.getjoins(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("getjoins_by_id", "success");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("getjoins", "failure");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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

	
	
	
	
	@RequestMapping(value = { "/deletejoins" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map deletejoins(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.deletejoins(guiMapMessage);
			  System.out.println(emplist);
			  if(emplist.isEmpty()){
				  returnMapMessage.put("delete joins by id", "success");
				  returnMapMessage.put("deletejoins", "0");
				 // returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("deletejoins", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = { "/getWherecondition" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map usergetWherecondition(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.getWherecondition(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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

	
	@RequestMapping(value = { "/fetchwherecondition" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map userfetchwherecondition(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.fetchwherecondition(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	@RequestMapping(value = { "/insertparameter" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map insertparameter(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  System.out.println(guiMapMessage);
			  List<HashMap> emplist =  employeeService.insertparameter(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	@RequestMapping(value = { "/getparameter" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map getparameter(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.getparameter(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnMessage", "Success Message");	
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "-1");
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
	
	
	
	
	@RequestMapping(value = { "/UpdateReportJoins" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map UpdateReportJoins(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.UpdateReportJoins(guiMapMessage);
			  System.out.println(emplist);
			  if(emplist.isEmpty()){
				  returnMapMessage.put("returnCode:", "0");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	@RequestMapping(value = { "/getalreadyinsertedjoinsbyid" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map getalreadyinsertedjoinsbyid(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.getalreadyinsertedjoinsbyid(guiMapMessage);
			  System.out.println(emplist);
			  if(!emplist.isEmpty()){
				  returnMapMessage.put("returnCode","0");
				  returnMapMessage.put("returnData", emplist);	
			  }
			  else{
				  returnMapMessage.put("returnCode", "1");
				  returnMapMessage.put("errorText", "Invalid Credentials");
			  }
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	@RequestMapping(value = { "/deleteparams" }, method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map deleteparams(@Valid @RequestBody String requestBody,HttpSession session)
	{  
	    Map returnMapMessage = new HashMap();
		   try{
			  
			  Map guiMapMessage = jsonToMap(requestBody);
			  Map searchMap = (Map)guiMapMessage.get("search"); 
			  List<HashMap> emplist =  employeeService.deleteparams(guiMapMessage);
			  System.out.println(emplist);
			
				  returnMapMessage.put("returnCode","0");
				  returnMapMessage.put("returnMessage","Success Message");
				 	
			  
			  
			 
			  
			 //returnMapMessage.put("result", "success");
			  
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
	
	
	
	@RequestMapping(value = { "/show_users" }, method = RequestMethod.POST, consumes = "application/json")
	 public @ResponseBody Map show_users(@Valid @RequestBody String requestBody,HttpSession session)
	 {  
	     Map returnMapMessage = new HashMap();
	     try{
	     
	     Map guiMapMessage = jsonToMap(requestBody);
	     System.out.println(guiMapMessage);
	     List<HashMap> emplist =  employeeService.show_users(guiMapMessage);
	    System.out.println("cntrl"+emplist);
	     if(!emplist.isEmpty()){
	      returnMapMessage.put("returncode", "0");
	      returnMapMessage.put("returnmessage", "Success message");
	      returnMapMessage.put("returnData", emplist); 
	      
	      //System.out.println(emplist);
	     }
	     else{
	      returnMapMessage.put("returncode", "-1");
	      returnMapMessage.put("returnmessage", "failure message");
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

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	//for insert where condition and params
	
		@RequestMapping(value = { "/insertCriteriaAndParams" }, method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody Map insertCriteriaAndParams(@Valid @RequestBody String requestBody,HttpSession session)
		{  
		    Map returnMapMessage = new HashMap();
			   try{
				  
				  Map guiMapMessage = jsonToMap(requestBody);
				  List<HashMap> paramlist =  employeeService.insertCriteriaAndParams(guiMapMessage);
				  System.out.println(paramlist);
				  if(!paramlist.isEmpty()){
					  returnMapMessage.put("returnCode","0");
					  returnMapMessage.put("returnMessage","Success Message");
					  returnMapMessage.put("returnData", paramlist);	
				  }
				  else{
					  returnMapMessage.put("returnCode", "-1");
					  returnMapMessage.put("returnMessage", "Failure Message");
				  }
				 
			   }
			   catch(Exception e) { 
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

	  

	
	
	






