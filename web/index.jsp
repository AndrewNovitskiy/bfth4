<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<html>
  <head>
    <title>LOL</title>
  </head>
  <body>
  <p><custom:today format="dd MMMM yyyy"/></p>
  <a href="${pageContext.request.contextPath}/do?command=vacancies"><fmt:message key="vacancies" /></a>
  <br>
  <c:if test="${not empty sessionScope.user}">
      <p>Hi, ${sessionScope.user.name}</p>
  </c:if>
      <a href="/user/logIn.jsp" title="log in"><fmt:message key="login" /></a>
      <br>
      <a href="/registration.jsp" title="registration"><fmt:message key="register" /></a>

  <c:if test="${not empty sessionScope.user}">
      <form action="${pageContext.request.contextPath}/do" name='log_out' method="post">
            <input type="submit" name="command" value="log_out" title="Log OUT">
      </form>
  </c:if>

  <li>
      <a href="${pageContext.request.contextPath}/do?command=change_language&language=en_EN">English</a>
  </li>
  <li>
      <a href="${pageContext.request.contextPath}/do?command=change_language&language=ru_RU">Русский</a>
  </li>

  </body>
</html>