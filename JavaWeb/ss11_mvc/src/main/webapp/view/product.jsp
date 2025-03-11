<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hiển thị sản phẩm</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<div class="actions">
    <a href="/products?action=add"><button class="btn add-btn">Thêm mới sản phẩm</button></a>
</div>
<table>
    <thead>
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm</th>
        <th>Số lượng sản phẩm</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.count}</td>
            <td class="actions">
                <button class="btn edit-btn">Sửa</button>
                <button class="btn delete-btn">Xóa</button>
                <button class="btn view-btn">Xem thêm</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>