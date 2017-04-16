<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atlanta-Soft</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="style/topbar_style.css">
    <link rel="stylesheet" href="style/menubar_style.css">
    <link rel="stylesheet" href="style/general_style.css">
    <link rel="stylesheet" href="style/vacancies_style.css">
</head>
<body>

<div id="container">
    
    <%@include file="include/topbar.jsp"%>
    <%@include file="include/header.jsp"%>
    <%@include file="include/menubar.jsp"%>
    <img src="style/resources/atl.jpg" class="photo">

    <div id="mainblock">

        <div id="content" class="block">

            <h2>Start Working Now!</h2>


            <c:if test="${not empty requestScope.vacancies}">
                <c:forEach items="${requestScope.vacancies}" var="vacancy">
                    <div class="vacancyblock">
                        <div>
                            <span><a href="${pageContext.request.contextPath}/controller?command=view_vacancy&id=${vacancy.vacancyId}" class="vacancytitle">${vacancy.position}</a></span>
                            <span class="vacancydate">Date: ${vacancy.dateTime}</span>
                        </div>
                        <hr>
                        <div><span class="vacancyparam">Salary: ${vacancy.salary}$</span></div>
                        <hr>
                        <div><span class="vacancyparam">Required experience: ${vacancy.experience} years</span></div>
                        <p class="vacancyinfo">
                                ${vacancy.info}
                        </p>
                        <span><a href="${pageContext.request.contextPath}/controller?command=view_vacancy&id=${vacancy.vacancyId}" class="vacancymoreinfo">More Info...</a></span>
                    </div>
                </c:forEach>
            </c:if>

        </div>
    </div>

    <img src="style/resources/a.jpg" class="photo">
    <%@include file="include/footer.jsp"%>
</div>
</body>
</html>

