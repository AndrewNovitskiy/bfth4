<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h2>Message Info</h2>
<p>${requestScope.message.dateTime}</p>
<p>${requestScope.message.recipientName}</p>
<p>${requestScope.message.recipientSurname}</p>
<p>${requestScope.message.title}</p>
<p>${requestScope.message.content}</p>
<br>
<a href="${pageContext.request.contextPath}/controller?command=user&id=${requestScope.message.recipientId}">User</a>
</body>
</html>
