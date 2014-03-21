'use strict';

/* Controllers */

var maseControllers = angular.module('maseAppControllers', []);

maseControllers.controller('TodoListCtrl', ['$scope', 'Todo', function ($scope, Todo) {
  $scope.todos = Todo.query();
}]);