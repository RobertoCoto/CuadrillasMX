var app = angular.module('tatei', []);

app.controller('cambioDatos',["$scope","$http", function ($scope,$http) {  
	
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
            url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
            params: {
		 		"idEmpleado": $scope.get.idEmpleado,
		         }
		    }).then(function (result) {
		    	$scope.resultadoEmpleado = result.data.empleado;
	            console.log($scope.resultadoEmpleado);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
    
		    $scope.actualizar = function(user) {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/CambioContrasena',
		              params: {
		    			"contrasena" : document.getElementById("contra").value,
				 		"contrasenaAnterior": document.getElementById("contraAnterior").value,
				 		"contrasenaNueva": document.getElementById("contraNueva").value,
				 		"repiteContrasena": document.getElementById("repetirContraNueva").value,
				 		"idEmpleado": document.getElementById("idEmpleado").value
				         }
				    }).then(function (result) {
				    	$scope.resultadoUsuario = result.data.usuario;
			            console.log($scope.resultadoUsuario);
			            
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    }
		    
}]);