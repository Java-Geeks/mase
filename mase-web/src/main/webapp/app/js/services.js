'use strict';

/* Services */

var maseServices = angular.module('maseAppServices', ['ngResource']);

var baseUrl = 'http://localhost\\:9100';

maseServices.factory('Todo', ['$resource',
  function($resource){
    return $resource(baseUrl + '/mase-ws/todos/:id', {id : '@id'},
    	{ 'update': {method: 'PUT'} }
    );
}]);

maseServices.factory('httpInterceptor', function httpInterceptor ($q, $window, $location) {
  return function (promise) {
      var success = function (response) {
          return response;
      };

      var error = function (response) {
          if (response.status === 401) {
              $location.url('/login');
          }

          return $q.reject(response);
      };

      return promise.then(success, error);
  };
});