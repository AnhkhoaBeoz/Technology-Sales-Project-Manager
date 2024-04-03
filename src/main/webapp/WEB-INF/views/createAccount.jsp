<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Tạo thêm tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

</head>
<body>
<div class="container">
    <c:if test="${!empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <h1 class="text-center mt-4">Manager Account</h1>
    <form:form action="/admin/accounts/save" method="post" modelAttribute="newAccount">
        <div class="form-group">
            <form:hidden path="id" class="form-control" id="username" name="username"/>
            <form:errors path="id" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="username" for="username">Username:</form:label>
            <form:input path="username" type="text" class="form-control" id="username" name="username"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>

            <div class="form-group">
                <form:label path="password" for="password">Password:</form:label>
                <form:input path="password" type="password" class="form-control" id="password" name="password"/>
                <form:errors path="password" cssClass="text-danger"/>
            </div>
        <div class="form-group">
            <form:label path="email" for="email">Email:</form:label>
            <form:input path="email" type="email" class="form-control" id="email" name="email"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="phone" for="phone">Phone:</form:label>
            <form:input path="phone" type="text" class="form-control" id="phone" name="phone"/>
            <form:errors path="phone" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="address" for="address">Address:</form:label>
            <form:input path="address" type="text" class="form-control" id="address" name="address"/>
            <form:errors path="address" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <form:select path="roles" class="form-control" id="role" multiple="true">
                <c:forEach var="role" items="${roles}">
                    <form:option value="${role.id}">${role.name}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="roles" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary mt-4">Submit</button>
    </form:form>
</div>
</body>
</html>
