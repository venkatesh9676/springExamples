<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style>
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>

<title>Login</title>
</head>
<body>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<div class="login-form">
			<form action="/examples/actions/confirmation.php" method="post">
				<h2 class="text-center">Log in</h2>
				<div class="form-group">
					
							<form:label path="username">Username: </form:label>
							<form:input path="username" class="form-control"
									placeholder="Username" required="required" id="username" />
						
						</div>
						<div class="form-group">
						
							<form:label path="password">Password:</form:label>
							<form:password path="password" class="form-control"
									placeholder="Password" required="required" id="password" />
						
						</div>
						<div class="form-group">
						
							
							<form:button id="login"
									class="btn btn-primary btn-block">Login</form:button>
					
						</div>
						
						
							<a href="index.jsp">Home</a>
						
						
					<div class="clearfix">
							<label class="pull-left checkbox-inline"><input
								type="checkbox"> Remember me</label> <a href="#"
								class="pull-right">Forgot Password?</a>
						</div>
						</form>
						<p class="text-center">
							<a href="#">Create an Account</a>
						</p>
						
</div>
	</form:form>
</body>
</html>