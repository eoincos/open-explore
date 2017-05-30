angular.module('hello', [])
  .controller('home', function($http) {
  	var self = this;
  	
    self.showDepartureSuggestions = function (departure) {
	  	$http({
		    url: 'getSuggestions/', 
		    method: "GET",
		    params: {location: departure}
		 }).then(function(response) {
	  		self.departureSuggestions = response.data;
	  		console.log(response.data);
	  	})
    }
    
    self.updateDeparture = function (suggestion) {
      self.departure = suggestion;
      self.departureSuggestions = [];
    }
    
    self.showArrivalSuggestions = function (arrival) {
      $http({
        url: 'getSuggestions/', 
        method: "GET",
        params: {location: arrival}
     }).then(function(response) {
        self.arrivalSuggestions = response.data;
        console.log(response.data);
      })
    }
    
    self.updateArrival = function (suggestion) {
      self.arrival = suggestion;
      self.arrivalSuggestions = [];
    }
  })
