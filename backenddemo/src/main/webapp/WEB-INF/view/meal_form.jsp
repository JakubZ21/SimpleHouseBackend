<%--
  Created by IntelliJ IDEA.
  User: QbeePC
  Date: 2020-02-14
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Adding New Meal</title>
</head>
<body>
<h1>Add New Meal</h1>
<form:form action="saveMeal" modelAttribute="meal" method="POST">

    <!--  need to associate this data with customer id -->
    <table>
        <form:hidden path="mealId"/>
        <tbody>
        <tr>
            <td><label>Meal:</label></td>
            <td><form:input path="mealName"/> </td>
        </tr>
        <tr>
            <td><label>Price:</label></td>
            <td><form:input path="mealPrice"/> </td>
        </tr>
        <tr>
            <td><label>Category:</label></td>
            <td><form:select path="category.id">
                <c:forEach var="item" items="${categories}">
                <form:option value="${item.id}">${item.category}</form:option>
                </c:forEach>

            </form:select></td>


        </tr>
        <tr>
            <td><label>Description:</label></td>
            <td><form:input path="mealDesc"/> </td>
        </tr>
        <tr>
            <td><label>Image(250x250):</label></td>
            <td><form:input path="imgUrl" /> </td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"/></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
