var app = angular.module('tatei', []);
app.controller('entradaAsistencia', function ($scope, $http) {  
	
	$http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
              params: {
		 		"idEmpleado" : '1'
		         },
              data: { }
		    }).then(function (result) {
		    	$scope.resultado = result.data.empleado;
	            console.log($scope.resultado);
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