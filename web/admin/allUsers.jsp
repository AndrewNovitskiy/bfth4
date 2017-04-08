<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
            ID_applicant
        </th>
        <th>
            Login
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Telephone
        </th>
        <th>
            Email
        </th>
        <th>
            Details
        </th>
    </tr>
<c:if test="${not empty requestScope.users}">
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <th>${user.idApplicant}</th>
            <th>${user.login}</th>
            <th>${user.name}</th>
            <th>${user.surname}</th>
            <th>${user.telephone}</th>
            <th>${user.email}</th>
            <th><a href="${pageContext.request.contextPath}/controller?command=user&id=${user.idApplicant}">Details...</a><br></th>
        </tr>
    </c:forEach>
</c:if>
</table>
</body>
</html>
