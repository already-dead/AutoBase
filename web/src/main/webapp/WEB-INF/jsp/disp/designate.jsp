<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Рейсы</title>
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
<h2>Таблица рейсов:</h2>
<table border="2">
<tr><td><b>ID</b></td><td><b>Дата</b></td><td><b>Адрес</b></td><td><b>Водитель</b></td><td><b>Автомобиль</b></td><td><b>Статус рейса</b></td><td><b>Состояние автомобиля</b></td><td><b>Действие</b></td></tr>
<c:forEach var="listElement" items="${requestScope.list}">
<tr><td>${listElement.getFlight_Id()}</td><td>${listElement.getDate()}</td><td>${listElement.getAdress()}</td><td>${listElement.getDriver()}</td><td>${listElement.getCar()}</td>
<c:if test="${listElement.getStatus()==1}"><td><font color="green">Выполнен</font></td></c:if>
<c:if test="${listElement.getStatus()==0}"><td><b>В процессе</b></td></c:if>
<c:if test="${listElement.getStatus()==-1}"><td><font color="red">Отменен</font></td></c:if>
<td>${listElement.getCondition()}</td>
<td>
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="deldesignate"> 
<input type="hidden" name="designateid" value="${listElement.getFlight_Id()}"> 
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit">Удалить</button>
</form>
</td>
</tr>
</c:forEach>
</table>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="adddesignate">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:30px">Добавить рейс</button>
</form>
</div>
</body>
</html>