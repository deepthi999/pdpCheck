package com.serviceImpl;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.mybatis.mappers.OrganizationMapper;

import com.service.OrganizationService;

@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
    @Qualifier("orgSessionFactory")
    private SqlSessionFactoryBean orgSessionFactory;
	
	@Override
	public List<HashMap> show_organization(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.show_organization(guiMapMessage);
	}

	@Override
	public List<HashMap> show_Reports(Map guiMapMessage) {
		// TODO Auto-generated method stub
	return organizationMapper.show_Reports(guiMapMessage);
	}

	@Override
	public List<HashMap> show_selectOrganization(Map guiMapMessage) {
		// TODO Auto-generated method stub
	return organizationMapper.show_selectOrganization(guiMapMessage);
	}
	
	@Override
	public List<HashMap> Show_no_of_reports(Map guiMapMessage) {
		// TODO Auto-generated method stub
	return organizationMapper.Show_no_of_reports(guiMapMessage);
	}

	@Override
	public List<HashMap> Show_no_of_Organization(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Show_no_of_Organization(guiMapMessage);
	}

	@Override
	public List<HashMap> Show_no_of_users(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Show_no_of_users(guiMapMessage);
	}

	@Override
	public List<HashMap> Show_no_of_Categories(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Show_no_of_Categories(guiMapMessage);
	}

	@Override
	public List<HashMap> AssignOrgReport(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.AssignOrgReport(guiMapMessage);
	}

	@Override
	public List<HashMap> Create_New_Organization(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Create_New_Organization(guiMapMessage);
	}

	@Override
	public List<HashMap> Delete_Tables(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Delete_Tables(guiMapMessage);
	}

	@Override
	public List<HashMap> Delete_Columns(Map guiMapMessage) {
		// TODO Auto-generated method stub	
	return organizationMapper.Delete_Columns(guiMapMessage);
	}

	@Override
	public List<HashMap> Organization_to_Reports(Map guiMapMessage) {
		// TODO Auto-generated method stub	
	return organizationMapper.Organization_to_Reports(guiMapMessage);
	}

	@Override
	public List<HashMap> Selected_organization_reports(Map guiMapMessage) {
		// TODO Auto-generated method stub		
	return organizationMapper.Selected_organization_reports(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportTables(Map guiMapMessage) {
		// TODO Auto-generated method stub
		//System.out.println("Selected_report_name mapper");
	return organizationMapper.GetOrgReportTables(guiMapMessage);
	}

	@Override
	public List<HashMap> show_noof_Organization(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.show_noof_Organization(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportTables(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportTables(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportParameters(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportParameters(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportJoins(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportJoins(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportFields(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportFields(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportField(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportField(guiMapMessage);
	}

	@Override
	public List<HashMap> UpdateOrgReportCriteria(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.UpdateOrgReportCriteria(guiMapMessage);
	}

	@Override
	public List<HashMap> RemoveOrgReportField(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.RemoveOrgReportField(guiMapMessage);
	}

	@Override
	public List<HashMap> InsertOrganization(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.InsertOrganization(guiMapMessage);
	}

	@Override
	public List<HashMap> GenerateOrgReport(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GenerateOrgReport(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportJoins(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GetOrgReportJoins(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportFields(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GetOrgReportFields(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportCriteria(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GetOrgReportCriteria(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportParameters(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GetOrgReportParameters(guiMapMessage);
	}

	@Override
	public List<HashMap> fnGetOrgReportCriteria(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.fnGetOrgReportCriteria(guiMapMessage);
	}

	@Override
	public List<HashMap> fnGetOrgFromList(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.fnGetOrgFromList(guiMapMessage);
	}

	@Override
	public List<HashMap> GetOrgReportCriteriaByReportId(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.GetOrgReportCriteriaByReportId(guiMapMessage);
	}

	@Override
	public List<HashMap> RemoveOrgReportTables(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.RemoveOrgReportTables(guiMapMessage);
	}

	@Override
	public List<HashMap> RemoveOrgReportCriteria(Map guiMapMessage) {
		// TODO Auto-generated method stub
		return organizationMapper.RemoveOrgReportCriteria(guiMapMessage);

	}
	

}
