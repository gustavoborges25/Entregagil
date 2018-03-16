app.controller('agricolaController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'agricolaService',function($scope, $location, $rootScope, $window, $localStorage, agricolaService){

    $scope.init = function() {
        $scope.count = 2;
        fotos = [];
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        if($scope.anuncio.noReboque=="true"){
            $scope.anuncio.noReboque = true;
        }else{
            $scope.anuncio.noReboque = false;
        }
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $rootScope.itemDoAnuncio.fotos = fotos;
        $location.path('/anuncio/criar-anuncio');
    };


}])