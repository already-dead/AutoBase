<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ошибка!</title>
</head>
<body>
<div align="center">
<h2>${requestScope.error}</h2>
<form action="${requestScope.link}" method="POST"> 
<input type="hidden" name="id" value="${requestScope.id}">
<button type="submit" style="width:400px;height:30px">Продолжить</button>
</form>
</div>
</body>
</html>