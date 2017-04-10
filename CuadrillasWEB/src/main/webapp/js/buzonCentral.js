app.controller('buzon', function ($scope, $http, $window) {
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
    	  var $popup = $window.open('http://localhost:8080/CuadrillasWEB/altaImss/alta_imss.html', '_blank','heigth=300,width=500');
 	     $popup.idImss = tareas.id;
 	    $popup.user = data.data.usuario.usuario;
    	  };
    	  
    	  //abre una ventana para autorizacion laboral
      $scope.autorizar = function(tareas) {
    	  var $popup = $window.open('http://localhost:8080/CuadrillasWEB/permiso/autorizacion.html', '_blank','heigth=600,width=600');
    	  $popup.idPermiso = tareas.id;
    	  $popup.user = data.data.usuario.usuario;
    	  };
    	  
    	  //abre una ventana para autorizacion de la actividad
      $scope.autorizarActividad = function(tareas) {
    	  var $popup = $window.open('http://localhost:8080/CuadrillasWEB/actividades/autorizacionActividadesDiarias.html', '_blank','heigth=600,width=600');
    	  $popup.idActividadDiaria = tareas.id;
    	  $popup.user = data.data.usuario.usuario;
    	  $popup.fechaTarea = tareas.fechaTarea;
    	  };
	 
    	  $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					};
		  $scope.actualizaTareas = function() {
			  $scope.buzonTarea();
			  };
		  
	});
