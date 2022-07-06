package keyword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Dbconnect
{
 Connection con=null;
 PreparedStatement ps=null;
 ResultSet rs=null;
 
 public Dbconnect()
 {
  try
  {
   Class.forName("com.mysql.jdbc.Driver");
   con=DriverManager.getConnection("jdbc:mysql://localhost/keywordsearch","root","");
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
 }

 
 public int insert(String username,String firstname,String lastname,String password,String gender,String dob,String email,String phone)
 {
  int i=0;
  try
  {
   ps=con.prepareStatement("insert into register(username,firstname,lastname,password,gender,dob,email,phone)values(?,?,?,?,?,?,?,?)");
   ps.setString(1,username);
   ps.setString(2,firstname);
   ps.setString(3,lastname);
   ps.setString(4,password);
    ps.setString(5,gender);
   ps.setString(6,dob);
    ps.setString(7,email);
	ps.setString(8,phone);
	System.out.println(ps);
   i=ps.executeUpdate();
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return i;
 }

 
 public int insert1(String places,String bar,String restaurant,String rooms,String latt,String long1)
 {
  int j=0;
  try
  {
   ps=con.prepareStatement("insert into hotels(hotelname,bar,restaurant,rooms,latitude,longitude)values(?,?,?,?,?,?)");
   ps.setString(1,places);
   ps.setString(2,bar);
   ps.setString(3,restaurant);
   ps.setString(4,rooms);
    ps.setString(5,latt);
   ps.setString(6,long1);
 
	System.out.println(ps);
   j=ps.executeUpdate();
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return j;
 }
 
 public int insert2(String location,String keynames,String places,String st)
 {
  int j=0;
  try
  {
   ps=con.prepareStatement("insert into locationdetail(location,keynames,star,fid)values(?,?,?,(select id from hotels where hotelname=?))");
   ps.setString(1,location);
   ps.setString(2,keynames);
   ps.setString(3,st);
     ps.setString(4,places);
	System.out.println(ps);
   j=ps.executeUpdate();
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return j;
 }
 
 public ResultSet selectuser()
 {

  try
  {
   ps=con.prepareStatement("select * from register");
    rs=ps.executeQuery();
   
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return rs;
 }
 
  
 public int select(String x,String y)
 {
  int m=0;
  try
  {
   ps=con.prepareStatement("select * from register where username=? and password=?");
 ps.setString(1,x);
 ps.setString(2,y);
   rs=ps.executeQuery();
   while(rs.next())
   {
    System.out.println(rs.getString(2));
    System.out.println(rs.getString(5));
    m=1;
   }
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return m;
 }
 
 
 
 public int select1(String x,String y)
 {
  int m=0;
  try
  {
   ps=con.prepareStatement("select * from admin where username=? and password=?");
 ps.setString(1,x);
 ps.setString(2,y);
   rs=ps.executeQuery();
   while(rs.next())
   {
    System.out.println(rs.getString(2));
    System.out.println(rs.getString(3));
    m=1;
   }
  }
  catch(Exception e)
  {
   System.out.println(e);
  }
  return m;
 }
 
 public int Findwidth() {
		// TODO Auto-generated method stub
		int k=0;
		try
		  {
			ps=con.prepareStatement("desc hotels");
			rs=ps.executeQuery();
			while(rs.next())
			{
				k++;
			}
		  }
		  catch(Exception e)
		  {
		   System.out.println(e);
		  }
		  return k;
	}

	public int Findheight() {
		// TODO Auto-generated method stub
		int k=0;
		try
		  {
			ps=con.prepareStatement("select * from hotels");
			rs=ps.executeQuery();
			while(rs.next())
			{
				k++;
			}
		  }
		  catch(Exception e)
		  {
		   System.out.println(e);
		  }
		  return k;
	}

	public String findElement(int i, int j) {
		// TODO Auto-generated method stub
		String k=null;
		int l=1;
		try
		  {
			ps=con.prepareStatement("select * from hotels");
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(l==i)
				{
					k=rs.getString(j+1);
				}
				l++;
			}
		  }
		  catch(Exception e)
		  {
		   System.out.println(e);
		  }
		  return k;
	}

	public int findposition(String string) {
		// TODO Auto-generated method stub
		int k=1;
		int j=0;
		try
		  {
			ps=con.prepareStatement("desc hotels");
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(string.equals(rs.getString(1)))
				{
					j=k;
				}
				k++;
			}
		  }
		  catch(Exception e)
		  {
		   System.out.println(e);
		  }
		  return j;
	}

	public ArrayList<String> findValues(String string) {
		// TODO Auto-generated method stub
	ArrayList<String> k=new ArrayList();
		
		try
		  {
			ps=con.prepareStatement("select * from hotels where hotelname=?");
			ps.setString(1, string);
			rs=ps.executeQuery();
			while(rs.next())
			{System.out.println("1 "+rs.getString(6));
			System.out.println("2 "+rs.getString(7));
				k.add(rs.getString(6));
				k.add(rs.getString(7));
			}
		  }
		  catch(Exception e){
			  
		   System.out.println(e);
		  }
		  return k;
	}

	

	public String findStars(String string) {
		// TODO Auto-generated method stub
		String k=null;
		try
		  {
			ps=con.prepareStatement("select * from locationdetail where fid=(select id from hotels where hotelname=?)");
			ps.setString(1, string);
			rs=ps.executeQuery();
			while(rs.next())
			{
				k=rs.getString(4);
			}
		  }
		  catch(Exception e){
			  
		   System.out.println(e);
		  }
		  return k;
	}

public ResultSet Find(String last) {
		// TODO Auto-generated method stub
		try
		  {
			ps=con.prepareStatement("select * from hotels inner join locationdetail on hotels.id=locationdetail.fid where hotelname=?");
			ps.setString(1, last);
			rs=ps.executeQuery();
			
		  }
		  catch(Exception e){
			  
		   System.out.println(e);
		  }
		return rs;
	}

public ResultSet Findefg() {
		// TODO Auto-generated method stub
		try
		  {
			ps=con.prepareStatement("select * from efg");
			
			rs=ps.executeQuery();
			
		  }
		  catch(Exception e){
			  
		   System.out.println(e);
		  }
		return rs;
	}
}
