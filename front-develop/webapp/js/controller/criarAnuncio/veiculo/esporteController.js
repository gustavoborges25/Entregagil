app.controller('esporteController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'esporteService',function($scope, $location, $rootScope, $window, $localStorage, esporteService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])