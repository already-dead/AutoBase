<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Новый рейс</title>
</head>
<body>
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="addwritedesignate">
<input type="hidden" name="id" value="${requestScope.id}">
<table cellspacing="2" border="3"> 
<tr> 
<th align="right">Дата рейса:</th> 
<td align="left"><input type="text" name="date" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="ГГГГ-ММ-ДД" required></td> 
</tr> 
<tr> 
<th align="right">Адрес:</th> 
<td align="left"><input type="text" name="adress" required></td> 
</tr>
<tr> 
<th align="right">ID водителя:</th> 
<td align="left"><input list="drivers" type="text" name="driver" pattern="^[2][0-9]{2}" placeholder="2**" required>

<datalist id="drivers">
<c:forEach var="listElement" items="${requestScope.drivers}">
<c:if test="${listElement.getStatus()==1}">
<option value="${listElement.getDriver_Id()}">
</c:if>
</c:forEach>
</datalist>

</td> 
</tr>
<tr> 
<th align="right">ID автомобиля:</th> 
<td align="left"><input list="cars" name="car" pattern="^[1][0-9]{2}" placeholder="1**" required>

<datalist id="cars">
<c:forEach var="listElement" items="${requestScope.cars}">
<option value="${listElement.getCar_Id()}">
</c:forEach>
</datalist>

</td> 
</tr>
<tr>
<td align="center" colspan="2">
<button type="submit" style="width:230px">Добавить рейс</button>
</td>
</tr>
</table> 
</form>

</body>
</html>