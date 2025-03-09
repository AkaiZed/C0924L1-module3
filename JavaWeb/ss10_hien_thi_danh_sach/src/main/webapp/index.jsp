<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Customer</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Danh sách khách hàng</h2>

<c:set var="customers" value="${[
    {'name':'Mai Văn Hoàn','dob':'1983-08-20','address':'Hà Nội','image':'anh/anh1.png'},
    {'name':'Nguyễn Văn Nam','dob':'1983-08-21','address':'Bắc Giang','image':'anh/anh2.jpg'},
    {'name':'Nguyễn Thái Hòa','dob':'1983-08-22','address':'Nam Định','image':'anh/anh3.jpg'},
    {'name':'Trần Đăng Khoa','dob':'1983-08-17','address':'Hà Tây','image':'anh/anh4.png'},
    {'name':'Nguyễn Đình Thi','dob':'1983-08-19','address':'Hà Nội','image':'anh/anh5.jpg'}
]}"/>

<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dob}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.image}" alt="Ảnh ${customer.name}"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
