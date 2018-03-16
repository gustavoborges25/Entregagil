app.controller('acessarPerfilController', ['$scope', '$rootScope', '$location', '$localStorage', '$routeParams', 'acessarPerfilService', function ($scope, $rootScope, $location, $localStorage, $routeParams, acessarPerfilService) {

	$scope.init = function () {
		$rootScope.showMenuUsuario = false;
		$rootScope.showRodape = true;
		$rootScope.telaLogin = false;

		$scope.tab = 1;

		acessarPerfilService.buscaUsuario($routeParams.id).then(function (response) {
			$scope.usuarioBuscado = response.data;
			$scope.buscaQtdAnuncios();
			$scope.buscaAvaliacoesComoAnunciante();
			$scope.buscaAvaliacoesComoTransportador();
			$scope.mediaAvaliacoesAnunciante();
			$scope.mediaAvaliacoesTransportador();
			$scope.buscaTransportesRealizados();
			$scope.porcentagemPessoasRecomendamTransportador();
			$scope.mediaTempoEntrega();
			$scope.mediaIntegridadeMercadoria();
		}, function (error) {
			$.snackbar({content: error.data.message, style: "toast erro"});
		});
	};

	$scope.denunciar = function () {
		//ira chamar o controler para denunciar
	};

	$scope.buscaQtdAnuncios = function () {
		acessarPerfilService.buscaQtdAnuncios($routeParams.id).then(function (response) {
			$scope.qtdAnuncios = response.data;
		}, function (error) {
			$.snackbar({content: error.data.message, style: "toast erro"});
		});
	};

	$scope.buscaAvaliacoesComoAnunciante = function () {
		acessarPerfilService.buscaAvaliacoesComoAnunciante($routeParams.id).then(function (response) {
			$scope.avaliacoesComoAnunciante = response.data;
			console.log($scope.avaliacoesComoAnunciante);
			$scope.avaliacoesComoAnunciante.quantidade = $scope.avaliacoesComoAnunciante.length;
		}, function (error) {
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	};

	$scope.mediaAvaliacoesAnunciante = function () {
		acessarPerfilService.mediaAvaliacoesAnunciante($routeParams.id).then(function (response) {
			var temp = response.data;
			$scope.mediaAnunciante = Math.round(temp);
		}, function (error) {
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	};
	$scope.mediaAvaliacoesTransportador = function () {
		acessarPerfilService.mediaAvaliacoesTransportador($routeParams.id).then(function (response) {
			var temp = response.data;
			$scope.mediaTransportador = Math.round(temp);
		}, function (error) {
			$.snackbar({content: error.data.message, style: "toast erro"});
		});
	};

	$scope.buscaAvaliacoesComoTransportador = function () {
		acessarPerfilService.buscaAvaliacoesComoTransportador($routeParams.id).then(function (response) {
			$scope.avaliacoesComoTransportador = response.data;
			$scope.avaliacoesComoTransportador.quantidade = $scope.avaliacoesComoTransportador.length;
		}, function (error) {
			$.snackbar({content: error.data.message, style: "toast erro"});
		});
	};

	$scope.buscaTransportesRealizados = function() {
		acessarPerfilService.buscaTransportesRealizados($routeParams.id).then(function (response) {
			$scope.transportesRealizados = response.data;
		}, function (error) {
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	}

	$scope.porcentagemPessoasRecomendamTransportador = function(){
		acessarPerfilService.porcentagemPessoasRecomendamTransportador($routeParams.id).then(function (response) {
			$scope.porcentagemTransportador = response.data;
		}, function (error) {
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	}

	$scope.mediaTempoEntrega = function(){
		acessarPerfilService.mediaTempoEntrega($routeParams.id).then(function(response){
			$scope.valorMediaTempoEntrega = response.data / 10;
			$scope.valorMediaTempoEntrega = Math.round($scope.valorMediaTempoEntrega) * 10;
		}, function (error){
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	}

	$scope.mediaIntegridadeMercadoria = function(){
		acessarPerfilService.mediaIntegridadeMercadoria($routeParams.id).then(function(response){
			$scope.valorMediaIntegridadeMercadoria = response.data / 10;
			$scope.valorMediaIntegridadeMercadoria = Math.round($scope.valorMediaIntegridadeMercadoria) * 10;
		}, function (error){
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	}


}])
