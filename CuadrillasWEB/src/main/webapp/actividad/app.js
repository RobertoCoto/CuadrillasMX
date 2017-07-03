$(document).ready(function(){
    $('.collapsible');
    $('.modal').modal({
        dismissible: false
    });
    $('select').material_select();
});
var dataBckp;
var asyncLoop = function(o){
    var i=-1, length = o.length;
    
    var loop = function(){
        i++;
        if( i == length) {
            o.callback(); return;
        }
        o.forHSA(loop, i);
    } 
    loop();
}
angular.module('tatei', ['ui.materialize'])

    .controller('AppCtrl', function($scope, $http) {
        $('#msload').show();
        $scope.toast = function (message, duration) {
            Materialize.toast(message, duration);
        }

        $scope.consultaAgenda = function(idAgenda) {

            $http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWS/service/consultaActividadDiaria/actividad?idAgendaDetalle=' + idAgenda
            }).then(function successCallback(response) {
                //console.log(response);
                //$('#msload').hide();
                var datos = response.data.actividadDiaria;
                $scope.listaActividades = datos.actividadDiariaDetalle;
                $scope.tramoInicialP = datos.coordenadasEsperado[0].direccion;
                $scope.tramoFinalP = datos.coordenadasEsperado[datos.coordenadasEsperado.length-1].direccion;

                
                var coordenadasArray = response.data.actividadDiaria.coordenadasEsperado;
                asyncLoop({
                    length : coordenadasArray.length,
                    forHSA : function(loop, i){
                        setTimeout(function(){
                            $scope.setDireccionEnReversaEditar(coordenadasArray[i].latitud, coordenadasArray[i].longitud, coordenadasArray[i].direccion);
                            loop();
                        },1500);
                    },
                    callback : function(){
                        $('#msload').hide();
                    }    
                });
                

            }, function errorCallback(response) {
                console.error(response);
            });
        }

        $scope.consultaAgenda(1);

        var actividads = this;
        actividads.allsQ = [];

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
                                //setTimeout(function () {
            geocoder.geocode({'location': latlng}, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    map.setCenter(results[0].geometry.location);
                    map2.setCenter(results[0].geometry.location);
                    $scope.setMarcadorEdicion(results[0].geometry.location, direccion);
                }
            });
                                //}, 100);
        }
        //***marcadores edicion map1
		$scope.setMarcadorEdicion = function(latLng, direccion) {

			// $('#msload').show();
            var geocoder = new google.maps.Geocoder;
            var img_mark = 'mark.png';
            var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
            medida.mvcLine.push(latLng);
            medida.mvcPolygon.push(latLng);
            medida.mvcMarkers.push(marcador);
            var latLngIndex = medida.mvcLine.getLength() - 1;
            var latlng = {lat: latLng.lat, lng: latLng.lng};
            //var direccion = 'SN';
            /* console.log(results);
            $( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
            		+ "<td class=\"td\" width=\"30px\"> </td>"
            		+ "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
            		+ "</tr>") );
			// $('#msload').hide();*/
	        $scope.mLineaRectaEdita();

	        //var km = $scope.mapa.metros / metros_div;
	        //var unidad_de_medida = "metros";

        };
        $scope.mLineaRectaEdita = function() {
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
        };
        $scope.setMarcador = function(latLng) {
  			var validaDiaSel = $scope.validaSeleccion();
  			if (validaDiaSel == false)
  			{
  				return;
  			}

  			//si ya esta agregado a la agenda se debe eliminar para poder editar
  			var fecha = $('#diaActividad').val(); 
  			var agendado = $scope.validaAgendaAgregada(fecha);
  			if (agendado)
  			{
  				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
  				return;
  			}

        	$('#msload').show();
            var geocoder = new google.maps.Geocoder;
            var img_mark = 'altaContrato/mark.png';
            var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
            medida.mvcLine.push(latLng);
            medida.mvcPolygon.push(latLng);
            medida.mvcMarkers.push(marcador);
            var latLngIndex = medida.mvcLine.getLength() - 1;
            google.maps.event.addListener(marcador, "drag", function(evt) {
            	medida.mvcLine.setAt(latLngIndex, evt.latLng);
                medida.mvcPolygon.setAt(latLngIndex, evt.latLng);
            });

            google.maps.event.addListener(marcador, "dragend", function() {
            	alert(medida.mvcLine.getLength());
                if (medida.mvcLine.getLength() > 1) {
                    $scope.calculaDistancia();
                }
            });

            var latlng = {lat: latLng.lat(), lng: latLng.lng()};
            var direccion = 'SN';
            geocoder.geocode({'location': latlng}, function(results, status) {
            	// console.log(results);
            	if (status === google.maps.GeocoderStatus.OK) {
            		if (results[1]) {
            			direccion =  results[0].formatted_address;
            			var coordenadaP = {};
            			var coordenadasTemp = [];
            			coordenadaP.latitud = latLng.lat();
            			coordenadaP.longitud = latLng.lng();
            			coordenadaP.direccion = direccion;
            			// if($scope.contratoFocus.coordenadas) {
            			$scope.mapa.gridCoordenadas.push(coordenadaP);
            				// console.info($scope.mapa);
            			// } else {
            			// coordenadasTemp.push(coordenadaP);
                        // $scope.contratoFocus.coordenadas = coordenadasTemp;
            			// }

            			$( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
            					+ "<td class=\"td\" width=\"30px\"> </td>"
            					+ "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
            					+ "</tr>") );

                    } else {
                    	$('#alert').show();
                    	$('#msgerror').text('No se encontro una direcci�n disponible.')
                          // alert('No se encontraron resultados');
                    }
            		$('#msload').hide();
            	} else {
            		$('#alert').show();
                    $('#msgerror').text('Problemas en la geolocalizaci�n debido ' + status + '')
                    // alert('Geocoder fallo debido al estatus: ' + status);
					$('#msload').hide();
            	}
            });


            $scope.mLineaRecta();
    		reseteaColorBotones();
			cambiaColorBoton($scope.mapa);
      };

    })
    
    .controller("ModalController", function ($scope, $http) {
        $scope.readyCallback = function () {
            Materialize.toast("listo", 1000);
        }
        $scope.completeCallback = function () {
            //Materialize.toast("Cancelado", 1000);
            $scope.actividad = dataBckp;
        }
        $scope.guardarActividadDetalle = function(data) {
            console.info(data);
            data.usuarioAlta = 'test';
            var jsonData = JSON.stringify(data);
            $http({
                method: "GET",
                url: "http://localhost:8080/CuadrillasWS/service/registraActividadDiaria/actividad",
                params: {jsonRegistraActividad: jsonData}

            }).then(function mySuccess(response) {
                console.info(response);
                if(response.data.estatus) {
                    $('#edicionActividades').modal('close');
                    Materialize.toast(response.data.mensajeFuncional, 7000);
                    dataBckp = data;
                } else {
                    data = dataBckp;
                    Materialize.toast(response.data.mensajeFuncional, 7000);
                }

            }, function myError(response) {
                console.log(response);
            });
        }
        $scope.abrir = function(actividad){
            dataBckp = actividad;
            //console.info(actividad);
            $('#msload').show();

            $scope.actividad = actividad;
            //Catalogo Atividad
            $http({
            method: 'GET',
            url: 'http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=ACTIVIDADE'
            }).then(function successCallback(response) {
                //console.log(response);
                $scope.actividadesCat = response.data.catalogo;

                //Catalogo Estado
                $http({
                method: 'GET',
                url: 'http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=ESTA_ACT'
                }).then(function successCallback(response) {                    
                    $scope.estadoCat = response.data.catalogo;

                    //Catalogo Prioridad
                    $http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=PRIO_ACT'
                    }).then(function successCallback(response) {
                        //console.log(response);
                        $scope.prioridadCat = response.data.catalogo;

                        //Catalogo Listo Vencido
                        $http({
                        method: 'GET',
                        url: 'http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LIST_VENC'
                        }).then(function successCallback(response) {
                            //console.log(response);
                            $scope.listoVencidoCat = response.data.catalogo;
                            $('#msload').hide();
                            Materialize.updateTextFields();
                        }, function errorCallback(response) {
                            console.error(response);
                        });
                        
                    }, function errorCallback(response) {
                        console.error(response);
                    });

                }, function errorCallback(response) {
                    console.error(response);
                });

            }, function errorCallback(response) {
                console.error(response);
            });

        }
        $scope.openModal = false;
    });;