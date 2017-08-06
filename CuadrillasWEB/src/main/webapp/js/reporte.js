app.controller('reporte', function ($scope, $http) {	
	  // msload 
		$('#success').hide();
	    $('#alert').hide();
	    //$('#msload').modal('show');
	    
	    var fechaInicioForm=$('input[name="fechaInicial"]');
	    var fechaTerminoForm=$('input[name="fechaFinal"]');
	    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	    
	    fechaInicioForm.datepicker({
	    	language: 'es',
	    	format: 'yyyy-mm-dd',
	        container: container,
	        todayHighlight: true,
	        autoclose: true
	      });
        fechaTerminoForm.datepicker({
        	language: 'es',
        	format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        });	    
	    					
        $scope.consultar = function() {
        	var fechaInicial = $('#fechaInicial').val();
        	var fechaFinal = $('#fechaFinal').val();
        	
        	$('#msload').modal('show');
        	
        	$scope.datos = {};
			$scope.encabezados = [];
        	
        	if ($scope.validarCampos() == false)
        	{
        		$('#msload').modal('hide');
        		return;
        	}
        	
        	$http({
                method: 'GET',
                url: '/CuadrillasWEB/ReporteAsistencia',
                params : {		 			
		 			"fechaInicio" 	: fechaInicial,
		 			"fechaFin"	: fechaFinal
		 		},
		 		data: {}
  		    }).then(function mySucces(result) {
  		    	$('#msload').modal('hide');
  				$('#alert').hide();
  				$('#success').hide();
  				//console.info(result.data.catalogo);
  				$scope.nombreColumnas = _getHeaders(result.data.reporte);
  				$scope.encabezados = result.data.encabezado;
  				//console.info("cabecera");
  				//console.info($scope.nombreColumnas);
  				//console.info($scope.encabezados);
  				$scope.datos = result.data.reporte;                
  		    }, function myError(response) {
  		    	$('#msload').modal('hide');
  		        console.error(response);
  		        $('#alert').show();
  				$('#msgerror').text(response.data.header.mensajeFuncional);
  		    });	     
        };
        
        $scope.exportar = function() {
        	var fechaInicial = $('#fechaInicial').val();
        	var fechaFinal = $('#fechaFinal').val();
        	
        	$('#msload').modal('show');        	
//        	$scope.datos = {};
//			$scope.encabezados = [];
        	
        	
        	if ($scope.validarCampos() == false)
        	{
        		$('#msload').modal('hide');
        		return;
        	}
        	
        	//console.info("/CuadrillasWEB/ReporteAsistenciaExportar?fechaInicio="+ fechaInicial +"&fechaFin=" + fechaFinal);
        	location.href="/CuadrillasWEB/ReporteAsistenciaExportar?fechaInicio="+ fechaInicial +"&fechaFin=" + fechaFinal;        	
        	
        	$('#msload').modal('hide');        		
        	/*
        	$http({
                method: 'GET',
                url: '/CuadrillasWEB/ReporteAsistenciaExportar',
                params : {		 			
		 			"fechaInicio" 	: fechaInicial,
		 			"fechaFin"	: fechaFinal
		 		},
		 		data: {}
  		    }).then(function mySucces(result) {
  		    	$('#msload').modal('hide');
  				$('#alert').hide();
  				$('#success').hide();
  				//console.info(result.data.catalogo);
  				//$scope.nombreColumnas = _getHeaders(result.data.reporte);
  				//$scope.encabezados = result.data.encabezado;
  				//console.info("cabecera");
  				//console.info($scope.nombreColumnas);
  				//console.info($scope.encabezados);
  				//$scope.datos = result.data.reporte;                
  		    }, function myError(response) {
  		    	$('#msload').modal('hide');
  		        console.error(response);
  		        $('#alert').show();
  				$('#msgerror').text(response.data.header.mensajeFuncional);
  		    });
  		    */	     
        };                        
        
        //$scope.consultar();
        
        function _getHeaders(items) {
            var headers = [];
            var temporal = []
            angular.forEach(items, function (item) {
            	if (temporal.length == 0)
                	temporal.push(Object.getOwnPropertyNames(item));
            });
             
            if (temporal.length > 0)
            {
            	for(var i=0; i < temporal[0].length; i++)
            	{
            		if (temporal[0][i] != "tipo")
            			headers.push(temporal[0][i]);
            	}
            }

            //console.info(headers);
            return headers;
        };       
		
	
		//para ocultar las alertas
		$scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		
		$scope.limpiarCampos = function(formEmpleado) {
			$scope.datos = {};
			$scope.encabezados = [];
			$('#fechaInicial').val('');
			$('#fechaFinal').val('');
		};
		
		$scope.validarCampos = function()
		{
	    	var correcto = true;
        	var fechaInicial = $('#fechaInicial').val();
        	var fechaFinal = $('#fechaFinal').val();
        	var cadena = "";
	    	
        	if (fechaInicial == '' || fechaFinal == '')
        	{
        		cadena = "Deben ser capturadas las 2 fechas, favor de verificar."
        		correcto = false;
        	}
        	
        	if (correcto == true)
        	{
        		if(validate_fechaMayorQue(fechaInicial,fechaFinal))
        		{
        			//document.write("La fecha "+fechaFinal+" es superior a la fecha "+fechaInicial);
        		}else{
        			correcto = false;
        			cadena = "La fecha "+fechaFinal+" debe ser mayor a la fecha "+fechaInicial + ", favor de verificar";
        		}
        	}
        	
							
        	if (correcto == false)
        	{
				$('#alert').show();
				$('#msgerror').text(cadena);
        	}
        	else
        	{
        		$('#alert').hide();
        	}
			return correcto;			
			
		};
		
		function validate_fechaMayorQue(fechaInicial,fechaFinal)
        {
        	//formato fechas aaaa-mm-dd
            valuesStart=fechaInicial.split("-");
            valuesEnd=fechaFinal.split("-");
            
 
            // Verificamos que la fecha no sea posterior a la actual
            var dateStart=new Date(valuesStart[0],(valuesStart[1]-1),valuesStart[2]);
            var dateEnd=new Date(valuesEnd[0],(valuesEnd[1]-1),valuesEnd[2]);
            if(dateStart>=dateEnd)
            {
                return 0;
            }
            return 1;
        }
		 		 	 
	});
