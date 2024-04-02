<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Đăng nhập tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

</head>
<body>
<div class="container mt-5">
    <c:if test="${not empty successMessage}">
    <div class="alert alert-success" role="alert">
            ${successMessage}
    </div>
    </c:if>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center mb-4">Đăng nhập tài khoản</h1>
                    <form:form action="/auth/confirmLogin" method="post" modelAttribute="loginRequestDTO">
                        <div class="form-group m-3">
                            <form:label path="username" for="username">Username</form:label>
                            <form:input path="username" class="form-control" id="username" name="username"
                                        placeholder="Enter your username"/>
                            <form:errors path="username" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="password" for="password">Password</form:label>
                            <form:input path="password" type="password" class="form-control" id="password"
                                        name="password" placeholder="Enter your password"/>
                            <form:errors path="password" cssClass="text-danger"/>
                        </div>

                        <button type="submit" class="m-3 btn btn-primary btn-block">Sign in</button>
                        <c:if test="${param.error != null}">

                            <i class="text-danger">Sorry! You entered invalid username/password.</i>

                        </c:if>
                    </form:form>
                    <div class="text-center">
                        <a href="/auth/register">Create an account</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>