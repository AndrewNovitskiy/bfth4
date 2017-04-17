<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETED Vacancies</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>DELETED Vacancies</h2>
<table border="1">
    <tr>
        <th>
            ID_vacancy
        </th>
        <th>
            DateTime
        </th>
        <th>
            Position
        </th>
        <th>
            Experience
        </th>
        <th>
            Salary
        </th>
        <th>
            DELETED
        </th>
        <th>
            Details...
        </th>
    </tr>
    <c:if test="${not empty requestScope.vacancies}">
        <c:forEach items="${requestScope.vacancies}" var="vacancy">
            <tr>
                <th>${vacancy.vacancyId}</th>
                <th>${vacancy.dateTime}</th>
                <th>${vacancy.position}</th>
                <th>${vacancy.experience}</th>
                <th>${vacancy.salary}</th>
                <th>${vacancy.deleted}</th>
                <th><a href="${pageContext.request.contextPath}/do?command=vacancy&id=${vacancy.vacancyId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
