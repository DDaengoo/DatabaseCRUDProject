<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="com.example.dbproject.dao.BoardDAO, com.example.dbproject.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Form</title>
	<style>
		/* Add your CSS styles here */
		body {
			font-family: Arial, sans-serif;
			background-color: #f4f4f4;
			margin: 0;
			padding: 20px;
		}

		h1 {
			text-align: center;
		}

		form {
			width: 50%;
			margin: 0 auto;
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}

		table {
			width: 100%;
		}

		table tr td {
			padding: 10px 0;
		}

		input[type="text"],
		textarea {
			width: calc(100% - 20px);
			padding: 8px;
			border-radius: 3px;
			border: 1px solid #ccc;
			margin-bottom: 10px;
		}

		input[type="submit"],
		input[type="button"] {
			padding: 8px 20px;
			border: none;
			border-radius: 3px;
			background-color: #007bff;
			color: #fff;
			cursor: pointer;
		}

		input[type="submit"]:hover,
		input[type="button"]:hover {
			background-color: #0056b3;
		}
	</style>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id = request.getParameter("id");
	BoardVO u = boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post">
	<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
	<table>
		<tr>
			<td>Category:</td>
			<td><input type="text" name="category" value="<%= u.getCategory()%>"/></td>
		</tr>
		<tr>
			<td>Workname:</td>
			<td><input type="text" name="workname" value="<%= u.getWorkname()%>"/></td>
		</tr>
		<tr>
			<td>Workplace:</td>
			<td><input type="text" name="workplace" value="<%= u.getWorkplace()%>" /></td>
		</tr>
		<tr>
			<td>Deadline:</td>
			<td><input type="text" name="deadline" value="<%= u.getDeadline()%>" /></td>
		</tr>
		<tr>
			<td>Note:</td>
			<td><textarea cols="50" rows="5" name="note"><%= u.getNote()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Edit Post"/>
				<input type="button" value="Cancel" onclick="history.back()"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>