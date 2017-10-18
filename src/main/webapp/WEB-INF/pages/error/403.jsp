<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="../templates/header_link.jsp"/>

Dear <strong>${user}</strong>, You are not authorized to access this page
<a href="<c:url value="/logout" />">Logout</a>

<jsp:include page="../templates/footer.jsp"/>
