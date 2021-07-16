<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bank Registration Form</h1>
	<form action="AddUserController" method="post">
		FirstName: <input type="text" name="firstName" /><br>
		LastName:  <input type="text" name="lastName" /><br>
		Email:     <input type="text" name="email" /><br>
		Password:  <input type="text" name="password" /><br>
	</form>
</body>
</html>