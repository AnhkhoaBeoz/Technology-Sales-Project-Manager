<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-success">
        <div class="container-fluid">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="${pageContext.request.contextPath}/img/brand-logo.svg" alt="Brand Logo" width="100"
                     height="60" class="me-2">
            </a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text_hyperlink font-weight-bold ${pageContext.request.requestURI == '/admin/accounts' ? 'active' : ''}" href="/admin/accounts">Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text_hyperlink font-weight-bold ${pageContext.request.requestURI == '/admin/role' ? 'active' : ''}" href="/admin/role">Role</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text_hyperlink font-weight-bold ${pageContext.request.requestURI == '/admin/category' ? 'active' : ''}" href="/admin/category">Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text_hyperlink font-weight-bold ${pageContext.request.requestURI == '/admin/product' ? 'active' : ''}" href="/admin/product">Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text_hyperlink font-weight-bold ${pageContext.request.requestURI == '/admin/order' ? 'active' : ''}" href="/admin/order">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="/auth/logout">Logout</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<script type="javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>