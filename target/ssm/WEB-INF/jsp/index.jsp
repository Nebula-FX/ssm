<%--
  Created by IntelliJ IDEA.
  User: Admin-FX
  Date: 2019/12/6
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="r" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<br>

<h1><t:message code="title"></t:message></h1>

<a href="${ctx}/book/toAdd"><t:message code="add.lable"></t:message></a>

<a href="${ctx}/book/listBook"><t:message code="list.lable"></t:message></a>


<div>
    <a href="${ctx}/book/listAll">滴滴</a>
    <r:hasPermission name="bookmanager:book:query">
    <a href="${ctx}/book/list1">返回单个对象</a>
    </r:hasPermission>
    <a href="${ctx}/book/list2">返回ListMap</a>
</div>

<r:hasRole name="管理员">
<div>
    <a href="${ctx}/change?locale=zh">中文</a>
    <a href="${ctx}/change?locale=en">English</a>
</div>
</r:hasRole>
</body>
</html>
