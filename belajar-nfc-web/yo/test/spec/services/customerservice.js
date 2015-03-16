'use strict';

describe('Service: customerservice', function () {

  // load the service's module
  beforeEach(module('belajarnfcappApp'));

  // instantiate service
  var customerservice;
  beforeEach(inject(function (_customerservice_) {
    customerservice = _customerservice_;
  }));

  it('should do something', function () {
    expect(!!customerservice).toBe(true);
  });

});
