<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application #${requestScope.application.applicationId}</title>
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


<form action="${pageContext.request.contextPath}/do" name='change_status' method="post">
    <select size="1" name="app_status">
        <option disabled>Select new Status</option>
        <option value="1">Waiting for a call</option>
        <option value="2">Awaits an interview</option>
        <option value="3">Awaiting results</option>
        <option value="4">Recruited</option>
        <option value="5">Rejected</option>
    </select>
    <input type="hidden" name="id" value="${requestScope.application.applicationId}">
    <input type="hidden" name="command" value="change_status">
    <input type="submit" name="submit" value="Change Status">
</form>


<p>DELETED ${requestScope.application.deleted}</p>
<br>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/do?command=user&id=${requestScope.application.applicantId}" class="control_elem">To User Page</a>
    </span>
    <span>
        <a href="${pageContext.request.contextPath}/do?command=vacancy&id=${requestScope.application.vacancyId}" class="control_elem">To Vacancy Page</a>
    </span>
    <span>
        <c:choose>
            <c:when test="${requestScope.application.deleted}">
                <input form="restore_form" type="submit" name="submit" value="Restore" class="control_elem">
            </c:when>
            <c:otherwise>
                <input form="delete_form" type="submit" name="submit" value="Delete" class="control_elem">
            </c:otherwise>
        </c:choose>
    </span>
</div>




<c:choose>
    <c:when test="${requestScope.application.deleted}">
        <form id="restore_form" action="${pageContext.request.contextPath}/do" name='restore_application' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="restore_application">
        </form>
    </c:when>
    <c:otherwise>
        <form id="delete_form" action="${pageContext.request.contextPath}/do" name='delete_application_admin' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="delete_application_admin">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
