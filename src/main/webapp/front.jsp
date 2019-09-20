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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/front-style.css" />
	<script type="text/javascript" src="js/front-js.js" ></script>
	<title>Insert title here</title>
</head>
<script>
	window.onload = function(){
		refresh();
	} 
	function refresh(){
		refreshSclass();
		refreshRecord(1);
		pageIndex()
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
	function refreshRecord(index){
		$.ajax({
			type:"post",
			url:"<%=basePath%>/sysparam/paginationStudent.action",
			async:true,
			dataType:"text",
			data:{
				index:index
			},
			success:function (e){
				var jsonObj = JSON.parse(e);
				showRecord(jsonObj["bean"]);
				showPageIndex(jsonObj["currentIndex"],jsonObj["recordSize"],
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
	/**
	 * 下拉菜单装载Sclass
	**/
	function showSclass(arrayObj){
		var tbody = document.getElementById("select-sc-id");
		var tbodyContext = "";
		for(var i=0;i<arrayObj.length;i++){
			tbodyContext += "<option value='"+arrayObj[i]["id"]+"'>"+arrayObj[i]["name"]+"</option>";
		}
		tbody.innerHTML = tbodyContext;
	}
	/**
	 *	显示记录集
	 */ 
	function showRecord(arrayObj){
		var tbody = document.getElementById("context");
		var tbodyContext = "";
		for(var i=0;i<arrayObj.length;i++){
			var test = arrayObj[i];
			tbodyContext += "<tr>";
			tbodyContext+="<th><input type='checkbox' name='recordId'/></th>";
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
	function showPageIndex(currentIndex/*当前页下标*/,recordSize/*总页数*/,
			recordShowSize/*每页显示最大记录数*/,pageSize/*页数*/){
		//生成页面索引   
		var pagesIndex = document.getElementById('pages_index');//	通过id抓取元素
		var t = pagesIndex.childNodes.length; 					//	抓取元素子节点数  
		var pagesContext = "";
		pagesContext += "<li class='page-item'><a class='page-link' href='#' onclick='refreshRecord("+(currentIndex-1)+")'>&laquo;</a></li>";
		for (var i = 1; i <= pageSize; i++) {  
			if(currentIndex != i){
				pagesContext += "<li class='page-item'><a  class='page-link' href='#' onclick='refreshRecord(" + i
					+ ")'>" + i + "</a></li>"; 
			}
			else{
				pagesContext += "<li class='page-item disabled'><a  class='page-link' href='#' onclick='refreshRecord(" + i
					+ ")'>" + i + "</a></li>"; 
			}
		}
		pagesContext += "<li class='page-item'><a class='page-link' href='#' onclick='refreshRecord("+(currentIndex+1)+")'>&raquo;</a></li>";
		pagesContext += "<li class='page-item disabled'>"
		+ "<a class='page-link' href='#'>"
		+ "<strong>共<b id='customer_record_size'>"+recordSize+"</b>条记录/ 共<b id='customer_page_size'>"+pageSize+"</b>页</strong>"
		+ "</a></li>";
		pagesIndex.innerHTML = pagesContext;

	}
	/*全选/取消 记录集 */
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
</script>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 show-layog">
				<div class="row">
					<div class="show-nab">
						<div class="show-nab-group">
							<div class="show-nab-logo">
								<a href="#"><img class="show-nab-img" src="img/p-71979987.jpg"/></a>
							</div>
						</div>
						<div class="show-nab-group">
							<div class="show-nab-link">
								<a href="#">link1</a>
							</div>
							<div class="show-nab-link">
								<a href="#">link2</a>
							</div>
							<div class="show-nab-link">
								<a href="#">link3</a>
							</div><div class="show-nab-link">
								<a href="#">link4</a>
							</div>
						</div> 
						<div class="show-nab-active show-nab-group">
							<div class="show-nab-link">
								<a href="#">link5</a>/
							</div>
							
							<div class="show-nab-link">
								<a href="#">link6</a>
							</div>
						</div>
					</div>
					
					<div class="col-sm-10 show-sider-layog">
						<div class="show-sider"> 
							<div id="sidbar" class="sidbar">
								<div class="sidbar-card show-sider-card">
									<div class="sidbar-card-header card-header">
										<a href="#sdbar-card-1" data-toggle="collapse">first</a>
									</div>
									<div id="sdbar-card-1" class="sdbar-card-body collapse"  data-parent="#sidbar">
										<div class="card-body"> 
											<a href="">first-one</a>
										</div>
										<div class="card-body">
											<a href="">first-two</a>
										</div>
									</div>
									<div class="sidbar-card-header card-header">
										<a href="#sabar-card-2" data-toggle="collapse">second</a>
									</div>
									<div id="sabar-card-2" class="sdbar-card-body collapse"  data-parent="#sidbar">
										<div class="card-body"> 
											<a href="">second-one</a>
										</div>
										<div class="card-body">
											<a href="">second-two</a>
										</div>
									</div>
									<div class="sidbar-card-header card-header">
										<a href="#sabar-card-3" data-toggle="collapse">third</a>
									</div>
									<div id="sabar-card-3" class="sdbar-card-body collapse"  data-parent="#sidbar">
										<div class="card-body"> 
											<a href="">third-one</a>
										</div>
										<div class="card-body">
											<a href="">third-two</a>
										</div>
									</div>
									<div class="sidbar-card-header card-header">
										<a href="#sabar-card-4" data-toggle="collapse">four</a>
									</div>
									<div class="sidbar-card-header card-header">
										<a href="#sabar-card-5" data-toggle="collapse">five</a>
									</div>
									<div class="sidbar-card-header card-header">
										<a href="#sabar-card-6" data-toggle="collapse">sex</a>
									</div>
								</div>
							</div>
						</div>
						<div class="show-context">
							<div class="show-table">
								<div class="table-responsive"> 
									<form action=""> 
										<div class="form-group table-search">
											<div class="card bg-primary text-white cells-label">
												<div class="card-body cell-label">name</div>
											</div>  
											<input type="text" name="name" class="form-control cells" />
										</div> 
										<div class="form-group table-search">
											<div class="card bg-primary text-white cells-label">
												<div class="card-body cell-label">sex</div> 
											</div> 
											<select id="select-st-sex" class="form-control cells" name="sex">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</div>
										<div class="form-group table-search">
											<div class="card bg-primary text-white cells-label">
												<div class="card-body cell-label">sclass</div>
											</div> 
											<select id="select-sc-id" class="form-control cells" name="sclassId"></select>
										</div>
										<div class="form-group table-search-btn">
											<button type="button" class="btn btn-primary">查找</button>
											<button type="reset" class="btn btn-primary">重置</button>
										</div>
									</form>
									<table class="table table-hover table-striped">
										<thead>  
											<tr>
												<th width="75px"><input type='checkbox' onclick="toCheckedRec(this.checked)"/><span id="records-checked">全选</span></th>
												<th>id</th>
												<th>name</th>
												<th>sex</th>
												<th>age</th>
												<th>birth</th>
												<th>operate</th>
											</tr>
										</thead>
										<tbody id="context">
										</tbody>
										<tfoot>
										</tfoot>
									</table>
									<div class="table-pagination">
										<div class="pagination-index">
											<ul class="pagination" id="pages_index">
												<li class="page-item"><a class="page-link" href="#" onclick="left() ">&laquo;</a></li>
												<li class="page-item"><a class="page-link" href="#" onclick="right()">&raquo;</a></li>
												<li class="page-item disabled">
													<a class="page-link" href="#">
														<strong>
															共<b id="customer_record_size"></b>条记录/ 
															共<b id="customer_page_size"></b>页
														</strong>
													</a>
												</li>
											</ul>	
										</div>
									</div>
									<div class="pagination-redirect">
										<div class="form-group">
											<select id="pg-record-size" class="form-control cells fm-lg-input" name="recordShowSize">
												<option value="5">5</option>
												<option value="10">10</option>
												<option value="15">15</option>
											</select>
											<button class="btn btn-primary  cells fm-lg-input disabled" type="button" onclick="">分页</button>
											<select id="pg-index-t" class="form-control cells fm-lg-input" name="pageIndex"></select>
											<button class="btn btn-primary  cells fm-lg-input" type="button" onclick="">跳转</button>
										</div> 
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="student">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="modal-title"></div>
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="table-requestable">
						<form action="">
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label class="form-cell form-cells-label">sex</label>
								</div>
								<div class="form-cell form-cells-radio">
									<div class="fm-cl-rd">
										<div class="radio label-cells-radio">
											<label><input type="radio" name="sex" />男</label>
										</div>
										<div class="radio label-cells-radio">
											<label><input type="radio" name="sex" />女</label>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group form-cells">
								<div class="form-cell form-cells-label">
									<label>name</label>
								</div>
								<div class=" form-cell form-cells-input">
									<input class="form-control" name="name" />
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">submit</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>