<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Forget Password</title>
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      .main {
        width: 100%;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        gap: 10vh;
        align-items: center;
        justify-content: center;
        background: linear-gradient(
          to bottom right,
          rgb(232, 237, 237),
          rgb(155, 236, 166)
        );
      }
      .main form {
        background: linear-gradient(
          to bottom right,
          rgb(144, 228, 133),
          rgb(117, 163, 123)
        );

        width: 35%;
        height: 10vh;
        border-radius: 15px;
        border: none;
        background-color: whitesmoke;
        padding: 70px 5px;
        box-shadow: 6px 6px 15px gray;
      }
      .form1 {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 10px;
      }
      .form1 input{
        padding: 7px 10px;
        border: none;
        border-radius: 7px;
      }
      .form2 {
        display: flex;
        flex-direction: column;
        gap: 10px;
        align-items: center;
        justify-content: center;
      }
      .form2 input {
        padding: 6px 8px;
        border: none;
        border-radius: 7px;
      }
      form button {
        color: white;
        background-color: green;
        padding: 8px 12px;
        border: none;
        border-radius: 7px;
      }
      .form1 p{
        color: red;
        font-size: 15px;
        text-align: center;
      }
      .back{
        text-decoration: none;
        padding: 8px 15px;
        border:none;
        border-radius: 15px;
        background-color: green;
        color: white;
        position: absolute;
        left: 5vh;
        top: 5vh;
      }
    </style>
  </head>
  <body>
    <div class="main">
    <a class="back" href="/login">Back</a>
      <form class="form1" action="/sendotp" method="post">
        <p>${msg}</p>
        <input type="email" name="email" placeholder="Enter email" />
        <button type="submit">Send OTP</button>
      </form>

      <form class="form2" action="/otp" method="post">
        <input type="number" name="otps" placeholder="Enter OTP here" />
        <button type="submit">Validate OTP</button>
      </form>
    </div>
  </body>
</html>
