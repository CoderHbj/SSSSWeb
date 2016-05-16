<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<style>
		.line {
            margin-top:200px;
            line-height:50px;
		}

        .text {
            height:50px;
            margin:20px 0;
            font-size:20px;
        }

        .btnslide {
            margin-top:10px;
        }
	
	</style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="buy.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp首页</a>


        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">

            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown" style="display:none;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">王建程<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp个人中心</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>&nbsp购物车</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li style="display:block;">
                    <a href="#">登录</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="container line">
    <div class="col-sm-4 col-sm-offset-4">
        <form action="login" method="post" class="form-signin" role="form">
            <h2 class="form-signin-heading">用户登录</h2>
            <input type="text" class="form-control text" name="customer_no" placeholder="请输入用户名" required autofocus>
            <input type="password" class="form-control text" name="customer_password" placeholder="请输入密码" required>
            <button class='btn btn-lg btn-primary btn-block' type='submit'>登录</button>

        </form>

    </div>
    <div class="col-sm-4 col-sm-offset-4 btnslide">
        <button class="btn btn-lg btn-default btn-block" data-toggle="modal" data-target="#myMo">注册</button>
        <div class="modal fade" id="myMo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">注册</h4>
                    </div>
                    <form action="iCoustomerA" method="post">
                    <div class="modal-body">
                        
                            <input type="hidden" value="111"/>
                            <div class="form-group">
                                <label>用户名:</label>
                                <input type="text" name="customer_no" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label>密码:</label>
                                <input type="text" name="customer_password" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label>姓名:</label>
                                <input type="text" name="customer_name" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label>性别:</label>
                                <select name="sex" class="form-control">
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>职业:</label>
                                <input type="text" name="job" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label>联系电话:</label>
                                <input type="text" name="tel" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>联系地址:</label>
                                <input type="text" name="addr" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>身份证:</label>
                                <input type="text" name="idcard" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label>备注:</label>
                                <textarea type="text" name="remark" class="form-control" ></textarea>
                            </div>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="js/jquery-1.12.3.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>