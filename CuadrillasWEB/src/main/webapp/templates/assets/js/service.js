var app = angular.module('cuadrillas', ['ui.bootstrap', 'ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
    
    //$urlRouterProvider.otherwise('prueba.htm');
    
    $stateProvider

        .state('home', {
            url: '/home',
            templateUrl: 'prueba.html',
            controller: 'vistaController'
        })    
});

app.controller('MainController', 
    function ($scope) {
        $scope.items = [
                        {
                            name: "España",
                            desc: "España",
                            subitems: [
                            {
                                name: "Real Madrid",
                                url: "home"
                            },
                            {
                                name: "Barcelona",
                                url: ""
                            },
                            {
                                name: "Villarreal",
                                url: ""
                            }]
                    },
                    {
                        name: "Alemania",
                        desc: "Alemania",
                        subitems: [
                            {
                                name: "Leverkusen",
                                url: ""
                            },
                            {
                                name: "Bayern",
                                url: ""
                            },
                            {
                                name: "Hannover",
                                url: ""
                            }]
                    },
                    {
                        name: "Inglaterra",
                        desc: "Inglaterra",
                        subitems: [
                            {
                                name: "Manchester City",
                                url: ""
                            },
                            {
                                name: "Chelsea",
                                url: ""
                            },
                            {
                                name: "Arsenal",
                                url: ""
                            }]
                    }
                ];

        /*$scope.default = $scope.items[0];*/

        

    });

    app.controller('ItemController', ['$scope', function (scope) {
                scope.$parent.isopen = (scope.$parent.default === scope.item);

                scope.$watch('isopen', function (newvalue, oldvalue, scope) {
                    scope.$parent.isopen = newvalue;
                });

            }]);

    app.controller('vistaController', 
        function ($scope) {
            document.getElementById("contenedor").style.marginLeft = "260px";
        });