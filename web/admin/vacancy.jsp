<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancy ${requestScope.vacancy.position}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
    <h2>Vacancy Info</h2>
<p><label>ID : </label>${requestScope.vacancy.vacancyId}</p>
<p><label>Date/Time : </label>${requestScope.vacancy.dateTime}</p>
<p><label>Position : </label>${requestScope.vacancy.position}</p>
<p><label>Experience : </label>${requestScope.vacancy.experience}</p>
<p><label>Salary : </label>${requestScope.vacancy.salary}</p>
<p><label>Info : </label>${requestScope.vacancy.info}</p>

</div>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=vapps&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}" class="control_elem">Apps Of Vacancy</a>
   </span>
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=vdelapps&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}" class="control_elem">DELETED Apps Of Vacancy</a>
   </span>
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=edit_vacancy&id=${requestScope.vacancy.vacancyId}&position=${requestScope.vacancy.position}" class="control_elem">Edit Vacancy</a>
</span>
    <span>
        <c:choose>
            <c:when test="${requestScope.vacancy.deleted}">
                <input form="restore_form" type="submit" name="submit" value="Restore" class="control_elem">
            </c:when>
            <c:otherwise>
                <input form="delete_form" type="submit" name="submit" value="Delete" class="control_elem">
            </c:otherwise>
        </c:choose>
    </span>
</div>


<c:choose>
    <c:when test="${requestScope.vacancy.deleted}">
        <form id="restore_form" action="${pageContext.request.contextPath}/admin/do" name='restore_vacancy' method="post">
            <input type="hidden" name="id" value="${requestScope.vacancy.vacancyId}">
            <input type="hidden" name="command" value="restore_vacancy">
        </form>
    </c:when>
    <c:otherwise>
        <form id="delete_form" action="${pageContext.request.contextPath}/admin/do" name='delete_vacancy' method="post">
            <input type="hidden" name="id" value="${requestScope.vacancy.vacancyId}">
            <input type="hidden" name="vacancy_position" value="${requestScope.vacancy.position}">
            <input type="hidden" name="command" value="delete_vacancy">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
