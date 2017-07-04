var app = angular.module('tatei', []);
app.controller('autorizaActividad', function ($scope, $http, $window) {
	$scope.id = $window.idActividadDiaria;
	$scope.usuario = $window.user;
	$scope.fecha = $window.fechaTarea;

	// msload 
	$('#success').hide();
    $('#alert').hide();
    $('#msload').modal('show');
    $('#tablaDocumentos').hide();
    $scope.nContrato = true;
    //obtiene el id y consulta las actividades
	    $scope.consultaActividad = function() {
			$('#msload').modal('show');
			$http({
					method: 'GET',
					url: '/CuadrillasWEB/ConsultaActividadDiariaBuzon',
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
						url: '/CuadrillasWEB/ConsultaActividadDocumentos',
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
				
				//autoriza la actividad
				$scope.autorizarActividad = function(actividad) {
					$scope.comentario  = $('#comentarioActividad').val();
					var confirmar = confirm("�Esta seguro de autorizar la actividad?"); 
						if (!confirmar) 
						{
							 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
								return false;
						}else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
						} 
						$http({
				              method: 'GET',
				              url: '/CuadrillasWEB/AutorizaActividadBuzon',
				    	 params: {
					 		"idActividadDiaria" : $scope.id,
					 		"envioAutorizacion" : "S",
					 		"autorizacion" : "S",
					 		"comentario": $scope.comentario,
					 		"usuario": $scope.usuario
					         }
						    }).then(function mySucces(response) {
						    	$('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
						    	 console.info(response);
						    	 //opener.top.location.reload();
						    }, function myError(response) {
						    	$('#msload').modal('hide');
						    	$('#success').hide();
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
						        console.error(response);
						    });
					};
					
					//para rechazar actividad
					$scope.rechazarActividad = function(actividad) {
						var confirmar = confirm("�Esta seguro de rechazar el permiso?"); 
						if (!confirmar) 
						{
							 $('#alert').show();
							 $('#msgerror').text('Se ha cancelado la operacion.');
								return false;
						}else  {
							 $('#msload').modal('show');
							 $('#alert').hide();
						}
						$http({
				              method: 'GET',
				              url: '/CuadrillasWEB/AutorizaActividadBuzon',
				    	 params: {
					 		"idActividadDiaria" : $scope.id,
					 		"envioAutorizacion" : "N",
					 		"autorizacion" : "N",
					 		"comentario": $scope.comentario,
					 		"usuario": $scope.usuario
					         }
						    }).then(function mySucces(response) {
						    	$('#msload').modal('hide');
								$('#success').show();
								$('#msgaviso').text(response.data.mensajeFuncional);
						    	 console.info(response);
						    	 //opener.top.location.reload();
						    }, function myError(response) {
						    	$('#msload').modal('hide');
						    	$('#success').hide();
								$('#alert').show();
								$('#msgerror').text(response.data.mensajeFuncional);
						        console.error(response);
						    });
						};
						
						// oculta las alertas
						$scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
						};
						
						//para visualizar las fotos obtenidas 
					$scope.visualizaFoto = function(documento) {
						$scope.url = documento.url;
						var $popup = $window.open('/CuadrillasWEB/RevisaActividadDocumentos?url='+ $scope.url, '_blank','heigth=600,width=600');
						 console.log("fotoncini: " + $scope.url);
						};
					
		var map;
		var map2;
        var medida;
        var medida2;
       $scope.cargarMapa =  function initMap() {
    	   medida = {
               mvcLine: new google.maps.MVCArray(),
               mvcPolygon: new google.maps.MVCArray(),
               mvcMarkers: new google.maps.MVCArray(),
               line: null,
               polygon: null
           };
           var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
           map = new google.maps.Map(document.getElementById('map'), {
             zoom: 7,
             center: mx1
           });
           /*var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
           var mx2 = {lat: 19.38962144393955, lng: -99.04332534816899};

           var marker = new google.maps.Marker({
             position: mx1,
             map: map
           });
           var marker = new google.maps.Marker({
             position: mx2,
             map: map
           }); */
           google.maps.event.addListener(map, 'click', function(event) {
               //console.log(event);
										if($scope.nContrato) {
               	$scope.setMarcador(event.latLng);
										} else {
											if($scope.edicionMap){
												$scope.setMarcador(event.latLng);
											} else {
												$scope.setMarcadorEdicion(event.latLng);
											}
										}
           });
          };
          
          $scope.cargarMapa2 =  function initMap2() {
            medida2 = {
                mvcLine: new google.maps.MVCArray(),
                mvcPolygon: new google.maps.MVCArray(),
                mvcMarkers: new google.maps.MVCArray(),
                line: null,
                polygon: null
            };
            var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
            map2 = new google.maps.Map(document.getElementById('map2'), {
              zoom: 7,
              center: mx1
            });
            google.maps.event.addListener(map2, 'click', function(event) {
                //console.log(event);
 										if($scope.nContrato) {
                	$scope.setMarcador2(event.latLng);
 										} else {
 											if($scope.edicionMap){
 												$scope.setMarcador2(event.latLng);
 											} else {
 												$scope.setMarcadorEdicion2(event.latLng);
 											}
 										}
            });
          };
         
	     // $scope.cargarMapa2();
            var markers = [];
            $scope.metros = null;
          $scope.showMap = function(actividad) {
        	  $scope.cargarMapa();
        	  for (var i = 0; i < actividad.coordenadas.length; i++) {
              	$scope.setDireccionEnReversaEditar(actividad.coordenadas[i].latitud, actividad.coordenadas[i].longitud, actividad.coordenadas[i].direccion);
          };
									$scope.edicionMap = true;								
									$("#tramos").empty();
        	  };
        	  
        	  $scope.mostrarReal = function(actividad) {
        		  $scope.cargarMapa2();
            	  for (var i = 0; i < actividad.coordenadas.length; i++) {
                  	$scope.setDireccionEnReversaEditar2(actividad.coordenadas[i].latitud, actividad.coordenadas[i].longitud, actividad.coordenadas[i].direccion);
              };
    									$scope.edicionMap = true;								
    									$("#tramos2").empty();
        		  };
        	  
        	  $scope.setMarcadorEdicion = function(latLng, direccion) {
						var geocoder = new google.maps.Geocoder;
						var img_mark = 'mark.png';
						var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
						medida.mvcLine.push(latLng);
						medida.mvcPolygon.push(latLng);
						medida.mvcMarkers.push(marcador);
						var latLngIndex = medida.mvcLine.getLength() - 1;
						var latlng = {lat: latLng.lat, lng: latLng.lng};
											if(!direccion){
												direccion = 'SN';
											}
						//console.log(results);
						$( "#tramos" ).append( $("<td class=\"td\" >"+ direccion +" </td>"
						 ));
											//$('#msload').modal('hide');
						$scope.mLineaRecta();
        	  		};
        	  		
        	  		$scope.setMarcadorEdicion2 = function(latLng, direccion) {
						var geocoder = new google.maps.Geocoder;
						var img_mark = 'mark.png';
						var marcador = new google.maps.Marker({map: map2, position: latLng, icon: img_mark, draggable: false});
						medida2.mvcLine.push(latLng);
						medida2.mvcPolygon.push(latLng);
						medida2.mvcMarkers.push(marcador);
						var latLngIndex = medida2.mvcLine.getLength() - 1;
						var latlng = {lat: latLng.lat, lng: latLng.lng};
											if(!direccion){
												direccion = 'SN';
											}
						//console.log(results);
						$( "#tramos2" ).append( $("<td class=\"td\" >"+ direccion +" </td>"
						 ));
											//$('#msload').modal('hide');
						$scope.mLineaRecta2();
        	  		};
        	  		
        	  		$scope.calculaDistancia = function() {
                        var length = 0;
                        if (medida.mvcPolygon.getLength() > 1) {
                            length = google.maps.geometry.spherical.computeLength(medida.line.getPath());
                        }
                        var area = 0;
                        if (medida.mvcPolygon.getLength() > 2) {
                            area = google.maps.geometry.spherical.computeArea(medida.polygon.getPath());
                        }
                    //    lM = document.forms["mb"].elements["mode"][0].checked;
                        var km = length / 1000;
                        var unidad_de_medida = " metros";
                        $scope.metros = length;
                        console.log($scope.metros);
                        $( "#km" ).text(length.toFixed(2) + unidad_de_medida);
  											$( "#txtkm" ).text('Distancia');
                        //console.log('Distancia total:' + length.toFixed(0) + ' metros ' +  km.toFixed(3));
                    };
                    
                    $scope.calculaDistancia2 = function() {
                        var length = 0;
                        if (medida2.mvcPolygon.getLength() > 1) {
                            length = google.maps.geometry.spherical.computeLength(medida2.line.getPath());
                        }
                        var area = 0;
                        if (medida2.mvcPolygon.getLength() > 2) {
                            area = google.maps.geometry.spherical.computeArea(medida2.polygon.getPath());
                        }
                    //    lM = document.forms["mb"].elements["mode"][0].checked;
                        var km = length / 1000;
                        var unidad_de_medida = " metros";
                        $scope.metros = length;
                        console.log($scope.metros);
                        $( "#km2" ).text(length.toFixed(2) + unidad_de_medida);
  											$( "#txtkm2" ).text('Distancia');
                        //console.log('Distancia total:' + length.toFixed(0) + ' metros ' +  km.toFixed(3));
                    };
                    
                    

                    $scope.mLineaRecta = function() {
                        if (medida.mvcLine.getLength() > 1) {
                            if (!medida.line) {
                                medida.line = new google.maps.Polyline({
                                    map: map,
                                    clickable: false,
                                    strokeColor: "#ad04ef",
                                    strokeOpacity: 1,
                                    strokeWeight: 3,
                                    path: medida.mvcLine
                                });
                            }

                            if (medida.mvcPolygon.getLength() > 2) {

                                if (medida.polygon != null)
                                {
                                    medida.polygon.setMap(null);
                                }


                                medida.polygon = new google.maps.Polygon({
                                    clickable: false,
                                    map: map,
                                    fillOpacity: 0.0,
                                    strokeOpacity: 0,
                                    paths: medida.mvcPolygon
                                });

                            }
                        }
                        if (medida.mvcLine.getLength() > 1) {
                            $scope.calculaDistancia();
                        }
                    };
                    
                    $scope.mLineaRecta2 = function() {
                        if (medida2.mvcLine.getLength() > 1) {
                            if (!medida2.line) {
                                medida2.line = new google.maps.Polyline({
                                    map: map2,
                                    clickable: false,
                                    strokeColor: "#ad04ef",
                                    strokeOpacity: 1,
                                    strokeWeight: 3,
                                    path: medida2.mvcLine
                                });
                            }

                            if (medida2.mvcPolygon.getLength() > 2) {

                                if (medida2.polygon != null)
                                {
                                    medida2.polygon.setMap(null);
                                }


                                medida2.polygon = new google.maps.Polygon({
                                    clickable: false,
                                    map: map2,
                                    fillOpacity: 0.0,
                                    strokeOpacity: 0,
                                    paths: medida2.mvcPolygon
                                });

                            }
                        }
                        if (medida2.mvcLine.getLength() > 1) {
                            $scope.calculaDistancia2();
                        }
                    }

                    $scope.setDireccionEnReversa = function(lat, lng) {
                        var latlng = {lat: lat, lng: lng};
                        var geocoder = new google.maps.Geocoder();
                        //var address = document.getElementById('direccion').value;
                        //geocoder.geocode({'address': address}, function(results, status) {
                        geocoder.geocode({'location': latlng}, function(results, status) {
                            if (status == google.maps.GeocoderStatus.OK) {
                                map.setCenter(results[0].geometry.location);
                                $scope.setMarcador(results[0].geometry.location);
                            } else {
                                alert('No se encontro la direccion , debido: ' + status);
                            }
                        });
                    }
  									$scope.setDireccionEnReversaEditar = function(lat, lng, direccion) {
                        var latlng = {lat: lat, lng: lng};
  											var geocoder = new google.maps.Geocoder();
  											setTimeout(function () {
  													geocoder.geocode({'location': latlng}, function(results, status) {
  		                          if (status == google.maps.GeocoderStatus.OK) {
  		                              map.setCenter(results[0].geometry.location);
  																	$scope.setMarcadorEdicion(results[0].geometry.location, direccion);
  		                          }
  		                      });
  											}, 100);
  											
  											


                    }
  									
                    $scope.setDireccionEnReversa2 = function(lat, lng) {
                        var latlng = {lat: lat, lng: lng};
                        var geocoder = new google.maps.Geocoder();
                        //var address = document.getElementById('direccion').value;
                        //geocoder.geocode({'address': address}, function(results, status) {
                        geocoder.geocode({'location': latlng}, function(results, status) {
                            if (status == google.maps.GeocoderStatus.OK) {
                                map2.setCenter(results[0].geometry.location);
                                $scope.setMarcador(results[0].geometry.location);
                            } else {
                                alert('No se encontro la direccion , debido: ' + status);
                            }
                        });
                    }
  									$scope.setDireccionEnReversaEditar2 = function(lat, lng, direccion) {
                        var latlng = {lat: lat, lng: lng};
  											var geocoder = new google.maps.Geocoder();
  											setTimeout(function () {
  													geocoder.geocode({'location': latlng}, function(results, status) {
  		                          if (status == google.maps.GeocoderStatus.OK) {
  		                              map2.setCenter(results[0].geometry.location);
  																	$scope.setMarcadorEdicion2(results[0].geometry.location, direccion);
  		                          }
  		                      });
  											}, 100);
  											
  											


                    }

                    $scope.limpiarMarcadores = function() {
                        if (medida.polygon) {
                            medida.polygon.setMap(null);
                            medida.polygon = null;
                        }
                        if (medida.line) {
                            medida.line.setMap(null);
                            medida.line = null
                        }
                        medida.mvcLine.clear();
                        medida.mvcPolygon.clear();
                        medida.mvcMarkers.forEach(function(elem, index) {
                            elem.setMap(null);
                        });
                        $scope.contratoFocus.coordenadas = [];
                        medida.mvcMarkers.clear();
                        $( "#tramos" ).empty();
                        $( "#km" ).text('');
  					  $( "#txtkm" ).text('');
                        //document.getElementById('lineLength').innerHTML = '';
                        //document.getElementById('polyArea').innerHTML = '';
                    }
	});
