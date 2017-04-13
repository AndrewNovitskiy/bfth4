<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancy ${requestScope.vacancy.position}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
    <h2>Vacancy Info</h2>
    <p>${requestScope.vacancy.vacancyId}</p>
    <p>${requestScope.vacancy.dateTime}</p>
    <p>${requestScope.vacancy.position}</p>
    <p>${requestScope.vacancy.experience}</p>
    <p>${requestScope.vacancy.salary}</p>
    <p>${requestScope.vacancy.info}</p>
    <p>DELETED ${requestScope.vacancy.deleted}</p>
<br>


<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=vapps&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}" class="control_elem">Apps Of Vacancy</a>
   </span>
    <span>
        <a href="${pageContext.request.contextPath}/controller?command=edit_vacancy&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}" class="control_elem">Edit Vacancy</a>
</span>
</div>


<c:choose>
    <c:when test="${requestScope.vacancy.deleted}">
        <form action="${pageContext.request.contextPath}/controller" name='restore_vacancy' method="post">
            <input type="hidden" name="id" value="${requestScope.vacancy.vacancyId}">
            <input type="hidden" name="command" value="restore_vacancy">
            <input type="submit" name="submit" value="Restore">
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/controller" name='delete_vacancy' method="post">
            <input type="hidden" name="id" value="${requestScope.vacancy.vacancyId}">
            <input type="hidden" name="command" value="delete_vacancy">
            <input type="submit" name="submit" value="Delete">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
