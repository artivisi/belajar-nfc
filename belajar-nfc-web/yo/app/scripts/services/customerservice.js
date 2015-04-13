'use strict';

angular.module('belajarNfcappApp')
  .factory('customerservice', function ($http) {
    return {
      query: function(){ 
      	  return $http.get('http://localhost:10000/api/customer/');
      },
      save: function(obj){
          if(obj.id == null){
              return $http.post('http://localhost:10000/api/customer/', obj);
          } else {
              return $http.put('http://localhost:10000/api/customer/'+obj.id, obj);
          }
      },
      remove: function(obj){
          if(obj.id != null){
              return $http.delete('http://localhost:10000/api/customer/'+obj.id);
          }
      }
    };
  });
