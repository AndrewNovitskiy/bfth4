<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel='stylesheet' href='style/registration_style.css' type='text/css' />
    <script src="script/registration_form_validation.js"></script>
</head>
<body>

<a href="/index.jsp" title="index">index.jsp</a>
<br>
<h1>Registration</h1>
<form action="${pageContext.request.contextPath}/do" name='registration' onSubmit="return formValidation();" method="post">
    <ul>
        <li><label>Login:</label></li>
        <li><input type="text" name="login" size="20" /></li>
        <span class="error" id="error-login"></span>
        <c:if test="${not empty requestScope.fail}">
            <span class="error">This login already exist</span>
        </c:if>

        <li><label>Password:</label></li>
        <li><input type="password" name="pass" size="20" /></li>
        <span class="error" id="error-pass"></span>

        <li><label>Confirm:</label></li>
        <li><input type="password" name="checkpass" size="20" /></li>
        <span class="error" id="error-checkpass"></span>

        <li><label>Name:</label></li>
        <li><input type="text" name="name" size="20" /></li>
        <span class="error" id="error-name"></span>

        <li><label>Surname:</label></li>
        <li><input type="text" name="surname" size="20" /></li>
        <span class="error" id="error-surname"></span>

        <li><label>Tel:</label></li>
        <li><input type="text" name="telephone" size="20" /></li>
        <span class="error" id="error-telephone"></span>

        <li><label>Email:</label></li>
        <li><input type="text" name="email" size="20" /></li>
        <span class="error" id="error-email"></span>


        <li><input type="submit" name="command" value="registration" /></li>
    </ul>
</form>

</body>
</html>
