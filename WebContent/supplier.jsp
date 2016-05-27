
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>汽车4S店管理平台</title>

<!-- Bootstrap core CSS -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrapValidator.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">
<style>
.img {
	width: 30px;
	height: 30px;
	margin: 10px 0 0 20px;
}

.img1 {
	width: 20px;
	height: 20px;
}

.img3 {
	width: 15px;
	height: 15px;
}

.head {
	width: 100%;
	height: 50px;
	background-color: #56abff;
}

.main {
	padding: 0;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">4S店管理平台</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="main.jsp">主页</a></li>
				<li><a href="#" id="example_bottom" rel="popover">个人资料</a></li>
				<li><a href="signout">退出登录</a></li>
			</ul>
			<form class="navbar-form navbar-right" action="selectUser"
				method="post" id="searchForm">
				<input type="text" class="form-control" name="key"
					placeholder="Search...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<s:if test='#session.user.post == "管理员"'>
					<ul class="nav nav-sidebar">
						<li><a href="selectAllUser">员工操作</a></li>
					</ul>
				</s:if>


				<s:if test='#session.user.post == "仓库管理员"'>
					<ul class="nav nav-sidebar">
						<li class="active"><a href="ssupplierA?page=0">供应商</a></li>
					</ul>
				</s:if>

				<s:if test='#session.user.post == "客户" '>
					<ul class="nav nav-sidebar">
						<li><a href="sACA?page=0">客户</a></li>
					</ul>
				</s:if>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="head">
					<img class="img" data-toggle="modal" data-target="#add"
						src="image/add.png">
				</div>
				<table class="table table-hover" id="list">
					<tr>
						<td width="100px">供应商名称</td>
						<td width="100px">联系人</td>
						<td width="100px">联系电话</td>
						<td width="100px">地址</td>
						<td width="100px">开户银行</td>
						<td width="100px">银行账户</td>
						<td width="100px">备注</td>
						<td width="100px">操作</td>
					</tr>


				</table>


			</div>

		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">新增</h4>
				</div>
				<form action="siA" method="post">
					<div class="modal-body">

						<div class="form-group">
							<label>供应商名称:</label> <input type="text" class="form-control"
								name="supplier_name" required>
						</div>
						<div class="form-group">
							<label>联系人:</label> <input type="text" class="form-control"
								name="contact" required>
						</div>
						<div class="form-group">
							<label>联系电话:</label> <input type="text" class="form-control"
								name="contact_tel" required>
						</div>
						<div class="form-group">
							<label> 联系地址:</label> <input type="text" class="form-control"
								name="contact_addr" required>
						</div>
						<div class="form-group">
							<label>开户银行:</label> <input type="text" class="form-control"
								name="account_bank" required>
						</div>
						<div class="form-group">
							<label>银行账号:</label> <input type="text" class="form-control"
								name="account_num" required>
						</div>
						<div class="form-group">
							<label>备注:</label>
							<textarea class="form-control" name="remark"></textarea>
						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary" id="addaction">新增</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="edit" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<form action="seA" method="post">
					<div class="modal-body" id="ed">

						<input type="hidden" name="supplier_id">
						<div class="form-group">
							<label>供应商名称:</label> <input type="text" class="form-control"
								name="supplier_name" required>
						</div>
						<div class="form-group">
							<label>联系人:</label> <input type="text" class="form-control"
								name="contact" required>
						</div>
						<div class="form-group">
							<label>联系电话:</label> <input type="text" class="form-control"
								name="contact_tel" required>
						</div>
						<div class="form-group">
							<label> 联系地址:</label> <input type="text" class="form-control"
								name="contact_addr" required>
						</div>
						<div class="form-group">
							<label>开户银行:</label> <input type="text" class="form-control"
								name="account_bank" required>
						</div>
						<div class="form-group">
							<label>银行账号:</label> <input type="text" class="form-control"
								name="account_num" required>
						</div>
						<div class="form-group">
							<label>备注:</label>
							<textarea class="form-control" name="remark"></textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-sm-4 col-sm-offset-4 col-md-3 col-md-offset-5"
			id="page"></div>
	</div>
	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="js/bootstrapValidator.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
	$(function ()
	{ $("#example_bottom").popover({html: true ,placement:'bottom',title: '${session.user["username"]}', 
		content: '<strong>${session.user["usex"]}<br>${session.user["post"]}</strong><a class="btn btn-danger" data-toggle="modal" data-target="#pswModal" role="button">修改密码</a>'});
	});
	

    $(function(){
    $('#add').modal({
    show: false,
    backdrop: 'static',
    keyboard: false
    });
    $('#edit').modal({
    show: false,
    backdrop: 'static',
    keyboard: false
    });
    $.ajax ({
    type : 'post',
    url : 'ssA.action',
    dataType:'json',
    success:function(data){
    var json = eval(data);
    var first,end;
    if(json.page==0){
    fnext=0
    }else{
    fnext=json.page-1;
    }
    if(json.page==(json.pagecount-1)){
    enext=json.page;
    }else{
    enext=json.page+1;
    }
    var aim = json.page+1;
    var end = json.pagecount-1;

    $("#page").append('<a href="ssupplierA?page=0" ><img class="img3" src="image/111.png" ></a> &nbsp;'+
    '<a href="ssupplierA?page='+fnext+'" ><img class="img3" src="image/112.png" ></a> &nbsp;'+
    '第'+aim+'页'+
    '&nbsp;|&nbsp;'+
    '共'+json.pagecount+'页 &nbsp;'+
    '<a href="ssupplierA?page='+enext+'" ><img class="img3" src="image/113.png" ></a> &nbsp;'+
    '<a href="ssupplierA?page='+end+'" ><img class="img3" src="image/114.png" ></a>');
    $.each(json, function (i) {
    $.each(json[i], function (j) {
    var supplier_id = json[i][j].supplier_id;
    var supplier_name = json[i][j].supplier_name;
    var contact = json[i][j].contact;
    var contact_tel = json[i][j].contact_tel;
    var contact_addr = json[i][j].contact_addr;
    var account_bank = json[i][j].account_bank;
    var account_num = json[i][j].account_num;
    var remark = json[i][j].remark;
    $("#list").append("<tr>"+'<input type="hidden" name="supplier_id" value="'+supplier_id+'">'+"<td>"+supplier_name+"</td><td>"+contact+"</td><td>"+contact_tel+"</td><td>"+contact_addr+"</td><td>"+account_bank+"</td><td>"+account_num+"</td><td>"+remark+"</td><td>"+
    '<img class="img1" data-toggle="modal" onclick="edit(this)" data-target="#edit" src="image/edit.png">&nbsp;'+
    '<a href="sdA?supplier_id='+supplier_id+'" ><img class="img1" src="image/delete.png"></a></td><tr>');

    });
    });
    },
    error :function(data){
    alert("error");
    }
    });



    });
    function edit(obj){
    var $me = $(obj);
    $("#ed").find("input[type=hidden]").val($me.parent().parent().find("input[type=hidden]").val());
    var $data = $me.parents('tr').children('td');
    $("#ed").find("input[name=supplier_name]").val($data.eq(0).text());
    $("#ed").find("input[name=contact]").val($data.eq(1).text());
    $("#ed").find("input[name=contact_tel]").val($data.eq(2).text());
    $("#ed").find("input[name=contact_addr]").val($data.eq(3).text());
    $("#ed").find("input[name=account_bank]").val($data.eq(4).text());
    $("#ed").find("input[name=account_num]").val($data.eq(5).text());
    $("#ed").find("textarea[name=remark]").val($data.eq(6).text());
    }



    </script>
</body>
</html>


