		var Ven_dorName = [];
		var Ven_type = [];
		var par_query = [];
		var query_data = [];
		var Ven_TxNmae = [];
		var Ven_DDNmae = [];
		console.log(Ven_DDNmae);
		console.log(Ven_TxNmae);
		var x;
		var y;
		var selectList;
		
		var Dropdown_data;
		
		var getperameter_data;
		
		var query;
		//var drop_donValues = [];
	

		function get_CustmizefilterData()
		{
			//alert('hello');
			var ReportNames = localStorage.getItem('orgnameid');
			var event = JSON.parse(ReportNames);
			var Reportname = event.report_name;
			var org_report_id = event.org_report_id;
			
			/*Ajax Call*/
					
			var jsonObjToSend = {};
			jsonObjToSend.org_report_id = org_report_id;
			jsonObjToSend.criteria_id = "NULL";
			
			
			
			var data = JSON.stringify(jsonObjToSend);
			
			 var saveData = $.ajax({
			      type: 'POST',
			      data: data,
			      url :'./OrganizationService/GetOrgReportParameters',
			      dataType: 'JSON',
			      contentType: "application/json",
			     
			      success: function(data)
			     	 { 
			    	   getperameter_data = data.returnData;
			    	   
			    	   console.log(getperameter_data);
			    	  
			    	   if(getperameter_data != undefined) {
			    	  		for(var i=0; i<getperameter_data.length; i++)
			    	  			{
			    	  				Ven_dorName.push(getperameter_data[i].param_label);
			    	  				Ven_type.push(getperameter_data[i].param_type);
			    	  				//Ven_Nmae.push(getperameter_data[i].param_name);
			    	  				//par_query.push(getperameter_data[i].param_query);
			    	  			}
			    	  		
				    	  	send_data();
			    	   }
			    	  },
			   error:function(data) 
			   		{ 
				 //  alert("Something went wrong");
				   }
			});
			
		};
			
		/*Displaying in frontend */
		
		function send_data()
		{
			var Vendor_Names = "";
			var Vendor_type = "";
			
			//alert(JSON.stringify(Ven_dorName));
			//document.getElementById("ven_dor").innerHTML = Ven_dorName; 
			
			for(var i=0; i< Ven_type.length; i++)
				{
					Ven_type;
					
					Vendor_Names += Ven_dorName[i] + "<br><br>";
					
					//Vendor_type += Ven_type[i] + "<br>";
					var VEN_Tyope = Ven_type[i];
					
					if( VEN_Tyope == "Text")
						{
						
						 x =getperameter_data[i].param_name;
						
						var input = document.createElement("input");
						input.setAttribute('type', 'text');
						input.setAttribute('id', "Ven_name"+i);
						input.setAttribute("style", 'margin-top:5px');
						input.setAttribute('name', x);
						input.setAttribute('class', 'form-control Vendor_Name');
						var parent = document.getElementById("in_put");
						parent.appendChild(input);							
						}
					else if(VEN_Tyope == "singleSelect")
						{	
						
						
						Ven_DDNmae.push(getperameter_data[i].param_name);
						 y = getperameter_data[i].param_query;
						 
						 par_query.push(getperameter_data[i].param_query);
						//alert(y);
						 
							console.log(query_data);
							selectList = document.createElement("select");
							selectList.setAttribute("id", "mySelect");
							selectList.setAttribute("style", 'margin-top:5px');
							selectList.setAttribute("name", Ven_DDNmae);			
							selectList.setAttribute("class", "form-control select_opt");
							var myDiv = document.getElementById("in_put");
							myDiv.appendChild(selectList);
							dropdn_data(y);						
							
						} 
				}
			document.getElementById("labe_div").innerHTML = Vendor_Names;
		}
		
		function dropdn_data(y)
		{
			//alert(y);
			/*var as ={};
			as.query = y;*/
		//	alert(JSON.stringify(as));
			par_query;
			//alert(par_query);
			console.log(y);
			//var  query_data = {"query":"SELECT DISTINCT APH.APHCUR AS 'KEY',APH.APHCUR AS VALUE FROM APH"};
			var query_data = {"query":y};
							
			
				var saveData = $.ajax({
			      type: 'POST',
			      data: JSON.stringify(query_data),
			      url: SERVER_CLIENT_SERVICE_URL +"/executeParamQuery",
			      dataType: 'JSON',
			      contentType: "application/json",
			     
			      success: function(data)
			     	 { 
			    	 // console.log(data);
			    	  console.log(data.returnData);
			    	  Dropdown_data = data.returnData;
			    	  console.log(Dropdown_data);
			    	 
			    	  dropdown_dataaa(y);
			    	  },
			  	 error:function(data) 
				   		{ 
					   		//alert("Something went wrong");
					   }
			});
			
		}
		
		function dropdown_dataaa(y)
		{
			
			Dropdown_data;
			Ven_DDNmae;
			//Create array of options to be added
			//var array = drop_donValues;
		 	var array = [];
			for(var i=0; i<Dropdown_data.length; i++)
				{
					array.push(Dropdown_data[i].value);
				}
			
			//Create and append select list
			
			
			/*var selectList = document.createElement("select");
			selectList.setAttribute("id", "mySelect");
			selectList.setAttribute("name", Ven_DDNmae);			
			selectList.setAttribute("class", "form-control select_opt");
			myDiv.appendChild(selectList);*/
			
			//Create and append the options
			for (var i = 0; i < array.length; i++) {
			    var option = document.createElement("option");
			    option.setAttribute("value", array[i]);			   
			    option.setAttribute("id", 'opt_id'+array[i]);
			    option.text = array[i];
			    selectList.appendChild(option);
			}
		}
		
		function addCustmFilter()
			{	
			var queryWithoutFilters = localStorage.getItem('Custgeneratedquery');
		
			  //alert('locquery:   '+queryWithoutFilters);
			
			 var elements = document.getElementById("myForm").elements;
			   var filterList =[];
			    for(var i = 0 ; i < elements.length ; i++){
			    	 var obj ={};
			        var item = elements.item(i);
			        
			        obj[item.name] = item.value;
			        filterList.push(obj)
			    }
			  
			    //alert("form Data"+JSON.stringify(filterList));
			    
			    for(var i = 0 ; i < filterList.length ; i++){
			    	var obj = filterList[i];
			    	  Object.keys(obj).forEach(function(k) {
			    	//	var namedParam = ":"+ k + ":";
			    		var paramValue = "'"+ obj[k] + "'";
			    		queryWithoutFilters =  queryWithoutFilters.replace(k, paramValue);

			    	});
			    	    }
			   //alert('afterReplacing:   '+queryWithoutFilters);
			    
			    
			    
			    var data = queryWithoutFilters;
				
				  $.ajax({
				url : SERVER_URL+'/runExecutefinaQuery',
				type : 'POST',
				data : data,
				dataType : 'JSON',
				contentType : "application/json",
				success : function(data) {

					//alert("success" + JSON.stringify(data));
					data = data.returnData;

					//alert("success" + JSON.stringify(data));

					console.log(data);
					createGridd(data);
					//bindreporttoexcel(data);
					//localStorage.setItem('queryOutput', JSON.stringify(data));
					//var finalqueryOutput = localStorage.getItem('queryOutput');
				//alert("finalqueryOutput" + finalqueryOutput);
					//window.open('10.html', '_self');
					//window.location.href('10.html');
				}
			}); 
			    
			    
				  function bindreporttoexcel(finalQueryvalues) {
						var arr = finalQueryvalues;
						//alert("pppp"+arr);
						var table = "<html><table class='table table-bordered'>";

						if (arr.length > 0) {
							var col = [];
							for ( var key in arr[0]) {
								if (col.indexOf(key) === -1) {
									col.push(key);
								}
							}
						}

						for (i = 0; i < col.length; i++) {
							table = table + "<th>" + col[i] + "</th>";
						}

						for (j = 0; j < arr.length; j++) {

							table = table + "<tr>";

							for (i = 0; i < col.length; i++) {
								table = table + "<td>" + arr[j][col[i]] + "</td>";
							}
							table = table + "</tr>";
						}
						table += "</table></html>";
						document.getElementById("QueryResult").innerHTML = table;
					} 
			}