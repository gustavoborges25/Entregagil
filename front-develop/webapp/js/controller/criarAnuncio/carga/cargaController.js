app.controller('cargaController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'cargaService',function($scope, $location, $rootScope, $window, $localStorage, cargaService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
        fotos = [];
        $scope.subcategoria = $rootScope.subcategoriaMesmaRota;
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $rootScope.itemDoAnuncio.fotos = fotos;
        $location.path('/anuncio/criar-anuncio');
    };


}])