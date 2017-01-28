var app = angular.module('tatei', []);
app.controller('bajaEmpleado', function ($scope, $http) {
	//obtener el id enviado por GET
	   $scope.obtainGet = function getGET(){
		   var loc = document.location.href;
		   var getString = loc.split('?')[1];
		   var GET = getString.split('&');
		   var get = {};

		   for(var i = 0, l = GET.length; i < l; i++){
		      var tmp = GET[i].split('=');
		      get[tmp[0]] = unescape(decodeURI(tmp[1]));
		   }
		   return get;
		};
		$scope.get = $scope.obtainGet();
		
	$http({
        method: 'GET',
        url: 'http://localhost:8080/CuadrillasWEB/ConsultaEmpleado',
        params: {
	 		"idEmpleado" : $scope.get.idEmpleado
	         },
        data: { }
	    }).then(function (result) {
	    	$scope.resultado = result.data.empleado;
          console.log($scope.resultado);
	    }, function myError(response) {
	        console.error(response);
	        alert(response.data.header.mensajeFuncional);
	    });
   
	     $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'TIPO_SALID'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoSalida = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
	     
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'CAUSA_RENU'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoRenuncia = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
		    
		    $scope.grabar = function(empleado) {
		    	
    				
    			var confirmar = confirm("¿Esta seguro de dar de baja al empleado?"); 

				if (!confirmar) 
				{
					alert('se ha cancelado la operacion.'); 
					return false;
				} 		    


		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/BajaEmpleado',
		              params : {
				 		"usuario": 'SISTEMAS',
				 		"comentario": document.getElementById("comentario").value,
				 		"codigoTipoSalida": document.getElementById("salida").value,
				 		"codigoCausaSalida": document.getElementById("causaSalida").value,
		              "idEmpleado": document.getElementById("idEmpleado").value
				 }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    		   
		    	}
		    
});