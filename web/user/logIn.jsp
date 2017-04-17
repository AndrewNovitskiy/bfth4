<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <link rel="stylesheet" href="style/logIn_style.css">
</head>
<body>
<a href="/index.jsp" title="index">index.jsp</a>
<br>
<div class="block">
    <form class="vsio" action="${pageContext.request.contextPath}/do" name='log_in' method="post">
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
    </div>
</body>
</html>
