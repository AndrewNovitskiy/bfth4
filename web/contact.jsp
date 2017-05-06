<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title>Contact</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="style/topbar_style.css">
    <link rel="stylesheet" href="style/menubar_style.css">
    <link rel="stylesheet" href="style/general_style.css">
    <link rel="stylesheet" href="style/contact_style.css">
</head>
<body>

<div id="container">
    <%@include file="include/topbar.jsp"%>
    <%@include file="include/header.jsp"%>
    <%@include file="include/menubar.jsp"%>
    <div id="mainblock">

        <div class="block">

            <h2><fmt:message key="text7" /></h2>
            <label><fmt:message key="phone" /> : </label> <span>+375 (29) 850-13-16</span>
            <br><br>
            <label><fmt:message key="email" /> : </label> <span>info@atl-soft.com</span>
            <br><br>
        </div>
    </div>
    <img src="style/resources/a.jpg" class="photo">
    <%@include file="include/footer.jsp"%>
</div>
</body>
</html>
