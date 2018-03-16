app.controller('industrialController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'industrialService',function($scope, $location, $rootScope, $window, $localStorage, industrialService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])