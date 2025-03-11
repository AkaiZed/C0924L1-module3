<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<form action="/products" method="post">
    <input type="hidden" name="action" value="add">
    <label for="id">Mã sản phẩm:</label><br>
    <input type="number" id="id" name="id" required><br><br>

    <label for="name">Tên sản phẩm:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="price">Giá sản phẩm:</label><br>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="count">Số lượng sản phẩm:</label><br>
    <input type="number" id="count" name="count" required><br><br>

    <button type="submit" class="btn add-btn">Thêm sản phẩm</button>
    <a href="/products"><button type="button" class="btn view-btn">Quay lại</button></a>
</form>
</body>
</html>