<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
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
                <h2>My Profile</h2>
                <label>Login : </label> <span>${sessionScope.user.login}</span><br><br>
                <label>Password : </label> <span>${sessionScope.user.password}</span><br><br>
                <label>Name : </label> <span>${sessionScope.user.name}</span><br><br>
                <label>Surname : </label> <span>${sessionScope.user.surname}</span><br><br>
                <label>Tel : </label> <span>${sessionScope.user.telephone}</span><br><br>
                <label>Email : </label> <span>${sessionScope.user.email}</span><br><br>
                <label>Resume : </label> <span>${requestScope.resume}</span><br><br>
            </div>

            <div class="control_elem_container">
                <span>
                    <a href="user/editProfile.jsp" class="control_elem">Edit Information</a>
                </span>
            </div>

        </div>
    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
