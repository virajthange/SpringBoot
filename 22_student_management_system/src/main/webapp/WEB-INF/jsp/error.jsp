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
        }
        .err-msg{
            padding: 10px 20px;
            background-color: aliceblue;
            width: 40%;

        }
        .err-msg h3{
            font-size: 25px;
            font-weight: 600;
            color: rgba(255, 0, 0, 0.755);
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="main">
        <div class="err-msg">
            <h3>Error occured</h3>
                Error occured...
            <p></p>

        </div>
    </div>
</body>
</html>