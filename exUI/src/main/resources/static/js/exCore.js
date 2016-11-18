var exApp = angular.module('exApp', ['ngRoute']);

exApp.config(function($routeProvider) {
	  $routeProvider
	  .when('/', {
	    templateUrl : 'pages/Configuration.html',
	  })
	  .when('/blog', {
	    templateUrl : 'pages/blog.html',
	  })
	  .otherwise({redirectTo: '/'});
});

exApp.controller('ConfigController', function($scope) {
	  $scope.message = 'Hello from ConfigController';
});

exApp.controller('BlogController', function($scope) {
	  $scope.message = 'Hello from BlogController';
});