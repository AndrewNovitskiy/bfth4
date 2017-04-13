<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETED Applications</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>DELETED Applications</h2>
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
            DELETED
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
                <th>${application.deleted}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=application&id=${application.applicationId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
