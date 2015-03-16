'use strict';

describe('Service: entrytransaksiservice', function () {

  // load the service's module
  beforeEach(module('belajarnfcappApp'));

  // instantiate service
  var entrytransaksiservice;
  beforeEach(inject(function (_entrytransaksiservice_) {
    entrytransaksiservice = _entrytransaksiservice_;
  }));

  it('should do something', function () {
    expect(!!entrytransaksiservice).toBe(true);
  });

});
