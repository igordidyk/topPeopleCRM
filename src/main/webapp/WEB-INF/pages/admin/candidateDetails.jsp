<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/allCandidates">Candidates</a></li>
        <li class="active">Add details</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>

    <h2>Add Language to candidate: ${candidate.name} ${candidate.surname}</h2>
    <form action="/admin/candidate/addLanguage" method="post">
        <input type="text" name="lang" placeholder="language">
        <input type="text" name="level" placeholder="language level">
        <input type="submit" value="ADD LANGUAGE">
        <input type="hidden" name="candidate" value="${candidate.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <h2>Add Education to candidate: ${candidate.name} ${candidate.surname}</h2>
    <form action="/admin/candidate/addEducation" method="post">

        <input type="text" name="standardEduction" placeholder="standardEduction">
        <input type="text" name="year" placeholder="year">
        <input type="text" name="nameOfSchool" placeholder="nameOfSchool">
        <input type="text" name="profesion" placeholder="profession">
        <input type="submit" value="ADD EDUCATION">
        <input type="hidden" name="candidate" value="${candidate.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

</div>

<jsp:include page="../templates/footer.jsp"/>