<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Автомобили</title>
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
<h2>Таблица автомобилей:</h2>
<table border="2">
<tr><td><b>ID</b></td><td><b>Марка</b></td><td><b>Модель</b></td><td><b>Рег. номер</b></td><td><b>Состояние</b></td><td><b>Действие</b></td></tr>
<c:forEach var="listElement" items="${requestScope.list}">
<tr><td>${listElement.getCar_Id()}</td><td>${listElement.getBrand()}</td><td>${listElement.getModel()}</td><td>${listElement.getRegNumber()}</td> <td>${listElement.getCondition()}</td> 
<td>
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="delcar"> 
<input type="hidden" name="carid" value="${listElement.getCar_Id()}"> 
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit">Удалить</button>
</form>
</td>
</tr>
</c:forEach>
</table>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="addcar">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:30px">Добавить автомобиль</button>
</form>
</div>
</body>
</html>