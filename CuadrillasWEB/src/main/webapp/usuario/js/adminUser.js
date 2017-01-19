var app = angular.module('tatei', []);
app.controller('adminDatos', function ($scope, $http) { 
	
			$http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralUsuario',
            data: { }
		    }).then(function (result) {
		    	$scope.resultadoAdmin = result.data.usuario;
	            console.log($scope.resultadoAdmin);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
});