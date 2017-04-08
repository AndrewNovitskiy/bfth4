<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h2>Applications For ${requestScope.position}</h2>
<table border="1">
    <tr>
        <th>
            ID_application
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Position
        </th>
        <th>
            Status
        </th>
    </tr>
    <c:if test="${not empty requestScope.applications}">
        <c:forEach items="${requestScope.applications}" var="application">
            <tr>
                <th>${application.applicationId}</th>
                <th>${application.applicantName}</th>
                <th>${application.applicantSurname}</th>
                <th>${application.vacancyPosition}</th>
                <th>${application.status}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=application&id=${application.applicationId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
