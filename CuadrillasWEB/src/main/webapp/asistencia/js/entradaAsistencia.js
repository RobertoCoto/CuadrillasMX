var app = angular.module('tatei', []);
app.controller('entradaAsistencia', function ($scope, $http) {  
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
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaAsistencia',
              params: {
            	  "idCuadrilla" : $scope.get.idCuadrilla
              },
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
            
           $scope.entrada = function(asistencia) {
        	   
           $scope.idEmpleado = asistencia.idEmpleado;
           $scope.comentario = document.getElementById("comentario").value;
           
           if($scope.comentario == "") {
        	   return false
        	   }
           
        		$http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWEB/EntradaAsistencia',
                    params: {
      		 		"idEmpleado" : $scope.idEmpleado,
      		 		"comentarios" : document.getElementById("comentario").value,
      		 		"usuario" : 'SISTEMAS'
      		         }
      		    }).then(function mySucces(response) {
      		    	 alert(response.data.mensajeFuncional);
      		    	 console.info(response);
      		    	location.reload();
      		    }, function myError(response) {
      		        console.error(response);
      		        alert(response.data.mensajeFuncional);
      		    });
        	   };
           
            $scope.salida = function(asistencia) {
            	
              $scope.idEmpleado = asistencia.idEmpleado;
        		$http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWEB/SalidaAsistencia',
                    params: {
      		 		"idEmpleado" : $scope.idEmpleado,
      		 		"usuario" : 'SISTEMAS'
      		         }
      		    }).then(function mySucces(response) {
      		    	alert(response.data.mensajeFuncional);
     		    	 console.info(response);
     		    	location.reload();
      		    }, function myError(response) {
      		        console.error(response);
      		        alert(response.data.header.mensajeFuncional);
      		    });
        	   };
           
});