<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message Details</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
    <h2>Message Details</h2>
    <p><label>Date/Time : </label>${requestScope.message.dateTime}</p>
    <p><label>Recipient : </label>${requestScope.message.recipientName} ${requestScope.message.recipientSurname}</p>
    <p><label>Theme : </label>${requestScope.message.title}</p>
    <p>${requestScope.message.content}</p>
</div>
<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=user&id=${requestScope.message.recipientId}" class="control_elem">User</a>
    </span>
</div>


</body>
</html>
