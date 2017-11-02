<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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

 <script src="./js/md5.js"></script>

</head>
<body >

<header> 

 <%--  <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL=http:./logout.jsp" /> --%>
<div id="header" style="oveflow: hidden; height: 10px ">
<img src="https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAA1hAAAAJDMwMzY2M2M4LWVjOWEtNDQxYi04OWM2LThhMWJjMTg1ZTU0Zg.png" align="left"  height="90" width="110" alt="logo" />
 
</div>
<h1>Welcome to Mouritech</h1>
 <a href="logout.jsp" class="glyphicon glyphicon-log-out" onclick="active='home'" id="log">Logout</a>

</header>

<form  name="userreg" class="center">
               <h2>Dashboard</h2>
         
                <div>
                    <label>Employee:</label>
                    <P>Employee in Mouritech</P>
                </div><br>
    
               <!--  <button ng-click='submit()' style='margin-top:15px'>submit</button> -->
            </form>
       
   <script>
    function preventBack() {
	   window.history.forward();
	  }
	  setTimeout("preventBack()", 0);
	  window.onunload = function() {
	   null
	  };  
	  
	  
   </script>
     
</body>
<br><br><br>
<footer>
<h4>Copyright @Mouritech LLC</h4>
 </footer>

</body>



</html>