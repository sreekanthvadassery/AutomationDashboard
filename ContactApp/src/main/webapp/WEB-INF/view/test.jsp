<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta charset="ISO-8859-1">

<s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
<script src="${url_jqlib}"></script>

<script>
	$(document).ready(function(){
		alert('Hi');
	});
</script>


<title>Insert title here</title>
</head>
<body>
	<h1>AJAX Test page</h1>
</body>
</html>