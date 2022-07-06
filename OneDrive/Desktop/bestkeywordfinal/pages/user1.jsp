<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<jsp:useBean id="obj1" class="keyword.FindKNN"/>
<%@page import="java.sql.*"%>
<%
String a=request.getParameter("places");
session.setAttribute("start",a);
String b=request.getParameter("latt");
session.setAttribute("latt1",b);
String c=request.getParameter("long");
session.setAttribute("lon1",c);
String d=request.getParameter("keynames");
int count=obj1.count(b,c,d);
if(count!=0)
{
		 String last=obj1.last();
		 System.out.println(" last   ****** "+last);
		 session.setAttribute("end",last);
		 response.sendRedirect("index.jsp");
		 
}else
{
%>
<html>

<head>
<script>alert("enter the keyword related to hotels");
window.location="../usersearch.html";
</script>
</head>

</html>
<%

}


%>