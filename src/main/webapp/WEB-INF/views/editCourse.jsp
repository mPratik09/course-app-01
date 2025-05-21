<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/saveUpdatedCourse"
		method="post">
		<table border="2">
			<tr>
				<td>Course Id:</td>
				<td><input type="text" name="c_id" value="${course.c_id}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>Course Name:</td>
				<td><input type="text" name="course_name"
					value="${course.course_name}"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"
					value="${course.description}"></td>
			</tr>
			<tr>
				<td colspan="2" align=right><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>

</body>

</body>
</html>