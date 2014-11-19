package com.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import com.dao.DataBaseDao;

public class UserControl {
private DataBaseDao dbd=new DataBaseDao(); 
private JSONArray jary=new JSONArray();
public String getUserList(int userId) throws Exception
   {
	    String strSql="select a.id,a.account,b.amount from user_tb ";
		strSql+=" a join useramount_tb b on a.id=b.userId";
		if(userId!=-1)
			strSql+=" where a.id="+userId;
		List<String> li=new ArrayList<String>();
		li.add("amount");
		li.add("account");
		li.add("id");
		Object objNew=dbd.getQueryList(strSql,li);
		return jary.fromObject(objNew).toString();
    }
 
 public String addGetMoney(int userId,double money,int exchangeType,String cardNo) throws Exception
   {
	 List<String> strSqlL=new ArrayList<String>();
	 String strSql="update useramount_tb set";
	 if(exchangeType==1)
	 strSql+=" amount=amount+"+money;
	 else
	 strSql+=" amount=amount-"+money;	 
	 strSql+=" where userId="+userId;
	 if(exchangeType==2)
		 strSql+=" and amount>="+money;
	 strSqlL.add(strSql);
	 strSql="insert into exchange_tb(";
	 strSql+="exchangeUserId,exchangeType,";
	 strSql+="exchangeAmount,cardNum,";
	 strSql+="exchangeTime)";
	 strSql+=" values("+userId;
	 strSql+=" ,"+exchangeType+",";
	 strSql+=money+",'"+cardNo+"',now());";
	 strSqlL.add(strSql);
	 dbd.updateDate(strSqlL);
	 System.out.println("strSql:"+strSql);
	 strSql="select amount from useramount_tb";
	 strSql+=" where userId="+userId;
	 List<String> li=new ArrayList<String>();
	 li.add("amount");
	 Object objNew=dbd.getQueryList(strSql,li);
	 return jary.fromObject(objNew).toString();
   }


}
