app.controller('motoController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'motoService',function($scope, $location, $rootScope, $window, $localStorage, motoService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])
