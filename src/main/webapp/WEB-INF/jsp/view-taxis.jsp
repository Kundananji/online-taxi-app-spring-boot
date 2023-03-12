<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>View Taxis</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>RegNo.</th>
                    <th>Name</th>
                    <th>Driver</th>
                    <th>Location</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${taxis}" var="taxi">
                    <tr>
                        <td>${taxi.registrationNumber}</td>
                        <td>${taxi.name}</td>
                        <td>${taxi.driverName}</td>
                        <td>${taxi.location}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>