/**
 * 鼠标移入时写日志图标
 */
function addlogOver(){
	$$("addlog").innerHTML="写日志";	
}
/**
 * 鼠标移出时写日志图标
 */
function addlogOff(){
	$$("addlog").innerHTML="+";
}

/**
 * 显示添加弹出层界面
 * @returns
 */
function showlogaddPage(){
	$$("logMask").style.display="inline";
	$$("addlogPage").style.display="inline";
}

/**
 * 关闭遮罩和添加弹出层界面
 * @returns
 */
function closelogaddPage(){
	$$("logMask").style.display="none";
	$$("addlogPage").style.display="none";
}

/**
 * 鼠标移出时判断是否放弃修改变量
 */
var logDivJudge=false;
/**
 * 鼠标点击时进行日志编辑 日志从浏览div 变为 编辑div
 * @param elem
 * @param title
 * @param name
 * @param content
 */
function logDivChange(elem, title, name, content){
	logDivJudge=true;
	
	content=content.replace(/<br>/g,"\n");
	elem.innerHTML=
		"<form class='update-log' action='/Log/log/updateLog' method='post'>" +
	    "<table>" + 
	    "<tr>" +
		    "<td><input readonly='readonly' id='log-input-title' class='input-lgwind' type='text' name='title' value='"+title+"' />" +
		         "<input readonly='readonly' id='log-input-name' class='input-lgwind' type='text' name='name' value='"+name+"' /></td>" +
	    "</tr>" +
	    "<tr>" +
		    "<td><textarea class='input-lgwind' rows='5' cols='67' name='content' >"+content+"</textarea></td>" +
	    "</tr>" +
	    "<tr><td><input class='input-lgwind' type='submit' value='确认修改' />" +
	             "<input class='input-lgwind' type='button' value='删除' onclick='deleteLogDiv(\""+name+"-"+title+"\");'/></td></tr>" +
        "</table>" +
        "</form>";
	elem.onclick=function(){
		if(!logDivJudge){
			logDivJudge=true;
		}
	}
}
/**
 * 删除指定名称的日志文件
 * @param title
 */
function deleteLogDiv(title){
	window.open('/Log/log/deleteLog?title='+title,'_self');
}
/**
 * 鼠标移出时 日志从修改div 变为 浏览div
 * @param elem
 * @param title
 * @param name
 * @param content
 */
function logDivChangeOut(elem, title, name, content){
	if (logDivJudge) {
		logDivJudge=false;
		var msg = "您要放弃本次修改吗？\n\n请确认！"
		if (confirm(msg) == true) {
			elem.innerHTML = "<div class='log-title'>" + title
					+ "&nbsp;&nbsp;<span class='log-name'>" + name
					+ "</span></div>" + "<div class='log-content'>" + content
					+ "</div>";
			elem.onclick = function() {
				logDivChange(elem, title, name, content);
			}
		}
	}
}