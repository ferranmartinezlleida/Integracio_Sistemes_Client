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
	String idioma = (String) session.getAttribute("idioma");
	
	// Set Attribute
	session.setAttribute("caracteristiques", caracteristiques);
	session.setAttribute("idioma", idioma);
	session.setAttribute("tipoLocal", tipoLocal);
%>

<body>
	<table>
		<tr>
			<td><a href="index.html">Torna al inici</a></td>
		</tr>	
	</table>
	<h1 id="header_est"></h1>
	
	<label id= "tiploc_est"></label> <label id="nameTipoLocal_est"></label>
	<br><br>
	
	<form method="post" action="AddLocalServlet">
			
		<label id="nom_est"></label> <input type="text" name="nomLocal" maxlength="250" />
		
		<br><br>
		 
		<label id="nomCarrer_est"></label> <input type="text" name="nomCarrer" maxlength="50" />
			
		<br><br>
		
		<label id="codiCarrer_est"></label> <input type="number" name="codiCarrer" value=0 /> 

		<br><br>
		
		<label id="nomVia_est"></label>  
		<select name="nomVia">
			<option id="RA_est"  value="RA"></option>
			<option id="AV_est"  value="AV"></option>
			<option id="PL_est"  value="PL"></option>
			<option id="CA_est"  value="CA"></option>
 			<option id="PS_est"  value="PS"></option>
 			<option id="TR_est"  value="TR"></option>				  
		</select>
				
		<br><br>
		
		<label id="numero_est"></label>  <input type="number" name="numero" value=0 /> 
		
		<br><br>
		
		<label id="observacions_est"></label>  <input type="text" name="observacions" maxlength="300" />
		
		<br><br>

		<h3 id= "formAccess_est"></h3>
		
		<div id="formulariAccessibilitat"></div>

		<br>

		<input id = "submit_est" type="submit" name="submit" value="Donar d'alta" />
	</form>
</body>

<script>

	var roadNames = {
		ca: ["Rambla", "Avinguda", "Plaça", "Carrer", "Passeig", "Travesia"],
		es: ["Rambla", "Avenida", "Plaza", "Calle", "Paseo", "Travesía"],
		en: ["Rambla", "Avenue", "Square", "Street", "Promenade", "Crossing"]
	};

	var UIdata ={
			ca: ["Donar d'alta un local", "Donar d'alta", "Cert" , "Fals"],
			es: ["Dar de alta un local", "Dar de alta", "Cierto", "Falso"],
			en: ["Register a local", "Register", "True", "False"]
	};

		
	var localData = {
			ca: ["Tipus local", "Nom local"," Nom carrer"," Codi carrer"," Nom via"," Numero"," Observacions", "Formulari d'accessibilitat"],
			es: ["Tipo local", "Nombre local" ," Nombre calle", "Codigo calle", "Nombre vía", "Número", "Observaciones", "Formulario de accesibilidad"],
			en: ["Local type", "Local name" , "Street name", "Street code"," Road name"," Number"," Observations", "Accessibility form"]
	};

	var localType = {
			ca: ["BARS I RESTAURANTS", "COMERÇOS", "ENTITATS BANCÀRIES" , "FARMÀCIES",  "HOTELS" ,  "LOCALS PÚBLICS"],
			es: ["BARES Y RESTAURANTES", "COMERCIOS", "ENTIDADES BANCARIAS", "FARMACIAS",  "HOTELES", "LOCALES PÚBLICOS" ],
			en: ["BARS AND RESTAURANTS", "COMMERCE",  "BANK"               , "PHARMACY" ,   "HOTELS" ,  "PUBLIC ESTABLISHMENTS"]
	};
	

	function changeLabelLanguage(){
		document.getElementById("header_est").innerHTML = 	UIdata.<%=idioma%>[0];
		document.getElementById("submit_est").value     = 	UIdata.<%=idioma%>[1];

		document.getElementById("RA_est").innerHTML = 		roadNames.<%=idioma%>[0];
		document.getElementById("AV_est").innerHTML = 		roadNames.<%=idioma%>[1];
		document.getElementById("PL_est").innerHTML = 		roadNames.<%=idioma%>[2];
		document.getElementById("CA_est").innerHTML = 		roadNames.<%=idioma%>[3];
		document.getElementById("PS_est").innerHTML = 		roadNames.<%=idioma%>[4];
		document.getElementById("TR_est").innerHTML = 		roadNames.<%=idioma%>[5];
		
		document.getElementById("tiploc_est").innerHTML       =  	localData.<%=idioma%>[0] + ':';
		document.getElementById("nom_est").innerHTML 	      = 	localData.<%=idioma%>[1] + ':';
		document.getElementById("nomCarrer_est").innerHTML    =    	localData.<%=idioma%>[2] + ':';
		document.getElementById("codiCarrer_est").innerHTML   = 	localData.<%=idioma%>[3] + ':';
		document.getElementById("nomVia_est").innerHTML		  = 	localData.<%=idioma%>[4] + ':';
		document.getElementById("numero_est").innerHTML       = 	localData.<%=idioma%>[5] + ':';
		document.getElementById("observacions_est").innerHTML =		localData.<%=idioma%>[6] + ':';
		document.getElementById("formAccess_est").innerHTML   = 	localData.<%=idioma%>[7] + ':';

		document.getElementById("nameTipoLocal_est").innerHTML = localType.<%=idioma%>[<%=tipoLocal-1%>];
	}

	changeLabelLanguage()

	generateNivells();
	generateFormulari();


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
				textnode = document.createTextNode(UIdata.<%=idioma%>[3]);
				option.appendChild(textnode);
				select.appendChild(option);
				
				// option: True
				option = document.createElement("option");
				option.value = "1";
				textnode = document.createTextNode(UIdata.<%=idioma%>[2]);
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
