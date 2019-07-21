<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>List of Masters Jedi</title>
</head>
<body>
List des Maitres Jedi</br>
    <ul>
        <c:forEach items="${listJedis}" var="masterJedi">
            <li> ${masterJedi} </br> </li>
        </c:forEach>
    </ul>

</body>
</html>
