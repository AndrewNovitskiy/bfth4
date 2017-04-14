<div id="menubar">
    <div class="menubarbutton">
        <a href="" class="menubartext">About Us</a>
    </div>
    <div class="menubarbutton">
        <a href="" class="menubartext">Contact</a>
    </div>
    <c:if test="${not empty sessionScope.user}">
        <div class="menubarbutton">
            <a href="${pageContext.request.contextPath}/controller?command=messages" class="menubartext">My Messages</a>
        </div>
        <div class="menubarbutton">
            <a href="" class="menubartext">My Responses</a>
        </div>
        <div class="menubarbutton">
            <a href="${pageContext.request.contextPath}/controller?command=profile" class="menubartext">My Profile</a>
        </div>
    </c:if>
    <div class="menubarbutton">
        <a href="${pageContext.request.contextPath}/controller?command=vacancies" class="menubartext">All Vacancies</a>
    </div>

</div>