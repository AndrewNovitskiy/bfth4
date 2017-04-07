<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.user.name} ${requestScope.user.surname}</title>
</head>
<body>
<h2>Info about User</h2>
    <p>${requestScope.user.idApplicant}</p>
    <p>${requestScope.user.login}</p>
    <p>${requestScope.user.name}</p>
    <p>${requestScope.user.surname}</p>
    <p>${requestScope.user.telephone}</p>
    <p>${requestScope.user.email}</p>
    <p>${requestScope.user.resume}</p>
<br>
<a href="${pageContext.request.contextPath}/controller?command=usapps&id=${requestScope.user.idApplicant}&name=${requestScope.user.name}&surname=${requestScope.user.surname}">Apps Of User</a><br>
<a href="${pageContext.request.contextPath}/controller?command=usmess&id=${requestScope.user.idApplicant}&name=${requestScope.user.name}&surname=${requestScope.user.surname}">Messages for User</a><br>

</body>
</html>
