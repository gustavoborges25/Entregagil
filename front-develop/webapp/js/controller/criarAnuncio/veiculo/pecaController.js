app.controller('pecaController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'pecaService',function($scope, $location, $rootScope, $window, $localStorage, pecaService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])