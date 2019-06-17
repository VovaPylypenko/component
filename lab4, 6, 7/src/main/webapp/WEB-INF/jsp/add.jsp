<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:base>
    <form:form method="post" action="/add" modelAttribute="audio">
        <h1>Add a new audio</h1>

        <br>
        <h3>Audio name*</h3>
        <form:label class="sr-only" path="name">Name</form:label>
        <form:input class="form-control" path="name" placeholder="Enter name"/>
        <form:errors path="name" class="alert-danger"/>

        <h3>Audio*</h3>
        <form:label class="sr-only" path="name">Audio</form:label>
        <form:textarea class="form-control" path="audio" placeholder="Enter audio"/>
        <form:errors path="audio" class="alert-danger"/>

        <h6 style="color: #dc3545" size="8">* - required</h6>
        <br/>

        <form:button type="submit" class="btn btn-lg btn-primary btn-block">Add</form:button>
    </form:form>
</t:base>
