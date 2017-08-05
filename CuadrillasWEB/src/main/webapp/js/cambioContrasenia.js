app.controller('cambioDatos',["$scope","$http", function ($scope,$http) {  
	
//	//obtener el id enviado por GET
//   $scope.obtainGet = function getGET(){
//	   var loc = document.location.href;
//	   var getString = loc.split('?')[1];
//	   var GET = getString.split('&');
//	   var get = {};
//
//	   for(var i = 0, l = GET.length; i < l; i++){
//	      var tmp = GET[i].split('=');
//	      get[tmp[0]] = unescape(decodeURI(tmp[1]));
//	   }
//	   return get;
//	};
//	$scope.get = $scope.obtainGet();

 // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
  $scope.consultaEmpleado = function() {
	  $('#msload').modal('show');
				  $http({
					  
			method: 'GET',
			url: '/CuadrillasWEB/ConsultaEmpleado',
			params: {
					"idEmpleado": "1", //aqui va ir variable que nos llegara del general
			     }
			}).then(function (result) {
				$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
				$scope.resultadoEmpleado = result.data.empleado;
			    console.log($scope.resultadoEmpleado);
			}, function myError(response) {
				$('#msload').modal('hide');
			    console.error(response);
			    $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
			});
	  };
	  
	  $scope.consultaEmpleado();
  
    
		    $scope.actualizar = function(user) {
		    	$scope.user = {};
		    if ($scope.cambioContra.$valid) {
		    	var confirmar = confirm("¿Esta seguro de guardar los datos?"); 
    			if (!confirmar) 
    				{
    					 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
						 $scope.cambioContra.$setPristine();
    					return false;
    				} else  {
						 $('#msload').modal('show');
						 $('#alert').hide();
    				}
		    	$http({
		              method: 'GET',
		              url: '/CuadrillasWEB/CambioContrasena',
		              params: {
		    			"contrasena" : user.conAnterior,
				 		"contrasenaAnterior": user.conAnterior,
				 		"contrasenaNueva": user.nueva,
				 		"repiteContrasena": user.repetirNueva,
				 		"idEmpleado": "1" //aqui va ir la variable que nos llegara del general
				         }
				    }).then(function mySucces(response) {
				    	$('#msload').modal('hide');
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
						$scope.cambioContra.$setPristine();
                      console.info(response);
                }, function myError(response) {
				        $('#msload').modal('hide');
				        console.error(response);
						$('#alert').show();
						$('#msgerror').text(response.data.mensajeFuncional);
				    });
		    	}
		    
		    	
		    };
		    
		     $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
			
			$scope.reset = function(user){
					$scope.user = {};
					$scope.user.conAnterior = "";
					$scope.user.nueva = "";
					$scope.user.repetirNueva = "";
					$scope.cambioContra.$setPristine();
					};
		    
}]);