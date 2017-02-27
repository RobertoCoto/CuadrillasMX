var app = angular.module('tatei', ['ui.bootstrap', 'ui.router']);
var data;

	function removeByAttr(arr, attr, value) {
	  var i = arr.length;
	  while(i--){
	     if( arr[i]
	         && arr[i].hasOwnProperty(attr)
	         && (arguments.length > 2 && arr[i][attr] === value ) ){

	         arr.splice(i,1);
	     }
	  }
	  return arr;
	}

 	app.config(function($routeProvider, $stateProvider) {
 		$routeProvider
            // route for the home page
            .when('/login', {
                templateUrl : 'templates/login.html',
                controller  : 'validaUsuario'
            })
            .when('/menu', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/10', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
             .when('/12', {
                 templateUrl : 'templates/menu.html',
                 controller  : 'validaUsuario'
            })
            .when('/13', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/20', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/30', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/31', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/32', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/33', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/34', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/40', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/41', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/50', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/51', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .when('/52', {
                templateUrl : 'templates/menu.html',
                controller  : 'validaUsuario'
            })
            .otherwise({redirectTo : '/login'});

   		$stateProvider
            .state('10', {
            	url: '/10',
                templateUrl : 'templates/catalogos.html',
                controller  : 'catalogoctrl'
            })
            .state('12', {
            	url: '/12',
            	templateUrl : 'templates/cambioContrasenia.html',
            	controller  : 'cambioDatos'
            })
        	.state('13', {
        		url: '/13',
                templateUrl : 'templates/cambioContraseniaGeneral.html',
                controller  : 'adminDatos'
        	})
            .state('20', {
            	url: '/20',
                templateUrl : 'templates/administracionEmpleado.html',
                controller  : 'registraEmpleado'
            })
            .state('30', {
            	url: '/30',
                templateUrl : 'templates/admin_cuadrillas.html',
                controller  : 'adminCuad'
            })
            .state('31', {
            	url: '/31',
                templateUrl : 'templates/altaContratos.html',
                controller  : 'altacontratoctrl'
            })
            .state('32', {
            	url: '/32',
                templateUrl : 'templates/registro_agenda.html',
                controller  : 'registroagendactrl'
            })
            .state('33', {
            	url: '/33',
                templateUrl : 'consultaAgenda/index.html',
                controller  : 'pendiente'
            })
            .state('34', {
            	url: '/34',
                templateUrl : 'templates/tomaAsistencia.html',
                controller  : 'entradaAsistencia'
            })
            .state('40', {
            	url: '/40',
                templateUrl : 'templates/buzonCentral.html',
                controller  : 'buzon'
            })
            .state('41', {
            	url: '/41',
                templateUrl : 'buzonresidente pendiente',
                controller  : 'pendiente'
            })
            .state('50', {
            	url: '/50',
                templateUrl : 'reporte1 pendiente',
                controller  : 'pendiente'
            })
            .state('51', {
            	url: '/51',
                templateUrl : 'reporte2 pendiente',
                controller  : 'pendiente'
            })
            .state('52', {
            	url: '/52',
                templateUrl : 'reporte3 pendiente',
                controller  : 'pendiente'
            })
            .state('otherwise', {redirectTo : '/login'});
 	});

 	//LOGIN
 	app.controller('validaUsuario',["$scope","$http", "$location", function ($scope,$http, $location) {
		    $scope.validar = function() {
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ConsultaUsuarioLogin',
		              params: {
		    			"user" : document.getElementById("usuario").value,
				 		"password": document.getElementById("clave").value
				         }
				    }).then(function mySucces(response) {
                        console.info(response);
                        data = response;
                        $location.path('/menu');
				        if (!$scope.$$phase && !$scope.$root.$$phase) {
				            $scope.$apply();
				            $('#contenedor').empty();
				            console.log("Scope Apply Done !!");
				          }
				          else {
				            setTimeout(function() {
				            	$scope.$apply();
				            	$('#contenedor').empty();
				            }, 200);
				          }
                        console.info("*******prueba*******");
                        console.info(data);
                        document.getElementById("usuario").value="";
                        document.getElementById("clave").value="";
                  }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
                        data = response;
                        console.info("*******prueba*******");
                        console.info(data);
				        //$location.path('/menu');
				        //if (!$scope.$$phase && !$scope.$root.$$phase) {
				        //    $scope.$apply();
				        //    console.log("Scope Apply Done !!");
				        //  }
				        //  else {
				        //    setTimeout(function() {
				        //    	$scope.$apply();
				        //    }, 200);
				        //  }
				    });
		    }
 	}]);
 	//FIN LOGIN
	app.service('fileUpload', ['$http', function ($http) {
	    this.uploadFileToUrl = function(contrato, json, uploadUrl){
	        var fd = new FormData();
	        fd.append('contrato', contrato);
					fd.append('json', json);
	        $http.post(uploadUrl, fd, {
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	        .success(function(){
	        })
	        .error(function(){
	        });
	    }
	}]);
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
 	//MENU
	app.controller('MainController',
		function ($scope, $location) {
			if(jQuery.type(data) === "undefined"){
				$location.path('/login');
		        if (!$scope.$$phase && !$scope.$root.$$phase) {
		            $scope.$apply();
		          }
		          else {
		            setTimeout(function() {
		            	$scope.$apply();
		            }, 200);
		          }
			}
			else
			{
				console.info(data.data.menu);
				console.info("usuario");
				console.info(data.data.usuario);
				$scope.usuario = data.data.usuario;
				$scope.items = data.data.menu;
				$scope.default = $scope.items[0];
			}
	});

    app.controller('ItemController', ['$scope', function (scope) {
                scope.$parent.isopen = (scope.$parent.default === scope.item);

                scope.$watch('isopen', function (newvalue, oldvalue, scope) {
                    scope.$parent.isopen = newvalue;
                });

    }]);

    app.controller('vistaController',
        function ($scope) {
            document.getElementById("contenedor").style.marginLeft = "260px";
    });
    //FIN MENU

    app.controller('catalogoctrl', function ($scope, $http) {

          $('#alert').hide();
          $('#success').hide();

          $scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					}

          var tipoCataloPadre = undefined;

          //$scope.options1 = option1Options;
          $('#msload').modal('show');
          $('#alert').hide();
          $('#success').hide();
          $http({
                  method: 'GET',
                  url: 'http://localhost:8080/CuadrillasWEB/ConsultaTipoCatalogos',
                  data: { }
            }).then(function successfn(result) {
              $scope.resultado = result.data.catalogo;
                    //console.log(result);
                     $('#msload').modal('hide');
            }, function errorfn(response) {
                console.error(response);
                //alert(response.data.header.mensajeFuncional);
                $('#msload').modal('hide');
                $('#alert').show();
                $('#msgerror').val(response.data.header.mensajeFuncional);
                //$scope.resultado2.push(objecto);
            });

          $scope.options2 = []; // we'll get these later

          $scope.saveOptions = function(objecto) {
            $('#msload').modal('show');
            $('#alert').hide();
            $('#success').hide();
            $http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWEB/RegistrarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANL&descripcion=SAN%20LORENZO&usuario=SISTEMAS',
                    params: {
                      "tipoCatalogo": tipoCataloPadre,
                      "codigo": document.getElementById("codigof").value.toUpperCase(),
                      "usuario": data.data.usuario.usuario,
                      "descripcion": document.getElementById("descripcionf").value.toUpperCase()
                     }
            }).then(function successfn(response) {
                var fila = {};
                fila.descripcion = document.getElementById("descripcionf").value.toUpperCase();
                fila.codigo = document.getElementById("codigof").value.toUpperCase();
                fila.tipo = 0;
                document.getElementById("descripcionf").value = '';
                document.getElementById("codigof").value = '';
                $scope.resultado2.push(fila);
                  //console.info(response);
                  $('#msload').modal('hide');
                  $('#success').show();
                  $('#msgaviso').text(response.data.mensajeFuncional);
            }, function errorfn(response) {
                console.error(response);
                //alert(response.data.mensajeFuncional);
                $('#msload').modal('hide');
                $('#alert').show();
                $('#msgerror').text(response.data.mensajeFuncional);
                //$scope.resultado2.push(objecto);
            });


          }

          $scope.getOptions2 = function(aaa){
            tipoCataloPadre = aaa;
            //console.log(aaa);
            $('#msload').modal('show');
            $('#alert').hide();
            $('#success').hide();
            $http({
                    method: 'GET',
                    url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
                    params: { "tipoCatalogo": aaa }
                }).success(function (result) {
                    $scope.resultado2 = result.catalogo;

                    $scope.editingData = {};

                     for (var i = 0, length = $scope.resultado2.length; i < length; i++) {
                       $scope.editingData[$scope.resultado2[i].codigo] = false;
                     }
                     $('#msload').modal('hide');

                     $scope.modify = function(catalogo){
                         $scope.editingData[catalogo.codigo] = true;
                     };

                     $scope.cancelar = function(catalogo) {
                       $scope.editingData[catalogo.codigo] = false;
                     }

                     $scope.update = function(catalogo){
                        //console.warn(catalogo);
                        //TODO ----- ACTUALIZAR HTTP
                        $('#msload').modal('show');
                        $('#alert').hide();
                        $('#success').hide();
                        $http({
                               method: 'GET',
                               url: 'http://localhost:8080/CuadrillasWEB/ActualizarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANL&descripcion=SAN%20LORENZO&usuario=SISTEMAS
                               params: {
                                 "tipoCatalogo": tipoCataloPadre,
                                 "descripcion": catalogo.descripcion,
                                 "codigo": catalogo.codigo,
                                 "usuario": data.data.usuario.usuario
                                }
                       }).then(function successfn(response) {
                         $scope.editingData[catalogo.codigo] = false;
                             //console.info(response);
                             $('#msload').modal('hide');
                             $('#success').show();
                             $('#msgaviso').text(response.data.mensajeFuncional);
                       }, function errorfn(response) {
                           console.error(response);
                           //alert(response.data.mensajeFuncional);
                           $('#msload').modal('hide');
                           $('#alert').show();
                           $('#msgerror').text(response.data.mensajeFuncional);
                           //$scope.resultado2.push(objecto);
                       });

                     };

                     $scope.remove = function(catalogo) {
                       //console.info(catalogo);
                       $('#msload').modal('show');
                       $('#alert').hide();
                       $('#success').hide();
                       $http({
                               method: 'GET',
                               url: 'http://localhost:8080/CuadrillasWEB/EliminarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANLO&usuario=SISTEMAS',
                               params: {
                                 "tipoCatalogo": tipoCataloPadre,
                                 "codigo": catalogo.codigo,
                                 "usuario": data.data.usuario.usuario
                                }
                       }).then(function successfn(response) {
                           removeByAttr($scope.resultado2, 'codigo',catalogo.codigo);
                             //console.info(response);
                             $('#msload').modal('hide');
                             $('#success').show();
                             $('#msgaviso').text(response.data.mensajeFuncional);
                       }, function errorfn(response) {
                           console.error(response);
                           //alert(response.data.mensajeFuncional);
                           $('#msload').modal('hide');
                           $('#alert').show();
                           $('#msgerror').text(response.data.mensajeFuncional);
                           //$scope.resultado2.push(objecto);
                       });


                     }
                    //console.log(result);
            });
          };


        });

        var map;
        var medida;

          function initMap() {
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
            google.maps.event.addListener(map, 'click', function(event) {
              //console.log(event);
                setMarcador(event.latLng);
            });
          }

            var markers = [];


            app.controller('altacontratoctrl', function ($scope, $http, fileUpload) {
							$(window).on("load resize ", function() {
							  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
							  $('.tbl-header').css({'padding-right':scrollWidth});
							}).resize();
              $('#mainPanel').hide();
              $('#alert').hide();
              $('#success').hide();
              var fechaInicioForm=$('input[name="fechaInicio"]');
              var fechaTerminoForm=$('input[name="fechaTermino"]');
              var fechaRegistroForm=$('input[name="fechaRegistro"]');
              var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
              var a = undefined;
              var b = undefined;
              fechaInicioForm.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
              }).on("change", function (e) {
                console.log(e)
                  console.log("fecha inicio: ", e.target.value);
                  var s = e.target.value.split("/")
                  a = moment([s[2], s[1]-1, s[0]]);
                  if (b) {
                    $('#diasDuracion').val(b.diff(a,'days')+1);
                  }
              });
              fechaTerminoForm.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
              }).on("change", function (e) {
                  var s = e.target.value.split("/")
                  b = moment([s[2], s[1]-1, s[0]]);
                  console.log("Fecha termino: ", e.target.value);
                  if (a) {
                    $('#diasDuracion').val(b.diff(a,'days')+1);
                  }
              });
              fechaRegistroForm.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
              })
              $scope.contratoFocus = {}; // contrato undefined
              $scope.nContrato = true;
              $http({
                      method: 'GET',
                      url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
                      params: {
                        'tipoCatalogo': 'CONTR_TIPO'
                      },
                      data: { }
                }).then(function successfn(result) {
                  $scope.catContratos = result.data.catalogo;
                        console.log(result);
                }, function errorfn(response) {
                    console.error(response);
                    alert(response.data.header.mensajeFuncional);
                    $('#msload').modal('hide');
                    //$('#msgerror').val(response.data.header.mensajeFuncional);
                });


              $http({
                      method: 'GET',
                      url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
                      params: {
                        'tipoCatalogo': 'DOCUMENTO'
                      },
                      data: { }
                }).then(function successfn(result) {
                      $scope.documentos = result.data.catalogo;
                        console.log(result);
                }, function errorfn(response) {
                    console.error(response);
                    alert(response.data.header.mensajeFuncional);
                    $('#msload').modal('hide');
                    //$('#msgerror').val(response.data.header.mensajeFuncional);
                });

                $http({
                        method: 'GET',
                        url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
                        params: {
                          'tipoCatalogo': 'EMPRESAS'
                        },
                        data: { }
                  }).then(function successfn(result) {
                        $scope.empresas = result.data.catalogo;
                          console.log(result);
                  }, function errorfn(response) {
                      console.error(response);
                      alert(response.data.header.mensajeFuncional);
                      $('#msload').modal('hide');
                      //$('#msgerror').val(response.data.header.mensajeFuncional);
                  });

                $http({
                        method: 'GET',
                        url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
                        params: {
                          'tipoCatalogo': 'VIALIDAD'
                        },
                        data: { }
                  }).then(function successfn(result) {
                        $scope.vialidades = result.data.catalogo;
                          console.log(result);
                  }, function errorfn(response) {
                      console.error(response);
                      alert(response.data.header.mensajeFuncional);
                      $('#msload').modal('hide');
                      //$('#msgerror').val(response.data.header.mensajeFuncional);
                  });



                  $scope.nuevoContrato = function() {
                    $('#mainPanel').show();
                    $('#nuevoContrato').hide();
                    $('#panelContratos').hide();
										$('form')[0].reset();
                    $scope.nContrato = true;
                    $scope.contratoFocus = {};
										$scope.contratoFocus.fechaRegistroContrato = new JsSimpleDateFormat("dd/MM/yyyy").format(new Date());
                    $scope.initMap();
                    $scope.limpiarMarcadores();
                  }

                  $scope.cancelar = function() {
                    $('#mainPanel').hide();
                    $('#nuevoContrato').show();
                    $scope.consultaContratos();
                    $('#panelContratos').show();
                    $scope.contratoFocus = {};
                    $scope.limpiarMarcadores();
										$('form')[0].reset();
                  }

                  $scope.altaContrato = function() {
                    //$('#mainPanel').hide();
                    //$scope.consultaContratos();
                    //$('#panelContratos').show();
                    //$('#nuevoContrato').show();
                    console.log($scope.contratoFocus);
										var contrato = $scope.contratoAdjunto;
										var json = JSON.stringify($scope.contratoFocus);
										console.log('Archivo a subir: ' );
										console.dir(contrato);
										var uploadUrl = "http://localhost:8080/CuadrillasWEB/test";
										fileUpload.uploadFileToUrl(contrato, json, uploadUrl);
                    //$scope.contratoFocus = {}; //para el final

                  }

									$scope.guardaContrato = function() {
                    //$('#mainPanel').hide();
                    //$scope.consultaContratos();
                    //$('#panelContratos').show();
                    //$('#nuevoContrato').show();
                    console.log($scope.contratoFocus);
										var json = JSON.stringify($scope.contratoFocus);
										var uploadUrl = "http://localhost:8080/CuadrillasWEB/test";
										fileUpload.uploadFileToUrl(null, json, uploadUrl);
                    //$scope.contratoFocus = {}; //para el final

                  }

                  $scope.consultaContratos = function() {
                    $('#msload').modal('show');
                    //setTimeout(function () {
                      $http({
                        method: 'GET',
                        url: 'http://localhost:8080/CuadrillasWEB/ConsultaContrato',
                        params: {
                        },
                        data: {}
                      }).then(function successfn(result) {
                        //console.log('contratos:');
                        $scope.contratos = result.data.contrato;
                        //console.log(result);
                        /*for (var i = 0; i < result.data.contrato[0].coordenadas.length; i++) {
                          setDireccionEnReversa(result.data.contrato[0].coordenadas[i].latitud, result.data.contrato[0].coordenadas[i].longitud);
                        }*/
                        $('#msload').modal('hide');
                      }, function errorfn(response) {
                        console.error(response);
                        alert(response.data.header.mensajeFuncional);
                        $('#msload').modal('hide');
                      });
                    //}, 2000);
                  }

                  $scope.editarContrato = function(contrato) {
                    $scope.contratoFocus = contrato;
                    $('#mainPanel').show();
                    $('#nuevoContrato').hide();
                    $('#panelContratos').hide();
                    $scope.nContrato = false;
                    $scope.initMap();
										setTimeout(function () {
											for (var i = 0; i < contrato.coordenadas.length; i++) {
												$scope.setDireccionEnReversaEditar(contrato.coordenadas[i].latitud, contrato.coordenadas[i].longitud, contrato.coordenadas[i].direccion);
											}
										}, 100);

                  }

                  //Ejecución inicial
                  $scope.consultaContratos();

                /*$('#msload').modal('show');
                $http({
                        method: 'GET',
                        url: 'http://localhost:8080/CuadrillasWEB/ConsultaCuadrilla',
                        params: {
                        },
                        data: { }
                  }).then(function successfn(result) {
                        $scope.cuadrillas = result.data.cuadrilla;
                          console.log(result);
                           $('#msload').modal('hide');
                  }, function errorfn(response) {
                      console.error(response);
                      alert(response.data.header.mensajeFuncional);
                      $('#msload').modal('hide');
                      //$('#msgerror').val(response.data.header.mensajeFuncional);
                  });*/

                  /*$('#msload').modal('show');
                  setTimeout(function () {
                    $http({
                      method: 'GET',
                      url: 'http://localhost:8080/CuadrillasWEB/ConsultaContrato',
                      params: {
                      },
                      data: {}
                    }).then(function successfn(result) {
                      console.log('contratos:');
                      $scope.contratos = result.data.contrato;
                      console.log(result);
                      for (var i = 0; i < result.data.contrato[0].coordenadas.length; i++) {
                        setDireccionEnReversa(result.data.contrato[0].coordenadas[i].latitud, result.data.contrato[0].coordenadas[i].longitud);
                      }
                      $('#msload').modal('hide');
                    }, function errorfn(response) {
                      console.error(response);
                      alert(response.data.header.mensajeFuncional);
                      $('#msload').modal('hide');
                    });
                  }, 2000); */

									$scope.setMarcadorEdicion = function(latLng, direccion) {
										//$('#msload').modal('show');
                    var geocoder = new google.maps.Geocoder;
                    var img_mark = 'altaContrato/mark.png';
                    var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
                    medida.mvcLine.push(latLng);
                    medida.mvcPolygon.push(latLng);
                    medida.mvcMarkers.push(marcador);
                    var latLngIndex = medida.mvcLine.getLength() - 1;
                    var latlng = {lat: latLng.lat, lng: latLng.lng};
                    var direccion = 'SN';
                      //console.log(results);
                      $( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
                        + "<td class=\"td\" width=\"30px\"> </td>"
                        + "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
                      + "</tr>") );
										//$('#msload').modal('hide');
                    $scope.mLineaRecta();
                  }

                  $scope.setMarcador = function(latLng) {
										$('#msload').modal('show');
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
                        if (medida.mvcLine.getLength() > 1) {
                            $scope.calculaDistancia();
                        }
                    });
                    var latlng = {lat: latLng.lat(), lng: latLng.lng()};
                    var direccion = 'SN';
                    geocoder.geocode({'location': latlng}, function(results, status) {
                      //console.log(results);
                      if (status === google.maps.GeocoderStatus.OK) {
                        if (results[1]) {
                          direccion =  results[0].formatted_address;
                          var coordenadaP = {};
                          var coordenadasTemp = [];
                          coordenadaP.latitud = latLng.lat();
                          coordenadaP.longitud = latLng.lng();
                          coordenadaP.direccion = direccion;
                          if($scope.contratoFocus.coordenadas) {
                            $scope.contratoFocus.coordenadas.push(coordenadaP);
                          } else {
                            coordenadasTemp.push(coordenadaP);
                            $scope.contratoFocus.coordenadas = coordenadasTemp;
                          }


                          $( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
                            + "<td class=\"td\" width=\"30px\"> </td>"
                            + "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
                          + "</tr>") );

                        } else {
                          $('#alert').show();
                          $('#msgerror').text('No se encontro una dirección disponible.')
                          //alert('No se encontraron resultados');
                        }
												$('#msload').modal('hide');
                      } else {
                        $('#alert').show();
                        $('#msgerror').text('Problemas en la geolocalización debido ' + status + '')
                        //alert('Geocoder fallo debido al estatus: ' + status);
												$('#msload').modal('hide');
                      }
                    });



                    /*
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="form-group">
                          <label for="direccionInicial" class="control-label">Dirección</label>
                          <input type="text" id="direccionInicial" class="form-control"placeholder="Av. Gobernadores 102 Col Bugambilias">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-3">
                          <label for="" class="control-label">Coordenadas</label>
                      </div>
                      <div class="col-sm-4">
                        <input type="text" id="latitudInicial" class="form-control" placeholder="-0.9999999">
                      </div>
                      <div class="col-sm-4">
                        <input type="text" id="longitudInicial" class="form-control" placeholder="1.2366526">
                      </div>
                    </div>
                    */

                    $scope.mLineaRecta();
                  }

                  $scope.initMap = function() {
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
													$scope.setMarcadorEdicion(event.latLng);
												}
                    });
                  }

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
                      $scope.contratoFocus.metros = length;
                      $( "#km" ).text(km.toFixed(2) + ' km');
											$( "#txtkm" ).text('Distancia');
                      //console.log('Distancia total:' + length.toFixed(0) + ' metros ' +  km.toFixed(3));
                  }

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
                      $scope.contratoFocus.metros = length;
                      $( "#km" ).text(km.toFixed(2) + ' km');
											$( "#txtkm" ).text('Distancia');
                      //console.log('Distancia total:' + length.toFixed(0) + ' metros ' +  km.toFixed(3));
                  }

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


    //REGISTRO AGENDA SEMANAL
    app.controller('registroagendactrl', function ($scope, $http) {
		  /*$('#mainPanel').hide();
		      $('#alert').hide();
		      $('#success').hide();
		*/
    	var actualizacion = false;
    	var fecha=$('input[name="fecha"]');
    	var diaActividad = $('input[name="diaActividad"]');
    	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	    fecha.datepicker({
	      format: 'yyyy-mm-dd',
	      container: container,
	      todayHighlight: true,
	      weekStart: 1,
	      language: "es",
	      regional:"es",
	  	  calendarWeeks: false,
	      autoclose: true,
	    });
	    diaActividad.datepicker({
	      format: 'yyyy-mm-dd',
	      language: "es",
	      regional:"es",
	      container: container,
	      todayHighlight: true,
	      calendarWeeks: false,
	      autoclose: true
	    });
	    $('.datepicker-semana').datepicker(
	  	{
	  		weekStart: 1,
	  		language: "es",
	  		regional:"es",
	  		calendarWeeks: false
	  	}).on('changeDate', function (e)
	  	{
	  		if (actualizacion)
	  			return;

	  		actualizacion = true;
	  		var value = e.date;
	  		var iniSemana = moment(value).day(1);
	  		var finSemana =  moment(value).day(7);
	  		$(this).datepicker('clearDate');
	  		$(this).datepicker('setDates', [
	  		    moment(value).day(1).toDate(),
  				moment(value).day(2).toDate(),
  				moment(value).day(3).toDate(),
  				moment(value).day(4).toDate(),
  				moment(value).day(5).toDate(),
  				moment(value).day(6).toDate(),
  				moment(value).day(7).toDate()
  			]);

	  		var semanaInicioDate = moment(iniSemana.toDate());
	  		var semanaFinDate = moment(finSemana.toDate());
	  		$('#ini').val(semanaInicioDate.format("YYYY-MM-DD"));
	  		$('#fin').val(semanaFinDate.format("YYYY-MM-DD"));
	  		$('#semana').val(moment(iniSemana.toDate()).week());
	  		actualizacion = false;

	  		//se arma el arreglo de dias de la semana
	  		$scope.fechasSemana= [];
	  		for (var i=1; i<=7; i++)
	  		{
	  			var contador = i;
	  			$scope.fechasSemana.push(mostrarFecha(contador, semanaInicioDate.format("YYYY-MM-DD")))
	  		}

	  		$('#diaActividad').val("");
	  });

	  //se llena catalogo de actividades
      $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params: {
                'tipoCatalogo': 'ACTIVIDADE'
              },
              data: { }
        }).then(function successfn(result) {
          $scope.catActividades = result.data.catalogo;
          //console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
        });

      //se llena catalogo de articulos
      $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params: {
                'tipoCatalogo': 'ARTICULO'
              },
              data: { }
        }).then(function successfn(result) {
              $scope.catArticulos = result.data.catalogo;
              //console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
        });

        //Se consultan los contratos activos
      	$http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaContratoActivo',
              params: { },
              data: { }
        }).then(function successfn(result) {
              $scope.contratosActivos = result.data.contrato;
              console.info("contratos");
              console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
            //$('#msgerror').val(response.data.header.mensajeFuncional);
        });

        //se agregan elementos al objeto de actividades
  		$scope.gridActividades = [];
  		$scope.gridArticulos = [];
  		$scope.agregarActividades = function(objActividad) {
  			var encontrado = false;

  			//$('#msload').modal('show');
  			//$('#alert').hide();
  			//$('#success').hide();

  			for(indice in $scope.gridActividades)
  			{
  				if (objActividad.codigo == $scope.gridActividades[indice].codigo)
  				{
  					encontrado = true;
  				}
  			}

  			if (encontrado == false)
  			{
  				var actividad = {};
  				actividad.codigo = objActividad.codigo;
	  			actividad.descripcion = objActividad.descripcion;
	  			$scope.gridActividades.push(actividad);
	          //console.info(response);
	          //$('#msload').modal('hide');
	          //$('#success').show();
	          //$('#msgaviso').text(response.data.mensajeFuncional);
  			}
  		};

  		$scope.agregarArticulos = function(objArticulo) {
  			var encontrado = false;

  			//$('#msload').modal('show');
  			//$('#alert').hide();
  			//$('#success').hide();
  			for(indice in $scope.gridArticulos)
  			{
  				if (objArticulo.codigo == $scope.gridArticulos[indice].codigo)
  				{
  					encontrado = true;
  				}
  			}

  			if (encontrado == false)
  			{
  				var articulo = {};
  				articulo.codigo = objArticulo.codigo;
	  			articulo.descripcion = objArticulo.descripcion;
	  			$scope.gridArticulos.push(articulo);

	          //console.info(response);
	          //$('#msload').modal('hide');
	          //$('#success').show();
	          //$('#msgaviso').text(response.data.mensajeFuncional);
  			}
  		};

  		$scope.eliminarActividades = function(actividad) {
  			//$('#msload').modal('show');
  			//$('#alert').hide();
  			//$('#success').hide();
  			for(indice in $scope.gridActividades)
  			{
  				if (actividad == $scope.gridActividades[indice].codigo)
  				{
  					$scope.gridActividades.splice(indice,1);
  				}
  			}

	          //console.info(response);
	          //$('#msload').modal('hide');
	          //$('#success').show();
	          //$('#msgaviso').text(response.data.mensajeFuncional);
  		};

  		$scope.eliminarArticulos = function(articulo) {
  			//$('#msload').modal('show');
  			//$('#alert').hide();
  			//$('#success').hide();
  			for(indice in $scope.gridArticulos)
  			{
  				if (articulo == $scope.gridArticulos[indice].codigo)
  				{
  					$scope.gridArticulos.splice(indice,1);
  				}
  			}

	          //console.info(response);
	          //$('#msload').modal('hide');
	          //$('#success').show();
	          //$('#msgaviso').text(response.data.mensajeFuncional);
  		};

  		//funcion para agregar d�as a una fecha
  		function mostrarFecha(days, fechaInicio){
		    milisegundos=parseInt(35*24*60*60*1000);

		    fecha_parametro = Date.parse(fechaInicio);
		    fecha=new Date(fecha_parametro);
		    day=fecha.getDate();
		    // el mes es devuelto entre 0 y 11
		    month=fecha.getMonth()+1;
		    year=fecha.getFullYear();

		    //Obtenemos los milisegundos desde media noche del 1/1/1970
		    tiempo=fecha.getTime();
		    //Calculamos los milisegundos sobre la fecha que hay que sumar o restar...
		    milisegundos=parseInt(days*24*60*60*1000);
		    //Modificamos la fecha actual
		    total=fecha.setTime(tiempo+milisegundos);
		    day=fecha.getDate();
		    month=fecha.getMonth()+1;
		    year=fecha.getFullYear();

		    monthAux = month.toString();
		    if (monthAux.length ==1)
		    {
		    	monthAux = "0" + monthAux;
		    }

		    dayAux = day.toString();
		    if (dayAux.length ==1)
		    {
		    	dayAux = "0" + dayAux;
		    }

		    return year + "-" + monthAux + "-" + dayAux;
  		};

  		//funcion para colocar la fecha de plan de actividades de acuerdo al bot�n seleccionado
  		$scope.obtenerFechaSeleccionada = function(dia)
  		{
  			$('#diaActividad').val($scope.fechasSemana[dia-1]);
  		}

    });
    //FIN REGISTRO AGENDA SEMANAL
