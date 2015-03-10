'use strict';

angular.module('belajarNfcappApp')
  .controller('CustomerCtrl', function ($scope) {

    $scope.opentanggalLahir = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        
        $scope.openedtanggalLahir = true;
    };
    
  });
