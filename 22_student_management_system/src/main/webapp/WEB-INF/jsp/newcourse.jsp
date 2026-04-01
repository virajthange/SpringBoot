<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Course</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .main{
            width: 100%;
            min-height: 100vh;
            background-color: rgba(135, 207, 235, 0.425);
        }

        .icons a{
            text-decoration: none;
            color: white;
        }
       .hero{
                   width: 100%;
                   min-height: 100vh;
                   display: flex;
                   justify-content: center;
                   align-items: center;
               background: linear-gradient(to bottom right, rgb(232, 237, 237) , rgb(155, 236, 166) );

               }
         .hero form{
                    width: 35%;
                    /* background-color: whitesmoke; */
                background: linear-gradient(to bottom right, rgb(144, 228, 133) , rgb(117, 163, 123) );
                box-shadow: 7px 7px 20px gray;

                    padding: 60px 50px;
                    border-radius: 10px;
                }
        form label{
            font-size: 18px;
        }
        .btn{
            display:flex;
            justify-content: center;
        }
        form input{
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 20px;
            border: none;
            border-radius: 5px;
            background-color: rgba(243, 249, 243, 0.652);
        }

        form button{
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: green;
            color: white;
                        font-weight: 600;

        }
         .back{
                    position: absolute;
                    top: 20px;
                    left: 20px;
                    background-color: green;
                    padding: 6px 15px;
                    border-radius: 15px;
                }
                .back a{
                    text-decoration: none;
                    color: white;
                }
         form h2{
            text-align: center;
            margin-bottom: 40px;
         }
    </style>
</head>
<body>
    <div class="main">
        <div class="back"> <a href="/dashboard"> Back </a> </div>
        <div class="hero">
            <form action="#" method="post">
                <h2>Add New Course</h2>
                <label for="courseName">Course Name:</label><br>
                <input type="text" id="courseName" name="name"><br><br>
                <label for="duration">Duration:</label><br>
                <input type="text" id="duration" name="duration" placeholder="e.g, 3 months"><br><br>
                <div class="btn">
                    <button type="submit">Save Course</button>
                </div>
            </form>
    </div>
</body>
</html>