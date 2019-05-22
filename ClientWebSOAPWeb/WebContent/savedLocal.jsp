<%@page import="serveiWebSOAP.Local"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="serveiWebSOAP.Formulari"%>
<%@page import="serveiWebSOAP.Caracteristica"%>
<%@page import="serveiWebSOAP.ServeiWeb"%>
<%@page import="serveiWebSOAP.ServeiWebServiceLocator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<a href="index.html">Torna al inici</a>

	<h1 id="status"></h1>
</body>

<script>
	
<%boolean status = (boolean) session.getAttribute("status");%>
	
<%if (status) {%>
	document.getElementById("status").innerHTML = "S'ha guardat correctament";
	document.title = "Local guardat";
<%} else { %>
	document.getElementById("status").innerHTML = "S'ha produït un error";
	document.title = "Error";
<% } %>
	
</script>
</html>