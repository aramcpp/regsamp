<%@ page import="com.synisys.go.Task.business.model.User" %>
<%@ page import="com.synisys.go.Task.business.model.UserInfo" %>
<%@ page import="com.synisys.go.Task.business.model.impl.UserInfoImpl" %>
<%@ page import="com.synisys.go.Task.business.model.impl.UserImpl" %><%--
  Created by IntelliJ IDEA.
  User: zaven.chilingaryan
  Date: 10/12/2016
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="assets/js/userProfile.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

            <%
                User user = (User) session.getAttribute("user");
                UserInfo userInfo = user.getUserInfo();
            %>

            <h1> Hi  <%=userInfo.getFirstName() + " " + userInfo. getLastName()%></h1>


            <br />

                <a href="signout" >Sign out</a>


                <button class="button-center" onclick="getUserInfo()">Details</button>


        <div id="userInfoDiv">

        </div>



    </div>

</body>
</html>
