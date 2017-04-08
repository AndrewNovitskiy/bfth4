<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<div>
    <a href="/index.jsp" title="index">Go To Web-Site</a>
    <a href="${pageContext.request.contextPath}/controller?command=all_users">Users</a>
    <a href="${pageContext.request.contextPath}/controller?command=vacancies_admin">Vacancies</a>
    <a href="${pageContext.request.contextPath}/controller?command=messages_admin">Messages</a>
    <a href="${pageContext.request.contextPath}/controller?command=applications_admin">Applications</a>
    <c:if test="${not empty sessionScope.admin}">
        <form action="${pageContext.request.contextPath}/controller" name='log_out_admin' method="post">
            <input type="submit" name="command" value="log_out_admin" title="Log OUT">
        </form>
    </c:if>
</div>
<table border="1">
    <tr>
        <th>
            ID_message
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Title
        </th>
        <th>
            Content
        </th>
        <th>
            DateTime
        </th>
        <th>
            Details...
        </th>
    </tr>
    <c:if test="${not empty requestScope.messages}">
        <c:forEach items="${requestScope.messages}" var="message">
            <tr>
                <th>${message.messageId}</th>
                <th>${message.recipientName}</th>
                <th>${message.recipientSurname}</th>
                <th>${message.title}</th>
                <th>${message.content}</th>
                <th>${message.dateTime}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=message&id=${message.messageId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
