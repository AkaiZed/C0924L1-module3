<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="/view/SignUpStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/SignUpStyle.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="signup-container">
    <h2>Đăng ký tài khoản</h2>
    <form id="signupForm" action="${pageContext.request.contextPath}/CustomerController" method="post">
        <input type="hidden" name="action" value="signup">
        <div class="input-group">
            <label for="username">Tên đăng nhập</label>
            <input class="input-field" id="username" name="username" type="text" placeholder="Nhập tên đăng nhập" required>
        </div>
        <br>
        <div class="input-group">
            <label for="password">Mật khẩu</label>
            <input class="input-field" id="password" name="password" type="password" placeholder="Nhập mật khẩu" required>
        </div>
        <div class="input-group">
            <label for="email">Email (không bắt buộc)</label>
            <input class="input-field" id="email" name="email" type="email" placeholder="Nhập email">
        </div>
        <div class="input-group">
            <label for="phone">Số điện thoại</label>
            <input class="input-field" id="phone" name="phone" type="text" placeholder="Nhập số điện thoại" required>
        </div>
        <div class="input-group">
            <label for="birthday">Ngày sinh</label>
            <input class="input-field" id="birthday" name="birthday" type="date" required>
        </div>
        <div class="error-msg" id="error-message">
            <c:if test="${not empty errorMessage}">
                ${errorMessage}
            </c:if>
        </div>
        <button type="submit" class="signup-btn">Đăng ký</button>
    </form>
    <div class="login-link">
        <a href="${pageContext.request.contextPath}/CustomerController?action=login">Quay lại đăng nhập</a>
    </div>
</div>
</body>
</html>