<%--
  Created by IntelliJ IDEA.
  Date: 2016/12/13 0024
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>活动管理</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>

    </style>
</head>
<body>
<div class="container">
    <h1>活动管理</h1>
    <hr/>

    <h3>所有活动 <a href="/addActivity" type="button" class="btn btn-default btn-sm">添加</a></h3>

    <!-- 如果活动列表为空 -->
    <c:if test="${empty activityList}">
        <p class="bg-warning">
            <br/>
            Activity表为空，请<a href="/addActivity" type="button" class="btn btn-default btn-sm">添加</a>
            <br/>
            <br/>
        </p>
    </c:if>

    <!-- 如果活动列表非空 -->
    <c:if test="${!empty activityList}">
        <table class="table table-bordered table-striped text-center">
            <tr>
                <th class="text-center">ID</th>
                <th class="text-center">部门</th>
                <th class="text-center">活动名称</th>
                <th class="text-center">时间</th>
                <th class="text-center">开销</th>
                <th class="text-center">操作</th>
            </tr>

            <c:forEach items="${activityList}" var="activity">
                <tr>
                    <td>${activity.id}</td>
                    <td>${activity.department}</td>
                    <td>${activity.name}</td>
                    <td>${activity.date}</td>
                    <td>${activity.spend}</td>
                    <td>
                        <a href="/showActivity/${activity.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/updateActivity/${activity.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                            <%--<a href="/deleteActivity/${activity.id}" type="button" class="btn btn-sm btn-danger">删除</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
