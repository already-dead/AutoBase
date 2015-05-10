<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Меню диспетчера</title>
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
<td align="right">
<b>Текущий диспетчер: ${requestScope.id}</b>
</td>
</tr>
</table>
</div>
<br>
<br>
<div align="center">
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="showdrivers">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Водители</button>
</form>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="showdisp">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Диспетчеры</button>
</form>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="showcars">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Автомобили</button>
</form>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="designate">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Назначить водителя на рейс</button>
</form>
<br>
<form action="/AutoBase/menu/dispatcher/" method="POST"> 
<input type="hidden" name="mode" value="remove">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Отстранить водителя</button>
</form>
</div>
</body>
</html>