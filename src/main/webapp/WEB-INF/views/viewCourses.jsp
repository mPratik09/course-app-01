<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
</head>
<body>

	<table border="2">
		<tr>
			<th>Course Id</th>
			<th>Course</th>
			<th>Description</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${courseList}" var="courses">
			<tr>
				<td>${courses.c_id}</td>
				<td>${courses.course_name}</td>
				<td>${courses.description}</td>
<%-- 			
				<td><a href="courses/${courses.c_id}">Update</a></td>
				<td><a href="courses/${courses.c_id}">Delete</a></td>
--%>
				<td>
					<form
						action="${pageContext.request.contextPath}/courses/${courses.c_id}/update"
						method="post">
						<input type="hidden" name="_method" value="put" />
						<input type="submit" value="Update">
					</form>
				</td>

				<td>
					<form
						action="${pageContext.request.contextPath}/courses/${courses.c_id}/delete"
						method="post">
						<input type="hidden" name="_method" value="delete" />
						<input type="submit" value="Delete"
							onclick="return confirm('Are you sure you want to delete this course?');" />
					</form>
				</td>

			</tr>
		</c:forEach>

	</table>

	<c:if test="${not empty msg}">
		<p style="color: green;">${msg}</p>
	</c:if>
</body>
</html>
