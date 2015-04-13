'use strict';

angular.module('belajarNfcappApp')
  .controller('CustomerCtrl', function ($scope, $http, customerservice) {
  	$scope.customers = {};
    $scope.opentanggalLahir = function($event) {
        $event.preventDefault();
        $event.stopPropagation();  
        $scope.openedtanggalLahir = true;
    };

 	customerservice.query().success(function(data){
 		$scope.customers = data;
 	});

 	$scope.deleteCustomer = function(x){
 		customerservice.remove(x).success(function(){
			alert("data berhasil di hapus");
 		}).error(function(){
			alert("data gagal di hapus");
 		})
 	}

  });