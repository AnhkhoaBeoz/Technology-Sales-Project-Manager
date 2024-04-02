
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Quản Lí Tài Khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <%@ include file="menu.jsp"%>
    </div>
    <div class="container d-flex flex-row-reverse bd-highlight mb-3">
        <div class="p-2 bd-highlight">
            <a href="${pageContext.request.contextPath}/accounts/create" class="btn btn-primary">Thêm Tài Khoản</a>
        </div>
    </div>
    <div class="container">
        <table class="table table-striped text-center">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Email</th>
                <th scope="col">User Name</th>
                <th scope="col">Address</th>
                <th scope="col">Full Name</th>
                <th scope="col">Phone</th>
                <th scope="col" colspan="2">Thao Tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accounts}" var="user">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.email}</td>
                    <td>${user.username}</td>

                    <td>${user.address}</td>
                    <td>${user.fullName}</td>
                    <td>${user.phone}</td>
                    <td><a href="/accounts/edit/${user.id}" class="btn btn-primary">Sửa</a></td>
                    <td><a href="#" onclick="confirmDelete('/accounts/delete/${user.id}')" class="btn btn-danger">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row align-items-end container">
        <%@ include file="footer.jsp" %>
    </div>
</div>
</body>
<script>
    function confirmDelete(url) {
        if (confirm("Are you sure you want to delete this account?")) {
            window.location.href = url;
        }
    }
</script>
</html>