<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancies</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/table_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
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
                <th><a href="${pageContext.request.contextPath}/admin/do?command=vacancy&id=${vacancy.vacancyId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
<br>
<div class="control_elem_container">
<span>
    <a href="/admin/newVacancy.jsp" title="Add New Vacancy" class="control_elem">Add New Vacancy</a>
</span>
<span>
    <a href="${pageContext.request.contextPath}/admin/do?command=deleted_vacancies" class="control_elem">DELETED Vacancies</a>
</span>
    </div>
</body>
</html>
