<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Contact App | Users</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<jsp:include page="include/menu.jsp" />

	<!-- Show All Users form Start -->
	<div class="container text-center" id="tasksDiv">
		<h3>Users</h3>
		<hr>
		<br>

		<!-- Table for listing Users starts -->
		<div class="table-responsive">
			<br>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Sl#</th> 
						<th>UserID</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Address</th>
						<th>LoginName</th>
						<th>Role</th>
						<th>LoginStatus</th>
					</tr>
				</thead>
				<tbody>
					<!-- No Records present message start -->
					<c:if test="${empty userList}">
						<tr>
							<td align="center" colspan="9" class="error">No Records	Present</td>
						</tr>
					</c:if>
					<!-- No Records present message end -->
					<!-- Row Iteration start -->
					<c:forEach var="user" items="${userList}" varStatus="st">
						<tr>
							<td>${st.count}</td>
							<td>${user.userId}</td>
							<td>${user.name}</td>
							<td>${user.phone}</td>
							<td>${user.email}</td>
							<td>${user.address}</td>
							<td>${user.loginName}</td>
							<td>${user.role}</td>
							<td>${user.loginStatus}</td>
						</tr>
					</c:forEach>
					<!-- Row Iteration end -->
				</tbody>
			</table>
		</div>
		<!-- Table for listing Users ends -->
	</div>
	<!-- Show All Users form End -->

	<p align="center" class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>

	<!-- END SECTION -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>

</html>