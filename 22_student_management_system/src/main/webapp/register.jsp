<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register Form</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #667eea, #764ba2);
    }

    .register-container {
        background: #ffffff;
        padding: 40px;
        width: 380px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    .register-container h2 {
        margin-bottom: 25px;
        color: #333;
    }

    .input-group {
        margin-bottom: 18px;
        text-align: left;
    }

    .input-group label {
        display: block;
        margin-bottom: 5px;
        font-size: 14px;
        color: #555;
    }

    .input-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        outline: none;
        transition: 0.3s;
    }

    .input-group input:focus {
        border-color: #667eea;
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #667eea;
        border: none;
        border-radius: 5px;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        background: #5a67d8;
    }

    .extra {
        margin-top: 15px;
        font-size: 14px;
    }

    .extra a {
        color: #667eea;
        text-decoration: none;
    }

    .extra a:hover {
        text-decoration: underline;
    }
</style>
</head>

<body>

<div class="register-container">
    <h2>Register</h2>
    <form>
        <div class="input-group">
            <label>Full Name</label>
            <input type="text" placeholder="Enter your name" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" placeholder="Enter your email" required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" placeholder="Create password" required>
        </div>

        <div class="input-group">
            <label>Confirm Password</label>
            <input type="password" placeholder="Confirm password" required>
        </div>

        <button type="submit" class="btn">Register</button>

        <div class="extra">
            <p>Already have an account? <a href="login">Login</a></p>
        </div>
    </form>
</div>

</body>
</html>