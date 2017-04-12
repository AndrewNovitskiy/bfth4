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