<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/img/key.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
</head>
<body>
<div class="d-grid">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Product Categories</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <c:forEach items="${categories}" var="category">
                            <li class="nav-item">
                                <a class="nav-link" href="/user/product/category/${category.id}">${category.name}</a>
                            </li>
                        </c:forEach>
                        <li class="nav-item">
                            <a class="nav-link" href="/auth/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>

    <div class="container">
        <h1>Product List</h1>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-4">
                    <section style="background-color: #eee;">
                        <div class="container py-3">
                            <div class="card" style="width: 18rem;">
                                <img src="${pageContext.request.contextPath}/uploads/${product.image}"
                                     class="card-img-top p-3 rounded" alt="${product.productName}"
                                     width="150px" height="200px"/>
                                <div class="card-body">
                                    <h5 class="card-title"
                                        style="font-family: Arial, sans-serif; color: #333; font-size: 20px;">${product.productName}</h5>
                                    <p class="card-text">${product.description}</p>
                                    <div class="d-flex justify-content-between">
                                        <p class="small"><a href="#!" class="text-muted">${product.category.name}</a>
                                        </p>
                                        <p class="small text-danger"><s>$${product.price}</s></p>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <p class="small mb-0">Price: $${product.price}</p>
                                    </div>
                                    <form:form action="/cart/add" method="post">
                                        <input type="hidden" name="productId" value="${product.id}"/>
                                        <input type="hidden" name="quantity" value="1"/>
                                        <button type="submit" class="btn btn-primary btn-sm">Add to cart</button>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>