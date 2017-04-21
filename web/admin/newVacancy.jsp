<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Vacancy</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>New Vacancy</h2>
<form action="${pageContext.request.contextPath}/admin/do" name="new_vacancy" method="post">

    <label>
        Position<br>
        <input type="text" name="position" required placeholder="Position">
    </label><br>
<label>
    Experience<br>
    <input type="number" name="experience" required>
</label><br>
<label>
    Salary<br>
    <input type="number" name="salary" required>
</label><br>
<label>
    Info<br>
    <textarea name="info" maxlength="800" required placeholder="Details about vacancy ..." rows="20" cols="50"></textarea>
</label><br>
    <input type="hidden" name="command" value="new_vacancy">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Add Vacancy" class="control_elem">
        </span>
    </div>
</form>
</body>
</html>
