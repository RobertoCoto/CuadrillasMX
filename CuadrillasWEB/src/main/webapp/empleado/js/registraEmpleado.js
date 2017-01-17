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

		
		
	  
	  var datosDocumentos = [];
	 
	   $scope.registrar = function(empleado) {
		   

$(document).ready(function(){

	$('input[type=submit]').click(function(){

		$('input[data-form=document]:checked').each(function(){
			var $Name  =  $(this).attr('name');
			var $Value =  $(this).val();
			datosDocumentos = { $Name : $Value };
			  
		});

	});

});
console.log(datosDocumentos);

		   var documentoEmpleado = new Object();
		   documentoEmpleado.codigoDocumento = document.getElementById("documento").value;
		   documentoEmpleado.estatusDocumento = document.getElementById("estatusDocumento").value;
		  
		   var arrayProperties = new Array();
		   arrayProperties.push(documentoEmpleado);
		   
		   var objetoDocumento= new Object();
		   objetoDocumento.documentoEmpleado = arrayProperties;
		   
		   var jsonDocumento = JSON.stringify(documentoEmpleado);
		   
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
	              "codigoPuesto": empleado.puesto,
	              "codigoVialidad": empleado.codigoVialidad,
	              "codigoArea": empleado.codigoArea,
	              "codigoTalla": empleado.codigoTalla,
	              "idCuadrilla": empleado.idCuadrilla,
	              "rfc" : document.getElementById("rfc").value,
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
	   
	   $scope.consultar = function(empleado) {
		   $http({
               method: 'GET',
               url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralEmpleado',
               
           }).success(function (result) {
               $scope.resultadoDatos = result.empleado;

               $scope.editingData = {};

                for (var i = 0, length = $scope.resultadoDatos.length; i < length; i++) {
                  $scope.editingData[$scope.resultadoDatos[i].idEmpleado] = false;
                }
                });
		}
	   
		
 
	 });
