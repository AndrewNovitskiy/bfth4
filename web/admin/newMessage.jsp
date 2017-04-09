<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Message  for ${requestScope.name} ${requestScope.surname}</title>
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
<h2>New Message  for ${requestScope.name} ${requestScope.surname}</h2>
<form action="${pageContext.request.contextPath}/controller" name="send_message" method="post">

    <label>
        Title<br>
        <input type="text" name="title" required placeholder="Enter theme of message ... ">
    </label><br>

    <label>
        Text<br>
        <textarea name="content" maxlength="200" required placeholder="Text of message ... " rows="10" cols="50"></textarea>
    </label><br>
    <input type="hidden" name="recipient" value="${requestScope.id}">
    <input type="hidden" name="command" value="send_message">
    <input type="submit" name="submit" value="Send">
</form>
</body>
</html>
