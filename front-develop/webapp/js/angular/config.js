//Arquivo de configuração, onde a palavra 'crud' é o nome que esta na diretiva ng-app
app = angular.module('entregagil', ['ngRoute', 'ngStorage', 'naif.base64', 'angularUtils.directives.dirPagination']);

app.controller('appController', ['$scope', '$location', '$rootScope', '$localStorage', '$route', function ($scope, $location, $rootScope, $localStorage, $route) {

	$scope.inicializaUsuarioLogado = function () {
		if ($localStorage.usuarioLogado) {
			$rootScope.logado = true;
			$rootScope.usuarioLogado = $localStorage.usuarioLogado;
		} else {
			$rootScope.logado = false;
			$rootScope.usuarioLogado = "";
		}
	};

	$scope.logout = function () {
		$localStorage.$reset();
		$rootScope.logado = false;
		$rootScope.usuarioLogado = "";
		$route.reload();
		$location.path('/');
	};

}])

app.config(function(paginationTemplateProvider) {
    paginationTemplateProvider.setPath('js/plugins/dirPagination.tpl.html');
});