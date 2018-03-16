app.controller('comercialController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'comercialService',function($scope, $location, $rootScope, $window, $localStorage, comercialService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])