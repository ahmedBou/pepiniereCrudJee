<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<form action="modify.do" method ="post">
			Nom: <input type="text" name="nm" value="${p.nom}"><br>
			Quantité: <input type="text" name="qt" value="${p.quantite}">
			Prix: <input type="text" name="px" value="${p.prix}">
			<input type= "hidden" value="${id}" name="id">
			<input type="submit" value="submit">
			
		</form>

</body>
</html>