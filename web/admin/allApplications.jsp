<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Applications</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/table_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
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
        <th>
            Details...
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
                <th><a href="${pageContext.request.contextPath}/admin/do?command=application&id=${application.applicationId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
<br>
<div class="control_elem_container">
<span>
    <a href="${pageContext.request.contextPath}/admin/do?command=deleted_applications" class="control_elem">DELETED Applications</a>
</span>
</div>
</body>
</html>
