<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Vacancy ${requestScope.position}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>Update Vacancy ${requestScope.position}</h2>
<form action="${pageContext.request.contextPath}/admin/do" name="update_vacancy" method="post">

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
    <input type="hidden" name="id" value="${requestScope.id}">
    <input type="hidden" name="command" value="update_vacancy">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Update Vacancy" class="control_elem">
        </span>
    </div>

</form>
</body>
</html>
