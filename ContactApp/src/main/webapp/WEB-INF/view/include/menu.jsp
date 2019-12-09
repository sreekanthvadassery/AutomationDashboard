<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout" />

<!-- GUEST MENU START -->
<c:if test="${sessionScope.userId == null}">
<%-- User is not yet logged in: Guest Menu --%>
<s:url var="url_reg_form" value="/reg_form" />
<s:url var="url_login" value="/index" />
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${url_login}">Home</a></li>
				<li><a href="${url_login}">Login</a></li>
				<li><a href="${url_reg_form}">Register</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Help</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>
<!-- GUEST MENU END -->

<!-- ADMIN MENU START -->
<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
<%-- Admin is logged in: Admin Menu --%>
<s:url var="url_ulist" value="/admin/users" />
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="${url_ulist}">User List</a></li>
				<li><a href="${url_logout}">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>
<!-- ADMIN MENU END -->

<!-- USER MENU START -->
<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
<%-- General User is logged in: User Menu --%>
<s:url var="url_uhome" value="/user/dashboard" />
<s:url var="url_cform" value="/user/contact_form" />
<s:url var="url_clist" value="/user/clist" />
<div role="navigation">
	<div class="navbar navbar-inverse">
		<a href="#" class="navbar-brand">ContactApp</a>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${url_uhome}">Home</a></li>
				<li><a href="${url_cform}">Add Contact</a></li>
				<li><a href="${url_clist}">Contact List</a></li>
				<li><a href="${url_logout}">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
</c:if>
<!-- USER MENU END -->