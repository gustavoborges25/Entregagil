app.controller('anuncioDetalheController', ['$scope', '$rootScope', '$location','$localStorage','$routeParams','anuncioDetalheService', function($scope, $rootScope, $location, $localStorage, $routeParams, anuncioDetalheService){

 	$scope.init = function(){

 		$scope.usuario = $localStorage.usuarioLogado.usuario;
 		$rootScope.showMenuUsuario = false;
 		$rootScope.showRodape = true;
 		$scope.imagemSelecionada = {};
 		$scope.itemAnuncio = {};
 		$scope.idAnuncio = $routeParams.idAnuncio;
 		$scope.anuncio = {};
 		$scope.listaDeLances = {};
 		$scope.lance = {};
 		$scope.itemAnuncio = [];	
 		$scope.distancia = {};
 		$scope.mensagem = {};
 		$scope.funcOk = {};
 		$scope.pergunta = {};
 		$scope.listaDePerguntas = [];
 		$scope.fotoSelecionada = {};

 		anuncioDetalheService.buscaDadosDoAnuncio($scope.idAnuncio).success(function(data){
 			$scope.anuncio = data;
 			$scope.anuncioFotosItensCommand = data.fotos;
			$scope.itemAnuncio = data.item;

			$scope.fotoSelecionada = data.fotos[0];
			enderecoOrigem = $scope.anuncio.enderecoOrigem.endereco + "," + $scope.anuncio.enderecoOrigem.cidade;
 			enderecoDestino = $scope.anuncio.enderecoDestino.endereco + "," + $scope.anuncio.enderecoDestino.cidade;	

 			$scope.renderizarMapa();

 			anuncioDetalheService.buscaPerguntas($scope.idAnuncio, $localStorage.usuarioLogado.token).success(function(data){
 				$scope.listaDePerguntas = data;
 			}).error(function(data){
 				$.snackbar({content: "Não foi possível buscar as perguntas.", style: "alert alert-danger"});
 			})

 		}).error(function(data){
 			// location('/');
 			$.snackbar({content: "Não foi possível encontrar o anúncio.", style: "alert alert-danger"});

 		})

 		$scope.listaDeLances = anuncioDetalheService.buscaLancesdoAnuncio($scope.idAnuncio, $localStorage.usuarioLogado.token).success(function(data){
 			$scope.listaDeLances = data;

 		}).error(function(data){
 			
 		})
 	}

 	$scope.efetuarLance = function() {
 		$scope.lance.idAnuncio = $scope.idAnuncio;
 		console.log($scope.lance.idAnuncio);
 		$scope.lance.idTransportador = $scope.usuario.pessoa.id;

 		anuncioDetalheService.efetuarLance($scope.lance, $localStorage.usuarioLogado.token).success(function(data){ 
			$scope.listaDeLances = data;
 			angular.element(document.querySelector('#modalDarLance')).modal('hide');
 			$scope.lance = {};

 			$.snackbar({content: "Lance efetuado com sucesso.", style: "alert alert-sucess"});

 		}).error(function(data){
 			$.snackbar({content: "Não foi possível efetuar o lance., " + data, style: "alert alert-danger"});
 		})
 	}

 	$scope.ok = function() {
 		$scope.funcOk.func();
 		angular.element(document.querySelector('#modalAviso')).modal('hide');
 	}

 	$scope.cancelar = function() {
		angular.element(document.querySelector('#modalAviso')).modal('hide');
 	}

 	$scope.aceitarLance = function(lanceAceito) {
 		$scope.mensagem = "Deseja realmente aceitar esse lance?";

 		var aceitarLanceCommand = {};
 		aceitarLanceCommand.idLance = lanceAceito.id;
 		aceitarLanceCommand.idPessoa = $scope.usuario.pessoa.id;

 		//chamar rota do back
 		$scope.funcOk.func = function() { 
 			anuncioDetalheService.aceitarLance(aceitarLanceCommand, $localStorage.usuarioLogado.token).success(function(data){ 
			$.snackbar({content: "Lance aceito com sucesso!, " + data, style: "alert alert-sucess"});			

	 		}).error(function(data){
	 			$.snackbar({content: "Não foi possível efetuar o lance, " + data, style: "alert alert-danger"});
	 		})
 		}
 	}

 	$scope.cancelarLance = function(lanceCancelado, index) {

 		$scope.mensagem = "Deseja realmente cancelar esse lance?"
 		var cancelarLanceCommand = {};
 		cancelarLanceCommand.idLance = lanceCancelado.id;
 		cancelarLanceCommand.idPessoa = $scope.usuario.pessoa.id;

 		$scope.funcOk.func = function(){
	 		anuncioDetalheService.cancelarLance(cancelarLanceCommand, $localStorage.usuarioLogado.token).success(function(data){ 
				$.snackbar({content: "Lance cancelado com sucesso!, " + data, style: "alert alert-sucess"});			

	 		}).error(function(data){
	 			$.snackbar({content: "Não foi possível efetuar o lance, " + data, style: "alert alert-danger"});
	 		})

 			$scope.listaDeLances.splice(index, 1);
 		}
 	}

 	$scope.abrirFormLance = function(lance) {
 		$scope.lance = lance;
 		
 		habilitarDesabilitarCamposFormLance(true);
 	}


 	function habilitarDesabilitarCamposFormLance(disabled){
 		document.getElementById('valor').disabled = disabled;
 		document.getElementById('estimativa').disabled = disabled;
 		document.getElementById('observacoes').disabled = disabled;
 		document.getElementById('cargaFracionada').disabled = disabled;
 		document.getElementById('efetuarLance').disabled = disabled;
 	}

 	$scope.perguntar = function(){

 		$scope.pergunta.idAnuncio = $scope.idAnuncio;
 		$scope.pergunta.idPessoa = $scope.anuncio.anunciante.id;

 		anuncioDetalheService.perguntar($scope.pergunta, $localStorage.usuarioLogado.token).success(function(data){ 
			$.snackbar({content: "Pergunta feita com sucesso!", style: "alert alert-sucess"});	

			$scope.pergunta = {};
			$scope.listaDePerguntas = data; 				

	 	}).error(function(data){
	 		$.snackbar({content: "Não foi possível efetuar o lance., " + data, style: "alert alert-danger"});
	 	})
 	}

 	$scope.replaceItem = function(item) {
 		var json = angular.toJson(item);
 		return json.replace('{"', "").replace('"}', "").replace('"', "").replace(':"', " : ");
 	}

 	$scope.renderizarMapa = function() {

 		var map;

		map = new google.maps.Map(document.getElementById("map"), mapOptions);
        var directionsService = new google.maps.DirectionsService();

        var options = {timeout: 10000, enableHighAccuracy: true};      

        var directionsDisplay = new google.maps.DirectionsRenderer();
        var request = {
            origin: enderecoOrigem,
            destination: enderecoDestino,
            travelMode: google.maps.DirectionsTravelMode.DRIVING
        };

        directionsService.route(request, function(response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
              $scope.distancia = distancia = response.routes[0].legs[0].distance.text;
              directionsDisplay.setDirections(response);
              directionsDisplay.setMap(map);
            }
        });
 	}

}]);