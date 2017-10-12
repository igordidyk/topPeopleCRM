<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin">Admin Home</a></li>
        <li><a href="/admin/company">Company</a></li>
        <li><a href="/admin/coordinators">Coordinators</a></li>
        <li class="active">Project</li>
        <li><a href="/admin/allEmployee">Employee</a></li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <h2>Create project</h2>
    <form action="/admin/projects/createProject" method="post">
        <input type="text" name="typeOfEmployment" placeholder="type of employment">
        <input type="text" name="position" placeholder="position">
        <input type="text" name="numberOfCandidatesForProject" placeholder="number of candidates for project">
        <input type="text" name="schengenContractStarting" placeholder="schengen contract starting">
        <input type="text" name="ECStarting" placeholder="EC starting">
        <input type="text" name="dateForMedicalDocs" placeholder="date for medical documents">
        <br>
        <input type="text" name="statusOfReceived" placeholder="status of received">
        <input type="text" name="processingTimePartner" placeholder="processing time partner">
        <input type="text" name="gettingSignedDocuments" placeholder="getting signed Documents">
        <input type="text" name="submissionDocumetns" placeholder="submission documetns">
        <input type="text" name="processingTimeUP" placeholder="processing time UP">
        <input type="text" name="pickingUpDocumentUA" placeholder="processing  UP document">
        <br>
        <input type="text" name="applicationProcess" placeholder="application Process">
        <input type="text" name="readyToGoToCZ" placeholder="readyToGoToCZ">
        <input type="text" name="deviationToWorkingContract" placeholder="deviation to working contract">
        <select name="company">
            <c:forEach items="${companies}" var="company">
                <option value="${company.id}">${company.nameCompany}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input type="submit" value="CREATE PROJECT" class="btn btn-default">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <br>
    <a href="/admin/projects/groups" class="btn btn-default">Add group to project</a>

    <br>
    <h2>All projects </h2>
    <h3>Show all projects with company</h3>
    <select name="choseCompany">
        <c:forEach items="${companies}" var="company">
            <option value="${company.id}">${company.nameCompany}</option>
        </c:forEach>
    </select>
    <table id="allProjects">
        <thead>
        <tr>

            <th>Type Of Employment</th>
            <th>Position</th>
            <th>Number of candidates</th>
            <th>Schengen contract starting</th>
            <th>EC starting</th>
            <th>Date for medical documents</th>
            <th>Status of received</th>
            <th>Processing time partner</th>
            <th>Getting signed documents</th>
            <th>Submission documetns</th>
            <th>Processing time UP</th>
            <th>Picking Up document UA</th>
            <th>Application process</th>
            <th>Ready to go to CZ</th>
            <th>Deviation to working contract</th>


        </tr>
        </thead>

        <tbody>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.typeOfEmployment}</td>
                <td>${project.position}</td>
                <td>${project.numberOfCandidatesForProject}</td>
                <td>${project.schengenContractStarting}</td>
                <td>${project.ECStarting}</td>
                <td>${project.dateForMedicalDocs}</td>
                <td>${project.statusOfReceived}</td>
                <td>${project.processingTimePartner}</td>
                <td>${project.gettingSignedDocuments}</td>
                <td>${project.submissionDocumetns}</td>
                <td>${project.processingTimeUP}</td>
                <td>${project.pickingUpDocumentUA}</td>
                <td>${project.applicationProcess}</td>
                <td>${project.readyToGoToCZ}</td>
                <td>${project.deviationToWorkingContract}</td>



            </tr>

        </c:forEach>

        </tbody>
    </table>

    <script type="text/javascript" charset="utf-8">
        $('#allProjects').dataTable();
    </script>


</div>

<jsp:include page="../templates/footer.jsp"/>