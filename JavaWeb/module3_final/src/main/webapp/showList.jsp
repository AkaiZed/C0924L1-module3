<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thống kê sách</title>
</head>
<body>
<h2>Danh sách sách</h2>
<%--<form method="get" action="BookController">--%>
<%--    <input type="text" name="keyword" placeholder="Tìm sách hoặc tác giả">--%>
<%--    <button type="submit">Tìm kiếm</button>--%>
<%--</form>--%>

<table border="1">
    <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="book" items="${booksList}">
        <tr>
            <td>${book.maSach}</td>
            <td>${book.tenSach}</td>
            <td>${book.tacGia}</td>
            <td>${book.soLuong}</td>
            <td>${book.moTa}</td>
            <td><a href="borrow.jsp?maSach=${book.maSach}">Mượn</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
