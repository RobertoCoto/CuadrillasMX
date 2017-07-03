app.controller('buzonResidente', function ($scope, $http) {
	  // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
	//Consulta todas las tareas pendientes
	$scope.buzonTarea = function() {
		$('#msload').modal('show');
	    $http({		
		method: 'GET',
		url: '/CuadrillasWEB/ConsultaBuzonResidente',
	    params: {
        	'idCuadrilla'	: $scope.usuario.idCuadrilla        	
      	},
		data: { }
		}).then(function (result) {
			$('#msload').modal('hide');
			$('#alert').hide();
			$('#success').hide();
			$scope.resultado = result.data.buzon;
		  console.log($scope.resultado);
		}, function myError(response) {
			$('#msload').modal('hide');
		    console.error(response);
		    $('#alert').show();
			$('#msgerror').text(response.data.header.mensajeFuncional)
		});
		};
	$scope.buzonTarea();	
		
	 
		 //abre una ventana para notificar imss   
      $scope.capturarActividades = function(tareas) {
    	  var $popup = $window.open('/CuadrillasWEB/actividad/index.html', '_blank','heigth=600,width=600');
    	  $popup.idAgendaDetalle = tareas.id;
    	  $popup.user = data.data.usuario.usuario;    	      	 
    	  };
    	  

	 
    	  $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		  $scope.actualizaTareas = function() {
			  $scope.buzonTarea();
			  };
		  
	});
