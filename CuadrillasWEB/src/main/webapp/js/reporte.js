app.controller('reporte', function ($scope, $http, $q) {	
	  // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('hide');
	    
	    var fechaInicioForm=$('input[name="fechaInicial"]');
	    var fechaTerminoForm=$('input[name="fechaFinal"]');
	    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	    
	    fechaInicioForm.datepicker({
	    	format: 'yyyy-mm-dd',
	        container: container,
	        todayHighlight: true,
	        autoclose: true,
	      });
        fechaTerminoForm.datepicker({
        	format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true,
        });	    
	    					
        $scope.consultar = function() {
        	fechaInicial = $('#fechaInicial').val();
        	fechaFinal = $('#fechaFinal').val();
        	$http({
                method: 'GET',
                url: '/CuadrillasWEB/ConsultaCatalogo',
                params : {
		 			"tipoCatalogo"	: 'PERFIL_EMP'//,
		 			//"fechaInicial" 	: fechaInicial,
		 			//"fechaFinal"	: fechaFinal
		 		},
		 		data: {}
  		    }).then(function mySucces(result) {
  		    	$('#msload').modal('hide');
  				$('#alert').hide();
  				$('#success').hide();
  				//console.info(result.data.catalogo);
  				$scope.encabezados = _getHeaders(result.data.catalogo);
  				//console.info("encabezados");
  				//console.info($scope.encabezados);
  				$scope.datos = result.data.catalogo;                
  		    }, function myError(response) {
  		    	$('#msload').modal('hide');
  		        console.error(response);
  		        $('#alert').show();
  				$('#msgerror').text(response.data.header.mensajeFuncional);
  		    });	     
        };                
        
        $scope.consultar();
        
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
		 		 	 
	});
