<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Product </title>

</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>CPM - Customer Product Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Product Name</th>
					<th>Purchase date</th>
					<th>Category name</th>
					<th>Price</th>
					<th>Description</th>
					<th>Action</th>
		
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${product}">
			
					<c:url var="deleteLink" value="/product/delete">
					</c:url>
					<c:url var="addProduct" value="/product/form">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					<tr>
						<td> ${tempProduct.productName} </td>
						<td> ${tempProduct.purchaseDate} </td>
						<td> ${tempProduct.category.categoryName} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.description} </td>
						<td>
							<a href="${addProduct }">AddProduct</a>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
</body>
</html>