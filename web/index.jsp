<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
  <head>
    <title>LOL</title>
  </head>
  <body>

  <a href="${pageContext.request.contextPath}/controller?command=vacancies">Vacancies</a>
  <br>
  <c:if test="${not empty sessionScope.user}">
      <p>Hi, ${sessionScope.user.name}</p>
  </c:if>
      <a href="/user/logIn.jsp" title="log in">log in</a>
      <br>
      <a href="/registration.jsp" title="registration">registration</a>

  <c:if test="${not empty sessionScope.user}">
      <form action="${pageContext.request.contextPath}/controller" name='log_out' method="post">
            <input type="submit" name="command" value="log_out" title="Log OUT">
      </form>
  </c:if>
  </body>
</html>