app.controller("avaliarUsuarioController", ["$scope", "$rootScope","avaliarUsuarioService","$routeParams","$localStorage","$location", function($scope, $rootScope, avaliarUsuarioService, $routeParams, $localStorage, $location){

	$scope.init = function(){
		// $rootScope.telaLogin = false;
		$rootScope.showRodape = false;
		$rootScope.showMenuUsuario = true;
		$rootScope.onMenu = 'home';

		if($routeParams.tipo == 'transportador'){
			$scope.avaliacaoAnunciante = new Object();
			$scope.avaliacaoTransportador = new Object();
			$scope.avaliacaoTransportador.idTransportador = $routeParams.id;
			$scope.avaliacaoTransportador.idAvaliador = $localStorage.usuarioLogado.usuario.pessoa.id;
			$scope.tipoTransportador = true;
			$scope.tipoAnunciante = false;
		}
		if($routeParams.tipo == 'anunciante'){
			$scope.avaliacaoTransportador = new Object();
			$scope.avaliacaoAnunciante = new Object();
			$scope.avaliacaoAnunciante.idAnunciante = $routeParams.id;
			$scope.avaliacaoAnunciante.idAvaliador = $localStorage.usuarioLogado.usuario.pessoa.id;
			$scope.tipoTransportador = false;
			$scope.tipoAnunciante = true;
		}

		$scope.buscaUsuario();
	}

	$scope.buscaUsuario = function(){
		avaliarUsuarioService.buscaUsuario($routeParams.id).then(function(response){
			$scope.usuarioBuscado = response.data;
		}, function(error){
			$.snackbar({content: error.message, style: "alert alert-danger"});
		});
	}

	$scope.avaliaAnunciante = function(){
		avaliarUsuarioService.avaliarAnunciante($scope.avaliacaoAnunciante).then(function(){
			$.snackbar({content: "Avaliado com sucesso!", style: "alert alert-success"});
			$location.path('/homeUsuario');
		}, function(error){
            $.snackbar({content: error.message, style: "alert alert-danger"});
        });
	}

	$scope.avaliaTransportador = function(){
		avaliarUsuarioService.avaliarTransportador($scope.avaliacaoTransportador).then(function(){
			$.snackbar({content: "Avaliado com sucesso!", style: "alert alert-success"});
			$location.path('/homeUsuario');
		}, function(error){
			$.snackbar({content: error.message, style: "alert alert-danger"});
		})
	}

	$scope.adcAvaliacao = function(qtde){
		$scope.avaliacaoAnunciante.avaliacaoGeral = qtde;
		$scope.avaliacaoTransportador.avaliacaoGeral = qtde;
	}

	$scope.adcTempoEntrega = function(value){
		if(value < 2){
			$scope.avaliacaoTransportador.tempoDeEntrega = 10;
		}
		if(value == 2 || value == 3  ){
			$scope.avaliacaoTransportador.tempoDeEntrega = 20;
		}
		if(value == 4 || value == 5  ){
			$scope.avaliacaoTransportador.tempoDeEntrega = 30;
		}
		if(value == 6 || value == 7  ){
			$scope.avaliacaoTransportador.tempoDeEntrega = 40;
		}
		if(value >= 8 ){
			$scope.avaliacaoTransportador.tempoDeEntrega = 50;
		}
	}



	$scope.adcIntegridadeEntrega = function(value){
		if(value < 2){
			$scope.avaliacaoTransportador.integridadeMercadoria = 10;
		}
		if(value == 2 || value == 3  ){
			$scope.avaliacaoTransportador.integridadeMercadoria = 20;
		}
		if(value == 4 || value == 5  ){
			$scope.avaliacaoTransportador.integridadeMercadoria = 30;
		}
		if(value == 6 || value == 7  ){
			$scope.avaliacaoTransportador.integridadeMercadoria = 40;
		}
		if(value >= 8 ){
			$scope.avaliacaoTransportador.integridadeMercadoria = 50;
		}
	}
}]);
