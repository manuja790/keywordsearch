<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<%@page import="java.sql.*"%>
<%
String a=request.getParameter("username");
String b=request.getParameter("firstname");
String c=request.getParameter("lastname");
String d=request.getParameter("password");
String e=request.getParameter("gender");
String f=request.getParameter("dob");
String g=request.getParameter("email");
String h=request.getParameter("phone");
 System.out.println(a);
  System.out.println(b);
  


int i=obj.insert(a,b,c,d,e,f,g,h);

if(i==1)
{
response.sendRedirect("../userlog.html");
}
else
{
response.sendRedirect("../userregister.html");
}
%>