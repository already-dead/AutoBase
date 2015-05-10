<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Меню водителя</title>
</head>
<body>
<div align="center">
<table width="1100">
<tr>
<td align="left">
<form action="/AutoBase/menu/driver/" method="POST"> 
<input type="hidden" name="id" value="0">
<button type="submit">Выход</button>
</form>
</td>
<td align="right">
<b>Текущий водитель: ${requestScope.id}</b>
</td>
</tr>
</table>
</div>
<br>
<br>
<div align="center">
<form action="/AutoBase/menu/driver/" method="POST"> 
<input type="hidden" name="mode" value="editdesignate">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Посмотреть мои рейсы</button>
</form>
<br>
<form action="/AutoBase/menu/driver/" method="POST"> 
<input type="hidden" name="mode" value="repair">
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:300px;height:50px">Заявка на ремонт</button>
</form>
</div>
</body>
</html>