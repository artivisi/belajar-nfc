'use strict';

angular.module('belajarNfcappApp')
  .factory('customerservice', function ($http, ConfigService) {
    return {
      query: function(){ 
      	  return $http({method: 'GET', url: ConfigService.serverUrl + '/customer/'}); 
      },
      save: function(obj){
          if(obj.id == null){
              var uploadUrl = ConfigService.serverUrl +'/customer';
              return $http.post(uploadUrl, obj, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                      });
          } else {
              return $http({method: 'PUT', url: ConfigService.serverUrl + '/customer/'+obj.id}, obj);
          }
      },
      remove: function(obj){
          if(obj.id != null){
              return $http({method: 'DELETE', url: ConfigService.serverUrl + "/customer/"+obj.id});
          }
      }
    }
  });
