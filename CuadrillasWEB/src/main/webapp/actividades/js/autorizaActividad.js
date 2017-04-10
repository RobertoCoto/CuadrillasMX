var app = angular.module('tatei', []);
app.controller('autorizaActividad', function ($scope, $http, $window) {
	$scope.id = $window.idActividadDiaria;
	$scope.usuario = $window.user;
	$scope.fecha = $window.fechaTarea;
console.log ($scope.fecha);
	// msload 
	$('#success').hide();
    $('#alert').hide();
    $('#msload').modal('show');
    $('#tablaDocumentos').hide();
    //obtiene el id y consulta las actividades
	    $scope.consultaActividad = function() {
			$('#msload').modal('show');
			$http({
					method: 'GET',
					url: 'http://localhost:8080/CuadrillasWEB/ConsultaActividadDiariaBuzon',
					params: {
							"idActividadDiaria" : $scope.id
					     },
					data: { }
					}).then(function (result) {
						$('#msload').modal('hide');
						$('#alert').hide();
						$('#success').hide();
						$scope.actividad = result.data.actividadDiaria;
						$scope.actividad.fechaActividad = $scope.fecha;
					    console.log($scope.actividad);
					
					}, function myError(response) {
						$('#msload').modal('hide');
				        console.error(response);
				        $('#alert').show();
						$('#msgerror').text(response.data.header.mensajeFuncional)
					});
			};
			$scope.consultaActividad();
			
			//metodo para mostrar la tabla de documentos
			$scope.muestraDocumento = function(actividades) {
				$('#tablaDocumentos').show();
				console.log(actividades.codigoActividad);
				$scope.codigoActividad = actividades.codigoActividad;
				$('#msload').modal('show');
				$http({
						method: 'GET',
						url: 'http://localhost:8080/CuadrillasWEB/ConsultaActividadDocumentos',
						params: {
								"idActividadDiaria" : $scope.id,
								"codigoActividad" : $scope.codigoActividad
						     },
						data: { }
						}).then(function (result) {
							$('#msload').modal('hide');
							$('#alert').hide();
							$('#success').hide();
							$scope.documentos = result.data.documentos;
						    console.log(result);
						
						}, function myError(response) {
							$('#msload').modal('hide');
					        console.error(response);
					        $('#alert').show();
							$('#msgerror').text(response.data.header.mensajeFuncional)
						});
				};
				
				$scope.autorizarActividad = function(actividad) {
						
					};
				
			
//		var map;
//		var map2;
//        var medida;
//        var medida2;
//       $scope.cargarMapa =  function initMap() {
//            medida = {
//                mvcLine: new google.maps.MVCArray(),
//                mvcPolygon: new google.maps.MVCArray(),
//                mvcMarkers: new google.maps.MVCArray(),
//                line: null,
//                polygon: null
//            };
//            var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
//            map = new google.maps.Map(document.getElementById('map'), {
//              zoom: 7,
//              center: mx1
//            });
//            google.maps.event.addListener(map, 'click', function(event) {
//              //console.log(event);
//                setMarcador(event.latLng);
//            });
//          };
//          
//          $scope.cargarMapa2 =  function initMap2() {
//            medida2 = {
//                mvcLine: new google.maps.MVCArray(),
//                mvcPolygon: new google.maps.MVCArray(),
//                mvcMarkers: new google.maps.MVCArray(),
//                line: null,
//                polygon: null
//            };
//            var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
//            map2 = new google.maps.Map(document.getElementById('map2'), {
//              zoom: 7,
//              center: mx1
//            });
//            google.maps.event.addListener(map2, 'click', function(event) {
//              //console.log(event);
//                setMarcador(event.latLng);
//            });
//          };
//
//            var markers = [];
//      
//      $scope.cargarMapa();
//      $scope.cargarMapa2();
      
     
	});
