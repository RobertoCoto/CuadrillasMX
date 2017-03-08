var app = angular.module('tatei', []);
app.controller('bajaEmpleado', function ($scope, $http, $window) {

		$scope.id = $window.idEmple;
		$scope.usuario = $window.user;
		
		
     // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
	    
	$scope.consultaEmpleado = function() {
		$('#msload').modal('show');
		$http({
	        method: 'post',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
	        params: {
		 		"idEmpleado" : $scope.id
		         },
	        data: { }
		    }).then(function (result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultado = result.data.empleado;
	          console.log($scope.resultado);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
		    
		    //consulta la causa de la salida
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'TIPO_SALID'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultadoSalida = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
		    
	       //consulta tipo renuncia
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'CAUSA_RENU'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultadoRenuncia = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
		};
		$scope.consultaEmpleado();
		
		    //para registrar la baja del empleado
		    $scope.grabar = function(empleado) {
		    	if ($scope.formBaja.$valid) {
		    		$scope.empleado = {};
			    	var confirmar = confirm("¿Esta seguro de dar de baja al empleado?"); 
	                  
					if (!confirmar) 
					{
						 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
						 $scope.formBaja.$setPristine();
						return false;
					} else  {
						 $('#msload').modal('show');
						 $('#alert').hide();
					}
			
			    	$http({
			              method: 'GET',
			              url: 'http://localhost:8080/CuadrillasWEB/BajaEmpleado',
			              params : {
					 		"usuario": $scope.usuario,
					 		"comentario": empleado.comentario,
					 		"codigoTipoSalida": empleado.codigoTipoSalida,
					 		"codigoCausaSalida": empleado.codigoCausaSalida,
			              "idEmpleado": $scope.id
					 }
					    }).then(function mySucces(response) {
					    	$('#msload').modal('hide');
							$('#success').show();
							$('#msgaviso').text(response.data.mensajeFuncional);
							$scope.empleado.comentario ="";
							$scope.formBaja.$setPristine();
					    	 console.info(response);
					    }, function myError(response) {
					    	$('#msload').modal('hide');
							$('#alert').show();
							$('#msgerror').text(response.data.mensajeFuncional);
					        console.error(response);
					        
					    });
				}
		    	
		    	};
		    	
		    $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					}
		    
});