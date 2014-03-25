'use strict';

/* Services */

var maseServices = angular.module('maseAppServices', ['ngResource']);

var baseUrl = 'http://localhost\\:9100';

maseServices.factory('Todo', ['$resource',
  function($resource){
    return $resource(baseUrl + '/mase-ws/todos/:id', {id : '@id'});
}]);