'use strict';


// Declare app level module which depends on filters, and services
var maseApp = angular.module('maseApp', [
  'ngRoute',
  'maseAppControllers',
  'maseAppFilters',
  'maseAppServices',
  'maseAppDirectives'
]);

maseApp.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	$httpProvider.responseInterceptors.push('httpInterceptor');

	$routeProvider.when('/', {templateUrl: 'partials/home.html', controller: 'HomeCtrl'});
	$routeProvider.when('/register', {templateUrl: 'partials/register.html', controller: 'RegisterCtrl'});
	$routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginCtrl'});
  $routeProvider.when('/todos', {templateUrl: 'partials/todo-list.html', controller: 'TodoListCtrl'});
  $routeProvider.otherwise({redirectTo: '/'});
}]);
