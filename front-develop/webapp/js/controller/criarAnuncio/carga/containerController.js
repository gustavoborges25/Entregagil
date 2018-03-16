app.controller('containerController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'containerService',function($scope, $location, $rootScope, $window, $localStorage, containerService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])