<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	

		<br><br>
		List of all the shops
		<br><br>


			<c:forEach var="business" items="${businessList}">
			<tb>
				<c:url var="outletsLink" value="/biz/outlet/list">
					<c:param name="bizId" value="${business.bizId}" />
				</c:url>

				<tr>
					<a href="${outletsLink}">${business.bizName}</a>

				</tr>
			</tb>

			</c:forEach>

	
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

