var app = angular.module('tatei', []);
app.controller('registraPermiso', function ($scope, $http) {
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
	 		"idEmpleado" : $scope.get.idEmpleado
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
		              "tipoPermiso" : document.getElementById("permisoCodigo").value,
				 		"usuario" : 'SISTEMAS'
				         }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	}
		    
});
