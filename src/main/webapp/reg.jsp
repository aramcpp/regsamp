<%--
  Created by IntelliJ IDEA.
  User: arthur.panosyan
  Date: 10/11/2016
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (request.getMethod().equals("POST")) { %>
<jsp:useBean id="userInfo" class="com.synisys.go.Task.business.model.impl.UserInfoImpl" scope="request">
    <jsp:setProperty name="userInfo" property="firstName" param="surName"/>
    <jsp:setProperty name="userInfo" property="lastName" param="lastName"/>
    <jsp:setProperty name="userInfo" property="age" param="age"/>
    <jsp:setProperty name="userInfo" property="phone" param="phone"/>
    <jsp:setProperty name="userInfo" property="id" value="-1"/>
</jsp:useBean>

<jsp:useBean id="user" class="com.synisys.go.Task.business.model.impl.UserImpl" scope="request">
    <jsp:setProperty name="user" property="userName" param="userName"/>
    <jsp:setProperty name="user" property="password" param="password"/>
    <jsp:setProperty name="user" property="userInfo" value="${userInfo}"/>
    <jsp:setProperty name="user" property="id" value="-1"/>
</jsp:useBean>

<%
    session.setAttribute("user", user);
%>

<jsp:forward page="/signUpServlet" />

<%
    }
%>

