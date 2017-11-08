<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Liste de bulletin</title>
	<script src='<c:url value="/js/jquery-3.2.1.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/nav.js"></c:url>'></script>
	<link rel="stylesheet" href='<c:url value="/css/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>
</head>
</head>
<body id="bulletins">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="container-fluid">
			<div class="col-12">
				<h1 class="display-4 text-center">Liste des Bulletins</h1>
			</div>
		</div>
		
		<div class="container-fluid">
		
			<div class="offset-9 col-2">
				<a type="button" href="/paie/mvc/bulletins/creer" class="col-2 btn btn-default btn-lg">
					<span>Créer un nouveau bulletin</span>
				</a>
			</div>
			<table class="table table-bordered table-hover top7">
				<thead class="thead-light">
					<tr>
						<th>Date/heure création</th>
						<th>Période</th>
						<th>Matricule</th>
						<th>Salaire brut</th>
						<th>Net Imposable</th>
						<th>Net à payer</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bulletins}" var="bulletin">
						<tr>
							<td class="align-middle">${bulletin.key.dateCreation}</td>
							<td class="align-middle">${bulletin.key.periode}</td>
							<td class="align-middle">${bulletin.key.remunerationEmploye.matricule}</td>
							<td class="align-middle">${bulletin.value.salaireBrut}</td>
							<td class="align-middle">${bulletin.value.netImposable}</td>
							<td class="align-middle">${bulletin.value.netAPayer}</td>
							<td><a class="btn" href="<c:url value='/mvc/bulletins/detail/${bulletin.key.id}'/>">Visualiser</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	
</body>
</html>