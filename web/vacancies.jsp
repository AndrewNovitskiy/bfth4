<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Atlanta-Soft</title>
    <link rel="stylesheet" href="style/vacancies_style.css">
</head>
<body>
<div id="container">
    <div id="loginbar">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <div class="barlabel">
                    <p class="bartext">Hi, ${sessionScope.user.name}!</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="barlabel">
                    <p class="bartext">Welcome!</p>
                </div>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <div id="logout" class="barref">
                    <a href="${pageContext.request.contextPath}/controller?command=log_out" class="bartext">log out</a>
                </div>
            </c:when>
            <c:otherwise>
                <div id="login" class="barref">
                    <a href="registration.jsp" class="bartext" title="registration">registration</a>
                </div>
                <div id="register" class="barref">
                    <a href="user/logIn.jsp" class="bartext" title="log in">log in</a>
                </div>
            </c:otherwise>
        </c:choose>


    </div>
    <div id="header">
        <img id="logo" src="style/resources/IT-logo.png" height="100" width="100" hspace="10">
        <h1>Atlanta-Soft</h1>
    </div>
    <div id="mainblock">



        <div id="sidebar" class="block">
            <div class="sidebarelem">
                <a href="${pageContext.request.contextPath}/controller?command=vacancies" class="sidebartext">All Vacancies</a>
            </div>
            <c:if test="${not empty sessionScope.user}">
                <div class="sidebarelem">
                    <a href="${pageContext.request.contextPath}/controller?command=profile" class="sidebartext">My Profile</a>
                </div>
                <div class="sidebarelem">
                    <a href="" class="sidebartext">My Responses</a>
                </div>
                <div class="sidebarelem">
                    <a href="" class="sidebartext">My Messages</a>
                </div>
            </c:if>
            <div class="sidebarelem">
                <a href="" class="sidebartext">Contact</a>
            </div>
            <div class="sidebarelem">
                <a href="" class="sidebartext">About Us</a>
            </div>
        </div>



        <div id="content" class="block">

            <img src="style/resources/atl.jpg" class="photo">
            <h2>Start Working Now!</h2>


<c:if test="${not empty requestScope.vacancies}">
    <c:forEach items="${requestScope.vacancies}" var="vacancy">
            <div class="vacancyblock">
                <div>
                    <span><a href="" class="vacancytitle">${vacancy.position}</a></span>
                    <span class="vacancydate">Date: ${vacancy.dateTime}</span>
                </div>
                <hr>
                <div><span class="vacancyparam">Salary: ${vacancy.salary}$</span></div>
                <hr>
                <div><span class="vacancyparam">Required experience: ${vacancy.experience} years</span></div>
                <p class="vacancyinfo">
                        ${vacancy.info}
                </p>
                <span><a href="" class="vacancymoreinfo">More Info...</a></span>
            </div>
    </c:forEach>
</c:if>

        </div>
    </div>
    <img src="style/resources/a.jpg" class="photo">
    <div id="footer">&copy; Andrei Novitsky, 2017</div>
</div>
</body>
</html>

