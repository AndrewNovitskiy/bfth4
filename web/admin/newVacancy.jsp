<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Vacancy</title>
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
<h2>New Vacancy</h2>
<form action="${pageContext.request.contextPath}/controller" name="new_vacancy" method="post">

    <label>
        Position<br>
        <input type="text" name="position" required placeholder="Position">
    </label><br>
<label>
    Experience<br>
    <input type="number" name="experience" required>
</label><br>
<label>
    Salary<br>
    <input type="number" name="salary" required>
</label><br>
<label>
    Info<br>
    <textarea name="info" maxlength="800" required placeholder="Details about vacancy ..." rows="20" cols="50"></textarea>
</label><br>
    <input type="hidden" name="command" value="new_vacancy">
    <input type="submit" name="submit" value="Add Vacancy">
</form>
</body>
</html>
