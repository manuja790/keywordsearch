<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
  
   <html>

<head>
&nbsp;
<center> <h2><font color="white">USERS LIST</font><h2></center>

<style>
table, th, td {
      border: 1px solid black;
}

</style>
</head>
<body background="uu.jpg">
<table style="width:100%" border="10">
<br>
 <tr>
    <th><font color="white">No</font></th>	
    <th><font color="white">Firstname</font></th>
	<th><font color="white">Lastname</font></th>
	 <th><font color="white">Gender</font></th>		
    <th><font color="white">Date Of Birth</font></th>
	<th><font color="white">Email</font></th>
	<th><font color="white">Phone</font></th>	
  </tr>
  
  <%
   ResultSet rs=obj.selectuser();
   
   while(rs.next())
{
  String a=rs.getString(1);
  String b=rs.getString(3);
  String c=rs.getString(4);
  String d=rs.getString(6);
  String e=rs.getString(7);
  String f=rs.getString(8);
  String g=rs.getString(9);
   %>
   
   <tr>
    <th><font color="white"><%=a%></font></th>
    <th><font color="white"><%=b%></font></th>		
    <th><font color="white"><%=c%></font></th>
	<th><font color="white"><%=d%></font></th>
	<th><font color="white"><%=e%></font></th>		
    <th><font color="white"><%=f%></font></th>
	<th><font color="white"><%=g%></font></th>
  </tr>
  
   <%
}
%>


  </table>
</body>
</html>