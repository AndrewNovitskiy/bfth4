<div id="topbar">
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <div class="topbarlabel">
                <p class="topbartext"><fmt:message key="hi" />, ${sessionScope.user.name}!</p>
            </div>
        </c:when>
        <c:otherwise>
            <div class="topbarlabel">
                <p class="topbartext"><fmt:message key="welcome" />!</p>
            </div>
        </c:otherwise>
    </c:choose>


    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <div id="logout" class="topbarref">
                <a href="${pageContext.request.contextPath}/user/do?command=log_out" class="topbartext"><fmt:message key="log.out" /></a>
            </div>
        </c:when>
        <c:otherwise>
            <div id="login" class="topbarref">
                <a href="registration.jsp" class="topbartext" title="registration"><fmt:message key="register" /></a>
            </div>
            <div id="register" class="topbarref">
                <a href="user/logIn.jsp" class="topbartext" title="log in"><fmt:message key="log.in" /></a>
            </div>
        </c:otherwise>
    </c:choose>
    <div id="lang" class="topbarref">
        <a href="${pageContext.request.contextPath}/do?command=change_language&language=en_EN" class="topbartext">EN</a>
    </div>
    <div id="lang" class="topbarref">
        <a href="${pageContext.request.contextPath}/do?command=change_language&language=ru_RU" class="topbartext">RU</a>
    </div>
</div>
