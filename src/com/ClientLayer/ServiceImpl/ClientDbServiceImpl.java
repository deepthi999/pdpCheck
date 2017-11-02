package com.ClientLayer.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ClientLayer.Dao.ClientDbDao;
import com.ClientLayer.Service.ClientDbService;
@Component

@Service("ClientDbService")
public class ClientDbServiceImpl implements ClientDbService {
	
	@Autowired
	private ClientDbDao clientDbDao;
	
	

	@Override
	public List<HashMap> getTableList(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Hello....GetTablesdetails....");
		return clientDbDao.getTableList(guiMapMessage);
		 
	}



	@Override
	public List<HashMap> getColumnList(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Hello....GetColumndetails....");
		return clientDbDao.getColumnList(guiMapMessage);
	}



	@Override
	public List<HashMap> runExecutefinalQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
	  return clientDbDao.runExecutefinalQuery(guiMapMessage);
	}



	@Override
	public List<HashMap> executefinalQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 return clientDbDao.executefinalQuery(guiMapMessage);
	}



	@Override
	public List<HashMap> executeParamQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 return clientDbDao.executeParamQuery(guiMapMessage);
	}

}
