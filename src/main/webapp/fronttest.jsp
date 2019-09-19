<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+request.getServerName() +":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
function refreshSelect(){
	$.ajax({
		type:"post",
		url:"<%=basePath%>/sysparam/paginationStudent.action",
		async:true,
		dataType:"text",
		data:{
			index:3,
			showSize:5
		}, 
		success:function (e){
			document.getElementById("text").innerHTML = e;

			var arrayObj = JSON.parse(e);

			showRecord(arrayObj["bean"]);
		}
	}); 
} 
function refreshRecord(){
	$.ajax({
		type:"post",
		url:"<%=basePath%>/sysparam/retrieveAllSclass.action",
		async:true,
		dataType:"text",
		data:{},
		success:function (e){
			var arrayObj = JSON.parse(e);
			showRecord(arrayObj);
		}
	});
}
function showRecord(arrayObj){
	var tbody = document.getElementById("t-re");
	var tbodyContext = "";
	for(var i=0;i<arrayObj.length;i++){
		var test = arrayObj[i];
		tbodyContext += "<tr>";
		tbodyContext+="<th><input type='checkbox' name='recordId'/></th>";
		for(var key in arrayObj[i]){
			console.log(key);
			tbodyContext += "<th>"+test[key]+"</th>";
		}
		tbodyContext +=
		"<th><a href='#' data-toggle='modal' data-target='#student'><img src='img/update.png' width='15px'/></a>" +
		"<a href='#' data-toggle='modal'  data-target='#delete'><img src='img/delete.png' width='20px'/></a></th>";
		tbodyContext += "</tr>";
	}
	tbody.innerHTML = tbodyContext;
}
function showSclass(arrayObj){
	var tbody = document.getElementById("select-sc-id");
	var tbodyContext = "";
	
	for(var i=0;i<arrayObj.length;i++){
		tbodyContext += "<option value='"+arrayObj[i]["id"]+"'>"+arrayObj[i]["name"]+"</option>";

	}
	tbody.innerHTML = tbodyContext;
}
</script>
</head>
<body>
<select id="select-sc-id" name="id">
	<option value="1">1</option>
</select>
<a href="javascript:refreshSelect();">56165465</a>
<div id="text"></div>
<table>
	<tbody id="t-re"></tbody>
</table>
</body>
</html> 