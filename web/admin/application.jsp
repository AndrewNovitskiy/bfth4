<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application ${requestScope.application.applicationId}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>Application Info</h2>
<p>${requestScope.application.applicationId}</p>
<p>${requestScope.application.applicantName}</p>
<p>${requestScope.application.applicantSurname}</p>
<p>${requestScope.application.applicantTelephone}</p>
<p>${requestScope.application.applicantEmail}</p>
<p>${requestScope.application.vacancyPosition}</p>
<p>${requestScope.application.status}</p>
<p>DELETED ${requestScope.application.deleted}</p>
<br>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=user&id=${requestScope.application.applicantId}" class="control_elem">To User Page</a>
    </span>
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=vacancy&id=${requestScope.application.vacancyId}" class="control_elem">To Vacancy Page</a>
    </span>
</div>




<c:choose>
    <c:when test="${requestScope.application.deleted}">
        <form action="${pageContext.request.contextPath}/controller" name='restore_application' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="restore_application">
            <input type="submit" name="submit" value="Restore">
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/controller" name='delete_application' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="delete_application">
            <input type="submit" name="submit" value="Delete">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
