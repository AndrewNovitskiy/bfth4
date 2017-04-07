<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.jsp" title="index">index.jsp</a>
<br>
<c:if test="${not empty sessionScope.user}">

        <tr>
            <th>${sessionScope.user.idApplicant}</th>
            <th>${sessionScope.user.login}</th>
            <th>${sessionScope.user.password}</th>
            <th>${sessionScope.user.name}</th>
            <th>${sessionScope.user.surname}</th>
            <th>${sessionScope.user.telephone}</th>
            <th>${sessionScope.user.email}</th>
        </tr>

</c:if>
<c:if test="${not empty sessionScope.user}">
    <form action="${pageContext.request.contextPath}/controller" name='log_out' method="post">
        <input type="submit" name="command" value="log_out" title="Log OUT">
    </form>
</c:if>
</body>
</html>
