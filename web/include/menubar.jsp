<div id="menubar">
    <div class="menubarbutton">
        <a href="../index.jsp" class="menubartext"><fmt:message key="about" /></a>
    </div>
    <div class="menubarbutton">
        <a href="../contact.jsp" class="menubartext"><fmt:message key="contacts" /></a>
    </div>
    <c:if test="${not empty sessionScope.user}">
        <div class="menubarbutton">
            <a href="${pageContext.request.contextPath}/user/do?command=my_messages" class="menubartext"><fmt:message key="messages" /></a>
        </div>
        <div class="menubarbutton">
            <a href="${pageContext.request.contextPath}/user/do?command=my_applications" class="menubartext"><fmt:message key="responses" /></a>
        </div>
        <div class="menubarbutton">
            <a href="${pageContext.request.contextPath}/user/do?command=profile" class="menubartext"><fmt:message key="profile" /></a>
        </div>
    </c:if>
    <div class="menubarbutton">
        <a href="${pageContext.request.contextPath}/do?command=vacancies" class="menubartext"><fmt:message key="vacancies" /></a>
    </div>

</div>