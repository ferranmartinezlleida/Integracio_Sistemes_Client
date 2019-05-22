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
<%
Local local = (Local)session.getAttribute("Local");
String action = (String)session.getAttribute("action");
String nomVia = local.getNomVia();
String nomCarrer = local.getNomCarrer();
int numero = local.getNumero();
String nomLocal = local.getNomLocal();
String tipus_busqueda = (String)session.getAttribute("tipus_busqueda");
Formulari form = local.getForm();
Caracteristica[] caracteristiques = form.getCaracteristiques();
String[] nivells = (String[]) session.getAttribute("nivells");


String senseDades = "Sense Dades";
boolean localTrobat = true;

if(local.getNomLocal().equals("buit")){
	String idioma = (String) session.getAttribute("idioma");
	localTrobat = false;
	local.setNomLocal(senseDades);
	local.setCodiTipoLocal(7);
	form.setIdioma(idioma);
}

%>
<script>


var formulariIdioma = {
		ca:["Cert/fals","Cert","Fals","Rang: 1..5","Sense Dades"],
		es:["Cierto/Falso","Cierto","Falso","Rango: 1..5","Sin Datos"],
		en:["True/False","True","False","Range: 1..5","No Data"]

		};

var localData = {
		ca:["Nom","Tipus Local","Adreça","Observacions","Dades de l'establiment","Formulari d'accessibilitat"],
		es:["Nombre","Tipo Local","Dirección","Observaciones","Datos del establecimiento","Formulario de accessibilidad"],
		en:["Name","Local Type","Adress","Observations","Establishment data","Accessibility Form"]

		};


function createTablesNivell(){
	
	<% for(int i = 0; i < nivells.length ; i++){ %>
	
	var table = document.createElement("table");
	var att = document.createAttribute("id");
	att.value =  "nivell_" + (<%=i%>+1);
	table.setAttributeNode(att);

	var row = table.insertRow(0);

	var cell1 = row.insertCell(0)
	var cell2 = row.insertCell(1)
	var cell3 = row.insertCell(2)
	

	cell1.innerHTML = "<%= nivells[i] %>".bold();
	
	document.getElementById("accessibilitat").appendChild(table);

<% } %>

}

function setValuesInputDireccio(){

	if(<%=localTrobat%>){
		document.getElementById("direccio").value = "<%=local.getNomVia()%> <%=local.getNomCarrer()%>, <%=local.getNumero()%>";
		document.getElementById("observacions").value = formulariIdioma.<%=form.getIdioma()%>[4];
	}else{
		document.getElementById("nomLocal").value = formulariIdioma.<%=form.getIdioma()%>[4];
		document.getElementById("tipusLocal").value = formulariIdioma.<%=form.getIdioma()%>[4];
		document.getElementById("direccio").value = formulariIdioma.<%=form.getIdioma()%>[4];
		document.getElementById("observacions").value = formulariIdioma.<%=form.getIdioma()%>[4];
		
	}
	
}



function getNameTipoLocalFromCodi(codi){

	var tipusLocal = ["BARS I RESTAURANTS","COMERÇOS","ENTITATS BANCÀRIES","FARMÀCIES","HOTELS","LOCALS PÚBLICS","Sense Dades"];

	return tipusLocal[(parseInt(codi)-1)];
}

function checkIfNull(obs){

	var observacions = "Sense Dades";

	if(obs != null){
		observacions = obs;
	}

	return observacions;
}

function appendCaracteristicatoTable(tableName,nomCarac,valueCarac,tipoCarac){
	var row = document.getElementById(tableName).insertRow(document.getElementById(tableName).rows.length);
	var cell1 = row.insertCell(0)
	
	var tipus = "";
	var value = valueCarac;
	if(tipoCarac == "1"){
		tipus = formulariIdioma.<%=form.getIdioma()%>[0];
		if(valueCarac == "0"){
			value=formulariIdioma.<%=form.getIdioma()%>[2];
		}else if(valueCarac =="1" ){
			value=formulariIdioma.<%=form.getIdioma()%>[1];
		}
	}else if (tipoCarac == "2"){
		tipus = formulariIdioma.<%=form.getIdioma()%>[3];
	}else if(tipoCarac ==""){
		tipus = formulariIdioma.<%=form.getIdioma()%>[4];
		value = "";
	}
	nomCarac = nomCarac.toLowerCase();
	nomCarac = nomCarac.charAt(0).toUpperCase() + nomCarac.slice(1);
	
	cell1.innerHTML= " - " + nomCarac;

	var row = document.getElementById(tableName).insertRow(document.getElementById(tableName).rows.length);
	var cell0 = row.insertCell(0)
	cell0.innerHTML = tipus + " -> " + value;

	
}


