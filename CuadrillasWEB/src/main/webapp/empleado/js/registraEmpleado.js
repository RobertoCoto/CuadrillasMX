var app = angular.module('tatei', ['ngSanitize']);
app.controller('registraEmpleado', function ($scope, $http, $window) {

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
		        alert(response.data.mensajeFuncional);
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

	  $scope.JSONDocumentation = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentos = [];

$('input[data-form=document]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 1 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentos.push( $Element );
	}
		
	
});

$scope.JSONDocumentation = JSON.stringify( { 'documentacion' : $scope.datosDocumentos } );
console.log($scope.JSONDocumentation);
 
});
	  


	   $scope.registrar = function(empleado) {
		   $scope.sueldo = document.getElementById("sueldo").value;
		   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
	   
 
 if ($scope.sueldo == "")
 {
	 $scope.sueldo = document.getElementById("sueldo").value = 0;
	 }
 
	 if ($scope.cuadrilla == "")
 {
	 $scope.cuadrilla = document.getElementById("cCuadrilla").value = 0;
	 }
 
 
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
	              "codigoPuesto": document.getElementById("cPuesto").value,
	              "codigoVialidad": document.getElementById("cVialidad").value,
	              "codigoArea": document.getElementById("cArea").value,
	              "codigoTalla": document.getElementById("cTalla").value,
	              "idCuadrilla": $scope.cuadrilla,
	              "telefono": document.getElementById("telefono").value,
	              "rfc" : document.getElementById("rfc").value,
	              "sueldo": $scope.sueldo,
	              "frecuenciaPago": document.getElementById("frecuenciaPago").value,
	              "nss": document.getElementById("nss").value,
	              "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
	              "observaciones": document.getElementById("observaciones").value,
	              "usuario": 'SISTEMAS',
	              "documentoEmpleado" : $scope.JSONDocumentation
			         }
			    }).then(function mySucces(response) {
			    	alert(response.data.mensajeFuncional);
			    	 console.info(response);
			    }, function myError(response) {
			        console.error(response);
			        alert(response.data.mensajeFuncional);
			    });
	   }
	   
	   $scope.consultar = function(empleado) {
		   $http({
               method: 'GET',
               url: 'http://localhost:8080/CuadrillasWEB/ConsultaGeneralEmpleado',
               
           }).success(function (result) {
               $scope.resultadoDatos = result.empleado;
               console.log($scope.resultadoDatos);
               $scope.editingData = {};

                for (var i = 0, length = $scope.resultadoDatos.length; i < length; i++) {
                  $scope.editingData[$scope.resultadoDatos[i].idEmpleado] = false;
                }
                });
		}
	   
		
      $scope.bajaEmpleado = function(general) {
    	    $scope.idE = general.idEmpleado;
    	     window.open('http://localhost:8080/CuadrillasWEB/empleado/baja_empleado.html?idEmpleado='+ $scope.idE, '_blank','heigth=600,width=600');
    	  };
    	  
      $scope.permisoEmpleado = function(general) {
    	  $scope.id = general.idEmpleado;
    	  window.open('http://localhost:8080/CuadrillasWEB/permiso/index.html?idEmpleado='+ $scope.id, '_blank','heigth=600,width=600');
    	  };
      
       $scope.editarDatos = function(general) {
    	   $scope.idEm = general.idEmpleado;
    	   
    	   $http({
               method: 'GET',
               url: 'http://localhost:8080/CuadrillasWEB/ConsultaDocumentos',
               params : {
 		 		"idEmpleado": $scope.idEm
 		 },
               data: { }
 		    }).then(function mySucces(result) {
 		    	$scope.resultadoDocumento = result.data.empleadoDocumento;
 	              console.log($scope.resultadoDocumento);
 		    }, function myError(response) {
 		        console.error(response);
 		        alert(response.data.mensajeFuncional);
 		        //$scope.resultado2.push(objecto);
 		    });
    	   
    	   document.getElementById("noEmpleado").value = general.noEmpleado;
    	   document.getElementById("nombre").value = general.nombre;
    	   document.getElementById("apellidoPaterno").value = general.apellidoPat;
    	   document.getElementById("apellidoMaterno").value = general.apellidoMat;
    	   document.getElementById("fechaNacimiento").value = general.fechaNacimiento;
    	   document.getElementById("nss").value = general.nss;
    	   document.getElementById("telefono").value = general.telefono;
    	   document.getElementById("rfc").value = general.rfc;
    	   document.getElementById("noCreditoInfonavit").value = general.noCreditoInfonavit;
    	   document.getElementById("sueldo").value = general.sueldo;
    	   
    	   //validacion del sexo
    	   if(general.sexo == "M")
    	   { 
    		   console.log(general.sexo);
    		   document.getElementById("sexo").selectedIndex = "1";
    		   
    		} else if(general.sexo == "F")
    	   {
    		   document.getElementById("sexo").selectedIndex = "2";
    		   }
    	   
    		   //validacion del puesto
    	   
    	    if(general.codigoPuesto == "AYGE") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "1";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    if(general.codigoPuesto == "CABO") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "2";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    if(general.codigoPuesto == "CHOF") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "3";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	     if(general.codigoPuesto == "MAQU") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "4";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    if(general.codigoPuesto == "OFCE") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "5";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    if(general.codigoPuesto == "PODA") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "6";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    if(general.codigoPuesto == "RESI") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "7";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    }
    	    
    		 //validacion de talla
         if(general.codigoTalla == "CHIC") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "1";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    }
    	   if(general.codigoTalla == "GRAN") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "2";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    }
    	    if(general.codigoTalla == "MEDI") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "3";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    }
    	    if(general.codigoTalla == "EXCH") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "4";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    }
    	    if(general.codigoTalla == "EXGR") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "5";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    }
    	    
    	    //validacion area
    	    if(general.codigoArea == "VERD") 
    	    {
    	    	console.log(general.codigoArea);
    	    	document.getElementById("codigoArea").selectedIndex = "1";
    	    	document.getElementById("cArea").value = general.codigoArea;
    	    }
    	    
    	    //validacion vialidad
              if(general.codigoVialidad == "5MAY") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "1";
    	    }
    	     if(general.codigoVialidad == "EJE6") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "2";
    	    }
    	     if(general.codigoVialidad == "EJE7") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "3";
    	    }
    	     if(general.codigoVialidad == "INSU") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "4";
    	    }
    	     if(general.codigoVialidad == "UNIV") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "5";
    	    }
    	     if(general.codigoVialidad == "ZARA") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "6";
    	    }
    	   
    	   document.getElementById('editar').style.display='none'; 
    	   document.getElementById('guardarDato').style.display='block'; 
    	   
    	   
    	   };
       
    	   $scope.actualizarDato = function(empleado) {
    		   $scope.sueldo = document.getElementById("sueldo").value;
    		   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
    	   
     
     if ($scope.sueldo == "")
     {
    	 $scope.sueldo = document.getElementById("sueldo").value = 0;
    	 }
     
	   $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ActualizaEmpleado',
              params: {
		        "idEmpleado": document.getElementById("idData").value,
              "noEmpleado" : document.getElementById("noEmpleado").value,
		 		"nombre" : document.getElementById("nombre").value,
		 		"apellidoPaterno": document.getElementById("apellidoPaterno").value,
		 		"apellidoMaterno" : document.getElementById("apellidoMaterno").value,
		 		"sexo": document.getElementById("sexo").value,
            "fechaNacimiento": document.getElementById("fechaNacimiento").value,
            "fechaIngreso": document.getElementById("fechaIngreso").value,
            "codigoPuesto": document.getElementById("cPuesto").value ,
            "codigoVialidad": document.getElementById("cVialidad").value = null,
            "codigoArea": document.getElementById("cArea").value,
            "codigoTalla": document.getElementById("cTalla").value,
            "idCuadrilla": document.getElementById("cCuadrilla").value = null,
              "telefono": document.getElementById("telefono").value,
            "rfc" : document.getElementById("rfc").value,
            "sueldo": $scope.sueldo,
            "frecuenciaPago": document.getElementById("frecuenciaPago").value,
            "nss": document.getElementById("nss").value,
            "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
            "observaciones": document.getElementById("observaciones").value,
            "usuario": 'SISTEMAS',
            "documentoEmpleado" : $scope.JSONDocumentation
		         }
		    }).then(function mySucces(response) {
		    	alert(response.data.mensajeFuncional);
		    	 console.info(response);
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		    });
    		   
    	   };
    	   
	 });
