'use strict';

angular.module('belajarNfcappApp')
  .controller('CustomerCtrl', function ($scope, $http, $filter, $timeout, customerservice) {
  	$scope.customers = {};
    $scope.opentanggalLahir = function($event) {
        $event.preventDefault();
        $event.stopPropagation();  
        $scope.openedtanggalLahir = true;
    };

  $scope.loadCustomers = function(){
   	customerservice.query().success(function(data){
   		$scope.customers = data;
   	});
  }

  $scope.loadCustomers();

  $scope.deleteCustomer = function(x){
    customerservice.remove(x).success(function(){
        $scope.loadCustomers();
        alert("data berhasil di hapus");
    }).error(function(){
        alert("data gagal di hapus");
    });
  }

 	$scope.saveCustomer = function(x){
      console.log('x id :', x.id);
      if(x.id == null){
          console.log('save null');
          if ($scope.fileFoto != null) {
            var dateFormat = $filter('date')($scope.currentCustomer.tanggalLahir, 'yyyy-MM-dd');
            var fd = new FormData();
            fd.append('foto', $scope.fileFoto);
            fd.append('nama', $scope.currentCustomer.nama);
            fd.append('email', $scope.currentCustomer.email);
            fd.append('alamat', $scope.currentCustomer.alamat);
            fd.append('tanggalLahir', dateFormat);
            customerservice.save(fd, null).success(function () {
              $scope.loadCustomers();
              alert("data berhasil disimpan..");
            });
        }
      }else {
          console.log('save not null');
          if ($scope.fileFoto != null) {
              var dateFormat = $filter('date')(x.tanggalLahir, 'yyyy-MM-dd');
              var fd = new FormData();
              fd.append('foto', $scope.fileFoto);
              fd.append('nama', x.nama);
              fd.append('email', x.email);
              fd.append('alamat', x.alamat);
              fd.append('tanggalLahir', dateFormat);
              customerservice.save(fd, x.id).success(function () {
                $scope.loadCustomers();
                alert("data berhasil disimpan..");
              });
          }
      }
        
  }

  $scope.clearForm = function(){
      $scope.currentCustomer = "";
      document.getElementById("fileFoto").value = "";
  }

  $scope.editCustomer = function(data){
    $scope.currentCustomer = data;
  }

  }); 
