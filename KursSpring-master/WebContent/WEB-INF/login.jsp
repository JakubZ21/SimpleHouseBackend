<%-- 
    Document   : login
    Created on : 2019-11-18, 16:41:05
    Author     : QbeePC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1250"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
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
                    
                    <form:button type="submit" class="btn btn-success">Login</form:button>
            </form:form>  
        </div>
        
        
    </body>
</html>
