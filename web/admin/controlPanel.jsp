<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN HERE, MTHRFCKERS</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/vacancies_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>


<h2>Control panel</h2>


<a href="${pageContext.request.contextPath}/controller?command=all_users">Users</a><br>
<a href="${pageContext.request.contextPath}/controller?command=vacancies_admin">Vacancies</a><br>
<a href="${pageContext.request.contextPath}/controller?command=messages_admin">Messages</a><br>
<a href="${pageContext.request.contextPath}/controller?command=applications_admin">Applications</a><br>


</body>
</html>
