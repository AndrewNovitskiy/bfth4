<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'en'}" />
<fmt:setBundle basename="com.andrew.i18n.text" />
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<html>
  <head>
    <title>ATL Software</title>
      <link rel='stylesheet' href='style/home_style.css' type='text/css' />
      <link rel="stylesheet" href="style/topbar_style.css">
  </head>
  <body>
    <%@include file="include/topbar.jsp"%>
    <div id="mainblock">
    <div id="block_one">
        <h2>Atlanta-Soft</h2>
        <h2>Today : <custom:today format="dd MMMM yyyy"/>. Start work with us!</h2>
        <div>
            <form action="${pageContext.request.contextPath}/do" name='vacancies' method="get">
                <input type="hidden" name="command" value="vacancies">
                <input type="submit" name="submit" id="enter" value="ENTER">
            </form>
        </div>
    </div>
    <div id="logo"><h1>Atlanta-Soft</h1></div>
    <div id="block_two" class="block">
        <img src="style/resources/sol.jpg" height="400" id="img1">
        <div id="text1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
    </div>
    <div id="block_three" class="block">
        <img src="style/resources/people.jpg" height="400" id="img2">
        <div id="text2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
    </div>
        <div id="block_four" class="block">
            <img src="style/resources/jav.png" height="400" id="img3">
            <div id="text3">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
        </div>
    </div>
    <%@include file="include/footer.jsp"%>
  </body>
</html>