<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Новый автомобиль</title>
</head>
<body>
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="addwritecar">
<input type="hidden" name="id" value="${requestScope.id}">
<table cellspacing="2" border="3"> 
<tr> 
<th align="right">Марка:</th> 
<td align="left"><input type="text" name="brand" required></td> 
</tr> 
<tr> 
<th align="right">Модель:</th> 
<td align="left"><input type="text" name="model" required></td> 
</tr>
<tr> 
<th align="right">Рег. номер:</th> 
<td align="left"><input type="text" name="regNumber" required></td> 
</tr>
<tr> 
<th align="right">Состояние:</th> 
<td align="left"><input type="text" name="condition" pattern="[0-9]{1}" required></td> 
</tr>
<tr>
<td align="center" colspan="2">
<button type="submit" style="width:230px">Добавить автомобиль</button>
</td>
</tr>
</table> 
</form>
</body>
</html>