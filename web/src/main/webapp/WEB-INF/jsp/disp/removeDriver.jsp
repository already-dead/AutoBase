<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Отстранение водителя</title>
</head>
<body>
<div align="center">
<table width="1100">
<tr>
<td align="left">
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="id" value="0">
<button type="submit">Выход</button>
</form>
</td>
<td align="left">
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit">На главную</button>
</form>
</td>
<td align="right">
<b>Текущий диспетчер: ${requestScope.id}</b>
</td>
</tr>
</table>
</div>
<br><br><br>
<div align="center">
<h2>Таблица водителей:</h2>
<table border="2">
<tr><td><b>ID</b></td><td><b>Имя</b></td><td><b>Фамилия</b></td><td><b>Текущий статус</b></td><td><b>Возможное действие</b></td></tr>
<c:forEach var="listElement" items="${requestScope.list}">
<tr><td>${listElement.getDriver_Id()}</td><td>${listElement.getName()}</td><td>${listElement.getSurname()}</td> 
<c:if test="${listElement.getStatus()==1}"> <td>Активный</td> <td> 
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="removewrite">
<input type="hidden" name="id" value="${requestScope.id}">
<input type="hidden" name="driverid" value="${listElement.getDriver_Id()}">
<button type="submit">Отстранить водителя</button>
</form>
</td></c:if>
<c:if test="${listElement.getStatus()==0}"> <td>Отстранен</td> <td> 
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="removewrite">
<input type="hidden" name="id" value="${requestScope.id}">
<input type="hidden" name="driverid" value="${listElement.getDriver_Id()}">
<button type="submit">Восстановить водителя</button>
</form>
</td></c:if>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>