var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl : 'pages/Configuration.html',
  })
  .otherwise({redirectTo: '/'});
});