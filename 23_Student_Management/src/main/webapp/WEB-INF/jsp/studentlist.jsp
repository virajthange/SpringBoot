<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/remixicon@4.9.0/fonts/remixicon.css"
      rel="stylesheet"
    />
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      header {
        width: 100%;
        height: 5vh;
        background-color: rgb(27, 27, 93);
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 15px;
      }
      .main-text {
        background-color: rgba(128, 128, 128, 0.316);
        width: 100%;
        height: 10vh;
        display: flex;
        align-items: center;
        justify-content: start;
        padding: 0 30px;
      }
      .hero {
        padding-top: 10vh;
        width: 100%;
        /* min-height: 85vh; */
        display: flex;
        justify-content: center;
      }
      table {
        background-color: whitesmoke;
        /* border-radius: 10px; */
        width: 60%;
        border-collapse: collapse;
        text-align: center;
      }
      table button {
        margin-left: 10px;
        padding: 5px 10px;
        border: none;
        border-radius: 5px;
        background-color: royalblue;
        color: white;
      }
      table .delete-button {
        background-color: red;
      }
      table .edit-button {
        background-color: green;
      }
      table thead {
        background-color: gray;
        color: white;
      }
      table th,
      table td {
        padding: 10px;
        border: 1px solid black;
      }
    </style>
  </head>

  <body>
    <div class="main">
      <header>
        <h1>Student List</h1>
        <div class="icons">
          <i class="ri-mail-line"></i>
          <i class="ri-user-line"></i>
        </div>
      </header>
      <div class="main-text"><a href="dashboard">Home</a> /students</div>

      <div class="hero">
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>email</th>
              <th>Course</th>
            </tr>
          </thead>
          <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>john.doe@example.com</td>
            <td>
              Spring <button class="edit-button">Edit</button>
              <button class="delete-button">Delete</button>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </body>
</html>
