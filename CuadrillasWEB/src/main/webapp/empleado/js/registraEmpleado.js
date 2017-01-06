var app = angular.module('tatei', []);
app.controller('registraEmpleado', function ($scope, $http) {
	   
$scope.empleado = {};
	   $scope.datoempleado = [];
	   
	   $scope.registrar = function(empleado) {
	   $scope.datoempleado.push(empleado);
	   console.log($scope.datoempleado);
	   $scope.nombre = empleado.nombre;
	   $scope.apellidoPaterno = empleado.apellidoPat;
	   $scope.apellidoMaterno = empleado.apellidoMat;
	   $scope.sexo = empleado.sexo;
	   $scope.rfc = empleado.rfc;
	   $scope.fechaIngreso = empleado.fechaIngreso;
	   $http.post("http://localhost:8080/CuadrillasWEB/RegistraEmpleado?" + "nombre=" + $scope.nombre +"&apellidoPat="+$scope.apellidoPaterno
		   ).success(function (dataSitio) {
	    	 $scope.items = dataSitio;
	    	
		      });
	   }
	   
	   
	 });
