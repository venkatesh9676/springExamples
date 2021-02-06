<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Confiramation form</title>
</head>
<body>

The Customer is Confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
The Free Passes: ${customer.freePasses}
<br><br>
The Postal Code: ${customer.postalCode}
<br><br>
The Course Code: ${customer.courseCode}
</body>
</html>