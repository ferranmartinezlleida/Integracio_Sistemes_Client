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
<br><%=mssg_resultat%></br>
</body>
</html>