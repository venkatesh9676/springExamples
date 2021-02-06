<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Users</title>
</head>
<body>

 
<table border="2" width="70%" cellpadding="2">  
<tr><th>id</th><th>username</th><th>password</th><th>firstname</th><th>lastname</th><th>email</th><th>address</th><th>phone</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="user" items="${users}">   
   <tr>  
   <td>${user.id}</td>
   <td>${user.username}</td>  
   <td>${user.password}</td>  
   <td>${user.firstname}</td>  
   <td>${user.lastname}</td>  
   <td>${user.email}</td>  
   <td>${user.address}</td>  
   <td>${user.phone}</td> 
    
   <td><a href="Update?id=${user.id}">Edit</a></td>  
  <!-- <a href="#" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-edit"></span> Edit
        </a> -->
   <td><a href="delete?id=${user.id}">Delete</a></td>  
   <!-- <a href="delete?id=${user.id}" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-remove"></span> Remove 
        </a> -->
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <!-- <a href="empform">Add New Employee</a> -->
</body>
</html>