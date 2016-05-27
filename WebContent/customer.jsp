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
.head {
	width: 100%;
	height: 50px;
	background-color: #56abff;
}

.text {
	font-size: 20px;
	padding-top: 10px;
}

.img3 {
	width: 15px;
	height: 15px;
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
						<li><a href="ssupplierA?page=0">供应商</a></li>
					</ul>
				</s:if>

				<s:if test='#session.user.post == "客户" '>
					<ul class="nav nav-sidebar">
						<li class="active"><a href="sACA?page=0">客户</a></li>
					</ul>
				</s:if>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="head">
					<p class="text">所有用户</p>
				</div>
				<table class="table table-hover" id="list">
					<tr>
						<td>用户编号</td>
						<td>用户名</td>
						<td>性别</td>
						<td>工作</td>
						<td>联系电话</td>
						<td>联系地址</td>
						<td>身份证</td>
						<td>备注</td>
					</tr>


				</table>

				<div class="container">
					<div class="col-sm-4 col-sm-offset-4 col-md-3 col-md-offset-5"
						id="page"></div>
				</div>
			</div>
		</div>


	</div>
	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="js/bootstrapValidator.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
			$(function() {
				$("#example_bottom")
						.popover(
								{
									html : true,
									placement : 'bottom',
									title : '${session.user["username"]}',
									content : '<strong>${session.user["usex"]}<br>${session.user["post"]}</strong><a class="btn btn-danger" data-toggle="modal" data-target="#pswModal" role="button">修改密码</a>'
								});
			});
			$(function() {
				$
						.ajax({
							type : 'post',
							url : 'sACoustomerA.action',
							dataType : 'json',
							success : function(data) {
								var json = eval(data);
								var first, end;
								if (json.page == 0) {
									fnext = 0
								} else {
									fnext = json.page - 1;
								}
								if (json.page == (json.pagecount - 1)) {
									enext = json.page;
								} else {
									enext = json.page + 1;
								}
								var aim = json.page + 1;
								var end = json.pagecount - 1;

								$("#page")
										.append(
												'<a href="sACA?page=0" ><img class="img3" src="image/111.png" ></a> &nbsp;'
														+ '<a href="sACA?page='
														+ fnext
														+ '" ><img class="img3" src="image/112.png" ></a> &nbsp;'
														+ '第'
														+ aim
														+ '页'
														+ '&nbsp;|&nbsp;'
														+ '共'
														+ json.pagecount
														+ '页 &nbsp;'
														+ '<a href="sACA?page='
														+ enext
														+ '" ><img class="img3" src="image/113.png" ></a> &nbsp;'
														+ '<a href="sACA?page='
														+ end
														+ '" ><img class="img3" src="image/114.png" ></a>');
								$
										.each(
												json,
												function(i) {
													$
															.each(
																	json[i],
																	function(j) {
																		var customer_no = json[i][j].customer_no;
																		var customer_name = json[i][j].customer_name;
																		var sex = json[i][j].sex;
																		var job = json[i][j].job;
																		var tel = json[i][j].tel;
																		var addr = json[i][j].addr;
																		var idcard = json[i][j].idcard;
																		var remark = json[i][j].remark;
																		$(
																				"#list")
																				.append(
																						"<tr><td>"
																								+ customer_no
																								+ "</td><td>"
																								+ customer_name
																								+ "</td><td>"
																								+ sex
																								+ "</td><td>"
																								+ job
																								+ "</td><td>"
																								+ tel
																								+ "</td><td>"
																								+ addr
																								+ "</td><td>"
																								+ idcard
																								+ "</td><td>"
																								+ remark
																								+ "</td><td>");

																	});
												});
							},
							error : function(data) {
								alert("error");
							}
						});

			});
		</script>
</body>
</html>




