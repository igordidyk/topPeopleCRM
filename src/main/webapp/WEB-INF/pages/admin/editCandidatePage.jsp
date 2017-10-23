<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/allCandidates">Candidates</a></li>
        <li class="active">Edit candidate</li>
        <p class="navbar-right"><a href="/logout">Log out</a></p>
    </ol>

    <h2>Edit candidate information</h2>
    <form action="/admin/candidate/save" method="post">
        <input type="hidden" name="id" value="${candidate.id}">
        <input type="text" name="name" placeholder="name" value="${candidate.name}">
        <input type="text" name="surname" placeholder="surname" value="${candidate.surname}">
        <input type="text" name="gender" placeholder="gender" value="${candidate.gender}">
        <input type="text" name="nationality" placeholder="nationality" value="${candidate.nationality}">
        <input type="text" name="dateOfBirth" placeholder="date of birth" value="${candidate.dateOfBirth}">
        <input type="text" name="marriedStatus" placeholder="married status" value="${candidate.marriedStatus}">
        <input type="text" name="birthPostIndex" placeholder="Birthday postIndex" value="${candidate.birthPlace.postIndex}">
        <br>
        <br>
        <input type="text" name="currentOccupation" placeholder="current occupation" value="${candidate.currentOccupation}">
        <input type="text" name="telephone" placeholder="telephone" value="${candidate.telephone}">
        <input type="text" name="email" placeholder="email" value="${candidate.email}">
        <input type="text" name="receivingEmploymentCard" placeholder="receiving employment card" value="${candidate.receivingEmploymentCard}">
        <select name="position">
            <c:forEach items="${cziscoList}" var="isco">
                <option value="${isco.id}"
                        <c:if test="${candidate.position == isco.ENG_position}">
                            selected
                        </c:if>
                >${isco.ENG_position}</option>
            </c:forEach>
        </select>

        <br>
        <br>

        <%--<label for="employee-place">birth place</label>--%>
        <%--<input type="checkbox" onchange="show()" id="employee-place">--%>

        <%--<div id="birthplace">--%>

        <input type="text" name="countryOfBirth" placeholder="country of birth" value="${candidate.birthPlace.countryOfBirth}">
        <input type="text" name="birthPlace" placeholder="born place" value="${candidate.birthPlace.birthPlace}">
        <input type="text" name="street" placeholder="street" value="${candidate.birthPlace.street}">
        <input type="text" name="cityOrVillage" placeholder="city or village" value="${candidate.birthPlace.cityOrVillage}">
        <%--<input type="text" name="zip" placeholder="zip" value="${candidate.zip}">--%>
        <%--</div>--%>

        <%--<label for="employee-address">Address</label>--%>
        <%--<input type="checkbox" id="employee-address" onchange="show()">--%>
        <br>
        <br>
        <%--<div id="address">--%>
        <input type="text" name="country" placeholder="Address country" value="${candidate.address.country}">
        <input type="text" name="region" placeholder="Address region" value="${candidate.address.region}">
        <input type="text" name="city" placeholder="Address city" value="${candidate.address.city}">
        <input type="text" name="addrPostIndex" placeholder="Address postIndex" value="${candidate.address.postIndex}">
        <input type="text" name="adressStreet" placeholder="Address street" value="${candidate.address.street}">
        <input type="text" name="numberOfHouse" placeholder="Address number of house" value="${candidate.address.numberOfHouse}">
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
        <input type="text" name="passportNomer" placeholder="passport number" value="${candidate.passportNumber}">
        <input type="text" name="passportValidUntil" placeholder="passport valid until" value="${candidate.passportValidUntil}">
        <input type="text" name="issuedByAuthority" placeholder="issued by authority" value="${candidate.issuedByAuthority}">
        <input type="text" name="receivedOrder" placeholder="received order" value="${candidate.receivedOrder}">
        <br/>
        <br/>
        <input type="number" name="phase" placeholder="phase" value="${candidate.phase}">
        <input type="number" name="status" placeholder="status" value="${candidate.status}">
        <input type="text" name="schengen" placeholder="schengen" value="${candidate.schengen}">
        <input type="text" name="workingAgreement" placeholder="working agreement" value="${candidate.workingAgreement}">
        <input type="text" name="workingAgree" placeholder="working agree" value="${candidate.workingAgree}">
        <input type="text" name="confirmationOfLivingPlace" placeholder="confirmation of living place" value="${candidate.confirmationOfLivingPlace}">
        <br/>
        <br/>
        <input type="text" name="beginWorkingContract" placeholder="begin working contract" value="${candidate.beginWorkingContract}">
        <input type="text" name="endWorkingContract" placeholder="end working contract" value="${candidate.endWorkingContract}">
        <input type="text" name="schengenTrialPeriod" placeholder="schengen trial period" value="${candidate.schengenTrialPeriod}">
        <input type="text" name="realStartingOfSchengen" placeholder="real starting of schengen" value="${candidate.realStartingOfSchengen}">
        <input type="text" name="multiVisa" placeholder="multi visa" value="${candidate.multiVisa}">
        <input type="text" name="ECBegin" placeholder="EC begin" value="${candidate.ECBegin}">
        <br/>
        <br/>
        <input type="text" name="ECEnd" placeholder="EC end" value="${candidate.ECEnd}">
        <input type="text" name="ECTrialPeriod" placeholder="EC trial period" value="${candidate.ECTrialPeriod}">
        <input type="text" name="expectedStartingAtCompany" placeholder="expected starting at company" value="${candidate.expectedStartingAtCompany}">
        <input type="text" name="duration" placeholder="duration" value="${candidate.duration}">
        <br/>
        <br/>
        <input type="text" name="presentedToCompany" placeholder="presentedToCompany" value="${candidate.presentedToCompany}">
        <input type="text" name="ministryOfForeignAffairs" placeholder="ministry of foreign affairs" value="${candidate.ministryOfForeignAffairs}">
        <input type="text" name="interviewAtConsulate" placeholder="interview at consulate" value="${candidate.interviewAtConsulate}">
        <input type="text" name="pickingUpTheVISA" placeholder="picking up the VISA" value="${candidate.pickingUpTheVISA}">
        <input type="text" name="registrationAtLocalOffice" placeholder="registration at local office" value="${candidate.registrationAtLocalOffice}">
        <input type="text" name="startingToWork" placeholder="starting to work" value="${candidate.startingToWork}">
        <br/>
        <br/>

        <textarea name="comments" placeholder="comments" value="${candidate.comments}">${candidate.comments}</textarea>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="save Changes">

    </form>
</div>

<jsp:include page="../templates/footer.jsp"/>

