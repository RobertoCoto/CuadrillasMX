var app = angular.module('tatei', []);
app.controller('altaImss', function ($scope, $http) {
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
		
    //Consulta el empleado solicitado por id
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
 
	    //para dar de alta el imss
 	 $scope.alta = function(imss) {
 		var confirmar = confirm("¿Esta seguro de notificar al imss?"); 

 			if (!confirmar) 
 				{
 					alert('se ha cancelado la operacion.'); 
			return false;
 				} 	
 		$http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWEB/NotificaImss',
            params: {
		 		"idEmpleado" : $scope.get.idEmpleado,
		 		"usuario": "SISTEMAS"
		         }
		    }).then(function mySucces(response) {
		    	 alert(response.data.mensajeFuncional);
		    	 console.info(response);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		    });
 	 
 		 };
 	 
	});
