/**
 * Author: Herman Dackenberg
 */

(function() {
	
	var app = angular.module("seatBookingApp", []);
	
	var theaterController = function($scope, $http) {
		
		var onComplete = function(response) {
			$scope.films = response.data.films;
			$scope.viewings = response.data.viewings;
			$scope.theaters = response.data.theaters;
		}
		
		var onError = function() {
			// TODO Display error!
		}
		
		// Call the servlet for data.
		$http.get("GetViewingsBooking").then(onComplete, onError);
		
		$scope.theaterFilter = function() {
			// TODO filter away viewings for other theaters.
		}
	}
	
	app.controller("theaterController", ["$scope", "$http", theaterController]);
	
}())