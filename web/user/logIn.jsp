<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="log.in" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/login_style.css">
</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">


        <div class="block" style="align-content: center;">
            <form action="${pageContext.request.contextPath}/do" name='log_in' method="post">
                <label>
                    <fmt:message key="login" /><br>
                    <input type="text" class="field" name="login" maxlength="45">
                </label>
                <br>
                <label>
                    <fmt:message key="password" /><br>
                    <input type="password" class="field" name="password" maxlength="45">
                </label>
                <br><br>

                <input type="hidden" name="command" value="log_in">

                <div class="control_elem_container">
                    <span>
                        <input type="submit" name="submit" value="<fmt:message key="log.in" />" class="control_elem" title="Log IN">
                    </span>
                </div>
            </form>
            <c:if test="${not empty requestScope.fail}">
                <p id="fail"><fmt:message key="bad.login.password" /></p>
            </c:if>

        </div>

    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
