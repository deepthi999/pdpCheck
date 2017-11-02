<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>


<jsp:scriptlet><![CDATA[response.setContentType("text/html");
   String name = null;
   session = request.getSession(false);
   response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1.
   response.setHeader("Cache-Control", "no-store"); // HTTP 1.1.
   response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   response.setDateHeader("Expires", 0);
   if (session != null ) {
    name = (String) session.getAttribute("name");
   }

   String doc = request.getParameter("doc");
   //System.out.println("here"+doc);
   if (request.getParameter("doc") != null) {
    try {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection(
       "jdbc:mysql://192.168.10.44:3306/MTVZ", "BhaskarK",
       "Initial123");
     System.out.println("driver is connected");
     Statement st = con.createStatement();
     String qry = "";
     if (doc.equals("collapse1")) {
      System.out.println("heelo");
      qry = "select Task_id, Task_Name,Task_Description,Status from NM_Add where U_status='Urgent' and I_status='Important'and Status!='completed' and email_id='"+ name + "'";
     } else if (doc.equals("collapse2")) {
      qry = "select Task_id,Task_Name,Task_Description,Status from NM_Add where U_status='Not Urgent' and I_status='Important' and Status!='completed' and email_id='"
        + name + "'";
     } else if (doc.equals("collapse3")) {
      qry = "select Task_id,Task_Name,Task_Description,Status from NM_Add where U_status='Urgent' and I_status='Not Important' and Status!='completed' and email_id='"
        + name + "'";
     } else if (doc.equals("collapse4")) {
      qry = "select Task_id,Task_Name,Task_Description,Status from NM_Add where U_status='Not Urgent' and I_status='Not Important' and Status!='completed' and email_id='"
        + name + "'";
     }
     System.out.println(qry);
     ResultSet rs = st.executeQuery(qry);
     ResultSetMetaData rmd = rs.getMetaData();]]></jsp:scriptlet>

<table class="table table-bordered" style="text-align:left"> <col width="100"> <col width="100"> <col width="100">

 <tr>
  <jsp:scriptlet><![CDATA[for (int i =2; i <= rmd.getColumnCount(); i++) {]]></jsp:scriptlet>
  <td style="color:  #20B2AA"  size='20'>
   <jsp:scriptlet><![CDATA[out.print(rmd.getColumnLabel(i));]]></jsp:scriptlet>
  </td>
  <jsp:scriptlet><![CDATA[}]]></jsp:scriptlet>
  
 </tr>
 <%
  //int j=0;
    while (rs.next()) {
 %>
 <tr id="<%out.print(rs.getString(1));%>">
 
  <%
   for (int i =2; i <= rmd.getColumnCount(); i++) {
  %>
  <td>
   <%
    out.println(rs.getString(i));
   %>
  </td>
  <%
   }
  %>
  <td colspan="2"><a href=""
   onClick="return edit('<%out.print(rs.getString(1));%>');">Edit</a></td>
 </tr>
 <tr id="new_<%out.print(rs.getString(1));%>">
  
 </tr>
 <%
  }
 %>
</table>

<%
 } catch (Exception e) {
%>
System.out.println(e2);
<%
 }
 }
   
%>
<%
%>