<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin">Admin Home</a></li>
        <li><a href="/admin/company">Company</a></li>
        <li><a href="/admin/coordinators">Coordinators</a></li>
        <li><a href="/admin/projects">Project</a></li>
        <li class="active">Candidates</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <h2>All candidates</h2>
    <table id="candidates">
        <thead>
        <tr>

            <th>Name</th>
            <th>Surname</th>
            <th>Gender</th>
            <th>Nationality</th>
            <th>Born</th>
            <th>Married status</th>
            <th>Current occupation</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Position</th>
            <th>Passport Number</th>
            <th>Passport Valid Until</th>
            <th>Issued By Authority</th>
            <th>Phase</th>
            <th>Status</th>
            <th>Received Order</th>
            <th>Schengen</th>
            <th>Working Agreement</th>
            <th>Working Agree</th>
            <th>Confirmation Of Living Place</th>
            <th>Begin Working Contract</th>
            <th>End Working Contract</th>
            <th>Schengen Trial Period</th>
            <th>Real Starting of Schengen</th>
            <th>Multi Visa</th>
            <th>EC Begin</th>
            <th>EC End</th>
            <th>EC Trial Period</th>
            <th>Expected Starting at Company</th>
            <th>Duration</th>
            <th>Presented to Company</th>
            <th>Ministry of Foreign Affairs</th>
            <th>Interview at Consulate</th>
            <th>Picking up the VISA</th>
            <th>Registration at local office</th>
            <th>Starting to Work</th>
            <th>Receiving Employment Card</th>
            <th>Comments</th>
            <th>Options</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${candidates}" var="candidate">
            <tr>
                <td>${candidate.name}</td>
                <td>${candidate.surname}</td>
                <td>${candidate.gender}</td>
                <td>${candidate.nationality}</td>
                <td>${candidate.dateOfBirth}</td>
                <td>${candidate.marriedStatus}</td>
                <td>${candidate.currentOccupation}</td>
                <td>${candidate.telephone}</td>
                <td>${candidate.email}</td>
                <td>${candidate.position}</td>
                <td>${candidate.passportNumber}</td>
                <td>${candidate.passportValidUntil}</td>
                <td>${candidate.issuedByAuthority}</td>
                <td>${candidate.phase}</td>
                <td>${candidate.status}</td>

                <td>${candidate.receivedOrder}</td>
                <td>${candidate.schengen}</td>
                <td>${candidate.workingAgreement}</td>
                <td>${candidate.workingAgree}</td>
                <td>${candidate.confirmationOfLivingPlace}</td>
                <td>${candidate.beginWorkingContract}</td>
                <td>${candidate.endWorkingContract}</td>
                <td>${candidate.schengenTrialPeriod}</td>
                <td>${candidate.realStartingOfSchengen}</td>
                <td>${candidate.multiVisa}</td>
                <td>${candidate.ECBegin}</td>
                <td>${candidate.ECEnd}</td>
                <td>${candidate.ECTrialPeriod}</td>
                <td>${candidate.expectedStartingAtCompany}</td>
                <td>${candidate.duration}</td>
                <td>${candidate.presentedToCompany}</td>
                <td>${candidate.ministryOfForeignAffairs}</td>
                <td>${candidate.interviewAtConsulate}</td>
                <td>${candidate.pickingUpTheVISA}</td>
                <td>${candidate.registrationAtLocalOffice}</td>
                <td>${candidate.startingToWork}</td>
                <td>${candidate.receivingEmploymentCard}</td>
                <td>${candidate.comments}</td>
                <td>
                    <a href="/admin/allCandidates/candidate-${candidate.id}">Show details</a>
                    <a href="/admin/deleteCandidate/${candidate.id}">Delete</a>
                    <a href="/admin/editCandidate/${candidate.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <script type="text/javascript" charset="utf-8">
        $('#candidates').dataTable();
    </script>
</div>
<jsp:include page="../templates/footer.jsp"/>