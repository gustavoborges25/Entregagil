app.controller('barcoController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'barcoService',function($scope, $location, $rootScope, $window, $localStorage, barcoService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])