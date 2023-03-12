<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Taxi</title>
    </head>
    <body>
        <c:if test="${addTaxiSuccess}">
            <div>Successfully added Taxi with Reg Number: ${savedTaxi.registrationNumber}</div>
        </c:if>
    
        <c:url var="add_taxi_url" value="/taxi/addTaxi"/>
        <form:form action="${add_taxi_url}" method="post" modelAttribute="taxi">
            <form:label path="registrationNumber">RegNo: </form:label> <form:input type="text" path="registrationNumber"/>
            <form:label path="name">Taxi Name: </form:label> <form:input type="text" path="name"/>
            <form:label path="driverName">Driver Name: </form:label> <form:input path="driverName"/>
             <form:label path="location">Location: </form:label> <form:input path="location"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>