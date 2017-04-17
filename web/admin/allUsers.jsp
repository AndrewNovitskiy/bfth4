<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
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
            <th>${user.idApplicant}</th>
            <th>${user.login}</th>
            <th>${user.name}</th>
            <th>${user.surname}</th>
            <th>${user.telephone}</th>
            <th>${user.email}</th>
            <th><a href="${pageContext.request.contextPath}/do?command=user&id=${user.idApplicant}">Details...</a><br></th>
        </tr>
    </c:forEach>
</c:if>
</table>
</body>
</html>
