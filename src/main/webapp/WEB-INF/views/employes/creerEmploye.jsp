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
	<link rel="stylesheet" href='<c:url value="/css/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>
</head>
<body id="employes">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="row">
			<div class="col-2">
				<button type="button" href="/paie/mvc/employes/lister" class="col-2 btn btn-default btn-lg">
					<i class="fa fa-angle-left" aria-hidden="true"></i><span> Retour</span>
				</button>
			</div>
			<div clas="col-8">
				<h1 class="display-4 text-center">Ajouter un employé</h1>
			</div>
			
		</div>
	
		<div class="row col-8 offset-2">
		
			<form class="creer_employe" method="post">
			
				<div class="form-group">
					<label for="inputMatricule">Matricule</label> 
					<input id="inputMatricule" class="form-control" type="text" name="matricule"></input>
				</div>
				
				<div class="form-group">
					<label for="selectEntreprise">Entreprise</label>
					<select id="selectEntreprise" name="entreprise" class="form-control">
						<c:forEach items="${entreprises}" var="entreprise">
							<option value="<c:out value="${entreprise.id}"/>">
								<c:out value="${entreprise}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="selectProfil">Profil</label> 
					<select name="profil" id="selectProfil" name="profil" class="form-control">
						<c:forEach items="${profils}" var="profil">
							<option value="<c:out value="${profil.id}"/>">
								<c:out value="${profil}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="selectGrade">Grade</label> 
					<select name="grade" id="selectGrade" class="form-control">
						<c:forEach items="${grades}" var="grade">
							<option value="<c:out value="${grade.id}"/>">
								<c:out value="${grade}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<input class="btn btn-default" type="submit" value="Créer"/>
			</form>
			
		</div>
		
	</div>

</body>
</html>
