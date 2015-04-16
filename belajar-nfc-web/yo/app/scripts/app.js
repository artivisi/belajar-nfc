'use strict';

/**
 * @ngdoc overview
 * @name belajarNfcappApp
 * @description
 * # belajarNfcappApp
 *
 * Main module of the application.
 */
angular
  .module('belajarNfcappApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'file-model',
    'ui.bootstrap',
    'base64'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/master/customer', {
        templateUrl: 'views/customer.html',
        controller: 'CustomerCtrl'
      })
      .when('/transaksi/entriTransaksi', {
        templateUrl: 'views/entri_transaksi.html',
        controller: 'EntryTransaksiCtrl'
      })
      .when('/laporan/transaksi', {
        templateUrl: 'views/laporantransaksi.html',
        controller: 'LaporantransaksiCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
