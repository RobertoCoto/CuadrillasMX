var app = angular.module('tatei', []);
app.controller('autorizaActividad', function ($scope, $http, $window) {
	
		var map;
		var map2;
        var medida;
        var medida2;
       $scope.cargarMapa =  function initMap() {
            medida = {
                mvcLine: new google.maps.MVCArray(),
                mvcPolygon: new google.maps.MVCArray(),
                mvcMarkers: new google.maps.MVCArray(),
                line: null,
                polygon: null
            };
            var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
            map = new google.maps.Map(document.getElementById('map'), {
              zoom: 7,
              center: mx1
            });
            google.maps.event.addListener(map, 'click', function(event) {
              //console.log(event);
                setMarcador(event.latLng);
            });
          };
          
          $scope.cargarMapa2 =  function initMap2() {
            medida2 = {
                mvcLine: new google.maps.MVCArray(),
                mvcPolygon: new google.maps.MVCArray(),
                mvcMarkers: new google.maps.MVCArray(),
                line: null,
                polygon: null
            };
            var mx1 = {lat: 19.34751544463381, lng: -98.98272888210454};
            map2 = new google.maps.Map(document.getElementById('map2'), {
              zoom: 7,
              center: mx1
            });
            google.maps.event.addListener(map2, 'click', function(event) {
              //console.log(event);
                setMarcador(event.latLng);
            });
          };

            var markers = [];
      
      $scope.cargarMapa();
      $scope.cargarMapa2();
	});
