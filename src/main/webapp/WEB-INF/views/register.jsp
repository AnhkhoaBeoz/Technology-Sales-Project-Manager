<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center mb-4">Đăng kí tài khoản</h1>
                    <form:form action="/auth/process_register" method="post" modelAttribute="registerRequestDTO">
                        <div class="form-group m-3">
                            <form:label path="email">Email</form:label>
                            <form:input path="email" class="form-control" id="email" placeholder="Nhập email của bạn"/>
                            <form:errors path="email" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="username">User Name</form:label>
                            <form:input path="username" class="form-control" id="username"
                                        placeholder="Nhập username của bạn"/>
                            <form:errors path="username" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="password">Password</form:label>
                            <form:password path="password" class="form-control" id="password"
                                           placeholder="Nhập mật khẩu"/>
                            <form:errors path="password" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="confirmPassword">Confirm Password</form:label>
                            <form:password path="confirmPassword" class="form-control" id="confirmPassword"
                                           placeholder="Nhập lại mật khẩu"/>
                            <form:errors path="confirmPassword" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="fullName">Full Name</form:label>
                            <form:input path="fullName" class="form-control" id="fullName"
                                        placeholder="Nhập họ và tên"/>
                            <form:errors path="fullName" cssClass="text-danger"/>
                        </div>
                        <div class="form-group m-3">
                            <form:label path="phone">Phone Number</form:label>
                            <form:input path="phone" class="form-control" id="phoneNumber"
                                        placeholder="Nhập số điện thoại"/>
                            <form:errors path="phone" cssClass="text-danger"/>
                        </div>
                        <button type="submit" class="m-3 btn btn-primary btn-block">Đăng Ký</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
