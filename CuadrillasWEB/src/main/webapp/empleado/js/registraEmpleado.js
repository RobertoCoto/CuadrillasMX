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
		    	$scope.resultadoCuadrilla = result.data.catalogo;
	              console.log(result);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.header.mensajeFuncional);
		        //$scope.resultado2.push(objecto);
		    });

$scope.empleado = {};
	   $scope.datoempleado = [];
	   
	   $scope.registrar = function(empleado) {
	   $scope.datoempleado.push(empleado);
	   console.log($scope.datoempleado);
	   $scope.nombre = empleado.nombre;
	   $scope.apellidoPaterno = empleado.apellidoPat;
	   $scope.apellidoMaterno = empleado.apellidoMat;
	   $scope.sexo = empleado.sexo;
	   $scope.rfc = empleado.rfc;
	   $scope.fechaNacimiento = empleado.fechaNacimiento;
	   $scope.fechaIngreso = empleado.fechaIngreso;
	   $scope.codigoPuesto = empleado.puesto;
	   $scope.codigoVialidad = "1";
	   $scope.codigoArea = empleado.codigoArea;
	   $scope.codigoTalla = empleado.codigoTalla;
	   $scope.idCuadrilla = empleado.idCuadrilla;
	   $scope.sueldo  = empleado.sueldo;
	   $scope.frecuenciaPago = empleado.tipoPago;
	   $scope.nss = empleado.nss;
	   $scope.telefono = empleado.telefono;
	   $scope.noCreditoInfonavit = empleado.infonavit;
	   $scope.observaciones = empleado.comentarios;
	   $scope.usuario = "SISTEMAS";
	   $scope.documentos = {"codigoDocumento": "ACNA" , "estatusDocumento" : "A"};
	   
	   $http.post("http://localhost:8080/CuadrillasWEB/RegistraEmpleado?" + "nombre=" + $scope.nombre +"&apellidoPat="+$scope.apellidoPaterno +"&apellidoMat="
		 +$scope.apellidoMaterno +"&sexo=" + $scope.sexo + "&rfc=" + $scope.rfc + "&fechaNacimiento=" + $scope.fechaNacimiento + "&fechaIngreso="
		 + $scope.fechaIngreso + "&codigoPuesto=" + $scope.codigoPuesto + "&codigoVialidad =" + $scope.codigoVialidad + "&codigoTalla=" + $scope.codigoTalla
		 + "&idCuadrilla=" +$scope.idCuadrilla + "&sueldo=" +$scope.sueldo +"&frecuenciaPago=" + $scope.frecuenciaPago + "&nss=" + $scope.nss 
		 + "&telefono=" + $scope.telefono + "&noCreditoInfonavit=" + $scope.noCreditoInfonavit + "&observaciones=" + $scope.observaciones + "&usuario=" + $scope.usuario + "&documentoEmpleado=" + $scope.documentos).success(function (dataSitio) {
	     $scope.items = dataSitio;
	    	
		      });
	   }
	   
	   
	 });
