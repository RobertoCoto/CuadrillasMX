app.controller('adminCuad', function ($scope, $http) {
	$('#success').hide();
	$('#alert').hide();
	$('#msload').modal('show');

				$scope.consultaCuadrilla = function() {
					$('#msload').modal('show');
					$http({
			              method: 'GET',
			              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
			              params : {
					 		"tipoCatalogo": 'VIALIDAD'
					 },
			              data: { }
					    }).then(function mySucces(result) {
					    	$('#msload').modal('hide');
							$('#alert').hide();
							$('#success').hide();
					    	$scope.resultado = result.data.catalogo;
				              console.log($scope.resultado);
					    }, function myError(response) {
					    	$('#msload').modal('hide');
					        console.error(response);
							$('#alert').show();
							$('#msgerror').text(response.data.header.mensajeFuncional)
					    });
					
			    $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCuadrilla',
	              data: { }
			    }).then(function mySucces(result) {
						$('#msload').modal('hide');
						$('#alert').hide();
						$('#success').hide();
			    	$scope.resultadoCuadrilla = result.data.cuadrilla;
		             console.log(result);
			    }, function myError(response) {
						$('#msload').modal('hide');
						console.error(response);
						$('#alert').show();
						$('#msgerror').text(response.data.header.mensajeFuncional)
			    });
				};
				$scope.consultaCuadrilla();
				
				//ocultar notificaciones
				$scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					}
				
				//alta de cuadrilla
				$scope.registrar = function(cuadrillas) {
		    	$scope.cuadrillas = {};
		    	if ($scope.formCuadrilla.$valid) {
		    		var confirmar = confirm("�Esta seguro de registrar la cuadrilla?");
					if (!confirmar)
					{
						 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
						 $scope.formCuadrilla.$setPristine();
						 return false;
					}else  {
						 $('#msload').modal('show');
						 $('#alert').hide();
					}
					
					$scope.vialidad = $('#idVialidad').val();
					$http({
					     method: 'GET',
					     url: 'http://localhost:8080/CuadrillasWEB/AltaCuadrilla',
					     params: {
						 "idCuadrilla" : cuadrillas.idCuadrilla,
						 "nombreCuadrilla" : cuadrillas.nombreCuadrilla,
					     "vialidad": $scope.vialidad,
						 "calificacion" : cuadrillas.calificacion,
						 "usuario" : data.data.usuario.usuario
					
					}
					   }).then(function mySucces(response) {
							$scope.formCuadrilla.$setPristine();
					   	    console.info(response);
					   	    $('#success').show();
							$('#msgaviso').text(response.data.mensajeFuncional);
							$scope.consultaCuadrilla();
					   	    $('#msload').modal('hide');
					   }, function myError(response) {
					   		$('#msload').modal('hide');
					   	    console.error(response);
							$('#alert').show();
							$('#msgerror').text(response.data.mensajeFuncional);
							$scope.formCuadrilla.$setPristine();
					   });
		    		}
		    	};
		    	
		    //Edita la cuadrilla

		    $scope.editarCuadrilla = function(datosCuadrilla) {
					console.log(datosCuadrilla);
					$scope.cuadrilla = datosCuadrilla;
					$scope.cuadrilla.actualizar = true;
					$scope.cuadrilla.editar = true;
					$('#colab').show();
		    	 $http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ConsultaColaborador',
		              params : {
				 		"idCuadrilla": datosCuadrilla.idCuadrilla
				 },
		              data: { }
				    }).then(function mySucces(result) {
				    	   $scope.resultadoColaborador = result.data.empleado;
			               console.log($scope.resultadoColaborador);
				    }, function myError(response) {
				        alert(response.data.header.mensajeFuncional);
				        //$scope.resultado2.push(objecto);
				    });
				    $('#numeroCuadrilla').val(datosCuadrilla.idCuadrilla);
				    $('#nombre').val(datosCuadrilla.nombreCuadrilla);
				    $('#calificacion').val(datosCuadrilla.calificacion);
		    	};
		    	
		    	//Actualiza la cuadrilla
		    	$scope.actualizar = function(cuadrillas) {
				console.log(data.data.usuario.usuario);
		    var confirmar = confirm("¿Esta seguro de actualizar la cuadrilla?");

		    	 if (!confirmar)
		    	 {
						 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
						 $scope.formCuadrilla.$setPristine();
		    		 return false;
		    	 } else {
						 $('#msload').modal('show');
						 $('#alert').hide();
					 }
		    	$scope.vialidad = $('#idVialidad').val();
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ModificaCuadrilla',
		              params: {
		    		 "idCuadrilla" : $('#numeroCuadrilla').val(),
		    		 "nombreCuadrilla" : $('#nombre').val(),
		             "vialidad": $scope.vialidad,
		    		 "calificacion" : $('#calificacion').val(),
		    		 "usuario" : data.data.usuario.usuario

		    	 }
				    }).then(function mySucces(response) {
				    		//$scope.consultaCuadrilla();
				    		console.log(response);
				    		$scope.consultaCuadrilla();
							$('#msload').modal('hide');
							$scope.formCuadrilla.$setPristine();
							$scope.reset();
							$('#success').show();
				    		$('#msgaviso').text(response.data.mensajeFuncional);
				    	   
				    }, function myError(response) {
							$('#msload').modal('hide');
							$('#alert').show();
							$('#msgerror').text(response.data.mensajeFuncional);
							$scope.formCuadrilla.$setPristine();
				             console.error(response);
				    });
		    	};
		    	
		    	$scope.reset = function(form) {
						$scope.cuadrilla = {};
						$scope.cuadrillas = {};
						$('#numeroCuadrilla').val("");
						$('#nombre').val("");
						$('#calificacion').val("");
						$scope.cuadrilla.actualizar = false;
						$scope.cuadrilla.editar = false;
						$scope.formCuadrilla.$setPristine();
						$('#colab').hide();
					}
		    	//baja
			$scope.bajaCuadrilla = function(datosCuadrilla) {
		    		var confirmar = confirm(" �Esta seguro de dar de baja la cuadrilla? ");

		    		if (!confirmar)
		    		{
		    			//alert('se ha cancelado la operacion.');
						  $('#alert').show();
 						  $('#msgerror').text('Se ha cancelado la operacion.');
						return false;
		    		}else  {
						 $('#msload').modal('show');
						 $('#alert').hide();
    				}

		    		$scope.CuadrillaData = datosCuadrilla.idCuadrilla;
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/BajaCuadrilla',
		              params: {
		    		 "idCuadrilla" : $scope.CuadrillaData,
		              "usuario" : data.data.usuario.usuario
		    	 }
				    }).then(function mySucces(response) {
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
						$scope.consultaCuadrilla();
						$('#msload').modal('hide');
				    	 console.info(response);
				    }, function myError(response) {
				    	$('#msload').modal('hide');
				    	 console.error(response);
						$('#alert').show();
						$('#msgerror').text(response.data.mensajeFuncional);
				    });
		    	};
});
