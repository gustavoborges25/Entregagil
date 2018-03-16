app.controller('loginController', ['$scope', '$rootScope', 'loginService', '$location', '$localStorage', function($scope, $rootScope, loginService, $location, $localStorage){

	$rootScope.showMenuUsuario = false;
	$rootScope.showRodape = false;

	$scope.logar = function() {
		loginService.logar($scope.usuario).success(function(data){
			$localStorage.usuarioLogado = data;
			$rootScope.logado = true;
			$rootScope.usuarioLogado = $localStorage.usuarioLogado;
			$location.path('/');
		}).error(function(data){
			$.snackbar({content: data.message, style: "toast erro"});
		})
	};

	$rootScope.telaLogin = true;

}]);
