<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Message  for ${requestScope.name} ${requestScope.surname}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<h2>New Message  for ${requestScope.name} ${requestScope.surname}</h2>
<form action="${pageContext.request.contextPath}/admin/do" name="send_message" method="post">

    <label>
        Title<br>
        <input type="text" name="title" required placeholder="Enter theme of message ... " maxlength="45">
    </label><br>

    <label>
        Text<br>
        <textarea name="content" maxlength="500" required placeholder="Text of message ... " rows="10" cols="50"></textarea>
    </label><br>
    <input type="hidden" name="recipient" value="${requestScope.id}">
    <input type="hidden" name="command" value="send_message">

    <div class="control_elem_container">
        <span>
            <input type="submit" name="submit" value="Send" class="control_elem">
        </span>
    </div>

</form>
</body>
</html>
