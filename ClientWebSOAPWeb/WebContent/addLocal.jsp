<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="serveiWebSOAP.Formulari"%>
<%@page import="serveiWebSOAP.Caracteristica"%>
<%@page import="serveiWebSOAP.ServeiWeb"%>
<%@page import="serveiWebSOAP.ServeiWebServiceLocator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donar d'alta un local</title>
</head>

<%
	int tipoLocal = (int) session.getAttribute("tipoLocal");
	Formulari formulari = (Formulari) session.getAttribute("formulari");
	Caracteristica[] caracteristiques = formulari.getCaracteristiques();
	session.setAttribute("caracteristiques", caracteristiques);
%>


<script>
	
</script>




<body>
	<h1>Donar d'alta un local</h1>
	<p id="nameTipoLocal"></p>

	<form method="post" action="AddLocalServlet">
	
		<input type="hidden" name="tipoLocal" value=<%=tipoLocal%> />
		
		Nom local: <input type="text" name="nomLocal" maxlength="250" />
		
		<br><br>
		 
		Nom carrer: <input type="text" name="nomCarrer" maxlength="50" />
			
		<br><br>
		
		Codi carrer: <input type="number" name="codiCarrer" /> 

		<br><br>
		
		Nom via: <input type="text" name="nomVia" maxlength="2" /> 
		
		<br><br>
		
		Numero: <input type="number" name="numero" /> 
		
		<br><br>
		
		Observacions: <input type="text" name="observacions" maxlength="300" />
		
		<br><br>

		<h3>Formulari d'accessibilitat:</h3>
		
		<div id="formulariAccessibilitat"></div>


		<br>

		<input type="submit" name="submit" value="Donar d'alta" />
	</form>




</body>

<script>
	function getNameTipoLocalFromCodi(codi) {

		var tipusLocal = [ "BARS I RESTAURANTS", "COMERÇOS",
						   "ENTITATS BANCÀRIES", "FARMÀCIES",
						   "HOTELS", "LOCALS PÚBLICS" ];

		return tipusLocal[codi - 1];
	}
	
	document.getElementById("nameTipoLocal").innerHTML = "Tipus de local: "
		+ window.getNameTipoLocalFromCodi(<%=tipoLocal%>);

	
	<% for(Caracteristica ca : caracteristiques) { %>
		// Add NomCaracteristica
		var node = document.createElement("p");
		var textnode = document.createTextNode("<%=ca.getNomCaracteristica()%>");
		node.appendChild(textnode);
		document.getElementById("formulariAccessibilitat").appendChild(node);

		// Add input
		var input = document.createElement("input");

		// type
		var att = document.createAttribute("type");
		att.value = "number";
		input.setAttributeNode(att);

		// name
		att = document.createAttribute("name");
		att.value = "caracteristica_" + "<%=ca.getCodiCaracteristica()%>";
		input.setAttributeNode(att);

		// default value = 0
		var att = document.createAttribute("value");
		att.value = 0;
		input.setAttributeNode(att);

		document.getElementById("formulariAccessibilitat").appendChild(input);

	<% } %>



	
	
</script>

</html>
