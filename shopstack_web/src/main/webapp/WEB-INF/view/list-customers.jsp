<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>my customer list</title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<h2>CRM - customer relationship manager</h2>
	</div>
</div>
<div id="container">
	<div id="content">
	<!-- add a add customer button -->
	<input type="button" value="Add Customer" 
		onclick="window.location.href='form'; return false;"
		class="add-button"
		/>
	
	
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>email</th>
				<th>Action</th>
			</tr>
			
				<!-- loop over customer -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}" >Update</a>
						 </td>
					</tr>
									
				</c:forEach>
		</table>
	</div>
</div>

</body>
</html>