package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dao.DataBaseDao;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     DataBaseDao dbd=new DataBaseDao();
     List<String> showLi=new ArrayList<String>();
     showLi.add("account");
     showLi.add("psssword");
     showLi.add("befLogTime");
     Object ObjNew=dbd.getQueryList("select * from user_tb", showLi);
     JSONArray jsonObj=new JSONArray();
     Object json=jsonObj.fromObject(ObjNew);
     System.out.println(json.toString());
     
     
     //dbd.updateDate("update user_tb set befLogTime='2014-10-20 10:18:00' where id=1");
     
     
	}

}
