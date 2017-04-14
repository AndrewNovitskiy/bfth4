<div id="topbar">


    <div class="topbarlabel">
        <p class="topbartext">ADMIN : ${sessionScope.admin.login}</p>
    </div>


    <div id="log_out_admin" class="topbarref">
        <a href="${pageContext.request.contextPath}/controller?command=log_out_admin" class="topbartext">Log out</a>
    </div>

    <div id="applications" class="topbarref">
        <a href="${pageContext.request.contextPath}/controller?command=applications_admin" class="topbartext">Applications</a>
    </div>

    <div id="messages" class="topbarref">
        <a href="${pageContext.request.contextPath}/controller?command=messages_admin" class="topbartext">Messages</a>
    </div>

    <div id="vacancies" class="topbarref">
        <a href="${pageContext.request.contextPath}/controller?command=vacancies_admin" class="topbartext">Vacancies</a>
    </div>

    <div id="users" class="topbarref">
        <a href="${pageContext.request.contextPath}/controller?command=all_users" class="topbartext">Users</a>
    </div>

    <div id="index" class="topbarref">
        <a href="/index.jsp" class="topbartext" title="index">Site</a>
    </div>

</div>
