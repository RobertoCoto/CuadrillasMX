var app = angular.module('tatei', []);

app.controller('validaUsuario',["$scope","$http", function ($scope,$http) {  
	
    
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
                        alert(response.data.header.mensajeFuncional);
                        document.getElementById("usuario").value="";
                        document.getElementById("clave").value="";
                  }, function myError(response) {
				        console.error(response);
				        alert(response.data.header.mensajeFuncional);
				    });
		    }
		    
}]);