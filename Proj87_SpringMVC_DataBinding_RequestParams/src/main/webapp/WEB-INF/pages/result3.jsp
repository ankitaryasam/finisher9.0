<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Student Id :   ${sid}
Name :   ${name}

<c:forEach var="course" items="${courses}">
    <p>Courses: ${course}</p>
</c:forEach>