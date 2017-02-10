var app = angular.module('tatei', []);
app.controller('autorizacionLaboral', function ($scope, $http) {

	//obtener el id enviado por GET
	   $scope.obtainGet = function getGET(){
		   var loc = document.location.href;
		   var getString = loc.split('?')[1];
		   var GET = getString.split('&');
		   var get = {};

		   for(var i = 0, l = GET.length; i < l; i++){
		      var tmp = GET[i].split('=');
		      get[tmp[0]] = unescape(decodeURI(tmp[1]));
		   }
		   return get;
		};
		$scope.get = $scope.obtainGet();


	
	$http({
        method: 'GET',
        url: 'http://localhost:8080/CuadrillasWEB/ConsultaPermisoTemporal',
        params: {
	 		"idEmpleado" : $scope.get.idEmpleado
	         },
        data: { }
	    }).then(function (result) {
	    	$scope.resultado = result.data.permiso;
	    	
          console.log($scope.resultado);
        
	    }, function myError(response) {
	        console.error(response);
	        alert(response.data.header.mensajeFuncional);
	    });
	
	    $http({
	        method: 'GET',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
	        params: {
		 		"idEmpleado" : $scope.get.idEmpleado
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
