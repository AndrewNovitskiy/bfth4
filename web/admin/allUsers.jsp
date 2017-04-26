<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/table_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<table border="1">
    <tr>
        <th>
            ID_applicant
        </th>
        <th>
            Login
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Telephone
        </th>
        <th>
            Email
        </th>
        <th>
            Details
        </th>
    </tr>
<c:if test="${not empty requestScope.users}">
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <th>${user.applicantId}</th>
            <th>${user.login}</th>
            <th>${user.name}</th>
            <th>${user.surname}</th>
            <th>${user.telephone}</th>
            <th>${user.email}</th>
            <th><a href="${pageContext.request.contextPath}/admin/do?command=user&id=${user.applicantId}">Details...</a><br></th>
        </tr>
    </c:forEach>
</c:if>
</table>
<br>
<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=recruited_users" class="control_elem">Recruited people</a>
    </span>
</div>
</body>
</html>
