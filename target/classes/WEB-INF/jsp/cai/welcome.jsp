<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Xgame</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
<style type="text/css">
.tr1 {
	background-color: #FF8C69;
	height: 40px;
	font-size: 16;
	font-weight:700;
	font-family:"Helvetica Neue", Helvetica, Arial, sans-serif;
}
td {
	width: 80px;
	height: 30px;
	text-align: center;
}
td[trname="third"] {
color:yellow;
}
td[trname="five"] {
color:red;
}



</style>
</head>
<body>
	<form id="queryCaiList" action="${ctx}/cai/welcome" method="POST">
		<input type="hidden" name="queryDay" value="${queryDay}" />
		<div align="center">
			<a id="preDay" href="javascript:void(0);">上一页</a>&nbsp;&nbsp;&nbsp;<a
				id="todayDay" href="javascript:void(0);">今天</a>&nbsp;&nbsp;&nbsp;<a
				id="nextDay" href="javascript:void(0);">下一页</a>
		</div>
	</form>
	<div align="center">
		<table id="myCaiTable" border="1px solid #dddddd"
			style="border-collapse: collapse; border-spacing: 0;">
			<tr class="tr1">
				<td width="150px">日期-排序号</td>
				<td width="80px">号码</td>
				<td trname="third">前三</td>
				<td>万千十</td>
				<td>万千个</td>
				<td>万百十</td>
				<td>万百个</td>
				<td>万十个</td>
				<td trname="third">中三</td>
				<td>千百个</td>
				<td>千十个</td>
				<td trname="third">后三</td>
				<td trname="five">组五</td>
			</tr>
			<c:forEach items="${caiList}" var="cai">
				<tr>
					<td style="background-color: #FF8C69;">${cai.openDate}-${cai.sortNo}</td>
					<td style="background-color: #FF8C69;">${cai.openNum}</td>
					<c:if test="${cai.zuThirdPosition123=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition123}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition123=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition123}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition123=='组六'}">
						<td>${cai.zuThirdPosition123}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition124=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition124}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition124=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition124}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition124=='组六'}">
						<td>${cai.zuThirdPosition124}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition125=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition125}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition125=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition125}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition125=='组六'}">
						<td>${cai.zuThirdPosition125}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition134=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition134}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition134=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition134}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition134=='组六'}">
						<td>${cai.zuThirdPosition134}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition135=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition135}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition135=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition135}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition135=='组六'}">
						<td>${cai.zuThirdPosition135}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition145=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition145}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition145=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition145}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition145=='组六'}">
						<td>${cai.zuThirdPosition145}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition234=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition234}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition234=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition234}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition234=='组六'}">
						<td>${cai.zuThirdPosition234}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition235=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition235}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition235=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition235}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition235=='组六'}">
						<td>${cai.zuThirdPosition235}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition245=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition245}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition245=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition245}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition245=='组六'}">
						<td>${cai.zuThirdPosition245}</td>
					</c:if>
					<c:if test="${cai.zuThirdPosition345=='组三'}">
						<td style="background-color: yellow;"><font color="red">${cai.zuThirdPosition345}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition345=='豹子'}">
						<td style="background-color: red;"><font color="blue">${cai.zuThirdPosition345}<font></td>
					</c:if>
					<c:if test="${cai.zuThirdPosition345=='组六'}">
						<td>${cai.zuThirdPosition345}</td>
					</c:if>
					<c:if test="${cai.zuFive!='组60'}">
						<c:if test="${cai.zuFive=='组120'}">
							<td><font color="blue">${cai.zuFive}<font></td>
						</c:if>
						<c:if test="${cai.zuFive!='组120'}">
							<td><font color="red">${cai.zuFive}<font></td>
						</c:if>
					</c:if>
					<c:if test="${cai.zuFive=='组60'}">
						<td>${cai.zuFive}</td>
					</c:if>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('#preDay').click(function() {
			var day = $('input[name=queryDay]').val();
			var preDay = dataChange(numberToString(day), -1);
			$('input[name=queryDay]').val(preDay);
			$('#queryCaiList').submit();
		});
		$('#nextDay').click(function() {
			var day = $('input[name=queryDay]').val();
			var nextDay = dataChange(numberToString(day), 1);
			$('input[name=queryDay]').val(nextDay);
			$('#queryCaiList').submit();
		});
		$('#todayDay').click(function() {
			$('input[name=queryDay]').val('');
			$('#queryCaiList').submit();
		});

		/* var context = '${ctx}';
		debugger;
		$.ajax({
			url : 'cai/v1/xday/cai/list',
			data : {
				"openDate" : 20181122
			},
			type : 'POST',
			dataType : 'json',
			success : function(retData) {
				debugger;
				if (retData.code == '0') {
					alert(retData);
					var caidata = retData.data;
					var tr = '';
					for (var i = 0; i < caidata.length; i++) {
						var cai = caidata[0];
						tr += '<td>' + cai.openDate + '</td><td>' + cai.sortNo
								+ '</td><td>' + cai.openNum + '</td><td>'
								+ cai.zuThirdPosition123 + '</td><td>'
								+ cai.zuThirdPosition124 + '</td><td>'
								+ cai.zuThirdPosition125 + '</td>' + '<td>'
								+ cai.zuThirdPosition134 + '</td><td>'
								+ cai.zuThirdPosition135 + '</td><td>'
								+ cai.zuThirdPosition145 + '</td><td>'
								+ cai.zuThirdPosition234 + '</td><td>'
								+ cai.zuThirdPosition235 + '</td><td>'
								+ cai.zuThirdPosition245 + '</td>' + '<td>'
								+ cai.zuThirdPosition345 + '</td><td>'
								+ cai.zuFive + '</td>';
					}
					$('#myCaiTable tr:gt(0)').remove();
					$('#myCaiTable tr:eq(0)').append(tr);
				}
			}
		}); */
	});

	function numberToString(date) {
		var datePar = date.toString();
		var year = datePar.substring(0, 4);
		var month = datePar.substring(4, 6);
		var day = datePar.substring(6, 8);
		return year + '-' + month + '-' + day;
	}
	/*日期格式转换，yyyy-mm-dd去掉横杠‘-’转化为int类型*/
	function stringToInt(date) {
		return parseInt(date.toString().replace(/-/g, ''));
	}

	/*日期格式的转换，yyyy-mm-dd日期加上几天后的日期yyyymmdd*/
	function dataChange(date, number) {
		var retData = new Date();
		var datePar = date.toString();
		var year = datePar.substring(0, 4);
		var month;
		var date = datePar.substring(8, 10);
		/*ie：如果是”01“则parseInt会将该字符串转化为数字”0“;firefox:不存在这种问题*/
		if (datePar.substring(5, 6) == '0')
			month = datePar.substring(6, 7);
		else
			month = datePar.substring(5, 7);
		retData.setFullYear(year, parseInt(month) - 1, date);
		retData.setTime(retData.getTime() + number * 24 * 60 * 60 * 1000);
		return dateformate1(retData);
	}
	function dateformate1(date) {
		var year = date.getFullYear() + "";
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var realmon = '0';
		var realday = '0';
		if (month < 10)
			month = realmon + month;
		if (day < 10)
			day = realday + day;
		return year + month + day;
	}
</script>
</html>
