<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
<body id="bulletins">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="row">
			<div class="col-2">
				<button type="button" href="#" class="col-2 btn btn-default btn-lg">
					<i class="fa fa-angle-left" aria-hidden="true"></i><span> Retour</span>
				</button>
			</div>
			<div class="col-8">
				<h1 class="display-4 text-center">Créer Bulletin de Salaire</h1>
			</div>
		</div>
	
		<div class="row col-8 offset-2">
		
			<form class="creer_employe" method="post">
			
				<div class="form-group">
					<label for="selectPeriode">Période</label> 
					<select name="periode" id="selectPeriode" name="profil" class="form-control">
						<c:forEach items="${periodes}" var="periode">
							<option value="<c:out value="${periode.id}"/>">
								<c:out value="${periode}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="selectMatricule">Matricule</label> 
					<select name="matricule" id="selectMatricule" class="form-control">
						<c:forEach items="${employes}" var="employe">
							<option value="<c:out value="${employe.id}"/>">
								<c:out value="${employe.matricule}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="inputPrime">Prime exceptionnelle</label> 
					<input id="inputPrime" class="form-control" type="text" name="prime"></input>
				</div>
				
				<input class="btn btn-default" type="submit" value="Créer"/>
			</form>
			
		</div>
		
	</div>

</body>
</html>
