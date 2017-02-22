var app = angular.module('tatei', []);
app.controller('autorizacionLaboral', function ($scope, $http) {

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
	    
	$scope.consultaPermiso = function() {
		$('#msload').modal('show');
		$http({
				method: 'GET',
				url: 'http://localhost:8080/CuadrillasWEB/ConsultaPermisoTemporal',
				params: {
						"idPermiso" : $scope.get.idPermiso
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
				 		"idPermiso" : $scope.get.idPermiso,
				 		"goceSueldo" : $scope.goce,
				 		"estatusAutorizacion": "S",
				 		"usuario": "SISTEMAS"
				         }
				    }).then(function mySucces(response) {
				    	$('#msload').modal('hide');
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 //opener.top.location.reload();
				    }, function myError(response) {
				    	$('#msload').modal('hide');
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
					 		"idPermiso" : $scope.get.idPermiso,
					 		"goceSueldo" : "N",
					 		"estatusAutorizacion": "N",
					 		"usuario": "SISTEMAS"
					         }
						    }).then(function mySucces(response) {
						    	$('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
						    	 console.info(response);
						    	 //opener.top.location.reload();
						    }, function myError(response) {
						    	$('#msload').modal('hide');
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
