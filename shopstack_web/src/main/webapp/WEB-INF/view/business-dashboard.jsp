<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>

	<title>DASHBOARD</title>
	
</head>

<body>
<h4>
<a href="${pageContext.request.contextPath}/">Shopstack</a>
</h4>

	
		<h2>My Business Home</h2>
	
	<p>	
	
		Comming soon...
		<br>
		List of all the shops
	
	</p>
	
	<hr>
		<form:form action="${pageContext.request.contextPath}/biz/form" 
	method="GET">
		
		<input type="submit" value="Add new business">
	</form:form>
		
	<hr>
	

	<form:form action="${pageContext.request.contextPath}/logout" 
		method="POST">
		
		<input type="submit" value="Logout">
		
	</form:form> 
</body>
</html>

