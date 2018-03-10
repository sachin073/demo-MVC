<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 24/2/18
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hi from hello

<form name="employee" action="/home/insertEmp" method="post">
    ID:  <input name="ID"/>
    Name : <input name="Name"/>

    <input type="radio" name="gender" value="male" onclick="document.employee.action='/home/insertEmp'" checked> by wired object<br>
    <input type="radio" name="gender" value="female" onclick="document.employee.action='/home/insertEmpUnwire'" > by @configurable <br>

<input type="submit" name="register" value="register me!">
</form>

</body>
</html>
