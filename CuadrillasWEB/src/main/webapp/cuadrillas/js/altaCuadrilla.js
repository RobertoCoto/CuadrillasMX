var app = angular.module('tatei', []);
app.controller('adminCuad', function ($scope, $http) {
	
 $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'VIALIDAD'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultado = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
	});
