app.controller("certificarController", ["$scope", "$rootScope", function($scope, $rootScope){

	$scope.init = function(){
		$rootScope.telaLogin = false;
		$rootScope.showRodape = false;
		$rootScope.showMenuUsuario = false;
		$rootScope.onMenu = 'home';
	}

}]);