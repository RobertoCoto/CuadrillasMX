var app = angular.module('tatei', ['ui.bootstrap', 'ui.router']);
var data;

 app.config(function($routeProvider) {
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
            .when('/cambioContrasena', {
                templateUrl : 'usuario/cambio_contra_gral.html',
                controller  : 'adminDatos'
            })            
            .otherwise({redirectTo : '/login'})

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
                        alert('hola');
                        $location.path('/menu');
                        $scope.$apply();                        
                        data = response;
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
				        $location.path('/menu');
				        if (!$scope.$$phase && !$scope.$root.$$phase) {
				            $scope.$apply();
				            console.log("Scope Apply Done !!");
				          } 
				          else {
				            setTimeout(function() {
				            	$scope.$apply();
				            }, 200);
				          }                        
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