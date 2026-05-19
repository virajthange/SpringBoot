<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      :root {
        --dark-color: #2f311c;
        --light-color: #55593a;
        --medium-color: #4a4d2e;
        --prim-color: #3b3d24;
      }
      body {
        height: 100vh;
        width: 100%;
        background-color: var(--dark-color);
      }
      .dashboard-page {
        width: 100%;
        height: 100%;

      }
      nav {
        width: 100%;
        padding: 10px;
        height: 15vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: var(--medium-color);
        color: white;
      }
      nav h2 {
        font-weight: 700;
      }
      nav ul {
        margin-top: 10px;
        width: 100%;
        display: flex;
        border-radius: 5px;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        background-color: var(--light-color);
      }
      nav ul li {
        text-align: center;
          width: 100%;
        list-style: none;
      }
      nav ul li a {
        width: 100%;
        text-decoration: none;
        color: white;
        font-size: 14px;
      }
      nav ul li:nth-child(1) {
        background-color: var(--prim-color);
        padding: 5px 10px;
        border-radius: 5px;
      }
      .hero {
        width: 100%;
        height: 80vh;
        background-color: var(--prim-color);
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .hero-container {
        background-color: var(--medium-color);
        width: 90%;
        height: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: start;
        gap: 20px;
        padding: 10vh;
      }
      .hero-container input, .hero-container button  {
        width: 100%;
        padding: 8px 10px;
        border-radius: 5px;
        border: none;
        outline: none;
      }
      .hero-container h2 {
        color: white;
      }
      .hero-container button {
        background-color: var(--dark-color);
        color: white;
      }
      .blog {
        width: 100%;
        padding: 8px 10px;
        border: none;
        border-radius: 5px;
        background-color: rgba(245, 245, 245, 0.723);
      }
      footer {
        width: 100%;
        height: 5vh;
        background-color: var(--medium-color);
        color: white;
      }
      footer p {
        height: 5vh;
        align-content: center;
        text-align: center;
      }

      @media screen and (max-width: 600px){
        nav{
            height: 20vh;
        }
        .hero {
            height: 75vh;
        }
        .hero-container {
            padding: 5vh;
        }
      }

    </style>
  </head>
  <body>
    <div class="dashboard-page">
        <nav>
            <h2>Blog Dashboard</h2>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Create new post</a></li>
                <li><a href="#">Profile</a></li>
            </ul>
        </nav>
        <div class="hero">
            <div class="hero-container">
                <h2>Blog posts</h2>
                <input type="text" name="posts" id="posts" placeholder="Search posts...">
                <input type="text" placeholder="sort by date">

                <div class="blog">
                    <h3>Blog title</h3>
                    <p>Author: John Doe | Date: 2024-10-01</p>
                    <p>Excerpt: This is an example excerpt from a blog post</p>
                    <p>Read more...</p>
                </div>
                <button> << prev</button>
                <button>  Next >> </Next></button>
            </div>
        </div>
        <footer>
            <p>@2026 Blog Platform</p>
        </footer>
    </div>
  </body>
</html>
