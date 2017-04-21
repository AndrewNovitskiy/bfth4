<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>Message Info</h2>
<p>${requestScope.message.dateTime}</p>
<p>${requestScope.message.recipientName}</p>
<p>${requestScope.message.recipientSurname}</p>
<p>${requestScope.message.title}</p>
<p>${requestScope.message.content}</p>
<br>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=user&id=${requestScope.message.recipientId}" class="control_elem">User</a>
    </span>
</div>


</body>
</html>
