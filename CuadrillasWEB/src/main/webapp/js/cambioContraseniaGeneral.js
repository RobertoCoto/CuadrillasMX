app.controller('adminDatos', function ($scope, $http) { 
	// msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
			$scope.consultaUsuario = function()  {
				$('#msload').modal('show');
				$http({		
				method: 'GET',
				url: '/CuadrillasWEB/ConsultaGeneralUsuario',
				data: { }
				}).then(function (result) {
					$('#msload').modal('hide');
					$('#alert').hide();
					$('#success').hide();
					$scope.resultadoAdmin = result.data.lista;
				    console.log($scope.resultadoAdmin);
				}, function myError(response) {
					$('#msload').modal('hide');
				    console.error(response);
				    $('#alert').show();
					$('#msgerror').text(response.data.header.mensajeFuncional)
				});
				};
				
		 $scope.consultaUsuario();		
		 	
		 	//para actualizar contraseña
		    $scope.actualizar = function(user) {
		    	$scope.user = {};
		    	if ($scope.formCambioGeneral.$valid) {
		    		var confirmar = confirm("¿Esta seguro de actualizar?"); 
	    			if (!confirmar) 
	    				{
	    					 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
							 $scope.formCambioGeneral.$setPristine();
	    					return false;
	    				} else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
	    				}
		    		$http({
			              method: 'GET',
			              url: '/CuadrillasWEB/RecuperaContrasena',
			              params: {
					 		"contrasenaNueva": user.contraNueva,
					 		"repiteContrasena": user.repetirContranueva,
					 		"idEmpleado": user.select
					         }
					    }).then(function mySucces(response) {
					    	$('#msload').modal('hide');
	 						$('#success').show();
	 						$('#msgaviso').text(response.data.mensajeFuncional);
	 						$scope.formCambioGeneral.$setPristine();
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
					$scope.user.contraNueva = "";
					$scope.user.repetirContraNueva = "";
					$scope.formCambioGeneral.$setPristine();
					};
				

});