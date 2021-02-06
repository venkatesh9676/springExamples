<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
      FirstName:<form:input path="firstName" />
		<br>
		<br>
      LastName:<form:input path="lastName" />
		<br><br>
      Country:
      <form:select path="country">

			<form:options items= "${student.countryOptions }" />

		</form:select>
		<br><br>
		Favorite Language:
		Java<form:radiobutton path="favoriteLanguage" value="java"/>
		C#<form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
		<br><br>
		Operating System
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		MAC Os<form:checkbox path="operatingSystems" value="MAC OS"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		<br><br>
		<input type="submit" value="Submit" />
 
	</form:form>
</body>
</html>