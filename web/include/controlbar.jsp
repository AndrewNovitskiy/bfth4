<div id="topbar">


    <div class="topbarlabel">
        <p class="topbartext">ADMIN : ${sessionScope.admin.login}</p>
    </div>


    <div id="log_out_admin" class="topbarref">
        <a href="${pageContext.request.contextPath}/admin/do?command=log_out_admin" class="topbartext">Log out</a>
    </div>

    <div id="applications" class="topbarref">
        <a href="${pageContext.request.contextPath}/admin/do?command=applications_admin" class="topbartext">Applications</a>
    </div>

    <div id="messages" class="topbarref">
        <a href="${pageContext.request.contextPath}/admin/do?command=messages_admin" class="topbartext">Messages</a>
    </div>

    <div id="vacancies" class="topbarref">
        <a href="${pageContext.request.contextPath}/admin/do?command=vacancies_admin" class="topbartext">Vacancies</a>
    </div>

    <div id="users" class="topbarref">
        <a href="${pageContext.request.contextPath}/admin/do?command=all_users" class="topbartext">Users</a>
    </div>

    <div id="index" class="topbarref">
        <a href="/index.jsp" class="topbartext" title="index">Site</a>
    </div>

</div>
