/**
 * 页面加载
 */
$(function(){
    var postData="";
    var json=null;
	var insertHtml="";
		$.ajax({
			  type: 'POST',
			  url: "com/getUserList",
			  success: function(data){
				  json=eval("("+data+")");
				  for(var i=0;i<json.length;i++)
					  {
					    insertHtml+="<option value=\""+json[i].id+"\">";
					    insertHtml+=json[i].account+"</option>";
					  }
				  $("#pushMoney").html(insertHtml);
				  for(var i=0;i<json.length;i++)
					  {
					    if($("#pushMoney option:selected").val()==json[i].id)
					    	{
					    	  $("#haveMoney").text(json[i].amount);
					    	  break;
					    	}
					  }
			  }
		});
	
$("#pushMoney").change(function(){
	postData="userId="+$("#pushMoney option:selected").val();
	$.ajax({
		  type: 'POST',
		  url: "com/getUserList",
		  data: postData,
		  success: function(data){
			  json=eval("("+data+")");
			  $("#haveMoney").text(json[0].amount);
		  }
	});
	
});
		
/**
 * 充值
 */
$(".addGetMoney").click(function(){
	postData="userId="+$("#pushMoney option:selected").val();
	postData+="&money="+$("#moneyTxt").val().trim();
	postData+="&exchangeType="+$(this).attr("exchangeType");
	postData+="&cardNo="+$("#cardNoTxt").val().trim();
	$.ajax({
		  type: 'POST',
		  url: "com/addGetMoney",
		  data: postData,
		  success: function(data){
			  json=eval("("+data+")");
			  $("#haveMoney").text(json[0].amount);
		  }
	});	 
})
		
		
});