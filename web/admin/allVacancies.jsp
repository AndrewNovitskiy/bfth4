<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancies</title>
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
            ID_vacancy
        </th>
        <th>
            DateTime
        </th>
        <th>
            Position
        </th>
        <th>
            Experience
        </th>
        <th>
            Salary
        </th>
        <th>
            Details...
        </th>
    </tr>
    <c:if test="${not empty requestScope.vacancies}">
        <c:forEach items="${requestScope.vacancies}" var="vacancy">
            <tr>
                <th>${vacancy.vacancyId}</th>
                <th>${vacancy.dateTime}</th>
                <th>${vacancy.position}</th>
                <th>${vacancy.experience}</th>
                <th>${vacancy.salary}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=vacancy&id=${vacancy.vacancyId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
<br>
<a href="/admin/newVacancy.jsp" title="Add New Vacancy">Add New Vacancy</a>
<br>
<a href="${pageContext.request.contextPath}/controller?command=deleted_vacancies">DELETED Vacancies</a><br>
</body>
</html>
