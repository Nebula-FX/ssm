
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>
图片上传
<form action="${ctx}/myFile/upload" method="post" enctype="multipart/form-data">
   书本编号:<input type="text" name="bookId" value="${param.bookId}">
    <br>
   <input type="file" name="file" >
    <br>
    <input type="submit" value="确定" >
</form>

</body>
</html>
