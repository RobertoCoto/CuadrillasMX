var app = angular.module('tatei', []);
app.controller('buzon', function ($scope, $http) {
	//Consulta todas las tareas pendientes
	 $http({
	        method: 'GET',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaTareas',
	        data: { }
		    }).then(function (result) {
		    	$scope.resultado = result.data.buzon;
	          console.log($scope.resultado);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
	 
	});
