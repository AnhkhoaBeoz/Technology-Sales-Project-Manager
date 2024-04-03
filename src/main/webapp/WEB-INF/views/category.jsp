<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Category Management</h1>
                <hr>
                <a href="/admin/category/add" class="btn btn-primary">Create</a>
                <table class="table table-bordered table-striped text-center" >
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th colspan="2">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>
                                <a href="/admin/category/edit/${category.id}"
                                   class="btn btn-warning">Edit</a>
                                <a href="#" onclick="confirmDelete('/admin/category/delete/${category.id}')   "
                                   class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <%@ include file="footer.jsp" %>
        </div>
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