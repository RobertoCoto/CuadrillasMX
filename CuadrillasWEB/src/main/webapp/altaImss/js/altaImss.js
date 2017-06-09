var app = angular.module('tatei', []);
app.controller('altaImss', function ($scope, $http, $window) {
	$scope.imss = $window.idImss;
	$scope.usuario = $window.user;
		
    //Consulta el empleado solicitado por id
 $http({
        method: 'GET',
        url: '/CuadrillasWEB/ConsultaEmpleado',
        params: {
	 		"idEmpleado" : $scope.imss
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
            url: '/CuadrillasWEB/NotificaImss',
            params: {
		 		"idEmpleado" : $scope.imss,
		 		"usuario": $scope.usuario
		         }
		    }).then(function mySucces(response) {
		    	 alert(response.data.mensajeFuncional);
		    	 console.info(response);
		    	// opener.top.location.reload();
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		    });
 	 
 		 };
 	 
	});
