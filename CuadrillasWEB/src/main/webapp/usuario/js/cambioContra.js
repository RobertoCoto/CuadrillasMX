var app = angular.module('tatei', []);
app.controller('cambioDatos', function ($scope, $http) {  
	$http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaUsuarioLogin',
              params: {
		 		"user": "rcoto",
		 		"password": "rcoto"
		         }
		    }).then(function (result) {
		    	$scope.resultadoUsuario = result.data.usuario;
	            console.log($scope.resultadoUsuario);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });

});