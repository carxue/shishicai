// ad
$(function(){
	var sWidth = $("#J_showPic").width();//取焦点图宽度
	var len = $(".showPic-body ul li").length;//获取焦点图个数
	var index = 0;
	var adTimer;
	$(".showPic-nav li").mouseover(function(){
		index = $(".showPic-nav li").index(this);
		showImg(index);
	 }).eq(0).mouseover();
	
	$(".showPic-body ul").css("width",sWidth * (len));
	
	$("#J_showPic").hover(function() {
		clearInterval(adTimer);
		},function(){
			adTimer = setInterval(function(){
				showImg(index);
				index++;
				if(index == len){index = 0;}
				},4000);//图片停止时间
			}).trigger("mouseleave");
		function showImg(index){
			var nowLeft = -index*sWidth;
			$(".showPic-body ul").stop(true,false).animate({"left":nowLeft},300);
			$(".showPic-nav li").removeClass("current").eq(index).addClass("current");
			}
		
	});



//hover
function elementHover(ele,eleShow,hover){
	$(ele).hover(
		function(){
			$(this).addClass(hover);
			$(eleShow).fadeIn("slow");
		},
		function(){
			$(this).removeClass(hover);
			$(eleShow).fadeOut("slow");
		}
	);
}
//Tabs
function tabs(tabNav,tabCon,tabEvent){
	var index = 0;
	if(tabEvent === true){	
		$(tabNav).mouseover(function(){
			index = $(tabNav).index(this);
			tabsFun(index,tabNav,tabCon);
		 })
	 }else{
		 $(tabNav).click(function(){
			index = $(tabNav).index(this);
			tabsFun(index,tabNav,tabCon);
		 })
		 }
}
function tabsFun(index,tabNav,tabCon){
	$(tabNav).removeClass("current").eq(index).addClass("current");
	$(tabCon).removeClass("current").eq(index).addClass("current");
	}
	
	
$(function(){
	elementHover(".selectBox",null,"hover");
	elementHover(".selectMore li",null,"hover");
	elementHover(".textInput",null,"hover");
	elementHover("#J_orderCon tbody tr",null,"hover")
	elementHover(".ico-date",null,"hover");
	elementHover(".g-order",null,"hover");
	tabs("#J_tab .tabNav li","#J_tab .tabCon",false);
	tabs("#J_tab .investNav li","#J_tab .investtabCon",false);
	tabs("#J_tab .pab-asideNav li","#J_tab .pab-aside-show",false);
	});
	
//滚动插件
(function($){
$.fn.extend({
        Scroll:function(opt,callback){
                //参数初始化
                if(!opt) var opt={};
                var _this=this.eq(0).find("ul:first");
                var        lineH=_this.find("li:first").height(), //获取行高
                        line=opt.line?parseInt(opt.line,10):parseInt(this.height()/lineH,10), //每次滚动的行数，默认为一屏，即父容器高度
                        speed=opt.speed?parseInt(opt.speed,10):500, //卷动速度，数值越大，速度越慢（毫秒）
                        timer=opt.timer?parseInt(opt.timer,10):3000; //滚动的时间间隔（毫秒）
                if(line==0) line=1;
                var upHeight=0-line*lineH;
                //滚动函数
                scrollUp=function(){
                        _this.animate({
                                marginTop:upHeight
                        },speed,function(){
                                for(i=1;i<=line;i++){
                                        _this.find("li:first").appendTo(_this);
                                }
                                _this.css({marginTop:0});
                        });
                }
                //鼠标事件绑定
                _this.hover(function(){
                        clearInterval(timerID);
                },function(){
                        timerID=setInterval("scrollUp()",timer);
                }).mouseout();
        }        
})
})(jQuery);

$(document).ready(function(){
        $(".notice").Scroll({line:1,speed:800,timer:2000});
});


