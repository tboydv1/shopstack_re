<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- /**
 * @author RAY-ABEL
 *
 */ -->

<html>

<head>

<title>ShopStack business Product add Form</title>

<style >
	.error {color: blue}
</style>

</head>
<body>
  <h2>Add Product Category</h2>

	<form:form action=" ${pageContext.request.contextPath}/product/processCategory" modelAttribute="category"  method="Post">
		
		
		Category Name :<br> <form:input path="categoryName"/>
		<form:errors path="categoryName" cssClass="error" />
		
		<br><br>
		
		
		<input type="submit" value="Submit"/>
	
	</form:form>

	
</body>

</html>