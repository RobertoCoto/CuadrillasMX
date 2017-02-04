var app = angular.module('tatei', []);
app.controller('entradaAsistencia', function ($scope, $http) {  
	
	
	
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaAsistencia',
              data: { }
		    }).then(function (result) {
		    	$scope.resultadoAsistencia = result.data.asistencia;
	            console.log($scope.resultadoAsistencia);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
            
            $scope.datosAsistencia = [];
            
            $scope.registrar = function(asistencia) { 
            	
            	$http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/EntradaAsistencia',
              params: {
		 		"idEmpleado" : document.getElementById("idEmpleado").value,
		 		"comentarios" : asistencia.comentario,
		 		"usuario" : 'SISTEMAS'
		         }
		    }).then(function mySucces(response) {
		    	 console.info(response);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
            }
});