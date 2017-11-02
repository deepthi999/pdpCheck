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
		
		var Dropdown_data;
		
		var getperameter_data;
		
		var query;
		//var drop_donValues = [];
	

		function get_filterData()
		{
			//alert('hello');
			var data = {"report_id":"88"};
			 var saveData = $.ajax({
			      type: 'POST',
			      data: JSON.stringify(data),
			      url: "http://172.16.40.168:8090/pdp/ReportsService/getparameter",
			      dataType: 'JSON',
			      contentType: "application/json",
			     
			      success: function(data)
			     	 { 
			    	  
			    	   getperameter_data = data.returnData;
			    	  
			    	  		for(var i=0; i<getperameter_data.length; i++)
			    	  			{
			    	  				Ven_dorName.push(getperameter_data[i].param_label);
			    	  				Ven_type.push(getperameter_data[i].param_type);
			    	  				//Ven_Nmae.push(getperameter_data[i].param_name);
			    	  				par_query.push(getperameter_data[i].param_query);
			    	  			}
			    	  		
				    	  	send_data();
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
					
					if( VEN_Tyope == "TEXT")
						{
						
						 x =getperameter_data[i].param_name;
						
						var input = document.createElement("input");
						input.setAttribute('type', 'text');
						input.setAttribute('id', "Ven_name"+i);
						input.setAttribute('name', x);
						input.setAttribute('class', 'form-control Vendor_Name');
						var parent = document.getElementById("in_put");
						parent.appendChild(input);							
						}
					else if(VEN_Tyope == "DROPdOWN")
						{	
						
						Ven_DDNmae.push(getperameter_data[i].param_name);
						 y = getperameter_data[i].param_name;
						//alert(y);
							console.log(query_data);
							dropdn_data(y);						
							
						} 
				}
			document.getElementById("labe_div").innerHTML = Vendor_Names;
		}
		
		function dropdn_data(y)
		{
			//alert(y);
			var as ={};
			as.query = y;
		//	alert(JSON.stringify(as));
			var  query_data = {"query":"SELECT DISTINCT APH.APHCUR AS 'KEY',APH.APHCUR AS VALUE FROM APH"};
			//var query_data = {"query":y};
							
				console.log(query_data);
			
				var saveData = $.ajax({
			      type: 'POST',
			      data: JSON.stringify(query_data),
			      url: "http://172.16.40.168:8090/pdp/ClientService/executeParamQuery",
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
			var myDiv = document.getElementById("DB");

			//Create array of options to be added
			//var array = drop_donValues;
		 	var array = [];
			for(var i=0; i<Dropdown_data.length; i++)
				{
					array.push(Dropdown_data[i].VALUE);
				}
			
			//Create and append select list
			
			
			var selectList = document.createElement("select");
			selectList.setAttribute("id", "mySelect");
			selectList.setAttribute("name", y);			
			selectList.setAttribute("class", "form-control select_opt");
			myDiv.appendChild(selectList);
			
			//Create and append the options
			for (var i = 0; i < array.length; i++) {
			    var option = document.createElement("option");
			    option.setAttribute("value", array[i]);
			    option.setAttribute("id", 'opt_id'+array[i]);
			    option.text = array[i];
			    selectList.appendChild(option);
			}
		}
		
		function get_VN()
			{	
			var queryWithoutFilters = localStorage.getItem('generatedquery');
		
			  alert(queryWithoutFilters);
			
			 var elements = document.getElementById("myForm").elements;
			   var filterList =[];
			    for(var i = 0 ; i < elements.length ; i++){
			    	 var obj ={};
			        var item = elements.item(i);
			        
			        obj[item.name] = item.value;
			        filterList.push(obj)
			    }
			  
			    alert(JSON.stringify(filterList));
			    for(var i = 0 ; i < filterList.length ; i++){
			    	var obj = filterList[i];
			    	  Object.keys(obj).forEach(function(k) {
			    		var namedParam = ":"+ k + ":";
			    		var paramValue = "'"+ obj[k] + "'";
			    		queryWithoutFilters =  queryWithoutFilters.replace(namedParam, paramValue);

			    	});
			    	    }
			    alert(queryWithoutFilters);
			}