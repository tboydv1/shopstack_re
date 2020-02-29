<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>my customer list</title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<h2>Outlet Lists</h2>
	</div>
</div>
<div id="container">
	<div id="content">
	<!-- add a add business outlet button -->
	<input type="button" value="Add New Outlet" 
		onclick="window.location.href='#'; return false;"
		class="add-button"
		/>
			
			<hr>
			
			<h3>
				List of outlets
			</h3>
				<!-- loop over outlet -->
				<c:forEach var="outlet" items="${outlets}">

					<c:url var="outletHome" value="/biz/out/home">

					</c:url>
					
					<h2>
					 ${outlet.displayName}
					 </h2>

									
				</c:forEach>

	</div>
</div>

</body>
</html>