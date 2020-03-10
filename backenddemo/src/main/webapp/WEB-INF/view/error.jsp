<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Error</title>
</head>
<html>
<body>

<h2>
    <c:choose>
        <c:when test="${httpStatus != null}">
            ${httpStatus} ${httpCode}
        </c:when>
        <c:otherwise>
            Something Went Wrong
        </c:otherwise>
    </c:choose>
</h2>
<hr>
<p>
    ${message}
</p>
<hr>

<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

</body>

</html>