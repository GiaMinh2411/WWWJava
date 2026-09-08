<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h1>Đăng nhập</h1>
    <p class="hint">Tài khoản demo: <strong>student</strong> / <strong>123456</strong></p>
    <p class="error">${error}</p>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <label for="username">Tên đăng nhập</label>
        <input id="username" name="username" value="${username}" required autofocus>
        <br/><br/>
        <label for="password">Mật khẩu</label>
        <input id="password" name="password" type="password" required>
        <br/><br/>
        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
