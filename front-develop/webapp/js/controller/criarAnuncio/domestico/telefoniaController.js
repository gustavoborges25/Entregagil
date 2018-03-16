app.controller('telefoniaController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'telefoniaService',function($scope, $location, $rootScope, $window, $localStorage, telefoniaService){

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
