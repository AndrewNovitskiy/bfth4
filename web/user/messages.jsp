<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
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



            <table border="1">
                <tr>
                    <th>
                        ID_message
                    </th>
                    <th>
                        Sender
                    </th>
                    <th>
                        Title
                    </th>
                    <th>
                        DateTime
                    </th>
                    <th>
                        Details...
                    </th>
                </tr>
                <c:if test="${not empty requestScope.messages}">
                    <c:forEach items="${requestScope.messages}" var="message">
                        <tr>
                            <th>${message.messageId}</th>
                            <th>${message.senderLogin}</th>
                            <th>${message.title}</th>
                            <th>${message.dateTime}</th>
                            <th>
                                <form action="${pageContext.request.contextPath}/do" name='my_message' method="post">
                                    <input type="hidden" name="id" value="${message.messageId}">
                                    <input type="hidden" name="command" value="my_message">
                                    <input type="submit" name="submit" value="Details">
                                </form>
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
