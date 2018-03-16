app.controller('indexController', ['$scope', '$location', '$rootScope', '$localStorage','$route', '$interval', function($scope, $location, $rootScope, $localStorage, $route, $interval) {

    var opcoesBusca = ["Busque por...", "Título", "Anunciante", "Cidade ou UF"];
    var idxOpcaoBusca = 0;

    $rootScope.buscarAnuncios = function (queryBuscarAnuncios) {
        $rootScope.showMenuUsuario = false;
        $rootScope.showRodape = true;
        $rootScope.telaLogin = false;

        $location.path('/anuncios/buscar/' + queryBuscarAnuncios);
    };

    $interval(function () {
        $scope.placeholderBuscarAnuncios = opcoesBusca[idxOpcaoBusca];
        idxOpcaoBusca == opcoesBusca.length ? idxOpcaoBusca = 0 : idxOpcaoBusca++;
    }, 1000);

}])
