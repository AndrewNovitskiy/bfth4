<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="profile" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/profile_style.css">
</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">

        <div class="block">
            <div>
                <h2><fmt:message key="profile" /></h2>
                <label><fmt:message key="login" /> : </label> <span>${sessionScope.user.login}</span><br><br>
                <label><fmt:message key="password" /> : </label> <span>${sessionScope.user.password}</span><br><br>
                <label><fmt:message key="name" /> : </label> <span>${sessionScope.user.name}</span><br><br>
                <label><fmt:message key="surname" /> : </label> <span>${sessionScope.user.surname}</span><br><br>
                <label><fmt:message key="phone" /> : </label> <span>${sessionScope.user.telephone}</span><br><br>
                <label><fmt:message key="email" /> : </label> <span>${sessionScope.user.email}</span><br><br>
                <label><fmt:message key="resume" /> : </label> <span>${requestScope.resume}</span><br><br>
            </div>

        </div>

        <form action="${pageContext.request.contextPath}/user/do" name='edit_profile' method="post">
            <input type="hidden" name="command" value="edit_profile">
            <div class="control_elem_container">
                <span>
                    <input type="submit" name="submit" class="control_elem" value="<fmt:message key="edit.profile" />">
                </span>
                <span>
                    <a href="changePassword.jsp" class="control_elem"><fmt:message key="change.password" /></a>
                </span>
            </div>
        </form>
    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
