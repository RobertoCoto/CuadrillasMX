var app = angular.module('tatei', []);
app.controller('adminCuad', function ($scope, $http) {
	
 $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'VIALIDAD'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultado = result.data.catalogo;
	              console.log($scope.resultado);
		    }, function myError(response) {
		        //console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
 
		    $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCuadrilla',
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoCuadrilla = result.data.cuadrilla;
	             console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });
		    
		    $scope.registrar = function(cuadrilla) {
		    	 var confirmar = confirm("¿Esta seguro de registrar la cuadrilla?"); 

		    	 if (!confirmar) 
		    	 {
		    		 alert('se ha cancelado la operacion.'); 
		    		 return false;
		    	 } 	
		    
		    	var noCuadrilla = document.getElementById("numeroCuadrilla").value;
		    	var nombreCuadrilla = document.getElementById("nombre").value;
		    	$scope.vialidad = cuadrilla.vialidad;
		    	var calificacion = document.getElementById("calificacion").value;
		    	
     if(noCuadrilla == "") {
    	 return false
    	 }
     
    	 if(nombreCuadrilla == "") {
    	 return false
    	 }
    	 if($scope.vialidad == "") {
    	 return false
    	 }
    	 
    	 if(calificacion == "") {
    	 return false
    	 }
     
		    	 $http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AltaCuadrilla',
		              params: {
		    		 "idCuadrilla" : document.getElementById("numeroCuadrilla").value,
		    		 "nombreCuadrilla" : document.getElementById("nombre").value,
		    		 "vialidad": $scope.vialidad ,
		    		 "calificacion" : document.getElementById("calificacion").value,
		    		 "usuario" : "SISTEMAS"
		    		 
		    	 }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 location.reload();
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	};
		    	
		    $scope.editarCuadrilla = function(datosCuadrilla) {
		    	
		    	 $http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ConsultaColaborador',
		              params : {
				 		"idCuadrilla": datosCuadrilla.idCuadrilla
				 },
		              data: { }
				    }).then(function mySucces(result) {
				    	$scope.resultadoColaborador = result.data.empleado;
			               console.log($scope.resultadoColaborador);
				    }, function myError(response) {
				        //console.error(response);
				        alert(response.data.header.mensajeFuncional);
				        //$scope.resultado2.push(objecto);
				    });
		    	 
		    $scope.calif = datosCuadrilla.calificacion;
		    console.log("calidf "+ $scope.calif);
		    
		    			document.getElementById("numeroCuadrilla").value = datosCuadrilla.idCuadrilla;
		    			document.getElementById("nombre").value = datosCuadrilla.nombreCuadrilla;
		    			document.getElementById("calificacion").value = $scope.calif;
		    			
		    			 //validacion vialidad
		                 if(datosCuadrilla.codigoVialidad == "5MAY") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "1";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	     if(datosCuadrilla.codigoVialidad == "EJE6") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "2";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	     if(datosCuadrilla.codigoVialidad == "EJE7") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "3";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	     if(datosCuadrilla.codigoVialidad == "INSU") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "4";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	     if(datosCuadrilla.codigoVialidad == "UNIV") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "5";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	     if(datosCuadrilla.codigoVialidad == "ZARA") 
		       	    {
		       	    	console.log(datosCuadrilla.codigoVialidad);
		       	    	document.getElementById("vialidad").selectedIndex = "6";
		       	    	document.getElementById("dataVialidad").value = datosCuadrilla.codigoVialidad;
		       	    }
		       	    
		    			document.getElementById("numeroCuadrilla").disabled = true;
		    			document.getElementById('editar').style.display='none'; 
    	                document.getElementById('guardarDato').style.display='block';
    	                document.getElementById('colab').style.display='block';
		    	};
		    
		    $scope.actualizar = function(cuadrilla) {
		    	
		    var confirmar = confirm("¿Esta seguro de actualizar la cuadrilla?"); 

		    	 if (!confirmar) 
		    	 {
		    		 alert('se ha cancelado la operacion.'); 
		    		 return false;
		    	 } 	
		    	
		    	$scope.vialidad = document.getElementById("dataVialidad").value;
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ModificaCuadrilla',
		              params: {
		    		 "idCuadrilla" : document.getElementById("numeroCuadrilla").value,
		    		 "nombreCuadrilla" : document.getElementById("nombre").value,
		              "vialidad": $scope.vialidad,
		    		 "calificacion" : document.getElementById("calificacion").value,
		    		 "usuario" : "SISTEMAS"
		    		 
		    	 }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 location.reload();
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	};
		    	
		    	$scope.bajaCuadrilla = function(datosCuadrilla) {
		    		$scope.CuadrillaData = datosCuadrilla.idCuadrilla;
		    		var confirmar = confirm(" ¿Esta seguro de dar de baja la cuadrilla? "); 

		    		if (!confirmar) 
		    		{
		    			alert('se ha cancelado la operacion.'); 
						return false;
		    		}
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/BajaCuadrilla',
		              params: {
		    		 "idCuadrilla" : $scope.CuadrillaData,
		              "usuario" : "SISTEMAS"
		    	 }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 location.reload();
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	};
		    
		    });
