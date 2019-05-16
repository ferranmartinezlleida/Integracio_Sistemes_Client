<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Esborra</title>
<%
String mssg_resultat = (String)session.getAttribute("mssg_resultat");
%>

</head>
<body>
	<table>
		<tr>
			<td><a href="index.html">Torna al inici</a></td>
		</tr>	
		<tr>
			<td><%=mssg_resultat%></td>
		</tr>	
	</table>
</body>
</html>