<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        :root{
            --dark-color: #2F311C;
            --light-color: #55593A;
            --medium-color: #4A4D2E;
            --prim-color: #3B3D24;
        }
        body{
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: var(--dark-color);
        }

        .login-text {
            color: white;
            font-size: 24px;
            margin-bottom: 20px;
        }
        form button {
            background-color: green;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 10px;
        }
        .form-container {
            background-color: var(--medium-color);
            padding: 20px;
            border-radius: 10px;
            width: 35%;
            height: fit-content;

        }
        .login-page {
            height: 100vh;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 20px;
        }
        .form-container p {
            color: blue
        }
        .form-container p a {
                    list-style: none;
        }
        form input {
            padding: 7px;
            border-radius: 5px;
            border: none;
            outline: none;

        }
    </style>
</head>
<body>
    <div class="login-page">
        <div class="form-container">
            <form action="/login" method="post">
            <h2 class="login-text">Login here</h2>
            <input type="email" required placeholder="Enter email">
            <input type="password" required placeholder="Enter password">
            <button type="submit">Login</button>
            <p>Haven't registered yet ? <a href="/register">Register here</a></p>
        </form>
        </div>
    </div>
</body>
</html>