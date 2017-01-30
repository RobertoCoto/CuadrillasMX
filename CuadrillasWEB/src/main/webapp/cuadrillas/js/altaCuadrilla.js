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
 
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCuadrilla',
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoCuadrilla = result.data.cuadrilla;
	              console.log($scope.resultadoCuadrilla);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
		    
		    $scope.registrar = function(cuadrilla) {
		    	
		    	 $http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AltaCuadrilla',
		              params: {
		    		 "idCuadrilla" : document.getElementById("numeroCuadrilla").value,
		    		 "nombreCuadrilla" : document.getElementById("nombre").value,
		    		 "calificacion" : document.getElementById("calificacion").value,
		    		 "usuario" : "SISTEMAS"
		    		 
		    	 }
				    }).then(function mySucces(result) {
				    	$scope.resultadoCuadrilla = result.data.cuadrilla;
			              console.log($scope.resultadoCuadrilla);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
				        //$scope.resultado2.push(objecto);
				    });
		    	};
		    
	});
