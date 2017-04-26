<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In Admin</title>
</head>
<body>
Hello, unnamed admin!
<a href="/index.jsp" title="index">index.jsp</a>
<br>
<form action="${pageContext.request.contextPath}/do" name='log_in_admin' method="post">
    <label>
        login
        <input type="text" name="login" maxlength="45">
    </label>
    <br>
    <label>
        password
        <input type="password" name="password" maxlength="45">
    </label>
    <br>
    <input type="hidden" name="command" value="log_in_admin">
    <input type="submit" name="submit" value="Log In">
</form>
<c:if test="${not empty requestScope.fail}">
    <p style="color: red">Bad login or password</p>
</c:if>
</body>
</html>
