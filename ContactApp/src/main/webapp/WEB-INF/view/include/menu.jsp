<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout" />

<c:if test="${sessionScope.userId == null}">
<%-- User is not yet logged in: Guest Menu --%>
<s:url var="url_reg_form" value="/reg_form" />
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#">Login</a></li>
				<li><a href="${url_reg_form}">Register</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Help</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
<%-- Admin is logged in: Admin Menu --%>
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#">User List</a></li>
				<li><a href="${url_logout}">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
<%-- General User is logged in: User Menu --%>
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#">Add Contact</a></li>
				<li><a href="#">Contact List</a></li>
				<li><a href="${url_logout}">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>