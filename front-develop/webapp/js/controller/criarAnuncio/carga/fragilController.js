app.controller('fragilController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'fragilService',function($scope, $location, $rootScope, $window, $localStorage, fragilService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])