app.controller('homeController', ['$rootScope', '$scope', 'anunciosPesquisaService', function($rootScope, $scope, anunciosPesquisaService){
	$rootScope.showMenuUsuario = false;
	$rootScope.showRodape = true;
	$rootScope.telaLogin = false;

	// Ao acessar a tela, recupera os últimos dez anúncios
	anunciosPesquisaService.getUltimosDezAnuncios()
		.then(function (response) {
				$scope.anuncios = response.data;
			},
			function (error) {
				$.snackbar({content: error.data.message, style: "alert alert-danger"});
			});

	// Para testes
	// $scope.anuncios = [
	// 	{
	// 		"titulo" : "Anúncio de teste 1",
	// 		"dataValidade" : "",
	// 		"enderecoOrigem" : {
	// 			"cidade" : "Maringá"
	// 		},
	// 		"enderecoDestino" : {
	// 			"cidade" : "Foz do Iguaçu"
	// 		}
	// 	},
	// 	{
	// 		"titulo" : "Anúncio de teste 2",
	// 		"dataValidade" : "",
	// 		"enderecoOrigem" : {
	// 			"cidade" : "Foz do Iguaçu"
	// 		},
	// 		"enderecoDestino" : {
	// 			"cidade" : "Maringá"
	// 		}
	// 	}
	// ];

	$scope.calculaValidadeAnuncio = function(anuncio) {
		var pedacosDaData = anuncio.dataValidade.split('-');
		var dataFinal = new Date(pedacosDaData[0], pedacosDaData[1] - 1, pedacosDaData[2]);
		var dataHoje = new Date();
		var diferencaEntreDatas = dataFinal.getTime() - dataHoje.getTime();
		var diasDeDiferenca = Math.ceil(diferencaEntreDatas / (1000 * 3600 * 24));
		return diasDeDiferenca;
	};

}])