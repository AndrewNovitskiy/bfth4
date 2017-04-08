<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application ${requestScope.application.applicationId}</title>
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
<h2>Application Info</h2>
<p>${requestScope.application.applicationId}</p>
<p>${requestScope.application.applicantName}</p>
<p>${requestScope.application.applicantSurname}</p>
<p>${requestScope.application.applicantTelephone}</p>
<p>${requestScope.application.applicantEmail}</p>
<p>${requestScope.application.vacancyPosition}</p>
<p>${requestScope.application.status}</p>
<br>
<a href="${pageContext.request.contextPath}/controller?command=user&id=${requestScope.application.applicantId}">To User Page</a>
<br>
<a href="${pageContext.request.contextPath}/controller?command=vacancy&id=${requestScope.application.vacancyId}">To Vacancy Page</a>

</body>
</html>
