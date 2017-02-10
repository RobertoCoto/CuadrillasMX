var app = angular.module('tatei', []);
app.controller('autorizacionLaboral', function ($scope, $http) {

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
        url: 'http://localhost:8080/CuadrillasWEB/ConsultaPermisoTemporal',
        params: {
	 		"idPermiso" : $scope.get.idPermiso
	         },
        data: { }
	    }).then(function (result) {
	    	$scope.resultado = result.data.permiso;
	    	
          console.log($scope.resultado);
        
	    }, function myError(response) {
	        console.error(response);
	        alert(response.data.mensajeFuncional);
	    });
	
	   
		     $scope.aceptar = function(permiso) {
		    	 
		     var coment = document.getElementById("comentario").value;
		    	if(coment === "") {
                	
                	return false;
                	}
		    	
                	var confirmar = confirm("¿Esta seguro de autorizar el permiso?"); 

		    		if (!confirmar) 
		    			{
		    				alert('se ha cancelado la operacion.'); 
		    					return false;
		    			} 	
		    	 
		    	 var checkSueldo = document.getElementById("goce");
		    	 
		    	 if(checkSueldo.checked == true) {
		    	       $scope.goce = "S";	 
		    	 } else if(checkSueldo.checked == false) {
		    		 $scope.goce = "N";
		    	 }
		    	 
		    	 
		    	 
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
		              params: {
				 		"idPermiso" : $scope.get.idPermiso,
				 		"comentario" : document.getElementById("comentario").value,
				 		"goceSueldo" : $scope.goce,
				 		"estatusAutorizacion": "S",
				 		"usuario": "SISTEMAS"
				         }
				    }).then(function mySucces(response) {
				    	 alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	
		    	}
		    
		     $scope.rechazar = function(permiso) {
		    	 var coment = document.getElementById("comentario").value;
		    	 if(coment === "") {
	                	
						return false;
						}
						
						var confirmar = confirm("¿Esta seguro de rechazar el permiso?"); 
						
						if (!confirmar) 
							{
								alert('se ha cancelado la operacion.'); 
									return false;
							} 	
				    	$http({
				              method: 'GET',
				              url: 'http://localhost:8080/CuadrillasWEB/AutorizacionPermiso',
				    	 params: {
					 		"idPermiso" : $scope.get.idPermiso,
					 		"comentario" : document.getElementById("comentario").value,
					 		"goceSueldo" : "N",
					 		"estatusAutorizacion": "N",
					 		"usuario": "SISTEMAS"
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
