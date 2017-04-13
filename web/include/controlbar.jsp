<div id="topbar">


    <div class="barlabel">
        <p class="bartext">ADMIN : ${sessionScope.admin.login}</p>
    </div>


    <div id="log_out_admin" class="barref">
        <a href="${pageContext.request.contextPath}/controller?command=log_out_admin" class="bartext">Log out</a>
    </div>

    <div id="applications" class="barref">
        <a href="${pageContext.request.contextPath}/controller?command=applications_admin" class="bartext">Applications</a>
    </div>

    <div id="messages" class="barref">
        <a href="${pageContext.request.contextPath}/controller?command=messages_admin" class="bartext">Messages</a>
    </div>

    <div id="vacancies" class="barref">
        <a href="${pageContext.request.contextPath}/controller?command=vacancies_admin" class="bartext">Vacancies</a>
    </div>

    <div id="users" class="barref">
        <a href="${pageContext.request.contextPath}/controller?command=all_users" class="bartext">Users</a>
    </div>

    <div id="index" class="barref">
        <a href="/index.jsp" class="bartext" title="index">Site</a>
    </div>

</div>
