package com.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mybatis.mappers.ReportMapper;
import com.service.ReportService;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {


	@Autowired
	private ReportMapper employeeMapper;
	@Autowired
    @Qualifier("empSessionFactory")
    private SqlSessionFactoryBean empSessionFactory;

	

	
	

	@Override
	public List<HashMap> show_databases(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing databases...");
		return employeeMapper.show_databases(guiMapMessage);
	}

	@Override
	public List<HashMap> show_tables(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing tabless...");
		return employeeMapper.show_tables(guiMapMessage);
	}

	@Override
	public List<HashMap> show_coloumns(List guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing coloumns...");
		return employeeMapper.show_coloumns(guiMapMessage);
	}

	@Override
	public List<HashMap> show_fields(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing coloumns...");
		return employeeMapper.show_fields(guiMapMessage);
	}

	@Override
	public List<HashMap> show_queryPreview(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing queryPreview...");
		return employeeMapper.show_queryPreview(guiMapMessage);
	}

/*	@Override
	public void useraddReport(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Details are added successfully....");
		employeeMapper.useraddReport(guiMapMessage);
	}*/

	@Override
	public List<HashMap> show_ReportsList(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing ReportsList...");
		return employeeMapper.show_ReportsList(guiMapMessage);
	}

	/*@Override
	public Map CreateReport(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Details are added successfully....");
		return employeeMapper.CreateReport(guiMapMessage);
	}*/

	@Override
	public List<HashMap> CreateReport(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing ids...");
		return employeeMapper.CreateReport(guiMapMessage);
	}
	

	

	@Override
	public HashMap InsertReportTables(HashMap tableObj) {
		// TODO Auto-generated method stub
		return employeeMapper.InsertReportTables(tableObj);
	}

	@Override
	public HashMap InsertReportColoumns(HashMap ColoumnObj) {
		// TODO Auto-generated method stub
		System.out.println("Showing InsertReportColoumns...");
		return employeeMapper.InsertReportColoumns(ColoumnObj);
	}

	@Override
	public Map InsertReportQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("InsertReportQuery are added successfully....");
		return employeeMapper.InsertReportQuery(guiMapMessage);
	}

	@Override
	public List<HashMap> show_Category(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing databases...");
		return employeeMapper.show_Category(guiMapMessage);
	}

	@Override
	public List<HashMap> show_tableNamesbasedonid(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing tablenames based on ids...");
		return employeeMapper.show_tableNamesbasedonid(guiMapMessage);
	}

	@Override
	public List<HashMap> finalQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing finalQuery...");
		return employeeMapper.finalQuery(guiMapMessage);
	}

	@Override
	public List<HashMap> ExecutefinaQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Executing finaQuery..."+guiMapMessage);
		return employeeMapper.ExecutefinaQuery(guiMapMessage);
	}

	@Override
	public List<HashMap> runExecutefinaQuery(Map  guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("run finaQuery..."+guiMapMessage);
		return employeeMapper.runExecutefinaQuery(guiMapMessage);
	}

	@Override
	public Map InsertmultiplejoinsQuery(Map guiMapMessage) {
		// TODO Auto-generated method stub
	   System.out.println("InsertmultiplejoinsQuery are added successfully....");
	   return employeeMapper.InsertmultiplejoinsQuery(guiMapMessage);
	}

	@Override
	public HashMap multiplejoinsinsert(HashMap tableObj) {
		// TODO Auto-generated method stub
		  System.out.println("multiplejoinsinsert ::::....");
		return employeeMapper.multiplejoinsinsert(tableObj);
	}

	@Override
	public HashMap checkTableId(HashMap tableObj) {
		// TODO Auto-generated method stub
		return employeeMapper.checkTableId(tableObj);
	}

	@Override
	public HashMap getTableIdObj(HashMap tableObj) {
		// TODO Auto-generated method stub
		return employeeMapper.getTableIdObj(tableObj);
	}

	@Override
	public HashMap insTableIdObj(HashMap getTableIdObj) {
		// TODO Auto-generated method stub
		return employeeMapper.insTableIdObj(getTableIdObj);
	}

	@Override
	public HashMap getInsTableIdObj(HashMap getTableIdObj) {
		// TODO Auto-generated method stub
		return employeeMapper.getInsTableIdObj(getTableIdObj);
	}

	@Override
	public List<HashMap> dashboard(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing databases...");
		return employeeMapper.dashboard(guiMapMessage);
	}

	@Override
	public List<HashMap> deleteTablerow(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing deletedTables...");
		return employeeMapper.deleteTablerow(guiMapMessage);
	}

	@Override
	public List<HashMap> deleteColumnrow(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing deletedTables...");
		return employeeMapper.deleteColumnrow(guiMapMessage);
	}

	@Override
	public List<HashMap> show_Reports(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("Showing reports...");
		return employeeMapper.show_Reports(guiMapMessage);
	}

	@Override
	public List<HashMap> show_ColoumnNamesbasedonid(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.show_ColoumnNamesbasedonid(guiMapMessage);
	}

	@Override
	public List<HashMap> getListOfEmployee(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.getListOfEmployee(guiMapMessage);

	}

	@Override
	public List<HashMap> show_Reportsdetails(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.show_Reportsdetails(guiMapMessage);
	}

	@Override
	public List<HashMap> getjoins(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.getjoins(guiMapMessage);
	}

	@Override
	public List<HashMap> getWherecondition(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("inserting Where condition...");
		return employeeMapper.getWherecondition(guiMapMessage);
	}

	@Override
	public List<HashMap> fetchwherecondition(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("fetching where condition...");
		return employeeMapper.fetchwherecondition(guiMapMessage);
	}

	@Override
	public List<HashMap> insertparameter(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("insert parameter...");
		return employeeMapper.insertparameter(guiMapMessage);
	}

	@Override
	public List<HashMap> getparameter(Map guiMapMessage) {
		// TODO Auto-generated method stub
		System.out.println("get parameter..."+guiMapMessage);
		return employeeMapper.getparameter(guiMapMessage);
	
	}

	@Override
	public List<HashMap> deletejoins(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.deletejoins(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateReportJoins(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.UpdateReportJoins(guiMapMessage);
	}

	@Override
	public List<HashMap> getalreadyinsertedjoinsbyid(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.getalreadyinsertedjoinsbyid(guiMapMessage);
	}

	@Override
	public List<HashMap> deleteparams(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return employeeMapper.deleteparams(guiMapMessage);
	}

	@Override
	public List<HashMap> show_users(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 return employeeMapper.show_users(guiMapMessage);
	}

	@Override
	public List<HashMap> insertCriteriaAndParams(Map guiMapMessage) {
		// TODO Auto-generated method stub
		 return employeeMapper.insertCriteriaAndParams(guiMapMessage);
		 
	}


	
	
	
	
	
	
	

	


	
}
