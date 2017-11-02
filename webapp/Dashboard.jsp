<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="ISO-8859-1">
  <title>Show Reports List</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="Style.css">
<script src="./js/utils/constants.js"></script>
<title>Dashboard</title>
<link rel="stylesheet" href="Style.css">
<style type="text/css">

.box{
margin-left:500px;
margin-top:-170px;
}
.center{
text-align:center;
}

a {
    color: black;
	text-decoration:none;
}
#log{
margin-left:1300px;
 color: white;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <!-- <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet"> -->

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
   <!--  <link href="vendor/morrisjs/morris.css" rel="stylesheet">
 -->
    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>


<body>
<!-- <header> 
<div id="header" style="oveflow: hidden; height: 10px ">
<img src="https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAA1hAAAAJDMwMzY2M2M4LWVjOWEtNDQxYi04OWM2LThhMWJjMTg1ZTU0Zg.png" align="left"  height="95" width="110" alt="logo" />
</div>
<h1>Welcome to Mouritech</h1>
</header>
</br></br></br> -->
 
 <div id="header"></div>
	<div class="container">
	<div class="panel panel-default panel-box">
	
<div class="panel-heading" style="text-align:center; font-size:25px";><b>Dashboard </b> <span id="spantext"></span>
<!-- <a style="float: right; color:#fff; font-size:12pt;margin-top: .5%;" href = "10.html">Back</a> -->
</div> <br><br>
 		<div class="row">
             <!--    <div class="col-lg-2 col-md-2 Panel_reportSn" >
                <a href="reportlist.jsp">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                               
                                <div style="color:white; text-align:center; margin-top: 8%; ">
                                    <div class="huge" id='menuHandler'  style="font-size: -webkit-xxx-large;"></div>
                                </div>
                                <div style="color:white;font-size: 18pt; text-align:center;    margin-top: -7%; ">
                                <b>Reports</b>
                                <div class="col-sm-9 col-md-9 "style="color:white;margin-top: 24%;font-size: 20pt;">
                                   
                                    <div><b>Reports</b></div>
                                </div>
                                </div>
                                 <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                    <i class="fa fa-file-word-o fa-5x"></i>
                                </div>
                            </div>
                             </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" ><a href="reportlist.jsp">View Details</a></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
               </a>
                </div> -->
                
                <div class="col-lg-2 col-md-2 Panel_reportSn" >
                <div style="height:1%;"></div>
                 <a href="reportlist.jsp">
              		<div >
                          <div style="color:white; text-align:center; margin-top: 8%; ">
                                <div class="huge" id='menuHandler'  style="font-size: -webkit-xxx-large;"></div>
                          </div>
                          <div style="color:white;font-size: 13pt; text-align:center;    margin-top: -7%; ">
                                <b>Reports</b>
                          </div>
                          <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                <i class="fa fa-file-word-o fa-5x"></i>
                          </div>
                    </div>
                 </a>
                </div>
                
                <div class="col-lg-2 col-md-2 Panel_reportSn" >
                 <a href="6_01.html">
              		<div class="row">
                          <div style="color:white; text-align:center; margin-top: 8%; ">
                                <div class="huge" id='menuHandler4'  style="font-size: -webkit-xxx-large;"></div>
                          </div>
                          <div style="color:white;font-size: 12pt; text-align:center;margin-top: -7%; ">
                                <b>Organization to Reports</b>
                          </div>
                          <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                <i class="fa fa-flag fa-5x"></i>
                          </div>
                    </div>
                 </a>
                </div>
              
                <div class="col-lg-2 col-md-2 Panel_reportSn" >
                 <a href="Organization.html">
              		<div class="row">
                          <div style="color:white; text-align:center; margin-top: 8%; ">
                                <div class="huge" id='menuHandler1'  style="font-size: -webkit-xxx-large;"></div>
                          </div>
                          <div style="color:white;font-size: 13pt; text-align:center;margin-top: -7%; ">
                                <b>Organization</b>
                          </div>
                          <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                <i class="fa fa-flag fa-5x"></i>
                          </div>
                    </div>
                 </a>
                </div>
                
                <div class="col-lg-2 col-md-2 Panel_reportSn" >
                 <a href="#">
              		<div class="row">
                          <div style="color:white; text-align:center; margin-top: 8%; ">
                                <div class="huge" id='menuHandler2'  style="font-size: -webkit-xxx-large;"></div>
                          </div>
                          <div style="color:white;font-size: 13pt; text-align:center;margin-top: -7%; ">
                                <b>Users</b>
                          </div>
                          <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                <i class="fa fa-users fa-5x"></i>
                          </div>
                    </div>
                 </a>
                </div>
                
               <div class="col-lg-2 col-md-2 Panel_reportSn" >
                 <a href="categories.html">
              		<div class="row">
                          <div style="color:white; text-align:center; margin-top: 8%; ">
                                <div class="huge" id='menuHandler3'  style="font-size: -webkit-xxx-large;"></div>
                          </div>
                          <div style="color:white;font-size: 13pt; text-align:center;margin-top: -7%; ">
                                <b>Categories</b>
                          </div>
                          <div  style="color:white;margin-top: 12%;text-align: center; font-size: 5pt; opacity: .5;">
                                <i class="fa fa-support fa-5x"></i>
                          </div>
                    </div>
                 </a>
                </div>
                <!-- <div class="col-lg-3 col-md-3">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-flag fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge" id='menuHandler4'></div>
                                    <span ><b>Organization to Reports</b></span>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" ><a href="6.html">View Details</a></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> -->
                
              <!--   <div class="col-lg-2 col-md-2">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-flag fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge" id='menuHandler1'></div>
                                    <div><b>Organization</b></div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left" ><a href="Organization.html">View Details</a></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> -->
                
                <!-- <div class="col-lg-2 col-md-2">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge" id='menuHandler2'></div>
                                    <div>Users</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                               <span class="pull-left" ><a href="">View Details</a></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> -->
              <!--   <div class="col-lg-2 col-md-2">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge" id='menuHandler3'></div>
                                    <div>Categories</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                               <span class="pull-left" ><a href="categories.html">View Details</a></span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div> -->
            </div>
            </div>
            </div>
            <div id="footer"></div>
			
             <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
   <!--  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
 -->
    <!-- Metis Menu Plugin JavaScript -->
   <!--  <script src="vendor/metisMenu/metisMenu.min.js"></script> -->

    <!-- Morris Charts JavaScript -->
    <!-- <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script> -->

    <!-- Custom Theme JavaScript -->
 <!--    <script src="dist/js/sb-admin-2.js"></script> -->
    
    
    
 <script>


