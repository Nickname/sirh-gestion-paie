<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Liste des employés</title>
	<script src='<c:url value="/js/jquery-3.2.1.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/nav.js"></c:url>'></script>
	<link rel="stylesheet" href='<c:url value="/css/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>
</head>
</head>
<body id="employes">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="container-fluid">
			<div clas="col-12">
				<h1 class="display-4 text-center">Liste des employés</h1>
			</div>
		</div>
		
		<div class="container-fluid">
		
			<div class="offset-9 col-2">
				<a type="button" href="/paie/mvc/employes/creer" class="col-2 btn btn-default btn-lg">
					<span>Ajouter un employé</span>
				</a>
			</div>
			<table class="table table-bordered table-hover top7">
				<thead class="thead-light">
					<tr>
						<th>Date/heure création</th>
						<th>Matricule</th>
						<th>Grade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employes}" var="employe">
						<tr>
							<td>${employe.dateCreation}</td>
							<td>${employe.matricule}</td>
							<td>${employe.grade.code}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	
</body>
</html>