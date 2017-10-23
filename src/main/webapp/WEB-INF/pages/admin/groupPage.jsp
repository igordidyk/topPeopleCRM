<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/projects">Project</a></li>
        <li class="active">Group</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <h2>Create group</h2>
    <form action="/admin/projects/groups/createGroup" method="post">
        <input type="text" name="nameGroup" placeholder="nameGroup">
        <input type="number" name="numberOfCandidates" placeholder="numberOfCandidates">
        <br>
        <br>
        <label for="project">Project</label>
        <select name="project" id="project">
            <c:forEach items="${projects}" var="project">
                <option value="${project.id}">${project.position}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <label for="candidates">Candidate</label>
        <select name="candidates" id="candidates" multiple >
            <c:forEach items="${candidates}" var="candidate">
                <option value="${candidate.id}">${candidate.name} ${candidate.surname} ( ${candidate.position} )</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input type="submit" value="CREATE GROUP">
        <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
    </form>







</div>



<jsp:include page="../templates/footer.jsp"/>