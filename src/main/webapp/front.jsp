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
	<title>Insert title here</title>
</head>
<script>
	window.onload = function(){
		show(10);
		pageIndex(50,5);
	}
	function ajaxToRetrieveData(){
		
	}
	function show(recordSize){
		var tbody = document.getElementById("context");
		var tbodyContext = "";
		for(var i=0;i<recordSize;i++){
			tbodyContext += "<tr>";
			tbodyContext+="<th><input type='checkbox' name='recordId'/></th>";
			for(var j=0;j<4;j++){
				tbodyContext += "<th>"+j+"</th>";
			}
			tbodyContext +=
			"<th><a href='#' data-toggle='modal' data-target='#student'><img src='img/update.png' width='15px'/></a>" +
			"<a href='#' data-toggle='modal'  data-target='#delete'><img src='img/delete.png' width='20px'/></a></th>";
			tbodyContext += "</tr>";
		}
		tbody.innerHTML = tbodyContext;
	}
	function pageIndex(recordSize,onePageSize){
		var t1 = parseInt(recordSize % onePageSize);
		var t2 = parseInt(recordSize / onePageSize);
		var pageSize = t1 == 0 ? t2 : t2 + 1;
		pageCurrentSize = pageSize;
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
<style>
	th{
		text-align:center;
	}
	.table-responsive{
		margin: 0 auto;
	}
	.table-search,.table-search label,.table-search input{
		float: left;
	}
	.table-search{
		width: 146px;
		margin-left: 20px;
	}
	.table-search label{
		margin-top: 7px;
		margin-right: 7px;
	}
	.table-search .cells{
		width: 100px; 
	}
	.table-responsive{
		width: 830px;
	}
	.table-search-btn{
		float: right;
	}
	.table-search-btn button{
		margin-right: 15px;
	}
	.table-pagination{
		float: right;
		margin-right: 15px;
	}
</style>
<style>
	.table-requestable{
		margin: 0 auto;
		width: 437px;
	}
	.form-cells{
		width: 437px;
		
	}
	.form-cells-radio{
		margin: ;
	}
	.label-cells-radio{
		float: left;
		margin: 0 5px;
	}
	.form-cells .form-cells-label{
		float: left;
		clear: left;
		width: 80px;
		margin-top: 7px;
		margin-bottom: 7px;
		margin-right: 7px;
		text-align: center;
	}
	.form-cells .form-cells-input,.fm-cl-rd{
		float: left;
		width: 350px;
	}
	.fm-cl-rd{
	}
</style>
<body>
	
	<div class="table-responsive"> 
		<form action="">
			<div class="form-group table-search">
				<label>name</label>
				<input type="text" name="name" class="form-control cells" />
			</div>
			<div class="form-group table-search">
				<label>name</label>
				<input type="text" name="name" class="form-control cells" />
			</div>
			<div class="form-group table-search">
				<label>name</label>
				<select class="form-control cells" name="">
					<option>1</option>
					<option>2</option>
				</select>
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
					<th>hello</th>
					<th>java</th>
					<th>and</th>
					<th>world</th>
					<th>operate</th>
				</tr>
			</thead>
			<tbody id="context">
			</tbody>
			<tfoot>
			</tfoot>
		</table>
		<div class="table-pagination">
			<ul class="pagination " id="pages_index">
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
	<div class="modal fade" id="delete">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="modal-title">
						
					</div>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="alert alert-danger" style="text-align: center;">
						<strong>确认删除么</strong>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">确认</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
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