<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Bulletin de salaire</title>
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
			<div class="col-2">
				<a href="/paie/mvc/bulletins/lister" class="btn btn-default btn-lg">
					<i class="fa fa-angle-left" aria-hidden="true"></i><span> Retour</span>
				</a>
			</div>
			<div class="col-12">
				<h1 class="display-4 text-center">Bulletin de salaire</h1>
			</div>
		</div>
	
		<div class="container-fluid">
		
		<div class="row">
			<div class="col-3">
				<strong>Entreprise</strong> <br>
				${bulletin.remunerationEmploye.entreprise.denomination} <br>
				SIRET : ${bulletin.remunerationEmploye.entreprise.siret}
			</div>
			<div class="col-3 offset-6">
				<strong>Période</strong><br> Du
				${bulletin.periode.dateDebut} au
				${bulletin.periode.dateFin} <br> <br> <strong>Matricule
					: ${bulletin.remunerationEmploye.matricule}</strong>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<h3>Salaire</h3>
				<table class="table table-bordered table-hover">
					<thead class="thead-light">
						<tr>
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Salaire de base</td>
							<td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
							<td><fmt:formatNumber type="number"
									value="${bulletin.remunerationEmploye.grade.tauxBase}"
									minFractionDigits="2" maxFractionDigits="2"/></td>
							<td>${resultatCalculRemuneration.salaireDeBase}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Prime Except.</td>
							<td></td>
							<td></td>
							<td>${bulletin.primeExceptionnelle}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Salaire Brut</td>
							<td></td>
							<td></td>
							<td>${resultatCalculRemuneration.salaireBrut}</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>

				<h3>Cotisations</h3>
				<table class="table table-bordered table-hover">
					<thead class="thead-light">
						<tr>
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cotisationsNonImposables}" var="cotisation">
							<tr>
								<td>${cotisation.code}-${cotisation.libelle}</td>
								<td>${resultatCalculRemuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial}</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										<fmt:formatNumber type="number"
											value="${resultatCalculRemuneration.salaireBrut * cotisation.tauxSalarial}"
											minFractionDigits="2" maxFractionDigits="2"/>
									</c:if></td>
								<td>${cotisation.tauxPatronal}</td>
								<td><c:if test="${cotisation.tauxPatronal != null}">
										<fmt:formatNumber type="number"
											value="${resultatCalculRemuneration.salaireBrut * cotisation.tauxPatronal}"
											minFractionDigits="2" maxFractionDigits="2"/>
									</c:if></td>
							</tr>
						</c:forEach>
						<tr>
							<td>Total Retenue</td>
							<td></td>
							<td></td>
							<td><fmt:formatNumber type="number"
									value="${resultatCalculRemuneration.totalRetenueSalarial}"
									minFractionDigits="2" maxFractionDigits="2"/></td>
							<td></td>
							<td><fmt:formatNumber type="number"
									value="${resultatCalculRemuneration.totalCotisationsPatronales}"
									minFractionDigits="2" maxFractionDigits="2"/></td>
						</tr>

					</tbody>
				</table>
				<h3>NET Imposable : ${resultatCalculRemuneration.netImposable}
					€</h3>
				<table class="table table-bordered table-hover">
					<thead class="thead-light">
						<tr>
							<td>Rubriques</td>
							<td>Base</td>
							<td>Taux Salarial</td>
							<td>Montant Salarial</td>
							<td>Taux patronal</td>
							<td>Cot. patronales</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cotisationsImposables}" var="cotisation">
							<tr>
								<td>${cotisation.code}-${cotisation.libelle}</td>
								<td>${resultatCalculRemuneration.salaireBrut}</td>
								<td>${cotisation.tauxSalarial}</td>
								<td><c:if test="${cotisation.tauxSalarial != null}">
										<fmt:formatNumber type="number"
											value="${resultatCalculRemuneration.salaireBrut * cotisation.tauxSalarial}"
											minFractionDigits="2" maxFractionDigits="2"/>
									</c:if></td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="col-3 offset-9" style="text-align: right; margin-bottom:50px;">
					<strong>NET A PAYER :
						${resultatCalculRemuneration.netAPayer} €</strong>
				</div>
			</div>
		</div>
		
		</div>

	</div>
	
</body>
</html>