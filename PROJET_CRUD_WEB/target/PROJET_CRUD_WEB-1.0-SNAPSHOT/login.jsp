<%-- 
    Document   : login
    Created on : Feb 1, 2026, 9:41:41 PM
    Author     : jerem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
        }
        .login-card {
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,.2);
        }
    </style>
</head>
<body>

<div class="container h-100 d-flex justify-content-center align-items-center">
    <div class="card login-card p-4 col-md-4">
        <h4 class="text-center mb-4">Login</h4>

        <form action="LoginServlet" method="post">
            <div class="mb-3">
                <label>Username</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button class="btn btn-primary w-100">Login</button>
        </form>

        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
    </div>
</div>

</body>
</html>

