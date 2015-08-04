(function() {

	'use strict';
	
	angular.module('hello', [ 'ngResource', 'ngRoute' ])
	.config( function( $routeProvider) {
		
		$routeProvider.when( '/', {
	        templateUrl : 'html/hello.tmpl.html',
	        controller : 'HelloCtrl',
	        resolve: {
	            message: function(helloService){
	                return helloService.get().$promise;
	            }
	        }
	    }).otherwise( '/' );
	})
}());
