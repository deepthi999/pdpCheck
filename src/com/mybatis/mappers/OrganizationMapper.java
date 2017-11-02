package com.mybatis.mappers;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("OrganizationMapper")
public interface OrganizationMapper {
	
	List<HashMap> show_organization(Map guiMapMessage);

	List<HashMap> show_Reports(Map guiMapMessage);

	List<HashMap> show_selectOrganization(Map guiMapMessage);

	List<HashMap> Show_no_of_reports(Map guiMapMessage);

	List<HashMap> Show_no_of_Organization(Map guiMapMessage);

	List<HashMap> Show_no_of_users(Map guiMapMessage);

	List<HashMap> Show_no_of_Categories(Map guiMapMessage);

	List<HashMap> AssignOrgReport(Map guiMapMessage);

	List<HashMap> Create_New_Organization(Map guiMapMessage);

	List<HashMap> Delete_Tables(Map guiMapMessage);

	List<HashMap> Delete_Columns(Map guiMapMessage);

	List<HashMap> Organization_to_Reports(Map guiMapMessage);

	List<HashMap> Selected_organization_reports(Map guiMapMessage);

	List<HashMap> GetOrgReportTables(Map guiMapMessage);

	List<HashMap> show_noof_Organization(Map guiMapMessage);

	List<HashMap> UpdateOrgReportTables(Map guiMapMessage);

	List<HashMap> UpdateOrgReportParameters(Map guiMapMessage);

	List<HashMap> UpdateOrgReportJoins(Map guiMapMessage);

	List<HashMap> UpdateOrgReportFields(Map guiMapMessage);

	List<HashMap> UpdateOrgReportField(Map guiMapMessage);

	List<HashMap> UpdateOrgReportCriteria(Map guiMapMessage);

	List<HashMap> RemoveOrgReportField(Map guiMapMessage);

	List<HashMap> InsertOrganization(Map guiMapMessage);

	List<HashMap> GenerateOrgReport(Map guiMapMessage);

	List<HashMap> GetOrgReportJoins(Map guiMapMessage);

	List<HashMap> GetOrgReportFields(Map guiMapMessage);

	List<HashMap> GetOrgReportCriteria(Map guiMapMessage);

	List<HashMap> GetOrgReportParameters(Map guiMapMessage);

	List<HashMap> fnGetOrgReportCriteria(Map guiMapMessage);

	List<HashMap> fnGetOrgFromList(Map guiMapMessage);

	List<HashMap> GetOrgReportCriteriaByReportId(Map guiMapMessage);

	List<HashMap> RemoveOrgReportTables(Map guiMapMessage);

	List<HashMap> RemoveOrgReportCriteria(Map guiMapMessage);

}
