	window.onload = function(){
		refresh();
	} 
	function refresh(){
		refreshSclass();
		refreshRecord(2,10);
		pageIndex()
	}
	function refreshPageIndex(currentIndex/*当前页下标*/,recordSize/*总页数*/,
			recordShowSize/*每页显示最大记录数*/,pageSize/*页数*/){
		//生成页面索引   
		var pagesIndex = document.getElementById('pages_index');//	通过id抓取元素
		var t = pagesIndex.childNodes.length; 					//	抓取元素子节点数 
		for (var i = pageSize; i > 0; i--) { 
			var li = document.createElement('li');				//	通过对象创建元素
			li.innerHTML = "<a  class='page-link' href='#' onclick='init(" + i
					+ ")'>" + i + "</a>";
			pagesIndex.insertBefore(li, pagesIndex.childNodes[2]);
		}
		document.getElementById('customer_record_size').innerHTML = recordSize; //	记录数 
		document.getElementById('customer_page_size').innerHTML = pageSize; //	总页数
	}
	function refreshShowSize(){
		var showSize = document.getElementById("pg-record-size").value;
		$.ajax({
			type:"post",
			url:"<%=basePath%>/sysparam/updateShowSize.action",
			async:true,
			dataType:"text",
			data:{
				showSize:showSize
			},
			success:function (e){
				alert("yesy")
			}
		});
	}
	function refreshRecord(index,showSize){
		$.ajax({
			type:"post",
			url:"<%=basePath%>/sysparam/paginationStudent.action",
			async:true,
			dataType:"text",
			data:{
				index:index,
				showSize:showSize
			},
			success:function (e){
				var jsonObj = JSON.parse(e);
				showRecord(jsonObj["bean"]);
				refreshPageIndex(jsonObj["currentIndex"],jsonObj["recordSize"],
					jsonObj["recordShowSize"],jsonObj["pageSize"]);
			}
		});
	}
	function refreshSclass(){
		$.ajax({
			type:"post",
			url:"<%=basePath%>/sysparam/retrieveAllSclass.action",
			async:true,
			dataType:"text",
			data:{},
			success:function (e){
				var arrayObj = JSON.parse(e);
				showSclass(arrayObj);
			}
		});
	}

	function showSclass(arrayObj){
		var tbody = document.getElementById("select-sc-id");
		var tbodyContext = "";
		for(var i=0;i<arrayObj.length;i++){
			tbodyContext += "<option value='"+arrayObj[i]["id"]+"'>"+arrayObj[i]["name"]+"</option>";
		}
		tbody.innerHTML = tbodyContext;
	}
	function showRecord(arrayObj){
		var tbody = document.getElementById("context");
		var tbodyContext = "";
		for(var i=0;i<arrayObj.length;i++){
			var test = arrayObj[i];
			tbodyContext += "<tr>";
			tbodyContext+="<th><input type='checkbox' name='recordId'/></th>";
/* 			for(var key in arrayObj[i]){
				tbodyContext += "<th>"+test[key]+"</th>";
			} */
			tbodyContext += "<th>"+test["id"]+"</th>";
			tbodyContext += "<th>"+test["name"]+"</th>";
			tbodyContext += "<th>"+test["sex"]+"</th>";
			tbodyContext += "<th>"+test["age"]+"</th>";
			tbodyContext += "<th>"+test["birth"]+"</th>";
			tbodyContext +=  
			"<th><a href='#' data-toggle='modal' data-target='#student'><img src='img/update.png' width='15px'/></a>" +
			"<a href='#' data-toggle='modal'  data-target='#delete'><img src='img/delete.png' width='20px'/></a></th>";
			tbodyContext += "</tr>";
		}
		tbody.innerHTML = tbodyContext;
	}
	function toCheckedRec(checked){
		var records = document.getElementsByName("recordId");
			for(i=0;i<records.length;i++){
				var record = records[i];
				if(checked==true&&record.checked == false){
					record.checked = !record.checked;
					document.getElementById("records-checked").innerHTML ="取消";
				}
				if(checked==false&&record.checked == true){
					record.checked = !record.checked;
					document.getElementById("records-checked").innerHTML ="全选";
				}
			}
	}