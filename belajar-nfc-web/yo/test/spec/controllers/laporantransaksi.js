'use strict';

describe('Controller: LaporantransaksiCtrl', function () {

  // load the controller's module
  beforeEach(module('belajarnfcappApp'));

  var LaporantransaksiCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LaporantransaksiCtrl = $controller('LaporantransaksiCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
