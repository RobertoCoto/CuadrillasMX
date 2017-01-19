var app = angular.module('tatei', []);
app.controller('cambioDatos', function ($scope, $http) {  
	
	$http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
            params: {
		 		"idEmpleado": "1",
		         }
		    }).then(function (result) {
		    	$scope.resultadoEmpleado = result.data.empleado;
	            console.log($scope.resultadoEmpleado);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
	

		    $scope.actualizar = function(user) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/CambioContrasena',
		              params: {
		    			"contrasena" : document.getElementById("contra").value,
				 		"contrasenaAnterior": document.getElementById("contraAnterior").value,
				 		"contrasenaNueva": document.getElementById("contraNueva").value,
				 		"repiteContrasena": document.getElementById("repetirContraNueva").value,
				 		"idEmpleado": document.getElementById("idEmpleado").value
				         }
				    }).then(function (result) {
				    	$scope.resultadoUsuario = result.data.usuario;
			            console.log($scope.resultadoUsuario);
			            
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    }
		    
});