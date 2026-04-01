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
        background: linear-gradient(
                                      to bottom right,
                                      rgb(232, 237, 237),
                                      rgb(155, 236, 166)
                                    );
    }

    .register-container {
        background:linear-gradient(to bottom right,  rgb(181, 222, 181), rgb(149, 226, 149));
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
        background-color: rgba(243, 249, 243, 0.652);
    }

    .input-group input:focus {
        border-color: #667eea;
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: green;
        border: none;
        border-radius: 5px;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {

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
    <form action="reg" method="post">
        <div class="input-group">
            <label>Full Name</label>
            <input type="text" name="name" placeholder="Enter your name" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email" placeholder="Enter your email" required>
        </div>

          <div class="input-group">
                            <label>Phone</label>
                            <input type="number" name="phone" placeholder="Enter phone" required>
            </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Create password" required>
        </div>


        <button type="submit" class="btn">Register</button>

        <div class="extra">
            <p>Already have an account? <a href="login">Login</a></p>
        </div>
    </form>
</div>

</body>
</html>