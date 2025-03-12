<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa sản phẩm</title>
<%--    <link rel="stylesheet" href="style.css">--%>
</head>
<body>
<h1>Sửa sản phẩm</h1>
<form action="/products?action=edit" method="post">
    <input type="hidden" name="id" value="${product.id}">
    Tên sản phẩm:
    <input type="text" id="name" name="name" value="${product.name}" required><br><br>
    Giá sản phẩm:
    <input type="number" id="price" name="price" value="${product.price}" step="0.01" required><br><br>
    Số lượng sản phẩm:
    <input type="number" id="count" name="count" value="${product.count}" required><br><br>

    <button type="submit" class="btn add-btn">Cập nhật sản phẩm</button>
    <a href="/products">
        <button type="button" class="btn view-btn">Quay lại</button>
    </a>
</form>
</body>
</html>
