<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>TẠO HOẶC CHỈNH SỬA LOẠI SẢN PHẨM</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div class="container">
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <h1 class="text-center mt-4">LOẠI SẢN PHẨM</h1>
    <div class="row">
        <div class="col-md-6 container">
            <form:form method="post" action="/category/save"
                       modelAttribute="category">
                <form:hidden path="id"/>
                <div class="form-group m-3">
                    <form:label path="name">Tên loại sản phẩm</form:label>
                    <form:input path="name" class="form-control" placeholder="Tên loại sản phẩm"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="form-group m-3">
                    <form:label path="description">Mô tả</form:label>
                    <form:input path="description" class="form-control" placeholder="Mô tả"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary m-3">Lưu</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
