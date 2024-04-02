<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Role Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="container d-flex flex-row-reverse bd-highlight mb-3 mt-3">
        <a href="${pageContext.request.contextPath}/role/add" class="btn btn-primary">Thêm mới</a>
    </div>
    <div>
        <table class="table table-striped text-center container">
            <thead class="thead-dark">
            <tr>
                <th>Role ID</th>
                <th>Role Name</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>
                        <a href="/role/edit/${role.id}" class="btn btn-primary">Sửa</a>
                        <a href="#" onclick="confirmDelete('/role/delete/${role.id}')" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="container ">
        <%@ include file="footer.jsp" %>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    function confirmDelete(url) {
        if (confirm("Bạn có chắc chắn muốn xóa không?")) {
            window.location.href = url;
        }
    }
</script>
</body>
</html>