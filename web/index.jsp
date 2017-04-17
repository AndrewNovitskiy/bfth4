<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="lang" />
<html lang="${language}">
  <head>
    <title>LOL</title>
  </head>
  <body>

  <a href="${pageContext.request.contextPath}/controller?command=vacancies"><fmt:message key="index.label.vacancies" /></a>
  <br>
  <c:if test="${not empty sessionScope.user}">
      <p>Hi, ${sessionScope.user.name}</p>
  </c:if>
      <a href="/user/logIn.jsp" title="log in"><fmt:message key="index.label.login" /></a>
      <br>
      <a href="/registration.jsp" title="registration"><fmt:message key="index.label.reg" /></a>

  <c:if test="${not empty sessionScope.user}">
      <form action="${pageContext.request.contextPath}/controller" name='log_out' method="post">
            <input type="submit" name="command" value="log_out" title="Log OUT">
      </form>
  </c:if>

  <form>
      <select id="language" name="language" onchange="submit()">
          <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
          <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
      </select>
  </form>

  </body>
</html>