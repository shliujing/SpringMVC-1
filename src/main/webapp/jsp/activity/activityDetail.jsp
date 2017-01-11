<%--
  Created by IntelliJ IDEA.
  Date: 2016/12/13 0024
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>活动详情</title>

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="/css/bootstrap.min.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <h1>活动详情</h1>
  <hr/>

  <table class="table tavble-bordered table-striped">
    <tr>
      <th>ID</th>
      <td>${activity.id}</td>
    </tr>
    <tr>
      <th>部门</th>
      <td>${activity.department}</td>
    </tr>
    <tr>
      <th>活动名称</th>
      <td>${activity.name}</td>
    </tr>
    <tr>
      <th>时间</th>
      <td>${activity.date}</td>
    </tr>
    <tr>
      <th>开销</th>
      <td>${activity.spend}</td>
    </tr>
  </table>

    <input type="button" value="返回" class="btn btn-default" onclick="history.back(-1);">
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>