/**
 * Author: Gustaf Peter Hultgren
 */

(function() {
	
	var app = angular.module("avApp", []);
	
	var theaterController = function($scope, $http) {
		
		// This function triggers whenever a call to get the data from the database is successful.
		var onComplete = function(response) {
			//$scope.films = response.data.films;
			$scope.viewings = response.data.viewings;
			$scope.theaters = response.data.theaters;
			
			$scope.viewingsList = response.data.viewings;
			
			if($scope.viewings.length > 0) {
				$scope.selectedViewing = $scope.viewings[0];
			}
			
			$scope.error = "";
		}
		
		// Function to trigger whenever an error has occured.
		var onError = function(reason) {
			$scope.error = "Error: " + reason.data.status;
			alert($scope.error);
		}
		
		// Call the servlet for data.
		$http.get("GetViewingsAdmin").then(onComplete, onError);
		
		// Triggers whenever the filter is changed.
		$scope.filter = function() {
			var id = $scope.selectedTheater;
			
			// If id = -1, then no filter is used and all viewings shown.
			if(id == -1)
				$scope.viewings = $scope.viewingsList;
			
			// Else, only viewings associated with the selected theater should be shown.
			else
				$scope.viewings = $scope.viewingsList.filter(function(viewing){
					return viewing.theaterId == id;
				})
		}
		
		// Triggers when a viewing is selected.
		$scope.selectViewing = function(viewing) {
			$scope.selectedViewing = viewing;
		}
		
		// Triggers if a http request to add a new viewing was successful.
		var onAddComplete = function(response) {
			// Call the servlet for data.
			$http.get("GetViewingsAdmin").then(onComplete, onError);
		}
		
		// Triggers whenever a http request to remove a viewing was successful.
		var onRemoveComplete = function(response) {
			// Remove the old data from the list.
			$scope.viewingsList = $scope.viewingsList.filter(function(){
				return viewing.theaterId != $scope.deletedId;
			})
			
		}
		
		// Triggers when adding a new viewing.
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
		
		// Triggers when removing a viewing.
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
	
	// Bind the controller to the application.
	app.controller("theaterController", ["$scope", "$http", theaterController]);
	
}())