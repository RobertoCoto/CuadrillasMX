var app = angular.module('tatei', []);
app.controller('registraPermiso', function ($scope, $http) {
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
	
	    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'PERMI_LABO'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoLaboral = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
		    $scope.datoPermiso = [];
		    $scope.registrar = function(permiso) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/RegistraPermiso',
		              params: {
				 		"idEmpleado" : document.getElementById("idEmpleado").value,
				 		"comentario" : document.getElementById("comentario").value,
				 		"fechaSolicitudMinima" : document.getElementById("fechaSolicitudMinima").value,
		              "fechaSolicitudMaxima" : document.getElementById("fechaSolicitudMaxima").value,
		              "horaSolicitudMinima" : document.getElementById("horaSolicitudMinima").value,
		              "horaSolicitudMaxima" : document.getElementById("horaSolicitudMaxima").value,
		              "tipoPermiso" : permiso.codigo,
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
