'use strict';


// Declare app level module which depends on filters, and services
var maseApp = angular.module('maseApp', [
  'ngRoute',
  'maseAppControllers',
  'maseAppFilters',
  'maseAppServices',
  'maseAppDirectives'
]);

maseApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/todos', {templateUrl: 'partials/todo-list.html', controller: 'TodoListCtrl'});
  $routeProvider.otherwise({redirectTo: '/todos'});
}]);
