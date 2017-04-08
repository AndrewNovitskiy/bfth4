<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.user.name} ${requestScope.user.surname}</title>
</head>
<body>
<div>
    <a href="/index.jsp" title="index">Go To Web-Site</a>
    <a href="${pageContext.request.contextPath}/controller?command=all_users">Users</a>
    <a href="${pageContext.request.contextPath}/controller?command=vacancies_admin">Vacancies</a>
    <a href="${pageContext.request.contextPath}/controller?command=messages_admin">Messages</a>
    <a href="${pageContext.request.contextPath}/controller?command=applications_admin">Applications</a>
    <c:if test="${not empty sessionScope.admin}">
        <form action="${pageContext.request.contextPath}/controller" name='log_out_admin' method="post">
            <input type="submit" name="command" value="log_out_admin" title="Log OUT">
        </form>
    </c:if>
</div>
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
