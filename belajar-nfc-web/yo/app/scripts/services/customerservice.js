'use strict';

angular.module('belajarNfcappApp')
  .factory('customerservice', function ($http, ConfigService) {
    return {
      query: function(){ 
      	  return $http({method: 'GET', url: ConfigService.serverUrl + '/customer/'}); 
      },
      save: function(obj, id){
          if(id == null){
              var uploadUrl = ConfigService.serverUrl +'/customer/null';
              return $http.post(uploadUrl, obj, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                      });
          } else {
              var uploadUrl = ConfigService.serverUrl +'/customer/'+ id;
              return $http.post(uploadUrl, obj, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                      });
          }
      },
      remove: function(obj){
          if(obj.id != null){
              return $http.delete(ConfigService.serverUrl +"/customer/"+ obj.id);
          }
      },
      cekStatus: function(id){ 
          return $http({method: 'GET', url: ConfigService.serverUrl + '/customer/print/card/' +id}); 
      },
    }
  });
