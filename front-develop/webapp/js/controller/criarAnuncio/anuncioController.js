app.controller('anuncioController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'anuncioService',function($scope, $location, $rootScope, $window, $localStorage, anuncioService){

	$scope.init = function() {
		$rootScope.showMenuUsuario = false;
		$rootScope.showRodape = true;
		$rootScope.telaLogin = false;
		
		if (!$localStorage.usuarioLogado) {
			$.snackbar({content: 'Faça login para poder cadastrar um anúncio.', style: "toast erro", timeout: 8000});
			$location.path('/login');
		} else {
		    if($rootScope.itemDoAnuncio){
		        $scope.count = 3;
		        $scope.anuncio = $rootScope.itemDoAnuncio;
		        $rootScope.itemDoAnuncio = false;
		        $window.scrollTo(0, 0);
		    }else{
		        $scope.count = 1;
		        $scope.rotaAtual = 'rotaAtual';
		        $scope.anuncio = {};
		    }

            $scope.anuncio.idPessoa = $localStorage.usuarioLogado.usuario.pessoa.id;
            $scope.anuncio.enderecoOrigem = {};
            $scope.anuncio.enderecoDestino = {};
            $scope.cepUsuarioLogado = $localStorage.usuarioLogado.usuario.pessoa.endereco.cep;
            $scope.idAtual = 'idAtual';
            $scope.idSubcategoria = "";
            $('.options input').attr('checked', false);
            $('.options input').attr('disabled',false);
    }
	};

	$scope.addSubcategoria = function(idSub, rota) {
		$scope.idSubcategoria = idSub;
		$rootScope.subcategoriaMesmaRota = idSub;
        $rootScope.rotaAtual = rota;
		if ($scope.idAtual==$scope.idSubcategoria) {
			$('.options input').attr('disabled', false);
			$scope.idAtual = 'idAtual';
			$scope.idSubcategoria = "";
		} else {
			$scope.idAtual = idSub;
			$('.options input').attr('disabled', true);
			$("#"+$scope.idAtual).attr('disabled', false);
		}
	};

	$scope.validaSeTemSubcategoriaEscolhida = function() {
		if (!$scope.idSubcategoria || $scope.idSubcategoria =="") {
			$.snackbar({content: 'Não selecionou subcategoria.', style: "toast erro"});
		} else {
	        $location.path($rootScope.rotaAtual);
		}
	};

	$scope.salvar = function () {
	    if($scope.anuncio.dataValidade>new Date()){
            anuncioService.salvar($rootScope.rotaAtual, $scope.anuncio, $rootScope.usuarioLogado.token )
                .success(function (data) {
                    $rootScope.itemDoAnuncio = false;
                    $.snackbar({content: 'Cadastro realizado com sucesso!', style: "toast sucesso"});
                    $location.path('/');
                    $window.scrollTo(0, 0);
                }).error(function (data) {
                    $.snackbar({content: 'Erro:' + data.message, style: "toast erro"});
                })
	    }else{
	        $.snackbar({content: 'Data de validade do anúncio inválida.', style: "toast erro"});
	    }

	};
	$scope.voltar = function(){
	    $location.path($rootScope.rotaAtual);
	}

	$scope.buscaCep = function(cep, tipoCep,idCep){

		cepNaoNulo = $scope.validarCampoObrigatorio('Cep', idCep);

		if (!cepNaoNulo)
			return;

		if (cep.length >= 8) {
            anuncioService.buscaCep(cep).success(function(data){

            	if (data.resultado_txt == "sucesso - cep não encontrado") {
            		$.snackbar({content: 'CEP não encontrado.', style: "toast erro"});
            		return;
            	}

            	if(tipoCep == 'origem') {
            		$scope.anuncio.enderecoOrigem.endereco = data.tipo_logradouro +" "+ data.logradouro;
            		$scope.anuncio.enderecoOrigem.bairro = data.bairro;
            		$scope.anuncio.enderecoOrigem.cidade = data.cidade;
            		$scope.anuncio.enderecoOrigem.estado = data.uf;
            	}
				if(tipoCep == 'destino') {
            		$scope.anuncio.enderecoDestino.endereco = data.tipo_logradouro +" "+ data.logradouro;
            		$scope.anuncio.enderecoDestino.bairro = data.bairro;
            		$scope.anuncio.enderecoDestino.cidade = data.cidade;
            		$scope.anuncio.enderecoDestino.estado = data.uf;
            	}

            }).error(function(data,status){
            	$.snackbar({content: 'Não foi possível buscar o CEP, tente novamente.', style: "toast erro"});
            })
        }
        else
		$.snackbar({content: 'Campo CEP incorreto.', style: "toast erro"});
	};

	$scope.validarCampoObrigatorio = function(nomeCampo, campo) {
		var strCampo = $(campo).val();
		var campoValido = strCampo != null && strCampo != "";
		$scope.setarCampoErro(campo, campoValido, nomeCampo + " obrigatório.");
		return campoValido;
	};

	$scope.setarCampoErro = function(campo, campoValido, msgErro) {

		if (campoValido) {
			$(campo).removeClass('error');
		}
		else {
			$(campo).addClass('error');
			$.snackbar({content: 'Campo ' + msgErro, style: "toast erro"});
		}
	};

	$scope.adicionaProprioEndereco = function(tipoCep,idCep){
	  if(tipoCep == 'origem'){
			$scope.anuncio.enderecoOrigem.cep = $scope.cepUsuarioLogado;
			cep = $scope.anuncio.enderecoOrigem.cep;
	  }
	  if(tipoCep == 'destino'){
			$scope.anuncio.enderecoDestino.cep = $scope.cepUsuarioLogado;
			cep = $scope.anuncio.enderecoDestino.cep;
		}

			if(tipoCep == 'origem'){
				if($scope.checkEnderecoOrigem){
					//Tempo para dar o bind na variavel
					setTimeout(function(){
						$scope.buscaCep(cep, tipoCep,idCep);
					}, 500);
				}else {
					$scope.enderecoOrigem.cep = '';
					$scope.enderecoOrigem.endereco = '';
					$scope.enderecoOrigem.bairro = '';
					$scope.enderecoOrigem.cidade = '';
					$scope.enderecoOrigem.estado = '';
				}
			}
			if(tipoCep == 'destino'){
				if($scope.checkEnderecoDestino){
					//Tempo para dar o bind na variavel
					setTimeout(function(){
						$scope.buscaCep(cep, tipoCep,idCep);
					}, 500);
				}else {
					$scope.enderecoDestino.cep = '';
					$scope.enderecoDestino.endereco = '';
					$scope.enderecoDestino.bairro = '';
					$scope.enderecoDestino.cidade = '';
					$scope.enderecoDestino.estado = '';
				}
			}
	};


}])
