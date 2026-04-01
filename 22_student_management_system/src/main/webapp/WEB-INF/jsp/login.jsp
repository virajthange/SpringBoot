<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Form</title>

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

      .login-container {
        background:linear-gradient(to bottom right,  rgb(181, 222, 181), rgb(149, 226, 149));
        padding: 40px;
        width: 370px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        text-align: center;
      }

      .login-container h2 {
        margin-bottom: 25px;
        color: #333;
      }

      .input-group {
        margin-bottom: 20px;
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
      .errmsg {
        font-size: 14px;
        font-weight: 500;
        display: inline-block;
        background: whitesmoke;
        color: red;
        border-radius: 10px;
        padding: 5px 10px;
        margin-bottom: 20px;
      }
      .forget{
        width: 100%;
        text-align: center;
        padding: 5px 0;
        font-size: 13px;

      }
      .forget a{
        text-decoration: none;
        color: purple;

      }
    </style>
  </head>

  <body>
    <div class="login-container">
      <h2>Login</h2>
      <form action="/auth" method="post">
      <%
        if(request.getAttribute("msg") != null) {
      %>
            <p class="errmsg"> ${msg} </p>
      <%
        }
      %>
        <div class="input-group">
          <label>Email</label>
          <input type="text" name="email" placeholder="Enter your email" required />
        </div>

        <div class="input-group">
          <label>Password</label>
          <input type="password" name="password" placeholder="Enter your password" required />
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="extra">
          <p>Don't have an account? <a href="register">Register</a></p>
        </div>
        <div class="forget"> <a href="forgetpassword">Forget passowrd ?</a></div>
      </form>
    </div>
  </body>
</html>
