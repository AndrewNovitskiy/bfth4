<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Vacancy</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
<h2>New Vacancy</h2>
<form action="${pageContext.request.contextPath}/admin/do" name="new_vacancy" method="post">

    <label>
        Position<br>
        <input type="text" name="position" required placeholder="Position" maxlength="45">
    </label><br><br>
<label>
    Experience<br>
    <input type="number" name="experience" required>
</label><br><br>
<label>
    Salary<br>
    <input type="number" name="salary" required>
</label><br><br>
<label>
    Info<br>
    <textarea name="info" maxlength="2000" required placeholder="Details about vacancy ..." rows="20" cols="100"></textarea>
</label><br>
    <input type="hidden" name="command" value="new_vacancy">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Add Vacancy" class="control_elem">
        </span>
    </div>
</form>
    </div>
</body>
</html>
