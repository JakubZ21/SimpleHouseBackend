<%-- 
    Document   : register
    Created on : 2019-11-12, 14:26:11
    Author     : QbeePC
--%>

<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: auto; width: 500px; padding-top: 50px">
            <form:form method="post" modelAttribute="user">
                
                <div class="form-group">
                    <label>User Name</label>
                    <form:input path="userName" placeholder="User Name" type="text" class="form-control"/>
                    <form:errors path="userName" style="color:red" class="form-text text-muted"/>
                </div>
                
                <div class="form-group">
                    <label>Password</label>
                    <form:input path="password" placeholder="Password" type="password" class="form-control"/>
                    <form:errors path="password" style="color:red" class="form-text text-muted" />
                    <br/>
                    <label>Confirm password</label>
                    <form:input path="confirmPassword" placeholder="Confirm Password" type="password" class="form-control"/>
                    <form:errors path="confirmPassword" style="color:red" class="form-text text-muted" />  
                </div>
                
                <div class="form-group">
                    <label>Email</label>
                    <form:input path="email" placeholder="Email" type="text" class="form-control"/>
                    <form:errors path="email" style="color:red" class="form-text text-muted" />
                </div>
                    <form:button type="submit" class="btn btn-success">Register</form:button>
            </form:form>  
        </div>
    </body>
</html>
