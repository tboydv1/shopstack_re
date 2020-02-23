<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>

	<title>DASHBOARD</title>
	
</head>

<body>
<h4>Shopstack</h4>
	<h2>SHOP MANAGEMENT PAGE</h2>
	
	<hr>
	
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
	
	
		<button><a href="${pageContext.request.contextPath}/customer/form">Add Customer</a></button>
		<button><a href="${pageContext.request.contextPath}/customer/list">List Customer</a></button>
		
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home page</a>
	
	<hr>
		<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">
		
		<input type="submit" value="Logout">
	</form:form> 
</body>
</html>

