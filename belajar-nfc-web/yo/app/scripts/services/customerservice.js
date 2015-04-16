'use strict';

angular.module('belajarNfcappApp')
  .factory('customerservice', function ($http, ConfigService) {
    return {
      query: function(){ 
      	  return $http({method: 'GET', url: ConfigService.serverUrl + '/customer/'}); 
      },
      save: function(obj, id){
          if(id == null){
              console.log('service x id :', id);
              var uploadUrl = ConfigService.serverUrl +'/customer';
              return $http.post(uploadUrl, obj, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                      });
          } else {
              console.log('service x id not null:', id);
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
      }
    }
  });
