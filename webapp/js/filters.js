//For Filters    

//For getparams

var creteriaid;
function bindFilterParams(data)
	{
		
		/*var creteria_id=JSON.stringify(data);
		creteriaid = data[0].o_criteria_id;
		
		localStorage.setItem('Crt_ID',creteriaid);
		*/
	var Report_Names = localStorage.getItem('reportsData');
	
	var event = JSON.parse(Report_Names);
	var report_id = event[0].report_id;
	 
	 var jsonObjfromDb={};
	 jsonObjfromDb.report_id =report_id;
	 //jsonObjfromDb.criteria_id = 'NULL';
	 
	// var Crt_ID=localStorage.getItem('Crt_ID');
	 jsonObjfromDb.criteria_id = 'NULL';
     var data=JSON.stringify(jsonObjfromDb);

       
$.ajax({
    url:'./ReportsService/getparameter',
    type: 'POST',
    dataType: 'json',
    contentType: "application/json ; charset=utf-8",
    data: data,
    success: function(data, textStatus, xhr) 
    {
        console.log(data);
      // alert("n"+JSON.stringify(data));
       bindExistingparam(data);
    },
    error: function(xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
 

function bindExistingparam(data) {
	
	
	var arr = data.returnData;

	var table="<html><table class='table table-bordered'>";
		
		 table=table+"<th id='thd'>"+"Filter Label"+"</th>"+"<th id='thd'>"+"Filter Type"+"</th>"+"<th id='thd'>"+"Delete"+"</th>"; 
		
		  if(arr!=null){
		  var i;
		  for(i = 0; i < arr.length; i++) {
		// var data = arr[i];  
		
		   table=table+"<tr>";  
		  // str = '<td><input type="button" value="Customize"  onclick="handleClick('+ arr[i].report_id  +' , \''+ arr[i].report_name +'\');"/></td>';
		   
		   str = "<td><img height='30px' src='./images/del.png' onClick='delparams("
				+ arr[i].report_id
				+ ", "
				+ arr[i].criteria_id
				
				+ ");'></img></td>";
		   
		   table=table+"<td>" + arr[i].criteria_label +"</td>"+"<td>" + arr[i].criteria_type +"</td>" +str;
		   /*table=table+"<td>" + arr[i].param_name +"</td>"+"<td>" + arr[i].param_label +"</td>"+"<td>" + arr[i].param_type +"</td>"+"<td>" + arr[i].param_query +str;*/
		   //alert(table);
		   
		 table=table+"</tr>";
		 console.log(str);
		}
		  
		  }
		  else{
		   //alert("report name not found");
		  }

		  table += "</table></html>";
		document.getElementById("filters").innerHTML=table;
				
		}
		
	}

function delparams(report_id, creteriaid) {
	//alert("creteriaid1"+ creteriaid);
	/*var Criteria_ID = localStorage.getItem('Crt_ID');
	alert("Criteria_ID2"+ Criteria_ID);*/
	
	data = {};
	data.report_id = report_id;
	
	data.criteria_id = creteriaid;
	
	//alert("TO be deleted Joins:" + JSON.stringify(data));
	data = JSON.stringify(data);
	$.ajax({
		url :'./ReportsService/deleteparams',
		type : 'POST',
		data : data,
		dataType : 'JSON',
		contentType : "application/json",
		success : function(data1) {
			
			//alert("delete:"+JSON.stringify(data1));
			console.log(data1);
			bindFilterParams(data);
			
	    	var x = document.getElementById('dynamic_filters');
			x.style.display = 'block';
		}
	});
	
}


	
	//Modified code for filters

		function insert_filter()
		{
			//alert('hello');
			var Jsondata={};
			
			
			var tableid= document.getElementById('drop_sele').value;
			//alert("ID"+tableid);
			/*var tabledbname=document.getElementById('drop_sele').tablename;
			alert("tbname:"+tabledbname);*/
			var tablecolname= document.getElementById('mouritable4').value;
			//alert("ID"+tablecolname);
			
			
			Jsondata.criteria_id = localStorage.getItem('critiriaId');
			
			var Report_Names = localStorage.getItem('reportsData');
			var event = JSON.parse(Report_Names);	
			var report_id = event[0].report_id;
			
			Jsondata.report_id = report_id;
			//Jsondata.report_id = 1;
			var criteria_prefix=document.getElementById('O_perator_s').value;
			if(criteria_prefix == "Please Select"){
			Jsondata.criteria_prefix ='WHERE';		
			}
			else
			    {
				Jsondata.criteria_prefix =criteria_prefix;
				}
			
			
			Jsondata.start_brace = 'N';
			//Jsondata.criteria_table_id_1 = $('#drop_sele :selected').val();
			Jsondata.criteria_table_id_1 ="NULL";
			Jsondata.criteria_field_id_1 = "NULL";
			Jsondata.criteria_field_name_1 = tablecolname;
			
			var  ope_rator = document.getElementById('O_perator').value;
			Jsondata.criteria_operator = ope_rator;
			
			Jsondata.criteria_table_id_2 = 'NULL';
			Jsondata.criteria_field_id_2 = 'NULL';
			Jsondata.criteria_field_name_2 = document.getElementById('param_label').value;
			
			Jsondata.end_brace ="N";
			Jsondata.criteria_label =document.getElementById('param_label').value;
			var criteria_type=document.getElementById('param_type').value;
			Jsondata.criteria_type =criteria_type;
			//Jsondata.criteria_query =document.getElementById('wherecondition').value;
			//alert("HIIIICreteria:"+criteria_type);
			
			if(criteria_type === "singleSelect" || criteria_type === "multiSelect"){
				//Jsondata.param_query = document.getElementById('param_query').value;
				Jsondata.criteria_query	='select ' + 'distinct '+tablecolname+ ' value '+'from '+ localStorage.getItem("databaseName")+"."+tableid;
				//alert(Jsondata.param_query); 
			}
			else
			{
				
				Jsondata.criteria_query = 'NULL';
			}
			
			Jsondata.quotes_enclosed ="Y";
			Jsondata.seq =1;
			
			//alert("mani"+JSON.stringify(Jsondata));
			
			
	var data = JSON.stringify(Jsondata);
	//alert("Final out:"+data);
			// alert("qqqqq" + data);
			$.ajax({
			    //url: './ReportsService/insertCriteriaAndParams',
			   url:SERVER_URL +'/insertCriteriaAndParams',
			    type: 'POST',
			    data: data,
			    dataType: 'JSON',
			    contentType: "application/json",
			    success: function(data) {
			    	
			    /*	alert("Inside azax:"+JSON.stringify(data));
			    	console.log(data);
			       alert("critiria"+JSON.stringify(data));*/
			    	console.log(data);
			    	 var data=data.returnData;
			           // alert(""+data);
			            bindFilterParams(data);
			    	
			    	// alert("critiria"+JSON.stringify(data));
			    	
			          
			          	
			           
			            
			        //localStorage.setItem("critiriaId",data.returnData[0].o_criteria_id);
			     
/*			       var data=data.returnData;
		           //alert('inside of success: '+ data);
		            
		           //alert(JSON.stringify(data));
		          bindFilterParams(data);*/
			            
			    },
		        error: function (data) {
		           alert('Error in Operation');
		        }
		    });
					
		
	}
		
		
		
	
		 $(document).ready(function(){
		      
	           // $("#with_outonchange").hide();
	            $("#and_or").hide(); 
	  	      
	    });
		  
		 
		
		function preferedtext() {
			    //alert("HI");
			   $(document).ready(function(){
			    	
			    	var filterName = document.getElementById('mouritable4').value;
					var  ope_rator = document.getElementById('O_perator').value;
					paramName = ':'+'param_'+filterName+':';
					var filterLabel = document.getElementById('param_label').value;
					

					if(document.getElementById('wherecondition').value == "")
						{
						//alert("Nagamani:"+paramName);
						paramName;
					 Where_query = "where " + filterName +' '+ope_rator +' '+ paramName;
					 document.getElementById('wherecondition').value = Where_query;
					//localStorage.setItem('where_cond',Where_query);
					//alert("nagu"+Where_query);
						
					localStorage.setItem('where_cond',Where_query);
					refresh();
						}
					else{
						
						 var Add_query = document.getElementById('O_perator_s').value;
						// alert(Add_query);
						 
							if(Add_query)
								{
								// alert("HELOOOOOO");
								table_coln = document.getElementById('mouritable4').value;
								ope_rator = document.getElementById('O_perator').value;
								//Name_query = document.getElementById('query_Name').value;	
								Where_query = "where " + filterName +' '+ope_rator +' '+ paramName;
								 Add_where = ' '+document.getElementById('O_perator_s').value + ' '+  filterName +' '+ope_rator +' '+ paramName;
								document.getElementById('wherecondition').value =  document.getElementById('wherecondition').value + Add_where;
								// alert(Add_where);
								 refresh();
								}
							else
							{
								alert("Operator is required");
								
							}
							
					}
			      
			    });
			  var prefer = document.getElementById('with_onchange').value;
			  prefer.style.display = 'none';
		}
		
		

	function insertall_filterdata()
	{
		
		insert_filter();
		 preferedtext();
	}

	
	function refresh()
	{
		$('#drop_sele').val('Please select Table');
        $('#mouritable4').val('Please select columns for Table');
        $('#O_perator').val('Please Select');
        $('#O_perator_s').val('Please Select');
        $('#param_label').val('');
        $('#param_type').val('Please Select');
        
        $("#and_or").show(); 
		
	}








