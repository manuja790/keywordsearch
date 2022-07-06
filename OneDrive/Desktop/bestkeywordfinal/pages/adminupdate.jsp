<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<%@page import="java.sql.*"%>
<%
String u=request.getParameter("username");
String v=request.getParameter("password");
int i=obj.select1(u,v);
String x="invalid";
if(i==1)
{
 response.sendRedirect("../admin2.html");
 }
else
{
%>
alert("enter the correct username and password");
<%
response.sendRedirect("../adminlogin.html");
}
%>