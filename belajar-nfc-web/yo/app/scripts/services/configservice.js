'use strict';

angular.module('belajarNfcappApp')
  .factory('ConfigService', function ($location) {
    var proto = $location.protocol();
    var host = $location.host();
    // var port = $location.port();
    var port = "8080";
    var server = proto+'://'+host+":"+port;
    var urlApi = server+"/belajar-nfc-server/api";
    return {
        server: server,
        serverUrl: urlApi
    };
  });
