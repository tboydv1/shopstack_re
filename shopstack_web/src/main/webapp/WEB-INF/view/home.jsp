<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<body>

<h4>Shopstack</h4>

	<h1>Home Page</h1>
	
	<h2>Welcome To Shopstack</h2>

	
	<form:form action="${pageContext.request.contextPath}/user/register" 
			method="GET">
		
		<input type="submit" value="Create Account">
		
	</form:form>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/login" 
			method="GET">
		
		<input type="submit" value="Sign in">
	</form:form>
	<hr>
	
</body>

</html>