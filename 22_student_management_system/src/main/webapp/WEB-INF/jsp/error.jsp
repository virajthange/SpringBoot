<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .main{
            width: 100%;
            min-height: 100vh;
            background-color: whitesmoke;
            display: flex;
            align-items: center;
            justify-content: center;
            background: linear-gradient(
                      to bottom right,
                      rgb(232, 237, 237),
                      rgb(155, 236, 166)
                    );
        }
        .err-msg{
            padding: 20px 20px;
            background-color: aliceblue;
            width: 40%;
            border-radius: 12px;
            box-shadow: 8px 8px 15px gray;
            text-align: center;
        }

        .err-msg h3{
            font-size: 25px;
            font-weight: 600;
            color: rgba(255, 0, 0, 0.755);
            margin-bottom: 20px;
        }
        .btn{
            position: absolute;
            left: 5vh;
            top: 5vh;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 15px;
            background-color: green;
        }
        .btn a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
    <div class="main">
        <button class="btn"><a href="/dashboard">Home</a></button>
        <div class="err-msg">
            <h3>Oops...! Something went wrong</h3>
            <p>${msg}</p>
        </div>
    </div>
</body>
</html>