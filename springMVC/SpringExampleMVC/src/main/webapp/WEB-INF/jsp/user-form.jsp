<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateForm</title>
</head>
<body>
<body>



<FONT color="red">

${loginFailed}

</FONT>

<form:form name="edit" action="rock"  modelAttribute="user">



<h1>update user</h1>

 <table align="center">

 <tr>

  <td>User id:<FONT color="red"><form:errors

  path="id" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="id" /></td>

 </tr>

 <tr>

  <td>User Name:<FONT color="red"><form:errors

  path="username" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="username" /></td>

 </tr>

 <tr>

  <td>Password:<FONT color="red"><form:errors

  path="password" /></FONT></td>

 </tr>

 <tr>

  <td><form:password path="password" /></td>

 </tr>

 <tr>

  <td>First name:<FONT color="red"><form:errors

  path="firstname" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="firstname" /></td>

 </tr>

 <tr>

  <td>Last name:<FONT color="red"><form:errors

  path="lastname" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="lastname" /></td>

 </tr>

 <tr>

  <td>Email:<FONT color="red"><form:errors

  path="email" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="email" /></td>

 </tr>

 <tr>

  <td>address:<FONT color="red"><form:errors

  path="address" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="address" /></td>

 </tr>

 <tr>

  <td>Phone:<FONT color="red"><form:errors

  path="phone" /></FONT></td>

 </tr>

 <tr>

  <td><form:input path="phone" /></td>

 </tr>

 <tr>

  <td><input type="submit" value="Submit" /></td>

 </tr>

 </table>

</form:form>

</body>

</html>
































