<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<html>
<head>
    <title>ATL Software</title>
    <link rel='stylesheet' href='style/home_style.css' type='text/css' />
    <link rel="stylesheet" href="style/topbar_style.css">
</head>
<body>
<%@include file="include/topbar.jsp"%>
<div id="mainblock">
    <div id="block_one">
        <h2>Atlanta-Soft</h2>
        <h2><fmt:message key="today" /> : <custom:today format="dd MMMM yyyy"/>. <fmt:message key="text3" /></h2>
        <div>
            <form action="${pageContext.request.contextPath}/do" name='vacancies' method="get">
                <input type="hidden" name="command" value="vacancies">
                <input type="submit" name="submit" id="enter" value="<fmt:message key="enter" />">
            </form>
        </div>
    </div>
    <div id="logo"><h1><a href="${pageContext.request.contextPath}/do?command=vacancies" id="atlref">Atlanta-Soft</a></h1></div>
    <div id="block_two" class="block">
        <a href="${pageContext.request.contextPath}/do?command=vacancies">
            <img src="style/resources/sol.jpg" id="img1">
        </a>
        <div id="text1"><fmt:message key="text4" /></div>
    </div>
    <div id="block_three" class="block">
        <a href="${pageContext.request.contextPath}/do?command=vacancies">
            <img src="style/resources/people.jpg" id="img2">
        </a>
        <div id="text2"><fmt:message key="text5" /></div>
    </div>
    <div id="block_four" class="block">
        <a href="${pageContext.request.contextPath}/do?command=vacancies">
            <img src="style/resources/jav.png" id="img3">
        </a>
        <div id="text3"><fmt:message key="text6" /></div>
    </div>
</div>
<%@include file="include/footer.jsp"%>
</body>
</html>