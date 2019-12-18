<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>

<h1>书本新增</h1>
${bookType}
<f:form action="${ctx}/book/addBook" method="post" modelAttribute="book">
   书名： <f:input path="bookName"/><f:errors path="bookName" cssClass="valid"></f:errors><br>
   价格： <f:input path="price"/><f:errors path="price" cssClass="valid"></f:errors><br>
    <input type="submit" value="确定">
</f:form>
</body>
</html>
