var app = angular.module('tatei', []);
app.controller('registraPermiso', function ($scope, $http,$filter) {
     //fecha Sistema
   var date = new Date();
   $scope.FromDate = date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2);
   
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
		
		   // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
	$scope.consultaEmpleado = function() {
		$('#msload').modal('show');
		$http({
	        method: 'GET',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
	        params: {
		 		"idEmpleado" : $scope.get.idEmpleado
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
		
		    $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
	              params : {
			 		"tipoCatalogo": 'PERMI_LABO'
			 },
	              data: { }
			    }).then(function mySucces(result) {
			    	$('#msload').modal('hide');
					$('#alert').hide();
					$('#success').hide();
			    	$scope.resultadoLaboral = result.data.catalogo;
		              console.log(result);
			    }, function myError(response) {
			    	$('#msload').modal('hide');
			        console.error(response);
			        $('#alert').show();
					$('#msgerror').text(response.data.header.mensajeFuncional)
			    });
		    
			     
		};
		$scope.consultaEmpleado();
		   
		    
		    //registra el permiso en la base de datos
		    $scope.registrar = function(permiso) {
		    	 $scope.permiso = {};
		    	//valida si el form es valido
		    	if ($scope.formPermiso.$valid) {
		    		$scope.fechaMinima = $("#fechaSolicitudMinima").val(); 
		    		$scope.fechaMaxima = $("#fechaSolicitudMaxima").val();
		    		$scope.horaMin = $("#horaSolicitudMaxima").val();
		    		$scope.horaMax = $("#horaSolicitudMinima").val();
		    		var confirmar = confirm("�Esta seguro de guardar los datos?"); 
		    			if (!confirmar) 
		    				{
		    					 $('#alert').show();
								 $('#msgerror').text('Se ha cancelado la operacion.');
								 $scope.formPermiso.$setPristine();
		    					return false;
		    				} else  {
								 $('#msload').modal('show');
								 $('#alert').hide();
		    				}
						$http({
						      method: 'GET',
						      url: 'http://localhost:8080/CuadrillasWEB/RegistraPermiso',
						      params: {
						 		"idEmpleado" : $scope.get.idEmpleado,
						 		"comentario" : permiso.comentario,
						 		"fechaSolicitud": $scope.FromDate,
						 		"fechaSolicitudMinima" : $scope.fechaMinima,
						      "fechaSolicitudMaxima" : $scope.fechaMaxima,
						      "horaSolicitudMinima" : $scope.horaMin,
						      "horaSolicitudMaxima" : $scope.horaMax,
						      "tipoPermiso" : permiso.codigo,
						 		"usuario" : 'SISTEMAS'
						         }
						    }).then(function mySucces(response) {
						    	$('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
								$scope.permiso.comentario ="";
								$scope.formPermiso.$setPristine();
						    	 console.info(response);
						    	 //opener.top.location.reload();
						    }, function myError(response) {
						    	$('#msload').modal('hide');
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
								$scope.formPermiso.$setPristine();
						        console.error(response);
						    });
		    		}
		    	};
		    	
		    $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		    
});
