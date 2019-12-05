<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Contact App | Add Contact</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<jsp:include page="include/menu.jsp" />

	<!-- Registration Form Start -->
	<div class="container text-center">
		<h3>New Contact</h3>
		<hr>
	
		<!-- ERROR MESSAGE START -->
		<c:if test="${not empty error }">
			<div class="alert alert-danger">
				<c:out value="${error }"></c:out>
			</div>
		</c:if>
		<!-- ERROR MESSAGE END -->
		
		<f:form class="form-horizontal" method="POST" action="/user/save-contact"
			modelAttribute="contactCommand">
			<!-- <f:input type="hidden" name="id" path="contactId" /> -->
			<div class="form-group">
				<label class="control-label col-md-3">Name</label>
				<div class="col-md-7">
					<f:input type="text" class="form-control" name="name"
						path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Phone</label>
				<div class="col-md-7">
					<f:input type="text" class="form-control" name="phone"
						path="phone" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Email</label>
				<div class="col-md-7">
					<f:input type="text" class="form-control" name="email"
						path="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Address </label>
				<div class="col-md-3">
					<f:textarea type="text" class="form-control" name="address"
						path="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Remark </label>
				<div class="col-md-3">
					<f:input type="text" class="form-control" name="remark"
						path="remark" />
				</div>
			</div>
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</f:form>
	</div>
	<!-- Registration Form End -->

	<p align="center" class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>

	<!-- END SECTION -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>

</html>