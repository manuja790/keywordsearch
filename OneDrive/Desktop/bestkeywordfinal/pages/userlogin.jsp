<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<%@page import="java.sql.*"%>
<%
String u=request.getParameter("username");
String v=request.getParameter("password");
int i=obj.select(u,v);
String x="invalid";
if(i==1)
{
 response.sendRedirect("../usersearch.html");
 }
else
{
%>
alert("enter the correct username and password");
<%
response.sendRedirect("../userlog.html");
}
%>