$(document).ready(function () {

var jsonObjToSend = {};
//var selecteddbname =localStorage.getItem('databaseName'); 
//jsonObjToSend.dbName = this.value;
//jsonObjToSend.dbName = selecteddbname;
$.ajax({
    url: './OrganizationService/Show_no_of_reports',
    type: 'POST',
    dataType: 'json',
    contentType : "application/json ; charset=utf-8",
    data: JSON.stringify(jsonObjToSend),
    success: function (data, textStatus, xhr) {
     
        console.log(data);
       bindTableData(data);
        
 
    },
    error: function (xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
		  
  
});
</script>
 <script type="text/javascript">
 function bindTableData(data){
	 var arr = data.returnData;
	 
	// alert(arr);
	 //var Obj=JSON.stringify(arr);
	// alert(Obj);
	
	 document.getElementById("menuHandler").innerHTML = arr[0].report_name;
	 
 }
 
 </script>
 
 
 <script>


$(document).ready(function () {

var jsonObjToSend = {};
//var selecteddbname =localStorage.getItem('databaseName'); 
//jsonObjToSend.dbName = this.value;
//jsonObjToSend.dbName = selecteddbname;
$.ajax({
    url: './OrganizationService/Show_no_of_Organization',
    type: 'POST',
    dataType: 'json',
    contentType : "application/json ; charset=utf-8",
    data: JSON.stringify(jsonObjToSend),
    success: function (data, textStatus, xhr) {
     
        console.log(data);
       bindTableData1(data);
        
 
    },
    error: function (xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
		  
  
});
</script>
 <script type="text/javascript">
 function bindTableData1(data){
	 var arr = data.returnData;
	 
	// alert(arr);
	 //var Obj=JSON.stringify(arr);
	// alert(Obj);
	
	 document.getElementById("menuHandler1").innerHTML = arr[0].org_name;
	 
 }
 
 </script>
 
 <script>


$(document).ready(function () {

var jsonObjToSend = {};
//var selecteddbname =localStorage.getItem('databaseName'); 
//jsonObjToSend.dbName = this.value;
//jsonObjToSend.dbName = selecteddbname;
$.ajax({
    url: './OrganizationService/Show_no_of_users',
    type: 'POST',
    dataType: 'json',
    contentType : "application/json ; charset=utf-8",
    data: JSON.stringify(jsonObjToSend),
    success: function (data, textStatus, xhr) {
     
        console.log(data);
       bindTableData2(data);
        
 
    },
    error: function (xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
		  
  
});
</script>
 <script type="text/javascript">
 function bindTableData2(data){
	 var arr = data.returnData;
	 
	// alert(arr);
	 //var Obj=JSON.stringify(arr);
	// alert(Obj);
	
	 document.getElementById("menuHandler2").innerHTML = arr[0].user_name;
	 
 }
 
 </script>
 
 <script>


$(document).ready(function () {

var jsonObjToSend = {};
//var selecteddbname =localStorage.getItem('databaseName'); 
//jsonObjToSend.dbName = this.value;
//jsonObjToSend.dbName = selecteddbname;
$.ajax({
    url: './OrganizationService/Show_no_of_Categories',
    type: 'POST',
    dataType: 'json',
    contentType : "application/json ; charset=utf-8",
    data: JSON.stringify(jsonObjToSend),
    success: function (data, textStatus, xhr) {
     
        console.log(data);
       bindTableData3(data);
        
 
    },
    error: function (xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
		  
  
});
</script>
 <script type="text/javascript">
 function bindTableData3(data){
	 var arr = data.returnData;
	 
	// alert(arr);
	 //var Obj=JSON.stringify(arr);
	// alert(Obj);
	
	 document.getElementById("menuHandler3").innerHTML = arr[0].report_category_name;
	 
 }
 
 </script>
 
  <script>


$(document).ready(function () {

var jsonObjToSend = {};
//var selecteddbname =localStorage.getItem('databaseName'); 
//jsonObjToSend.dbName = this.value;
//jsonObjToSend.dbName = selecteddbname;
$.ajax({
    url: './OrganizationService/Organization_to_Reports',
    type: 'POST',
    dataType: 'json',
    contentType : "application/json ; charset=utf-8",
    data: JSON.stringify(jsonObjToSend),
    success: function (data, textStatus, xhr) {
     
        console.log(data);
       bindTableData4(data);
      
    },
    error: function (xhr, textStatus, errorThrown) {
        console.log('Error in Operation');
    }
});
		  
  
});
</script>
 <script type="text/javascript">
 function bindTableData4(data){
	 var arr = data.returnData;
	 
	// alert(arr);
	 //var Obj=JSON.stringify(arr);
	// alert(Obj);
	
	 document.getElementById("menuHandler4").innerHTML = arr[0].org_report_id;
	 
 }
 
 </script>
	
     
</body>
<!-- <br><br><br>
<footer>
<h4>Copyright @Mouritech LLC</h4>
 </footer> -->
<script>
	$("#header").load("header.html");
	$("#footer").load("footer.html");
</script>




</html>