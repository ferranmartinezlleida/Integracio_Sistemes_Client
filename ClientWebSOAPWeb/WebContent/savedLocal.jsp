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
<title>Insert title here</title>
</head>
<body>
	<h1 id="status"></h1>
</body>

<script>
	
<%boolean status = (boolean) session.getAttribute("status");%>
	
<%if (status) {%>
	document.getElementById("status").innerHTML = "S'ha guardat correctament";
<%} else { %>
	document.getElementById("status").innerHTML = "S'ha produït un error";
<% } %>
	
</script>
</html>