
<%@tag description="Navbar tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">Home</a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/add"/>">Add audio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/audios"/>">My audios</a>
                </li>
            </sec:authorize>
        </ul>

        <sec:authorize access="isAuthenticated()">
            <ul class="navbar-nav">
                <li class="nav-item ">
                    <dir class="nav-link">
                        <sec:authentication property="principal.username"/>
                    </dir>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a class="btn btn-outline-secondary my-2 my-sm-0" href="<c:url value="/signup"/>">Sign up</a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<c:url value="/login"/>">Log in</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a class="btn btn-outline-danger my-2 my-sm-0" href="<c:url value="/logout"/>">Log out</a>
        </sec:authorize>
    </div>
</nav>
<br/>


