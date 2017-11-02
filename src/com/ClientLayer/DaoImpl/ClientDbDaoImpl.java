package com.ClientLayer.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.ClientLayer.Dao.ClientDbDao;
import com.mysql.jdbc.Statement;
@Component
public class ClientDbDaoImpl implements ClientDbDao {
	
	@Autowired
    @Qualifier("jdbcTemplate")	
   private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<HashMap> getTableList(Map guiMapMessage) {
		 String sql = "SELECT TABLE_NAME from information_schema.tables WHERE table_schema = " + " '"+guiMapMessage.get("dbName") + "'";
		 System.out.println(sql);
		  List results = template.queryForList(sql);
		  return results;
		
	}

	@Override
	public List<HashMap> getColumnList(Map guiMapMessage) {
		 System.out.println(guiMapMessage);
		// TODO Auto-generated method stub
		// return template.query("select table_name,concat(table_name,'.',COLUMN_NAME) AS COLUMN_NAMES from information_schema.columns where table_name ='aph'",new ResultSetExtractor<List<HashMap>>(){
		 ArrayList<String> tableList = (ArrayList<String>) guiMapMessage.get("tableList");
			StringBuilder sql = new StringBuilder();
			
			sql.append("select table_name,concat(table_name,'.',COLUMN_NAME) AS COLUMN_NAMES from information_schema.columns where table_name  IN  (");

			for(String tablename: tableList) {
			      sql.append("?,");
			    }
			sql.append(")");

			Object[] params = tableList.toArray();
			//use this to remove the extra comma at the end of your IN() clause
			String query = sql.toString().replace(",)", ")");
			//List results = template.queryForList(query);
			List results = template.queryForList(query, params);
			return results;
		}

	@Override
	public List<HashMap> runExecutefinalQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 String query =  (String) guiMapMessage.get("query");
		 System.out.println(query);
         List result = template.queryForList(query);
	     return result;
	}

	@Override
	public List<HashMap> executefinalQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 String query = (String) guiMapMessage.get("query");
		 System.out.println(query);
         List sql = template.queryForList(query);
	     return sql;
	}

	@Override
	public List<HashMap> executeParamQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("IIII:::"+guiMapMessage);
		 String query = (String) guiMapMessage.get("query"); 
		 System.out.println(query);
         List result = template.queryForList(query);
	     return result;
	}

}
