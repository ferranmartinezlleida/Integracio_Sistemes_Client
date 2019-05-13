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

String caract = "";

for(int i=0;i<caracteristiques.length;i++){
	
	caract = caract + caracteristiques[i].getNomCaracteristica() + "|" + caracteristiques[i].getValor() + "|" + caracteristiques[i].getTipo() + ";";
	
}


%>
<script>

function getNameTipoLocalFromCodi(codi){

	var tipusLocal = ["BARS I RESTAURANTS","COMERÇOS","ENTITATS BANCÀRIES","FARMÀCIES","HOTELS","LOCALS PÚBLICS"];

	return tipusLocal[(parseInt(codi)-1)];
}

function checkIfNull(obs){

	var observacions = "Sense observacions";

	if(obs != null){
		observacions = obs;
	}

	return observacions;
}

function appendCaracteristicatoTable(tableName,row,nomCarac,valueCarac,tipoCarac){
	var row = document.getElementById(tableName).insertRow(row);
	var cell1 = row.insertCell(0)
	var cell2 = row.insertCell(1)
	var cell3 = row.insertCell(2)
	
	var tipus = "";
	var value = valueCarac;

	if(tipoCarac == "1"){
		tipus = "Cert/fals";
		if(valueCarac == "0"){
			value="Fals";
		}else if(valueCarac =="1" ){
			value="Cert";
		}
	}else if (tipoCarac == "2"){
		tipus = "Rang: 1..5";
		}
	
	
	cell1.innerHTML= nomCarac;
	cell2.innerHTML = tipus;
	cell3.innerHTML = value;
}

function getCaracteristiquesfromString(caract){

	var arrayCarac = caract.toString().split(";");
	
	for(i=0;i<(arrayCarac.length-1);i++){		
		var caracteristica = arrayCarac[i].split("|");
		appendCaracteristicatoTable("accessibilitat",(i+1),caracteristica[0],caracteristica[1],caracteristica[2]);
			
	}

}

function defineLabelButtonbyAction(){

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
	
}

function letSearchByAdressDependingOnTipusBusqueda(){

	var tipus_busqueda = "<%=tipus_busqueda%>";

	if(tipus_busqueda == "adress"){

		document.getElementById("alternative_search").style.display="none";
	}


	
}



</script>

<head>
<meta charset="UTF-8">
<title>Local</title>
</head>
<body>
<input type="hidden" id="action" name="action" value="<%=action%>"/>

	<table id="alternative_search">
		<tr>
			<td>No és el local que busques?</td>
			<td></td>
		</tr>
		<tr>
			<td>Proba una cerca més concreta</td>
			<td><a id="adress" name="adress"  href="">Busca per adreça</a></td>
		</tr>
	</table>
	<table>
	<tr>
		<td>Dades de l'establiment</td>
		<td></td>
	</tr>
	<tr>
		<td>Nom:</td>
		<td><input type="text" name="nomLocal" readonly="readonly" id="nomLocal" value="<%=local.getNomLocal()%>"/></td>
	</tr>
	<tr>
		<td>Tipus local</td>
		<td><input type="text" name="tipusLocal" readonly="readonly" id="tipusLocal" value=""/></td>
	</tr>
	<tr>
		<td>Adreça:</td>
		<td><input type="text" name="direccio" readonly="readonly" id="direccio" value="<%=local.getNomVia()%> <%=local.getNomCarrer()%>, <%=local.getNumero()%>"/></td>
	</tr>
	<tr>
		<td>Observacions:</td>
		<td><input type="text" name="observacions" readonly="readonly" id="observacions" value=""/></td>
	</tr>
</table>
<table id="accessibilitat">
	<tr>
		<td>Dades formulari</td>
		<td></td>
	</tr>
	
</table>
<form method="get" id="frm" name="frm" action="">

<input type="hidden" id="pk" name="pk" value="<%=local.getCodiLocal()%>"/>
<table id="taula_accions">
	<tr>
		<td><h1 id="boto_label"></h1></td>
	</tr>
	<tr>
		<td><td><button id="boto" name="boto" onclick="document.frm.submit();" value=""> </button></td></td>
	</tr>
</table>

</form>

	
</table>

</body>
<script>
	document.getElementById("tipusLocal").value = getNameTipoLocalFromCodi(<%=local.getCodiTipoLocal()%>);
	document.getElementById("observacions").value = checkIfNull(<%=local.getObservacions()%>);
	getCaracteristiquesfromString("<%=caract%>");
	defineLabelButtonbyAction();
	letSearchByAdressDependingOnTipusBusqueda();
</script>
</html>