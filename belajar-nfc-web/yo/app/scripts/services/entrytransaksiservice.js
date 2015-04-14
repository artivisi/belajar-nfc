'use strict';

angular.module('belajarNfcappApp')
  .factory('entrytransaksiservice', function ($http) {
    return{
      query : function(){
          return $http.get('http://localhost:10000/api/entriTransaksi');
      },
      findOne : function(id){
          return $http.get('http://localhost:10000/api/entriTransaksi/' + id);
      },
      save : function (obj){
          if(obj.id == null){
              return $http.post('http://localhost:10000/api/entriTransaksi/', obj);
          } else {
              return $http.put('http://localhost:10000/api/entriTransaksi/' + obj.id, obj);
          }
      },
      remove : function (id){
          if(id != null){
              return $http.delete('http://localhost:10000/api/entriTransaksi/' + id);
        }
      }
    };
  });
