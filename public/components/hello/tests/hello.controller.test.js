describe('HelloCtrl', function() {

	var $controller;
	var $scope;
	var expectedMessage = {'value' : 'Hello World!'};

	beforeEach(module('hello'));

	beforeEach(inject(function(_$controller_, _$rootScope_) {
		$controller = _$controller_;
		$scope = _$rootScope_.$new();
	}));

	beforeEach(function() {
		$controller('HelloCtrl', { $scope: $scope, message: expectedMessage});
	});

	it('Message should be Hello World!', function() {
		expect($scope.message).toEqual(expectedMessage.value);
	});
});