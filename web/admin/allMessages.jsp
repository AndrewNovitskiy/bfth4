<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<table border="1">
    <tr>
        <th>
            ID_message
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Title
        </th>
        <th>
            Content
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
                <th>${message.recipientName}</th>
                <th>${message.recipientSurname}</th>
                <th>${message.title}</th>
                <th>${message.content}</th>
                <th>${message.dateTime}</th>
                <th><a href="${pageContext.request.contextPath}/controller?command=message&id=${message.messageId}">Details...</a></th>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
