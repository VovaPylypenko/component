
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <div class="mainContainer">
        <form:form action="/signup" class="form-signup" method="post" modelAttribute="user">
            <h1 >Sign up</h1>

            <h3 class="h3 mb-3 font-weight-normal">User name*</h3>
            <%--<form:label class="sr-only" path="username">Username</form:label>--%>
            <form:input class="form-control" placeholder="Username" path="username"/>
            <form:errors path="username" class="alert-danger"/>
            <br/>

            <h3 class="h3 mb-3 font-weight-normal">Password*</h3>
            <%--<form:label class="sr-only" path="password">Password</form:label>--%>
            <form:input type="password" class="form-control" placeholder="Password" path="password"/>
            <form:errors path="password" class="alert-danger"/>
            <br/>

            <h3 class="h3 mb-3 font-weight-normal">Password repeat*</h3>
            <%--<form:label class="sr-only" path="password">Password repeat</form:label>--%>
            <form:input type="password" class="form-control" placeholder="Password" path="password2"/>
            <form:errors path="password2" class="alert-danger"/>

            <h6 style="color: #dc3545" size="8">* - required</h6>
            <br/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        </form:form>
    </div>
</t:base>
