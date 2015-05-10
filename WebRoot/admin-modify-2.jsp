<%@page import="cn.edu.qtech.vo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% User user = (User) request.getAttribute("user"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze UI Admin user Examples</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  <SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
  
  <SCRIPT type="text/javascript">
	$(function() {
		$("#uploadPic").click(function(){
		    $("#uploadForm").submit();
		});
	});
	
	
</SCRIPT>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>May jv</strong> <small>美剧之家管理后台</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
     

      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="admin-index.html"><span class="am-icon-home"></span> 首页</a></li>
	<li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="admin-user.html" class="am-cf"><span class="am-icon-check"></span> 个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="admin-help.html"><span class="am-icon-puzzle-piece"></span> 帮助页</a></li>
          <li><a href="admin-gallery.html"><span class="am-icon-th"></span> 相册页面<span class="am-badge am-badge-secondary am-margin-right am-fr">24</span></a></li>
          <li><a href="admin-log.html"><span class="am-icon-calendar"></span> 系统日志</a></li>
          <li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
        </ul>
      </li>
      <li><a href="admin-table.html"><span class="am-icon-table"></span> 表格</a></li>
      <li><a href="admin-form.html"><span class="am-icon-pencil-square-o"></span> 表单</a></li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>注册公告，言论不要有敏感词汇，查水表，概不负责。—— Amaze UI</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> wiki</p>
        <p>Welcome to the May JV UI wiki!</p>
      </div>
    </div>
  </div>
  <!-- sidebar end -->
  <!-- content start -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>修改头像</small></div>
    </div>

    <hr/>

    <div class="am-g">

      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8" style="left:10%;">
        <div class="am-panel am-panel-default" style="width:600px">
          <div class="am-panel-bd">
            <div class="am-g">
              <div class="am-u-md-4">
                <img class="am-img-circle am-img-thumbnail" src="/videoBBS/picture.do?method=getPic&picId=<%=user.getPicId() %>" alt=""/>
              </div>
              <div class="am-u-md-8">
                <p><a href="#">meijv.com</a> </p>
                <form id="uploadForm" class="am-form" action="/videoBBS/adminUser.do?method=modifyPic&userId=<%=user.getId() %>&picId=<%=user.getPicId() %>" method="post" enctype="multipart/form-data">
                  <div class="am-form-group">
                    <input type="file" name="photo" id="user-pic">
                    <p class="am-form-help">请选择要上传的文件...</p>
                    <button type="button" id="uploadPic" class="am-btn am-btn-primary am-btn-xs">保存</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>


      </div>

      
    </div>
  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license. <a href="http://www.mycodes.net/" target="_blank">美剧之家</a></p>
</footer>

<!--[if lt IE 9]>
<script src="assets/js/jquery1.11.1.min.js"></script>
<script src="assets/js/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>
