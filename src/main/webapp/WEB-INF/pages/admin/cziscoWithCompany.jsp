<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/company">Company</a></li>
        <li class="active">CZ_ISCO</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>

    </ol>


    <h2>Create CZ_ISCO</h2>
    <form action="/admin/company/createISCO" method="post">
        <input type="text" name="czisco" placeholder="czisco">
        <input type="text" name="kkov" placeholder="kkov">
        <input type="text" name="ENG_position" placeholder="ENG_position">
        <input type="text" name="CZ_position" placeholder="CZ_position">
        <input type="text" name="numberOfVacancy" placeholder="numberOfVacancy">
        <input type="text" name="CZ_text" placeholder="CZ_text">
        <input type="hidden" name="idCompany" value="${company.id}">
        <br/>
        <br/>
        <input type="submit" value="CREATE">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <br>


    <br/>
    <h2>All CZ_ISCO </h2>
    <table id="czisco">
        <thead>
        <tr>
            <th>CZ_ISCO number</th>
            <th>KKOV</th>
            <th>ENG position</th>
            <th>CZ position</th>
            <th>Number Of Vacancy</th>
            <th>CZ_text</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${ISCOList}" var="isco">
            <tr>

                <td>${isco.czisco}</td>
                <td>${isco.kkov}</td>
                <td>${isco.ENG_position}</td>
                <td>${isco.CZ_position}</td>
                <td>${isco.numberOfVacancy}</td>
                <td>${isco.CZ_text}</td>

            </tr>


        </c:forEach>
        </tbody>
    </table>
    <script type="text/javascript" charset="utf-8">
        $('#czisco').dataTable();

        let exportElem = document.getElementById('exportToFile');
        exportElem.style.display = "none";
        function show() {
            if (document.getElementById("export").checked) exportElem.style.display = "block";
            else exportElem.style.display = "none";

        };

    </script>
</div>


<jsp:include page="../templates/footer.jsp"/>