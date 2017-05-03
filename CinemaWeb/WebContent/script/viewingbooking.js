(function() {
	var app = angular.module("viewingbookingApp", []);

	var viewingbookingController = function($scope, $http) {

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

	app.controller("viewingbookingController", [ "$scope", "$http",
		viewingbookingController ]);

}())