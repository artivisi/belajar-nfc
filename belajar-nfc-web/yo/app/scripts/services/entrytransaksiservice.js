'use strict';

angular.module('belajarNfcappApp')
  .factory('entrytransaksiservice', function ($http, ConfigService) {
    return{
      query : function(){
          return $http.get(ConfigService.serverUrl +'/entriTransaksi');
      },
      findOne : function(id){
          return $http.get(ConfigService.serverUrl +'/entriTransaksi/'+ id);
      },
      save : function (obj){
          if(obj.id == null){
              return $http.post( ConfigService.serverUrl +'/entriTransaksi/', obj);
          } else {
              return $http.put( ConfigService.serverUrl +'/entriTransaksi/' + obj.id, obj);
          }
      },
      remove : function (id){
          if(id != null){
              return $http.delete( ConfigService.serverUrl +'/entriTransaksi/' + id);
              return $http.delete( ConfigService.serverUrl +'/entriTransaksi/laporan?sdate=' + sdate + "&edate=");
        }
      },
      queryByDate : function (sdate, edate){
          if(sdate != null && edate != null){
              return $http.get(ConfigService.serverUrl +'/entriTransaksi/laporan?sdate='+ sdate +"&edate="+ edate);
          }
      }
    };
  });
