<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width">
	<meta charset="UTF-8">
	<meta name="author" content="Gustaf Peter Hultgren, Robert FÃ¤ngstrÃ¶m, Sven Andersson, Herman Dackenberg">
	<link rel="icon" type="image.png" href="media/cinema.png">
	<link rel="stylesheet" href="src/style.css">
	<link rel="stylesheet" href="src/navbar.css">
	<!-- En kommentar -->
	<title>Cinema Webbklient</title>
</head>
<body>
	<div id="main_container">
		<header>
			<h1>Cinema</h1>
		</header>
		<nav>
			<ul>
				<li><a href="info.html"><input type="button" value="Info"></a></li>
				<li><input type="button" value="Films & Tickets" disabled></li>
				<li><a href="adminfilm.html"><input type="button" value="Admin"></a></li>
			</ul>
		</nav>
		<article>
			<div>
			<%int i = 0;
			%>
			<ul>
			
			<c:set var="id" value="0" scope="page"/>
					<c:forEach items="${films}" var="film">
						<li><a href="GetFilmsBooking?id=${Integer.toString(id)}" class="film_link">
							&bull; <c:out value="${film.title}"/>
						</a></li>
						<c:set var="id" value="${id + 1}" scope="page"/>
					</c:forEach>		
			
			</ul>
			</div>
			
			
			<div id="film_info_div">
				<div id="film_info">
					<p><c:out value="${film.title}"/> <br></p>
					<p><c:out value="${film.description}"/> <br></p>
					<p><c:out value="${film.genre}"/><br></p>
					<p><c:out value="${film.year}"/><br></p>
					<p>PGI <c:out value="${film.pgi}"/> <br></p>  
					<p><c:out value="${film.length}"/> Min</p> 
					
			
					
				</div>
				<div id="book_ticket">
					<a href="index.html"><input type="button" value="Back"></a>
					<a href="viewingbooking.html"><input type="button" value="Boka Biljett"></a>
				</div>
				<div></div>
			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert FÃ¤ngstrÃ¶m, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
</body>
</html>