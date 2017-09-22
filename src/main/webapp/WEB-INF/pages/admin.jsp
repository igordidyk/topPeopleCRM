<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="templates/header_link.jsp"/>

${principal}

<ul class="breadcrumb">
    <li><a href="/admin">Admin</a></li>
    <li><a href="/admin/company">Company</a></li>
    <li><a href="/admin/coordinator">Coordinator</a></li>
</ul>

<jsp:include page="templates/footer.jsp"/>
