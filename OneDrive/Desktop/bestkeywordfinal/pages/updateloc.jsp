<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<%@page import="java.sql.*"%>
<%
String a=request.getParameter("places");
String b=request.getParameter("location");
String c=request.getParameter("keynames");
String d=request.getParameter("bar");
String e=request.getParameter("rooms");
String f=request.getParameter("restaurant");
String g=request.getParameter("latt");
String h=request.getParameter("long");
String l=request.getParameter("Stars");
System.out.println(a);
System.out.println(b);
System.out.println(d);
System.out.println(e);
System.out.println(f);


 int j=obj.insert1(a,d,f,e,g,h);
 int i=obj.insert2(b,c,a,l);



if(i==1&&j==1)
{
response.sendRedirect("../updatelocation.html");
}
else
{
%>
<html>
<script>
   alert("uploading failed");
   </script>
   </html>
   <%
}
%>