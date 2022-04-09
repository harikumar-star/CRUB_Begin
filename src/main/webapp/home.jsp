<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.DbUtil"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.model.User"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<meta charset="ISO-8859-1">
<title>CRUD</title>

</head>
<body>



<%!
// Declaring Variable as Global
List<User> d;
%>



	<%
	

	
	 String msg = (String) request.getAttribute("msg");
if(msg != null)
{
	out.println(msg);
}
else
{
	String o = (String) request.getAttribute("success");
	 d = (ArrayList) request.getAttribute("u");
	
} 
		
	

		
	%>



	<div align="center">

		<h1>User List</h1>
		<br />
		<table border="1">
			<tr style="background-color: lightblue; color: white;">
				<th>Name</th>
				<th>Roll No</th>
				<th>Last Name</th>
				<th>Status</th>
			</tr>
			<%
			String name = "";
			int rollno;
			String lastname = "";
			String status = "Update";
			String status1 = "Delete";

			int u = 0;

			try {
				new UserDao();
				for(User u1 : d)
				{
				String a = u1.getName();
				int b = u1.getRollno();
				String c = u1.getLname();
			%>
			<tr>
				<td><%=a %></td>
				<td><%=b %></td>
<td><%=c %></td>





			<!-- <td><a href="UserController?b=<%=u%> & status=<%=status%>">Update</a> -->
			<td>
			<a href="UserController2?b=<%=b%>&op=<%=status%>">Update</a>
			<a href="UserController2?b=<%=b%>&op=<%=status1%>">Delete</a>
			
				</td>

<a href="index.jsp">Check</a>
			</tr>

			<%
				}

			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</table>
	</div>


















	<br>
	<!-- Add -->
	<h1>Add Users</h1>
	<form action="UserController" method="post">

		<input type="hidden" id="custId" name="op" value="Add">
		<br> 
		<input
			type="text" name="name"> <br>
			<input type="text" name="roll"><br>
		
		<input type="text" name="lname"><br> 
		<input type="submit"
			value="ADD">
	</form>

	<br>

</body>
</html>