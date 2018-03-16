app.controller('confirmarEmailController', ['$scope', '$location', '$rootScope', '$localStorage', '$routeParams', '$window', 'confirmarEmailService', function($scope, $location, $rootScope, $localStorage, $routeParams, $window, confirmarEmailService) {
    

    $scope.init = function () {
        $rootScope.showMenuUsuario = false;
        $rootScope.showRodape = true;
        $rootScope.telaLogin = false;

        confirmarEmailService.confirmarEmail($routeParams.token)
            .success(function(data){
                $localStorage.usuarioLogado.usuario = data;    
                $.snackbar({content: "E-mail confirmado.", style: "alert alert-success"});
                $window.location.reload();
        $location.path('/');
            })
            .error(function(data){
                $.snackbar({content: data.message, style: "alert alert-danger"});
                $location.path('/');
            })
        
    };
}])
