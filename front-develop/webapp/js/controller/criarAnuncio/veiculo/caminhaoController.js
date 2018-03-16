app.controller('caminhaoController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'caminhaoService',function($scope, $location, $rootScope, $window, $localStorage, caminhaoService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        if($scope.anuncio.noReboque=="true"){
            $scope.anuncio.noReboque = true;
        }else{
            $scope.anuncio.noReboque = false;
        }
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $location.path('/anuncio/criar-anuncio');
    };


}])