<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
            width: 40%;
            margin: auto;
            margin-bottom: 2rem;
        }

        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }

        .container {
            padding: 2px 16px;
        }
    </style>
</head>
<body>
<h1>Product List</h1>
<c:forEach var="product" items="${products}">
    <div class="card">
        <img src="${product.image}" alt="${product.name}" style="width:100%">
        <div class="container">
            <h4><b>${product.name}</b></h4>
            <p>${product.price}</p>
            <form action="add-to-cart" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </div>
</c:forEach>
</body>
</html>