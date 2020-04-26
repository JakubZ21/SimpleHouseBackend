<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QbeePC
  Date: 2020-03-05
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <h2>Customers' Messages</h2>
    <hr>
    <div class="row">
        <div class="col">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Message</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <td scope="row">${message.name}</td>
                        <td class="text-wrap">${message.email}</td>
                        <td style="word-wrap: break-word;min-width: 160px;max-width: 160px;">${message.messageText}</td>
                        <td><a class="btn btn-danger"
                               onclick="if(!(confirm('Are you sure you want to delete that meal?'))) return false"
                               href="${pageContext.request.contextPath}/deleteMessage?id=${message.id}">Delete</a>
                            <a class="btn btn-info"
                               href="${pageContext.request.contextPath}/markAsRead?id=${message.id}">Mark as Read</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col">
            <c:choose>
                <c:when test="${param.read==1}">
                    <p><a href="?read=0">Show not read messages</a></p>
                    <p><a href="/seeMessages">Show all messages</a></p>
                </c:when>
                <c:when test="${param.read==0}">
                    <p><a href="?read=1">Show read messages</a></p>
                    <p><a href="/seeMessages">Show all messages</a></p>
                </c:when>
                <c:when test="${param.read==null}">
                    <p><a href="?read=1">Show read messages</a></p>
                    <p><a href="?read=0">Show not read messages</a></p>
                </c:when>
            </c:choose>
            <p><a href="/">Go back to Home</a></p>
        </div>
    </div>
</div>
</body>
</html>
