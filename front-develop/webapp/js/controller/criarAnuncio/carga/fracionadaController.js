app.controller('fracionadaController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'fracionadaService',function($scope, $location, $rootScope, $window, $localStorage, fracionadaService){

    $scope.init = function() {
        $scope.count = 2;
        fotos = [];
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $rootScope.itemDoAnuncio.fotos = fotos;
        $location.path('/anuncio/criar-anuncio');
    };


}])