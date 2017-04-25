<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width">
	<meta charset="UTF-8">
	<meta name="author" content="Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg">
	<link rel="icon" href="media/cinema.ico">
	<link rel="stylesheet" href="src/style.css">
	<link rel="stylesheet" href="src/navbar.css">
	<title>Cinema</title>
</head>
<body>
	<div id="main_container">
		<header>
			<h1>Cinema</h1>
		</header>
		<nav>
			<ul>
				<li><a href="info.html"><input type="button" value="Info"></a></li>
				<li><a href="GetFilmsBooking?id=0"><input type="button" value="Films & Tickets"></a></li>
				<li><input type="button" value="Admin" disabled></li>
			</ul>
		</nav>
		<nav id="admin_nav">
			<ul>
				<li><input type="button" value="Hantera filmer" disabled></li>
				<li><a href="adminviewing.html"><input type="button" value="Hantera visningar"></a></li>
			</ul>
		</nav>
		<article>
			<div>
				<form method="GET" action="GetFilmsAdmin">
					<input type="hidden" name="id" value="0">
					<label for="filter">Titelfilter</label>
					<input type="text" name="filter">
				</form>		
				
				<ul>
					<c:set var="id" value="0" scope="page"/>
					<c:forEach items="${films}" var="film">
						<li><a href="GetFilmsAdmin?id=${Integer.toString(id)}" class="film_link">
							&bull; <c:out value="${film.title}"/>
						</a></li>
						<c:set var="id" value="${id + 1}" scope="page"/>
					</c:forEach>
				</ul>
				<form method="POST" action="DeleteFilm?title=${film.title}">
					<input type="submit" value="Ta Bort Film">
				</form>
				<form method="POST" action="AddFilm">
					<input type="submit" value="Lägg till Film"><br>
					<label for="title">Titel</label>
					<input type="text" name="title"><br>
					<label for="title">Genre</label>
					<input type="text" name="genre"><br>
					<label for="title">Åldersgräns</label>
					<input type="text" name="age"><br>
					<label for="title">Speltid</label>
					<input type="number" name="time"><br>
					<label for="title">Utgivningsår</label>
					<input type="number" name="year"><br>
					<label for="title">Beskrivning</label>
					<input type="text" name="description"><br>
				</form>
				
			</div>
			<div id="film_info_div">
				<div id="film_info">
					<h3><c:out value="${film.title}"/></h3>
					<p><c:out value="${film.genre}"/>, <c:out value="${film.year}"/></p>
					<p><c:out value="${film.length}"/> min, <c:out value="${film.pgi}"/> år</p>
					<p><c:out value="${film.description}"/></p>
				</div>
			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
</body>
</html>