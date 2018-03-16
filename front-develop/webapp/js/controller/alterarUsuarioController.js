app.controller('alterarUsuarioController', ['$scope', '$rootScope', '$location','$localStorage','alterarUsuarioService', function($scope, $rootScope, $location, $localStorage, alterarUsuarioService) {

	$scope.init = function () {
		$rootScope.telaLogin = false;
		$rootScope.showMenuUsuario = false;
		$rootScope.showRodape = true;

		if (!$localStorage.usuarioLogado) {
			$location.path('/');
		}

		$scope.pessoa = $localStorage.usuarioLogado.usuario.pessoa;	
		$scope.tipoForm = $scope.pessoa.tipoPessoa;
	}


	$scope.salvar = function () {
		$scope.pessoa.foto = $('#imgUsuario').prop('src');
		alterarUsuarioService.editar($localStorage.usuarioLogado.token, $scope.pessoa)
			.success(function (data) {
				$.snackbar({content: "Dados alterados com sucesso.", style: "toast sucesso"});
				$localStorage.usuarioLogado.usuario.pessoa = data;
				$location.path("/homeUsuario");
			}).error(function (data, status) {
			$.snackbar({content: "Erro ao alterar o usuário: " + data, style: "toast erro"});
		})
	}

	function mudaPropriedadeImagem() {
		document.getElementById("imgUsuario").src = $scope.pessoa.foto.replace("dataimage/jpegbase64", "data:image/jpeg;base64,");
    }


	$scope.buscaCep = function(cep){
		if (cep.length > 8) {

            alterarUsuarioService.buscaCep(cep).success(function(data){
            		
            	$scope.pessoa.endereco.endereco = data.tipo_logradouro +" "+ data.logradouro;
            	$scope.pessoa.endereco.bairro = data.bairro;
            	$scope.pessoa.endereco.cidade = data.cidade;
            	$scope.pessoa.endereco.estado = data.uf;


            }).error(function(data,status){
            	console.log(data);
            	console.log(status);
            })
            
        }
	}

	$scope.validarCampoObrigatorio = function(nomeCampo, campo) {
		var strCampo = $(campo).val();
		var campoValido = strCampo != null && strCampo != "";
		setarCampoErro(campo, campoValido, nomeCampo + " obrigatório.");
		return campoValido;
	}

	function setarCampoErro(campo, campoValido, msgErro) {

		if (campoValido) {
			$(campo).removeClass('error');
		}
		else {
			$(campo).addClass('error');
			$.snackbar({content: 'Campo ' + msgErro, style: "toast erro"});
		}
	}

}])