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
        <label for="projectSelect">Project</label>
        <select name="project" id="projectSelect">
            <option value="" selected disabled>Select project</option>
            <c:forEach items="${projects}" var="project">
                <option value="${project.id}"
                        <c:if test="${selectedProject.id == project.id}">
                            selected
                        </c:if>
                >${project.position}</option>
            </c:forEach>
        </select>
        <input type="text" name="nameGroup" placeholder="nameGroup">
        <input type="number" name="numberOfCandidates" placeholder="numberOfCandidates">
        <br>
        <br>
        <br>
        <br>
        <label for="candidates">Candidates</label>
        <select name="candidates" id="candidates" multiple>
            <c:forEach items="${candidates}" var="candidate">
                <option value="${candidate.id}">${candidate.name} ${candidate.surname} ( ${candidate.position} )
                </option>
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
<script>
    projectSelect.addEventListener("change", function () {
        sel = this;
        let projectId = this.value;
        location.href = "/admin/projects/groups?projectId=" + projectId;
    });
</script>


<jsp:include page="../templates/footer.jsp"/>