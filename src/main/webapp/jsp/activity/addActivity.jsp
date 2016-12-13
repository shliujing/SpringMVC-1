<%--
  Created by IntelliJ IDEA.
  Date: 2016/12/13 0024
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>添加活动</title>

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
  <h1>添加活动</h1>
  <hr/>
  <form:form action="/addActivityPost" method="post" commandName="activity" role="form">
    <div class="form-group">
      <label for="department">部门：</label>
      <input type="text" class="form-control" id="department" name="department" placeholder="输入部门"/>
    </div>
    <div class="form-group">
      <label for="name">负责人：</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="输入负责人"/>
    </div>
    <div class="form-group">
      <label for="date">时间：</label>
      <input type="text" class="form-control" id="date" name="date" placeholder="输入时间"/>
    </div>
    <div class="form-group">
      <label for="spend">开销：</label>
      <input type="text" class="form-control" id="spend" name="spend" placeholder="输入开销"/>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-sm btn-success">提交</button>
    </div>
  </form:form>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
