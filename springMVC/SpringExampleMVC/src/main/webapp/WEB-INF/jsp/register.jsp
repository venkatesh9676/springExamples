<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style>
	body {
		color: #fff;
		background: #63738a;
		font-family: 'Roboto', sans-serif;
	}
    .form-control{
		height: 40px;
		box-shadow: none;
		color: #969fa4;
	}
	.form-control:focus{
		border-color: #5cb85c;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 400px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .btn{        
        font-size: 16px;
        font-weight: bold;		
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}    	
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
    .signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #5cb85c;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}  
</style>

</head>
<body>
<div class="signup-form">
<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<h2>Register</h2>
<p class="hint-text">Create your account. It's free and only takes a minute.</p>
<div class="form-group">
			<div class="row">
			
		     <div class="col-xs-6">
				<form:label path="username">Username</form:label>
				<form:input path="username" class="form-control" name="username" placeholder="User Name" required="required" id="username" />
			</div>
			
			  <div class="col-xs-6">
				<form:label path="password">Password</form:label>
				<form:password path="password" class="form-control" name="password"  placeholder="password" required="required" id="password" />
			</div>
			
			<div class="col-xs-6">
				<form:label path="firstname">FirstName</form:label>
				<form:input path="firstname" class="form-control" name="firstname" placeholder="first Name" required="required" id="firstname" />
						</div>
			
			<div class="col-xs-6">
				<form:label path="lastname">LastName</form:label>
				<form:input path="lastname" class="form-control" name="lastname" placeholder="last Name" required="required" id="lastname" />
			</div>
			
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" class="form-control" name="email" placeholder="Email" required="required" id="email" />
			</div>
			
			<div class="form-group">
				<form:label path="address">Address</form:label>
				<form:input path="address" class="form-control" name="address" placeholder="Address" required="required" id="address" />
			</div>
			
			<div class="form-group">
				<form:label path="phone">Phone</form:label>
				<form:input path="phone" class="form-control" name="phone" placeholder="Phone" required="required" id="phone" />
			</div>
			
			<div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		    </div>
           
           <div class="form-group">
		       <form:button id="register" class="btn btn-success btn-lg btn-block" name="register">Register Now</form:button>
		       </div>
			
				
	<div class="text-center">Already have an account? <a href="#">Sign in</a></div>
</div>
				<a href="index.jsp">Home</a>
			
		
	</form:form>
	
</body>
</html>