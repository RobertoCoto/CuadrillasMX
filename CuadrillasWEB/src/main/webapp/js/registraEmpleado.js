 

app.controller('registraEmpleado', function ($scope, $http, $window) {
	
     //Fecha del sistema 
   var	hoy = new Date()
   var	dd = hoy.getDate()
	var mm = hoy.getMonth()+1 //hoy es 0!
   var  yyyy = hoy.getFullYear()
    
    if(dd<10) {
    dd='0'+dd
	} 

	if(mm<10) {
    mm='0'+mm
	} 

   hoy = yyyy+'-'+mm+'-'+dd;
   console.log(hoy);
   	document.getElementById("fechaIngreso").value = hoy;
   	
//validaciones
$('input[data-form=nEmpleado]').keyup(function() {

		var data = $(this).val();
		var regx = /^[A-Z0-9]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_err').fadeOut('slow');
		}
		else {
			$('.amt_err')
				.text('No se permite letras minusculas o caracteres invalidos.')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });

    $('input[data-form=nombreE]').keyup(function() {


		var data = $(this).val();
		var regx = /^[A-z ÁÉÍÓÚáéíóúÑñ]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_error').fadeOut('slow');
		}
		else {
			$('.amt_error')
				.text('no se permiten numeros o caracteres invalidos')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });
    
    $('input[data-form=apellidoP]').keyup(function() {


		var data = $(this).val();
		var regx = /^[A-z ÁÉÍÓÚáéíóúÑñ]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorApellidoP').fadeOut('slow');
		}
		else {
			$('.amt_errorApellidoP')
				.text('no se permiten numeros o caracteres invalidos')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });
    $('input[data-form=apellidoM]').keyup(function() {


var data = $(this).val();
var regx = /^[A-z ÁÉÍÓÚáéíóúÑñ]+$/;

if ( data === '' || data.match(regx) ){
	$('.amt_errorApellidoM').fadeOut('slow');
}
else {
	$('.amt_errorApellidoM')
		.text('no se permiten numeros o caracteres invalidos')
		.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
		.fadeIn('fast');
}

});
$('input[data-form=nss]').keyup(function() {


var data = $(this).val();
var regx = /^[0-9]+$/;

if ( data === '' || data.match(regx) ){
	$('.amt_errorNSS').fadeOut('slow');
}
else {
	$('.amt_errorNSS')
		.text('No se permite letras o caracteres invalidos.')
		.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
		.fadeIn('fast');
}

});
$('input[data-form=infonavit]').keyup(function() {


var data = $(this).val();
var regx = /^[0-9]+$/;

if ( data === '' || data.match(regx) ){
	$('.amt_errorInfonavit').fadeOut('slow');
}
else {
	$('.amt_errorInfonavit')
		.text('No se permite letras o caracteres invalidos.')
		.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
		.fadeIn('fast');
}

});

$('input[data-form=rfc]').keyup(function() {


		var data = $(this).val();
		var regx = /^[A-Z0-9]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorRFC').fadeOut('slow');
		}
		else {
			$('.amt_errorRFC')
				.text('No se permite letras minusculas o caracteres invalidos.')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });

 $('input[data-form=sueldo]').keyup(function() {


		var data = $(this).val();
		var regx = /^[0-9.]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorSueldo').fadeOut('slow');
		}
		else {
			$('.amt_errorSueldo')
				.text('No se permite letras o caracteres invalidos.')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });
 
  $('input[data-form=tel]').keyup(function() {


		var data = $(this).val();
		var regx = /^[0-9]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorTel').fadeOut('slow');
		}
		else {
			$('.amt_errorTel')
				.text('No se permite letras o caracteres invalidos.')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}
		
    });
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
		    	//documentos normal
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
 
});

// json docs no
	  $scope.JSONDocumentationNoDocs = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentosD = [];

$('input[data-form=document]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 3 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentosD.push( $Element );
	}
		
	
});

