<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Added</title>
</head>
<body>
	<form action="courseAdded" method="post">
		<table border="2">
			<tr>
				<td>Course Name:</td>
				<td><input type="text" name="course_name"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td colspan="2" align=right><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
</body>
</html>