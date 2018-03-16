app.controller('alterarSenhaController', ['$scope', '$rootScope', '$location','$localStorage','alterarSenhaService', function($scope, $rootScope, $location, $localStorage, alterarSenhaService){

	$scope.init = function(){
		$rootScope.showMenuUsuario = true;
		$rootScope.showRodape = false;
		$rootScope.telaLogin = false;

		$rootScope.onMenu = 'home';

		$rootScope.mudaOnMenu = function($var){
 			$rootScope.onMenu = $var;
		}

		if (!$localStorage.usuarioLogado) {
			$location.path('/');
		}

		$scope.usuario = $localStorage.usuarioLogado.usuario;
		$scope.errorSenha = false;
		$scope.errorEmail = false;
		$scope.usuario.foto = "../../../../../imagem/a8744bef-3ff9-4372-bf96-47322c0e237b.png";
//			\back\src\main\webapp\js\controller
	};

	$scope.salvar = function() {
        if (!$scope.errorSenha) {
            alterarSenhaService.alterarSenha($rootScope.usuarioLogado.token, $scope.usuario).success(function(data) {
                $.snackbar({content: "Dados gravados com sucesso!", style: "toast sucesso"});
                //$location.path('/');
                $scope.usuario.confirmacaoSenha = "";
                $scope.usuario.senha = "";
            }).error(function(data,status) {
                $.snackbar({content: error.data.message, style: "toast erro"});
            })
         }
    };

	$scope.solicitarAlteracaoEmail = function(){
		alterarSenhaService.solicitarAlteracaoEmail($rootScope.usuarioLogado.token, $scope.usuario).success(function(data){
				$.snackbar({content: "Para alterar o e-mail, clique no link que enviamos no seu e-mail atual.", style: "toast sucesso"});
				$location.path('/');
		}).error(function(data){
				$.snackbar({content: error.data.message, style: "toast erro"});
		})
	};

	$scope.validarTamanhoSenha = function(strSenha) {
		$scope.errorSenha = false;

		if (strSenha == null || (strSenha.length < 6 || strSenha.length > 12)) {
			$scope.errorSenha = true;
			$.snackbar({content: 'Senha deve conter de 6 à 12 dígitos.', style: "toast erro"});
			return false;
		}

		return true;
	};

	$scope.validaSenha = function(){
		$scope.errorSenha = false;

		var tamanhoCorreto = $scope.validarTamanhoSenha($scope.usuario.confirmacaoSenha);

		if (!tamanhoCorreto)
			return;

		if($scope.usuario.senha == $scope.usuario.confirmacaoSenha){
			$scope.errorSenha = false;
		}else {
			$.snackbar({content: 'Senhas não são iguais.', style: "toast erro"});
			$scope.errorSenha = true;
		}
	};

	$scope.validaEmailIguais = function(){
		$scope.errorEmail = false;
		if ($scope.usuario.novoEmail == $scope.usuario.confirmarEmail){
			$scope.errorEmail = !$scope.validaEmail('confirmarEmail');
		} else {
			$.snackbar({content: 'Campos não são iguais!', style: "toast erro"});
			$scope.errorEmail = true;
		}
	};

	$scope.validaEmail = function(nomeCampo) {
		$scope.errorEmail = false;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if (!filter.test(document.getElementById(nomeCampo).value)) {
			$.snackbar({content: 'Campo e-mail está incorreto', style: "toast erro"});
			$scope.errorEmail = true;
			return false
		}

		return true;
	};

}])