(function() {

	'use strict';

	angular.module('hello').factory('helloService', helloService);

	function helloService($resource) {

		return $resource('/hello');
	}

}());