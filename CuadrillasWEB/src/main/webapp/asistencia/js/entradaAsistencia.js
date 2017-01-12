app = angular.module('tatei', []);
app.controller('entradaAsistencia', function ($scope, $http) {  
	
	 $http.get("http://localhost:8080/CuadrillasWEB/ConsultaEmpleado?").success(function (dataSitio) {
	     $scope.items = dataSitio;
	    	
		      });

});