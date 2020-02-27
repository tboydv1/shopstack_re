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

	<h2>SHOP MANAGEMENT PAGE</h2>
	
		
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/customer/list"  method="GET">
	
		<input type= "submit" value ="Manage Customers"/>
	
	</form:form>
	
	<hr>
	
	
	
	<hr>
		<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">
		
		<input type="submit" value="Logout">
	</form:form> 
</body>
</html>

