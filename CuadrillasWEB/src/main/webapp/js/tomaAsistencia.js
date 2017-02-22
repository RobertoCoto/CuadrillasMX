
app.controller('entradaAsistencia', function ($scope, $http,$timeout) { 

//	//obtener el id enviado por GET
//	   $scope.obtainGet = function getGET(){
//		   var loc = document.location.href;
//		   var getString = loc.split('?')[1];
//		   var GET = getString.split('&');
//		   var get = {};
//
//		   for(var i = 0, l = GET.length; i < l; i++){
//		      var tmp = GET[i].split('=');
//		      get[tmp[0]] = unescape(decodeURI(tmp[1]));
//		   }
//		   return get;
//		};
//		$scope.get = $scope.obtainGet();
		
	  //Fecha del sistema 
   var	hoy = new Date()
   var	dd = hoy.getDate()
	var mm = hoy.getMonth()+1 //hoy es 0!
   var  yyyy = hoy.getFullYear()
    
    if(dd<10) {
    dd='0'+dd
	} 

	if(mm<10) {
    mm='0'+mm
	} 

   hoy = yyyy+'-'+mm+'-'+dd;
   console.log(hoy);
   	document.getElementById("fechaIngreso").value = hoy;
   	
   	$scope.reloj = function(){
   	//hora
   	var momentoActual = new Date()
   	var hora = momentoActual.getHours() 
   	var minuto = momentoActual.getMinutes() 
   	var str_minuto = new String (minuto) 
   	if (str_minuto.length == 1) 
      	minuto = "0" + minuto 
   	str_hora = new String (hora) 
   	if (str_hora.length == 1) 
      	hora = "0" + hora 
   	var horaImprimible = hora + " : " + minuto
   	document.getElementById("horarioAsistencia").value = horaImprimible;
   	$timeout($scope.reloj,1000)
   	};
   	
   	// msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
		  $scope.asistencia = function(){
			  $('#msload').modal('show');
			  $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/ConsultaAsistencia',
	              params: {
	            	  "idCuadrilla" : "1"
	              },
	              data: { }
			    }).then(function (result) {
			    	$('#msload').modal('hide');
					$('#alert').hide();
					$('#success').hide();
			    	$scope.resultadoAsistencia = result.data.asistencia;
		            console.log($scope.resultadoAsistencia);
			    }, function myError(response) {
			    	$('#msload').modal('hide');
			        console.error(response);
			        $('#alert').show();
					$('#msgerror').text(response.data.header.mensajeFuncional)
			    });
		  };
		  $scope.asistencia();  
            
            
            //registra la entrada del empleado
           $scope.entrada = function(asistencia) {
        	
           if ($scope.form_reloj.$valid) {
        	   var confirmar = confirm("¿Esta seguro de registrar la entrada?"); 

						if (!confirmar) 
						{
							 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.'); 
							 $scope.form_reloj.$setPristine();
							return false;
						} else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
	    				}	
						$scope.idEmpleado = asistencia.idEmpleado;						
						$http({
						    method: 'GET',
						    url: 'http://localhost:8080/CuadrillasWEB/EntradaAsistencia',
						    params: {
								"idEmpleado" : $scope.idEmpleado,
								"comentarios" : asistencia.observacion,
								"usuario" : data.data.usuario.usuario
						       }
						  }).then(function mySucces(response) {
							    $('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
								$scope.form_reloj.$setPristine();
						  	 console.info(response);
						  }, function myError(response) {
							   $('#msload').modal('hide');
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
						      console.error(response); 
						  });
        	   }
        	   };
           
            $scope.salida = function(asistencia) {
            	
            var confirmar = confirm("¿Esta seguro de registrar la salida?"); 

				if (!confirmar) 
				{
					$('#alert').show();
					 $('#msgerror').text('Se ha cancelado la operacion.'); 
					 $scope.form_reloj.$setPristine(); 
					return false;
				}  else  {
					 $('#msload').modal('show');
					 $('#alert').hide();
				}	
            	
              $scope.idEmpleado = asistencia.idEmpleado;
              
        		$http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWEB/SalidaAsistencia',
                    params: {
      		 		"idEmpleado" : $scope.idEmpleado,
      		 		"usuario" : 'SISTEMAS'
      		         }
      		    }).then(function mySucces(response) {
      		    	$('#msload').modal('hide');
					$('#success').show();
					$('#msgaviso').text(response.data.mensajeFuncional);
					 $scope.form_reloj.$setPristine();
     		    	 console.info(response);
      		    }, function myError(response) {
      		    	$('#msload').modal('hide');
					$('#alert').show();
					$('#msgerror').text(response.data.mensajeFuncional);
      		        console.error(response);
      		    });
        	   };
           
});