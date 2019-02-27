/**
 * 
 */


/**
 * 
 */


function validateForm(formObj) {
	var fields = formObj.serializeArray();
	for (var i = 0; i < fields.length; i++) {
		var f = fields[i];
		/** **/
		// 验证textarea
		var textarea = $("textarea[name='" + f.name + "']");
		
		if (textarea.attr("validate") == "notNull" && $.trim(f.value) == "") {
			Util.window.Alert(null,textarea.attr("desc") + "\u4e0d\u80fd\u4e3a\u7a7a！",null,null,null);
			textarea[0].focus();
			return false;
		}
		
		// 验证select
		var select = $("select[name='" + f.name + "']");
		if (select.attr("validate") == "notNull" && $.trim(f.value) == "") {
			Util.window.Alert(null,textarea.attr("desc") + "\u4e0d\u80fd\u4e3a\u7a7a！",null,null,null);
			select[0].focus();
			return false;
		}		
		
		// 验证input
		var input = $("input[name='" + f.name + "']");
		if (!input.attr("validate")) continue;
		var v = input.attr("validate").split(",");
		for (var j = 0; j < v.length; j++) {
		     //控制输入框里不能录入脚本
		    var reg_noscript=new RegExp("<.*?script[^>]*?>.*?(<\/.*?script.*?>)*","ig");
		    if(f.value!=""&&reg_noscript.test($.trim(f.value))){
		    	Util.window.Alert(null,input.attr("desc") + "不能输入script脚本!",null,null,null);
		        input[0].focus();
		        return false;
		    }
		    //1.验证非空
			if (v[j] == "notNull" && $.trim(f.value) == "") {
				Util.window.Alert(null,input.attr("desc") + "\u4e0d\u80fd\u4e3a\u7a7a！",null,null,null);
				input[0].focus();
				return false;
			}
			
			if ($.trim(f.value) == "") break;
			//2.只能输入整形数字		
			if (v[j] == "number" && !/^\d+$/.test($.trim(f.value))) {
				Util.window.Alert(null,input.attr("desc") + "\u5fc5\u987b\u4e3a\u6574\u6570！",null,null,null);
				input[0].focus();
				return false;
			}
			//3.验证浮点型
			if (v[j] == "double" && !/^\d+((\.?\d+)|(\d*))$/.test($.trim(f.value))) {
				Util.window.Alert(null,input.attr("desc") + "\u5fc5\u987b\u4e3a\u6574\u6570！",null,null,null);
				input[0].focus();
				return false;
			}
			//4.验证时间类型yyyy-MM-dd
			if (v[j] == "date" && !/^\d{4}\-\d{2}\-\d{2}$/.test($.trim(f.value))) {
				Util.window.Alert(null,input.attr("desc") + "\u5fc5\u987b\u4e3a\u683c\u5f0fyyyy-MM-dd,\u59822012-12-01！",null,null,null);
				input[0].focus();
				return false;
			}
			//5.金额（包含正数或负数）
			if(v[j] =="money" && !/^(-[0-9]|[0-9]|(0[.])|(-(0[.])))[0-9]{0,}(([.]*\d{1,2})|[0-9]{0,})$/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//6.验证电子邮件
			if(v[j] =="email" && !/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//7.验证固定电话号码
			if(v[j] =="telephone" && !/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}		
			//8.验证移动电话号码
			if(v[j] =="mobile" && !/^((13[0-9])|(14[0-9])|(15[^4,\D])|(18[0,1,2,3,5-9]))\d{8}$/.test($.trim(f.value))){
				 //alert(input.attr("desc") + "\u5fc5\u987b\u4e3a\u6574\u6570！");
//				 alert(input.attr("desc") + "格式不正确！");
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//9.验证邮编
			if(v[j] =="postcode" && !/^\d{6}$/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//10.中文字符
			if(v[j] =="chinese" && !/^\d{6}$/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//11.验证网址
			var strRegex = "^((https|http|ftp|rtsp|mms)?://)" 
			    + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@ 
			          + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
			          + "|" // 允许IP和DOMAIN（域名）
			          + "([0-9a-z_!~*'()-]+\.)*" // 域名- www. 
			          + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名 
			          + "[a-z]{2,6})" // first level domain- .com or .museum 
			          + "(:[0-9]{1,4})?" // 端口- :80 
			          + "((/?)|" // a slash isn't required if there is no file name 
			          + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
			var re=new RegExp(strRegex); 
			if(v[j] =="url" && !re.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！匹配例子:http://www.wyxg.com",null,null,null);
				input[0].focus();
				return false;
			}
			//12.验证QQ号[5-11位数字]
			if(v[j] =="qq" && !/[0-9]{5,11}/.text($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				 input[0].focus();
				 return false;
			}
			//12.验证身份证号
			if(v[j] =="idcard" && !/^[1-9]([0-9]{16}|[0-9]{13})[xX0-9]$/.text($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！",null,null,null);
				input[0].focus();
				return false;
			}
			//13.验证IP
			if(v[j]=="ip" && !/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/.test($.trim(f.value))){
				Util.window.Alert(null,input.attr("desc") + "格式不正确！匹配例子:192.168.0.1",null,null,null);
				input[0].focus();
				return false;
			}		
		}
	}
	return true;
}


