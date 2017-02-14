var app = angular.module('tatei', []);
app.controller('buzon', function ($scope, $http) {
	//Consulta todas las tareas pendientes
	 $http({
	        method: 'GET',
	        url: 'http://localhost:8080/CuadrillasWEB/ConsultaTareas',
	        data: { }
		    }).then(function (result) {
		    	$scope.resultado = result.data.buzon;
	          console.log($scope.resultado);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		    });
	 
		    
      $scope.notificar = function(tareas) {
    	    $scope.idImss = tareas.id;
    	     window.open('http://localhost:8080/CuadrillasWEB/altaImss/alta_imss.html?idEmpleado='+ $scope.idImss, '_blank','heigth=300,width=500');
    	  };
    	  
      $scope.autorizar = function(tareas) {
    	  $scope.idPermiso = tareas.id;
    	  window.open('http://localhost:8080/CuadrillasWEB/permiso/autorizacion.html?idPermiso='+ $scope.idPermiso, '_blank','heigth=600,width=600');
    	  };
	 
	});
