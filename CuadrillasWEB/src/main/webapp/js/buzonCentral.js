app.controller('buzon', function ($scope, $http) {
	  // msload 
		$('#success').hide();
	    $('#alert').hide();
	    $('#msload').modal('show');
	    
	//Consulta todas las tareas pendientes
	$scope.buzonTarea = function() {
		$('#msload').modal('show');
	    $http({		
		method: 'GET',
		url: 'http://localhost:8080/CuadrillasWEB/ConsultaTareas',
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
      $scope.notificar = function(tareas) {
    	    $scope.idImss = tareas.id;
    	     window.open('http://localhost:8080/CuadrillasWEB/altaImss/alta_imss.html?idEmpleado='+ $scope.idImss, '_blank','heigth=300,width=500');
    	  };
    	  
    	  //abre una ventana para autorizacion laboral
      $scope.autorizar = function(tareas) {
    	  $scope.idPermiso = tareas.id;
    	  window.open('http://localhost:8080/CuadrillasWEB/permiso/autorizacion.html?idPermiso='+ $scope.idPermiso, '_blank','heigth=600,width=600');
    	  };
	 
    	  $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		  $scope.actualizaTareas = function() {
			  $scope.buzonTarea();
			  };
		  
	});
