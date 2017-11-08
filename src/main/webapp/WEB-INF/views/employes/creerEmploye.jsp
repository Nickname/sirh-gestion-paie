<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Créer un employer</title>
	<script src='<c:url value="/js/jquery-3.2.1.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/nav.js"></c:url>'></script>
	<link rel="stylesheet" href='<c:url value="/css/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>
</head>
<body id="employes">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="row">
			<div class="col-2">
				<a href="/paie/mvc/employes/lister" class="col-2 btn btn-default btn-lg">
					<i class="fa fa-angle-left" aria-hidden="true"></i><span> Retour</span>
				</a>
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
				
				<sec:csrfInput />
				
				<input class="btn btn-default" type="submit" value="Créer" style="float:right;"/>
			</form>
			
		</div>
		
	</div>

</body>
</html>
