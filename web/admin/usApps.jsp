<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.name} ${requestScope.surname} applications</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>${requestScope.name} ${requestScope.surname} applications</h2>
<table border="1">
    <tr>
        <th>
            ID_application
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
                <th>${application.vacancyPosition}</th>
                <th>${application.status}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=application&id=${application.applicationId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
