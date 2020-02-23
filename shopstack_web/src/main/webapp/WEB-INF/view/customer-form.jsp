<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>

<title>ShopStack Customer Registration Form</title>

<style >
	.error {color: blue}
</style>

</head>
<body>
	
	
	<form:form action="${pageContext.request.contextPath}/customer/process" modelAttribute="customer" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name: </label></td>
						<td><form:input path="firstName" /></td>					
					</tr>
					<tr>
						<td><label>Last Name: </label></td>
						<td><form:input path="lastName" /></td>					
					</tr>
					<tr>
						<td><label>Phone number : </label></td>
						<td><form:input path="phoneNumber" /></td>					
					</tr>
					<tr>
						<td><label>email: </label></td>
						<td><form:input path="email" /><form:errors path="email" cssClass="error" /></td>					
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>					
					</tr>
					
				</tbody>
			</table>
		
		</form:form>
<%-- 
	<form:form action=" ${pageContext.request.contextPath}/customer/process" modelAttribute="customer" method="GET">
		Customer Name (*): <form:input path="name"/>
		<form:errors path="name" cssClass="error" />
		
		<br><br>
		
		
		Email (*): <form:input path="email"/>
		<form:errors path="email" cssClass="error" />
		
		<br><br>
		
		Organization Name: <form:input path="organizationName"/>
		
		<form:errors path="organizationName" cssClass="error" />
		
		<br><br>
		
		Contact Number (*): <form:input path="contactNumber"/>
		<form:errors path="contactNumber" cssClass="error" />
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form:form>
 --%>		
	
</body>

</html>