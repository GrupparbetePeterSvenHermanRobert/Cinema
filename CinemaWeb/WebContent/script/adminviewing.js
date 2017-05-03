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
			
			if($scope.viewings.length > 0) {
				$scope.selectedViewing = $scope.viewings[0];
			}
		}
		
		var onError = function(reason) {
			$scope.error = "Error: " + reason.data.status;
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
		
		$scope.selectViewing = function(viewing) {
			$scope.selectedViewing = viewing;
		}
		
		var onPostComplete = function(response) {
			// TODO any responses.
		}
		
		$scope.add = function() {
			var package = {
					mode: "add",
					filmtitle: $scope.filmTitle,
					theaterId: $scope.theaterId,
					date: $scope.date,
					start: $scope.start,
					end: $scope.end,
					description: $scope.description
			}
			
			var jsonPackage = JSON.stringify(package);
			
			$http.post("GetViewingsAdmin", jsonPackage).then(onPostComplete, onError);
		}
	}
	
	app.controller("theaterController", ["$scope", "$http", theaterController]);
	
}())