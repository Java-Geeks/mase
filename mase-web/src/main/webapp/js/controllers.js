'use strict';

/* Controllers */

var maseControllers = angular.module('maseAppControllers', []);

/* Navigation bar controller */
maseControllers.controller('HeaderCtrl', ['$scope', '$location', function($scope, $location) {
  $scope.isActive = function (viewLocation) {
  	return viewLocation === $location.path();
  }
}]);

/* Welcome controller */
maseControllers.controller('HomeCtrl', ['$scope', function($scope) {
	
}]);

/* Login controller */
maseControllers.controller('LoginCtrl', ['$scope', '$location', 'UserService', function($scope, $location, UserService) {
	$scope.authenticationError = false;
	
	$scope.loginUser = function() {
		var param = { 
				email: $scope.email,
	      password: $scope.password
	  };
		UserService.login(param, 
      function success () {
        $location.path("/");
      }, function error () {
      	console.log("[LoginCtrl] Error login");
      	$scope.authenticationError = true;
      }
    );
	};
}]);

/* Register controller */
maseControllers.controller('RegisterCtrl', ['$scope', 'Account', function($scope, Account) {
	$scope.success = null;
	$scope.authenticationError = null;
	$scope.doNotMatch = null;
	$scope.registerUser = function() {
			if ($scope.user.password != $scope.confirmPassword) {
				$scope.doNotMatch = "ERROR";
			} else {
				$scope.doNotMatch = null;
				Account.save($scope.user,
						function (value, responseHeaders) {
							$scope.success = "OK";
							$scope.authenticationError = null;
							$scope.user = null;
							$scope.confirmPassword = null;
						},
						function (httpResponse) {
							$scope.authenticationError = "ERROR";
							$scope.success = null;
						}
				);
			}
	};
}]);

/* Todo list controller */
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
  
  $scope.updateTodo = function(todo) {
    todo.$update();
  };
}]);

