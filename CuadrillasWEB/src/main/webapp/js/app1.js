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
            .when('/35', {
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
                templateUrl : 'templates/consulta_agenda.html',
                controller  : 'consultaagendactrl'
            })
            .state('34', {
            	url: '/34',
                templateUrl : 'templates/tomaAsistencia.html',
                controller  : 'entradaAsistencia'
            })
            .state('35', {
            	url: '/35',
            	templateUrl : 'templates/admin_herramientas.html',
                controller  : 'adminherramientasctl'
            })            
            .state('40', {
            	url: '/40',
                templateUrl : 'templates/buzonCentral.html',
                controller  : 'buzon'
            })
            .state('41', {
            	url: '/41',
                templateUrl : 'templates/buzonResidente.html',
                controller  : 'buzonResidente'
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
            })
            .state('otherwise', {redirectTo : '/login'});
 	});

 	//LOGIN
 	app.controller('validaUsuario',["$scope","$http", "$location", function ($scope,$http, $location) {
		    $scope.validar = function() {
		    	$http({
		              method: 'GET',
		              url: '/CuadrillasWEB/ConsultaUsuarioLogin',
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
				$('#msload').modal('show');
				$('#alert').hide();
				$('#success').hide();
	        var fd = new FormData();
	        fd.append('contrato', contrato);
					fd.append('json', json);
	        $http.post(uploadUrl, fd, {
	            transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
	        })
	        .success(function(aa){
						console.log(aa);
						$('#msload').modal('hide');
						$('#success').show();
						$('#msgaviso').text(aa.mensajeFuncional);
	        })
	        .error(function(aa){
						console.log(aa);
						$('#msload').modal('hide');
						$('#alert').show();
						$('#msgerror').text(aa.mensajeFuncional);
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
				//console.info(data.data.menu);
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
                  url: '/CuadrillasWEB/ConsultaTipoCatalogos',
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
                    url: '/CuadrillasWEB/RegistrarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANL&descripcion=SAN%20LORENZO&usuario=SISTEMAS',
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
                    url: '/CuadrillasWEB/ConsultaCatalogo',
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
                               url: '/CuadrillasWEB/ActualizarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANL&descripcion=SAN%20LORENZO&usuario=SISTEMAS
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
                               url: '/CuadrillasWEB/EliminarCatalogo',//?tipoCatalogo=VIALIDAD&codigo=SANLO&usuario=SISTEMAS',
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

            				//********************** contratos**********************************
            app.controller('altacontratoctrl', function ($scope, $http, fileUpload, $window) {

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
                format: 'yyyy-mm-dd',
                container: container,
                todayHighlight: true,
                autoclose: true,
              }).on("change", function (e) {
                console.log(e)
                  console.log("fecha inicio: ", e.target.value);
									$scope.contratoFocus.fechaInicio = e.target.value;
                  var s = e.target.value.split("-")
                  a = moment([s[0], s[1]-1, s[2]]);
                  if (b) {
                    $('#diasDuracion').val(b.diff(a,'days')+1);
                  }
              });
              fechaTerminoForm.datepicker({
                format: 'yyyy-mm-dd',
                container: container,
                todayHighlight: true,
                autoclose: true,
              }).on("change", function (e) {
                  var s = e.target.value.split("-")
                  b = moment([s[0], s[1]-1, s[2]]);
                  console.log("Fecha termino: ", e.target.value);
									$scope.contratoFocus.fechaFin = e.target.value;
                  if (a) {
                    $('#diasDuracion').val(b.diff(a,'days')+1);
                  }
              });
              fechaRegistroForm.datepicker({
                format: 'yyyy-mm-dd',
                container: container,
                todayHighlight: true,
                autoclose: true,
              })
              $scope.contratoFocus = {}; // contrato undefined
              $scope.nContrato = true;
              $http({
                      method: 'GET',
                      url: '/CuadrillasWEB/ConsultaCatalogo',
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
                      url: '/CuadrillasWEB/ConsultaCatalogo',
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
                          url: '/CuadrillasWEB/ConsultaCatalogo',
                          params : {
            		 		"tipoCatalogo": 'CONT_DOCU'
            		 },
                          data: { }
            		    }).then(function mySucces(result) {
            		    	$scope.tipoDocumento = result.data.catalogo;
            	              console.log($scope.tipoDocumento);
            		    }, function myError(response) {
            		    	$('#msload').modal('hide');
            		        console.error(response);
            		        $('#alert').show();
            				$('#msgerror').text(response.data.header.mensajeFuncional)
            		    });

                $http({
                        method: 'GET',
                        url: '/CuadrillasWEB/ConsultaCatalogo',
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
                        url: '/CuadrillasWEB/ConsultaCatalogo',
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

									$http({
	                        method: 'GET',
	                        url: '/CuadrillasWEB/ConsultaCuadrilla',
	                        params: { },
	                        data: { }
	                  }).then(function successfn(result) {
	                        $scope.cuadrillas = result.data.cuadrilla;
	                        console.log(result);
	                  }, function errorfn(response) {
	                      console.error(response);
	                      //alert(response.data.header.mensajeFuncional);
	                      //$('#msgerror').val(response.data.header.mensajeFuncional);
	                  });

				

                  $scope.nuevoContrato = function() {
                    $('#mainPanel').show();
                    $('#nuevoContrato').hide();
                    $('#panelContratos').hide();
                    $('#consultarDocumento').hide();
                    
                    $('#agregarDocumento').hide();
                    $('#showDocument').hide();
                    $('#tablaDocumentos').hide();
                    $('#addDocument').hide();
                    $("#estatus").prop('disabled', true);
										$('#contratoFile').show();
										$('#linkContrato').hide();
										$('#linkContrato').empty();
										$('form')[0].reset();
                    $scope.nContrato = true;
                    $scope.contratoFocus = {};
										$scope.contratoFocus.usuarioAlta = data.data.usuario.usuario;
										$scope.contratoFocus.estatus = 'A';
										$scope.contratoFocus.fechaRegistroContrato = new JsSimpleDateFormat("yyyy-MM-dd").format(new Date());
                    $scope.initMap();
                    $scope.limpiarMarcadores();
                    $scope.formContrato.$setPristine();
                  }

                  $scope.cancelar = function() {
                    $('#mainPanel').hide();
                    $('#nuevoContrato').show();
                    $scope.consultaContratos();
                    $('#panelContratos').show();
                    $('#tablaDocumentos').hide();
										$('#linkContrato').empty();
                    $scope.contratoFocus = {};
										$scope.contratoFocus.usuarioAlta = data.data.usuario.usuario;
                    $scope.limpiarMarcadores();
										$('form')[0].reset();
										$scope.formContrato.$setPristine();
                  }
                  
                  $scope.limpiarContratopo = function() {
                	  $('#mainPanel').hide();
                	  $('#panelContratos').show();
                      $('#nuevoContrato').show();
                      $('#linkContrato').empty();
                      $('#tablaDocumentos').hide();
                      $scope.contratoFocus = {}; //para el final
                      $scope.contratoFocus.usuarioAlta = data.data.usuario.usuario;
                      $scope.limpiarMarcadores();
										$('form')[0].reset();
										$scope.formContrato.$setPristine();
                      $scope.consultaContratos();
                	  };
                  
                  $scope.altaContrato = function() {
                    console.log($scope.contratoFocus);
										$scope.contratoFocus.usuarioAlta = data.data.usuario.usuario;
										var contrato = $scope.contratoAdjunto;
										var json = JSON.stringify($scope.contratoFocus);
										console.log('Archivo a subir: ' );
										console.dir(contrato);
										var uploadUrl = "/CuadrillasWEB/AltaContrato";
										fileUpload.uploadFileToUrl(contrato, json, uploadUrl);
                  };

									$scope.guardaContrato = function() {
                    $('#mainPanel').hide();
                    $('#panelContratos').show();
                    $('#nuevoContrato').show();
                    
										$('#linkContrato').empty();
                    console.log($scope.contratoFocus);
										$scope.contratoFocus.usuarioAlta = data.data.usuario.usuario;
										var json = JSON.stringify($scope.contratoFocus);
										var uploadUrl = "/CuadrillasWEB/ActualizaContrato";
										fileUpload.uploadFileToUrl(null, json, uploadUrl);
										/*var dataObj = {
											JSONModificaContrato: json
										}
										var config = {
				                headers : {
				                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
				                }
				            }
										$http.post('http://localhost:8080/CuadrillasWEB/ActualizaContrato', json, config)
				            .success(function (data, status, headers, config) {
				                console.info(data);
				            })
				            .error(function (data, status, header, config) {
				                console.info(data);
				            });*/
                    $scope.contratoFocus = {}; //para el final
										$scope.consultaContratos();

                  }

                  $scope.consultaContratos = function() {
										$scope.edicionMap = false;
                    $('#msload').modal('show');
                    //setTimeout(function () {
                      $http({
                        method: 'GET',
                        url: '/CuadrillasWEB/ConsultaContrato',
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

									$scope.hideAlerts = function() {
										$('#alert').hide();
										$('#success').hide();
										//$scope.consultaContratos();
									}

                  $scope.editarContrato = function(contrato) {
                	  
                    $scope.contratoFocus = contrato;
										console.info(contrato);
										
										$('#contratoFile').hide();
										$('#linkContrato').show();
										$('#showDocument').show();
										$('#agregarDocumento').show();
										$('#addDocument').show();
										$('#linkContrato').append('<br><a class="btn btn-default btn-block" target="_blank" href="/CuadrillasWEB/ConsultaContratoDocumento?idContrato=' + contrato.idContrato +'">Ver Contrato</a>' );
										//'http://localhost:8080/CuadrillasWEB/ConsultaContratoDocumento?idContrato=' + contrato.idContrato
                    $('#mainPanel').show();
                    $('#nuevoContrato').hide();
                    $('#panelContratos').hide();
                    $("#estatus").prop('disabled', false);
                    $scope.nContrato = false;
                    $scope.initMap();
                    for (var i = 0; i < contrato.coordenadas.length; i++) {
                    	$scope.setDireccionEnReversaEditar(contrato.coordenadas[i].latitud, contrato.coordenadas[i].longitud, contrato.coordenadas[i].direccion);
                }
										$scope.edicionMap = true;
										$("#tramos").empty();
														
                  };
                  
                  $scope.muestraDocumento = function(docs) {
                	  $scope.idDocument = docs.idDocumento;
                	  var $popup = $window.open('/CuadrillasWEB/BusquedaDocumentoContrato?idDocumento='+ $scope.idDocument, '_blank','heigth=600,width=600');
                	 
                	  };
                   
                  $scope.consultaDocs = function () {
                	  $scope.idCon = $('#contratoHidden').val(); 
                	  $http({
                          method: 'GET',
                          url: '/CuadrillasWEB/ConsultaDocumentosContrato',
                          params : {
            		 		"idContrato":  $scope.idCon
            		 },
                          data: { }
            		    }).then(function mySucces(result) {
            		    	$scope.contratosDocs = result.data.contratoDocumento;
            	              console.log($scope.contratosDocs);
            		    }, function myError(response) {
            		    	$('#msload').modal('hide');
            		        console.error(response);
            		        $('#alert').show();
            				$('#msgerror').text(response.data.header.mensajeFuncional)
            		    });
                	  };
                	  
                	  $scope.registraDocumento = function() {
                	  $scope.contratoD.usuarioAlta = data.data.usuario.usuario;
                	  $scope.contratoD.idContrato = $('#contratoHidden').val();
						var contratoDocumento = $scope.contratoAdjuntoDocumento;
						var json = JSON.stringify($scope.contratoD);
						console.log('Archivo a subir: ' );
						console.dir(contratoDocumento);
						var uploadUrl = "/CuadrillasWEB/RegistraDocumentoContrato";
						fileUpload.uploadFileToUrl(contratoDocumento, json, uploadUrl);
					 $scope.contratoD = {};
					 $scope.consultaDocs();
                	  };
                  
                  $scope.listaDocumentos = function() {
                	  $('#tablaDocumentos').show();
                	  $scope.consultaDocs();
                	  };
                  

                  //Ejecuci�n inicial
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
										if(!direccion){
											direccion = 'SN';
										}
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
                          if($scope.contratoFocus.coordenadas && $scope.contratoFocus.coordenadas.length > 0) {
														coordenadaP.orden = $scope.contratoFocus.coordenadas[$scope.contratoFocus.coordenadas.length-1].orden + 1;
														if($scope.contratoFocus.coordenadas[$scope.contratoFocus.coordenadas.length-1].idContrato){
															coordenadaP.idContrato = $scope.contratoFocus.coordenadas[$scope.contratoFocus.coordenadas.length-1].idContrato;
														}
														if($scope.contratoFocus.coordenadas[$scope.contratoFocus.coordenadas.length-1].idAgenda){
															coordenadaP.idAgenda = $scope.contratoFocus.coordenadas[$scope.contratoFocus.coordenadas.length-1].idAgenda;
														}
                            $scope.contratoFocus.coordenadas.push(coordenadaP);
                          } else {
														coordenadaP.orden = 1;
														if($scope.contratoFocus.idContrato) {
															coordenadaP.idContrato = $scope.contratoFocus.idContrato;
														}
                            coordenadasTemp.push(coordenadaP);
                            $scope.contratoFocus.coordenadas = coordenadasTemp;
                          }


                          $( "#tramos" ).append( $( "<tr class=\"tr\" width=\"493px\">"
                            + "<td class=\"td\" width=\"30px\"> </td>"
                            + "<td class=\"td\" width=\"463px\">"+ direccion +" </td>"
                          + "</tr>") );

                        } else {
                          $('#alert').show();
                          $('#msgerror').text('No se encontro una direcci�n disponible.')
                          //alert('No se encontraron resultados');
                        }
												$('#msload').modal('hide');
                      } else {
                        $('#alert').show();
                        $('#msgerror').text('Problemas en la geolocalizaci�n debido ' + status + '')
                        //alert('Geocoder fallo debido al estatus: ' + status);
												$('#msload').modal('hide');
                      }
                    });



                    /*
                    <div class="row">
                      <div class="col-sm-12">
                        <div class="form-group">
                          <label for="direccionInicial" class="control-label">Direcci�n</label>
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
													if($scope.edicionMap){
														$scope.setMarcador(event.latLng);
													} else {
														$scope.setMarcadorEdicion(event.latLng);
													}
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
                      $( "#km" ).text(length.toFixed(2) + unidad_de_medida);
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
    app.controller('registroagendactrl', function ($scope, $http, fileUpload) {
		  /*
			 * $('#mainPanel').hide(); $('#alert').hide(); $('#success').hide();
			 */

  		$scope.gridActividades = [];
  		$scope.gridArticulos = [];
  		$scope.gridActividadesSemana = [];
  		$scope.gridArticulosSemana = [];
  		$scope.mapa = {};
  		$scope.mapaSemana = [];
  		$scope.mapa.gridCoordenadas = [];
  		$scope.diasAgenda = [];

  		var idAgenda = 0;
  		var validado = false;
  		var metros_div = 1;
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
	  		validado=false;
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

	  		// se arma el arreglo de dias de la semana
	  		$scope.fechasSemana= [];
	  		for (var i=1; i<=7; i++)
	  		{
	  			var contador = i;
	  			$scope.fechasSemana.push(mostrarFecha(contador, semanaInicioDate.format("YYYY-MM-DD")))
	  		}

	  		$('#diaActividad').val("");
	  });


	  // se llena catalogo de actividades
      $http({
              method: 'GET',
              url: '/CuadrillasWEB/ConsultaCatalogo',
              params: {
                'tipoCatalogo': 'ACTIVIDADE'
              },
              data: { }
        }).then(function successfn(result) {
          $scope.catActividades = result.data.catalogo;
          $scope.catActividadesAux = result.data.catalogo;
          // console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
        });

      // se llena catalogo de articulos
      $http({
              method: 'GET',
              url: '/CuadrillasWEB/ConsultaCatalogo',
              params: {
                'tipoCatalogo': 'ARTICULO'
              },
              data: { }
        }).then(function successfn(result) {
              $scope.catArticulos = result.data.catalogo;
              // console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
        });

        // Se consultan los contratos activos
      	$http({
              method: 'GET',
              url: '/CuadrillasWEB/ConsultaContratoActivo',
              params: { },
              data: { }
        }).then(function successfn(result) {
              $scope.contratosActivos = result.data.contrato;
              //console.info("contratos");
              //console.log(result);
        }, function errorfn(response) {
            console.error(response);
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
            // $('#msgerror').val(response.data.header.mensajeFuncional);
        });


        // ***agregar actividades
  		$scope.agregarActividades = function(objActividad) {
  			var encontrado = false;

  			// $('#msload').modal('show');
  			// $('#alert').hide();
  			// $('#success').hide();
  			// se validan dias
  			var validaDiaSel = $scope.validaSeleccion();
  			if (validaDiaSel == false)
  			{
  				return;
  			}

  			var fecha = $('#diaActividad').val();

  			//si ya esta agregado a la agenda se debe eliminar para poder editar
  			var agendado = $scope.validaAgendaAgregada(fecha);
  			if (agendado)
  			{
  				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
  				return;
  			}

  			for(indice in $scope.gridActividades)
  			{
  				if (objActividad.codigo == $scope.gridActividades[indice].codigo && fecha == $scope.gridActividades[indice].fecha)
  				{
  					encontrado = true;
  				}
  			}

  			if (encontrado == false)
  			{
  				var actividad = {};
  				actividad.fecha = $('#diaActividad').val();
  				actividad.codigo = objActividad.codigo;
	  			actividad.descripcion = objActividad.descripcion;
	  			$scope.gridActividades.push(actividad);
	  			reseteaColorBotones();
	  			cambiaColorBoton($scope.gridActividades);
	          // console.info(response);
	          // $('#msload').modal('hide');
	          // $('#success').show();
	          // $('#msgaviso').text(response.data.mensajeFuncional);
  			}

  		};


  		// ***agregar articulos
  		$scope.agregarArticulos = function(objArticulo) {
  			var encontrado = false;

  			// $('#msload').modal('show');
  			// $('#alert').hide();
  			// $('#success').hide();

  			// se validan dias
  			var validaDiaSel = $scope.validaSeleccion();
  			if (validaDiaSel == false)
  			{
  				return;
  			}

  			var fecha = $('#diaActividad').val();

  			//si ya esta agregado a la agenda se debe eliminar para poder editar
  			var agendado = $scope.validaAgendaAgregada(fecha);
  			if (agendado)
  			{
  				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
  				return;
  			}

  			for(indice in $scope.gridArticulos)
  			{
  				if (objArticulo.codigo == $scope.gridArticulos[indice].codigo &&  fecha == $scope.gridArticulos[indice].fecha)
  				{
  					encontrado = true;
  				}
  			}

  			if (encontrado == false)
  			{
  				var articulo = {};
  				articulo.fecha = $('#diaActividad').val();
  				articulo.codigo = objArticulo.codigo;
	  			articulo.descripcion = objArticulo.descripcion;
	  			$scope.gridArticulos.push(articulo);
	  			reseteaColorBotones();
	  			cambiaColorBoton($scope.gridArticulos);
	          // console.info(response);
	          // $('#msload').modal('hide');
	          // $('#success').show();
	          // $('#msgaviso').text(response.data.mensajeFuncional);
  			}

  		};


  		// ***eliminar actividades
  		$scope.eliminarActividades = function(actividad) {
  			// $('#msload').modal('show');
  			// $('#alert').hide();
  			// $('#success').hide();
  			fecha = $('#diaActividad').val();

  			//si ya esta agregado a la agenda se debe eliminar para poder editar
  			var agendado = $scope.validaAgendaAgregada(fecha);
  			if (agendado)
  			{
  				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
  				return;
  			}

  			for(indice in $scope.gridActividades)
  			{
  				if (actividad == $scope.gridActividades[indice].codigo && fecha == $scope.gridActividades[indice].fecha)
  				{
  					$scope.gridActividades.splice(indice,1);
  				}
  			}

  			reseteaColorBotones();
  			cambiaColorBoton($scope.gridActividades);
  			cambiaColorBoton($scope.gridArticulos);
  			cambiaColorBoton($scope.mapa);
	          // console.info(response);
	          // $('#msload').modal('hide');
	          // $('#success').show();
	          // $('#msgaviso').text(response.data.mensajeFuncional);
  		};


  		// ***eliminar articulos
  		$scope.eliminarArticulos = function(articulo) {
  			// $('#msload').modal('show');
  			// $('#alert').hide();
  			// $('#success').hide();

  			fecha = $('#diaActividad').val();

  			//si ya esta agregado a la agenda se debe eliminar para poder editar
  			var agendado = $scope.validaAgendaAgregada(fecha);
  			if (agendado)
  			{
  				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
  				return;
  			}

  			for(indice in $scope.gridArticulos)
  			{
  				if (articulo == $scope.gridArticulos[indice].codigo && fecha == $scope.gridArticulos[indice].fecha)
  				{
  					$scope.gridArticulos.splice(indice,1);
  				}
  			}

  			reseteaColorBotones();
  			cambiaColorBoton($scope.gridArticulos);
  			cambiaColorBoton($scope.gridActividades);
  			cambiaColorBoton($scope.mapa);
	          // console.info(response);
	          // $('#msload').modal('hide');
	          // $('#success').show();
	          // $('#msgaviso').text(response.data.mensajeFuncional);
  		};


  		// ***funcion para agregar dias a una fecha
  		function mostrarFecha(days, fechaInicio){
		    milisegundos=parseInt(35*24*60*60*1000);

		    fecha_parametro = Date.parse(fechaInicio);
		    fecha=new Date(fecha_parametro);
		    day=fecha.getDate();
		    // el mes es devuelto entre 0 y 11
		    month=fecha.getMonth()+1;
		    year=fecha.getFullYear();

		    // Obtenemos los milisegundos desde media noche del 1/1/1970
		    tiempo=fecha.getTime();
		    // Calculamos los milisegundos sobre la fecha que hay que sumar o
			// restar...
		    milisegundos=parseInt(days*24*60*60*1000);
		    // Modificamos la fecha actual
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


  		// ***funcion para colocar la fecha de plan de actividades de acuerdo al
		// boton seleccionado
  		$scope.obtenerFechaSeleccionada = function(dia)
  		{
  			var fecha = $('#diaActividad').val();

  			// se pasa lo capturado al arreglo de toda la semana
  			// actividades
  			// ************************************************
  			for(var indice=$scope.gridActividadesSemana.length-1; indice>=0; indice--)
  			{
  				if ( fecha == $scope.gridActividadesSemana[indice].fecha)
  				{
  					$scope.gridActividadesSemana.splice(indice,1);
  				}
  			}

  			for(indice in $scope.gridActividades)
  			{
  				$scope.gridActividadesSemana.push($scope.gridActividades[indice]);
  			}

  			// articulos
  			// ************************************************
  			for(var indice=$scope.gridArticulosSemana.length-1; indice>=0; indice--)
  			{
  				if (fecha == $scope.gridArticulosSemana[indice].fecha)
  				{
  					$scope.gridArticulosSemana.splice(indice,1);
  				}
  			}

  			for(indice in $scope.gridArticulos)
  			{
  				$scope.gridArticulosSemana.push($scope.gridArticulos[indice]);
  			}

  			 // mapa
  			// ************************************************
  			if ($scope.mapa.gridCoordenadas.length >0)
  			{
  	  			for(var indice=$scope.mapaSemana.length-1; indice>=0; indice--)
  	  			{
  	  				if (fecha == $scope.mapaSemana[indice].fecha)
  	  				{
  	  					$scope.mapaSemana.splice(indice,1);
  	  				}
  	  			}

	  			var mapaTemp = {};
	  			mapaTemp.gridCoordenadas = [];
	  			for(indice in $scope.mapa.gridCoordenadas)
	  			{
	    			var coordenadaP = {};
	    			coordenadaP.latitud = $scope.mapa.gridCoordenadas[indice].latitud;
	    			coordenadaP.longitud = $scope.mapa.gridCoordenadas[indice].longitud;
	    			coordenadaP.direccion = $scope.mapa.gridCoordenadas[indice].direccion;

	  				mapaTemp.gridCoordenadas.push(coordenadaP);
	  			}
	  			mapaTemp.metros = $scope.mapa.metros;
	  			mapaTemp.fecha = $scope.mapa.fecha;
	  			$scope.mapaSemana.push(mapaTemp);
	  		}

  			// console.info("MAPAS SEMANA");
  			// console.info($scope.mapaSemana);
  			
  	  		//se limpian los marcadores
  	  		if (dia != 0)
  	  		{
  	  		//	$scope.limpiarMarcadores(fecha);
  	  		//}
  	  		//else
  	  		//{  	  		
  	  			$scope.limpiarMarcadores('1900-01-01');
  	  		}  			

  			if (dia != 0)
  			{
  				$('#diaActividad').val($scope.fechasSemana[dia-1]);
  				fecha = $('#diaActividad').val();
  			}
  			
  			$scope.gridActividades = [];
  			$scope.gridArticulos = [];
  	  		$scope.mapa = {};
  	  		$scope.mapa.gridCoordenadas = [];

  			// se revisa si hay informacion en el arreglo general para la fecha
			// seleccionada
  			for(indice in $scope.gridActividadesSemana)
  			{
  				if ( fecha == $scope.gridActividadesSemana[indice].fecha)
  				{
  					$scope.gridActividades.push($scope.gridActividadesSemana[indice]);
  				}
  			}

  			for(indice in $scope.gridArticulosSemana)
  			{
  				if (fecha == $scope.gridArticulosSemana[indice].fecha)
  				{
  					$scope.gridArticulos.push($scope.gridArticulosSemana[indice]);
  				}
  			}

  			//console.info("mapasemana");
  			//console.info($scope.mapaSemana);
  			for(indice in $scope.mapaSemana)
  			{
  				if (fecha == $scope.mapaSemana[indice].fecha)
  				{
		  			if ($scope.mapaSemana[indice].gridCoordenadas.length >0)
		  			{
			  			var mapaTemp = {};
			  			mapaTemp.gridCoordenadas = [];
			  			for(rec_coord in $scope.mapaSemana[indice].gridCoordenadas)
			  			{
			    			var coordenadaP = {};
			    			coordenadaP.latitud = $scope.mapaSemana[indice].gridCoordenadas[rec_coord].latitud;
			    			coordenadaP.longitud = $scope.mapaSemana[indice].gridCoordenadas[rec_coord].longitud;
			    			coordenadaP.direccion = $scope.mapaSemana[indice].gridCoordenadas[rec_coord].direccion;

			  				mapaTemp.gridCoordenadas.push(coordenadaP);
			  			}
			  			mapaTemp.metros = $scope.mapaSemana[indice].metros;
			  			mapaTemp.fecha = $scope.mapaSemana[indice].fecha;

			  			$scope.mapa.fecha = mapaTemp.fecha;
			  			$scope.mapa.metros = mapaTemp.metros;
			  			$scope.mapa.gridCoordenadas = mapaTemp.gridCoordenadas;
			  			//console.info("mapa");
			  			//console.info($scope.mapa);
			  			//console.info("coordenadas:" + dia);
			  			//console.info($scope.mapa.gridCoordenadas);
			  			if (dia != 0)
			  			{
							setTimeout(function () { 
								for (var i = 0; i < $scope.mapa.gridCoordenadas.length; i++) {
									$scope.setDireccionEnReversaEditar($scope.mapa.gridCoordenadas[i].latitud, $scope.mapa.gridCoordenadas[i].longitud, $scope.mapa.gridCoordenadas[i].direccion);
								}
							}, 100);
						}
			  		}
  				}
  			}

  			//se revisa si hay observaciones capturadas
  			$('#observaciones').val("");
  			for (var i=0; i<$scope.diasAgenda.length; i++)
  			{
  				if (fecha == $scope.diasAgenda[i].fecha)
  				{
  					$('#observaciones').val($scope.diasAgenda[i].observaciones);
  				}
  			}

  			reseteaColorBotones();
  			cambiaColorBoton($scope.gridArticulos);
  			cambiaColorBoton($scope.gridActividades);
  			cambiaColorBoton($scope.mapa);

  		};

  		// ***para saber si esta seleccionado un dia de actividad para su
		// captura
  		$scope.validaSeleccion = function()
  		{  			  		
  			var respuesta = true;
  			if ($('#diaActividad').val() == "")
  			{
  				alert("Debe seleccionar un dia de la semana");
  				respuesta = false;
  			}
  			
  			if ($('#cboContrato').val() == "?")
  			{
  				alert("Debe seleccionar un contrato");
  				respuesta = false;  				
  			}
  			
  			if (!validado)
  			{
  				alert("Debe validar si existe informacion para el contrato y semana seleccionados");
  				respuesta = false;  				
  			}

  			return respuesta;
  		};

  		// ***para limpiar toda la pantalla
  		$scope.reiniciarPantalla = function(cambiaCombo)
  		{
  			idAgenda = 0;
  			validado = false;
  	  		$scope.gridActividades = [];
  	  		$scope.gridArticulos = [];
  	  		$scope.gridActividadesSemana = [];
  	  		$scope.gridArticulosSemana = [];
  	  		$('#diaActividad').val("");
  	  		$('#observaciones').val("");
  	  		$scope.fechasSemana= [];
  	  		
  	  		$("#btnD1").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD2").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD3").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD4").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD5").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD6").removeClass("btn-success").addClass("btn-primary");
  	  		$("#btnD7").removeClass("btn-success").addClass("btn-primary");

  	  		$scope.mapa = {};
  	  		$scope.mapaSemana = [];
  	  		$scope.mapa.gridCoordenadas = [];
  	  		$scope.diasAgenda = [];
  	  		
  	  		$scope.limpiarMarcadoresLectura();
  	  		$scope.limpiarMarcadores('1900-01-01');
  	  		  	  	  	  		
/*  	  		if (cambiaCombo == undefined || cambiaCombo == 'undefined')
  	  		{
  	  			$("#txtResidente").val("");
  	  			$("#numPersonas").val("");
  	  			$("#totalHrsHombre").val("");
  	  			$("#semana").val("");
  	  		}
  */	  			
  		};

  		// ***se cambia el color de los botones
  		cambiaColorBoton = function(objCaptura)
  		{
  			// se revisan los arreglos generales de acuerdo al arreglo de la
			// semana
  			var numeroBoton = -1;
  			var fecha = $("#diaActividad").val();
  			
  			for(var i=0; i < $scope.fechasSemana.length; i++)
  			{
  				// console.info($scope.fechasSemana[indice]);
  				// console.info(fecha);
  				if ($scope.fechasSemana[i] == fecha)
  				{
  					numeroBoton = Number(i) +1;
  					break;
  				}
  			}

  			if (numeroBoton == -1)
  			{
  				return;
  			}

  			//$("#btnD" + numeroBoton.toString()).removeClass("btn-success").addClass("btn-primary");

			for (indice2 in objCaptura)
			{
				if (objCaptura[indice2].fecha != undefined)
				{
	  				if (fecha == objCaptura[indice2].fecha)
	  				{
	  					$("#btnD" + numeroBoton.toString()).removeClass("btn-primary").addClass("btn-success");
	  					break;
	  				}
  				}
  				else
				{
	  				if (fecha == objCaptura.fecha)
	  				{
	  					$("#btnD" + numeroBoton.toString()).removeClass("btn-primary").addClass("btn-success");
	  					break;
	  				}
				}
			}
  		};


  		// ***resetea color de botones
  		reseteaColorBotones = function()
  		{
			if ($scope.fechasSemana.length == undefined || $scope.fechasSemana.length == 'undefined')
			{
				return;
			}
			
  			var fecha = $("#diaActividad").val();
  			for(var i=0; i < $scope.fechasSemana.length; i++)
  			{
  				if ($scope.fechasSemana[i] == fecha)
  				{
  					var numeroBoton = Number(i) +1;
  					$("#btnD" + numeroBoton.toString()).removeClass("btn-success").addClass("btn-primary");
  					break;
  				}
  			}
  		};

  		//***marcadores edicion map1
		$scope.setMarcadorEdicion = function(latLng, direccion) {
  			var validaDiaSel = $scope.validaSeleccion();
  			if (validaDiaSel == false)
  			{
  				return;
  			}

			// $('#msload').modal('show');
            var geocoder = new google.maps.Geocoder;
            var img_mark = 'altaContrato/mark.png';
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

	        var km = $scope.mapa.metros / metros_div;
	        var unidad_de_medida = " metros";
	        $scope.mapa.fecha= $('#diaActividad').val();
	        $( "#km" ).text(km.toFixed(2) + ' mts');
	        $( "#txtkm" ).text('Distancia');

        };
        
        
        $scope.setMarcadorLectura = function(latLng, direccion) {        	        	             	
			// $('#msload').modal('show');
            var geocoder = new google.maps.Geocoder;
            var img_mark = 'altaContrato/mark.png';
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

	        //se suman los tramos de todos los dias
	        var metrosTotales = 0; 
	        for (var i=0; i<$scope.diasAgenda.length; i++)
	        {
	        	//console.info("metros totales");
	        	//console.info($scope.diasAgenda[i].metros);	        	
	        	metrosTotales = metrosTotales + parseFloat($scope.diasAgenda[i].metros.replace(" mtrs", ""));
	        }	        
	        var km = metrosTotales / metros_div;
	        var unidad_de_medida = " metros";
	        $( "#km2" ).text(km.toFixed(2) + ' mts');
	        $( "#txtkm2" ).text('Distancia');

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
            		$('#msload').modal('hide');
            	} else {
            		$('#alert').show();
                    $('#msgerror').text('Problemas en la geolocalizaci�n debido ' + status + '')
                    // alert('Geocoder fallo debido al estatus: ' + status);
					$('#msload').modal('hide');
            	}
            });


            $scope.mLineaRecta();
    		reseteaColorBotones();
			cambiaColorBoton($scope.mapa);
      };


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

        google.maps.event.addListener(map, 'click', function(event) {
            // console.log(event);
        	// if($scope.nContrato) {
            	$scope.setMarcador(event.latLng);
			// } else {
			// $scope.setMarcadorEdicion(event.latLng);
			// }
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
        var mx12 = {lat: 19.34751544463381, lng: -98.98272888210454};
        map2 = new google.maps.Map(document.getElementById('map2'), {
          zoom: 7,
          center: mx12
        });

        google.maps.event.addListener(map2, 'click', function(event) {
            	//$scope.setMarcador(event.latLng);
        });
      };   	  

/*
 * $scope.calculaDistancia = function() { var length = 0; if
 * (medida.mvcPolygon.getLength() > 1) { length =
 * google.maps.geometry.spherical.computeLength(medida.line.getPath()); } var
 * area = 0; if (medida.mvcPolygon.getLength() > 2) { area =
 * google.maps.geometry.spherical.computeArea(medida.polygon.getPath()); } // lM =
 * document.forms["mb"].elements["mode"][0].checked; var km = length / 1000; var
 * unidad_de_medida = " metros"; $scope.coordenadas.metros = length; $( "#km"
 * ).text(km.toFixed(2) + ' km'); $( "#txtkm" ).text('Distancia');
 * //console.log('Distancia total:' + length.toFixed(0) + ' metros ' +
 * km.toFixed(3)); };
 */

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
          $scope.mapa.fecha= $('#diaActividad').val();
          $scope.mapa.metros = length;
          $( "#km" ).text(km.toFixed(2) + ' mts');
          $( "#txtkm" ).text('Distancia');
          // console.log('Distancia total:' + length.toFixed(0) + ' metros ' +
			// km.toFixed(3));
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
      
      $scope.setDireccionEnReversa = function(lat, lng) {
          var latlng = {lat: lat, lng: lng};
          var geocoder = new google.maps.Geocoder();
          // var address = document.getElementById('direccion').value;
          // geocoder.geocode({'address': address}, function(results, status)
			// {
          geocoder.geocode({'location': latlng}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                  map.setCenter(results[0].geometry.location);
                  $scope.setMarcador(results[0].geometry.location);
              } else {
                  alert('No se encontro la direccion , debido: ' + status);
              }
          });
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

    	  
    	  if (fecha == undefined || fecha == 'undefined')
    	  {
    		  fecha = $("#diaActividad").val();
    	  }

    	  //console.info("fecha:" + fecha);
    	  if (fecha != '1900-01-01')
    	  {
	  		  var agendado = $scope.validaAgendaAgregada(fecha);
	  		  if (agendado)
	  		  {
				alert("Para poder modificar el dia primero hay que quitarlo de la agenda");
				return;
	  		  }
  		  }  		  

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
          $scope.mapa = {};
          $scope.mapa.gridCoordenadas = [];
          medida.mvcMarkers.clear();
          $( "#tramos" ).empty();
          $( "#km" ).text('');
		  $( "#txtkm" ).text('');
          // document.getElementById('lineLength').innerHTML = '';
          // document.getElementById('polyArea').innerHTML = '';

		  reseteaColorBotones();
		  cambiaColorBoton($scope.gridArticulos);
		  cambiaColorBoton($scope.gridActividades);
		  cambiaColorBoton($scope.mapa);
		  //$scope.colocaMarcadoresSeleccionados();
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
      

      //regresa fecha descripcion
      $scope.obtenerDiaDesc = function(fecha)
      {
		  if ($scope.fechasSemana.length == undefined || $scope.fechasSemana.length == 'undefined')
		  {
			return;
		  }
			
    	  var dia=-1;
    	  var diaDesc = "";
    	  for(var i=0; i < $scope.fechasSemana.length; i++)
    	  {
    		  if ($scope.fechasSemana[i] == fecha)
    		  {
    			  dia = Number(i) +1;
    			  break;
    		  }
    	  }

    	  switch(dia)
    	  {
    	  	case 1:
				diaDesc= "LU";
				break;
			case 2:
				diaDesc= "MA";
				break;
			case 3:
				diaDesc= "MI";
				break;
			case 4:
				diaDesc= "JU";
				break;
			case 5:
				diaDesc= "VI";
				break;
			case 6:
				diaDesc= "SA";
				break;
			case 7:
				diaDesc= "DO";
				break;
    	  }

    	  //console.info("dia:" + diaDesc);
    	  return diaDesc;
      };

      $scope.agregarAgenda = function()
      {
			var fecha = $("#diaActividad").val();
			var numeBoton = -1;

			if ($scope.fechasSemana.length == undefined || $scope.fechasSemana.length == 'undefined')
			{
				return;
			}
			
			for(var i=0; i < $scope.fechasSemana.length; i++)
			{
				if ($scope.fechasSemana[i] == fecha)
				{
					numeroBoton = Number(i) +1;
					break;
				}
			}

			if (numeroBoton == -1)
			{
				if (fecha == "")
				{
					alert("Debe seleccionar algun dia, favor de verificar");
				}
				return;
			}

			//se valida que se hayan capturado actividades, materias y por lo menos 2 puntos de direccion
			if (!$scope.validaAgregarAgenda(fecha))
			{
				return;
			}


			//en caso de no estar en el arreglo se agrega
			var encontrado = false;
			for(var i=0; i < $scope.diasAgenda.length; i++)
			{
				if ($scope.diasAgenda[i].fecha == fecha)
				{
					encontrado = true;
					break;
				}
			}

			//se llena el objeto para llenar los dias agregados a la agenda
			if (!encontrado)
			{
	  			if ($scope.mapa.gridCoordenadas.length >0)
	  			{
		  			var mapaTemp = {};
		  			var indice = $scope.mapa.gridCoordenadas.length-1;
		  			mapaTemp.direccion = $scope.mapa.gridCoordenadas[0].direccion;
		  			//console.info("FFFFF");
		  			//console.info($scope.mapa.metros);
		  			var metros = $scope.mapa.metros;
                    var km = $scope.mapa.metros / metros_div;
		  			mapaTemp.metros = km.toFixed(2) + " mts";
		  			mapaTemp.fecha = $scope.mapa.fecha;
		  			mapaTemp.diaDesc = $scope.obtenerDiaDesc(fecha) + " " + $scope.mapa.fecha;
		  			mapaTemp.observaciones = $("#observaciones").val();
					$scope.diasAgenda.push(mapaTemp);
		  		}

			}
			else
			{
				alert("Este dia ya esta agregado en la agenda");
				return;
			}

			$scope.obtenerFechaSeleccionada(0);			
			$scope.colocarMarcadoresSeleccionados();			

      };

      //agregar datos a la agenda
      $scope.validaAgregarAgenda = function(fecha)
      {

    	  var encontrado = false;

  			// actividades
  			// ************************************************
  			for(var indice=$scope.gridActividades.length-1; indice>=0; indice--)
  			{
  				if ( fecha == $scope.gridActividades[indice].fecha)
  				{
  					encontrado = true;
  					break;
  				}
  			}

  			if (encontrado == false)
  			{
  				alert("Para agregar la agenda es necesario capturar las actividades, favor de verificar");
  				return false;
  			}

  			encontrado = false;

  			// articulos
  			// ************************************************
  			for(var indice=$scope.gridArticulos.length-1; indice>=0; indice--)
  			{
  				if (fecha == $scope.gridArticulos[indice].fecha)
  				{
  					encontrado = true;
  					break;
  				}
  			}

  			if (encontrado == false)
  			{
  				alert("Para agregar la agenda es necesario capturar los materiales, favor de verificar");
  				return false;
  			}

  			encontrado = false;

  			 // mapa
  			// ************************************************
  			var puntos =$scope.mapa.gridCoordenadas.length;

  			if (puntos < 2)
  			{
  				alert("Para agregar la agenda es necesario capturar al menos 2 puntos en el mapa, favor de verificar");
  				return false;
  			}
  			else
  			{
  				encontrado = true;
  			}
  			
  			if ($('#observaciones').val() == "")
  			{
  				alert("Debe capturar las observaciones");
  				return false;
  			}

  			return true;

      };

      //eliminar de las agendas
      $scope.eliminarDiaAgenda = function(fecha)
      {
    	  //console.info("Fecha");
    	  //console.info(fecha);
    	  //console.info($scope.diasAgenda);
			for(var i=$scope.diasAgenda.length-1; i>=0; i--)
			{
				if ($scope.diasAgenda[i].fecha == fecha)
				{
					$('#observaciones').val($scope.diasAgenda[i].observaciones);
					$scope.diasAgenda.splice(i,1);
					break;
				}
			}
			
			$scope.limpiarMarcadoresLectura();
			$scope.colocarMarcadoresSeleccionados();
      };

      //valida agenda agregada
      $scope.validaAgendaAgregada = function(fecha)
      {
    	  var encontrado = false;
    	  for(var i=$scope.diasAgenda.length-1; i>=0; i--)
    	  {
    		  if ($scope.diasAgenda[i].fecha == fecha)
    		  {
    			  encontrado = true;
    			  break;
    		  }
    	  }

    	  return encontrado;
      };
      
      //***coloca los marcadores agendados
      $scope.colocarMarcadoresSeleccionados = function()
      {
    	  //se limpian los marcadores existentes
    	  $scope.limpiarMarcadoresLectura();

    	  //console.info("colocarMarcadoresSeleccionados");
    	  //console.info($scope.diasAgenda);
    	  //console.info($scope.mapaSemana);
    	  //arreglo de fechas de la semana seleccionada
    	  for(var i=0; i < $scope.fechasSemana.length; i++)
    	  {
    		  var fecha = $scope.fechasSemana[i];
    		  
    		  //console.info("colocarMarcadoresSeleccionados");    		  
    		  //console.info(fecha);
				    			  
    		  //arreglo de las fechas agendadas
    		  for (j=0; j<$scope.diasAgenda.length; j++)
    		  {
    			  if (fecha == $scope.diasAgenda[j].fecha)
    			  {    			
    				  
    				  //console.info("dias agenda:" +$scope.diasAgenda[j].fecha);
    				  //coordenadas de toda la semana
			  		  //for(var indice=$scope.mapaSemana.length-1; indice>=0; indice--)
    				  for(var indice=0; indice<$scope.mapaSemana.length; indice++)
			  		  {
			  			  if (fecha == $scope.mapaSemana[indice].fecha)
			  			  {
			  				  //console.info("colocarMarcadoresSeleccionados");
			  				  //console.info( $scope.mapaSemana[indice]);				  
			  				  if ($scope.mapaSemana[indice].gridCoordenadas.length >0)
			  				  {
			  					//console.info($scope.mapaSemana[indice].gridCoordenadas);
								//setTimeout(function () {
									//for (var rec_coord = $scope.mapaSemana[indice].gridCoordenadas.length-1; rec_coord >=0 ; rec_coord--) {
									  for (var rec_coord = 0; rec_coord < $scope.mapaSemana[indice].gridCoordenadas.length ; rec_coord++) {								
										var direccion = $scope.mapaSemana[indice].gridCoordenadas[rec_coord].direccion;
										console.info("colocarMarcadoresSeleccionados");
										console.info( $scope.mapaSemana[indice].fecha + " " + direccion);
										$scope.setDireccionEnReversaLectura($scope.mapaSemana[indice].gridCoordenadas[rec_coord].latitud, $scope.mapaSemana[indice].gridCoordenadas[rec_coord].longitud, direccion);
										}
									//}, 500);
			  				  }
			  				  break;
			  			  }
			  		  }  			  						
    			  }  					
    		  }  				
    	  }
      };
      
      //***registra la agenda
      $scope.registrarAgenda = function(objContrato)
      {      
    	  //Se valida que haya dias agendados
    	  if ($scope.diasAgenda.length == 0)
    	  {
    		  alert("No hay dias agendados por registrar");
    		  return;
    	  }
    	  
    	  $scope.agendaObj = {};
    	  $scope.agendaObj.JSONAltaAgenda = {};
    	  $scope.agendaObj.JSONAltaAgenda.idContrato 		= objContrato.idContrato;
    	  $scope.agendaObj.JSONAltaAgenda.fechaInicio 		= $('#ini').val();
    	  $scope.agendaObj.JSONAltaAgenda.fechaFin 			= $('#fin').val();
    	  $scope.agendaObj.JSONAltaAgenda.noHoras			= $('#totalHrsHombre').val();
    	  $scope.agendaObj.JSONAltaAgenda.noTrabajadores	= $('#numPersonas').val();
    	  $scope.agendaObj.JSONAltaAgenda.noSemana			= $('#semana').val();
    	  $scope.agendaObj.JSONAltaAgenda.usuario 			= $scope.usuario.usuario;
    	  $scope.agendaObj.JSONAltaAgenda.idAgenda			= idAgenda;
    	  //$scope.agendaObj.JSONAltaAgenda.agendaDetalle	= [];
    	  $scope.agendaObj.JSONAltaAgenda.diasAgenda		= [];
    	  
    	  //se recorren los dias agendados
    	  for (var liAgendados=0; liAgendados<$scope.diasAgenda.length; liAgendados++)
    	  {    		  
    		  var diasAgendaTemp = {};
    		  diasAgendaTemp.actividades = [];
    		  diasAgendaTemp.materiales = [];
    		  diasAgendaTemp.coordenadas = [];
    		  
    		  var fecha = $scope.diasAgenda[liAgendados].fecha;
    		      		  
    		  //se arma el arreglo de actividades    		  
    		  var actividades = [];    		  
    		  //codigo, fecha
    		  for(var liActividades=0; liActividades<$scope.gridActividadesSemana.length; liActividades++)
	  		  {
	  			  if ( fecha == $scope.gridActividadesSemana[liActividades].fecha)
	  			  {
	  				  var actividadesTemp = {};
	  				  actividadesTemp.codigoActividad	= $scope.gridActividadesSemana[liActividades].codigo;
	  				  
	  				  actividades.push(actividadesTemp);
	  			  }
	  		  }
    		  
	  		  //se arma el arreglo de articulos
    		  var articulos = [];
    		  for(var liArticulos=0; liArticulos<$scope.gridArticulosSemana.length; liArticulos++)
	  		  {
	  			  if ( fecha == $scope.gridArticulosSemana[liArticulos].fecha)
	  			  {
	  				  var articulosTemp = {};
	  				  articulosTemp.codigoMaterial		= $scope.gridArticulosSemana[liArticulos].codigo;
	  				  
	  				  articulos.push(articulosTemp);
	  			  }
	  		  }
	  		  
	  		  //se arma el arreglo de coordenadas
			  var coordenadas = [];

    		  for(var liMapa=0; liMapa < $scope.mapaSemana.length; liMapa++)
    		  {    			  
    			  if (fecha == $scope.mapaSemana[liMapa].fecha)
    			  {
    	    		  var orden = 0;
    				  for(rec_coord in $scope.mapaSemana[liMapa].gridCoordenadas)
    				  {
    	    			  orden++;
    					  var coordenadaP = {};
    					  coordenadaP.orden		= orden;
    					  coordenadaP.latitud 	= $scope.mapaSemana[liMapa].gridCoordenadas[rec_coord].latitud;
    					  coordenadaP.longitud 	= $scope.mapaSemana[liMapa].gridCoordenadas[rec_coord].longitud;
    					  coordenadaP.direccion = $scope.mapaSemana[liMapa].gridCoordenadas[rec_coord].direccion;

    					  coordenadas.push(coordenadaP);
    				  }    				      				  
    			  }
    		  }    		  
	  		  
    		  diasAgendaTemp.fecha 			= fecha;
    		  diasAgendaTemp.avanceEsperado = $scope.diasAgenda[liAgendados].metros.replace(" mts", "");
    		  diasAgendaTemp.observaciones 	= $scope.diasAgenda[liAgendados].observaciones;	  		  
    		  diasAgendaTemp.actividades 	= actividades;
    		  diasAgendaTemp.materiales		= articulos;
    		  diasAgendaTemp.coordenadas	= coordenadas; 
    		
    		  $scope.agendaObj.JSONAltaAgenda.diasAgenda.push(diasAgendaTemp);
    		
    		  //console.info("*********agendaDetalleTEMP********");
    		  //console.dir (agendaDetalleTemp);
    		  //console.info(JSON.stringify(agendaDetalleTemp));
    	  }

    	  //console.info("*********agendaDetalle********");    	  
    	  //console.dir ($scope.agendaObj.JSONAltaAgenda.agendaDetalle);
    	 
    	  
    	  	//comentarios Soto ---- aqui conviertes tu objeto a json
    	  var jsonAgenda = JSON.stringify($scope.agendaObj.JSONAltaAgenda);
    	  console.info(jsonAgenda);
    	  
    	  $('#msload').modal('show');
    	      
	      $http({
              method: 'POST',
              url: '/CuadrillasWEB/AltaAgenda',
              params: {
                'JSONAltaAgenda': jsonAgenda
              },
              data: { }
        }).then(function mySucces(response) {
	    	$('#msload').modal('hide');
	    	$scope.reiniciarPantalla();
	    	validado=false;
	    	alert(response.data.mensajeFuncional);
			//$('#success').show();
			//$('#msgaviso').text(response.data.mensajeFuncional);
	    	 console.info(response);
	    }, function myError(response) {
	    	$('#msload').modal('hide');
	    	alert(response.data.mensajeFuncional);
	    	//console.error(response);
			//$('#alert').show();
			//$('#msgerror').text(response.data.mensajeFuncional);
	    });
      };

      //***funcion para consultar agenda existente
      $scope.consultarAgenda = function(objContratos)
      {
    	  var respuesta = true;
    	  //validaciones
    	  if ($('#cboContrato').val() == "?")
    	  {
    		  alert("Debe seleccionar un contrato");
    		  respuesta = false;  				
    	  }
    	  
    	  if ($('#semana').val() == "")
    	  {
    		  alert("Debe seleccionar una semana");
    		  respuesta = false;  				
    	  }
    	  
    	  if (!respuesta)
    	  {
    		return;  
    	  }
    	  
    	  $('#msload').modal('show');    	  
    	  
    	  validado = true;    	     	 
    	  idAgenda= 0;
    	  
	      $http({
              method: 'GET',
              url: '/CuadrillasWEB/ConsultaAgendaSemanal',
              params: {
                'idContrato'	: objContratos.idContrato,
                'noSemana' 		: $('#semana').val(),
                'fechaBusqueda' : $('#fecha').val().substring(0,4)
              },
              data: { }
	      }).then(function successfn(response) {
        	//console.info("***consulta");
        	//console.info(response);
        	//alert(response.data.header.mensajeFuncional);
        	idAgenda = response.data.agenda.idAgenda;
        	$scope.procesarConsulta(response.data);        	
        	$('#msload').modal('hide');
        	
              // console.log(result);
	      }, function errorfn(response) {
        	//console.info("***error");
        	//console.info(response);
        	idAgenda = 0;
            alert(response.data.header.mensajeFuncional);
            $('#msload').modal('hide');
	      });    	  
      };

  	  // ***funcion para colocar la fecha de plan de actividades de acuerdo al
      // a la fecha seleccionada
  	  $scope.llenaObjetosSemanales = function(fecha)
  	  {  			
  		  // se pasa lo capturado al arreglo de toda la semana
  		  // actividades
  		  // ************************************************
  		  for(var indice=$scope.gridActividadesSemana.length-1; indice>=0; indice--)
  		  {
  			  if ( fecha == $scope.gridActividadesSemana[indice].fecha)
  			  {
  				  $scope.gridActividadesSemana.splice(indice,1);
  			  }
  		  }

  		  for(indice in $scope.gridActividades)
  		  {
  			  $scope.gridActividadesSemana.push($scope.gridActividades[indice]);
  		  }

  		  // articulos
  		  // ************************************************
  		  for(var indice=$scope.gridArticulosSemana.length-1; indice>=0; indice--)
  		  {
  			  if (fecha == $scope.gridArticulosSemana[indice].fecha)
  			  {
  				  $scope.gridArticulosSemana.splice(indice,1);
  			  }
  		  }

  		  for(indice in $scope.gridArticulos)
  		  {
  			  $scope.gridArticulosSemana.push($scope.gridArticulos[indice]);
  		  }

  		  // mapa
  		  // ************************************************
  		  if ($scope.mapa.gridCoordenadas.length >0)
  		  {
  			  for(var indice=$scope.mapaSemana.length-1; indice>=0; indice--)
  			  {
  				  if (fecha == $scope.mapaSemana[indice].fecha)
  				  {
  					  $scope.mapaSemana.splice(indice,1);
  				  }
  			  }

  			  var mapaTemp = {};
  			  mapaTemp.gridCoordenadas = [];
  			  for(indice in $scope.mapa.gridCoordenadas)
  			  {
  				  var coordenadaP = {};
  				  coordenadaP.latitud = $scope.mapa.gridCoordenadas[indice].latitud;
  				  coordenadaP.longitud = $scope.mapa.gridCoordenadas[indice].longitud;
  				  coordenadaP.direccion = $scope.mapa.gridCoordenadas[indice].direccion;

  				  mapaTemp.gridCoordenadas.push(coordenadaP);
  			  }
  			  mapaTemp.metros = $scope.mapa.metros;
  			  mapaTemp.fecha = $scope.mapa.fecha;
  			  $scope.mapaSemana.push(mapaTemp);
  		  }

  		  reseteaColorBotones();
  		  cambiaColorBoton($scope.gridArticulos);
  		  cambiaColorBoton($scope.gridActividades);
  		  cambiaColorBoton($scope.mapa);
  	  };
  		
    //***Se procesa la consulta
    $scope.procesarConsulta = function(objConsulta)
    {    	
    	//console.info(objConsulta.agenda[0]);
    	//se arma el arreglo de fechas de la semana
	  	var semanaInicioDate = objConsulta.agenda.fechaInicio;
	  	var primerFechaCapturada = "";
/*	  	var semanaFinDate = objConsulta.agenda[0].fechaFin.toDate();
	  	$('#ini').val(semanaInicioDate.format("YYYY-MM-DD"));
	  	$('#fin').val(semanaFinDate.format("YYYY-MM-DD"));
	  	$('#semana').val(moment(semanaInicioDate).week());
	  	$('#cboContrato').val(objConsulta.agenda[0].idContrato);
*/	  	

	  	// se arma el arreglo de dias de la semana
	  	$scope.fechasSemana= [];
	  	for (var i=1; i<=7; i++)
	  	{
	  		var contador = i;
	  		$scope.fechasSemana.push(mostrarFecha(contador, semanaInicioDate))
	  	}
    	
    	$scope.gridActividadesSemana	= [];
  		$scope.gridArticulosSemana 		= [];
  		$scope.mapaSemana 				= [];
    	$scope.diasAgenda 				= [];
  		
    	//Se llena el objeto de dias agenda
    	for (var i=0; i<objConsulta.agenda.diasAgenda.length; i++)
    	{
        	//se inicializan los arreglos
        	$scope.gridActividades = [];    	
      		$scope.gridArticulos = [];
      		$scope.mapa = {};
      		$scope.mapa.gridCoordenadas = [];      		
      		
    		var fechaObj = objConsulta.agenda.diasAgenda[i].fecha;    	
    		    		
    		$("#diaActividad").val(fechaObj);
    		    		
    		//se llena el objeto de actividades
    		for(var liActividades=0; liActividades < objConsulta.agenda.diasAgenda[i].actividades.length; liActividades++)
    		{
    			var actividad = {};
    			actividad.fecha = fechaObj;
    			actividad.codigo = objConsulta.agenda.diasAgenda[i].actividades[liActividades].codigoActividad;
    			actividad.descripcion = objConsulta.agenda.diasAgenda[i].actividades[liActividades].descripcionActividad;
    			$scope.gridActividades.push(actividad);
	  		}
	  		
	  		//se llena el objeto de articulos
    		for(var liArticulos=0; liArticulos < objConsulta.agenda.diasAgenda[i].materiales.length; liArticulos++)
    		{
    			var articulo = {};
    			articulo.fecha = fechaObj;
    			articulo.codigo = objConsulta.agenda.diasAgenda[i].materiales[liArticulos].codigoMaterial;
    			articulo.descripcion = objConsulta.agenda.diasAgenda[i].materiales[liArticulos].descripcionMaterial;
    			$scope.gridArticulos.push(articulo);
	  		}
    		
	  		//se llena el objeto de mapa
	  		var mapaTemp = {};
	  		mapaTemp.gridCoordenadas = [];
	  		//console.info("coordenadas consulta");
	  		//console.info(objConsulta.agenda[0].diasAgenda[i].coordenadas);
	  		for(var liCoordenadas=0; liCoordenadas < objConsulta.agenda.diasAgenda[i].coordenadas.length; liCoordenadas++)
	  		{
	  			var coordenadaP = {};
	    		coordenadaP.latitud 	= objConsulta.agenda.diasAgenda[i].coordenadas[liCoordenadas].latitud;
	    		coordenadaP.longitud 	= objConsulta.agenda.diasAgenda[i].coordenadas[liCoordenadas].longitud;
	    		coordenadaP.direccion 	= objConsulta.agenda.diasAgenda[i].coordenadas[liCoordenadas].direccion;

	  			mapaTemp.gridCoordenadas.push(coordenadaP);
	  		}
	  		mapaTemp.metros	= objConsulta.agenda.diasAgenda[i].avanceEsperado;
	  		mapaTemp.fecha 	= objConsulta.agenda.diasAgenda[i].fecha;
	  		
			$scope.mapa.fecha = mapaTemp.fecha;
			$scope.mapa.metros = mapaTemp.metros;
			$scope.mapa.gridCoordenadas = mapaTemp.gridCoordenadas;

			//se llena dias agenda
  			var agendaTemp = {};
  			if ($scope.mapa.gridCoordenadas.length > 0)
  			{
  				agendaTemp.direccion = $scope.mapa.gridCoordenadas[0].direccion;
  			}  			
  			var metros = objConsulta.agenda.diasAgenda[i].avanceEsperado;
            var km = metros / metros_div;            
  			agendaTemp.metros = km.toFixed(2) + " mts";
  			agendaTemp.fecha = fechaObj;
  			agendaTemp.diaDesc = $scope.obtenerDiaDesc(fechaObj) + " " + fechaObj;
  			agendaTemp.observaciones = objConsulta.agenda.diasAgenda[i].observaciones;
			$scope.diasAgenda.push(agendaTemp);
			
			$scope.llenaObjetosSemanales(fechaObj);			
    	}
    	
    	//para seleccionar el primer boton capturado
  		var numeroBoton = -1;  		
  		for(var i=0; i < $scope.fechasSemana.length; i++)
  		{
			if ($scope.fechasSemana[i] == fechaObj)
			{
				numeroBoton = Number(i) +1;
				break;
			}
  		}

  		$scope.obtenerFechaSeleccionada(numeroBoton);
  		
  		setTimeout(function () {
  			$scope.colocarMarcadoresSeleccionados()}, 5000);		 
    };
  		
  		
      //para inicializar los mapas
      $scope.initMap();
      $scope.initMap2();
    });    
    //FIN REGISTRO AGENDA SEMANAL

    //CONSULTA DE AGENDA
    app.controller('consultaagendactrl', function ($scope, $http) {
    	
        var map;
        var medida;
        
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	    $('#fecha').datepicker({
	    	format: 'yyyy-mm-dd',
	        container: container,
	        todayHighlight: true,
	        autoclose: true,
	        language: "es"
	    });
                    	
        //***Consulta de la agenda
        $scope.consultarAgendaDia = function()
        {
        	//bot�n de mapa ng-click="muestraMap()"
        	$('#msload').modal('show'); 
        	
      		$scope.gridActividades = [];
      		$scope.gridArticulos = [];
      		$scope.mapa = {};
      		$scope.mapa.gridCoordenadas = [];

      		$scope.limpiarMarcadores();
      			      		        	
        	$http({
        		method: 'GET',
        		url: '/CuadrillasWEB/ConsultaAgendaDia',
        		params: {
                	'idCuadrilla'	: 1, //$scope.usuario.idCuadrilla,
                	'fecha' 		: $('#fecha').val()
              	},
              	data: { }
        	}).then(function successfn(response) {
        		console.info("***consulta dia");
        		console.info(response);
        		//alert(response.data.header.mensajeFuncional);        		
        		procesarConsulta(response.data);        	
        		$('#msload').modal('hide');
        	
        		// console.log(result);
        	}, function errorfn(response) {
        		//console.info("***error");
        		//console.info(response);
        		idAgenda = 0;
        		alert(response.data.header.mensajeFuncional);
        		$('#msload').modal('hide');
        	});        	
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
        
        var metros_div = 1;
		$scope.setMarcadorEdicion = function(latLng, direccion) {
			// $('#msload').modal('show');
            var geocoder = new google.maps.Geocoder;
            var img_mark = 'altaContrato/mark.png';
            var marcador = new google.maps.Marker({map: map, position: latLng, icon: img_mark, draggable: false});
            medida.mvcLine.push(latLng);
            medida.mvcPolygon.push(latLng);
            medida.mvcMarkers.push(marcador);
            var latLngIndex = medida.mvcLine.getLength() - 1;
            var latlng = {lat: latLng.lat, lng: latLng.lng};
            //var direccion = 'SN';
            // console.log(results);
			// $('#msload').modal('hide');
	        $scope.mLineaRectaEdita();
	        
	        var km = $scope.mapa.metros / metros_div;
	        var unidad_de_medida = " metros";
	        $( "#km" ).text(km.toFixed(2) + ' mts');
	        $( "#txtkm" ).text('Distancia:  ');

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
        
        //***Inicializa el mapa
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

            google.maps.event.addListener(map, 'click', function(event) {
                	//$scope.setMarcador(event.latLng);
            });            
        };

        
        $scope.muestraMap = function() {                
        	
            //en caso de haber información en el arreglo de mapas se muestran los marcadores
        	setTimeout(function () { 
        		
        		
        		for (var i = 0; i < $scope.mapa.gridCoordenadas.length; i++) {
				//console.info($scope.mapa.gridCoordenadas[i].direccion);
					$scope.setDireccionEnReversaEditar($scope.mapa.gridCoordenadas[i].latitud, $scope.mapa.gridCoordenadas[i].longitud, $scope.mapa.gridCoordenadas[i].direccion);
				}
			}, 500);
        	
			$scope.initMap();
        };
        
        //***Se prepara la informacion para mostrarla en pantalla
        procesarConsulta = function(objConsulta)
        {
        	if ($('#fecha').val() == "")
        	{
        		alert("Debe seleccionar una fecha");
        		return;
        	}
        
    		//se llena el objeto de actividades
        	var fechaObj = objConsulta.agenda.diasAgenda[0].fecha;
    		for(var liActividades=0; liActividades < objConsulta.agenda.diasAgenda[0].actividades.length; liActividades++)
    		{
    			var actividad = {};
    			actividad.fecha = fechaObj;
    			actividad.codigo = objConsulta.agenda.diasAgenda[0].actividades[liActividades].codigoActividad;
    			actividad.descripcion = objConsulta.agenda.diasAgenda[0].actividades[liActividades].descripcionActividad;
    			$scope.gridActividades.push(actividad);
	  		}
	  		
	  		//se llena el objeto de articulos
    		for(var liArticulos=0; liArticulos < objConsulta.agenda.diasAgenda[0].materiales.length; liArticulos++)
    		{
    			var articulo = {};
    			articulo.fecha = fechaObj;
    			articulo.codigo = objConsulta.agenda.diasAgenda[0].materiales[liArticulos].codigoMaterial;
    			articulo.descripcion = objConsulta.agenda.diasAgenda[0].materiales[liArticulos].descripcionMaterial;
    			$scope.gridArticulos.push(articulo);
	  		}
    		
	  		//se llena el objeto de mapa
	  		var mapaTemp = {};
	  		mapaTemp.gridCoordenadas = [];
	  		//console.info("coordenadas consulta");
	  		//console.info(objConsulta.agenda[0].diasAgenda[i].coordenadas);
	  		for(var liCoordenadas=0; liCoordenadas < objConsulta.agenda.diasAgenda[0].coordenadas.length; liCoordenadas++)
	  		{
	  			var coordenadaP = {};
	    		coordenadaP.latitud 	= objConsulta.agenda.diasAgenda[0].coordenadas[liCoordenadas].latitud;
	    		coordenadaP.longitud 	= objConsulta.agenda.diasAgenda[0].coordenadas[liCoordenadas].longitud;
	    		coordenadaP.direccion 	= objConsulta.agenda.diasAgenda[0].coordenadas[liCoordenadas].direccion;

	  			mapaTemp.gridCoordenadas.push(coordenadaP);
	  		}
	  		mapaTemp.metros	= objConsulta.agenda.diasAgenda[0].avanceEsperado;
	  		mapaTemp.fecha 	= objConsulta.agenda.diasAgenda[0].fecha;
	  		
			$scope.mapa = {};
			$scope.mapa.gridCoordenadas = [];
			$scope.mapa.fecha = mapaTemp.fecha;
			$scope.mapa.metros = mapaTemp.metros;
			$scope.mapa.gridCoordenadas = mapaTemp.gridCoordenadas;			
			
			console.info("consulta agenda");
			console.info($scope.mapa);

            //en caso de haber información en el arreglo de mapas se muestran los marcadores
        	setTimeout(function () { 
			for (var i = 0; i < $scope.mapa.gridCoordenadas.length; i++) {
				console.info($scope.mapa.gridCoordenadas[i].direccion);
				$scope.setDireccionEnReversaEditar($scope.mapa.gridCoordenadas[i].latitud, $scope.mapa.gridCoordenadas[i].longitud, $scope.mapa.gridCoordenadas[i].direccion);
			}
			}, 100);			
        };
        
        
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
          $scope.mapa = {};
          $scope.mapa.gridCoordenadas = [];
          medida.mvcMarkers.clear();
          $( "#tramos" ).empty();
          $( "#km" ).text('');
		  $( "#txtkm" ).text('');
        };
        
        $scope.initMap();        
    });    
    //FIN CONSULTA DE AGENDA
		
    //CATALOGO HERRMIENTAS
    app.controller('adminherramientasctl', function ($scope, $http) {
    	
		contenido_textarea = "" 
		num_caracteres_permitidos = 99 
		
		$scope.validaLongitud= function(){ 
			num_caracteres = $('#txtDescripcion').val().length; 
		
		   if (num_caracteres > num_caracteres_permitidos){ 
			   var cadena = $('#txtDescripcion').val();
			   cadena = cadena.substring(0, num_caracteres_permitidos);
			   $('#txtDescripcion').val(cadena);
		   } 	 
		}
    

        //ocultar notificaciones
		$scope.hideAlerts = function() {
			$('#alert').hide();
			$('#success').hide();
		};
		
		//llamado a la funcion que oculta alerts
		$scope.hideAlerts();
                       
		$scope.consultaHerramientas = function() {
	
	    	// se llena catalogo de estatus de herramienta
	        $('#msload').modal('show');
	    	$http({
	    		method: 'GET',
		        url: '/CuadrillasWEB/ConsultaCatalogo',
	            params: {
	            	'tipoCatalogo': 'ESTA_HERRA'
	            },
	            data: { }
	        }).then(function successfn(result) {
	        	$scope.catEstatus = result.data.catalogo;
	        	//console.info(result.data.catalogo);
	        	$('#msload').modal('hide');
	        }, function errorfn(response) {
	        	//console.error(response);
	        	$('#msload').modal('hide');        	
	            alert(response.data.header.mensajeFuncional);            
	        });

	    	// se llena catalogo de tipo de herramienta
	    	$('#msload').modal('show');
	    	$http({
	    		method: 'GET',
	    		url: '/CuadrillasWEB/ConsultaCatalogo',
	    		params: {
	            	'tipoCatalogo': 'TIPO_ARTIC'
	            },
	            data: { }
	        }).then(function successfn(result) {
	        	$scope.catTipo = result.data.catalogo;
	        	$('#msload').modal('hide');
	        	// console.log(result);
	        }, function errorfn(response) {
	        	//console.error(response);
	        	$('#msload').modal('hide');
	            alert(response.data.header.mensajeFuncional);            
	        });			

	    	$('#msload').modal('show');
	    	$http({
	    		method: 'GET',
	    		url: '/CuadrillasWEB/ConsultaHerramienta',
	    		data: { }
	    	}).then(function mySucces(result) {
				$('#msload').modal('hide');				
				//$scope.hideAlerts(); //ocultar notificaciones
				$scope.resultadoHerramienta = result.data.herramienta;
				//console.log(result);
	    	}, function myError(response) {
				$('#msload').modal('hide');
				//console.error(response);
				//$scope.resultadoHerramienta = response.data.herramienta;
				$('#alert').show();
				$('#msgerror').text(response.data.header.mensajeFuncional)
	    	});
		};
		
		//llamado a la función cuando se carga la pantalla
		$scope.consultaHerramientas();
		
		//función para limpiar los campos
    	$scope.reset = function(form) {
				/*$('#txtNumeroHerramienta').val("");
				$('#txtArticulo').val("");
				$('#txtDescripcion').val("");
				$('#txtMarca').val("");				
				$('#txtModelo').val("");
				$('#txtSerie').val("");*/
				$scope.herramientas={};
				$scope.formHerramienta.$setPristine();
		};    				
		
		//alta de cuadrilla
		$scope.registrar = function(herramientas) {			
			var idHerramienta = herramientas.idHerramienta;
			var herramienta = herramientas.nombre;
			var descripcion = herramientas.descripcion;
			var estatus = herramientas.codigoEstatus;
			var tipo = herramientas.codigoTipo;
			var marca =	herramientas.marca;			
			var modelo = herramientas.modelo;
			var serie = herramientas.noSerie;
			
			//validar información
			//console.info("registrar");
			
			if ($scope.validaCampos(herramientas) == true)
			{
				return false;
			}			 
			
			if ($('#txtNumeroHerramienta').val() == "")
			{
				if ($scope.formHerramienta.$valid) {
					var confirmar = confirm("¿Esta seguro de registrar la herramienta?");
					if (!confirmar)
					{
						$('#alert').show();
						$('#msgerror').text('Se ha cancelado la operacion.');
						$scope.formHerramienta.$setPristine();
						return false;
					}else  {
					 $('#msload').modal('show');
					 $('#alert').hide();
					}
			
					$http({
						method: 'GET',
						url: '/CuadrillasWEB/RegistrarHerramienta',
						params: {
							"nombre" 		: herramienta,
							"descripcion" 	: descripcion,
							"codigoEstatus"	: estatus,
							"codigoTipo" 	: tipo,
							"marca" 		: marca,
							"modelo"		: modelo,
							"noSerie" 		: serie, 
							"usuarioAlta" 	: data.data.usuario.usuario			
						}
					}).then(function mySucces(response) {
						$scope.formHerramienta.$setPristine();
						//console.info(response);
						$('#success').show();
						$('#msgaviso').text(response.data.mensajeFuncional);
						$scope.consultaHerramientas();
						$('#msload').modal('hide');
					}, function myError(response) {
						$('#msload').modal('hide');
						console.error(response);
						$('#alert').show();
						$('#msgerror').text(response.data.mensajeFuncional);
						$scope.formHerramienta.$setPristine();
					});
				} //if de pantalla valida
			} //if de registrar
			else
			{
				//Actualiza la cuadrilla				
				var confirmar = confirm("¿Esta seguro de actualizar la herramienta?");
		    	 if (!confirmar)
		    	 {
		    		 $('#alert').show();
		    		 $('#msgerror').text('Se ha cancelado la operacion.');
		    		 $scope.formHerramienta.$setPristine();
		    		 return false;
		    	 } 
		    	 else 
		    	 {
		    		 $('#msload').modal('show');
		    		 $('#alert').hide();
		    	 }
		    	 
		    	 $http({
		              method: 'GET',
		              url: '/CuadrillasWEB/ActualizarHerramienta',
		              params: 
		              {
		            	"idHerramienta"	: idHerramienta,
		    		 	"nombre" 		: herramienta,
						"descripcion" 	: descripcion,
						"codigoEstatus"	: estatus,
						"codigoTipo" 	: tipo,
						"marca" 		: marca,
						"modelo"		: modelo,
						"noSerie" 		: serie, 
						"usuarioAlta" 	: data.data.usuario.usuario		            	  
		              }
		    	 }).then(function mySucces(response) 
		    	 {
		    		 //$scope.consultaCuadrilla();
				    console.log(response);
				    $scope.consultaHerramientas();
					$('#msload').modal('hide');
					$scope.formHerramienta.$setPristine();
					$scope.reset();
					$('#success').show();
				    $('#msgaviso').text(response.data.mensajeFuncional);
				 }, function myError(response) 
				 {
					 $('#msload').modal('hide');
					 $('#alert').show();
					 $('#msgerror').text(response.data.mensajeFuncional);
					 $scope.formHerramienta.$setPristine();
					 console.error(response);
				 });				
			} //if de actualizar
    	};
    				
		//baja
		$scope.bajaHerramienta = function(datosHerramienta) {
			var confirmar = confirm("¿Esta seguro de dar de baja la herramienta? ");

    		if (!confirmar)
    		{
    			//alert('se ha cancelado la operacion.');
				$('#alert').show();
				$('#msgerror').text('Se ha cancelado la operacion.');
				return false;
    		}else  {
    			$('#msload').modal('show');
				$('#alert').hide();
			}

    		
    		$http({
    			method: 'GET',
    			url: '/CuadrillasWEB/EliminarHerramienta',
    			params: {
    			"idHerramienta" : datosHerramienta.idHerramienta,
    			"usuario" : data.data.usuario.usuario
    			}
		    }).then(function mySucces(response) {
				$('#success').show();
				$('#msgaviso').text(response.data.mensajeFuncional);
				$scope.consultaHerramientas();
				$('#msload').modal('hide');
		    	 console.info(response);
		    }, function myError(response) {
		    	$('#msload').modal('hide');
		    	 console.error(response);
				$('#alert').show();
				$('#msgerror').text(response.data.mensajeFuncional);
		    });
    	};			

		//Edita la herramienta
    	$scope.editarHerramienta = function(datosHerramienta) {
    		//console.log(datosHerramienta);
    		$scope.herramientas={};
			$scope.herramientas = datosHerramienta;
			
			$('#txtNumeroHerramienta').val(datosHerramienta.idHerramienta);
			//$('#nombre').val(datosCuadrilla.nombreCuadrilla);
			//$('#calificacion').val(datosCuadrilla.calificacion);
	    };
	    
	    //funcion para validar que se hayan llenado todos los campos
	    $scope.validaCampos= function(herramientas)
	    {
	    	var error = false;
	    	var cadena = "Favor de verificar: ";
	    	
			if (herramientas.nombre == "")
			{
				cadena = "El nombre.";
				error=true;
			}
			
			if (herramientas.descripcion == "" || herramientas.descripcion == undefined ||herramientas.descripcion == 'undefined')
			{
				cadena = "La descripción.";
				error=true;
			}			
			
			if ($('#txtDescripcion').val().length < 50)
			{
				cadena = "La descripción debe contener al menos 50 caracteres." ;
				error=true;
			}			
			
			if (herramientas.codigoEstatus == "" || herramientas.codigoEstatus == undefined ||herramientas.codigoEstatus == 'undefined')
			{
				cadena = "El estatus." ;
				error=true;
			}			
			
			if (herramientas.codigoTipo == "" || herramientas.codigoTipo == undefined ||herramientas.codigoTipo == 'undefined')
			{
				cadena = "El tipo.";
				error=true;
			}
			
			if (herramientas.marca == "" || herramientas.marca == undefined ||herramientas.marca == 'undefined')
			{
				cadena = "La marca.";
				error=true;
			}
			
			if (herramientas.modelo == "" || herramientas.modelo == undefined ||herramientas.modelo == 'undefined')
			{
				cadena = "El modelo.";
				error=true;
			}
			
			if (herramientas.noSerie == "" || herramientas.noSerie == undefined ||herramientas.noSerie == 'undefined')
			{
				cadena = "El número de serie." ;
				error=true;
			}	
								
			$('#alert').show();
			$('#msgerror').text(cadena);
			return error;
	    }
	    
    });
    //FIN CATALOGO HERRMIENTAS