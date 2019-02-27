<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cai statistic</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
<script src="${ctx}/js/echart/echarts.min.js"></script>
</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<form id="zhexianfiveForm" action="${ctx}/cai/echart" method="POST">
	<input type="hidden" name="queryDay" value="${queryDay}"/>
		<div algin="center">
			<a id="preDay" href="javascript:void(0);">上一页</a>&nbsp;&nbsp;&nbsp;<a id="todayDay" href="javascript:void(0);">今天</a>&nbsp;&nbsp;&nbsp;<a id="nextDay" href="javascript:void(0);">下一页</a>
		</div>
	</form>
	<div id="zhexianfive" style="height: 400px;width: 1150px;"></div>
	<br/><br/><br/><br/>
	<div id="zhexianbao" style="height: 400px;width: 1150px;"></div>
	<br/><br/><br/><br/>
	<div id="zhexianthird" style="height: 400px;width: 1150px;"></div>
	<!-- ECharts单文件引入 -->
	<script type="text/javascript">
		$(function() {
			var caiStaList = ${caiList};
			zuFive(caiStaList);
			thirdBaozi(caiStaList);
			thirdType(caiStaList);
			//单击上下页
			$('#preDay').click(function(){
				var day = $('input[name=queryDay]').val();
				var preDay = dataChange(numberToString(day),-29);
				$('input[name=queryDay]').val(preDay);
				$('#zhexianfiveForm').submit();
			});
			$('#nextDay').click(function(){
				var day = $('input[name=queryDay]').val();
				var nextDay = dataChange(numberToString(day),29);
				$('input[name=queryDay]').val(nextDay);
				$('#zhexianfiveForm').submit();
			});
			$('#todayDay').click(function(){
				$('input[name=queryDay]').val('');
				$('#zhexianfiveForm').submit();
			});
		});
		//组5
		function zuFive(caiStaList) {//组5
			var caiDate = [];
			var zu5 = [];
			var zu10 = [];
			var zu20 = [];
			var zu30 = [];
			var xName = [ '组5', '组10', '组20', '组30', ];
			for (var i = 0; i < caiStaList.length; i++) {
				var caiSta = caiStaList[i];
				caiDate.push(caiSta.openDate);
				zu5.push(caiSta.zuFive5Acount);
				zu10.push(caiSta.zuFive10Acount);
				zu20.push(caiSta.zuFive20Acount);
				zu30.push(caiSta.zuFive30Acount);
			}

			var chart = echarts.init($('#zhexianfive')[0]);
			chart.setOption({

				title : {
					text : '组5折线图'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : xName
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : caiDate
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : xName[0],
					type : 'line',
					stack : '总量',
					data : zu5
				}, {
					name : xName[1],
					type : 'line',
					stack : '总量',
					data : zu10
				}, {
					name : xName[2],
					type : 'line',
					stack : '总量',
					data : zu20
				}, {
					name : xName[3],
					type : 'line',
					stack : '总量',
					data : zu30
				} ]
			//,color:['#c23531','#2f4554', '#61a0a8', '#d48265']
			});
		}
		//各组豹子
		function thirdBaozi(caiStaList) {//组5
			var caiDate = [];
			var third123 = [];var third124 = [];var third125 = [];
			var third134 = [];var third135 = [];var third145 = [];
			var third234 = [];var third235 = [];var third245 = [];var third345 = [];
			var xName = [ '前三', '万千十', '万千个', '万百十', '万百个','万十个','中三','千百个','千十个','后三'];
			for (var i = 0; i < caiStaList.length; i++) {
				var caiSta = caiStaList[i];
				caiDate.push(caiSta.openDate);
				third123.push(caiSta.zuThirdPosition123BaoCount);
				third124.push(caiSta.zuThirdPosition124BaoCount);
				third125.push(caiSta.zuThirdPosition125BaoCount);
				third134.push(caiSta.zuThirdPosition134BaoCount);
				third135.push(caiSta.zuThirdPosition135BaoCount);
				third145.push(caiSta.zuThirdPosition145BaoCount);
				third234.push(caiSta.zuThirdPosition234BaoCount);
				third235.push(caiSta.zuThirdPosition235BaoCount);
				third245.push(caiSta.zuThirdPosition245BaoCount);
				third345.push(caiSta.zuThirdPosition345BaoCount);
			}

			var chart = echarts.init($('#zhexianbao')[0]);
			chart.setOption({

				title : {
					text : '组3豹子折线图'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : xName
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : caiDate
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : xName[0],
					type : 'line',
					stack : '总量',
					data : third123
				}, {
					name : xName[1],
					type : 'line',
					stack : '总量',
					data : third124
				}, {
					name : xName[2],
					type : 'line',
					stack : '总量',
					data : third125
				}, {
					name : xName[3],
					type : 'line',
					stack : '总量',
					data : third134
				}, {
					name : xName[4],
					type : 'line',
					stack : '总量',
					data : third135
				}, {
					name : xName[5],
					type : 'line',
					stack : '总量',
					data : third145
				}, {
					name : xName[6],
					type : 'line',
					stack : '总量',
					data : third234
				}, {
					name : xName[7],
					type : 'line',
					stack : '总量',
					data : third235
				}, {
					name : xName[8],
					type : 'line',
					stack : '总量',
					data : third245
				}, {
					name : xName[9],
					type : 'line',
					stack : '总量',
					data : third345
				} ]
			//,color:['#c23531','#2f4554', '#61a0a8', '#d48265']
			});
		}
		//各组三
		function thirdType(caiStaList) {//组5
			var caiDate = [];
			var third123 = [];var third124 = [];var third125 = [];
			var third134 = [];var third135 = [];var third145 = [];
			var third234 = [];var third235 = [];var third245 = [];var third345 = [];
			var xName = [ '前三', '万千十', '万千个', '万百十', '万百个','万十个','中三','千百个','千十个','后三'];
			for (var i = 0; i < caiStaList.length; i++) {
				var caiSta = caiStaList[i];
				caiDate.push(caiSta.openDate);
				third123.push(caiSta.zuThirdPosition123Count);
				third124.push(caiSta.zuThirdPosition124Count);
				third125.push(caiSta.zuThirdPosition125Count);
				third134.push(caiSta.zuThirdPosition134Count);
				third135.push(caiSta.zuThirdPosition135Count);
				third145.push(caiSta.zuThirdPosition145Count);
				third234.push(caiSta.zuThirdPosition234Count);
				third235.push(caiSta.zuThirdPosition235Count);
				third245.push(caiSta.zuThirdPosition245Count);
				third345.push(caiSta.zuThirdPosition345Count);
			}

			var chart = echarts.init($('#zhexianthird')[0]);
			chart.setOption({
				title : {
					text : '组3折线图'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : xName
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : caiDate
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : xName[0],
					type : 'line',
					stack : '总量',
					data : third123
				}, {
					name : xName[1],
					type : 'line',
					stack : '总量',
					data : third124
				}, {
					name : xName[2],
					type : 'line',
					stack : '总量',
					data : third125
				}, {
					name : xName[3],
					type : 'line',
					stack : '总量',
					data : third134
				}, {
					name : xName[4],
					type : 'line',
					stack : '总量',
					data : third135
				}, {
					name : xName[5],
					type : 'line',
					stack : '总量',
					data : third145
				}, {
					name : xName[6],
					type : 'line',
					stack : '总量',
					data : third234
				}, {
					name : xName[7],
					type : 'line',
					stack : '总量',
					data : third235
				}, {
					name : xName[8],
					type : 'line',
					stack : '总量',
					data : third245
				}, {
					name : xName[9],
					type : 'line',
					stack : '总量',
					data : third345
				} ]
			//,color:['#c23531','#2f4554', '#61a0a8', '#d48265']
			});
		}
		
		
		
		function numberToString(date){
			var datePar=date.toString();
		    var year=datePar.substring(0,4);
		    var month=datePar.substring(4,6);
		    var day=datePar.substring(6,8);
			return year+'-'+month+'-'+day;
		}
		/*日期格式转换，yyyy-mm-dd去掉横杠‘-’转化为int类型*/
		function stringToInt(date){
			return parseInt(date.toString().replace(/-/g,''));
		}

		/*日期格式的转换，yyyy-mm-dd日期加上几天后的日期yyyymmdd*/
		function dataChange(date,number){
			var retData=new Date();
			var datePar=date.toString();
		    var year=datePar.substring(0,4);  
		    var month;
		    var date=datePar.substring(8,10);
		    /*ie：如果是”01“则parseInt会将该字符串转化为数字”0“;firefox:不存在这种问题*/
		    if(datePar.substring(5,6)=='0')
		    	month=datePar.substring(6,7);
		    else
		    	month=datePar.substring(5,7);
			retData.setFullYear(year, parseInt(month)-1, date);    
			retData.setTime(retData.getTime()+number*24*60*60*1000);  
			return dateformate1(retData);
		}
		function dateformate1(date){
			var year=date.getFullYear()+"";
			var month=date.getMonth()+1;
			var day=date.getDate();
			var realmon='0';
			var realday='0';
			if(month<10)
				month=realmon+month;
			if(day<10)
				day=realday+day;
			return year+month+day;
		}
	</script>
</body>

</html>
