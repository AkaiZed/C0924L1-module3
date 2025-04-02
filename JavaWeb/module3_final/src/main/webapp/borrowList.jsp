<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sách đã mượn</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container mt-4">
    <h2>Danh sách sách đã mượn</h2>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Mã mượn sách</th>
            <th>Tên sách</th>
            <th>Tên học sinh</th>
            <th>Ngày mượn</th>
            <th>Ngày trả</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="card" items="${cardsList}">
            <tr>
                <td>${card.maMuonSach}</td>
                <td>${card.tenSach}</td>
                <td>${card.tenHocSinh}</td>
                <td>${card.ngayMuon}</td>
                <td>${card.ngayTra}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>