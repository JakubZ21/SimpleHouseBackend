<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QbeePC
  Date: 2020-02-26
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Add Category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
    .error{
        color: red;
    }
    </style>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <div class="row">
        <div class="col">
        <form:form action="saveCategory" modelAttribute="category" method="POST">

            <table>
                <form:hidden path="id"/>
                <tbody>
                <tr>
                    <td><label>Category Name</label></td>
                    <td><form:input path="category"/><form:errors path="category" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        </div>
        <div class="col">
            <table class=" table table-striped" >
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Category</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <c:forEach var="categoryListed" items="${categories}">
                        <tr>
                            <td scope="row">${categoryListed.id}</td><td>${categoryListed.category}</td><td><a class="btn btn-danger" href="${pageContext.request.contextPath}/meals/deleteCategory?id=${categoryListed.id}">Delete</a> <a class="btn btn-info" href="${pageContext.request.contextPath}/meals/renameCategory?id=${categoryListed.id}">Rename</a></td>
                        </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
