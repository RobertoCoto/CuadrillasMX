var app = angular.module('tatei', []);
app.controller('adminDatos', function ($scope, $http) { 
	
			$http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralUsuario',
            data: { }
		    }).then(function (result) {
		    	$scope.resultadoAdmin = result.data.lista;
	            console.log($scope.resultadoAdmin);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
			 
		    $scope.actualizar = function(usuario) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/RecuperaContrasena',
		              params: {
				 		"contrasenaNueva": document.getElementById("contraNueva").value,
				 		"repiteContrasena": document.getElementById("repetirContraNueva").value,
				 		"idEmpleado": document.getElementById("idEmpleado").value
				         }
				    }).then(function mySucces(response) {
	                	  // $scope.editingData[catalogo.codigo] = false;
	                         console.info(response);
	                   }, function myError(response) {
	                       console.error(response);
	                       alert(response.data.mensajeFuncional);
	                       //$scope.resultado2.push(objecto);
	                   });
		    	};
		    

});