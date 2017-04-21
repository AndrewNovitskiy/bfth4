<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="responses" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">

        <div class="block">


            <h2><fmt:message key="responses" /></h2>
            <table border="1">
                <tr>
                    <th>
                        <fmt:message key="position" />
                    </th>
                    <th>
                        <fmt:message key="status" />
                    </th>
                </tr>
                <c:if test="${not empty requestScope.applications}">
                    <c:forEach items="${requestScope.applications}" var="application">
                        <tr>
                            <th>${application.vacancyPosition}</th>
                            <th>${application.status}</th>
                            <th>
                                <a href="${pageContext.request.contextPath}/do?command=view_vacancy&id=${application.vacancyId}"><fmt:message key="details" /></a>
                            </th>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>


        </div>
    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
