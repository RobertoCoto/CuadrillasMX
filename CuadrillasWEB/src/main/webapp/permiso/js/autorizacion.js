var app = angular.module('tatei', []);
app.controller('autorizacionLaboral', function ($scope, $http) {
	$scope.idRecibido= '1';
	$http({
        method: 'GET',
        url: 'http://localhost:8080/CuadrillasWEB/ConsultaPermisoTemporal',
        params: {
	 		"idEmpleado" : $scope.idRecibido
	         },
        data: { }
	    }).then(function (result) {
	    	$scope.resultado = result.data.permiso;
	    	$scope.idEmp = result.data.permiso.idEmpleado;
          console.log($scope.resultado);
          console.log($scope.idEmp);
	    }, function myError(response) {
	        console.error(response);
	        alert(response.data.header.mensajeFuncional);
	    });
	
	    $http({
	        method: 'GET',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
	        params: {
		 		"idEmpleado" : $scope.idRecibido
		         },
	        data: { }
		    }).then(function (result) {
		    	$scope.resultadoEmpleado = result.data.empleado;
	          console.log($scope.resultadoEmpleado);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
	        $scope.permiso = {};
		     $scope.aceptar = function(permiso) {
		    	 
		    	 var checkSueldo = document.getElementById("goce");
		    	 
		    	 if(checkSueldo.checked == true) {
		    	       $scope.goce = "S";	 
		    	 } else if(checkSueldo.checked == false) {
		    		 $scope.goce = "N";
		    	 }
		    	 
		    	 
		    	 
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
		              params: {
				 		"idPermiso" : document.getElementById("idPermiso").value,
				 		"idEmpleado" : document.getElementById("idEmpleado").value,
				 		"comentario" : document.getElementById("comentario").value,
				 		"goceSueldo" : $scope.goce,
				 		"estatusAutorizacion": "S",
				 		"usuario": "SISTEMAS"
				         }
				    }).then(function mySucces(response) {
				    	 console.info(response);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
				    });
		    	
		    	}
		    
		     $scope.rechazar = function(permiso) {
				    	$http({
				              method: 'GET',
				              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
				    	 params: {
					 		"idPermiso" : document.getElementById("idPermiso").value,
					 		"idEmpleado" : document.getElementById("idEmpleado").value,
					 		"comentario" : document.getElementById("comentario").value,
					 		"goceSueldo" : "N",
					 		"estatusAutorizacion": "N",
					 		"usuario": "SISTEMAS"
					         }
						    }).then(function mySucces(response) {
						    	 console.info(response);
						    }, function myError(response) {
						        console.error(response);
						        alert(response.data.header.mensajeFuncional);
						    });
				    	}
	});
