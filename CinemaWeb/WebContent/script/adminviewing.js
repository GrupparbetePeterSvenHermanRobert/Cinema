/**
 * Author: Gustaf Peter Hultgren
 */

(function() {
	
	var app = angular.module("avApp", []);
	
	var theaterController = function($scope, $http) {
		
		var onComplete = function(response) {
			$scope.films = response.data.films;
			$scope.viewings = response.data.viewings;
			$scope.theaters = response.data.theaters;
			
			$scope.viewingsList = response.data.viewings;
		}
		
		var onError = function() {
			$scope.error = "Error: " + response.data.status;
		}
		
		// Call the servlet for data.
		$http.get("GetViewingsAdmin").then(onComplete, onError);
		
		$scope.filter = function() {
			var id = $scope.selectedTheater;
			
			if(id == -1)
				$scope.viewings = $scope.viewingsList;
			else
				$scope.viewings = $scope.viewingsList.filter(function(viewing){
					return viewing.theaterId == id;
				})
		}
	}
	
	app.controller("theaterController", ["$scope", "$http", theaterController]);
	
}())