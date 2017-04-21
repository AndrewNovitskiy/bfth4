<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="register" /></title>
    <link rel='stylesheet' href='style/registration_style.css' type='text/css' />

</head>
<body>

<a href="/index.jsp" title="index">index.jsp</a>
<br>
<h1><fmt:message key="register" /></h1>
<form action="${pageContext.request.contextPath}/do" name='registration' onSubmit="return formValidation();" method="post">
    <ul>
        <li><label><fmt:message key="login" />:</label></li>
        <li><input type="text" name="login" size="20" /></li>
        <span class="error" id="error-login"></span>
        <c:if test="${not empty requestScope.fail}">
            <span class="error"><fmt:message key="login.exists" /></span>
        </c:if>

        <li><label><fmt:message key="password" />:</label></li>
        <li><input type="password" name="pass" size="20" /></li>
        <span class="error" id="error-pass"></span>

        <li><label><fmt:message key="confirm" />:</label></li>
        <li><input type="password" name="checkpass" size="20" /></li>
        <span class="error" id="error-checkpass"></span>

        <li><label><fmt:message key="name" />:</label></li>
        <li><input type="text" name="name" size="20" /></li>
        <span class="error" id="error-name"></span>

        <li><label><fmt:message key="surname" />:</label></li>
        <li><input type="text" name="surname" size="20" /></li>
        <span class="error" id="error-surname"></span>

        <li><label><fmt:message key="phone" />:</label></li>
        <li><input type="text" name="telephone" size="20" /></li>
        <span class="error" id="error-telephone"></span>

        <li><label><fmt:message key="email" />:</label></li>
        <li><input type="text" name="email" size="20" /></li>
        <span class="error" id="error-email"></span>


        <li><input type="submit" name="command" value="registration" /></li>
    </ul>
</form>

</body>
</html>
