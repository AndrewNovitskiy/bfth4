<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<a href="/index.jsp" title="index">index.jsp</a>
<br>
    <form action="${pageContext.request.contextPath}/controller" name='log_in' method="post">
        <label>
            login
            <input type="text" name="login">
        </label>
        <br>
        <label>
            password
            <input type="password" name="password">
        </label>
        <br>
        <input type="submit" name="command" value="log_in" title="Log IN">
    </form>
    <c:if test="${not empty requestScope.fail}">
        <p style="color: red">Bad login or password</p>
    </c:if>
</body>
</html>
