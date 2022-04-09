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

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


@SuppressWarnings("unchecked")

User cc = (User) request.getAttribute("u");
System.out.println(cc);
%>
<form action="UserController" method ="post">
<input type="hidden" id="custId" name="op" value="Updatechange">
  <label for="fname">Name:</label><br>
  <input type="text" id="fname" name="name" value="<%=cc.getName() %>"><br>
   <label for="fname">Roll No:</label><br>
  <input type="number" id="fname" name="roll" value="<%=cc.getRollno() %>"><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" value="<%=cc.getLname() %>"><br><br>
  <input type="submit" value="Update">
</form> 

<%

%>
</body>
</html>