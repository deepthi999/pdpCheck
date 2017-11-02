
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="Style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/utils/constants.js"></script>
<script>
	function LoadDoc() {
		//document.getElementsByTagName("header")[0].innerHTML = HEADER_SECTION;
		document.getElementById("reportName").innerHTML = REPORT_NAME;
		document.getElementById("databaseName").innerHTML = SELECT_DB;
		document.getElementById("category").innerHTML = SELECT_CATEGORY;
		document.getElementById("reportDescription").innerHTML = REPORT_DESCRIPTION;
		//document.getElementsByTagName("footer")[0].innerHTML = FOOTER_SECTION;
	}
</script>
</head>
<body onload="LoadDoc();">
	<div id="header"></div>
	<div class="container">
		<div class="panel panel-default panel-box">
			   <div class="panel-heading" style="text-align:center; font-size:20px";><b>Create Report</b> <span id="spantext"></span></div>
			</div>
			<div class="panel-body">
				<form method="post" name="GeneralForm" id="report">
					<table class="table table-bordered">

						<tr>
							<td><b><div id="databaseName"></div> </b></td>
							<td><select class="form-control" id="DLState"></select></td>
						</tr>

						<tr>
							<td><b><div id="category"></div> </b></td>
							<td><b> </b><select class="form-control" id='SelectCategory'>
							</select></td>
							</select>
							</td>
						</tr>

						<tr>
							<td><b><div id="reportName"></div> </b></td>
							<td><input class="form-control" type="text"
								name="ReportName" id="ReportName" /></td>
						</tr>

						<tr>
							<td><b><div id="reportDescription"></div> </b></td>
							<td><textarea class="form-control" id="description" rows="3"
									cols="25"></textarea></td>
						</tr>
					</table>
					</br>
					<div align="center">
						<button type="button" class="btn btn-primary"
							onclick="ReportDataGet()">Next</button>
					</div>
					<br> <br> <br> <br> <br>
				</form>
			</div>
		</div>
	
	<div id="footer" ></div>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						localStorage.clear();
						var jsonObjToSend = {};
						$
								.ajax({
									url : SERVER_URL + '/show_databases',
									type : 'POST',
									dataType : 'json',
									contentType : "application/json ; charset=utf-8",
									data : JSON.stringify(jsonObjToSend),
									success : function(data, textStatus, xhr) {
										data = data.returnData;
										var ddlCustomers = $('#DLState');
										ddlCustomers
												.empty()
												.append(
														'<option selected="selected">Please select</option>');
										$.each(data, function() {
											ddlCustomers.append($(
													"<option></option>").val(
													this['database_id']).html(
													this['database_name']));
										});
										$('#DLState')
												.on(
														'change',
														function() {
															var id = $(
																	'#DLState')
																	.val();

															var name = $(
																	'#DLState :selected')
																	.text();

															localStorage
																	.setItem(
																			"databaseName",
																			name);

														});
										console.log(data);
									},
									error : function(xhr, textStatus,
											errorThrown) {
										console.log('Error in Operation');
									}
								});

						var jsonObjToSend = {};
						$
								.ajax({
									url : SERVER_URL + '/show_Category',
									type : 'POST',
									dataType : 'json',
									contentType : "application/json ; charset=utf-8",
									data : JSON.stringify(jsonObjToSend),
									success : function(data) {
										data = data.returnData;
										var ddlCustomers = $('#SelectCategory');
										ddlCustomers
												.empty()
												.append(
														'<option selected="selected">Please select</option>');
										$
												.each(
														data,
														function() {
															ddlCustomers
																	.append($(
																			"<option></option>")
																			.val(
																					this['report_category_id'])
																			.html(
																					this['report_category_name']));

														});
										$('#SelectCategory').on(
												'change',
												function() {
													var id = $(
															'#SelectCategory')
															.val();
												});
										console.log(data);

									},
									error : function(xhr, textStatus,
											errorThrown) {
										console.log('Error in Operation');
									}
								});
					});

	function ReportDataGet() {

		var report = {};
		report.rep_name = $("#ReportName").val();
		report.rep_desc = $("#description").val();
		report.rep_cat = $('#SelectCategory').val();
		report.db_id = $('#DLState').val();

		$.ajax({
			url : SERVER_URL + '/CreateReport',
			type : 'POST',
			dataType : 'json',
			contentType : "application/json ; charset=utf-8",
			data : JSON.stringify(report),
			success : function(data, textStatus, xhr) {
				data = data.returnData;
				console.log(data);
				var reportid = JSON.stringify(data);
				window.location.href = "index.html";
				localStorage.setItem("reportsData", reportid);
			},
			error : function(xhr, textStatus, errorThrown) {
				console.log('Error in Operation');
			}
		});
	}
</script>
<script>
$("#header").load("header.html");
$("#footer").load("footer.html");
</script>
</html>