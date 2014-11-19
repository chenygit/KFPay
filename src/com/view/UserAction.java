package com.view;

import java.util.ArrayList;
import java.util.List;

import com.control.UserControl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport 
{
	private int userId=-1;
	private double money=0;
	private String json = "";
	private int exchangeType=0;
	private String cardNo;
	public int getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(int exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserList() throws Exception {
		UserControl uc=new UserControl();
		json=uc.getUserList(userId);
		return "getUserList";
	}

	public String addGetMoney() throws Exception
	{
		UserControl uc=new UserControl();
		json=uc.addGetMoney(userId,money,exchangeType,cardNo);
		return "addGetMoney";
	}
	
}
