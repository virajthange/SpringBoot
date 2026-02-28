<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
            width: 100%;
            height: 100vh;
        }
        .form-container{
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;

            form{
                background: rgba(245, 245, 245, 0.737);
                width: 35%;
                height: 60%;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                border-radius: 10px;
                gap: 10px;

                input{
                    width: 80%;
                    padding: 15px 10px;
                    border: none;
                    outline: none;
                    border-radius: 10px;
                }:nth-child(5) {
                    background-color: rgba(19, 207, 19, 0.723);
                    color: white;
                    font-weight: 700;
                    font-size: 16px;
                }
            }

        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="/regdata" method="post">
        <h1>Register Here...!</h1>
        <input type="text" name="username" placeholder="Enter user name">
        <input type="email" name="useremail" placeholder="Enter email">
        <input type="password" name="userpassword" placeholder="Enter password">
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>