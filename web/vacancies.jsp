<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
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

            <h2 id="text1"><fmt:message key="text1" /></h2>


            <c:if test="${not empty requestScope.vacancies}">
                <c:forEach items="${requestScope.vacancies}" var="vacancy">
                    <div class="vacancyblock">
                        <div>
                            <span><a href="${pageContext.request.contextPath}/do?command=view_vacancy&id=${vacancy.vacancyId}" class="vacancytitle">${vacancy.position}</a></span>
                            <span class="vacancydate"><fmt:message key="date" />: ${vacancy.dateTime}</span>
                        </div>
                        <hr>
                        <div><span class="vacancyparam"><fmt:message key="salary" />: ${vacancy.salary}$</span></div>
                        <hr>
                        <div><span class="vacancyparam"><fmt:message key="experience" />: ${vacancy.experience}</span></div>
                        <div class="vacancyinfo">
                                ${vacancy.info}
                        </div>
                        <span><a href="${pageContext.request.contextPath}/do?command=view_vacancy&id=${vacancy.vacancyId}" class="vacancymoreinfo"><fmt:message key="more" /></a></span>
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

