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
		
		var onAddComplete = function(response) {
			// Call the servlet for data.
			$http.get("GetViewingsAdmin").then(onComplete, onError);
		}
		
		var onRemoveComplete = function(response) {
			// Remove the old data from the list.
			$scope.viewingsList = $scope.viewingsList.filter(function(){
				return viewing.theaterId != $scope.deletedId;
			})
			
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
			
			$http.post("GetViewingsAdmin", jsonPackage).then(onAddComplete, onError);
		}
		
		$scope.remove = function(viewingId) {
			var package = {
					mode: "delete",
					id: "viewingId"
			}
			
			$scope.deletedId = viewingId;
			
			var jsonPackage = JSON.stringify(package);
			
			$http.post("GetViewingsAdmin", jsonPackage).then(onRemoveComplete, onError);
		}
	}
	
	app.controller("theaterController", ["$scope", "$http", theaterController]);
	
}())