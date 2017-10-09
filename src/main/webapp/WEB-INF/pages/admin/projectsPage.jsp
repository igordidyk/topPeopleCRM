<jsp:include page="../templates/header_link.jsp"/>

<div class="container">

    <form action="" method="post">
        <input type="text" name="typeOfEmployment" placeholder="type of employment">
        <input type="text" name="position" placeholder="position">
        <input type="text" name="schengenContractStarting" placeholder="schengen contract starting">
        <input type="text" name="ECStarting" placeholder="EC starting">
        <input type="text" name="dateForMedicalDocs" placeholder="date for medical documents">
        <input type="text" name="statusOfReceived" placeholder="status of received">
        <input type="text" name="processingTimePartner" placeholder="processing time partner">
        <input type="text" name="gettingSignedDocuments" placeholder="getting signed Documents">
        <input type="text" name="submissionDocumetns" placeholder="submission documetns">
        <input type="text" name="processingTimeUP" placeholder="processing time UP">
        <input type="text" name="applicationProcess" placeholder="application Process">
        <input type="text" name="readyToGoToCZ" placeholder="readyToGoToCZ">
        <input type="text" name="deviationToWorkingContract" placeholder="deviation to working contract">
        <br>
        <br>
        <input type="submit" value="CREATE PROJECT">
        <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
    </form>




</div>

<jsp:include page="../templates/footer.jsp"/>