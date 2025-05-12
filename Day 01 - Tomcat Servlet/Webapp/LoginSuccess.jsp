<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #2575fc, #6a11cb);
            color: #ffffff;
            text-align: center;
            padding-top: 60px;
        }

        h1 {
            font-size: 38px;
            color: #ffffff;
        }

        h3 {
            font-size: 28px;
            color: #e0e0e0;
            margin-top: 10px;
        }

        p {
            font-size: 18px;
            color: #dcdcdc;
        }

        a {
            display: inline-block;
            margin-top: 25px;
            padding: 12px 28px;
            background-color: #00c9a7;
            color: #ffffff;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            transition: 0.3s ease;
        }

        a:hover {
            background-color: #00b09b;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <h1>SUCCESSFUL LOGIN</h1>
    <h3>Hi <%= request.getAttribute("user") %>, Login successful!</h3>
    <p>Welcome to your account.</p>
    <a href="login.html">Logout?</a>
</body>
</html>
