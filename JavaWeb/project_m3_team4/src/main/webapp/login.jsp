<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="/view/LoginStyle.css">
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>
<div class="login-container">
    <h2>Đăng nhập tài khoản</h2>
    <form action="CustomerServlet" method="POST">
        <input class="input-field" type="text" name="username" placeholder="Tên đăng nhập" required>
        <input class="input-field" type="password" name="password" placeholder="Mật khẩu" required>
        <button type="submit" class="login-btn">Đăng nhập</button>
    </form>
    <div class="extra-links">
        <a href="SignUp.jsp">Đăng ký</a>
        <a href="ForgotPassword.jsp">Quên mật khẩu?</a>
    </div>

    <c:if test="${not empty errorMessage}">
        <div style="color: red; text-align: center;">${errorMessage}</div>
    </c:if>
</div>
</body>
</html>
