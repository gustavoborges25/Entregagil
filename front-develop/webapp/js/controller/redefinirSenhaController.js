app.controller('redefinirSenhaController', ['$scope','$rootScope', 'redefinirSenhaService', '$location','$routeParams', function($scope, $rootScope, redefinirSenhaService, $location, $routeParams){
	$scope.init = function(){
		$rootScope.showMenuUsuario = false;
		$rootScope.telaLogin = false;
		$scope.usuario = {};
		if ($rootScope.usuarioLogado) {
      $scope.usuario = $rootScope.usuarioLogado.usuario;
   	}
		$scope.errorSenha = false;
		$scope.errorEmail = false;
	};
	//Ao inserir o e-mail para receber o link entra na função abaixo para testar se o e-mail existe
	$scope.testeEmail = function() {
		//encaminha para a rota do validaEmail no service e tras o retorno do back
		redefinirSenhaService.validaEmail($scope.usuario)
		.then(function (response) {
			// TO DO substituir abaixo por box de confirmação para o usuário conforme padrão a ser decidido
			$.snackbar({content: "Um e-mail com o link para redefinir sua senha foi enviado!", style: "toast sucesso"});
			// TO DO apos confirmação redirecionar usuário para outra página que decidir
			$location.path("/");
		},
		function(error) {
			$.snackbar({content: error.data.message, style: "toast erro"});
		});
	};

	//Após receber link com token usuário informa a nova senha na função abaixo
	$scope.testeSenha = function() {
		//Condição para garantir que a senha e a confirmação da senha são iguais
		if ($scope.novasenha == $scope.confirmesenha) {
			//Aqui é validado o usuario pelo token que recebeu no e-mail e retorna o id do usuário
			redefinirSenhaService.recuperaUsuarioPorToken($routeParams.token)
			.then(function (response) {
				//Com o id do usuario então é passado ao back o id e a nova senha
				redefinirSenhaService.redefinirSenha(
					{"idUsuario" : response.data.id,
					 "novaSenha"  :$scope.novasenha})
				.then(function (response) {
					$.snackbar({content: "Dados gravados com sucesso!", style: "alert alert-success"});
					// TO DO apos confirmação redirecionar usuário para outra página que decidir
					$location.path("/");
				},
				function(error) {
					$.snackbar({content: error.data.message, style: "toast erro"});
				});
			},
			function(error) {
				$.snackbar({content: error.data.message, style: "toast erro"});
			});
		}else{
			$.snackbar({content: "A nova senha e sua confirmação devem ser iguais.", style: "toast erro"});
		}
	}

	$scope.validarTamanhoSenha = function(strSenha){
		$scope.errorSenha = false;

		if(strSenha == null || (strSenha.length < 6
			|| strSenha.length > 12)){
				$scope.errorSenha = true;
				$.snackbar({content: 'Senha deve conter de 6 à 12 dígitos.', style: "toast erro"});
				return false;
			}
			return true;
			$scope.errorSenha = false;
	};

	$scope.validaSenha = function(){
		$scope.errorSenha = false;

		var tamanhoCorreto = $scope.validarTamanhoSenha($scope.usuario.confirmarSenha);

		if (!tamanhoCorreto)
			return;

		if($scope.usuario.novaSenha == $scope.usuario.confirmarSenha){
			return true;
			$scope.errorSenha = false;
		}else {
			$.snackbar({content: 'Senhas não são iguais.', style: "toast erro"});
			$scope.errorSenha = true;
			return false;
		}
	};

	$scope.validaEmail = function(){
		$scope.errorEmail = false;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(!filter.test($scope.usuario.email)){
			$.snackbar({content: 'Campo e-mail está incorreto', style: "toast erro"});
			$scope.errorEmail = true;
			return false
		}
	}

}])
