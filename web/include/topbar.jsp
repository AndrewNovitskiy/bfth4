<div id="topbar">
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <div class="topbarlabel">
                <p class="topbartext">Hi, ${sessionScope.user.name}!</p>
            </div>
        </c:when>
        <c:otherwise>
            <div class="topbarlabel">
                <p class="topbartext">Welcome!</p>
            </div>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <div id="logout" class="topbarref">
                <a href="${pageContext.request.contextPath}/do?command=log_out" class="topbartext">log out</a>
            </div>
        </c:when>
        <c:otherwise>
            <div id="login" class="topbarref">
                <a href="registration.jsp" class="topbartext" title="registration">registration</a>
            </div>
            <div id="register" class="topbarref">
                <a href="user/logIn.jsp" class="topbartext" title="log in">log in</a>
            </div>
        </c:otherwise>
    </c:choose>
</div>
