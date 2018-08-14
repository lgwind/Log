/*
 * 加载页面执行的操作
 */
window.onload = function(event) {
	//获取所有标签
	var tags = document.getElementsByTagName('*');
	//获取当前时间
	var myDate = new Date();//获取系统当前时间
	var dateStr = myDate.getFullYear()+'年'; //获取当前年份(2位)
	dateStr+=myDate.getMonth()+1+'月'; //获取当前月份(0-11,0代表1月)
	dateStr+=myDate.getDate()+'日'; //获取当前日(1-31)
//	alert(dateStr);
	//给当前天标签设置特定样式
	for (var i=0; i<tags.length; i++){
		if(tags[i].title==dateStr){
			tags[i].style.backgroundColor="#d9b3b3";
			tags[i].style.borderRadius='20px';
			tags[i].style.color='#ffffff';
			tags[i].title+=' 今天';
		}
	}
}

/**
 * 鼠标移入时写日志图标
 */
function checkName(){
	var name= $$("checkName").value;
	window.open('/Log/log/checkName?name='+name,'_self');
}

function checkNameFocus(){
	$$("checkName").select();
	$$("checkName").focus();
}