$scope.JSONDocumentationNoDocs = JSON.stringify( { 'documentacion' : $scope.datosDocumentosD } );

 
});

// json docs no
	  $scope.JSONDocumentationNaDocs = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentosDa = [];

$('input[data-form=document]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 2 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentosDa.push( $Element );
	}
		
	
});

$scope.JSONDocumentationNaDocs = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDa } );

 
});
	  
//value pago  
$scope.pagoValor = null;
$('input[type=submit]').on('click',function(){
			
$scope.datoPago = [];

$('input[data-form=Pagos]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
    $scope.datoPago.push($Value);
	
});
$scope.pagoValor = $scope.datoPago;
 
});

	   $scope.registrar = function(empleado) {
		   
			   
		   
		 	
			//se declaran variables 	
	       var noEmpleado = document.getElementById("noEmpleado").value;
	       var nombre = document.getElementById("nombre").value;
	       var apellidoPat = document.getElementById("apellidoPaterno").value;
	       var apellidoMat = document.getElementById("apellidoPaterno").value;
	       var puesto = document.getElementById("codigoPuesto").value;
	       var nacimiento = document.getElementById("fechaNacimiento").value;
	       var nss = document.getElementById("nss").value;
	       var infonavit = document.getElementById("noCreditoInfonavit").value;
	       var rfc = document.getElementById("rfc").value;
	       var telefono = document.getElementById("telefono").value;
	       var talla =  document.getElementById("cTalla").value;
	       var sexo = document.getElementById("sexo").value;
	       var area = document.getElementById("codigoArea").value;
	       var calif = document.getElementById("calificacion").value;
		   $scope.sueldo = document.getElementById("sueldo").value;
		   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
		   $scope.vialidad = document.getElementById("cVialidad").value;

		   //validaciones front
 if (noEmpleado == null) {
	 $('.amt_err')
		.text('Numero Empleado vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (nombre == null) {
	 $('.amt_error')
		.text('El nombre esta vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (apellidoPat == null) {
	 $('.amt_errorApellidoP')
		.text('El apellido paterno esta vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (apellidoMat == null) {
	 $('.amt_errorApellidoM')
		.text('El apellido materno esta vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (puesto == null) {
	 $('.amt_errorPuesto')
		.text('No se ha seleccionado un puesto.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (nacimiento == null) {
	 $('.amt_errorNacimiento')
		.text('No se ha seleccionado una fecha.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (nss == null) {
	 $('.amt_errorNSS')
		.text('Numero de seguro vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (infonavit == null) {
	 $('.amt_errorNSS')
		.text('Numero de seguro vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (rfc == null) {
	 $('.amt_errorRFC')
		.text('RFC vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (telefono == null) {
	 $('.amt_errorTel')
		.text('Telefono vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (talla == "") {
	 $('.amt_errorTalla')
		.text('No se ha seleccionado una talla.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (sexo == "") {
	 $('.amt_errorSexo')
		.text('No se ha seleccionado un sexo.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (area == "") {
	 $('.amt_errorArea')
		.text('No se ha seleccionado un Area.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if (calif == "") {
	 $('.amt_errorCalificacion')
		.text('Asigne una calificación.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if($scope.sueldo == 0) {
	 $('.amt_errorSueldo')
		.text('Sueldo vacio.')
		.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
		.fadeIn('fast');
	 return false;
	 }
 if ($scope.sueldo == "")
 {
	 $scope.sueldo = document.getElementById("sueldo").value = 0;
	 }
 
	 if ($scope.cuadrilla == "")
 {
	 $scope.cuadrilla = document.getElementById("cCuadrilla").value = 0;
	 }
 
	  if ($scope.vialidad == "")
 {
	 $scope.vialidad = document.getElementById("cVialidad").value = null;
	 }
 
	 var imss = document.getElementById("seguro");
		   
		   if(imss.checked == true) {
			   $scope.seguro = "S";
			   } else if(imss.checked == false) {
				   $scope.seguro = "N";
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
	              "codigoPuesto": document.getElementById("cPuesto").value,
	              "codigoVialidad": document.getElementById("cVialidad").value,
	              "codigoArea": document.getElementById("cArea").value,
	              "codigoTalla": document.getElementById("cTalla").value,
	              "idCuadrilla": $scope.cuadrilla,
	              "calificacion": document.getElementById("calificacion").value,
	              "telefono": document.getElementById("telefono").value,
	              "rfc" : document.getElementById("rfc").value,
	              "sueldo": $scope.sueldo,
	              "frecuenciaPago": $scope.pagoValor,
	              "nss": document.getElementById("nss").value,
	              "altaIMSS": $scope.seguro,
	              "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
	              "observaciones": document.getElementById("observaciones").value,
	              "usuario": 'SISTEMAS',
	              "documentoEmpleado" : $scope.JSONDocumentation,
	              "noDocs" : $scope.JSONDocumentationNoDocs,
	              "naDocs" :$scope.JSONDocumentationNaDocs
			         }
			    }).then(function mySucces(response) {
			    	alert(response.data.mensajeFuncional);
			    	 console.info(response);
			    	 setTimeout('document.form_reloj.reset()',2000);
		             return false;
			    }, function myError(response) {
			        console.error(response);
			        alert(response.data.mensajeFuncional);
			    });
		   
			    
	   };
	   
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
		};
	   
		
      $scope.bajaEmpleado = function(general) {
    	    $scope.idE = general.idEmpleado;
    	     window.open('http://localhost:8080/CuadrillasWEB/empleado/baja_empleado.html?idEmpleado='+ $scope.idE, '_blank','heigth=600,width=600');
    	  };
    	  
      $scope.permisoEmpleado = function(general) {
    	  $scope.id = general.idEmpleado;
    	  window.open('http://localhost:8080/CuadrillasWEB/permiso/index.html?idEmpleado='+ $scope.id, '_blank','heigth=600,width=600');
    	  };
    	  
    	  
      
       $scope.editarDatos = function(general, $rootScope) {
    	     
    	   $scope.idEm = general.idEmpleado;
    	   console.log("id del editar " + $scope.idEm);
    	   console.log("la calificacion shabo" + general.calificacion);
    	  
		   var codigo = null;
					$http({
					    method: 'GET',
					    url: 'http://localhost:8080/CuadrillasWEB/ConsultaDocumentos',
					    params : {
							"idEmpleado": $scope.idEm
					}
					  }).then(function mySucces(result) {
					  	$scope.resultadoDocumentoEmp = result.data.empleadoDocumento;

					  }, function myError(response) {
					      console.error(response);
					      alert(response.data.mensajeFuncional);
					      //$scope.resultado2.push(objecto);
					  });

             document.getElementById("idData").value= $scope.idEm;
             
            
    	   
    	    document.getElementById("noEmpleado").value = general.noEmpleado;
   	   document.getElementById("noEmpleado").disabled = false;
   	   document.getElementById("nombre").value = general.nombre;
   	   document.getElementById("nombre").disabled = false;
   	   document.getElementById("apellidoPaterno").value = general.apellidoPat;
   	   document.getElementById("apellidoPaterno").disabled= false;
   	   document.getElementById("apellidoMaterno").value = general.apellidoMat;
   	   document.getElementById("apellidoMaterno").disabled = false;
   	   document.getElementById("fechaNacimiento").value = general.fechaNacimiento;
   	   document.getElementById("fechaNacimiento").disabled = false;
   	   document.getElementById("apellidoMaterno").disabled = false;
   	   document.getElementById("nss").value = general.nss;
   	   document.getElementById("nss").disabled = false;
   	   document.getElementById("telefono").value = general.telefono;
   	   document.getElementById("telefono").disabled = false;
   	   document.getElementById("rfc").value = general.rfc;
   	   document.getElementById("rfc").disabled = false;
   	   document.getElementById("calificacion").value = general.calificacion;
   	   document.getElementById("calificacion").disabled = false;
   	   document.getElementById("noCreditoInfonavit").value = general.noCreditoInfonavit;
   	   document.getElementById("noCreditoInfonavit").disabled = false;
   	   document.getElementById("sueldo").value = general.sueldo;
   	   document.getElementById("sueldo").disabled = false;
   	  
   	   $scope.cuadri = general.idCuadrilla;
   	   
   	   if (typeof($scope.cuadri) === "undefined") {
   		  document.getElementById('idCuadrilla').value="";
      	   document.getElementById('idCuadrilla').disabled = false;
      	  document.getElementById("cCuadrilla").value = 0;
   		   } else {
   			document.getElementById('idCuadrilla').value="number:"+ $scope.cuadri;
   	   	   document.getElementById('idCuadrilla').disabled = false;
   	   	  document.getElementById("cCuadrilla").value = $scope.cuadri;
   			   }
   		   
   	        if(general.altaImss == "S") {
   	          document.getElementById("seguro").checked = true;
   	          document.getElementById("seguro").disabled = false;
   	        } else if(general.altaImss == "N") {
   	        	document.getElementById("seguro").checked = false;
   	        	document.getElementById("seguro").disabled = false;
   	        }
   	        
   	        
   	   
    	   //validacion del sexo
    	   if(general.sexo == "M")
    	   { 
    		   console.log(general.sexo);
    		   document.getElementById("sexo").selectedIndex = "1";
    		   document.getElementById('sexo').disabled = false;
    		   
    		} else if(general.sexo == "F")
    	   {
    		   document.getElementById("sexo").selectedIndex = "2";
    		   document.getElementById('sexo').disabled = false;
    		   }
    	   
    		   //validacion del puesto
    	   
    	    if(general.codigoPuesto == "AYGE") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "1";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    if(general.codigoPuesto == "CABO") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "2";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    if(general.codigoPuesto == "CHOF") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "3";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	     if(general.codigoPuesto == "MAQU") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "4";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    if(general.codigoPuesto == "OFCE") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "5"; 
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    if(general.codigoPuesto == "PODA") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "6";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    if(general.codigoPuesto == "RESI") 
    	    {
    	    	console.log(general.codigoPuesto);
    	    	document.getElementById("codigoPuesto").selectedIndex = "7";
    	    	document.getElementById("cPuesto").value = general.codigoPuesto;
    	    	document.getElementById("codigoPuesto").disabled = false;
    	    }
    	    
    		 //validacion de talla
         if(general.codigoTalla == "CHIC") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "1";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    	document.getElementById("codigoTalla").disabled = false;
    	    }
    	   if(general.codigoTalla == "GRAN") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "2";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    	document.getElementById("codigoTalla").disabled = false;
    	    }
    	    if(general.codigoTalla == "MEDI") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "3";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    	document.getElementById("codigoTalla").disabled = false;
    	    }
    	    if(general.codigoTalla == "EXCH") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "4";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    	document.getElementById("codigoTalla").disabled = false;
    	    }
    	    if(general.codigoTalla == "EXGR") 
    	    {
    	    	console.log(general.codigoTalla);
    	    	document.getElementById("codigoTalla").selectedIndex = "5";
    	    	document.getElementById("cTalla").value = general.codigoTalla;
    	    	document.getElementById("codigoTalla").disabled = false;
    	    }
    	    
    	    //validacion area
    	    if(general.codigoArea == "VERD") 
    	    {
    	    	console.log(general.codigoArea);
    	    	document.getElementById("codigoArea").selectedIndex = "1";
    	    	document.getElementById("cArea").value = general.codigoArea;
    	    	document.getElementById("codigoArea").disabled = false;
    	    }
    	    
    	    //validacion vialidad
              if(general.codigoVialidad == "5MAY") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "1";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	     if(general.codigoVialidad == "EJE6") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "2";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	     if(general.codigoVialidad == "EJE7") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "3";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	     if(general.codigoVialidad == "INSU") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "4";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	     if(general.codigoVialidad == "UNIV") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "5";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	     if(general.codigoVialidad == "ZARA") 
    	    {
    	    	console.log(general.codigoVialidad);
    	    	document.getElementById("codigoVialidad").selectedIndex = "6";
    	    	document.getElementById("codigoVialidad").disabled = false;
    	    	document.getElementById("cVialidad").value = general.codigoVialidad;
    	    }
    	   
    	   document.getElementById('editar').style.display='none'; 
    	  $("div[data-id=documentosData").hide();
    	  $("div[data-id=documentosResultado").show();
    	   document.getElementById('guardarDato').style.display='block'; 
    
    	   
    	  
    	   };
       
    	   

//documentos actualizar

	  $scope.JSONDocumentationUpdate = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentosUpdate = [];

$('input[data-form=documentData]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 1 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentosUpdate.push( $Element );
	}
		
	
});

$scope.JSONDocumentationUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosUpdate } );
 
});

// json docs no
	  $scope.JSONDocumentationNoDocsUpdate = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentosDUpdate = [];

$('input[data-form=documentData]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 3 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentosDUpdate.push( $Element );
	}
		
	
});

$scope.JSONDocumentationNoDocsUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDUpdate } );

 
});

// json docs no
	  $scope.JSONDocumentationNaDocsUpdate = null;
	  $('input[type=submit]').on('click',function(){
			
$scope.datosDocumentosDaUpdate = [];

$('input[data-form=documentData]:checked').each(function(){
	
    var $Name  =  $(this).attr('name');
	var $Value =  $(this).val();
	
	if( $Value == 2 )
	{
		var $Element = {};
		
		$Element = $Name;
		//$Element['estatusDocumento'] = 'A';
		$scope.datosDocumentosDaUpdate.push( $Element );
	}
		
	
});

$scope.JSONDocumentationNaDocsUpdate = JSON.stringify( { 'documentacion' : $scope.datosDocumentosDaUpdate } );
 
});
    	   $scope.actualizarDato = function() {
    		   $scope.idEm = document.getElementById("idData").value;
    		  
    		   $scope.sueldo = document.getElementById("sueldo").value;
    		   $scope.cuadrilla = document.getElementById("cCuadrilla").value;
    		   console.log("es la cuadrilla: "+ $scope.cuadrilla);
    	       
    	       $scope.vialidad =document.getElementById("cVialidad").value;
     
     if ($scope.sueldo == "")
     {
    	 $scope.sueldo = document.getElementById("sueldo").value = 0;
    	 }
     
      
	  if (typeof($scope.vialidad) === "undefined")
 {
	 $scope.vialidad = document.getElementById("cVialidad").value = null;
	 }
           var imss = document.getElementById("seguro");
		   
		   if(imss.checked == true) {
			   $scope.seguro = "S";
			   } else if(imss.checked == false) {
				   $scope.seguro = "N";
			   }    
	   $http({
              method: 'GET',
              url: 'http://localhost:8080/CuadrillasWEB/ActualizaEmpleado',
              params: {
		        "idEmpleado": $scope.idEm,
              "noEmpleado" : document.getElementById("noEmpleado").value,
		 		"nombre" : document.getElementById("nombre").value,
		 		"apellidoPaterno": document.getElementById("apellidoPaterno").value,
		 		"apellidoMaterno" : document.getElementById("apellidoMaterno").value,
		 	"sexo": document.getElementById("sexo").value,
            "fechaNacimiento": document.getElementById("fechaNacimiento").value,
            "fechaIngreso": document.getElementById("fechaIngreso").value,
            "codigoPuesto": document.getElementById("cPuesto").value ,
            "codigoVialidad": document.getElementById("cVialidad").value ,
            "codigoArea": document.getElementById("cArea").value,
            "codigoTalla": document.getElementById("cTalla").value,
            "idCuadrilla":  document.getElementById("cCuadrilla").value,
            "telefono": document.getElementById("telefono").value,
            "rfc" : document.getElementById("rfc").value,
            "sueldo": $scope.sueldo,
            "calificacion": document.getElementById("calificacion").value,
            "frecuenciaPago": $scope.pagoValor,
            "nss": document.getElementById("nss").value,
              "altaIMSS": $scope.seguro,
            "noCreditoInfonavit": document.getElementById("noCreditoInfonavit").value,
            "observaciones": document.getElementById("observaciones").value,
            "usuario": 'SISTEMAS',
              "documentoEmpleado" : $scope.JSONDocumentationUpdate,
              "noDocs" : $scope.JSONDocumentationNoDocsUpdate,
              "naDocs" :$scope.JSONDocumentationNaDocsUpdate
		         }
		    }).then(function mySucces(response) {
		    	alert(response.data.mensajeFuncional);
		    	 console.info(response);
//		    	  $("div[data-id=documentosResultado").hide();
//		    	  $("div[data-id=documentosData").show();
		    	 //setTimeout('document.form_reloj.reset()',2000);
		    	 location.reload();
	             return false;
		    }, function myError(response) {
		        console.error(response);
		        alert(response.data.mensajeFuncional);
		    });
    		  
		    
    	   };
    	   
    $scope.consultaEmpleado = function(general) {
    	  $scope.idEm = general.idEmpleado;
   	   
   	  
		   var codigo = null;
					$http({
					    method: 'GET',
					    url: 'http://localhost:8080/CuadrillasWEB/ConsultaDocumentos',
					    params : {
							"idEmpleado": $scope.idEm
					}
					  }).then(function mySucces(result) {
					  	$scope.resultadoDocumentoEmp = result.data.empleadoDocumento;

					  }, function myError(response) {
					      console.error(response);
					      alert(response.data.mensajeFuncional);
					      //$scope.resultado2.push(objecto);
					  });

            document.getElementById("idData").value= $scope.idEm;
            
           
   	   
   	   document.getElementById("noEmpleado").value = general.noEmpleado;
   	   document.getElementById("noEmpleado").disabled = true;
   	   document.getElementById("nombre").value = general.nombre;
   	   document.getElementById("nombre").disabled = true;
   	   document.getElementById("apellidoPaterno").value = general.apellidoPat;
   	   document.getElementById("apellidoPaterno").disabled= true;
   	   document.getElementById("apellidoMaterno").value = general.apellidoMat;
   	   document.getElementById("apellidoMaterno").disabled = true;
   	   document.getElementById("fechaNacimiento").value = general.fechaNacimiento;
   	   document.getElementById("fechaNacimiento").disabled = true;
   	   document.getElementById("apellidoMaterno").disabled = true;
   	   document.getElementById("nss").value = general.nss;
   	   document.getElementById("nss").disabled = true;
   	   document.getElementById("telefono").value = general.telefono;
   	   document.getElementById("telefono").disabled = true;
   	   document.getElementById("rfc").value = general.rfc;
   	   document.getElementById("rfc").disabled = true;
   	   document.getElementById("calificacion").value = general.calificacion;
   	   document.getElementById("calificacion").disabled = true;
   	   document.getElementById("noCreditoInfonavit").value = general.noCreditoInfonavit;
   	   document.getElementById("noCreditoInfonavit").disabled = true;
   	   document.getElementById("sueldo").value = general.sueldo;
   	   document.getElementById("sueldo").disabled = true;
   	   $scope.cuadri = general.idCuadrilla;
   	   document.getElementById('idCuadrilla').value="number:"+ $scope.cuadri;
   	   document.getElementById('idCuadrilla').disabled = true;
   	if(general.altaImss == "S") {
	          document.getElementById("seguro").checked = true;
	          document.getElementById("seguro").disabled = true;
	        } else if(general.altaImss == "N") {
	        	document.getElementById("seguro").checked = false;
	        	document.getElementById("seguro").disabled = true;
	        }
   	   //validacion del sexo
   	   if(general.sexo == "M")
   	   { 
   		   console.log(general.sexo);
   		   document.getElementById("sexo").selectedIndex = "1";
   		document.getElementById("sexo").disabled = true;
   		   
   		} else if(general.sexo == "F")
   	   {
   		   document.getElementById("sexo").selectedIndex = "2";
   		  document.getElementById("sexo").disabled = true;
   		   }
   	   
   		   //validacion del puesto
   	   
   	    if(general.codigoPuesto == "AYGE") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "1";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    if(general.codigoPuesto == "CABO") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "2";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    if(general.codigoPuesto == "CHOF") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "3";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	     if(general.codigoPuesto == "MAQU") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "4";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    if(general.codigoPuesto == "OFCE") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "5";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    if(general.codigoPuesto == "PODA") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "6";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    if(general.codigoPuesto == "RESI") 
   	    {
   	    	console.log(general.codigoPuesto);
   	    	document.getElementById("codigoPuesto").selectedIndex = "7";
   	    	document.getElementById("codigoPuesto").disabled = true;
   	    }
   	    
   		 //validacion de talla
        if(general.codigoTalla == "CHIC") 
   	    {
   	    	console.log(general.codigoTalla);
   	    	document.getElementById("codigoTalla").selectedIndex = "1";
   	    	document.getElementById("codigoTalla").disabled = true;
   	    }
   	   if(general.codigoTalla == "GRAN") 
   	    {
   	    	console.log(general.codigoTalla);
   	    	document.getElementById("codigoTalla").selectedIndex = "2";
   	    	document.getElementById("codigoTalla").disabled = true;
   	    }
   	    if(general.codigoTalla == "MEDI") 
   	    {
   	    	console.log(general.codigoTalla);
   	    	document.getElementById("codigoTalla").selectedIndex = "3";
   	    	document.getElementById("codigoTalla").disabled = true;
   	    }
   	    if(general.codigoTalla == "EXCH") 
   	    {
   	    	console.log(general.codigoTalla);
   	    	document.getElementById("codigoTalla").selectedIndex = "4";
   	    	document.getElementById("codigoTalla").disabled = true;
   	    }
   	    if(general.codigoTalla == "EXGR") 
   	    {
   	    	console.log(general.codigoTalla);
   	    	document.getElementById("codigoTalla").selectedIndex = "5";
   	    	document.getElementById("codigoTalla").disabled = true;
   	    }
   	    
   	    //validacion area
   	    if(general.codigoArea == "VERD") 
   	    {
   	    	console.log(general.codigoArea);
   	    	document.getElementById("codigoArea").selectedIndex = "1";
   	    	document.getElementById("codigoArea").disabled = true;
   	    }
   	    
   	    //validacion vialidad
             if(general.codigoVialidad == "5MAY") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "1";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	     if(general.codigoVialidad == "EJE6") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "2";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	     if(general.codigoVialidad == "EJE7") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "3";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	     if(general.codigoVialidad == "INSU") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "4";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	     if(general.codigoVialidad == "UNIV") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "5";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	     if(general.codigoVialidad == "ZARA") 
   	    {
   	    	console.log(general.codigoVialidad);
   	    	document.getElementById("codigoVialidad").selectedIndex = "6";
   	    	document.getElementById("codigoVialidad").disabled = true;
   	    }
   	   
   	   document.getElementById('editar').style.display='none'; 
   	  $("div[data-id=documentosData").hide();
   	  //$("div[data-id=documentosResultado").hide();
   	   document.getElementById('guardarDato').disabled = true; 
    	};
    
    	   
	 });
	    