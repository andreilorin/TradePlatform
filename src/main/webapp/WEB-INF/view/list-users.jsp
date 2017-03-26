<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>HI</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Users</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input id="addButton" type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="user" items="${users}">

					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>

						<td>
							<c:url var="updateLink" value="/user/showFormForUpdate">
								<c:param name="id" value="${user.id}" />
						</c:url>

						<a href="${updateLink}">Update</a>
						
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>