<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	
	<%@include file="header.jsp" %> 

	
	<form action="index.do" method="get">
		<div class="container">
			<div class="row justify-content-center">
					
				<c:forEach items="${plantes}" var="p">
					<div class="columns" >
						<div class="card" style="width: 18rem;">
						  <img src="images/spathi.webp" class="card-img-top" alt="...">
						  <div class="card-body">
						    
						    <span class="card-title">Nom: <b>${p.nom}</b> </span>
						    <span class="card-title">Quantité: <b>${p.quantite}</b></span>
						    <span class="card-title">Prix: <b>${p.prix}</b></span><br>
						    
						    						    
						    <form action="getId.do" method="get">
						     	
						     	<button type="submit" name="id" value="${p.id}" class="btn btn-primary" value="Modify">Modify</button>
						    	<%-- <button type="submit" name="id" value="${p.id}" class="btn btn-primary" value="Delete">Delete</button> 	 --%>
						    
						    </form>
						    
		
						    
						    
						    
						<a href="delete.do?id=${p.id}" class="btn btn-primary">Delete</a>
						    
						  </div>
						</div>
					</div>
				</c:forEach>
			
				
			</div>
		</div>
	</form>
	
	
	
	<table class="table table-striped">
	
		<tr>
			<th>ID</th><th>nom</th><th>quantité</th><th>prix</th>
		</tr>
		<c:forEach items="${plantes}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nom}</td>
				<td>${p.quantite}</td>
				<td>${p.prix}</td>
			
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>