function putCaracteristiquesinPlace(){

	if(<%=localTrobat%>){
	<% for(Caracteristica ca : caracteristiques) { %>

		appendCaracteristicatoTable("nivell_" + <%=ca.getNivell()%>,"<%=ca.getNomCaracteristica()%>","<%=ca.getValor()%>","<%=ca.getTipo()%>");

	<% } %>
	}
}


function defineLabelButtonbyAction(){
	if(<%=localTrobat%>){
		var button = "";
		var action = "";
		var action = "<%=action%>";
		if(action == "B"){
	
			button="Dona de Baixa";
			action="Esborra";
			document.frm.action ="Delete";
		}else if(action == "V"){
			button="Validar";
			action="Valida";
			document.frm.action ="verify_servlet";
		}else if(action == "C"){
			document.getElementById('taula_accions').style.display = 'none';
			document.getElementById('boto').style.display = 'none';
			document.getElementById('boto_label').style.display = 'none';
			
	
		}
		document.getElementById('adress').href = "adress.html?action="+"<%=action%>";
		document.getElementById('boto').innerHTML=button;
		document.getElementById('boto_label').innerHTML=action;
	}else{
		document.getElementById('boto').style.display="none"

	}
	
}

function letSearchByAdressDependingOnTipusBusqueda(){

	var tipus_busqueda = "<%=tipus_busqueda%>";

	if(tipus_busqueda == "adress"){

		document.getElementById("alternative_search").style.display="none";
	}


	
}

function changeLabelLanguage(){

	document.getElementById("nom_est").innerHTML= localData.<%=form.getIdioma()%>[0];
	document.getElementById("tiploc_est").innerHTML= localData.<%=form.getIdioma()%>[1];
	document.getElementById("add_est").innerHTML= localData.<%=form.getIdioma()%>[2];
	document.getElementById("obs_est").innerHTML= localData.<%=form.getIdioma()%>[3];
	document.getElementById("dadesEst").innerHTML= localData.<%=form.getIdioma()%>[4];
	document.getElementById("formEst").innerHTML= localData.<%=form.getIdioma()%>[5];
	
}




</script>

<head>
<meta charset="UTF-8">
<title>Local</title>
</head>
<body>
<input type="hidden" id="action" name="action" value="<%=action%>"/>
	<table>
		<tr>
			<td><a href="index.html">Torna al inici</a></td>
		</tr>	
	</table>

	<table id="alternative_search">
		<tr>
			<td>No és el local que busques?</td>
			<td></td>
		</tr>
		<tr>
			<td>Prova una cerca més concreta</td>
			<td><a id="adress" name="adress"  href="">Busca per adreça</a></td>
		</tr>
	</table>
	<table>
	<tr>
		<td><h1 id="dadesEst"></h1></td>
		<td></td>
	</tr>
	<tr>
		<td id="nom_est"/>
		<td><input type="text" name="nomLocal" readonly="readonly" id="nomLocal" value="<%=local.getNomLocal()%>" style="width:200px"/></td>
	</tr>
	<tr>
		<td id="tiploc_est"/>
		<td><input type="text" name="tipusLocal" readonly="readonly" id="tipusLocal" value="" style="width:200px"/></td>
	</tr>
	<tr>
		<td id="add_est"/>
		<td><input type="text" name="direccio" readonly="readonly" id="direccio" style="width:200px"/></td>
	</tr>
	<tr>
		<td id="obs_est"/>
		<td><input type="text" name="observacions" readonly="readonly" id="observacions" value="" style="width:200px"/></td>
	</tr>
</table>
<table>
	<tr>
		<td><h1 id="formEst"><h1></td>
		<td></td>
	</tr>
</table>
<table id="accessibilitat">
</table>
<form method="get" id="frm" name="frm" action="">

<input type="hidden" id="pk" name="pk" value="<%=local.getCodiLocal()%>"/>
<table id="taula_accions">
	<tr>
		<td><h1 id="boto_label"></h1></td>
	</tr>
	<tr>
		<td><button id="boto" name="boto" onclick="document.frm.submit();" value=""> </button></td>
	</tr>
</table>

</form>

	
</table>

</body>
<script>
	document.getElementById("tipusLocal").value = getNameTipoLocalFromCodi(<%=local.getCodiTipoLocal()%>);
	document.getElementById("observacions").value = checkIfNull(<%=local.getObservacions()%>);
	createTablesNivell();
	putCaracteristiquesinPlace();
	changeLabelLanguage();
	setValuesInputDireccio();
	defineLabelButtonbyAction();
	letSearchByAdressDependingOnTipusBusqueda();
</script>
</html>