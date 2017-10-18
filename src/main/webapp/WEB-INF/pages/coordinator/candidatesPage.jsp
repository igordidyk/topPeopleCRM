<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin">Coordinator Home</a></li>
        <li><a href="/coordinator/candidates">Candidate</a></li>
        <li><a href="/coordinator/myAccount">Account details</a></li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <h2>Registration candidates</h2>

    <form action="/coordinator/candidates/addCandidate" method="post">
        <input type="submit" value="ADD CANDIDATE">
        <br>
        <br>

        <input type="text" name="name" placeholder="name" required>
        <input type="text" name="surname" placeholder="surname">
        <input type="text" name="gender" placeholder="gender">
        <input type="text" name="nationality" placeholder="nationality">
        <input type="text" name="dateOfBirth" placeholder="date of birth">
        <input type="text" name="marriedStatus" placeholder="married status">
        <br>
        <br>
        <input type="text" name="currentOccupation" placeholder="current occupation">
        <input type="text" name="telephone" placeholder="telephone">
        <input type="text" name="email" placeholder="email">
        <input type="text" name="receivingEmploymentCard" placeholder="receiving employment card">
        <select name="position">
            <c:forEach items="${cziscoList}" var="isco">
                <option value="${isco.id}">${isco.ENG_position}</option>
            </c:forEach>
        </select>
        <br>
        <br>

        <%--<label for="employee-place">birth place</label>--%>
        <%--<input type="checkbox" onchange="show()" id="employee-place">--%>

        <%--<div id="birthplace">--%>

            <input type="text" name="countryOfBirth" placeholder="country of birth">
            <input type="text" name="birthPlace" placeholder="born place">
            <input type="text" name="street" placeholder="street">
            <input type="text" name="cityOrVillage" placeholder="city or village">
            <input type="text" name="zip" placeholder="zip">
        <%--</div>--%>

        <%--<label for="employee-address">Address</label>--%>
        <%--<input type="checkbox" id="employee-address" onchange="show()">--%>
        <br>
        <br>
        <%--<div id="address">--%>
            <input type="text" name="country" placeholder="Address country">
            <input type="text" name="region" placeholder="Address region">
            <input type="text" name="city" placeholder="Address city">
            <input type="text" name="postIndex" placeholder="Address postIndex">
            <input type="text" name="adressStreet" placeholder="Address street">
            <input type="text" name="numberOfHouse" placeholder="Address number of house">
        <%--</div>--%>

        <%--<label for="language">Language</label>--%>
        <%--<input type="checkbox" id="language" onchange="show()">--%>

        <%--<div id="lang">--%>
        <%--<input type="text" name="lang" placeholder="lang">--%>
        <%--<input type="text" name="level" placeholder="level">--%>
        <%--</div>--%>

        <%--<label for="education">Education</label>--%>
        <%--<input type="checkbox" id="employee-education" onchange="show()">--%>
        <%--<div id="education">--%>
        <%--<input type="text" name="standardEduction" placeholder="standard eduction">--%>
        <%--<input type="text" name="years" placeholder="years">--%>
        <%--<input type="text" name="nameOfSchool" placeholder="name of school">--%>
        <%--<input type="text" name="profesion" placeholder="profesion">--%>
        <%--</div>--%>
        <br/>
        <%--<input type="text" name="telephone" placeholder="telephone">--%>
        <%--<input type="text" name="email" placeholder="email">--%>
        <input type="text" name="passportNomer" placeholder="passport number">
        <input type="text" name="passportValidUntil" placeholder="passport valid until">
        <input type="text" name="issuedByAuthority" placeholder="issued by authority">
        <input type="text" name="receivedOrder" placeholder="received order">
        <br/>
        <br/>
        <input type="number" name="phase" placeholder="phase">
        <input type="number" name="status" placeholder="status">
        <input type="text" name="schengen" placeholder="schengen">
        <input type="text" name="workingAgreement" placeholder="working agreement">
        <input type="text" name="workingAgree" placeholder="working agree">
        <input type="text" name="confirmationOfLivingPlace" placeholder="confirmation of living place">
        <br/>
        <br/>
        <input type="text" name="beginWorkingContract" placeholder="begin working contract">
        <input type="text" name="endWorkingContract" placeholder="end working contract">
        <input type="text" name="schengenTrialPeriod" placeholder="schengen trial period">
        <input type="text" name="realStartingOfSchengen" placeholder="real starting of schengen">
        <input type="text" name="multiVisa" placeholder="multi visa">
        <input type="text" name="ECBegin" placeholder="EC begin">
        <br/>
        <br/>
        <input type="text" name="ECEnd" placeholder="EC end">
        <input type="text" name="ECTrialPeriod" placeholder="EC trial period">
        <input type="text" name="expectedStartingAtCompany" placeholder="expected starting at company">
        <input type="text" name="duration" placeholder="duration">
        <br/>
        <br/>
        <input type="text" name="presentedToCompany" placeholder="presentedToCompany">
        <input type="text" name="ministryOfForeignAffairs" placeholder="ministry of foreign affairs">
        <input type="text" name="interviewAtConsulate" placeholder="interview at consulate">
        <input type="text" name="pickingUpTheVISA" placeholder="picking up the VISA">
        <input type="text" name="registrationAtLocalOffice" placeholder="registration at local office">
        <input type="text" name="startingToWork" placeholder="starting to work">
        <br/>
        <br/>

        <textarea name="comments" placeholder="comments"></textarea>
        <br/>
        <br/>

        <input type="hidden" name="coordinator" value="${key}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br>
        <br>
    </form>

    <table id="allCandidates">
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
                <th>Number of Vacancy</th>
                <th>Phase</th>
                <th>Status</th>


            <%--<th>Birth Place</th>--%>
            <%--<th>Address country</th>--%>
            <%--<th>Address region</th>--%>
            <%--<th>Address city</th>--%>
            <%--<th>Address postIndex</th>--%>
            <%--<th>Address street</th>--%>
            <%--<th>Address numberOfHouse</th>--%>

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
                    <a href="/coordinator/candidates/candidate-${candidate.id}">Show details</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<br>
<br>
<br>
<%--<script src="../js/main.js"></script>--%>
<jsp:include page="../templates/footer.jsp"/>