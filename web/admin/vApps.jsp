<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
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
                <th><a href="${pageContext.request.contextPath}/do?command=application&id=${application.applicationId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
