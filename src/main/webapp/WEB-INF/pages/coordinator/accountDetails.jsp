<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/coordinator">Coordinator Home</a></li>
        <li><a href="/coordinator/candidates">Candidate</a></li>
        <li class="active">Account details</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <br>
    <h2>Profile details</h2>

    <p>* Here you can change your personal data</p>
    <form action="/coordinator/myAccount/editProfile" method="post">
        <input type="text" name="firstName" placeholder="firstName" value="${coordinator.firstName}">
        <input type="text" name="lastName" placeholder="lastName" value="${coordinator.lastName}">
        <input type="text" name="email" placeholder="email" value="${coordinator.email}">
        <input type="text" name="telephone" placeholder="telephone" value="${coordinator.telephone}">
        <%--<input type="text" name="username" placeholder="username" value="${coordinator.username}">--%>
        <%--<input type="text" name="password" placeholder="password">--%>
        <input type="hidden" name="id" value="${coordinator.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br>
        <br>
        <input type="submit" value="save changes">
    </form>
    <br>



<jsp:include page="../templates/footer.jsp"/>