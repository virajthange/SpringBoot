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
            background:  var(--dark-color);
            background: linear-gradient(
                    135deg,
                    #2F311C,
                    #4A4D2E,
                    #55593A
                );
        }

        .login-text {
            color: black;
            font-size: 24px;
            margin-bottom: 20px;
        }
        form button {
            background-color: var(--dark-color);
            width: 100%;
            color: white;
            border: none;
            padding: 8px 10px;
            border-radius: 10px;
            font-weight: 600;
        }
        .form-container {
            /*
            background-color: var(--medium-color);
            */
            background-color: whitesmoke;
            backdrop-filter: blur(50px);
            padding: 80px 40px;
            border-radius: 10px;
            width: 25%;
            height: fit-content;
            box-shadow: 10px 10px 15px black;
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

        .form-container  a {
            color: blue;
            list-style: none;
            text-decoration: none;
        }
        form input {
            padding: 7px;
            border-radius: 5px;
            width: 100%;
            border: none;
            outline: none;
            background-color: white;
        }
        form input:focus {
            border-color: #4A4D2E;
            box-shadow: 0 0 10px rgba(74,77,46,0.3);
        }
        form button:hover {
            background: #55593A;
        }
    </style>
</head>
<body>
    <div class="login-page">
        <div class="form-container">
            <form action="/login" method="post">
            <h2 class="login-text">Login here</h2>
            <input type="email" name="username" required placeholder="Enter email">
            <input type="password" name="password" required placeholder="Enter password">
            <button type="submit">Login</button>
            <a href="/auth/register"> Haven't registered yet ? Register here </a>
        </form>
        </div>
    </div>
</body>
</html>