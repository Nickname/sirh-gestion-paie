<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Créer un bulletin</title>
	<script src='<c:url value="/js/jquery-3.2.1.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/nav.js"></c:url>'></script>
	<link rel="stylesheet" href='<c:url value="/css/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/css/style.css"></c:url>'>
</head>
<body id="bulletins">
	<div id="nav"></div>
	
	<div class="container top10">
	
		<div class="row">
			<div class="col-2">
				<a href="/paie/mvc/bulletins/lister" class="col-2 btn btn-default btn-lg">
					<i class="fa fa-angle-left" aria-hidden="true"></i><span> Retour</span>
				</a>
			</div>
			<div class="col-8">
				<h1 class="display-4 text-center">Créer Bulletin de Salaire</h1>
			</div>
		</div>
	
		<div class="row col-8 offset-2">
		
			<form class="creer_bulletin" method="post">
			
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
				
				<sec:csrfInput />
				
				<input class="btn btn-default" type="submit" value="Créer" style="float:right;"/>
			</form>
			
		</div>
		
	</div>

</body>
</html>
