app.controller('adminCuad', function ($scope, $http) {

	$('#success').hide();
	$('#alert').hide();
	$('#msload').modal('show');
	$('input[data-form=numeroCuadrilla]').keyup(function() {


var data = $(this).val();
var regx = /^[0-9]+$/;

if ( data === '' || data.match(regx) ){
	$('.amt_errorCuadrilla').fadeOut('slow');
}
else {
	$('.amt_errorCuadrilla')
		.text('No se permite letras o caracteres invalidos.')
		.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
		.fadeIn('fast');
}

});

$('input[data-form=nombreCuadrilla]').keyup(function() {


		var data = $(this).val();
		var regx = /^[A-z ������������]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorNombreCuadrilla').fadeOut('slow');
		}
		else {
			$('.amt_errorNombreCuadrilla')
				.text('no se permiten numeros o caracteres invalidos')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}

    });

    $('input[data-form=calificacionCuadrilla]').keyup(function() {


		var data = $(this).val();
		var regx = /^[0-9]+$/;

		if ( data === '' || data.match(regx) ){
			$('.amt_errorCalificacionCuadrilla').fadeOut('slow');
		}
		else {
			$('.amt_errorCalificacionCuadrilla')
				.text('No se permite letras o caracteres invalidos.')
				.css({'color':'#fff', 'background':'#990000', 'padding':'3px'})
				.fadeIn('fast');
		}

    });

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

				$scope.consultaCuadrilla = function() {
					$('#msload').modal('show');
			    $http({
	              method: 'GET',
	              url: 'http://localhost:8080/CuadrillasWEB/ConsultaCuadrilla',
	              data: { }
			    }).then(function mySucces(result) {
						$('#msload').modal('hide');
						$('#alert').hide();
						$('#success').hide();
			    	$scope.resultadoCuadrilla = result.data.cuadrilla;
		             console.log(result);
			    }, function myError(response) {
						$('#msload').modal('hide');
			        console.error(response);
							$('#alert').show();
							$('#msgerror').text(response.data.header.mensajeFuncional)
			        //alert(response.data.header.mensajeFuncional);
			        //$scope.resultado2.push(objecto);
			    });
				}

				$scope.consultaCuadrilla();

		    $scope.registrar = function(cuadrilla) {
		    	$scope.cuadrilla = {};
				$scope.cuadrilla.actualizar = true;
		    	var noCuadrilla = document.getElementById("numeroCuadrilla").value;
		    	var nombreCuadrilla = document.getElementById("nombre").value;
		    	$scope.vialidad = document.getElementById("vialidad").value;
		    	var calificacion = document.getElementById("calificacion").value;
     if(noCuadrilla == "") {
    	    $('.amt_errorCuadrilla')
			.text('Numero de la cuadrilla vacio.')
			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
			.fadeIn('fast');
    	 return false
    	 }
         if($scope.vialidad == "") {
    		 $('.amt_errorVialidad')
				.text('No se ha elegido una vialidad.')
				.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
				.fadeIn('fast');
    	 return false
    	 }
    	 if(nombreCuadrilla == "") {
    		 $('.amt_errorNombreCuadrilla')
 			.text('No ha ingresado un nombre.')
 			.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
 			.fadeIn('fast');
    	 return false
    	 }
    	 if(calificacion == "") {
    		 $('.amt_errorCalificacionCuadrilla')
				.text('No se ha elegido una calificaci�n.')
				.css({'color':'#fff', 'background':'#EAA001', 'padding':'3px'})
				.fadeIn('fast');
    	 return false
    	 }

		    	 var confirmar = confirm("�Esta seguro de registrar la cuadrilla?");

		    	 if (!confirmar)
		    	 {
		    		 alert('se ha cancelado la operacion.');
		    		 return false;
		    	 }

		    	 $http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/AltaCuadrilla',
		              params: {
		    		 "idCuadrilla" : document.getElementById("numeroCuadrilla").value,
		    		 "nombreCuadrilla" : document.getElementById("nombre").value,
		              "vialidad": cuadrilla.codigoVialidad,
		    		 "calificacion" : document.getElementById("calificacion").value,
		    		 "usuario" : data.data.usuario.usuario

		    	 }
				    }).then(function mySucces(response) {
				    	alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 
				    }, function myError(response) {
				        console.error(response);
				        alert(response.data.mensajeFuncional);
				    });
		    	};

					$scope.reset = function(form) {
						$scope.cuadrilla = {};
						$scope.cuadrilla.actualizar = false;
						$scope.cuadrilla.editar = false;
						$('#colab').hide();
						$scope.consultaCuadrilla();
					}

		    $scope.editarCuadrilla = function(datosCuadrilla) {
					console.log(datosCuadrilla);
					$scope.cuadrilla = datosCuadrilla;
					$scope.cuadrilla.actualizar = true;
					$scope.cuadrilla.editar = true;
					$('#colab').show();
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

		    	};

		    $scope.actualizar = function(cuadrilla) {
				console.log(cuadrilla);
				console.log(data.data.usuario.usuario);
		    var confirmar = confirm("¿Esta seguro de actualizar la cuadrilla?");

		    	 if (!confirmar)
		    	 {
						 $('#alert').show();
						 $('#msgerror').text('Se ha cancelado la operacion.');
		    		 //alert('se ha cancelado la operacion.');
		    		 return false;
		    	 } else {
						 $('#msload').modal('show');
						 $('#alert').hide();
					 }

		    	$scope.vialidad = document.getElementById("dataVialidad").value;
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/ModificaCuadrilla',
		              params: {
		    		 "idCuadrilla" : cuadrilla.idCuadrilla,
		    		 "nombreCuadrilla" : cuadrilla.nombreCuadrilla,
		         "vialidad": cuadrilla.codigoVialidad,
		    		 "calificacion" : cuadrilla.calificacion,
		    		 "usuario" : data.data.usuario.usuario

		    	 }
				    }).then(function mySucces(response) {
							$('#msload').modal('hide');
							$('#success').show();
							$('#msgaviso').text(response.data.mensajeFuncional);
				    	//alert(response.data.mensajeFuncional);
				    	 console.info(response);
				    	 //location.reload();
				    }, function myError(response) {
							$('#msload').modal('hide');
							$('#alert').show();
							$('#msgerror').text(response.data.mensajeFuncional);
				        console.error(response);
				        //alert(response.data.mensajeFuncional);
				    });
		    	};

					$scope.hideAlerts = function() {
						$('#alert').hide();
						$('#success').hide();
					}

		    	$scope.bajaCuadrilla = function(datosCuadrilla) {
		    		var confirmar = confirm(" �Esta seguro de dar de baja la cuadrilla? ");

		    		if (!confirmar)
		    		{
		    			//alert('se ha cancelado la operacion.');
							$('#alert').show();
 						  $('#msgerror').text('Se ha cancelado la operacion.');
						return false;
		    		}

		    		$scope.CuadrillaData = datosCuadrilla.idCuadrilla;
		    	$http({
		              method: 'GET',
		              url: 'http://localhost:8080/CuadrillasWEB/BajaCuadrilla',
		              params: {
		    		 "idCuadrilla" : $scope.CuadrillaData,
		              "usuario" : data.data.usuario.usuario
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
