app.controller('registraEmpleado', function ($scope, $http, $window) {
	   var date = new Date();
	   $scope.FromDate = date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2);
	  // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
						
		// consulta el perfil del empleado
    $scope.consultaTodo = function () {
    	$('#msload').modal('show');
			$http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'PERFIL_EMP'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultado = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
			
		    //consulta la talla
			 $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'ROPA_TALLA'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultadoRopa = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
			
		    //consulta la vialidad
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
		    	$scope.resultadoVialidad = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
			 	 
		    //consulta el area
			 	  $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'AREA_INC'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultadoArea = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
			 	  
		    //consulta los documentos
			 	  $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'DOCU_EMPLE'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
		    	$scope.resultadoDocumentos = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		        console.error(response);
		        $('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
		    });
			//consulta la cuadrilla
		    
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
		$scope.consultaTodo();
		
		//para ocultar las alertas
		$scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		
		$scope.limpiarCampos = function(formEmpleado) {
			$("div[data-id=documentosResultado").hide();
	    	$("div[data-id=documentosData").show();
	    	$('#editar').show();
			$scope.general = {};
			$scope.formEmpleado.$setPristine();
			};
		 
			//Registrar Empleado Lectura de documentos estatus SI
		  $scope.JSONDocumentation = null;
		  $('input[type=submit]').on('click',function(){		
		  $scope.datosDocumentos = [];
          $('input[data-form=document]:checked').each(function(){
			   var $Name  =  $(this).attr('name');
			   var $Value =  $(this).val();
			   var $status = null;
			   if( $Value == 1 )
				 {
					var $Element = {};
					$status = "SI";
					$Element["codigoDocumento"] = $Name;
				    $Element["estatusDocumento"] = $status;
		  $scope.datosDocumentos.push( $Element );
	    }	
				 if( $Value == 3 )
				 {
					var $Element = {};
					    $status = "NO";
					    $Element["codigoDocumento"] = $Name;
					    $Element["estatusDocumento"] = $status;
						$scope.datosDocumentos.push( $Element );
	    }
				 if( $Value == 2 )
				 {
					    var $Element = {};
					    $status = "NA";
					    $Element["codigoDocumento"] = $Name;
					    $Element["estatusDocumento"] = $status;
		  $scope.datosDocumentos.push( $Element);
	    }
	    });
	      $scope.JSONDocumentation = JSON.stringify( { 'documentacion' : $scope.datosDocumentos } ); 
        });
 
			  //Form de pago
		 	 $scope.pagoValor = null;
			 $('input[type=submit]').on('click',function(){
			 $scope.datoPago = [];
			 $('input[data-form=Pagos]:checked').each(function(){
				    var $Name  =  $(this).attr('name');
					var $Value =  $(this).val();
			 $scope.datoPago.push($Value);
			 });
			 $scope.pagoValor = $scope.datoPago;
			 });
			 
			 //Registra Empleado
            $scope.registrar = function(general) {
            	console.log(general.noEmpleado);
            	if ($scope.formEmpleado.$valid) {
            		$scope.general = {};
            		var confirmar = confirm("¿Esta seguro de registrar el empleado?"); 
	    			if (!confirmar) 
	    				{
	    					 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
							 $scope.formEmpleado.$setPristine();
	    					return false;
	    				} else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
	    				}
	    			$scope.fechaNacimiento = $("#fechaNacimiento").val();
	    		 if($("#seguro").is(':checked')) {
		    	       $scope.imss = "S";	 
		    	        }else {
		    		   $scope.imss = "N";
		    	     }
	    		     
		    	     $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/RegistraEmpleado',
	              params: {
			 		"noEmpleado" : general.noEmpleado,
			 		"nombre" : general.nombre,
			 		"apellidoPaterno": general.apellidoPat,
			 		"apellidoMaterno" : general.apellidoMat,
			 		"sexo": general.sexo,
	              "fechaNacimiento": $scope.fechaNacimiento,
	              "codigoPuesto": general.codigoPuesto,
	              "codigoVialidad": general.codigoVialidad,
	              "codigoArea": general.codigoArea,
	              "codigoTalla": general.codigoTalla,
	              "idCuadrilla": general.idCuadrilla,
	              "calificacion": general.calificacion,
	              "telefono": general.telefono,
	              "rfc" : general.rfc,
	              "sueldo": general.sueldo,
	              "frecuenciaPago": $scope.pagoValor,
	              "nss": general.nss,
	              "altaIMSS": $scope.imss,
	              "noCreditoInfonavit": general.noCreditoInfonavit,
	              "observaciones": general.coment,
	              "usuario": data.data.usuario.usuario,
	              "documentoEmpleado" : $scope.JSONDocumentation
			         }
			    }).then(function mySucces(response) {
			    	$('#msload').modal('hide');
					$('#success').show();
					$('#msgaviso').text(response.data.mensajeFuncional);
					$scope.formEmpleado.$setPristine();
			    	 console.info(response);
			    }, function myError(response) {
			    	$('#msload').modal('hide');
			    	 console.error(response);
					$('#alert').show();
					$('#msgerror').text(response.data.mensajeFuncional);
			    });
			   
                 }
            	
            	};
            
            	//consultar Empleados
            $scope.consultar = function(empleado) {
            	$('#msload').modal('show');
		      $http({
               method: 'GET',
               url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralEmpleado',
               
           }).success(function (result) {
        	    $('#msload').modal('hide');
				$('#alert').hide();
				$('#success').hide();
               $scope.resultadoDatos = result.empleado;
               console.log($scope.resultadoDatos);
           }, function myError(response) {
   		    	$('#msload').modal('hide');
   		        console.error(response);
   		        $('#alert').show();
   				$('#msgerror').text(response.data.header.mensajeFuncional)
   		    });
                $('#empl').show();
		};
		
			//baja empleado		
		 $scope.bajaEmpleado = function(general) {
    	    var $popup = $window.open('http://localhost:8080/CuadrillasWEB/empleado/baja_empleado.html', '_blank','heigth=600,width=600');
    	    $popup.idEmple = general.idEmpleado;
    	    $popup.user = data.data.usuario.usuario;
    	  };
    	  //permisoEmpleado
      $scope.permisoEmpleado = function(general) {
    	  var $popup = $window.open('http://localhost:8080/CuadrillasWEB/permiso/permisoLaboral.html', '_blank','heigth=600,width=600');
    	  $popup.idEmple = general.idEmpleado;
    	  $popup.user = data.data.usuario.usuario;
    	  };
    	  
    	  //edita datos del empleado
				$scope.editarDatos = function(general) {
					 $scope.idEmmpleado = general.idEmpleado;
					 $scope.general = general;
					 
					 $http({
						    method: 'GET',
						    url: 'http://localhost:8080/CuadrillasWEB/ConsultaDocumentos',
						    params : {
								"idEmpleado": $scope.idEmmpleado
						}
						  }).then(function mySucces(result) {
							    $('#msload').modal('hide');
								$('#alert').hide();
								$('#success').hide();
						  	$scope.resultadoDocumentoEmp = result.data.empleadoDocumento;

						  }, function myError(response) {
							    $('#msload').modal('hide');
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
						        console.error(response);
						  });
				  
					 if(general.altaImss == "S") {
						 $('#seguro').prop('checked', true);
					 		} else if(general.altaImss == "N") {
	   	        	    $('#seguro').prop('checked', false);
					 		}
							  $('#editar').hide(); 
					    	  $("div[data-id=documentosData").hide();
					    	  $("div[data-id=documentosResultado").show();
					    	  $('#guardarDato').show();  
					};
					
					
				//actualiza Empleado Lectura de documentos estatus SI
		   $scope.JSONDocumentationUpdate = null;
		  $('input[type=submit]').on('click',function(){		
		  $scope.datosDocumentosUpdate = [];
          $('input[data-form=documentData]:checked').each(function(){
			   var $Name  =  $(this).attr('name');
			   var $Value =  $(this).val();
			   if( $Value == 1 )
				 {
					var $Element = {};
					$status = "SI";
					$Element["codigoDocumento"] = $Name;
				    $Element["estatusDocumento"] = $status;
		$scope.datosDocumentosUpdate.push( $Element );
	    }
				  if( $Value == 3 )
				 {
					var $Element = {};
					$status = "NO";
					$Element["codigoDocumento"] = $Name;
				    $Element["estatusDocumento"] = $status;
		$scope.datosDocumentosUpdate.push( $Element );
	    }
				  if( $Value == 2 )
				 {
					var $Element = {};
					$status = "NA";
					$Element["codigoDocumento"] = $Name;
				    $Element["estatusDocumento"] = $status;
		$scope.datosDocumentosUpdate.push( $Element );
	    }
	    });
	    $scope.JSONDocumentationUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosUpdate } ); 
        });
  	 
		//actualiza el empleado
		 	 $scope.actualizarDato = function(general) {
		 		$scope.general = {};
		 		 $scope.idEmpleado = general.idEmpleado;
		 		var confirmar = confirm("¿Esta seguro de registrar el empleado?"); 
    			if (!confirmar) 
    				{
    					 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
						 $scope.formEmpleado.$setPristine();
    					return false;
    				} else  {
						 $('#msload').modal('show');
						 $('#alert').hide();
    				}
    			$scope.fechaNacimiento = $("#fechaNacimiento").val();
    			if($("#seguro").is(':checked')) {
		    	       $scope.imss = "S";	 
		    	        }else {
		    		   $scope.imss = "N";
		    	     }
		 		$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ActualizaEmpleado',
		              params: {
				        "idEmpleado": $scope.idEmpleado,
		                "noEmpleado" : general.noEmpleado,
				 		"nombre" : general.nombre,
				 		"apellidoPaterno": general.apellidoPat,
				 		"apellidoMaterno" : general.apellidoMat,
				 		"sexo": general.sexo,
		              "fechaNacimiento": $scope.fechaNacimiento,
		              "codigoPuesto": general.codigoPuesto,
		              "codigoVialidad": general.codigoVialidad,
		              "codigoArea": general.codigoArea,
		              "codigoTalla": general.codigoTalla,
		              "idCuadrilla": general.idCuadrilla,
		              "calificacion": general.calificacion,
		              "telefono": general.telefono,
		              "rfc" : general.rfc,
		              "sueldo": general.sueldo,
		              "frecuenciaPago": $scope.pagoValor,
		              "nss": general.nss,
		              "altaIMSS": $scope.imss,
		              "noCreditoInfonavit": general.noCreditoInfonavit,
		              "observaciones": general.coment,
		              "usuario": data.data.usuario.usuario,
		              "documentoEmpleado" : $scope.JSONDocumentationUpdate
				         }
				    }).then(function mySucces(response) {
				    	$('#msload').modal('hide');
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
						$scope.formEmpleado.$setPristine();
				    	 console.info(response);
				    	 $("div[data-id=documentosResultado").hide();
				    	 $("div[data-id=documentosData").show();
				    }, function myError(response) {
				    	$('#msload').modal('hide');
						$('#alert').show();
						$('#msgerror').text(response.data.mensajeFuncional);
				        console.error(response);
				    });
		    	   
		 	 };
		 	 
		 	 //solo consulta empleado
		 	 	 $scope.consultaEmpleado = function(general) {
		 	 		 $scope.general = general;
		 	 		  if(general.altaImss == "S") {
						 $('#seguro').prop('checked', true);
					 		} else if(general.altaImss == "N") {
	   	        	    $('#seguro').prop('checked', false);
					 		}
							  $('#editar').hide(); 
					    	  $("div[data-id=documentosData").hide();
					    	  $("div[data-id=documentosResultado").hide();
					    	  $('#guardarDato').hide();  
		 	 		 };
		 	 	 
		 	 
	});
