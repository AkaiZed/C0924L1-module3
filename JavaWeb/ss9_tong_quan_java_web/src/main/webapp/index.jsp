<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
<h2>Discount Calculator</h2>
<form action="sum" method="post">
    <%--    <label>Product Description:</label>--%>
    <%--    <input type="text" name="description"><br><br>--%>

    List Price: <input type="number" name="listPrice">
    <br><br>
    Discount Percent: <input type="number" name="discountPercent"><br><br>

    <button>Calculate Discount</button>
    <%--    <button type="submit">Calculate Discount</button>--%>
</form>
</body>
</html>