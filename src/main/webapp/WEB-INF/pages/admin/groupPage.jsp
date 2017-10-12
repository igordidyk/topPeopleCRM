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
        <input type="number" name="numberOfCanditates" placeholder="numberOfCanditates">
        <select name="project" >
            <c:forEach items="${projects}" var="project">
                <option value="${project.id}">${project.position}</option>
            </c:forEach>
        </select>
        <input type="submit" value="CREATE GROUP">
        <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
    </form>







</div>



<jsp:include page="../templates/footer.jsp"/>