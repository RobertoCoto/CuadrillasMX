var app = angular.module('tatei', []);
app.controller('registraEmpleado', function ($scope, $http) {

	 $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCatalogo',
              params : {
		 		"tipoCatalogo": 'PERFIL_EMP'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultado = result.data.catalogo;
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
		 		"tipoCatalogo": 'ROPA_TALLA'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoRopa = result.data.catalogo;
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
		 		"tipoCatalogo": 'VIALIDAD'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoVialidad = result.data.catalogo;
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
		 		"tipoCatalogo": 'AREA_INC'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoArea = result.data.catalogo;
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
		 		"tipoCatalogo": 'DOCU_EMPLE'
		 },
              data: { }
		    }).then(function mySucces(result) {
		    	$scope.resultadoDocumentos = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
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


	   $scope.datoempleado = [];
	   
	   $scope.registrar = function(empleado) {
		   var documentoEmpleado = new Object();
		   documentoEmpleado.codigoDocumento = document.getElementById("documento").value;
		   documentoEmpleado.estatusDocumento = document.getElementById("estatusDocumento").value;
		   
		   var arrayProperties = new Array();
		   arrayProperties.push(documentoEmpleado);
		   
		   var objetoDocumento= new Object();
		   objetoDocumento.documentoEmpleado = arrayProperties;
		   
		   var jsonDocumento = JSON.stringify(objetoDocumento);
		   
		   $scope.json = jsonDocumento;
		   console.log($scope.json);
		   $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/RegistraEmpleado',
	              params: {
			 		"noEmpleado" : document.getElementById("noEmpleado").value,
			 		"nombre" : document.getElementById("nombre").value,
			 		"apellidoPaterno": document.getElementById("apellidoPaterno").value,
			 		"apellidoMaterno" : document.getElementById("apellidoMaterno").value,
			 		"sexo": document.getElementById("sexo").value,
	              "fechaNacimiento": document.getElementById("fechaNacimiento").value,
	              "fechaIngreso": document.getElementById("fechaIngreso").value,
	              "codigoPuesto": empleado.codigoPuesto,
	              "codigoVialidad": empleado.codigoVialidad,
	              "codigoArea": empleado.codigoArea,
	              "codigoTalla": empleado.codigoTalla,
	              "idCuadrilla": empleado.idCuadrilla,
	              "sueldo": document.getElementById("sueldo").value,
	              "frecuenciaPago": document.getElementById("frecuenciaPago").value,
	              "nss": document.getElementById("nss").value,
	              "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
	              "observaciones": document.getElementById("observaciones").value,
	              "usuario": 'SISTEMAS',
	              "documentoEmpleado" : $scope.json
			         }
			    }).then(function mySucces(response) {
			    	 console.info(response);
			    }, function myError(response) {
			        console.error(response);
			        alert(response.data.header.mensajeFuncional);
			    });
	   }
 
	 });
