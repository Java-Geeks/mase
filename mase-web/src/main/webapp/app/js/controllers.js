'use strict';

/* Controllers */

var maseControllers = angular.module('maseAppControllers', []);

maseControllers.controller('TodoListCtrl', ['$scope', 'Todo', function ($scope, Todo) {
  $scope.todos = Todo.query();
  
  $scope.createTodo = function(todo) {
	  var saveTodo = new Todo(todo);
	  saveTodo.$save(
	    function success (createdTodo, putResponseHeaders) {
		  $scope.todos.push(createdTodo);
		  $scope.newTodo = "";
		}, function error (httpResponse) {
			console.log("Error while creating new todo !");
		});
	 
  };
  
  $scope.deleteTodo = function(todo) {
	todo.$delete(
	  function success(deletedTodo, responseHeaders) {
		$scope.todos.splice($scope.todos.indexOf(deletedTodo), 1);
		}, function error(httpResponse) {
			console.log("Error while deleting todo with id : " + todo.id); 
		});
  };
}]);