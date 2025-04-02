<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 3/26/2025
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Ký</title>
</head>
<body>
<form action="RegisterServlet" method="get" class="login-form">
    <div class="form-group">
        <label >Tài khoản:</label>
        <input type="text" id="taiKhoan" name="taiKhoan" required placeholder="Nhập tài khoản của bạn">
        <i class="fas fa-envelope"></i>
    </div>
    <div class="form-group">
        <label for="password">Mật Khẩu:</label>
        <input type="password" id="password" name="password" required placeholder="Nhập mật khẩu">
        <i class="fas fa-lock"></i>
    </div>
    <div class="form-options">
        <label>
            <input type="checkbox" name="remember-me"> Remember me
        </label>
        <a href="forgotPassword.jsp" class="forgot-password">Forgot password?</a>
    </div>
    <button type="submit" class="submit-btn">Đăng nhập</button>
    <p class="register-link">Don't have an account? <a href="register.jsp">Register</a></p>
</form>
</body>
</html>
