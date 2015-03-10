'use strict';

angular.module('belajarNfcappApp')
  .factory('customerservice', function () {
    // Service logic
    // ...

    var meaningOfLife = 42;

    // Public API here
    return {
      someMethod: function () {
        return meaningOfLife;
      }
    };
  });
