<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mượn sách</title>
    <script>
        function validateDates() {
            const borrowDate = new Date(document.getElementById("ngayMuon").value);
            const returnDate = new Date(document.getElementById("ngayTra").value);
            if (returnDate <= borrowDate) {
                alert("Ngày trả sách phải sau ngày mượn sách!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h2>Mượn sách</h2>

<form method="post" action="BorrowController" onsubmit="return validateDates()">
    <label for="maMuonSach">Mã mượn sách:</label>
    <input type="text" id="maMuonSach" name="maMuonSach" value="MS-${book.maSach}" readonly><br>

    <input type="hidden" name="maSach" value="${book.maSach}">

    <label for="tenSach">Tên sách:</label>
    <input type="text" id="tenSach" name="tenSach" value="${book.tenSach}" readonly><br>

    <label for="maHocSinh">Tên học sinh:</label>
    <select id="maHocSinh" name="maHocSinh">
        <c:forEach var="student" items="${studentsList}">
            <option value="${student.maHocSinh}">${student.hoTen}</option>
        </c:forEach>
    </select><br>

    <label for="ngayMuon">Ngày mượn sách:</label>
    <input type="date" id="ngayMuon" name="ngayMuon" value="${currentDate}" readonly><br>

    <label for="ngayTra">Ngày trả sách:</label>
    <input type="date" id="ngayTra" name="ngayTra" required><br>

    <button type="submit">Mượn sách</button>
    <button type="button" onclick="window.location.href='showList.jsp'">Hủy</button>
</form>

</body>
</html>