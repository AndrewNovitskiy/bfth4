<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application #${requestScope.application.applicationId}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
<h2>Application Info</h2>
<p><label>Application ID : </label>${requestScope.application.applicationId}</p>
<p><label>Who : </label>${requestScope.application.applicantName} ${requestScope.application.applicantSurname}</p>
<p><label>Phone : </label>${requestScope.application.applicantTelephone}</p>
<p><label>Email : </label>${requestScope.application.applicantEmail}</p>
<p><label>Position : </label>${requestScope.application.vacancyPosition}</p>
<p><label>Status : </label>${requestScope.application.status}</p>


<form action="${pageContext.request.contextPath}/admin/do" name='change_status' method="post">
    <select size="1" name="app_status">
        <option disabled>Select new Status</option>
        <option value="1">Waiting for a call</option>
        <option value="2">Awaits an interview</option>
        <option value="3">Awaiting results</option>
        <option value="4">Recruited</option>
        <option value="5">Rejected</option>
    </select>
    <input type="hidden" name="id" value="${requestScope.application.applicationId}">
    <input type="hidden" name="applicant_id" value="${requestScope.application.applicantId}">
    <input type="hidden" name="vacancy_position" value="${requestScope.application.vacancyPosition}">
    <input type="hidden" name="applicant_name" value="${requestScope.application.applicantName}">
    <input type="hidden" name="command" value="change_status">
    <input type="submit" name="submit" value="Change Status">
</form>

    </div>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=user&id=${requestScope.application.applicantId}" class="control_elem">To User Page</a>
    </span>
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=vacancy&id=${requestScope.application.vacancyId}" class="control_elem">To Vacancy Page</a>
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
        <form id="restore_form" action="${pageContext.request.contextPath}/admin/do" name='restore_application' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="restore_application">
        </form>
    </c:when>
    <c:otherwise>
        <form id="delete_form" action="${pageContext.request.contextPath}/admin/do" name='delete_application_admin' method="post">
            <input type="hidden" name="id" value="${requestScope.application.applicationId}">
            <input type="hidden" name="command" value="delete_application_admin">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
