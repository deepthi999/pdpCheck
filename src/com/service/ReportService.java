package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReportService {




	List<HashMap> show_databases(Map guiMapMessage);

	List<HashMap> show_tables(Map guiMapMessage);

	List<HashMap> show_coloumns(List guiMapMessage);

	List<HashMap> show_fields(Map guiMapMessage);

	List<HashMap> show_queryPreview(Map guiMapMessage);

	/*void useraddReport(Map guiMapMessage);*/

	List<HashMap> show_ReportsList(Map guiMapMessage);

	//Map CreateReport(Map guiMapMessage);
	List<HashMap> CreateReport(Map guiMapMessage);
	
	HashMap InsertReportTables(HashMap tableObj);
	HashMap InsertReportColoumns(HashMap ColoumnObj);

	Map InsertReportQuery(Map guiMapMessage);

	List<HashMap> show_Category(Map guiMapMessage);

	List<HashMap> show_tableNamesbasedonid(Map guiMapMessage);

	List<HashMap> finalQuery(Map guiMapMessage);

	List<HashMap> ExecutefinaQuery(Map guiMapMessage);

	List<HashMap> runExecutefinaQuery(Map guiMapMessage);

	Map InsertmultiplejoinsQuery(Map guiMapMessage);

	HashMap multiplejoinsinsert(HashMap tableObj);

	HashMap checkTableId(HashMap tableObj);

	HashMap getTableIdObj(HashMap tableObj);

	HashMap insTableIdObj(HashMap getTableIdObj);

	HashMap getInsTableIdObj(HashMap getTableIdObj);

	List<HashMap> dashboard(Map guiMapMessage);

	List<HashMap> deleteTablerow(Map guiMapMessage);

	List<HashMap> deleteColumnrow(Map guiMapMessage);

	List<HashMap> show_Reports(Map guiMapMessage);

	List<HashMap> show_ColoumnNamesbasedonid(Map guiMapMessage);

	List<HashMap> getListOfEmployee(Map guiMapMessage);

	List<HashMap> show_Reportsdetails(Map guiMapMessage);

	List<HashMap> getjoins(Map guiMapMessage);

	List<HashMap> getWherecondition(Map guiMapMessage);

	List<HashMap> fetchwherecondition(Map guiMapMessage);

	List<HashMap> insertparameter(Map guiMapMessage);

	List<HashMap> getparameter(Map guiMapMessage);

	List<HashMap> deletejoins(Map guiMapMessage);

	List<HashMap> UpdateReportJoins(Map guiMapMessage);

	List<HashMap> getalreadyinsertedjoinsbyid(Map guiMapMessage);

	List<HashMap> deleteparams(Map guiMapMessage);

	List<HashMap> show_users(Map guiMapMessage);

	List<HashMap> insertCriteriaAndParams(Map guiMapMessage);



	


	


}
