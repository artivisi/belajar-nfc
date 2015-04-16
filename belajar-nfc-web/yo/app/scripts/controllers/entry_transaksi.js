'use strict';

angular.module('belajarNfcappApp')
  .controller('EntryTransaksiCtrl', function ($scope, entrytransaksiservice, customerservice) {
    $scope.transactions = {};
    $scope.customers = {};
    $scope.currentEntryTransaction = {};

    $scope.reloadCustomer = function (){
    	customerservice.query().success(function(data){
    		$scope.customers = data.content;
    	});
    }

    $scope.reloadTransaction = function(){
	    entrytransaksiservice.query().success(function(data){
	 		$scope.transactions = data;
	 	});	
    }
    
    $scope.openTanggal = function($event) {
        $event.preventDefault();
        $event.stopPropagation();  
        $scope.tanggalIsOpened = true;
    }

    $scope.edit = function (selectedTransaction) {
        $scope.currentEntryTransaction = selectedTransaction;
        $scope.original = angular.copy($scope.currentEntryTransaction);
    }

    $scope.clearForm = function(){
    	$scope.currentEntryTransaction = {};
    }

    $scope.delete = function(x){
	    bootbox.confirm('Apakah anda yakin akan menghapus ?', function(result) {
	        if(result){
	            entrytransaksiservice.remove(x.id)
            		.success(function(){
            			bootbox.alert('Data berhasil dihapus');
            		})
            		.error(function() {
            			bootbox.alert('Data gagal dihapus');
            		});
        		$scope.reloadTransaction();
	        }
	    }); 
	};

	$scope.save = function(x){
		$scope.currentEntryTransaction.tanggal = new Date();
		entrytransaksiservice.save(x)
			.success(function() {
				bootbox.alert('Data berhasil disimpan');
			})
			.error(function (){
				bootbox.alert('Data gagal disimpan');
			})
			$scope.reloadTransaction();
			$scope.clearForm();
	}    

    $scope.detail = function(){
        $('#detailtransaksi').modal('show');
    }

    $scope.reloadCustomer();
    $scope.reloadTransaction();

  });
