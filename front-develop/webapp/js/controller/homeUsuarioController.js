
app.controller('homeUsuarioController', ['$rootScope', '$scope', 'homeUsuarioService', 'anuncioService', '$location', function($rootScope, $scope, homeUsuarioService, anuncioService, $location ){
	$rootScope.showMenuUsuario = true;
	$rootScope.showRodape = false;
	$rootScope.onMenu = 'home';
	$scope.usuario = $rootScope.usuarioLogado.usuario;

	$rootScope.mudaOnMenu = function($var){
		$rootScope.onMenu = $var;
	}

	// ROTAS

	$rootScope.listaLog = function(anuncio){
		homeUsuarioService.getLog($rootScope.usuarioLogado.token, anuncio.id).success(function(data){
			anuncio.logs = data;
			for(i = 0; i < anuncio.logs.length; i++){
				if (anuncio.logs[i].status == 'EM_TRANSPORTE') {
	            	anuncio.logs[i].classe = 'transporte';
	            	anuncio.logs[i].labelStatus = 'Em transporte';
	        	}
				if (anuncio.logs[i].status == 'ENTREGUE') {
            		anuncio.logs[i].classe = 'entregue';
            		anuncio.logs[i].labelStatus = 'Entregue';
		        }
		        if (anuncio.logs[i].status == 'CANCELADO') {
		            anuncio.logs[i].classe = 'cancelado';
		            anuncio.logs[i].labelStatus = 'Cancelado';
		        }
		        if (anuncio.logs[i].status == 'AGUARDANDO_LANCE') {
		            anuncio.logs[i].classe = 'aguardandoLance';
		            anuncio.logs[i].labelStatus = 'Aguardando lance';
		        }
				$rootScope.buscaLocal(anuncio.logs[i]);
			}
		}).error(function(data, status){
			$.snackbar({content: data.message, style: "toast erro"});
		});
	}

	$rootScope.init = function(){
		anuncioService.getAnuncio($rootScope.usuarioLogado.token, $rootScope.usuarioLogado.usuario.pessoa.id).success(function(data){
			$rootScope.anuncio = data;
			for(i = 0; i < $rootScope.anuncio.length; i++){
				$rootScope.listaLog($rootScope.anuncio[i]);
				$rootScope.buscaMenorLance($rootScope.anuncio[i]);
			}
		}).error(function(data){
			$.snackbar({content: data.message, style: "alert alert-danger"});
		});

		anuncioService.getTransporte($rootScope.usuarioLogado.token, $rootScope.usuarioLogado.usuario.pessoa.id).success(function(data){
			$rootScope.transporte = data;
			for(i = 0; i < $rootScope.transporte.length; i++){
				$rootScope.listaLog($rootScope.transporte[i]);
				$rootScope.buscaMenorLance($rootScope.transporte[i]);
			}
		}).error(function(data){
			$.snackbar({content: data.message, style: "toast erro"});
		});

		$scope.mediaAvaliacoesAnunciante();
		$scope.mediaAvaliacoesTransportador();

	}

	$rootScope.salvarLog = function(checkin){
		checkin.idAnuncio = $rootScope.idTransporte;
		homeUsuarioService.postCheckin(checkin, $rootScope.usuarioLogado.token).success(function(data){
			$.snackbar({content: 'Check-In efetuado com sucesso!', style: "alert alert-success"});
			$rootScope.init();
			document.getElementById('checkin').style.display = "none";
			model = document.getElementsByClassName('modal-backdrop');
			model[0].style.display = "none";
		}).error(function(data){
			$.snackbar({content: data.message, style: "alert alert-danger"});
		})
	}

	$rootScope.cancelarAnuncio = function(id){
		homeUsuarioService.deleteAnuncio(id, $rootScope.usuarioLogado.token).success(function(data){
			$.snackbar({content: 'Anúncio cancelado!', style: "alert alert-success"});
			$rootScope.init();
		}).error(function(data){
			$.snackbar({content: data.message, style: "alert alert-danger"});
		});
	}

	$rootScope.cancelarTransporte = function(id){
		homeUsuarioService.deleteTransporte(id, $rootScope.usuarioLogado.token).success(function(data){
			$.snackbar({content: 'Transporte cancelado!', style: "alert alert-success"});
			$rootScope.init();
		}).error(function(data){
			$.snackbar({content: data.message, style: "alert alert-danger"});
		});
	}


	// FUNÇÕES
	$scope.mediaAvaliacoesAnunciante = function () {
          homeUsuarioService.mediaAvaliacoesAnunciante($rootScope.usuarioLogado.usuario.pessoa.id).then(function (response) {
               $scope.mediaAnunciante = Math.round(response.data);
          }, function (error) {
               $.snackbar({content: error.data.message, style: "alert alert-danger"});
          });
     };
     $scope.mediaAvaliacoesTransportador = function () {
          homeUsuarioService.mediaAvaliacoesTransportador($rootScope.usuarioLogado.usuario.pessoa.id).then(function (response) {
               $scope.mediaTransportador = Math.round(response.data);
          }, function (error) {
               $.snackbar({content: error.data.message, style: "alert alert-danger"});
          });
     };

	$rootScope.buscaLocal = function(log){
		homeUsuarioService.getLocal(log.local).success(function(data){
			if (data.results[0] != null) {
				log.local = data.results[0].formatted_address;
			} else {
				log.local = '';
			}
		}).error(function(data, status){
			$.snackbar({content: error.data.message, style: "alert alert-danger"});
		});
	};

	$rootScope.buscaMenorLance = function(anuncio){
		homeUsuarioService.getMenorLance($rootScope.usuarioLogado.token, anuncio.id).success(function(data){
			anuncio.menorLance = data;
		}).error(function(data){
			$.snackbar({content: data.message, style: "alert alert-danger"});
		});
	};

  	$rootScope.ordenar = function(keyname){
        $rootScope.sortKey = keyname;
        $rootScope.reverse = !$scope.reverse;
    };

    $rootScope.inicializaCheckin = function(id){
    	$rootScope.checkin = {};
    	$rootScope.idTransporte = id;
    	if(navigator.geolocation){
			navigator.geolocation.getCurrentPosition(
			function(position){
				var localizacao = position.coords.latitude+','+position.coords.longitude;
				homeUsuarioService.getLocal(localizacao).success(function(data){
					$rootScope.localizacao = data.results[0].formatted_address;
					$rootScope.checkin.local = localizacao;
				}).error(function(data, status){
					$.snackbar({content: error.data.message, style: "alert alert-danger"});
				});
			},
			// if there was an error
			function(error){
				alert('ouch');
			});
		}
		// inicializa a hora atual
	    var dataHora = new Date();
	    $rootScope.checkin.hora = dataHora.getHours()+":"+dataHora.getMinutes()+" h";
	    // inicializa a data atual
	    $rootScope.checkin.data = dataHora;
	}
}])