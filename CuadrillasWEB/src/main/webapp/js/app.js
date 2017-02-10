var app = angular.module('tatei', ['ui.bootstrap', 'ui.router']);
var data;

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
                templateUrl : 'catalogo/index.html',
                controller  : 'catalogoctrl'
            })
             .when('/12', {
                templateUrl : 'usuario/cambio_contra.html',
                controller  : 'cambioDatos'
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
                templateUrl : 'catalogo/index.html',
                controller  : 'catalogoctrl'
            })
            .state('12', {
            	url: '/12',
            	templateUrl : 'usuario/cambio_contra.html',
            	controller  : 'cambioDatos'
            })
        	.state('13', {
        		url: '/13', 
                templateUrl : 'usuario/cambio_contra_gral.html',
                controller  : 'adminDatos'
        	})
            .state('20', {
            	url: '/20',
                templateUrl : 'empleado/index.html',
                controller  : 'registraEmpleado'
            })
            .state('30', {
            	url: '/30',
                templateUrl : 'cuadrillas/admin_cuadrillas.html',
                controller  : 'adminCuad'
            })
            .state('31', {
            	url: '/31',
                templateUrl : 'altaContrato/index.html',
                controller  : 'altacontratoctrl'
            })
            .state('32', {
            	url: '/32',
                templateUrl : 'registroAgenda/index.html',
                controller  : 'pendiente'
            })
            .state('33', {
            	url: '/33',
                templateUrl : 'consultaAgenda/index.html',
                controller  : 'pendiente'
            })
            .state('34', {
            	url: '/34',
                templateUrl : 'asistencia/index.html',
                controller  : 'entradaAsistencia'
            })
            .state('40', {
            	url: '/40',
                templateUrl : 'buzoncentral pendiente',
                controller  : 'pendiente'
            })
            .when('41', {
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
            });            
    });
 
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
				            $('contenedor').empty();
				            console.log("Scope Apply Done !!");
				          } 
				          else {
				            setTimeout(function() {
				            	$scope.$apply();
				            	$('contenedor').empty();
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
    

	app.controller('MainController', 
		function ($scope) {
	    	console.info(data.data.menu);
	    	console.info("usuario");
	    	console.info(data.data.usuario);
	    	$scope.usuario = data.data.usuario;
	    	$scope.items = data.data.menu;
	        $scope.default = $scope.items[0];
	        
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