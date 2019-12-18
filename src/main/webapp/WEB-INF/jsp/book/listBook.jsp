<%--
  Created by IntelliJ IDEA.
  User: Admin-FX
  Date: 2019/12/7
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<%--书本查询--%>
<%--${bookList}--%>
<%--${pageBean}--%>
<form action="${ctx}/book/listBook" method="post">
    书名:<input type="text" name="bookName">
    <input type="submit" value="确定">
</form>
<table border="1" width="99%">
    <tr>
        <td>书本编号</td>
        <td>书本名称</td>
        <td>书本价格</td>
        <td>操作</td>
    </tr>
        <c:forEach items="${books}" var="v">
            <tr>
                <td>${v.bookId}</td>
                <td>${v.bookName}</td>
                <td>${v.price}</td>
                <td><img src="${ctx}/myFile/download?fileId=${v.img}"><td>
                    <a href="${ctx}/book/toUpload?bookId=${v.bookId}">上传图片</a>
                </td>
            </tr>
        </c:forEach>
${pageBaen}
</table>
</body>
</html>
