<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>

<div class="container">
    <ol class="breadcrumb">
        <li class="active"><%--<a href="/admin">Admin Home</a>--%>Coordinator Home</li>
        <li><a href="/coordinator/candidates">Employee</a></li>
        <li><a href="/coordinator/myAccount">Account details</a></li>
        <p class="navbar-right"><a href="/logout" >Log out  </a></p>
    </ol>
    <h2>Registration candidates</h2>

    <form action="/coordinator/candidates/addCandidate" method="post">
        <input type="text" name="name" placeholder="name" required>
        <input type="text" name="surname" placeholder="surname">
        <input type="text" name="gender" placeholder="gender">
        <input type="text" name="nationality" placeholder="nationality">
        <input type="date" name="dateOfBirth" placeholder="date of birth">
        <input type="date" name="marriedStatus" placeholder="married status">
        <input type="date" name="currentOccupation" placeholder="current occupation">
        <input type="date" name="telephone" placeholder="telephone">
        <input type="date" name="email" placeholder="email">

        <br/>

        <label for="employee-place">birth place</label>
        <input type="checkbox" onchange="show()" id="employee-place">

        <div id="birthplace">

            <input type="text" name="countryOfBirth" placeholder="country of birth">
            <input type="text" name="birthPlace" placeholder="born place">
            <input type="text" name="street" placeholder="street">
            <input type="text" name="cityOrVillage" placeholder="city or village">
            <input type="text" name="zip" placeholder="zip">
        </div>

        <label for="employee-address">Address</label>
        <input type="checkbox" id="employee-address" onchange="show()">

        <div id="address">
            <input type="text" name="country" placeholder="Address country">
            <input type="text" name="region" placeholder="Address region">
            <input type="text" name="city" placeholder="Address city">
            <input type="text" name="postIndex" placeholder="Address postIndex">
            <input type="text" name="adressStreet" placeholder="Address street">
            <input type="text" name="numberOfHouse" placeholder="Address number of house">
        </div>

        <label for="language">Language</label>
        <input type="checkbox" id="language" onchange="show()">

        <div id="lang">
            <input type="text" name="lang" placeholder="lang">
            <input type="text" name="level" placeholder="level">
        </div>

        <label for="education">Education</label>
        <input type="checkbox" id="employee-education" onchange="show()">
        <div id="education">
            <input type="text" name="standardEduction" placeholder="standard eduction">
            <input type="text" name="years" placeholder="years">
            <input type="text" name="nameOfSchool" placeholder="name of school">
            <input type="text" name="profesion" placeholder="profesion">
        </div>
        <br/>
        <%--<input type="text" name="telephone" placeholder="telephone">--%>
        <%--<input type="text" name="email" placeholder="email">--%>
        <%--<input type="text" name="passportNomer" placeholder="passport number">--%>
        <%--<input type="text" name="passportValidUntil" placeholder="passport valid until">--%>
        <%--<input type="text" name="issuedByAuthority" placeholder="issued by authority">--%>
        <%--<input type="text" name="receivedOrder" placeholder="received order">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<input type="number" name="phase" placeholder="phase">--%>
        <%--<input type="number" name="status" placeholder="status">--%>
        <%--<input type="text" name="schengen" placeholder="schengen">--%>
        <%--<input type="text" name="workingAgreement" placeholder="working agreement">--%>
        <%--<input type="text" name="workingAgree" placeholder="working agree">--%>
        <%--<input type="text" name="confirmationOfLivingPlace" placeholder="confirmation of living place">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<input type="text" name="beginWorkingContract" placeholder="begin working contract">--%>
        <%--<input type="text" name="endWorkingContract" placeholder="end working contract">--%>
        <%--<input type="text" name="schengenTrialPeriod" placeholder="schengen trial period">--%>
        <%--<input type="text" name="realStartingOfSchengen" placeholder="real starting of schengen">--%>
        <%--<input type="text" name="multiVisa" placeholder="multi visa">--%>
        <%--<input type="text" name="ECBegin" placeholder="EC begin">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<input type="text" name="ECEnd" placeholder="EC end">--%>
        <%--<input type="text" name="ECTrialPeriod" placeholder="EC trial period">--%>
        <%--<input type="text" name="expectedStartingAtCompany" placeholder="expected starting at company">--%>
        <%--<input type="text" name="duration" placeholder="duration">--%>
        <%--<input type="text" name="marriedStatus" placeholder="marriedStatus">--%>
        <%--<input type="text" name="currentOccupation" placeholder="currentOccupation">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<input type="text" name="presentedToCompany" placeholder="presentedToCompany">--%>
        <%--<input type="text" name="ministryOfForeignAffairs" placeholder="ministry of foreign affairs">--%>
        <%--<input type="text" name="interviewAtConsulate" placeholder="interview at consulate">--%>
        <%--<input type="text" name="pickingUpTheVISA" placeholder="picking up the VISA">--%>
        <%--<input type="text" name="registrationAtLocalOffice" placeholder="registration at local office">--%>
        <%--<input type="text" name="startingToWork" placeholder="starting to work">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<input type="text" name="receivingEmploymentCard" placeholder="receiving employment card">--%>
        <%--<br/>--%>
        <%--<br/>--%>
        <%--<textarea name="comments" placeholder="comments"></textarea>--%>

        <input type="hidden" name="coordinator" value="${key}">
        <br/>
        <input type="submit" value="add Employee">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

</div>


<script src="../js/main.js"></script>
<jsp:include page="../templates/footer.jsp"/>