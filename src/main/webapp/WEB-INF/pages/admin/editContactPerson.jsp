<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header_link.jsp"/>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/company">Company</a></li>
        <li class="active">Edit contact person</li>
        <p class="navbar-right"><a href="/logout">Log out </a></p>
    </ol>
    <h2>Edit this person</h2>
    <%--<form action="/admin/company/save" method="post">--%>
        <%--<input type="text" name="nameCompany" value="${company.nameCompany}" placeholder="nameCompany">--%>
        <%--&lt;%&ndash;<input type="number" name="numberOfCanditates" value="${company.numberOfCanditates}" placeholder="numberOfCanditates">&ndash;%&gt;--%>
        <%--<input type="text" name="IC" placeholder="IC" value="${company.IC}">--%>
        <%--<input type="text" name="contactAddress" placeholder="Contact Address" value="${company.contactAddress}">--%>
        <%--<input type="text" name="telephone" placeholder="telephone" value="${company.telephone}">--%>
        <%--<input type="text" name="email" placeholder="email" value="${company.email}">--%>
        <%--<input type="text" name="CZ_NACE" placeholder="CZ_NACE" value="${company.CZ_NACE}">--%>
        <%--<input type="hidden" name="company" value="${company.id}">--%>
        <%--<input type="hidden"--%>
               <%--name="${_csrf.parameterName}"--%>
               <%--value="${_csrf.token}"/>--%>

        <%--<input type="submit" value="save Changes">--%>

    <%--</form>--%>

    <form action="/admin/company/editChanges" method="post">
        <input type="text" name="firstName" placeholder="firstName" value="${person.firstName}">
        <input type="text" name="lastName" placeholder="lastName" value="${person.lastName}">
        <input type="text" name="position" placeholder="position" value="${person.position}">
        <input type="text" name="email" placeholder="email" value="${person.email}">
        <input type="text" name="telephone" placeholder="telephone" value="${person.telephone}">
        <input type="hidden" name="idPerson" value="${person.id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <br/>
        <br/>
        <input type="submit"  value="SAVE CHANGES">
    </form>

</div>
<jsp:include page="../templates/footer.jsp"/>