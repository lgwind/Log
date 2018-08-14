/**
 * 加载页面执行的操作
 */
//window.onload=function(event){
//
//}

/**
 * 返回id
 * @param id
 * @returns
 */
function $$(id){
	return document.getElementById(id);
}


/**
 * 显示遮罩
 * @returns
 */
function showMask(){
	$$("userMask").style.display="inline";
}

