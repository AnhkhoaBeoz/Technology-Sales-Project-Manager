<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Create Role</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <h1 class="text-center mt-4">Create Role</h1>
    <form:form action="/role/save" method="POST" modelAttribute="role" class="mt-4">
        <div class="form-group">
            <form:label path="name">Role Name:</form:label>
            <form:input path="name" class="form-control"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary mt-4">Submit</button>
    </form:form>
    <button><a href="/role" class="btn btn-primary mt-4">Back</a>
    </button>

</div>
</body>
</html>
