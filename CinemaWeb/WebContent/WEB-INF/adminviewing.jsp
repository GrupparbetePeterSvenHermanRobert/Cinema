<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="GetFilmsAdmin?id=0"><input type="button" value="Hantera filmer"></a></li>
				<li><input type="button" value="Hantera visningar" disabled></li>
			</ul>
		</nav>
		<article>
			<div>
				<select>
					<option value="-1">Alla</option>
					<c:forEach items="${theaters}" var="theater">
					
						<option value="${Integer.toString(theater.id)}">
							Salong <c:out value="${theater.id}"/>
						</option>
					
					</c:forEach>
				</select>
				
				<ul>
					<c:set var="id" value="0" scope="page"/>
					<c:forEach items="${viewings}" var="viewing">
						<li><a href="GetViewingsAdmin?id=${Integer.toString(id)}" class="film_link">
						<c:out value="${viewing.filmTitle}"/>, 
						<c:out value="${viewing.date}"/>, Kl. 
						<c:out value="${viewing.time}"/></a></li>
						<c:set var="id" value="${id + 1}" scope="page"/>
					</c:forEach>
				</ul>
				<input type="button" value="Ta Bort Visning">
				<form>
					<input type="submit" value="Lägg till Visning"><br>
					<label for="title">Filmtitel</label>
					<input type="text" name="title"><br>
					<label for="theater">Salong</label>
					<input type="number" name="theater"><br>
					<label for="date">Datum</label>
					<input type="date" name="date"><br>
					<label for="start">Starttid</label>
					<input type="time" name="start"><br>
					<label for="end">Sluttid</label>
					<input type="time" name="end"><br>
					<label for="description">Beskrivning</label>
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
				<div id="film_info">
					<h3>Salong <c:out value="${viewing.theaterId}"/></h3>
					<p><c:out value="${viewing.date}"/></p>
					<p><c:out value="${viewing.time}"/> - <c:out value="${viewing.end}"/></p>
					<p><!-- Theater Information to be added! -->Kuddar och hörslinga finns till alla.</p>
				</div>


			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
</body>
</html>