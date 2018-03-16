app.controller('animalController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'animalService',function($scope, $location, $rootScope, $window, $localStorage, animalService){

    $scope.init = function() {
        $scope.count = 2;
        fotos = [];
        $window.scrollTo(0, 0);
    }

    $scope.salvarItem = function () {
        if($scope.anuncio.possuiCaixaTranporte=="true"){
            $scope.anuncio.possuiCaixaTranporte = true;
        }else{
            $scope.anuncio.possuiCaixaTranporte = false;
        }
        if($scope.anuncio.vacinacaoEmDia=="true"){
            $scope.anuncio.vacinacaoEmDia = true;
        }else{
            $scope.anuncio.vacinacaoEmDia = false;
        }
        if($scope.anuncio.possuiTodosRegistros=="true"){
            $scope.anuncio.possuiTodosRegistros = true;
        }else{
            $scope.anuncio.possuiTodosRegistros = false;
        }
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $rootScope.itemDoAnuncio.fotos = fotos;
        $location.path('/anuncio/criar-anuncio');
    };


}])
