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
    <style>.error {
        color: red;
        font-weight: bold
    }</style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 50px">
    <h2>Add New Meal</h2>
    <hr>
    <div class="row">
        <div class="col">
            <form:form action="saveMeal" modelAttribute="meal" method="POST" enctype="multipart/form-data">
                <table>
                    <form:hidden path="mealId"/>
                    <tbody>
                    <tr class="form-group">
                        <td><label>Meal:</label></td>
                        <td><form:input path="mealName" cssClass="form-control"/><form:errors path="mealName"
                                                                                              cssClass="error"/></td>
                    </tr>
                    <tr class="form-group">
                        <td><label>Price:</label></td>
                        <td><form:input path="mealPrice" cssClass="form-control"/><form:errors path="mealPrice"
                                                                                               cssClass="error"/></td>
                    </tr>
                    <tr class="form-group">
                        <td><label>Category:</label></td>
                        <td>
                            <form:select cssClass="form-control" path="category.id">
                                <c:forEach var="item" items="${categories}">
                                    <form:option value="${item.id}">${item.category}</form:option>
                                </c:forEach>
                            </form:select>
                        </td>
                        <form:errors path="category" cssClass="error"/>

                    </tr>
                    <tr class="form-group">
                        <td><label>Description:</label></td>
                        <td><form:textarea rows="5" path="mealDesc" cssClass="form-control"/><form:errors
                                path="mealDesc" cssClass="error"/></td>
                    </tr>
                    <tr class="form-group">
                        <td><label>Image(250x250):</label></td>
                        <td><input class="form-control-file" type="file" name="file"
                                   accept="image/png, image/jpeg"><form:errors path="img" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save" class="btn btn-primary"/></td>
                    </tr>
                    </tbody>
                    <form:hidden path="img"/>
                    <c:choose>
                        <c:when test="${meal.encoded64!=null || meal.encoded64!=defImage}"><input type="hidden"
                                                                                                  name="hasImage"
                                                                                                  value="1"></c:when>
                        <c:otherwise><input type="hidden" name="hasImage" value="0"></c:otherwise>
                    </c:choose>
                </table>
            </form:form>
        </div>
        <div class="col">
            <c:if test="${meal.encoded64!=null}">
                <img style="border: 5px solid grey; padding: 5px" src="data:image/jpg;base64,${meal.encoded64}"
                     alt="Image"/>
                <p>This is current image</p>
            </c:if>
        </div>

    </div>
</div>
</body>
</html>
