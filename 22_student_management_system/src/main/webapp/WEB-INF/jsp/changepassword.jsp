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
        padding: 50px 5px;
        box-shadow: 6px 6px 15px gray;
      }
      .form1 {
        display: flex;
        flex-direction: column;
        gap: 20px;
        align-items: center;
        justify-content: center;
      }

      .form1 input {
        padding: 6px 8px;
        border: none;
        border-radius: 10px;
      }
      form button {
        color: white;
        background-color: green;
        padding: 8px 12px;
        border: none;
        border-radius: 7px;
      }
    </style>
  </head>
  <body>
    <div class="main">
      <form class="form1" action="/changepass" method="post">
        <input type="text" name="password" placeholder="Enter new password" />
        <button type="submit">Change Password</button>
      </form>

    </div>
  </body>
</html>
