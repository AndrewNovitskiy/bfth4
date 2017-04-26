<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="log.in" /></title>
    <link rel="stylesheet" href="style/logIn_style.css">
</head>
<body>
<a href="/index.jsp" title="index">index.jsp</a>
<br>
<div class="block">
    <form class="vsio" action="${pageContext.request.contextPath}/do" name='log_in' method="post">
        <label>
            <fmt:message key="login" />
            <input type="text" name="login" maxlength="45">
        </label>
        <br>
        <label>
            <fmt:message key="password" />
            <input type="password" name="password" maxlength="45">
        </label>
        <br>
        <input type="submit" name="command" value="log_in" title="Log IN">
    </form>
    <c:if test="${not empty requestScope.fail}">
        <p style="color: red"><fmt:message key="bad.login.password" /></p>
    </c:if>
    </div>

</body>
</html>
