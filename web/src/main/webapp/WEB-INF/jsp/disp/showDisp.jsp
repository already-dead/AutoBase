<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Диспетчеры</title>
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
<h2>Таблица диспетчеров:</h2>
<table border="2">
<tr><td><b>ID</b></td><td><b>Имя</b></td><td><b>Фамилия</b></td><td><b>Действие</b></td></tr>
<c:forEach var="listElement" items="${requestScope.list}">
<tr><td>${listElement.getDisp_Id()}</td><td>${listElement.getName()}</td><td>${listElement.getSurname()}</td>
<td>
<c:if test="${listElement.getDisp_Id()!=requestScope.id}">
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="deldisp"> 
<input type="hidden" name="dispid" value="${listElement.getDisp_Id()}"> 
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit">Удалить</button>
</form>
</c:if>
<c:if test="${listElement.getDisp_Id()==requestScope.id}">
<b>Текущий</b>
</c:if>
</td>
</tr>
</c:forEach>
</table>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="adddisp">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:30px">Добавить диспетчера</button>
</form>
</div>
</body>
</html>