<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<script src="js/jquery-1.12.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrapValidator.js"></script>

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
			<form class="navbar-form navbar-right" action="SelectCar"
				method="post" id="searchForm">
				<input type="text" class="form-control" name="chnName"
					placeholder="CHINESE NAME Search...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar ">
					<li><a href="getAllAc">配件管理<!--<span class="sr-only">(current)</span>--></a></li>
					<li class="active"><a href="SelectAllCar">车辆管理<!--<span class="sr-only">(current)</span>--></a></li>
					<li><a href="getSaleList">销售单审核</a></li>
					<li><a href="getSubList">订货单签收</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<c:if test="${user.post eq '管理员'}">
					<ul class="nav nav-sidebar">
						<li><a href="selectAllUser">员工操作</a></li>
					</ul>
				</c:if>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">车辆列表</h1>
				<div class="col-md-11 col-md-offset-11">
					<button class="btn btn-success" data-toggle="modal"
						data-target="#addModal" role="button">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加车辆
					</button>
				</div>
				<table class="table table-hover piece" style="margin-left: 0;">
					<thead>
						<tr>
							<th width="70px"><input id="all" type="checkbox"
								class="head">全选</th>
							<th>车辆编码</th>
							<th>中文名</th>
							<th>英文名</th>
							<th>颜色</th>
							<th>排量</th>
							<th>产地</th>
							<th>品牌</th>
							<th>供应商</th>
							<th>单价</th>
							<th>图片</th>
							<th>数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="carlist" var="u">
							<tr>
								<td><input type="checkbox"
									value="<s:property value="#u.id"/>"></td>
								<td><s:property value="#u.code" /></td>
								<td><s:property value="#u.chn_name" /></td>
								<td><s:property value="#u.eng_name" /></td>
								<td><s:property value="#u.color" /></td>
								<td><s:property value="#u.displacement" /></td>
								<td><s:property value="#u.place" /></td>
								<td><s:property value="#u.brand" /></td>
								<td><s:property value="#u.provider" /></td>
								<td><s:property value="#u.price" /></td>
								<td><s:property value="#u.url" /></td>
								<td><s:property value="#u.quantity" /></td>
								<td><a href="javascript:void(0);" class="btn btn-warning"
									rel="<s:property value="#u.id"/>" role="button" /><span
									class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:url id="url_pre" value="SelectAllCar">
					<s:param name="pageNow" value="pageNow-1"></s:param>
				</s:url>

				<s:url id="url_next" value="SelectAllCar">
					<s:param name="pageNow" value="pageNow+1"></s:param>
				</s:url>

				<s:if test="%{pageNow!=1}">
					<s:a href="%{url_pre}" class="btn btn-primary btn-lg" role="button">上一页</s:a>
				</s:if>
				<s:else>
					<s:a href="%{url_pre}" class="btn btn-primary btn-lg disabled"
						role="button">上一页</s:a>
				</s:else>
				<s:iterator value="list" status="status">
					<s:url id="url" value="SelectAllCar">
						<s:param name="pageNow" value="pageNow" />
					</s:url>
				</s:iterator>
				<s:if test="%{pageNum>pageNow}">
					<s:a href="%{url_next}" class="btn btn-primary btn-lg"
						role="button">下一页</s:a>
				</s:if>
				<s:else>
					<s:a href="%{url_next}" class="btn btn-primary btn-lg disabled"
						role="button">下一页</s:a>
				</s:else>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal-header">
		<input type="button" name="deleteinfo" value="删除选中项" onclick="deleteinfo()"/>
	</div>

		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加车辆</h4>
					</div>
					<form action="AddCar" method="post" id="addForm">
						<div class="modal-body">
							<div class="form-group">
								<label for="code">编码</label> <input type="text"
									class="form-control" id="code" name="code" placeholder="编码">
							</div>
							<div class="form-group">
								<label for="chn_name">中文名</label> <input type="text"
									class="form-control" id="chn_name" name="chn_name"
									placeholder="中文名">
							</div>
							<div class="form-group">
								<label for="eng_name">英文名</label> <input type="text"
									class="form-control" id="eng_name" name="eng_name"
									placeholder="英文名">
							</div>
							<div class="form-group">
								<label for="color">颜色</label> <select class="form-control"
									id="color" name="color">
									<s:iterator value="colorlist" var="c">
										<option value="<s:property value="#c.color" />"><s:property
												value="#c.color" /></option>
									</s:iterator>
								</select>
							</div>
							<div class="form-group">
								<label for="displacement">排量</label> <input type="text"
									class="form-control" id="displacement" name="displacement"
									placeholder="排量">
							</div>
							<div class="form-group">
								<label for="place">产地</label> <input type="text"
									class="form-control" id="place" name="place" placeholder="产地">
							</div>
							<div class="form-group">
								<label for="brand">品牌</label> <input type="text"
									class="form-control" id="brand" name="brand" placeholder="品牌">
							</div>
							<div class="form-group">
								<label for="provider">供应商</label> <select class="form-control"
									id="provider" name="provider">
									<s:iterator value="suplist" var="sup">
										<option value="<s:property value="#sup.supplier_id" />"><s:property
												value="#sup.supplier_name" /></option>
									</s:iterator>
								</select>
							</div>
							<div class="form-group">
								<label for="price">单价</label> <input type="text"
									class="form-control" id="price" name="price" placeholder="单价" />
							</div>
							<div class="form-group">
								<label for="text">描述</label> <input type="text"
									class="form-control" id="text" name="text" placeholder="描述" />
							</div>
							<div class="form-group">
								<label for="quantity">数量</label> <input type="text"
									class="form-control" id="quantity" name="quantity"
									placeholder="数量">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改车辆信息</h4>
					</div>
					<form action="UpdateCar" method="post" id="changeForm">
						<div class="modal-body">
							<s:iterator value="cidlist" var="u">
								<input type="hidden" value="#u.id" />
								<div class="form-group">
									<label for="code">编码</label> <input type="text"
										class="form-control" id="code" name="code"
										value="<s:property value="#u.code"/>" />
								</div>
								<div class="form-group">
									<label for="chn_name">中文名称</label> <input type="text"
										class="form-control" id="chn_name" name="chn_name"
										value="<s:property value="#u.chn_name"/>" />
								</div>
								<div class="form-group">
									<label for="eng_name">英文名称</label> <input type="text"
										class="form-control" id="eng_name" name="eng_name"
										value="<s:property value="#u.eng_name"/>" />
								</div>
								<div class="form-group">
									<label for="color">颜色</label> <select class="form-control"
										name="color">
										<s:iterator value="colorlist" var="c">
											<option value="<s:property value="#u.color"/>"><s:property
													value="#c.color" /></option>
										</s:iterator>
									</select>
								</div>
								<div class="form-group">
									<label for="place">产地</label> <input type="text"
										class="form-control" id="place" name="place"
										value="<s:property value="#u.place"/>" />
								</div>
								<div class="form-group">
									<label for="brand">品牌</label> <input type="text"
										class="form-control" id="brand" name="brand"
										value="<s:property value="#u.brand"/>" />
								</div>
								<div class="form-group">
									<label for="provider">供应商</label> <input type="text"
										class="form-control" id="provider" name="provider"
										value="<s:property value="#u.provider"/>" />
								</div>
								<div class="form-group">
									<label for="price">单价</label> <input type="text"
										class="form-control" id="price" name="price"
										value="<s:property value="#u.price"/>" />
								</div>
								<div class="form-group">
									<label for="text">描述</label> <input type="text"
										class="form-control" id="text" name="text"
										value="<s:property value="#u.text"/>" />
								</div>
								<div class="form-group">
									<label for="quantity">库存</label> <input type="text"
										class="form-control" id="quantity" name="quantity"
										value="<s:property value="#u.quantity"/>" />
								</div>
							</s:iterator>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交更改</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<div class="modal fade" id="pswModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改密码</h4>
					</div>
					<form action="changePsw" method="post" id="pswForm">
						<div class="modal-body">
							<div class="form-group">
								<label for="password">原密码</label> <input type="password"
									class="form-control" id="password" name="password"
									placeholder="密码">
							</div>
							<div class="form-group">
								<label for="password">新密码</label> <input type="password"
									class="form-control" id="newpassword" name="newpassword"
									placeholder="密码">
							</div>
							<div class="form-group">
								<label for="repassword">新密码</label> <input type="password"
									class="form-control" id="repassword" name="repassword"
									placeholder="密码">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交更改</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<script type="text/javascript">
			function deleteinfo() {
				var a = document.getElementsByName("id");
				var selectedNo = 0;
				if (a.length > 0) {
					for (var i = 0; i < a.length; i++) {
						if (a[i].checked == true) {
							selectedNo = selectedNo + "," + a[i].value;
						}
					}
				}
				if (selectedNo == 0) {
					alert("选项不能为空");
					return;
				}
				document.forms[0].action = "http://localhost:8080/SSSSWeb/DeleteCar?carid="
						+ selectedNo;
				document.forms[0].submit();
			}

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

			$(document)
					.ready(
							function() {
								$(".btn-warning").click(
										function() {
											var id = $(this).attr('rel');
											$("#myModal .modal-content > form")
													.attr(
															"action",
															"SelectCarByID?id="
																	+ id);
											$("#myModal").modal();
										});
								$('#addForm')
										.bootstrapValidator(
												{
													message : 'This value is not valid',
													feedbackIcons : {
														valid : 'glyphicon glyphicon-ok',
														invalid : 'glyphicon glyphicon-remove',
														validating : 'glyphicon glyphicon-refresh'
													},
													fields : {
														username : {
															message : 'The username is not valid',
															validators : {
																notEmpty : {
																	message : '姓名不能为空'
																},
																stringLength : {
																	min : 1,
																	max : 8,
																	message : '姓名长度必须小于8'
																},
																regexp : {
																	regexp : /^[A-Za-z\u4e00-\u9fa5]+$/,
																	message : '含有非法字符'
																}
															}
														},
														password : {
															validators : {
																notEmpty : {
																	message : '密码不能为空'
																},
																stringLength : {
																	min : 1,
																	max : 10,
																	message : '密码长度必须小于8位'
																},
															}
														},
														phonenum : {
															message : 'The phonenum is not valid',
															validators : {
																stringLength : {
																	min : 11,
																	max : 11,
																	message : '长度必须为11位'
																},
																regexp : {
																	regexp : /^[0-9]+$/,
																	message : '含有非法字符'
																}
															}
														}
													}
												});
								$('#changeForm')
										.bootstrapValidator(
												{
													message : 'This value is not valid',
													feedbackIcons : {
														valid : 'glyphicon glyphicon-ok',
														invalid : 'glyphicon glyphicon-remove',
														validating : 'glyphicon glyphicon-refresh'
													},
													fields : {
														username : {
															message : 'The username is not valid',
															validators : {
																stringLength : {
																	min : 1,
																	max : 8,
																	message : '姓名长度必须小于8'
																},
																regexp : {
																	regexp : /^[A-Za-z\u4e00-\u9fa5]+$/,
																	message : '含有非法字符'
																}
															}
														},
														phonenum : {
															message : 'The phonenum is not valid',
															validators : {
																stringLength : {
																	min : 11,
																	max : 11,
																	message : '长度必须为11位'
																},
																regexp : {
																	regexp : /^[0-9]+$/,
																	message : '含有非法字符'
																}
															}
														}
													}
												});
								$('#pswForm')
										.bootstrapValidator(
												{
													message : 'This value is not valid',
													feedbackIcons : {
														valid : 'glyphicon glyphicon-ok',
														invalid : 'glyphicon glyphicon-remove',
														validating : 'glyphicon glyphicon-refresh'
													},
													fields : {
														password : {
															validators : {
																notEmpty : {
																	message : '密码不能为空'
																},
																stringLength : {
																	min : 1,
																	max : 10,
																	message : '密码长度必须小于10位'
																},
															}
														},
														newpassword : {
															validators : {
																notEmpty : {
																	message : '密码不能为空'
																},
																stringLength : {
																	min : 1,
																	max : 10,
																	message : '密码长度必须小于10位'
																},
																identical : {
																	field : 'repassword',
																	message : '两次新密码不同'
																}
															}
														},
														repassword : {
															validators : {
																notEmpty : {
																	message : '密码不能为空'
																},
																stringLength : {
																	min : 1,
																	max : 10,
																	message : '密码长度必须小于10位'
																},
																identical : {
																	field : 'newpassword',
																	message : '两次新密码不同'
																}
															}
														}
													}
												});
							});
		</script>
</body>
</html>
