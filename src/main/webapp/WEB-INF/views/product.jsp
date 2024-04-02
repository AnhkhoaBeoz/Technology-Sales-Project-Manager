<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <%@ include file="menu.jsp" %>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Product Management</h1>
                <hr>
                <a href="/product/add" class="btn btn-primary">Create</a>
                <table class="table table-bordered table-striped text-center">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th colspan="3">Image</th>
                        <th colspan="2">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productName}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.category.name}</td>
                            <td><img src="${pageContext.request.contextPath}/uploads/${product.image}"
                                     alt="${product.productName}" width="100px" height="100px"></td>
                            <td>
                                <a href="/product/update/${product.id}" class="btn btn-warning">Edit</a>
                                <a href="#" onclick="confirmDelete('/product/delete/${product.id}')"
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
        if (confirm("Are you sure you want to delete?")) {
            window.location.href = url;
        }
    }
</script>
</body>
</html>
