app.controller('anunciosPesquisaController', ['$scope', '$routeParams', 'anunciosPesquisaService', 'anuncioItemFotoService', function ($scope, $routeParams, anunciosPesquisaService, anuncioItemFotoService) {

    // Ao abrir a tela, pesquisa todos os anúncios válidos desta categoria
    if ($routeParams.categoria) {
        anunciosPesquisaService.getAnuncios($routeParams.categoria)
            .then(function (response) {
                    $scope.anuncios = response.data;

                    for (var i = 0; i < $scope.anuncios.length; i++) {
                        //$scope.carregaThumbnail($scope.anuncios[i]);
                    }
                },
                function (error) {
                    $.snackbar({content: error.data.message, style: "toast erro"});
                });
    } else {
        anunciosPesquisaService.getAnunciosByQuery($routeParams.query)
            .then(function (response) {
                    $scope.anuncios = response.data;

                    for (var i = 0; i < $scope.anuncios.length; i++) {
                        //$scope.carregaThumbnail($scope.anuncios[i]);
                    }
                },
                function (error) {
                    $.snackbar({content: error.data.message, style: "toast erro"});
                });
    }

    $scope.calculaValidadeAnuncio = function(anuncio) {
        var pedacosDaData = anuncio.dataValidade.split('-');
        var dataFinal = new Date(pedacosDaData[0], pedacosDaData[1] - 1, pedacosDaData[2]);
        var dataHoje = new Date();
        var diferencaEntreDatas = dataFinal.getTime() - dataHoje.getTime();
        var diasDeDiferenca = Math.ceil(diferencaEntreDatas / (1000 * 3600 * 24));
        return diasDeDiferenca;
    };

    $scope.carregaThumbnail = function(anuncio) {
        anuncioItemFotoService.getFotoMiniaturaDoAnuncio(anuncio.id)
            .then(function (response) {
                    anuncio.foto = response.data.foto;
                },
                function (error) {
                    $.snackbar({content: error.data.message, style: "toast erro"});
                });
    };

}])