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
				<select size="25">
					<!-- <option value="Rambo 19">Rambo 19 	Action	2018</option>
					<option value="The Room">The Room Drama	2003</option>
					<option value="Batman dead or alive">Batman dead or alive Action	2018</option>
					<option value="Nisse i brevlÃ¥dan">Nisse i brevlÃ¥dan Barn	2018</option>
					<option value="StarTreck 17">StarTreck 27 Sify 2019</option>
					<option value="Indiana Jones 7">Indiana Jones 7 Action 2019</option>
					-->
				</select>
			</div>
			<div id="film_info_div">
				<div id="film_info">
					<h3>Rambo 19</h3>
					<p>Action	2018</p>
					<p>130	15</p>
					<p>Rambo och Emil trÃ¤ffar sina vÃ¤nner. Allt Ã¤r Emils fel sÃ¥ grillpartyt blir en katarsrof. <br>
					Indianer och Cowboys anfaller med pickadoller och pilar.<br> 
					NÃ¤r striden Ã¤r avslutas sammlas alla och grillar marchmallows.
					</p>
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