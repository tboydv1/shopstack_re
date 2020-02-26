<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>

<title>ShopStack Customer Registration Form</title>

<style >
	.error {color: blue}
</style>

</head>
<body>


	<form:form action="${pageContext.request.contextPath}/biz/process" modelAttribute="business"  method="GET">
		
		
		Company Name : <form:input path="bizName"/>
		<form:errors path="bizName" cssClass="error" />
		
		<br><br>
		
		
		Company Email : <form:input path="bizEmail"/>
		<form:errors path="bizEmail" cssClass="error" />
		
		<br><br>
		
		Business Category: 
		<form:label path="bizCategory.bizCategoryName"/>
			
			<form:select path ="bizCategory.bizCategoryName">
				<form:option value="Choose one" />
				<form:options items="${categoriesList}" />
			</form:select>
		<form:errors path="bizCategory" cssClass="error" />
		
		<br><br>
		
		Business Service : 
		<form:label path="bizService.bizServiceName"/>
			<form:select path ="bizService.bizServiceName">
				<form:option value="Choose one" />
				<form:options items="${servicesList}" />
			</form:select>
		<form:errors path="bizService" cssClass="error" />
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form:form>
		
	
</body>

</html>