<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancy ${requestScope.vacancy.position}</title>
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
    <h2>Vacancy Info</h2>
    <p>${requestScope.vacancy.vacancyId}</p>
    <p>${requestScope.vacancy.dateTime}</p>
    <p>${requestScope.vacancy.position}</p>
    <p>${requestScope.vacancy.experience}</p>
    <p>${requestScope.vacancy.salary}</p>
    <p>${requestScope.vacancy.info}</p>
<br>
    <a href="${pageContext.request.contextPath}/controller?command=vapps&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}">Apps Of Vacancy</a><br>
    <a href="${pageContext.request.contextPath}/controller?command=edit_vacancy&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}">Edit Vacancy</a><br>

</body>
</html>
