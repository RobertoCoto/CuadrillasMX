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
	   $scope.fechaNacimiento = empleado.fechaNacimiento;
	   $scope.fechaIngreso = empleado.fechaIngreso;
	   $scope.codigoPuesto = empleado.puesto;
	   $scope.codigoVialidad = empleado.codigoVialidad;
	   $scope.codigoArea = empleado.codigoArea;
	   $scope.codigoTalla = empleado.codigoTalla;
	   $scope.idCuadrilla = empleado.idCuadrilla;
	   $scope.sueldo  = empleado.sueldo;
	   $scope.frecuenciaPago = empleado.tipoPago;
	   $scope.nss = empleado.nss;
	   $scope.telefono = empleado.telefono;
	   $scope.noCreditoInfonavit = empleado.infonavit;
	   $scope.observaciones = empleado.comentarios;
	   $scope.usuario = empleado.usuario;
	   
	   $http.get("http://localhost:8080/CuadrillasWEB/RegistraEmpleado?" + "nombre=" + $scope.nombre +"&apellidoPat="+$scope.apellidoPaterno +"&apellidoMat="
		 +$scope.apellidoMaterno +"&sexo=" + $scope.sexo + "&rfc=" + $scope.rfc + "&fechaNacimiento=" + $scope.fechaNacimiento + "&fechaIngreso="
		 + $scope.fechaIngreso + "&codigoPuesto=" + $scope.codigoPuesto + "&codigoVialidad =" + $scope.codigoVialidad + "&codigoTalla=" + $scope.codigoTalla
		 + "&idCuadrilla=" +$scope.idCuadrilla + "&sueldo=" +$scope.sueldo +"&frecuenciaPago=" + $scope.frecuenciaPago + "&nss=" +$scope.nss 
		 + "&telefono=" + $scope.telefono + "&noCreditoInfonavit=" + $scope.noCreditoInfonavit + "&observaciones=" +$scope.observaciones).success(function (dataSitio) {
	    	 $scope.items = dataSitio;
	    	
		      });
	   }
	   
	   
	 });
