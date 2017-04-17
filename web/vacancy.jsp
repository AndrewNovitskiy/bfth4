<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="style/topbar_style.css">
    <link rel="stylesheet" href="style/menubar_style.css">
    <link rel="stylesheet" href="style/general_style.css">
    <link rel="stylesheet" href="style/control_element_style.css">
    <link rel="stylesheet" href="style/vacancy_style.css">
</head>
<body>

<div id="container">
    <%@include file="include/topbar.jsp"%>
    <%@include file="include/header.jsp"%>
    <%@include file="include/menubar.jsp"%>
    <div id="mainblock">

        <div class="block">

            <div>
                <c:if test="${requestScope.vacancy.deleted}">
                    <h2 class="deleted">The vacancy is not up to date!</h2>
                </c:if>
                <h2>${requestScope.vacancy.position}</h2>
                <label>Date : </label> <span>${requestScope.vacancy.dateTime}</span><br><br>
                <label>Salary : </label> <span>${requestScope.vacancy.salary}$</span><br><br>
                <label>Experience : </label> <span>${requestScope.vacancy.experience} years</span><br><br>
                <hr>
                <label>Details : </label><br>
                <span>${requestScope.vacancy.info}</span><br><br>
            </div>

            
            <c:choose>
                <c:when test="${requestScope.vacancy.deleted}">
                    <span class="notice">You can not respond to this vacancy</span>
                </c:when>
                <c:when test="${empty sessionScope.user}">
                    <span class="notice">Log in to respond to this vacancy</span>
                </c:when>
                <c:when test="${requestScope.app_exists}">
                    <div class="control_elem_container">
                        <span>
                            <form action="${pageContext.request.contextPath}/do" name='delete_application' method="post">
                                <input type="hidden" name="vacancyId" value="${requestScope.vacancy.vacancyId}">
                                <input type="hidden" name="command" value="delete_application">
                                <input type="submit" name="submit" value="DETETE Respond ..." class="control_elem">
                            </form>
                        </span>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="control_elem_container">
                        <span>
                            <form action="${pageContext.request.contextPath}/do" name='new_application' method="post">
                                <input type="hidden" name="vacancyId" value="${requestScope.vacancy.vacancyId}">
                                <input type="hidden" name="command" value="new_application">
                                <input type="submit" name="submit" value="To Respond ..." class="control_elem">
                            </form>
                        </span>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <img src="style/resources/a.jpg" class="photo">
    <%@include file="include/footer.jsp"%>
</div>
</body>
</html>
