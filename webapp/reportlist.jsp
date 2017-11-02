<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Reports List</title>

<meta charset="ISO-8859-1">
<title>Report Output</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript"
	src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>
<link rel="stylesheet" href="Style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/utils/constants.js"></script>
<style>
#thd {
	background-color: #0088cc;
	color: white;
}
</style>
<bodyverifying();">

	<div id="header"></div>

<div class="container">
  
        <div class="panel-body"style="margin-top: 10%;">
     
      <div class=" ">
        <div class="row">
          <div class="col-md-2">
           
          </div>
          <div class="col-md-8">
            <div id="QueryResult" style="text-align:left"></div>
          </div>
          <div class="col-md-2">
         
            <div class="row btn-grp" style="text-align:center">
       
              <a type="button" id="exportButton" class="btn btn-primary" href="report.jsp">Create Report</a>
            </div>
            <br>
            <div class="row btn-grp" style="text-align:center">
<!--               <a href="j_spring_security_logout"> Logout </a>
 -->                            <a type="button" id="exportButton" class="btn btn-primary" href="j_spring_security_logout">Logout</a>
              
            
            </div>
					
                 </div>
           
          </div>
        </div>
        
      
  </div>
</div>&emsp;&emsp;&emsp;
<div id="footer"></div>

<script>
	function handleClick(report_id, report_name) {
		//alert(report_id);
		//alert(report_name);
		var repoid = "{report_id:" + report_id + ", report_name:" + report_name
				+ "}";
		repoid = {};
		repoid.report_id = report_id;
		repoid.report_name = report_name;
		reportid = [];
		reportid.push(repoid);

		//var repoprtid=JSON.stringify(reportid);

		localStorage.setItem("reportsData", JSON.stringify(reportid));

		//window.location.href = "4.html";

		var data = "{" + "report_id" + ":" + report_id + "}";
		//alert("reportid..."+ data);
		$.ajax({
			url : SERVER_URL + '/finalQuery',
			type : 'POST',
			data : data,
			dataType : 'JSON',
			contentType : "application/json",
			success : function(data) {
				data = data.returnData;

				console.log(data);
				// alert(JSON.stringify(data));
				executefinalQuery(data);

			}
		});
		function executefinalQuery(data) {

			var data = data[0].v_sql;
			data = data.replace(/\s+/g, " ");
			data = data.replace(/"/g, "'"); //to Replace with single quotes in plcae of "
			data = "{" + "\"query\"" + ":\"" + data + "\"}";

			localStorage.setItem('generatedquery', data);
			//	alert("finalquery"+data);
			window.open('10_1.html', '_self');

		}
	}
</script>





 </center>

<div id="tableId"></div>
<br/><br/>

<script>
	//$('#DLState').on('change', function () {
	$(document).ready(function() {
		localStorage.clear();
		var jsonObjToSend = {};
		//var selecteddbname =localStorage.getItem('databaseName'); 
		//jsonObjToSend.dbName = this.value;
		//jsonObjToSend.dbName = selecteddbname;
		$.ajax({
			url : './ReportsService/show_Reportsdetails',
			type : 'POST',
			dataType : 'json',
			contentType : "application/json ; charset=utf-8",
			data : JSON.stringify(jsonObjToSend),
			success : function(data, textStatus, xhr) {

				console.log(data);
				bindTableData(data);

			},
			error : function(xhr, textStatus, errorThrown) {
				console.log('Error in Operation');
			}
		});

	});
</script>
       
 <script type="text/javascript">
		function bindTableData(data) {

			var arr = data.returnData;
			var table = "<html><table class='table table-bordered' id='QueryResult'>";
			var chk = "<td>" + "" + "</td>";
			/*  var dbname =localStorage.getItem('databaseName'); */

			table = table + "<th id='thd'>" + "Report Names" + "</th>"
					+ "<th id='thd'>" + "Run Report" + "</th>";

			var i;

			// var out = "<table>";
			for (i = 0; i < arr.length; i++) {

				var data = arr[i];
				//alert(JSON.stringify(data));

				table = table + "<tr>";

				str = '<td><input type="button" value="Run" class="btn btn-primaryReportlist" onclick="handleClick('
						+ arr[i].report_id
						+ ' , \''
						+ arr[i].report_name
						+ '\');"/></td>';

				// str = '<td><input type="button"  value="Run"  onClick="handleClick('+ arr[i].report_id  +');"/></td>';
				table = table + "<td>" + arr[i].report_name + "</td>" + str;

				table = table + "</tr>";

				//console.log(str);

			}

			table += "</table></html>";
			document.getElementById("QueryResult").innerHTML = table;
		}

		$("#header").load("header.html");
		$("#footer").load("footer.html");
	</script>
       
     
       
  </body>     
       
</html>