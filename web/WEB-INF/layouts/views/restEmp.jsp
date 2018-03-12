<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 11/3/18
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css">
</head>
<body>
<div class="spittleView">
    <div class="spittleMessage"><c:out value="${employee.empID}" /></div>
    <div>
        <span class="spittleTime"><c:out value="${employee.name}" /></span>
    </div>
</div>
</body>
</html>