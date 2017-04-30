<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Vacancy ${requestScope.vacancy.position}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
<h2>Update Vacancy ${requestScope.vacancy.position}</h2>
<form action="${pageContext.request.contextPath}/admin/do" name="update_vacancy" method="post">

    <label>
        Position<br>
        <input type="text" name="position" required placeholder="Position" maxlength="45" value="${requestScope.vacancy.position}">
    </label><br><br>
    <label>
        Experience<br>
        <input type="number" name="experience" required value="${requestScope.vacancy.experience}">
    </label><br><br>
    <label>
        Salary<br>
        <input type="number" name="salary" required value="${requestScope.vacancy.salary}">
    </label><br><br>
    <label>
        Info<br>
        <textarea name="info" maxlength="2000" required placeholder="Details about vacancy ..." rows="20" cols="100">${requestScope.vacancy.info}</textarea>
    </label><br>
    <input type="hidden" name="id" value="${requestScope.vacancy.vacancyId}">
    <input type="hidden" name="command" value="update_vacancy">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Update Vacancy" class="control_elem">
        </span>
    </div>

</form>
    </div>
</body>
</html>
