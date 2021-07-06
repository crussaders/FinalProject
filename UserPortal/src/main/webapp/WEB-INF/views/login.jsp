<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value='/static/style.css'/>" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<section>
		 <header>
        <div class="container">
            <div class="logopart d-flex mr-auto">
                <img src="../static/plogo.png" class="logo" alt="pharmacy logo" width="50px">
                <h5 class="ml-3 text-white font-weight-bold">HealthClub Pharma</h5>
            </div>
        </div>
    	</header>
	   <div class="container-fluid login">
	        <div class="row">
	            <div class="col-12">
	                <div class="loginform">
	                    <h3 class="text-center font-weight-bold text-uppercase">${loginMessage}</h3>
	                    <form:errors path="usercredentials.*" />
	                    <form:form action="/pharmacy/homepage" modelAttribute="usercredentials"
						method="post">
	                        <div class="form-group">
	                            <label for="user">User Id</label>
	                            <input type="text" name="userid" id="userid" class="form-control" placeholder="Enter UserId" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="password">Password</label>
	                            <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password" required>
	                        </div>
	                        <button accesskey="l" type="submit" name="submit" class="btn btn-block"><u>L</u>ogin</button>
	                    </form:form>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>
	<!-- End -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>