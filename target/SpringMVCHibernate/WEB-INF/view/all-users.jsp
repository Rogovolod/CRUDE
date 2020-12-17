<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<body>

<br>
<br>
<br>
<br>

<div align="center">
<table width="30%" border="1" cellpadding="1" bgcolor="#F0F8FF">
    <tr align="center">
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var = "usr" items = "${allUsers}">

        <c:url var = "updateButton" value="/updateInfo">
            <c:param name="userId" value="${usr.id}"/>
        </c:url>

        <c:url var = "deleteButton" value="/deleteUser">
            <c:param name="userId" value="${usr.id}"/>
        </c:url>

        <tr align="center">
            <td>${usr.name}</td>
            <td>${usr.surname}</td>
            <td>${usr.department}</td>
            <td>${usr.salary}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>

<br>

    <input type="button" value="Add"
           onclick="window.location.href = 'addNewUser'"/>

</div>
</body>

</html>