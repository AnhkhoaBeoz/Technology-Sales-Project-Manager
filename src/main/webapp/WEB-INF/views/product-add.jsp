<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center">Product Management</h1>
            <hr>
        </div>
    </div>
    <c:if test="${not empty message}">
        <div class="alert alert-danger" role="alert">
                ${message}
        </div>
    </c:if>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <hr>
                <form:form action="/admin/product/confirmAdd" method="post" modelAttribute="product" enctype="multipart/form-data">
                    <div class="form-group">
                        <form:label path="productName">Product Name</form:label>
                        <form:input path="productName" type="text" class="form-control" id="productName" required="true"/>
                    </div>
                    <div class="form-group">
                        <form:label path="description">Description</form:label>
                        <form:textarea path="description" class="form-control" id="description" rows="3" required="true"/>
                    </div>
                    <div class="form-group">
                        <form:label path="price">Price</form:label>
                        <form:input path="price" type="number" class="form-control" id="price" min="0" step="0.01" required="true"/>
                    </div>
                    <div class="form-group">
                        <form:label path="category">Category</form:label>
                        <form:select path="category" class="form-control" id="category" required="true">
                            <form:option value="" label="Select category"/>
                            <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label for="file">Image</label>
                        <input type="file" class="form-control" id="file" name="file">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
    <div class="row">
        <%@ include file="footer.jsp" %>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>