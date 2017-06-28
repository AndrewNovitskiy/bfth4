<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="register" /></title>
    <link rel='stylesheet' href='style/registration_style.css' type='text/css' />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="style/topbar_style.css">
    <link rel="stylesheet" href="style/menubar_style.css">
    <link rel="stylesheet" href="style/general_style.css">
    <link rel="stylesheet" href="style/control_element_style.css">
    <script src="script/registration_form_validation.js"></script>
</head>
<body>

<div id="container">

    <%@include file="include/topbar.jsp"%>
    <%@include file="include/header.jsp"%>
    <%@include file="include/menubar.jsp"%>
    <div id="mainblock">

        <h1><fmt:message key="register" /></h1>
        <c:if test="${not empty requestScope.validationFail}">
            <span class="error"><fmt:message key="validation.fail" /></span>
        </c:if>
        <form action="${pageContext.request.contextPath}/do" name='registration' onSubmit="return formValidation();"  method="post">
            <ul>
                <li><label><fmt:message key="login" />:</label></li>
                <li><input type="text" name="login" size="20" /></li>
                <span class="error" id="error-login"></span>
                <c:if test="${not empty requestScope.loginFail}">
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
            </ul>
            <input type="hidden" name="command" value="registration">
            <div class="control_elem_container">
                <span>
                    <input type="submit" name="submit" class="control_elem" value="<fmt:message key="submit" />" />
                </span>
            </div>
        </form>
    </div>
    <img src="style/resources/a.jpg" class="photo">
    <%@include file="include/footer.jsp"%>
</div>

</body>
</html>


