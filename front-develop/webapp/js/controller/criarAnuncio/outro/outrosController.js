app.controller('outrosController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'outrosService',function($scope, $location, $rootScope, $window, $localStorage, outrosService){

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