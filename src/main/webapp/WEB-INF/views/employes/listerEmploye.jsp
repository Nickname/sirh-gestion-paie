<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Créer un employer</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<script> <c:import url="../../script/nav.js"/> </script>
	<style> <c:import url="../../css/style.css"/> </style>
	<style> <c:import url="../../css/font-awesome-4.7.0/css/font-awesome.min.css"/> </style>
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