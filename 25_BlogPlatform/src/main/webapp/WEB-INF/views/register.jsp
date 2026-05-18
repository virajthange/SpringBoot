<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>

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

        .register-text {
            color: white;
            font-size: 24px;
            margin-bottom: 20px;
        }
        form button {
            background-color: rgb(53, 153, 193);
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
        .register-page {
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
        form input {
            padding: 7px;
            border-radius: 5px;
            border: none;
            outline: none;

        }
        .already {
            color: rgb(144, 144, 245);
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="register-page">
        <div class="form-container">
            <form action="/register" method="post">
            <h2 class="register-text">Register here</h2>
            <input type="text" required placeholder="Enter username">
            <input type="email" required placeholder="Enter email">
            <input type="text" required placeholder="Enter full name">
            <input type="password" required placeholder="Enter password">
            <button type="submit">Register</button>
            <a class="already" href="/login">Already have an account? Login here</a>
        </form>
        </div>
    </div>
</body>
</html>