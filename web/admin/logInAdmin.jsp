<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In Admin</title>
    <link rel="stylesheet" href="../style/login_style.css">
</head>
<body>
<h2><a href="/index.jsp" title="index">Atlanta-Soft</a></h2>
<form action="${pageContext.request.contextPath}/do" name='log_in_admin' method="post">
    <label>
        login<br>
        <input type="text" class="field" name="login" maxlength="45">
    </label>
    <br>
    <label>
        password<br>
        <input type="password" class="field" name="password" maxlength="45">
    </label>
    <br><br>
    <input type="hidden" name="command" value="log_in_admin">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Log In" class="control_elem">
        </span>
    </div>
</form>
<c:if test="${not empty requestScope.fail}">
    <p id="fail">Bad login or password</p>
</c:if>
</body>
</html>
