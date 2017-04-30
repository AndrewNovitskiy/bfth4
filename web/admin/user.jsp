<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.user.name} ${requestScope.user.surname}</title>
    <link rel="stylesheet" href="../style/topbar_style.css">
    <link rel="stylesheet" href="../style/control_element_style.css">
    <link rel="stylesheet" href="../style/admin_content_style.css">
</head>
<body>
<%@include file="../include/controlbar.jsp"%>
<div class="content">
<h2>Info about User</h2>
    <p><label>ID : </label>${requestScope.user.applicantId}</p>
    <p><label>Login : </label>${requestScope.user.login}</p>
    <p><label>Name : </label>${requestScope.user.name}</p>
    <p><label>Surname : </label>${requestScope.user.surname}</p>
    <p><label>Phone : </label>${requestScope.user.telephone}</p>
    <p><label>Email : </label>${requestScope.user.email}</p>
    <p><label>Resume : </label>${requestScope.user.resume}</p>
</div>

<div class="control_elem_container">
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=usapps&id=${requestScope.user.applicantId}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Apps Of User</a>
</span>
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=usmess&id=${requestScope.user.applicantId}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Messages for User</a>
</span>
    <span>
        <a href="${pageContext.request.contextPath}/admin/do?command=new_message&id=${requestScope.user.applicantId}&name=${requestScope.user.name}&surname=${requestScope.user.surname}" class="control_elem">Write</a>
</span>
</div>

</body>
</html>
