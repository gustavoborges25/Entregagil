app.controller('alterarEmailController', ['$scope', '$rootScope', '$location','$routeParams','alterarSenhaService', function($scope, $rootScope, $location, $routeParams ,alterarSenhaService){

	$scope.init = function(){
		$rootScope.showMenuUsuario = false;
		$rootScope.showRodape = true;
		$rootScope.telaLogin = false;

		$scope.updateEmailUsuarioCommand = {};
		$scope.updateEmailUsuarioCommand.token = $routeParams.token;
		alterarSenhaService.recuperaUsuarioPorToken($scope.updateEmailUsuarioCommand.token).success(function(data){
			$scope.updateEmailUsuarioCommand.id = data.id;
			
		}).error(function(data){
			$.snackbar({content: "Token inválido!", style: "toast erro"});
			$location.path('/');
		})
	}

	$scope.salvar = function() {

		console.log('teste');
        if(!$scope.errorEmail && !$scope.updateEmailUsuarioCommand.id) {
            alterarSenhaService.alterarEmail($scope.updateEmailUsuarioCommand).success(function(data){
                $.snackbar({content: "E-mail alterado com sucesso, confirme seu novo e-mail", style: "toast sucesso", timeout: 100});
                $location.path('/');
            }).error(function(data,status){
                $.snackbar({content: error.data.message, style: "toast erro"});
            })
         }else {
			return false;
         }
    };

	$scope.validaEmailIguais = function(){
		$scope.errorEmail = false;
		if($scope.updateEmailUsuarioCommand.novoEmail == $scope.updateEmailUsuarioCommand.confirmarEmail){
			if (!$scope.validaEmail('confirmarEmail')) {
				$scope.errorEmail = true;
				return false;
			}
			$scope.errorEmail = false;
			return true
		}else {
			$.snackbar({content: 'Campos não são iguais!', style: "toast erro"});
			$scope.errorEmail = true;
			return false;
		}
	}

	$scope.validaEmail = function(nomeCampo){
		$scope.errorEmail = false;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(!filter.test(document.getElementById(nomeCampo).value)){
			$.snackbar({content: 'Campo e-mail está incorreto', style: "toast erro"});
			$scope.errorEmail = true;
			return false
		}

		return true;
	}
}])