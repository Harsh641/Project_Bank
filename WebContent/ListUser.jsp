<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.BankBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<%@include file="Headers.jsp" %>
	<%
		ArrayList<BankBean> users = (ArrayList<BankBean>) request.getAttribute("users");
	%>
	<br>
	<div class="container center_div">
		<div class="row">
			<div class="col-md-6">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<td scope="row">Acc_No</td>
							<td scope="row">FirstName</td>
							<td scope="row">LastName</td>
							<td scope="row">Email</td>
							<td scope="row">Password</td>
						</tr>
					</thead>
					<tbody>
					<%
						for(BankBean bb : users){
					%>
						<tr>
							<td><%=bb.getAcc_no()%></td>
							<td><%=bb.getFirstName()%></td>
							<td><%=bb.getLastName()%></td>
							<td><%=bb.getEmail()%></td>
							<td><%=bb.getPassword()%></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>