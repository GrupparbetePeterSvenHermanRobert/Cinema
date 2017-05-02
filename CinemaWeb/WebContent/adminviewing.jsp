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
		<article data-ng-app="avApp" data-ng-controller="theaterController">
			<div>
				<select data-ng-change="theaterFilter()" data-ng-model="selectedTheater" data-ng-init="-1">
					<option value="-1">Alla</option>
					<option value="{{theater.theaterId}}" data-ng-repeat="theater in theaters">
					Salong {{theater.theaterId}}
					</option>
				</select>
				
				<table>
					<thead>
						<tr>
							<td>
								Filmtitel
							</td>
							<td>
								Datum
							</td>
							<td>
								Start- och sluttid
							</td>
						</tr>
					</thead>
					<tr data-ng-repeat="viewing in viewings">
						<td>
							{{viewing.film.title}}
						</td>
						<td>
							{{viewing.date}}
						</td>
						<td>
							Kl. {{viewing.startTime.time.hour}}:{{viewing.startTime.time.minute}} -
							{{viewing.endTime.time.hour}}:{{viewing.endTime.time.minute}}
						</td>
						<td>
							<button data-ng-click="remove({{viewing.id}})">Ta Bort</button>
						</td>
					</tr>
				</table>
				
				<form>
					<input type="button" value="Lägg till Visning" data-ng-click="add "><br>
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
					<!--<h3><c:out value="${film.title}"/></h3>
					<p><c:out value="${film.genre}"/>, <c:out value="${film.year}"/></p>
					<p><c:out value="${film.length}"/> min, <c:out value="${film.pgi}"/> år</p>
					<p><c:out value="${film.description}"/></p>-->
				</div>
				<div id="film_info">
					<!--<h3>Salong <c:out value="${viewing.theaterId}"/></h3>
					<p><c:out value="${viewing.date}"/></p>
					<p><c:out value="${viewing.time}"/> - <c:out value="${viewing.end}"/></p>-->
					<p><!-- Theater Information to be added! -->Kuddar och hörslinga finns till alla.</p>
				</div>
			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
	
	<!-- Load AngularJS version 1.6.2 -->
	<script data-require="angular.js@1.6.2" data-semver="1.6.2" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.2/angular.js"></script>
	<!-- Load the Java Script to use. -->
	<script src="script/adminviewing.js"></script>
	<!-- Warn about issues with javaScript. -->
	<noscript>JavaScript unavailable or disabled!</noscript>
</body>
</html>