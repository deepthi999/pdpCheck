<html>
<body>

<div id="demo">
<select id ="demo"onclick="getData()">select</select>

</div>


   <script type="text/javascript">
function getData() 
{
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
     
    }
  };
  xhttp.open("POST","http://localhost:8025/pdp/ReportsService/show_databases", true);
   xhttp.setRequestHeader("Content-Type", "application/json"); 
       xhttp.send("{}");
   
}
</script>
</body>
</html>