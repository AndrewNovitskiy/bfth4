<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="change.password" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/login_style.css">
    <script src="../script/change_password_form_validation.js"></script>
</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">


        <div class="block" style="align-content: center;">
            <h2><fmt:message key="change.password" /></h2>
            <form action="${pageContext.request.contextPath}/do" onSubmit="return formValidation();" name='change_pwd' method="post">
                <c:if test="${not empty requestScope.validationFail}">
                    <span class="error"><fmt:message key="validation.fail" /></span>
                </c:if><br>
                <label>
                    <fmt:message key="new.password" /><br>
                    <input type="password" class="field" name="new_password" maxlength="45">
                    <span class="error" id="error-pass"></span>
                </label>
                <br>
                <label>
                    <fmt:message key="confirm" /><br>
                    <input type="password" class="field" name="confirmation" maxlength="45">
                    <span class="error" id="error-checkpass"></span>
                </label>
                <br><br>

                <input type="hidden" name="command" value="change_password">

                <div class="control_elem_container">
                    <span>
                        <input type="submit" name="submit" value="<fmt:message key="submit" />" class="control_elem">
                    </span>
                </div>
            </form>
        </div>
    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
