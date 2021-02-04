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
	<p>hello jsp</p>
	
	<form action="search.do" method="get">
		<input type="text" name="nm" value="${ modelPl.getNm()}">
		<input type="submit" value="submit">
	</form>
	
<table class="table table-striped">

	<tr>
		<th>ID</th><th>nom</th><th>quantité</th><th>prix</th>
	</tr>
	<c:forEach items="${modelPl.pl}" var="p">
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