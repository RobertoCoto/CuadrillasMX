app.controller('cambioDatos',["$scope","$http", function ($scope,$http) {  
	
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
  
	  $scope.UserData = data.data.usuario.usuario;
	  $('#msload').modal('show');
				  $http({
					  
			method: 'GET',
			url: '/CuadrillasWEB/ConsultaDatosUsuario',
			params: {
					"user": $scope.UserData, //aqui va ir variable que nos llegara del general
			     }
			}).then(function (result) {
				$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
				$scope.resultadoUsuario = result.data;
			    console.log($scope.resultadoUsuario);
			}, function myError(response) {
				$('#msload').modal('hide');
			    console.error(response);
			    $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
			});
	  
  
  
		    $scope.actualizar = function(user) {
		    	$scope.idUser = data.data.usuario.idEmpleado;
		    	$scope.user = {};
		    if ($scope.cambioContra.$valid) {
		    	var confirmar = confirm("�Esta seguro de guardar los datos?"); 
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
				 		"idEmpleado": $scope.idUser //aqui va ir la variable que nos llegara del general
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