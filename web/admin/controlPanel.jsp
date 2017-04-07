<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN HERE, MTHRFCKERS</title>
    <link rel='stylesheet' href='C:\install\apache tomcat\apache-tomcat-8.5.11\webapps\bullet_for_two_hares\web\style\admin\control_panel_style.css' type='text/css' />
</head>
<body>
<a href="/index.jsp" title="index">index.jsp</a>
<br>

<c:if test="${not empty sessionScope.admin}">
    <tr>
        <th>${sessionScope.admin.idAdmin}</th>
        <th>${sessionScope.admin.login}</th>
        <th>${sessionScope.admin.password}</th>
    </tr>
</c:if>


<h2>Control panel</h2>


<a href="${pageContext.request.contextPath}/controller?command=all_users">Users</a><br>
<a href="${pageContext.request.contextPath}/controller?command=vacancies_admin">Vacancies</a><br>
<a href="${pageContext.request.contextPath}/controller?command=messages_admin">Messages</a><br>
<a href="${pageContext.request.contextPath}/controller?command=applications_admin">Applications</a><br>

<c:if test="${not empty sessionScope.admin}">
    <form action="${pageContext.request.contextPath}/controller" name='log_out_admin' method="post">
        <input type="submit" name="command" value="log_out_admin" title="Log OUT">
    </form>
</c:if>
</body>
</html>
