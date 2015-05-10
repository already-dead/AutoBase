<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Состояние</title>
</head>
<body>
<form action="/AutoBase/menu/driver/" method="POST">
<input type="hidden" name="mode" value="writeconfirm">
<input type="hidden" name="id" value="${requestScope.id}">
<table cellspacing="2" border="3"> 
<tr> 
<th align="right">ID рейса:</th> 
<td align="left"><input name="flightid" value="${requestScope.flightid}" readonly></td> 
</tr> 
<tr> 
<th align="right">ID водителя:</th> 
<td align="left"><input name="driverid" value="${requestScope.driverid}" readonly></td> 
</tr> 
<tr> 
<th align="right">Состояние автомобиля:</th> 
<td align="left"><input type="text" name="condition" size="20" pattern="[0-9]{1}" required></td> 
</tr> 
<tr>
<td align="center" colspan="2">
<button type="submit" style="width:300px">Отправить данные о рейсе</button>
</td>
</tr>
</table>
</form>
</body>
</html>