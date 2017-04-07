<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application ${requestScope.application.applicationId}</title>
</head>
<body>
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
