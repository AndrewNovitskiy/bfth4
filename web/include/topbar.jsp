<div id="topbar">
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
