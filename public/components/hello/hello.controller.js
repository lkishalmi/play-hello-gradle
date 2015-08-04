(function() {

	'use strict';

	angular.module('hello').controller('HelloCtrl', HelloCtrl);

	HelloCtrl.$inject = [ '$scope' , 'message' ];

	function HelloCtrl($scope, message) {
		$scope.message = message.value;
	}
}());
