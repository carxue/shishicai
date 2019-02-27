	/**
	 * JS收益计算器公共类
	 */
	Caluclate={
		//验证用户输入数据合法性方法
			validateReg:{
				//验证用户是否输入的为整数
				//当前验证用户的投资金额及投资期限
				RegAmountMoney:function RegAmountMoney(obj){
					if(/^[1-9]{1}[0-9]{0,5}$/.test($.trim(obj))){
						return true;
					}else if(/^[1-9]+[0-9]{0,5}[\.][\d]{1,2}$/.test($.trim(obj))){
						return true;
					}else{
						return false;	
					}
				},
				//验证浮点性数据
				//当前验证用户输入的收益率
				//当前收益率可以为0-20之间【不包括0和20】并且可以为小数【保证小数点后2位】
				RegDoubleNum:function RegDoubleNum(obj){
					if(!isNaN(parseInt(obj))){
						if(parseFloat(obj)>=0 && parseFloat(obj)<=100){
							return true;
						}
					}
					return false;
					/*if(/^[1-9]{1}$/.test($.trim(obj))){
						return true;
					}else if(/^[1]{1}[0-9]{1}$/.test($.trim(obj))){
						return true;
					}else if(/^([1-9]|1[0-9])[\.][0-9]{1,2}$/.test($.trim(obj))){
						return true;
					}else if(/^0[\.][0-9]{1,2}$/.test($.trim(obj))){
						return true;
					}else{
						return false;
					}*/
				},
				
				//验证投资天数
				RegInvestDays:function RegInvestDays(obj){
					if(/^[1-9]{1}[0-9]{0,5}$/.test($.trim(obj))){
						return true;
					}else{
						return false;
					}
				}
			},
			
			//显示输入错误提示信息
			//验证投资金额及投资期限【必须输入整数】
			validateInfo:{
				ValidateAmountMoney:function(obj){
						if($("#"+obj).val() =="" || null == $("#"+obj).val()){
							$("#"+obj).siblings("span[class='info']").attr("style","display:none");
							$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>请输入投资金额！");
							return false;
						}else{
							if(!Caluclate.validateReg.RegAmountMoney($("#"+obj).val())){
								$("#"+obj).siblings("span[class='info']").attr("style","display:none");
								$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>金额输入错误！");
								return false;
							}else{
								$("#"+obj).siblings("span[class='info']").show();
								$("#"+obj).siblings("span[class='info-box']").attr("class","").html("");
								return true;
							}
						}
				},
				//验证输入投资收益率
				//输入必须为0-20间的数值，如果为小数最多保留两位小数
				ValidateProfit:function(obj){
						if($("#"+obj).val() =="" || null == $("#"+obj).val()){
							$("#"+obj).siblings("span[class='info']").attr("style","display:none");
							$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>请输入投资收益率！");;
							return false;
						}else{
							if(!Caluclate.validateReg.RegDoubleNum($("#"+obj).val())){
								$("#"+obj).siblings("span[class='info']").attr("style","display:none");
								$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>值为0到100之间！");;
								return false;
							}else{
								$("#"+obj).siblings("span[class='info']").show();
								$("#"+obj).siblings("span").eq(1).attr("class","").html("");
								return true;
							}
						}
				},
				
				ValidateInvestDays:function(obj){
					if($("#"+obj).val() =="" || null == $("#"+obj).val()){
						$("#"+obj).siblings("span[class='info']").attr("style","display:none");
						$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>请输入投资期限！");
						return false;
					}else{
						if(!Caluclate.validateReg.RegInvestDays($("#"+obj).val())){
							$("#"+obj).siblings("span[class='info']").attr("style","display:none");
							$("#"+obj).siblings("span").eq(1).attr("class","info-box").html("<i class='ico-info ico-erro'></i>投资期限为正整数！");
							return false;
						}else{
							$("#"+obj).siblings("span[class='info']").show();
							$("#"+obj).siblings("span[class='info-box']").attr("class","").html("");
							return true;
						}
					}
				}
			},
			//收益计算类
			count:{
				CheckIsNaN:function(obj){
					return isNaN(obj);
				},
				
				//计算收益时有三个参数：invest-投资金额;profit-收益率;time-投资期限
				CaluclateProfit:function(invest,profit,time){
					var income = 0;
					income = (time/365)*(profit/100)*invest*10000;
					return income;
				},
				
				
				GetParseFloatAmountMoney:function(obj){
					if(Caluclate.validateReg.RegAmountMoney(obj)){
						return parseFloat(obj);
					}else{
						return 0;
					}
				},
				
				GetParseFloatProfit:function(obj){
					if(Caluclate.validateReg.RegDoubleNum(obj)){
						return parseFloat(obj);
					}else{
						return 0;
					}
				},
				
				//返回5位整数
				GetParseInt:function(obj){
					if(Caluclate.validateReg.RegInvestDays(obj)){
						return parseInt(obj);
					}else{
						return 0;
					}
				}
			},
			
			//JS对计算出来的收益及本金总和进行格式化
			formate:{
				formateMoney:function(s,n){
					   n = n > 0 && n <= 20 ? n : 2;  
					   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
					   var l = s.split(".")[0].split("").reverse(),  
					   r = s.split(".")[1];  
					   t = "";  
					   for(var i = 0; i < l.length; i ++ ){  
					      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
					   }  
					   return t.split("").reverse().join("") + "." + r;					
				}
			}
	};
	
	function resetCal(){
		$("#amountMoney").val("");
		$("#gains").val("");
		$("#deadline").val("");
//		$("#amountMoney ~ span[class='info']").attr("style","");
		$("#amountMoney").siblings("span[class='info']").removeAttr("style").text("万元");
		$("#amountMoney").siblings("span").eq(1).removeClass().html("");
		
//		$("#gains ~ span[class='info']").attr("style","");
		$("#gains").siblings("span[class='info']").removeAttr("style").text("%");
		$("#gains").siblings("span").eq(1).removeClass().html("");
		
//		$("#deadline ~ span[class='info']").attr("style","");
		$("#deadline").siblings("span[class='info']").removeAttr("style").text("天");
		$("#deadline").siblings("span").eq(1).removeClass().html("");
		
		
		$("#hope_gains").html("<strong class=\"price\">0<\/strong>元");
		$("#invest_gains").html("<strong  class=\"price\">0<\/strong>元");
	}
	
	$(function(){
		//显示收益计算器
		$("#caculateBox").click(function() {
			$("#bgMask").show();
			$("#d-caluclate").show();
		});
		
		//关闭收益计算器
		$("#closecal").click(function(){
			resetCal();
			$("#d-caluclate").hide();
			$("#bgMask").hide();
		});
		
//		Caluclate.validateInfo.ValidateInputIntValue("amountMoney");
//		Caluclate.validateInfo.ValidateInputIntValue("deadline");
//		Caluclate.validateInfo.ValidateDoubleValue("gains");
		
		//对收益计算器进行重置
		$("#reset").click(function(){
			resetCal();
		});
		
		$('#amountMoney').change(function(){
			var obj = /^-*\d+(($)|(\.\d+$))/;
			var amount = $('#amountMoney').val();
			if(!obj.test(amount)){
				Util.window.Alert(null,"投资金额必须为数字！","确定");
				$('#amountMoney').val('');
				$('#amountMoney').focus();
				return;
			}
			if(parseInt(amount.substring(0,1))==0){
				Util.window.Alert(null,"投资金额额度首位必须大于0！","确定");
				$('#amountMoney').val('');
				$('#amountMoney').focus();
				return;
			}
			var point = amount.indexOf('.');
			var len = amount.length;
			if((len-point-1)>2&&point!=-1){
				$('#amountMoney').val(amount.substring(0,point+3));
			}else if(point==-1){
				$('#amountMoney').val(amount+'.00');
			}else if((len-point-1)==1&&point!=-1){
				$('#amountMoney').val(amount+'0');
			}
		});
		//计算收益
		$("#cal_gains").click(function(){
			
			if(Caluclate.validateInfo.ValidateAmountMoney("amountMoney")
					&& Caluclate.validateInfo.ValidateProfit("gains")
					&& Caluclate.validateInfo.ValidateInvestDays("deadline")){
				
				var invest = Caluclate.count.GetParseFloatAmountMoney($("#amountMoney").val());
				var profit = Caluclate.count.GetParseFloatProfit($("#gains").val());
				var time = Caluclate.count.GetParseInt($("#deadline").val());
				
				var result = Caluclate.count.CaluclateProfit(invest, profit, time);
				var sum = invest*10000 + result;
				$("#hope_gains").html("<strong class=\"price\">"+Caluclate.formate.formateMoney(result,2)+"<\/strong>元");
				$("#invest_gains").html("<strong  class=\"price\">"+Caluclate.formate.formateMoney(sum,2)+"<\/strong>元");
			}else{
				return false;
			}
		});
	});
