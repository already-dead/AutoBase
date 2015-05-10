<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Новый диспетчер</title>
</head>
<body>
<form action="/AutoBase/menu/dispatcher/" method="POST">
<input type="hidden" name="mode" value="addwritedisp">
<input type="hidden" name="id" value="${requestScope.id}">
<table cellspacing="2" border="3"> 
<tr> 
<th align="right">Имя:</th> 
<td align="left"><input type="text" name="name" required></td> 
</tr> 
<tr> 
<th align="right">Фамилия:</th> 
<td align="left"><input type="text" name="surname" required></td> 
</tr>
<tr>
<td align="center" colspan="2">
<button type="submit" style="width:230px">Добавить диспетчера</button>
</td>
</tr>
</table> 
</form>
</body>
</html>