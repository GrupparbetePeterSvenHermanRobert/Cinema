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
					<option value="all">Alla</option>
					<option value="2">Salong 2 Emil</option>
					<option value="3">Salong 3 Tyr</option>
					<option value="4">Salong 4 Oden</option>
					<option value="5">Salong 5 Thor</option>
					<option value="6">Salong 6 Njord</option>
					<option value="7">Salong 7 Freja</option>
					<option value="8">Salong 8 Saga</option>
					<option value="9">Salong 9 Glim</option>
					<option value="10">Salong 10 Alva</option>
					<option value="1">Salong 1 Loke</option>
				</select>
				
				<ul>
					<c:out value="${viewings.size()}" />
					<c:forEach items="${viewings}" var="viewing">
						<li><a href="GetViewingsAdmin?id=0"><c:out value="${viewing.id}"/>,
						 <c:out value="${viewing.id}"/></a></li>
					</c:forEach>
				</ul>
				 <select size="25">
					<option value="1">Rambo 17 2018-04-34 18:30 </option>
					<option value="2">Nisse i brevlådan 2017-04-20 15:30</option>
					<option value="3">Star Treck 27 2018-02-20 18:30</option>
					<option value="4">Rambo 17 2018-04-31 18:30 </option>
					<option value="5">Star Treck 27 2018-04-20 18:30</option>
					<option value="6">Nisse i brevlådan 2017-04-27 15:30</option>
					<option value="7">Rambo 17 2018-05-28 18:30</option>
					<option value="8">Nisse i brevlådan 2017-04-02 15:30</option>
				</select>
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
					<h3>Indiana Jöns	</h3>
					<p>Komedi 2018</p>
					<p>100min 15år</p>
					<p>Inidana springer omkring och tar hand om pisker och nitar. <br>
					Tjyvar och banditer försöker fånga Jöns och fastnar i lera.<br>
					Allt är som vanligt Emils fel</p>
				</div>
				<div id="film_info">
					<h3>Salong 2 Emil</h3>
					<p>2018-05-20</p>
					<p>18:00 - 21:00</p>
					<p>Kuddar och hörslinga finns till alla.</p>
				</div>


			</div>
		</article>
		<footer>
			<p>&copy; 2017, Gustaf Peter Hultgren, Robert Fängström, Sven Andersson, Herman Dackenberg, All Rights Reserved.</p>
		</footer>
	</div>
</body>
</html>