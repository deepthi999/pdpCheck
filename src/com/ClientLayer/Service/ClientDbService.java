package com.ClientLayer.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public interface ClientDbService {

	List<HashMap> getTableList(Map guiMapMessage);

	List<HashMap> getColumnList(Map guiMapMessage);

	List<HashMap> runExecutefinalQuery(Map guiMapMessage);

	List<HashMap> executefinalQuery(Map guiMapMessage);

	List<HashMap> executeParamQuery(Map guiMapMessage);

}
