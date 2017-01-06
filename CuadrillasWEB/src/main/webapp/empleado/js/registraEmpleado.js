var app = angular.module('tatei', []);
app.controller('registraEmpleado', function ($scope, $http) {
	   
$scope.empleado = {};
	   $scope.datoempleado = [];
	   
	   $scope.registrar = function(empleado) {
	   $scope.datoempleado.push(empleado);
	   console.log($scope.datoempleado);
	   }
	   
	 });
