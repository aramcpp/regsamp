<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-up</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <% String userExists = (String) request.getAttribute("duplicateUsernameException");
        if (userExists != null) {%>
    <h1 style="color: red">User already exists.</h1>
    <%
        }
    %>
    <form class="sign-form" method="post">

        <h1>Sign-up</h1>

        <br/>

        <fieldset>
            <input class="form-control" type="text" name="surName" placeholder="Enter sure name">
        </fieldset>

        <fieldset>
            <input class="form-control" type="text" name="lastName" placeholder="Enter last name">
        </fieldset>

        <fieldset>
            <input class="form-control" type="text" name="age" placeholder="Enter age">
        </fieldset>

        <fieldset>
            <input class="form-control" type="text" name="phone" placeholder="Enter phone">
        </fieldset>

        <fieldset>
            <input class="form-control" type="text" name="userName" placeholder="Enter userName">
        </fieldset>

        <fieldset>
            <input class="form-control" type="password" name="password" placeholder="Enter password">
        </fieldset>

        <br/>

        <fieldset>
            <input class="btn btn-primary btn-block" type="submit" value="Sign-up">
        </fieldset>
    </form>
    <%@ include file="reg.jsp" %>
</div>
</body>
</html>