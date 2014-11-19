<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>孔方宝功能测试</title>
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/kfbtest.js"></script>

</head>
<body>
<!-- 孔方宝充值提现 -->
账户充值
<br/>
账户余额:<span id="haveMoney"></span>
<br/>
账号:<select id="pushMoney">
</select>
金额：<input id="moneyTxt" type="text" value=""/>
银行卡号：<input id="cardNoTxt" type="text" value=""/>
<input class="addGetMoney" id="addMoneyBtn" type="button" exchangeType="1" value="充值"/>
<input class="addGetMoney" id="getMomenyBtn" type="button" exchangeType="2" value="提现"/>
<hr/>
<!--孔方宝计算收益-->
<input type="button" value="查看收益">
<br/>
今日获得的收益:<span id="makeMomeny"></span>

</body>
</html>