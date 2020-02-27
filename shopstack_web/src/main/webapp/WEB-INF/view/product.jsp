<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>

<head>

<title>ShopStack business Product add Form</title>

<style >
	.error {color: blue}
</style>

</head>
<body>
  <h2>Add Product</h2>
 


	<form:form action="${pageContext.request.contextPath}/product/process"  modelAttribute="product" method="Post">
		
		Product Name :<br> <form:input path="productName"/>
		<form:errors path="description" cssClass="error" />

		
		<br><br>
		
		  purchase date :<br> <form:input type="date" path="purchaseDate" />
		<form:errors path="purchaseDate" cssClass="error" /> 
		
		<br><br>
		
		Product Category: <br> <form:label path="category"/>
			
			<form:select path ="category">
				<form:option value="Choose one" />
				<form:options items="${categoriesList}" />
			</form:select>
		<form:errors path="category" cssClass="error" />
		
		
		<br><br>
	 	put new button: Add Product
		
			<input type="button" value="Add to category"
				   onclick="window.location.href='category-form'; return false;"
				  
			/>
		<br><br>  
		
		Price :<br> <form:input path="price"/>
		<form:errors path="price" cssClass="error" />
		
		
		<br><br>
		
		
		 Description :<br> <form:input path="description"/>
		<form:errors path="description" cssClass="error" />
		
		
		<br><br>
		
		
		<input type="submit" value="Submit"/>
	
	</form:form>
		
	
</body>

</html>