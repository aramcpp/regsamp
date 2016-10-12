<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign-in</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
    <%if (session.getAttribute("user") != null){
        response.sendRedirect("userProfile.jsp");
    return;}%>


        <div class="container">
            <form class="sign-form" action="signin" method="post">

                <h1>Sign-in</h1>

                <br />

                <fieldset>
                    <input class="form-control" type="text" name="username" placeholder="Enter username">
                </fieldset>

                <fieldset>
                    <input class="form-control" type="password" name="password" placeholder="Enter password">
                </fieldset>

                <br />

                <fieldset>
                    <input class="btn btn-primary btn-block" type="submit" value="Sign-in">
                </fieldset>
            </form>



        </div>
    </body>
</html>