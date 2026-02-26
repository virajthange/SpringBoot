<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
a{
    padding: 10px 10px;
    color: white;
    font-size: 17px;
    background: green;
    border: none;
    border-radius: 10px;
    text-decoration: none;
}
</style>
<body>
    <div>
        <h1>Welcome to the form handling project</h1>
           <a href="<c:url value='/register' />">
                Click here to register
            </a>
    </div>

</body>
</html>