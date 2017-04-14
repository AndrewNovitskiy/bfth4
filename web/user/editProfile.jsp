<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">

</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">



        <form action="${pageContext.request.contextPath}/controller" name='update_profile' onSubmit="return formValidation();" method="post">


            <br>
                <label>Name:</label>
                <input type="text" name="name" size="20" />
                <span class="error" id="error-name"></span>
            <br>
                <label>Surname:</label>
                <input type="text" name="surname" size="20" />
                <span class="error" id="error-surname"></span>
            <br>
                <label>Tel:</label>
                <input type="text" name="telephone" size="20" />
                <span class="error" id="error-telephone"></span>
            <br>
                <label>Email:</label>
                <input type="text" name="email" size="20" />
                <span class="error" id="error-email"></span>
            <br>
                <label>Resume:</label>
                <textarea name="resume" maxlength="1500" placeholder="Your Resume ..." rows="30" cols="50"></textarea>
            <br>



                <input type="submit" name="command" value="registration" />

        </form>




    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
