app.controller('registraEmpleado', function ($scope, $http, $window) {
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
		
		 //consulta lista empleados
			$scope.consultar = function(empleado) {
		   $http({
               method: 'GET',
               url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralEmpleado',
               
           }).success(function (result) {
               $scope.resultadoDatos = result.empleado;
               console.log($scope.resultadoDatos);
               $scope.editingData = {};

                for (var i = 0, length = $scope.resultadoDatos.length; i < length; i++) {
                  $scope.editingData[$scope.resultadoDatos[i].idEmpleado] = false;
                }
                });
                $('#empl').show();
		};
					//edita datos del empleado
				$scope.editarDatos = function(general) {
					 console.log(general);
					 $scope.idEm = general.idEmpleado;
					 $scope.general = general;
					 
					 $http({
						    method: 'GET',
						    url: 'http://localhost:8080/CuadrillasWEB/ConsultaDocumentos',
						    params : {
								"idEmpleado": $scope.idEm
						}
						  }).then(function mySucces(result) {
						  	$scope.resultadoDocumentoEmp = result.data.empleadoDocumento;

						  }, function myError(response) {
						      console.error(response);
						      alert(response.data.mensajeFuncional);
						      //$scope.resultado2.push(objecto);
						  });
        
	             document.getElementById("idData").value= $scope.idEm;
	             
	             document.getElementById("noEmpleado").disabled = false;
				 document.getElementById("nombre").disabled = false;
				 document.getElementById("apellidoPaterno").disabled= false;
				 document.getElementById("apellidoMaterno").disabled = false;
				 document.getElementById("fechaNacimiento").disabled = false;
				 document.getElementById("nss").disabled = false;
				 document.getElementById("telefono").disabled = false;
				 document.getElementById("rfc").disabled = false;
				 document.getElementById("calificacion").disabled = false;
				 document.getElementById("noCreditoInfonavit").disabled = false;
				  document.getElementById("sueldo").disabled = false;
				  document.getElementById('idCuadrilla').disabled = false;
				  
				 if(general.altaImss == "S") {
   	          document.getElementById("seguro").checked = true;
   	          document.getElementById("seguro").disabled = false;
   	        } else if(general.altaImss == "N") {
   	        	document.getElementById("seguro").checked = false;
   	        	document.getElementById("seguro").disabled = false;
   	        }
		   document.getElementById("sexo").disabled = false;
				 document.getElementById("codigoPuesto").disabled = false;
				 document.getElementById("codigoTalla").disabled = false;
				 document.getElementById("codigoArea").disabled = false;
				 document.getElementById("codigoVialidad").disabled = false;
				 
			document.getElementById('editar').style.display='none'; 
    	  $("div[data-id=documentosData").hide();
    	  $("div[data-id=documentosResultado").show();
    	   document.getElementById('guardarDato').style.display='block'; 
    	   document.getElementById('guardarDato').disabled = false; 
					};
					
			//baja empleado		
		 $scope.bajaEmpleado = function(general) {
    	    $scope.idE = general.idEmpleado;
    	     window.open('http://localhost:8080/CuadrillasWEB/empleado/baja_empleado.html?idEmpleado='+ $scope.idE, '_blank','heigth=600,width=600');
    	  };
    	  //permisoEmpleado
      $scope.permisoEmpleado = function(general) {
    	  $scope.id = general.idEmpleado;
    	  window.open('http://localhost:8080/CuadrillasWEB/permiso/index.html?idEmpleado='+ $scope.id, '_blank','heigth=600,width=600');
    	  };
    	  
									    	 //documentos actualizar
									
										  $scope.JSONDocumentationUpdate = null;
										  $('input[type=submit]').on('click',function(){
												
									$scope.datosDocumentosUpdate = [];
									
									$('input[data-form=documentData]:checked').each(function(){
										
									    var $Name  =  $(this).attr('name');
										var $Value =  $(this).val();
										
										if( $Value == 1 )
										{
											var $Element = {};
											
											$Element = $Name;
											//$Element['estatusDocumento'] = 'A';
											$scope.datosDocumentosUpdate.push( $Element );
										}
											
										
									});
									
									$scope.JSONDocumentationUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosUpdate } );
									 
									});
									
									// json docs no
										  $scope.JSONDocumentationNoDocsUpdate = null;
										  $('input[type=submit]').on('click',function(){
												
									$scope.datosDocumentosDUpdate = [];
									
									$('input[data-form=documentData]:checked').each(function(){
										
									    var $Name  =  $(this).attr('name');
										var $Value =  $(this).val();
										
										if( $Value == 3 )
										{
											var $Element = {};
											
											$Element = $Name;
											//$Element['estatusDocumento'] = 'A';
											$scope.datosDocumentosDUpdate.push( $Element );
										}
											
										
									});
									
									$scope.JSONDocumentationNoDocsUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDUpdate } );
									
									 
									});
									
									// json docs no
										  $scope.JSONDocumentationNaDocsUpdate = null;
										  $('input[type=submit]').on('click',function(){
												
									$scope.datosDocumentosDaUpdate = [];
									
									$('input[data-form=documentData]:checked').each(function(){
										
									    var $Name  =  $(this).attr('name');
										var $Value =  $(this).val();
										
										if( $Value == 2 )
										{
											var $Element = {};
											
											$Element = $Name;
											//$Element['estatusDocumento'] = 'A';
											$scope.datosDocumentosDaUpdate.push( $Element );
										}
											
										
									});
									
									$scope.JSONDocumentationNaDocsUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDaUpdate } );
									 
									});
				//actualizar empleado
				$scope.actualizarDato = function(general) {
					 console.log(general);
					 $scope.idEm = general.idEmpleado;
					 $scope.general = general;
					 console.log(data.data.usuario.usuario);
					 
					  $scope.sueldo = document.getElementById("sueldo").value;
    		   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
    		   console.log("es la cuadrilla: "+ $scope.cuadrilla);
    	       
    	       $scope.vialidad =document.getElementById("cVialidad").value;
     
     if ($scope.sueldo == "")
     {
    	 $scope.sueldo = document.getElementById("sueldo").value = 0;
    	 }
     
      
	  if (typeof($scope.vialidad) === "undefined")
 {
	 $scope.vialidad = document.getElementById("cVialidad").value = null;
	 }
           var imss = document.getElementById("seguro");
		   
		   if(imss.checked == true) {
			   $scope.seguro = "S";
			   } else if(imss.checked == false) {
				   $scope.seguro = "N";
			   }    
	   $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ActualizaEmpleado',
              params: {
		        "idEmpleado": $scope.idEm,
              "noEmpleado" : document.getElementById("noEmpleado").value,
		 		"nombre" : document.getElementById("nombre").value,
		 		"apellidoPaterno": document.getElementById("apellidoPaterno").value,
		 		"apellidoMaterno" : document.getElementById("apellidoMaterno").value,
		 	"sexo": document.getElementById("sexo").value,
            "fechaNacimiento": document.getElementById("fechaNacimiento").value,
            "fechaIngreso": document.getElementById("fechaIngreso").value,
            "codigoPuesto": document.getElementById("cPuesto").value ,
            "codigoVialidad": document.getElementById("cVialidad").value ,
            "codigoArea": document.getElementById("cArea").value,
            "codigoTalla": document.getElementById("cTalla").value,
            "idCuadrilla":  document.getElementById("cCuadrilla").value,
            "telefono": document.getElementById("telefono").value,
            "rfc" : document.getElementById("rfc").value,
            "sueldo": $scope.sueldo,
            "calificacion": document.getElementById("calificacion").value,
            "frecuenciaPago": $scope.pagoValor,
            "nss": document.getElementById("nss").value,
              "altaIMSS": $scope.seguro,
            "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
            "observaciones": document.getElementById("observaciones").value,
            "usuario": data.data.usuario.usuario,
              "documentoEmpleado" : $scope.JSONDocumentationUpdate,
              "noDocs" : $scope.JSONDocumentationNoDocsUpdate,
              "naDocs" :$scope.JSONDocumentationNaDocsUpdate
		         }
		    }).then(function mySucces(response) {
		    	alert(response.data.mensajeFuncional);
		    	 console.info(response);
//		    	  $("div[data-id=documentosResultado").hide();
//		    	  $("div[data-id=documentosData").show();
		    	 //setTimeout('document.form_reloj.reset()',2000);
		    	 //location.reload();
	             return false;
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		    });
    	   };
    	   
    	   //solo consulta empleado
          $scope.consultaEmpleado = function(general) {
        	     console.log(general);
				 $scope.idEm = general.idEmpleado;
				 $scope.general = general;
				 
				 document.getElementById("noEmpleado").disabled = true;
				 document.getElementById("nombre").disabled = true;
				 document.getElementById("apellidoPaterno").disabled= true;
				 document.getElementById("apellidoMaterno").disabled = true;
				 document.getElementById("fechaNacimiento").disabled = true;
				 document.getElementById("nss").disabled = true;
				 document.getElementById("telefono").disabled = true;
				 document.getElementById("rfc").disabled = true;
				 document.getElementById("calificacion").disabled = true;
				 document.getElementById("noCreditoInfonavit").disabled = true;
				  document.getElementById("sueldo").disabled = true;
				  document.getElementById('idCuadrilla').disabled = true;
				  
				  if(general.altaImss == "S") {
			          document.getElementById("seguro").checked = true;
			          document.getElementById("seguro").disabled = true;
			        } else if(general.altaImss == "N") {
			        	document.getElementById("seguro").checked = false;
			        	document.getElementById("seguro").disabled = true;
			        }
				 document.getElementById("sexo").disabled = true;
				 document.getElementById("codigoPuesto").disabled = true;
				 document.getElementById("codigoTalla").disabled = true;
				 document.getElementById("codigoArea").disabled = true;
				 document.getElementById("codigoVialidad").disabled = true;
				 
				 document.getElementById('editar').style.display='none'; 
   	  $("div[data-id=documentosData").hide();
   	  //$("div[data-id=documentosResultado").hide();
   	   document.getElementById('guardarDato').disabled = true; 
        	  };
          
																						    	//documentos normal
												  $scope.JSONDocumentation = null;
												  $('input[type=submit]').on('click',function(){
														
											$scope.datosDocumentos = [];
											
											$('input[data-form=document]:checked').each(function(){
												
											    var $Name  =  $(this).attr('name');
												var $Value =  $(this).val();
												
												if( $Value == 1 )
												{
													var $Element = {};
													
													$Element = $Name;
													//$Element['estatusDocumento'] = 'A';
													$scope.datosDocumentos.push( $Element );
												}
													
												
											});
											
											$scope.JSONDocumentation = JSON.stringify( { 'documentacion' : $scope.datosDocumentos } );
											 
											});
											
											// json docs no
												  $scope.JSONDocumentationNoDocs = null;
												  $('input[type=submit]').on('click',function(){
														
											$scope.datosDocumentosD = [];
											
											$('input[data-form=document]:checked').each(function(){
												
											    var $Name  =  $(this).attr('name');
												var $Value =  $(this).val();
												
												if( $Value == 3 )
												{
													var $Element = {};
													
													$Element = $Name;
													//$Element['estatusDocumento'] = 'A';
													$scope.datosDocumentosD.push( $Element );
												}
													
												
											});
											
											$scope.JSONDocumentationNoDocs = JSON.stringify( { 'documentacion' : $scope.datosDocumentosD } );
											
											 
											});
											
											// json docs no
												  $scope.JSONDocumentationNaDocs = null;
												  $('input[type=submit]').on('click',function(){
														
											$scope.datosDocumentosDa = [];
											
											$('input[data-form=document]:checked').each(function(){
												
											    var $Name  =  $(this).attr('name');
												var $Value =  $(this).val();
												
												if( $Value == 2 )
												{
													var $Element = {};
													
													$Element = $Name;
													//$Element['estatusDocumento'] = 'A';
													$scope.datosDocumentosDa.push( $Element );
												}
													
												
											});
											
											$scope.JSONDocumentationNaDocs = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDa } );
											
											 
											});
												  
											//value pago  
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
				//metodo para registrar empleado
		$scope.registrar = function(general) {
			
		    console.log(data.data.usuario.usuario);
			//se declaran variables 	
		       var noEmpleado = document.getElementById("noEmpleado").value;
		       var nombre = document.getElementById("nombre").value;
		       var apellidoPat = document.getElementById("apellidoPaterno").value;
		       var apellidoMat = document.getElementById("apellidoPaterno").value;
		       var puesto = document.getElementById("codigoPuesto").value;
		       var nacimiento = document.getElementById("fechaNacimiento").value;
		       var nss = document.getElementById("nss").value;
		       var infonavit = document.getElementById("noCreditoInfonavit").value;
		       var rfc = document.getElementById("rfc").value;
		       var telefono = document.getElementById("telefono").value;
		       var talla =  document.getElementById("cTalla").value;
		       var sexo = document.getElementById("sexo").value;
		       var area = document.getElementById("codigoArea").value;
		       var calif = document.getElementById("calificacion").value;
			   $scope.sueldo = document.getElementById("sueldo").value;
			   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
			   $scope.vialidad = document.getElementById("cVialidad").value;

			   //validaciones front
	 if (noEmpleado == "") {
		 $('.amt_err')
			.text('Numero Empleado vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (nombre == "") {
		 $('.amt_error')
			.text('El nombre esta vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (apellidoPat == "") {
		 $('.amt_errorApellidoP')
			.text('El apellido paterno esta vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (apellidoMat == "") {
		 $('.amt_errorApellidoM')
			.text('El apellido materno esta vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (puesto == "") {
		 $('.amt_errorPuesto')
			.text('No se ha seleccionado un puesto.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (nacimiento == "") {
		 $('.amt_errorNacimiento')
			.text('No se ha seleccionado una fecha.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (nss == "") {
		 $('.amt_errorNSS')
			.text('Numero de seguro vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (infonavit == "") {
		 $('.amt_errorNSS')
			.text('Numero de seguro vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (rfc == "") {
		 $('.amt_errorRFC')
			.text('RFC vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (telefono == "") {
		 $('.amt_errorTel')
			.text('Telefono vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (talla == "") {
		 $('.amt_errorTalla')
			.text('No se ha seleccionado una talla.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (sexo == "") {
		 $('.amt_errorSexo')
			.text('No se ha seleccionado un sexo.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (area == "") {
		 $('.amt_errorArea')
			.text('No se ha seleccionado un Area.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if (calif == "") {
		 $('.amt_errorCalificacion')
			.text('Asigne una calificación.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if($scope.sueldo == 0) {
		 $('.amt_errorSueldo')
			.text('Sueldo vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
		 return false;
		 }
	 if ($scope.sueldo == "")
	 {
		 $scope.sueldo = document.getElementById("sueldo").value = 0;
		 }
	 
		 if ($scope.cuadrilla == "")
	 {
		 $scope.cuadrilla = document.getElementById("cCuadrilla").value = 0;
		 }
	 
		  if ($scope.vialidad == "")
	 {
		 $scope.vialidad = document.getElementById("cVialidad").value = null;
		 }
	 
		 var imss = document.getElementById("seguro");
			   
			   if(imss.checked == true) {
				   $scope.seguro = "S";
				   } else if(imss.checked == false) {
					   $scope.seguro = "N";
				   }
		
			$http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/RegistraEmpleado',
	              params: {
			 		"noEmpleado" : document.getElementById("noEmpleado").value,
			 		"nombre" : document.getElementById("nombre").value,
			 		"apellidoPaterno": document.getElementById("apellidoPaterno").value,
			 		"apellidoMaterno" : document.getElementById("apellidoMaterno").value,
			 		"sexo": document.getElementById("sexo").value,
	              "fechaNacimiento": document.getElementById("fechaNacimiento").value,
	              "codigoPuesto": document.getElementById("cPuesto").value,
	              "codigoVialidad": document.getElementById("cVialidad").value,
	              "codigoArea": document.getElementById("cArea").value,
	              "codigoTalla": document.getElementById("cTalla").value,
	              "idCuadrilla": $scope.cuadrilla,
	              "calificacion": document.getElementById("calificacion").value,
	              "telefono": document.getElementById("telefono").value,
	              "rfc" : document.getElementById("rfc").value,
	              "sueldo": $scope.sueldo,
	              "frecuenciaPago": $scope.pagoValor,
	              "nss": document.getElementById("nss").value,
	              "altaIMSS": $scope.seguro,
	              "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
	              "observaciones": document.getElementById("observaciones").value,
	              "usuario": data.data.usuario.usuario,
	              "documentoEmpleado" : $scope.JSONDocumentation,
	              "noDocs" : $scope.JSONDocumentationNoDocs,
	              "naDocs" :$scope.JSONDocumentationNaDocs
			         }
			    }).then(function mySucces(response) {
			    	alert(response.data.mensajeFuncional);
			    	 console.info(response);
			    	 setTimeout('document.form_reloj.reset()',2000);
		             return false;
			    }, function myError(response) {
			        console.error(response);
			        alert(response.data.mensajeFuncional);
			    });
			};
			
			$scope.reset = function(form) {
						$scope.general = {};
						$scope.general.actualizar = false;
						$scope.general.editar = false;
						 document.getElementById("noEmpleado").disabled = false;
						 document.getElementById("nombre").disabled = false;
						 document.getElementById("apellidoPaterno").disabled= false;
						 document.getElementById("apellidoMaterno").disabled = false;
						 document.getElementById("fechaNacimiento").disabled = false;
						 document.getElementById("nss").disabled = false;
						 document.getElementById("telefono").disabled = false;
						 document.getElementById("rfc").disabled = false;
						 document.getElementById("calificacion").disabled = false;
						 document.getElementById("noCreditoInfonavit").disabled = false;
						  document.getElementById("sueldo").disabled = false;
						  document.getElementById('idCuadrilla').disabled = false;
						  
						  document.getElementById("sexo").disabled = false;
				 document.getElementById("codigoPuesto").disabled = false;
				 document.getElementById("codigoTalla").disabled = false;
				 document.getElementById("codigoArea").disabled = false;
				 document.getElementById("codigoVialidad").disabled = false;
				 
			document.getElementById('editar').style.display='none'; 
    	  $("div[data-id=documentosData").show();
    	  $("div[data-id=documentosResultado").hide();
    	   document.getElementById('guardarDato').style.display='none'; 
    	   document.getElementById('editar').style.display='block'; 
    	   document.getElementById('guardarDato').disabled = false; 
    	             $('#empl').hide();
						$scope.consultaTodo();
						
				
					};
		
	});
