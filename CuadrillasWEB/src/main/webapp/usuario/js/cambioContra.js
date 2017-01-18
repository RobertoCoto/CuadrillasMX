var app = angular.module('tatei', []);
app.controller('cambioDatos', function ($scope, $http) {  
	$scope.iniciar = function (user) {
		$http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWEB/ConsultaUsuarioLogin',
            params: {
		 		"user": document.getElementById("us").value,
		 		"password": document.getElementById("pass").value
		         }
		    }).then(function (result) {
		    	$scope.resultadoUsuario = result.data.usuario;
	            console.log($scope.resultadoUsuario);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
		}
	
	

		    $scope.actualizar = function(user) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/CambioContrasena',
		              params: {
				 		"contrasenaAnterior": document.getElementById("contraAnterior").value,
				 		"contrasenaNueva": document.getElementById("contraNueva").value,
		              "repiteContrasena": document.getElementById("repetirContraNueva").value,
		              "user": document.getElementById("usuario").value
				         }
				    }).then(function (result) {
				    	$scope.resultadoUsuario = result.data.usuario;
			            console.log($scope.resultadoUsuario);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
				    });
		    }
		    
});