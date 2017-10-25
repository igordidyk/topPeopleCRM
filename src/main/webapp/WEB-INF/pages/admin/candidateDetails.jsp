<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/allCandidates">Candidates</a></li>
        <li class="active">Add details</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>

    <%--<h2>Add Language to candidate: ${candidate.name} ${candidate.surname}</h2>--%>
    <%--<form action="/admin/candidate/addLanguage" method="post">--%>
    <%--<input type="text" name="lang" placeholder="language">--%>
    <%--<input type="text" name="level" placeholder="language level">--%>
    <%--<input type="submit" value="ADD LANGUAGE">--%>
    <%--<input type="hidden" name="candidate" value="${candidate.id}">--%>
    <%--<input type="hidden"--%>
    <%--name="${_csrf.parameterName}"--%>
    <%--value="${_csrf.token}"/>--%>
    <%--</form>--%>

    <%--<h2>Add Education to candidate: ${candidate.name} ${candidate.surname}</h2>--%>
    <%--<form action="/admin/candidate/addEducation" method="post">--%>

    <%--<input type="text" name="standardEduction" placeholder="standardEduction">--%>
    <%--<input type="text" name="year" placeholder="year">--%>
    <%--<input type="text" name="nameOfSchool" placeholder="nameOfSchool">--%>
    <%--<input type="text" name="profesion" placeholder="profession">--%>
    <%--<input type="submit" value="ADD EDUCATION">--%>
    <%--<input type="hidden" name="candidate" value="${candidate.id}">--%>
    <%--<input type="hidden"--%>
    <%--name="${_csrf.parameterName}"--%>
    <%--value="${_csrf.token}"/>--%>
    <%--</form>--%>
    <h2>Language</h2>
    <table id="languagesOfCandidate">
        <thead>
        <tr>
            <th>language</th>
            <th>language level</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${candidate.languages}" var="lang">
            <tr>
                <td>${lang.lang}</td>
                <td>${lang.level}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Education</h2>
    <table id="educationsOfCandidate">
        <thead>
        <tr>
            <th>Standard eduction</th>
            <th>Educations year</th>
            <th>Name Of School</th>
            <th>Profession</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${candidate.educations}" var="edu">
            <tr>
                <td>${edu.standardEduction}</td>
                <td>${edu.year}</td>
                <td>${edu.nameOfSchool}</td>
                <td>${edu.profesion}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <script type="text/javascript" charset="utf-8">
        $('#languagesOfCandidate').dataTable();
        $('#educationsOfCandidate').dataTable();
    </script>

</div>

<jsp:include page="../templates/footer.jsp"/>