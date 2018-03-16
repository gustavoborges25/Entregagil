app.controller('privacidadeController', ['$scope', '$rootScope', '$location','$localStorage','privacidadeService', function($scope, $rootScope, $location, $localStorage, privacidadeService){

	$scope.init = function(){
		$rootScope.showMenuUsuario = true;
		$rootScope.showRodape = false;
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
	};

	$scope.salvar = function() {
        if (!$scope.errorSenha) {
            privacidadeService.alterarSenha($rootScope.usuarioLogado.token, $scope.usuario).success(function(data) {
                $.snackbar({content: "Senha alterada com sucesso!", "toast erro"});
                $location.path('/');
            }).error(function(data,status) {
                $.snackbar({content: error.data.message, style: "toast erro"});
            })
         }
    };

	$scope.solicitarAlteracaoEmail = function(){
		privacidadeService.solicitarAlteracaoEmail($rootScope.usuarioLogado.token, $scope.usuario).success(function(data){
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












// app.controller('privacidadeController', ['$scope', '$rootScope', '$location','$localStorage','privacidadeService', function($scope, $rootScope, $location, $localStorage, privacidadeService){

// 	$scope.init = function(){
// 		$rootScope.showMenuUsuario = true;
// 		$rootScope.showRodape = false;
// 		$rootScope.onMenu = 'home';

// 		$rootScope.mudaOnMenu = function($var){
// 			$rootScope.onMenu = $var;
// 		}

// 		if (!$localStorage.usuarioLogado) {
// 			$location.path('/');
// 		}

// 		$scope.usuario = $localStorage.usuarioLogado.usuario;
// 		$scope.errorSenha = false;
// 		$scope.errorEmail = false;
// 	};

// 	$scope.salvar = function() {
//         if (!$scope.errorSenha) {
//             privacidadeService.prvacidade($rootScope.usuarioLogado.token, $scope.usuario).success(function(data) {
//                 $.snackbar({content: "Senha alterada com sucesso!", style: "alert alert-success"});
//                 $location.path('/');
//             }).error(function(data,status) {
//                 $.snackbar({content: error.data.message, style: "alert alert-danger"});
//             })
//          }
//     };

// 	$scope.solicitarAlteracaoEmail = function(){
// 		privacidadeService.solicitarAlteracaoEmail($rootScope.usuarioLogado.token, $scope.usuario).success(function(data){
// 				$.snackbar({content: "Para alterar o e-mail, clique no link que enviamos no seu e-mail atual.", style: "alert alert-success"});
// 				$location.path('/');
// 		}).error(function(data){
// 				$.snackbar({content: error.data.message, style: "alert alert-danger"});
// 		})
// 	};

// 	$scope.validarTamanhoSenha = function(strSenha) {
// 		$scope.errorSenha = false;

// 		if (strSenha == null || (strSenha.length < 6 || strSenha.length > 12)) {
// 			$scope.errorSenha = true;
// 			$.snackbar({content: 'Senha deve conter de 6 à 12 dígitos.', style: "alert alert-danger"});
// 			return false;
// 		}

// 		return true;
// 	};

// 	$scope.validaSenha = function(){
// 		$scope.errorSenha = false;

// 		var tamanhoCorreto = $scope.validarTamanhoSenha($scope.usuario.confirmacaoSenha);

// 		if (!tamanhoCorreto)
// 			return;

// 		if($scope.usuario.senha == $scope.usuario.confirmacaoSenha){
// 			$scope.errorSenha = false;
// 		}else {
// 			$.snackbar({content: 'Senhas não são iguais.', style: "alert alert-danger"});
// 			$scope.errorSenha = true;
// 		}
// 	};

// 	$scope.validaEmailIguais = function(){
// 		$scope.errorEmail = false;
// 		if ($scope.usuario.novoEmail == $scope.usuario.confirmarEmail){
// 			$scope.errorEmail = !$scope.validaEmail('confirmarEmail');
// 		} else {
// 			$.snackbar({content: 'Campos não são iguais!', style: "alert alert-danger"});
// 			$scope.errorEmail = true;
// 		}
// 	};

// 	$scope.validaEmail = function(nomeCampo) {
// 		$scope.errorEmail = false;
// 		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
// 		if (!filter.test(document.getElementById(nomeCampo).value)) {
// 			$.snackbar({content: 'Campo e-mail está incorreto', style: "alert alert-danger"});
// 			$scope.errorEmail = true;
// 			return false
// 		}

// 		return true;
// 	};

// }])



