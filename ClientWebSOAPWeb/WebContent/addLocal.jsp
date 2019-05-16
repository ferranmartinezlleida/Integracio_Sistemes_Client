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
	// Get Attribute
	int tipoLocal = (int) session.getAttribute("tipoLocal");
	Formulari formulari = (Formulari) session.getAttribute("formulari");
	String[] nivells = (String[]) session.getAttribute("nivells");
	Caracteristica[] caracteristiques = formulari.getCaracteristiques();
	
	// Set Attribute
	session.setAttribute("caracteristiques", caracteristiques);
	session.setAttribute("idioma", session.getAttribute("idioma"));
	session.setAttribute("tipoLocal", tipoLocal);
%>

<body>
	<h1>Donar d'alta un local</h1>
	<p id="nameTipoLocal"></p>

	<form method="post" action="AddLocalServlet">
			
		Nom local: <input type="text" name="nomLocal" maxlength="250" />
		
		<br><br>
		 
		Nom carrer: <input type="text" name="nomCarrer" maxlength="50" />
			
		<br><br>
		
		Codi carrer: <input type="number" name="codiCarrer" value=0 /> 

		<br><br>
		
		Nom via: <select name="nomVia">
				  <option value="RA">Rambla</option>
				  <option value="AV">Avinguda</option>
				  <option value="PL">Plaça</option>
  				  <option value="CA">Carrer</option>
  				  <option value="PS">Passeig</option>
  				  <option value="TR">Travesia</option>				  
				</select>
				
		<br><br>
		
		Numero: <input type="number" name="numero" value=0 /> 
		
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

	document.getElementById("nameTipoLocal").innerHTML = 
		"Tipus de local: " + window.getNameTipoLocalFromCodi(<%=tipoLocal%>);

	generateNivells();
	generateFormulari();


	function getNameTipoLocalFromCodi(codi) {

		var tipusLocal = [ "BARS I RESTAURANTS", "COMERÇOS",
						   "ENTITATS BANCÀRIES", "FARMÀCIES",
						   "HOTELS", "LOCALS PÚBLICS" ];

		return tipusLocal[codi - 1];
	}

	function generateNivells(){
		<% for(int i = 0; i < nivells.length ; i++){ %>
			
			var div = document.createElement("div");
			var att = document.createAttribute("id");
			att.value =  "nivell_" + (<%=i%>+1);
			div.setAttributeNode(att);

			var node = document.createElement("h4");
			var textnode = document.createTextNode("<%= nivells[i] %>");
			node.appendChild(textnode);
			div.appendChild(node);
			
			document.getElementById("formulariAccessibilitat").appendChild(div);
	
		<% } %>
	}

	function generateFormulari(){
		
		<% for(Caracteristica ca : caracteristiques) { %>
		
			// Add NomCaracteristica
			var node = document.createElement("p");
			var textnode = document.createTextNode("<%= ca.getNomCaracteristica() %>");
			node.appendChild(textnode);
			document.getElementById("nivell_" + <%=ca.getNivell()%>).appendChild(node);
	
			// Add select
			var select = document.createElement("select");

			// select name
			var att = document.createAttribute("name");
			att.value = "<%= "caracteristica_" + ca.getCodiCaracteristica()%>";
			select.setAttributeNode(att);

			// options for the select
			var option;
			
			<% if (ca.getTipo() == 1) { %>

				// option:  False
				option = document.createElement("option");
				option.value = "0";
				textnode = document.createTextNode("Fals");
				option.appendChild(textnode);
				select.appendChild(option);
				
				// option: True
				option = document.createElement("option");
				option.value = "1";
				textnode = document.createTextNode("Cert");
				option.appendChild(textnode);
				select.appendChild(option);
				
			<% } else if (ca.getTipo() == 2){ %>
			
				// option: 1..5
				for(var i = 1; i < 6; i ++){
					option = document.createElement("option");
					option.value = i;
					textnode = document.createTextNode(i);
					option.appendChild(textnode);
					select.appendChild(option);
				}
		
			<% } %>
	
			document.getElementById( "nivell_" + <%=ca.getNivell()%>).appendChild(select);
	
		<% } %>
	}
	
</script>

</html>
