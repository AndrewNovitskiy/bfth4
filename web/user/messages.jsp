<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<html>
<head>
    <title><fmt:message key="messages" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/menubar_style.css">
    <link rel="stylesheet" href="../style/general_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/table_style.css">
</head>
<body>

<div id="container">
    <%@include file="../include/topbar.jsp"%>
    <%@include file="../include/header.jsp"%>
    <%@include file="../include/menubar.jsp"%>
    <div id="mainblock">

        <div class="block">

            <c:choose>
                <c:when test="${not empty requestScope.messages}">
                    <h2><fmt:message key="messages" /></h2>
                    <table border="1">
                        <tr>
                            <th>
                                <fmt:message key="sender" />
                            </th>
                            <th>
                                <fmt:message key="theme" />
                            </th>
                            <th>
                                <fmt:message key="date.time" />
                            </th>
                            <th>
                                <fmt:message key="details" />
                            </th>
                        </tr>
                            <c:forEach items="${requestScope.messages}" var="message">
                                <tr>
                                    <th>${message.senderLogin}</th>
                                    <th>${message.title}</th>
                                    <th>${message.dateTime}</th>
                                    <th>
                                        <form action="${pageContext.request.contextPath}/user/do" name='my_message' method="post">
                                            <input type="hidden" name="id" value="${message.messageId}">
                                            <input type="hidden" name="command" value="my_message">
                                            <input type="submit" name="submit" value="<fmt:message key="details" />">
                                        </form>
                                    </th>
                                </tr>
                            </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <h2><fmt:message key="messages.empty" /></h2>
                </c:otherwise>
            </c:choose>





        </div>
    </div>
    <img src="../style/resources/a.jpg" class="photo">
    <%@include file="../include/footer.jsp"%>
</div>
</body>
</html>
