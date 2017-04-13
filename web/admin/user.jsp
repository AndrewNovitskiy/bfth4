<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.user.name} ${requestScope.user.surname}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>Info about User</h2>
    <p>${requestScope.user.idApplicant}</p>
    <p>${requestScope.user.login}</p>
    <p>${requestScope.user.name}</p>
    <p>${requestScope.user.surname}</p>
    <p>${requestScope.user.telephone}</p>
    <p>${requestScope.user.email}</p>
    <p>${requestScope.user.resume}</p>
<br>


<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=usapps&id=${requestScope.user.idApplicant}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Apps Of User</a>
</span>
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=usmess&id=${requestScope.user.idApplicant}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Messages for User</a>
</span>
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=new_message&id=${requestScope.user.idApplicant}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Write</a>
</span>
</div>

</body>
</html>
