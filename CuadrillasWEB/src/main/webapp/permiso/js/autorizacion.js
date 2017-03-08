var app = angular.module('tatei', []);
app.controller('autorizacionLaboral', function ($scope, $http, $window) {
$scope.id = $window.idPermiso;
$scope.usuario = $window.user;
	   // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
	$scope.consultaPermiso = function() {
		$('#msload').modal('show');
		$http({
				method: 'GET',
				url: 'http://localhost:8080/CuadrillasWEB/ConsultaPermisoTemporal',
				params: {
						"idPermiso" : $scope.id
				     },
				data: { }
				}).then(function (result) {
					$('#msload').modal('hide');
					$('#alert').hide();
					$('#success').hide();
					$scope.resultado = result.data.permiso;
				    console.log($scope.resultado);
				
				}, function myError(response) {
					$('#msload').modal('hide');
			        console.error(response);
			        $('#alert').show();
					$('#msgerror').text(response.data.header.mensajeFuncional)
				});
		};
		
		$scope.consultaPermiso();
	
	   
		     $scope.aceptar = function(permiso) {
		    	 $scope.permiso = {};
		    	 
                	var confirmar = confirm("¿Esta seguro de autorizar el permiso?"); 

		    		if (!confirmar) 
		    			{
		    				 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
		    					return false;
		    			}else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
	    				} 	
		    	 if($("#goce").is(':checked')) {
		    	       $scope.goce = "S";	 
		    	 }else {
		    		   $scope.goce = "N";
		    	 }
		    	 

		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
		              params: {
				 		"idPermiso" : $scope.id,
				 		"goceSueldo" : $scope.goce,
				 		"estatusAutorizacion": "S",
				 		"usuario": $scope.usuario
				         }
				    }).then(function mySucces(response) {
				    	$('#msload').modal('hide');
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 //opener.top.location.reload();
				    }, function myError(response) {
				    	$('#msload').modal('hide');
				    	$('#success').hide();
						$('#alert').show();
						$('#msgerror').text(response.data.mensajeFuncional);
				        console.error(response);
				    });
		    	
		    	}
		    
		     $scope.rechazar = function(permiso) {
		    	 $scope.permiso = {};
						var confirmar = confirm("¿Esta seguro de rechazar el permiso?"); 
						
						if (!confirmar) 
		    			{
		    				 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
		    					return false;
		    			}else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
	    				} 		
				    	$http({
				              method: 'GET',
				              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
				    	 params: {
					 		"idPermiso" : $scope.id,
					 		"goceSueldo" : "N",
					 		"estatusAutorizacion": "N",
					 		"usuario": $scope.usuario
					         }
						    }).then(function mySucces(response) {
						    	$('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
						    	 console.info(response);
						    	 //opener.top.location.reload();
						    }, function myError(response) {
						    	$('#msload').modal('hide');
						    	$('#success').hide();
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
						        console.error(response);
						    });
				    	};
				    	
				    $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
	});
