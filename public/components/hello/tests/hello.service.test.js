describe('helloService', function() {

	var mockResource, helloService, $resource;

	beforeEach(module('hello'));

	beforeEach(inject(function(_$injector_, _$q_) {
		$injector = _$injector_;
		$q = _$q_;
	}));

	beforeEach(inject(function() {

		mockResource = {
			get : function() {
				queryDeferred = $q.defer();
				return {
					$promise : queryDeferred.promise
				};
			}
		}

		spyOn(mockResource, 'get').and.callThrough();

		var helloServiceInst = $injector.get('helloService');
		helloService = new helloServiceInst(mockResource);
	}));

	it('Should return the delegated $resource.get()',
			function() {
				expect(helloService.get()).toEqual(mockResource.get());
			});
});
