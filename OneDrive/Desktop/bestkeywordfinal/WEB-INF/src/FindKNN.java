
package keyword;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class FindKNN {
	 
	static Dbconnect db=new Dbconnect();
	static String[][]	base1=null;
	static String[][]	base2=null;
	ArrayList output=new ArrayList();
	
	
	
	public static void main(String[] args) {}




	public int count(String ps, String ks, String ns) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ArrayList<String> Link=new ArrayList<>();
		ArrayList<String> hotel=new ArrayList<>();
		
		double  latitude=Double.parseDouble(ps);
		
		double  longitude=Double.parseDouble(ks);
		
		double totalsum=latitude+longitude;
		
		System.out.println("totalsum ="+totalsum);
		
		String a=ns;
		
		String[] keywords={"bar","rooms","room","restaurant"};
		
		String delims = "[ ?!;: ,]+";
		
		String[] splitStr1 =a.split(delims);
		
		for(int i=0;i<splitStr1.length;i++)
		{
			
			System.out.println(splitStr1[i]);
			for(int j=0;j<keywords.length;j++)
			{
			if(keywords[j].equals(splitStr1[i]))
			{
				Link.add(splitStr1[i]);
				System.out.println(splitStr1[i]);
			}
			}
		}
		for(int i=0;i<Link.size();i++)
		{
			System.out.println(Link.get(i));
		}
		
		if(Link.size()!=0)
		{
		int width1=db.Findwidth();
		int width=width1-2;
		int height=db.Findheight();
		
		String[][] Matrix=new String[height][width];
		


		
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				if(j==0){
					Matrix[i][j]=db.findElement(i+1,j+1);
			      }else if(j==width-1)
			      {
			    		Matrix[i][j]=" ";	  
			      }else
			      {
			    		String find=db.findElement(i+1,j+1); 
			    		if(find.equals("yes"))
			    		{
			    			Matrix[i][j]="1";	
			    		}else
			    		{
			    			Matrix[i][j]="0";	
			    		}
			      }
				
				System.out.println("matrix ["+i+"]["+j+"] ="+Matrix[i][j]);
			}
			
		}
		
		
		
		for(int i1=0;i1<Link.size();i1++)
		{
			
			Matrix=new String[height][width];
			


			
			for(int i=0;i<height;i++)
			{
				for(int j=0;j<width;j++)
				{
					if(j==0){
						Matrix[i][j]=db.findElement(i+1,j+1);
				      }else if(j==width-1)
				      {
				    		Matrix[i][j]=" ";	  
				      }else
				      {
				    		String find=db.findElement(i+1,j+1); 
				    		if(find.equals("yes"))
				    		{
				    			Matrix[i][j]="1";	
				    		}else
				    		{
				    			Matrix[i][j]="0";	
				    		}
				      }
					
					System.out.println("matrix ["+i+"]["+j+"] ="+Matrix[i][j]);
				}
				
			}
			
			
			
			
			int count=0;
			System.out.println("links =="+Link.get(i1));
			int mpos=db.findposition(Link.get(i1));
			System.out.println("mpos ="+mpos);
			for(int j=0;j<height;j++)
			{
		
				if(Matrix[j][mpos-2].equals("0"))
						{
					
					       Matrix[j][0]="0";
					       count++;
						}
			}
			for(int i=0;i<height;i++)
			{
				for(int j=0;j<width;j++)
				{
					System.out.println("matrix ["+i+"]["+j+"] ="+Matrix[i][j]);	
				}
				
			}
			System.out.println("count ="+count);
			int newheight=height-count;
			System.out.println("new height ="+newheight);
			String[][] base=new String[newheight][width];
			int ls=0;
			for(int i=0;i<height;i++)
			{
				if(!Matrix[i][0].equals("0"))
				{
				for(int j=0;j<width;j++)
				{
				    base[ls][j]=Matrix[i][j];
				}
				ls++;
				}
				
			}
			
			
			for(int i=0;i<newheight;i++)
			{
				for(int j=0;j<width;j++)
				{
					if(j==0)
					{
						System.out.println("base ["+i+"]["+j+"] ="+base[i][j]);
						ArrayList<String> li=db.findValues(base[i][j]);
						
						double lat1= Double.parseDouble(li.get(0));
						double lon1= Double.parseDouble(li.get(1));
						
						System.out.println("lat1 ="+lat1);
						
						System.out.println("lon1 ="+lon1);
						double totalsum1=lat1+lon1;
						
						double totalsum2;
						
						if(totalsum > totalsum1)
						{
							totalsum2=totalsum-totalsum1;
						}else
						{
							totalsum2=totalsum1-totalsum;
						}
						
						base[i][width-1]=Double.toString(totalsum2);
						System.out.println("totalsum ="+totalsum1);
					}
				}
				
			}
			
			
			
			for(int i=0;i<newheight;i++)
			{
				for(int j=0;j<width;j++)
				{
					System.out.println("Completebase ["+i+"]["+j+"] ="+base[i][j]);
				}
			}
			int p=0;
			for(int i2=0;i2<Link.size();i2++)
			{
				if(!Link.get(i2).equals(Link.get(i1)))
			{
				if(p==0)
				{
				System.out.println("link1"+Link.get(i1));
				System.out.println("link2"+Link.get(i2));
				
					
				count=0;
				 mpos=db.findposition(Link.get(i2));
				for(int j=0;j<newheight;j++)
				{
			
					if(base[j][mpos-2].equals("0"))
							{
						
						       base[j][0]="0";
						       count++;
							}
				}
				for(int i=0;i<newheight;i++)
				{
					for(int j=0;j<width;j++)
					{
						System.out.println("matrix ["+i+"]["+j+"] ="+base[i][j]);	
					}
					
				}
				 System.out.println(newheight);
				 System.out.println(count);
				 int newheigh=newheight;
				 newheight=newheight-count;
				
		base1=new String[newheight][width];
				 ls=0;
				for(int i=0;i<newheigh;i++)
				{
					if(!base[i][0].equals("0"))
					{
					for(int j=0;j<width;j++)
					{
					    base1[ls][j]=base[i][j];
					}
					ls++;
					}
					
				}
				
				
				for(int i=0;i<newheight;i++)
				{
					for(int j=0;j<width;j++)
					{
						if(j==0)
						{
							System.out.println("base ["+i+"]["+j+"] ="+base1[i][j]);
							ArrayList<String> li=db.findValues(base1[i][j]);
							
							double lat1= Double.parseDouble(li.get(0));
							double lon1= Double.parseDouble(li.get(1));
							
							System.out.println("lat1 ="+lat1);
							
							System.out.println("lon1 ="+lon1);
							double totalsum1=lat1+lon1;
							
							double totalsum2;
							
							if(totalsum > totalsum1)
							{
								totalsum2=totalsum-totalsum1;
							}else
							{
								totalsum2=totalsum1-totalsum;
							}
							
							base1[i][width-1]=Double.toString(totalsum2);
							System.out.println("totalsum ="+totalsum1);
						}
					}
					
				}
				
				
				
				for(int i=0;i<newheight;i++)
				{
					for(int j=0;j<width;j++)
					{
						System.out.println("Completebase ["+i+"]["+j+"] ="+base1[i][j]);
					}
				}
				p++;	
			}
			
				if(p==1)
				{
					System.out.println("link1"+Link.get(i1));
					System.out.println("link2"+Link.get(i2));
					
						
					count=0;
					 mpos=db.findposition(Link.get(i2));
					for(int j=0;j<newheight;j++)
					{
				
						if(base1[j][mpos-2].equals("0"))
								{
							
							       base1[j][0]="0";
							       count++;
								}
					}
					for(int i=0;i<newheight;i++)
					{
						for(int j=0;j<width;j++)
						{
							System.out.println("matrix ["+i+"]["+j+"] ="+base1[i][j]);	
						}
						
					}
					 System.out.println(newheight);
					 System.out.println(count);
					 int newheigh=newheight;
					 newheight=newheight-count;
					
				base2=new String[newheight][width];
					 ls=0;
					for(int i=0;i<newheigh;i++)
					{
						if(!base1[i][0].equals("0"))
						{
						for(int j=0;j<width;j++)
						{
						    base2[ls][j]=base1[i][j];
						}
						ls++;
						}
						
					}
					
					
					for(int i=0;i<newheight;i++)
					{
						for(int j=0;j<width;j++)
						{
							if(j==0)
							{
								System.out.println("base ["+i+"]["+j+"] ="+base2[i][j]);
								ArrayList<String> li=db.findValues(base2[i][j]);
								
								double lat1= Double.parseDouble(li.get(0));
								double lon1= Double.parseDouble(li.get(1));
								
								System.out.println("lat1 ="+lat1);
								
								System.out.println("lon1 ="+lon1);
								double totalsum1=lat1+lon1;
								
								double totalsum2;
								
								if(totalsum > totalsum1)
								{
									totalsum2=totalsum-totalsum1;
								}else
								{
									totalsum2=totalsum1-totalsum;
								}
								
								base2[i][width-1]=Double.toString(totalsum2);
								System.out.println("totalsum ="+totalsum1);
							}
						}
						
					}
					
					
					
					for(int i=0;i<newheight;i++)
					{
						for(int j=0;j<width;j++)
						{
							System.out.println("Completebase ["+i+"]["+j+"] ="+base2[i][j]);
						}
					}
				}
				
				
			}
				
				
				
				
				
			}
			
			
			if(Link.size()==1)
			{System.out.println("sucessssssss");
				double[] find=new double[newheight];
				int p1=0;
				for(int k1=0;k1<newheight;k1++)
				{
					
						find[p1]=Double.parseDouble(base[k1][width-1]);
						System.out.println(find[p1]);
						p1++;
				}
				
				for(int k1=0;k1<find.length;k1++)
				{
					for(int s1=k1+1;s1<find.length;s1++)
				{
					if(find[s1]>find[k1])
					{
						double kk=find[k1];
						find[k1]=find[s1];
						find[s1]=kk;
					}
				}
				}
			String check=Double.toString(find[find.length-1]);
		
			for(int k1=0;k1<newheight;k1++)
			{
				if(base[k1][width-1].equals(check))
				{
					hotel.add(base[k1][0]);
					System.out.println(base[k1][0]);
				}
			}
			
				
			}else if(Link.size()==2)
			{
				System.out.println("sucess");
				double[] find=new double[newheight];
				int p1=0;
				for(int k1=0;k1<newheight;k1++)
				{
					
						find[p1]=Double.parseDouble(base1[k1][width-1]);
						System.out.println(find[p1]);
						p1++;
				}
				
				for(int k1=0;k1<find.length;k1++)
				{
					for(int s1=k1+1;s1<find.length;s1++)
				{
					if(find[s1]>find[k1])
					{
						double kk=find[k1];
						find[k1]=find[s1];
						find[s1]=kk;
					}
				}
				}
			String check=Double.toString(find[find.length-1]);
			System.out.println("check "+check);
			for(int k1=0;k1<newheight;k1++)
			{
				if(base1[k1][width-1].equals(check))
				{
					hotel.add(base1[k1][0]);
					System.out.println(base1[k1][0]);
				}
			}			
			
			}else
			{
				double[] find=new double[newheight];
				int p1=0;
				for(int k1=0;k1<newheight;k1++)
				{
					
						find[p1]=Double.parseDouble(base2[k1][width-1]);
						System.out.println(find[p1]);
						p1++;
				}
				
				for(int k1=0;k1<find.length;k1++)
				{
					for(int s1=k1+1;s1<find.length;s1++)
				{
					if(find[s1]>find[k1])
					{
						double kk=find[k1];
						find[k1]=find[s1];
						find[s1]=kk;
					}
				}
				}
			String check=Double.toString(find[find.length-1]);
		
			for(int k1=0;k1<newheight;k1++)
			{
				if(base2[k1][width-1].equals(check))
				{
					hotel.add(base2[k1][0]);
					System.out.println(base2[k1][0]);
				}
			}
			}
			
			
			
		}
		

		
		
		for(int i=0;i<hotel.size();i++)
		{
			int ch=0;
			for(int i1=0;i1<output.size();i1++)
			{
				if(output.get(i1).equals(hotel.get(i)))
				{
					ch=1;
				}
			}
			if(ch==0)
			{
				output.add(hotel.get(i));
			}
		}
		
		ArrayList Stars=new ArrayList();
        String[] sta=new String[output.size()];
		for(int i=0;i<output.size();i++)
		{
			System.out.println("output ="+output.get(i));
			String st=db.findStars(output.get(i).toString());
			System.out.println("stars ="+st);
			Stars.add(st);
			sta[i]=st;
			
		}
		
		
		for(int k1=0;k1<sta.length;k1++)
		{
			for(int s1=k1+1;s1<sta.length;s1++)
		{
			if(Integer.parseInt(sta[s1])>Integer.parseInt(sta[k1]))
			{
				String kk=sta[k1];
				sta[k1]=sta[s1];
				sta[s1]=kk;
			}
		}
		}
		
		
		
		String pos=sta[0];
		int posi=0;
		for(int i=0;i<Stars.size();i++)
		{
			if(pos.equals(Stars.get(i)))
			{
				posi=i;
				break;
			}
		}
		
		System.out.println("position ="+posi);
		System.out.println("position ="+output.get(posi));
		}
		return Link.size();

	}




	public String last() {
		// TODO Auto-generated method stub
		return (String) output.get(0);
	}

}
