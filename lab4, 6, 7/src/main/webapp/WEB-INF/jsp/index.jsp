
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <div class="jumbotron">
        <h1>
            Hello,
            <sec:authorize access="!isAuthenticated()">
                new user:)
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal.username"/>
            </sec:authorize>
            !
        </h1>
    </div>
</t:base>
