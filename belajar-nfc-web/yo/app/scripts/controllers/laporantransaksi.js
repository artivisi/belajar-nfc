'use strict';

angular.module('belajarNfcappApp')
  .controller('LaporantransaksiCtrl', function ($scope, $filter, entrytransaksiservice) {
  	  $scope.listTransaksis = {};

	  $scope.today = function() {
	    $scope.startdate = new Date();
	    $scope.enddate = new Date();
	  };
	  $scope.today();

	  $scope.open1 = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();

	    $scope.opened1 = true;
	  };

	  $scope.open2 = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();

	    $scope.opened2 = true;
	  };

	  $scope.prosesLoadData = function(){
	  		var sdate, edate;
	  		sdate = $filter("date")($scope.startdate, "yyyy-MM-dd") ;
	  		edate = $filter("date")($scope.enddate, "yyyy-MM-dd") ;

	  		entrytransaksiservice.queryByDate(sdate, edate).success(function(data){
	  			if(data == ""){
	  				bootbox.alert("Data tidak ditemukan..!!"); 
	  				document.getElementById('hiddeShowProcess').style.display = "none";
	  			}else{ 
		  			$scope.listTransaksis = data;
		  			$scope.calculateData();
		  			document.getElementById('hiddeShowProcess').style.display = "";
	  			}
	  		});
	  }

	$scope.calculateData = function(){
		var total = 0;
		var data = $scope.listTransaksis;
		for (var i = 0; i <= data.length; i++) {
			if(data[i] != null){
				total += data[i].nilaiTransaksi;
			}
		}
		$scope.total = total;
	}

});