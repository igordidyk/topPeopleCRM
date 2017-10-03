<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="templates/header_link.jsp"/>

<div class="row">
    <div class="col-md-6 col-md-offset-3 text-center">
        <div class="panel panel-default " style="margin-top: 200px;" >
            <div class="panel-heading">Login with Username and Password</div>
            <div class="panel-body">
                <c:url var="loginUrl" value="/login"/>
                <form action="${loginUrl}" method="post" class="form-horizontal ">
                    <%--Start alert message--%>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>Invalid username and password.</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>You have been logged out successfully.</p>
                        </div>
                    </c:if>
                    <%--End alert --%>
                    <div class="input-group input-sm">
                        <label for="input_UsName" class="input-group-addon"><span
                                class="glyphicon glyphicon-user"></span></label>

                        <input type="text" required
                               class="form-control"
                               id="input_UsName" name="username"
                               placeholder="Input Username"/>

                    </div>

                    <div class="input-group input-sm">
                        <label for="input_Password" class="input-group-addon"><span
                                class="glyphicon glyphicon-lock"></span></label>

                        <input type="password"
                               required
                               class="form-control" id="input_Password" name="password"
                               placeholder="*******"/>
                    </div>

                    <div class="form-actions">
                        <input type="submit"
                               class="btn btn-block btn-primary btn-default" value="Log in">
                    </div>


                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                </form>

            </div>
        </div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>

