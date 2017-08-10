var app = angular.module('tatei', []);
// AUTORIZA ACTIVIDAD
app.controller('autorizaActividad', function ($scope, $http, $window) {
	 var map;
	 var medida;
	 var map2;
	 var medida2;
	

	$scope.id = 1;//$window.idActividadDiaria;	
	$scope.usuario = $window.user;
	$scope.fecha = $window.fechaTarea;	
	var metros_div = 1;
	
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
	};	

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
				url: '/CuadrillasWEB/ConsultaActividadDiariaCampo',
				params: {
						"idAgendaDetalle" : $scope.id
				     },
				data: { }
				}).then(function (result) {
					$('#msload').modal('hide');
					$('#alert').hide();
					$('#success').hide();
					console.info("consulta diaria");
					console.info(result)
					console.info("consulta coordenadas");
					$scope.actividad = result.data.actividadDiaria;
					console.info(result.data.actividadDiaria.coordenadasReal);
					$scope.coordenadasEsperadas = result.data.actividadDiaria.coordenadasEsperado;
					$scope.coordenadasReales = result.data.actividadDiaria.coordenadasReal;					
					$scope.actividad.fechaActividad = $scope.fecha;
				    console.log($scope.actividad);
				
				}, function myError(response) {
					$('#msload').modal('hide');
			        console.error(response);
			        $('#alert').show();
					$('#msgerror').text(response.data.header.mensajeFuncional)
				});
				  
		};
		
		//consulta inicial
		$scope.consultaActividad();
		
 		//***marcadores edicion map1
		$scope.setMarcadorEdicion = function(latLng, direccion) {
			// $('#msload').modal('show');
           var geocoder = new google.maps.Geocoder;
           var img_mark = 'mark.png';
           var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
           medida.mvcLine.push(latLng);
           medida.mvcPolygon.push(latLng);
           medida.mvcMarkers.push(marcador);
           var latLngIndex = medida.mvcLine.getLength() - 1;
           var latlng = {lat: latLng.lat, lng: latLng.lng};
           //var direccion = 'SN';
           // console.log(results);
           $( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
           		+ "<td class=\"td\" width=\"30px\"> </td>"
           		+ "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
           		+ "</tr>") );
			// $('#msload').modal('hide');
	        $scope.mLineaRectaEdita();
	        
            if (medida.mvcLine.getLength() > 1) {
                $scope.calculaDistancia();
            }	        

	        //se suman los tramos de todos los dias de las coordenadas REALES
	        var metrosTotales = 0;
	        /*for (var i=0; i<$scope.coordenadasReales.length; i++)
	        {
	        	//console.info("metros totales");
	        	//console.info($scope.diasAgenda[i].metros);	        	
	        	metrosTotales = metrosTotales + parseFloat($scope.coordenadasReales[i].metros.replace(" mtrs", ""));
	        }*/	        
	        var km = metrosTotales / metros_div;
	        var unidad_de_medida = " metros";
	        //$( "#km" ).text(km.toFixed(2) + ' mts');
	        //$( "#txtkm" ).text('Distancia');

       };
       
       
       $scope.setMarcadorLectura = function(latLng, direccion) {        	        	             	
			// $('#msload').modal('show');
           var geocoder = new google.maps.Geocoder;
           var img_mark = 'mark.png';
           var marcador2 = new google.maps.Marker({map: map2, position: latLng, icon: img_mark, draggable: false});
           medida2.mvcLine.push(latLng);
           medida2.mvcPolygon.push(latLng);
           medida2.mvcMarkers.push(marcador2);
           var latLngIndex = medida2.mvcLine.getLength() - 1;
           var latlng = {lat: latLng.lat, lng: latLng.lng};
           //var direccion = 'SN';
           // console.log(results);
           $( "#tramos2" ).append( $( "<tr class=\"tr\" width=\"493px\">"
           		+ "<td class=\"td\" width=\"30px\"> </td>"
           		+ "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
           		+ "</tr>") );
			// $('#msload').modal('hide');
	        $scope.mLineaRectaLectura();
	        
            if (medida2.mvcLine.getLength() > 1) {
                $scope.calculaDistancia2();
            }	        

	        //se suman los tramos de todos los dias de las coordenadas ESPERADAS
	        var metrosTotales = 0;
	        /*for (var i=0; i<$scope.coordenadasEsperadas.length; i++)
	        {
	        	//console.info("metros totales");
	        	//console.info($scope.diasAgenda[i].metros);	        	
	        	metrosTotales = metrosTotales + parseFloat($scope.coordenadasEsperadas[i].metros.replace(" mtrs", ""));
	        }*/	        
	        var km = metrosTotales / metros_div;
	        var unidad_de_medida = " metros";
	        //$( "#km2" ).text(km.toFixed(2) + ' mts');
	        //$( "#txtkm2" ).text('Distancia');
       };
					
		$scope.initMap = function() {
			medida = {
					mvcLine: new google.maps.MVCArray(),
					mvcPolygon: new google.maps.MVCArray(),
					mvcMarkers: new google.maps.MVCArray(),
					line: null,
					polygon: null
       };
			
       
			
       var mx1 = {lat: 19.433478, lng: -99.133771};
       map = new google.maps.Map(document.getElementById('map'), {
         zoom: 14,
         center: mx1
       });
       google.maps.event.addListener(map, 'click', function(event) {
           	//$scope.setMarcador(event.latLng);

       });
     };

     $scope.initMap2 = function() {
       medida2 = {
           mvcLine: new google.maps.MVCArray(),
           mvcPolygon: new google.maps.MVCArray(),
           mvcMarkers: new google.maps.MVCArray(),
           line: null,
           polygon: null
       };
       var mx12 = {lat: 19.433478, lng: -99.133771};
       map2 = new google.maps.Map(document.getElementById('map2'), {
         zoom: 14,
         center: mx12
       });

       google.maps.event.addListener(map2, 'click', function(event) {
           	//$scope.setMarcadorLectura(event.latLng);
       });
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
     // lM = document.forms["mb"].elements["mode"][0].checked;
         var km = length / metros_div;
         var unidad_de_medida = " metros";
         $( "#km" ).text(km.toFixed(2) + ' mts');
         $( "#txtkm" ).text('Distancia');
         // console.log('Distancia total:' + length.toFixed(0) + ' metros ' +
			// km.toFixed(3));
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
     // lM = document.forms["mb"].elements["mode"][0].checked;
         var km = length / metros_div;
         var unidad_de_medida = " metros";
         $( "#km2" ).text(km.toFixed(2) + ' mts');
         $( "#txtkm2" ).text('Distancia');
         // console.log('Distancia total:' + length.toFixed(0) + ' metros ' +
			// km.toFixed(3));
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

     $scope.mLineaRectaLectura = function() {
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
     };      
     
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
     };

     $scope.setDireccionEnReversaLectura = function(lat, lng, direccion) {
         var latlng = {lat: lat, lng: lng};
         var geocoder = new google.maps.Geocoder();
         setTimeout(function () {
       	  geocoder.geocode({'location': latlng}, function(results, status) {
       		  if (status == google.maps.GeocoderStatus.OK) {
       			  map2.setCenter(results[0].geometry.location);
       			  $scope.setMarcadorLectura(results[0].geometry.location, direccion);        			  
		          }
		      });
         }, 50);
     };      

     $scope.limpiarMarcadores = function(fecha) {
   	 
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
         medida.mvcMarkers.clear();
         $( "#tramos" ).empty();
         $( "#km" ).text('');
		  $( "#txtkm" ).text('');
         // document.getElementById('lineLength').innerHTML = '';
         // document.getElementById('polyArea').innerHTML = '';
     };
     
     $scope.limpiarMarcadoresLectura = function() {

         if (medida2.polygon) {
             medida2.polygon.setMap(null);
             medida2.polygon = null;
         }
         if (medida2.line) {
             medida2.line.setMap(null);
             medida2.line = null
         }
         medida2.mvcLine.clear();
         medida2.mvcPolygon.clear();
         medida2.mvcMarkers.forEach(function(elem, index) {
             elem.setMap(null);
         });
         medida2.mvcMarkers.clear();
         $( "#tramos2" ).empty();
         $( "#km2" ).text('');
		  $( "#txtkm2" ).text('');
         // document.getElementById('lineLength').innerHTML = '';
         // document.getElementById('polyArea').innerHTML = '';
     };
     
     $scope.showMap = function(actividad) {
   	  setTimeout(function() {        	 
   		  $scope.initMap();
   		  $scope.colocarMarcadores($scope.coordenadasEsperadas,1);
   	  },1000);    	  
     	    		  
     };
   	  
	  $scope.mostrarReal = function(actividad) {
   	  setTimeout(function() {        	 
   		  $scope.initMap2();
   		  $scope.colocarMarcadores($scope.coordenadasReales,2);
   	  },1000);    	  
	  };
       	        
     //***coloca los marcadores agendados
     $scope.colocarMarcadores = function(coordenadas, numMapa)
     {
   	  //se limpian los marcadores existentes
   	  if (numMapa == 1)
   	  {
   		  $scope.limpiarMarcadores();
   	  }
   	  else
   	  {
   		  $scope.limpiarMarcadoresLectura();
   	  }
   		  

   	  //console.info("colocarMarcadoresSeleccionados");
   	  //console.info($scope.diasAgenda);
   	  //console.info(coordenadas.length);
	   	  if (numMapa == 1)
	   	  {
	   		  //console.info(coordenadas[i].direccion);
	   		  //$scope.setDireccionEnReversaEditar(coordenadas[i].latitud, coordenadas[i].longitud, coordenadas[i].direccion);
	      	asyncLoop({
	    		length : coordenadas.length,
				forHSA : function(loop, i){
					setTimeout(function(){
						$scope.setDireccionEnReversaEditar(coordenadas[i].latitud, coordenadas[i].longitud, coordenadas[i].direccion);
						loop();
					},1500);
				},
				callback : function(){
					$('#msload').modal('hide');
				}    
			});       		  
	   	  }
	   	  else
	   	  {
	   		  //$scope.setDireccionEnReversaLectura(coordenadas[i].latitud, coordenadas[i].longitud, coordenadas[i].direccion);
	      	asyncLoop({
	    		length : coordenadas.length,
				forHSA : function(loop, i){
					setTimeout(function(){
						$scope.setDireccionEnReversaLectura(coordenadas[i].latitud, coordenadas[i].longitud, coordenadas[i].direccion);
						loop();
					},1500);
				},
				callback : function(){
					$('#msload').modal('hide');
				}    
			});       	  
	   	  }   	  
     };
     
   //funcion para validar que se hayan llenado todos los campos
   $scope.validaCampos = function()
   {
   	var error = false;
		if ($('#comentarioActividad').val().length < 50)
		{
			cadena = "Favor de verificar: El comentario debe contener al menos 50 caracteres." ;
			error=true;
		}			
									
		$('#alert').show();
		$('#msgerror').text(cadena);
		return error;
	};
	       

	//autoriza la actividad
	$scope.autorizarActividad = function() {
		var comentario  = $('#comentarioActividad').val();
		var horasTabajadas = $('#noHorasTrabajadas').val();
		var porcentajeHoras = $('#porcentajeHoras').val();		
		
		if ($scope.validaCampos() == true)
		{
			return false;
		}			 
		
		var confirmar = confirm("¿Esta seguro de autorizar la actividad?");
				
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
	 			"idAgendaDetalle" 	: $scope.id,
	 			"autorizacion" 		: "S",
	 			"comentario"		: comentario,
	 			"usuario"			: $scope.usuario,
	 			"noHorasTabajadas"	: horasTabajadas,
	 			"porcentaje"		: porcentajeHoras
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
		$scope.rechazarActividad = function() {
			var comentario  = $('#comentarioActividad').val();
			var horasTabajadas = $('#noHorasTrabajadas').val();
			var porcentajeHoras = $('#porcentajeHoras').val();			
			
			if ($scope.validaCampos() == true)
			{
				return false;
			}			 
			
			var confirmar = confirm("¿Esta seguro de rechazar el permiso?"); 
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
	 				"idAgendaDetalle" 	: $scope.id,
	 				"autorizacion" 		: "N",
	 				"comentario"		: comentario,
	 				"usuario"			: $scope.usuario,
		 			"noHorasTabajadas"	: horasTabajadas,
		 			"porcentaje"		: porcentajeHoras
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

		$scope.cambiaColorBarra= function(porcentaje){
			if(porcentaje>=75)
				return "progress-bar progress-bar-success";
			else if(porcentaje>=50 && porcentaje<75)
				return "progress-bar progress-bar-warning";
			else
				return "progress-bar progress-bar-danger";
		};
 
		//se muestran los mapas
		setTimeout(function(){
			$scope.initMap();
	    },1000);		
		
	    setTimeout(function(){			
	    	$scope.initMap2();
	    },1000);
	});

    // FIN AUTORIZA ACTIVIDAD
