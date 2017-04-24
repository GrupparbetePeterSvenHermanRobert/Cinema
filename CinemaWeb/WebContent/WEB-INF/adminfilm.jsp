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
				<li><a href="filmbooking.html"><input type="button" value="Films & Tickets"></a></li>
				<li><a href="adminfilm.html"><input type="button" value="Admin" disabled></a></li>
			</ul>
		</nav>
		<nav id="admin_nav">
			<ul>
				<li><a href="adminfilm.html"><input type="button" value="Hantera filmer" disabled></a></li>
				<li><a href="adminviewing.html"><input type="button" value="Hantera visningar"></a></li>
			</ul>
		</nav>
		<article>
			<div>
				<label for="filter">Titelfilter</label>
				<input type="text" name="filter">
				<select size="25">
				<option value="Rambo 19">Rambo 19 	Action	2018</option>
					<option value="The Room">The Room Drama	2003</option>
					<option value="Batman dead or alive">Batman dead or alive Action	2018</option>
					<option value="Nisse i brevlådan">Nisse i brevlådan Barn	2018</option>
					<option value="StarTreck 17">StarTreck 27 Sify 2019</option>
					<option value="Indiana Jones 7">Indiana Jones 7 Action 2019</option>
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
				<h3>Rambo 19</h3>
					<p>Action 2018</p>
					<p>100 min 15år</p>
					<p>En film om Rambo och allt är Emils fel.<br>
					 Under Rambos underbara resa i underjorden händer inget speciellt.<br> 
					Det är skuta och döda, enhörningar och bubbelpooler.<br>
					Allt är inlindat i ett romantiskt töcken.</p>			
				</div>
			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
</body>
</html>