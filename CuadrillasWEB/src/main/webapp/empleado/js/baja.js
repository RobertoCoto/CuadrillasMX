var app = angular.module('tatei', []);
app.controller('bajaEmpleado', function ($scope, $http) {
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
		 		"tipoCatalogo": 'TIPO_SALID'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoSalida = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
	     
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'CAUSA_RENU'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoRenuncia = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
		    
		    $scope.grabar = function(empleado) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/BajaEmpleado',
		              params : {
				 		"usuario": 'SISTEMAS',
				 		"comentario": document.getElementById("comentario").value,
				 		"codigoTipoSalida": empleado.codigoTipoSalida,
				 		"codigoCausaSalida": empleado.codigoCausaSalida,
		              "idEmpleado": document.getElementById("idEmpleado").value
				 }
				    }).then(function mySucces(result) {
				    	$scope.resultadoRenuncia = result.data.catalogo;
			              console.log(result);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
				        //$scope.resultado2.push(objecto);
				    });
		    	}
		    
});