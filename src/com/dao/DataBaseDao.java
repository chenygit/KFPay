package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseDao 
{
	 private final String DriverName="com.mysql.jdbc.Driver";
	 private final String URL = "jdbc:mysql://localhost:8808/kfxpaydb";
	 private final String userName = "root";
	 private final String PassWord = "kfxcheny";
	 private Connection conn=null;
	 private PreparedStatement ps=null;
	 private ResultSet rs=null;
	 private Connection getConnection() 
	           {
	             try {
	        	     Class.forName(DriverName).newInstance();
	                 conn = DriverManager.getConnection(URL, userName, PassWord);
	                } 
	              catch (Exception e) 
	                     {
	            	       System.out.println("yyyyyyy");
	                       e.printStackTrace();
	                     } 
	              return conn;
	        }
	 
	 public void updateDate(List<String> strSqlL) throws SQLException 
	             {
		           conn=getConnection();
		          
		           try {
		        	   conn.setAutoCommit(false);
		        	   for(String str:strSqlL)
		        	    {
			              ps=conn.prepareStatement(str);
			              ps.executeUpdate();
		        	     }
					   conn.commit();
				     } 
		           catch (SQLException e) 
		                {
					      conn.rollback();
				        }
		           finally
		               {
		                  if(ps!=null)
		        	         ps.close();
		               }
	             }
	 public Object getQueryList(String strSql, List<String> showFields) throws Exception
	               {
		               List<Object> li=new ArrayList<Object>();
		               Map m=null;
		               conn=getConnection();
			           ps=conn.prepareStatement(strSql);
			           rs=ps.executeQuery();
			           while(rs.next())
			                 {
			            	   m=new HashMap();
			            	    for(String str:showFields)
			            	    	 m.put(str, rs.getString(str));
			            	     li.add(m);
			                 }
		                  if(ps!=null)
		        	         ps.close();
		               return li;
	               }
}
