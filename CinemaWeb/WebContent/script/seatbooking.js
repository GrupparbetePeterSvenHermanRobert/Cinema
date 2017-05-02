/**
 * Author: Herman Dackenberg
 */

(function() {
	
	var app = angular.module("seatBookingApp", []);
	
	var seatBookingController = function($scope, $http) {
		
		var onComplete = function(response) {
			$scope.film = response.data.film;
			$scope.viewing = response.data.viewing;
			$scope.theater = response.data.theater;
		}
		
		var onError = function() {
			// TODO Display error!
		}
		
		// Call the servlet for data.
		$http.get("GetFilmTheaterViewing").then(onComplete, onError);
		
	}
	
	app.controller("seatBookingController", ["$scope", "$http", seatBookingController]);
	
}())