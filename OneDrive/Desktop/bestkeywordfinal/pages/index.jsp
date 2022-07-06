<jsp:useBean id="obj" class="keyword.Dbconnect"/>
<jsp:useBean id="obj1" class="keyword.FindKNN"/>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<%
String start=(String)session.getAttribute("start");

String latt1=(String)session.getAttribute("latt1");


String lon1=(String)session.getAttribute("lon1");

String end1=(String)session.getAttribute("end");
String lon2=null;
		String latt2=null;
		String det=null;
		
ResultSet rs=obj.Find(end1);
		try {
			while(rs.next())
			{
				latt2=rs.getString(6);
				lon2=rs.getString(7);
				det =rs.getString(10);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

System.out.println(start);
System.out.println(latt1);
System.out.println(lon1);
System.out.println(end1);
%>
<!DOCTYPE html>
<html>
<head>
<script
src="http://maps.googleapis.com/maps/api/js">
</script>

<script>
var myCenter=new google.maps.LatLng(<%=latt2%>,<%=lon2%>);

function initialize()
{
var mapProp = {
  center:myCenter,
  zoom:25,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker=new google.maps.Marker({
  position:myCenter,
  });

marker.setMap(map);

var infowindow = new google.maps.InfoWindow({
  content:"<%=det%>"
  });

infowindow.open(map,marker);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

<body>
<div id="googleMap" style="width:1000px;height:500px;"></div>
</body>
</html>
