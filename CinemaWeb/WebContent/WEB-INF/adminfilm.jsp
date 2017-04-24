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
				<li><a href="GetFilmsBooking"><input type="button" value="Films & Tickets"></a></li>
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
				<label for="filter">Titelfilter</label>
				<input type="text" name="filter">
				
				<select size="25">
					<c:forEach items="${films}" var="film">
						<% int i = 0; %>
						<option value="${i}">
							&bull; <c:out value="${film.title}"/>
							<c:out value="${film.description}" />
						</option>
						<% i++; %>
					</c:forEach>
				</select>
				
				<input type="button" value="Ta Bort Film">
				<form>
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
					<p>Action 2018</p>
					<p>100 min 15år</p>
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