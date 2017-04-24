<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="edit.profile" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/edit_profile_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">

</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">

<h2><fmt:message key="editing" /></h2>

        <form action="${pageContext.request.contextPath}/user/do" name='update_profile' method="post">

                <label><fmt:message key="name" />:</label><br>
                <input type="text" name="name" size="20" />
                <span class="error" id="error-name"></span>
            <br><br>
                <label><fmt:message key="surname" />:</label><br>
                <input type="text" name="surname" size="20" />
                <span class="error" id="error-surname"></span>
            <br><br>
                <label><fmt:message key="phone" />:</label><br>
                <input type="text" name="telephone" size="20" />
                <span class="error" id="error-telephone"></span>
            <br><br>
                <label><fmt:message key="email" />:</label><br>
                <input type="text" name="email" size="20" />
                <span class="error" id="error-email"></span>
            <br><br>
                <label><fmt:message key="resume" />:</label><br>
                <textarea name="resume" maxlength="1500" placeholder="Your Resume ..." rows="30" cols="50"></textarea>
            <br><br>


                <input type="hidden" name="command" value="update_profile">

            <div class="control_elem_container">
                <span>
                    <input type="submit" name="submit" class="control_elem button" value="<fmt:message key="update.profile" />" />
                </span>
            </div>

        </form>

    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
