angular.module('starter.login.controller', ['ngStorage'])

.controller('SignInCtrl', function($scope, $state, $localStorage, Login) {
  $scope.init = function(){
    if($localStorage.usuario){
      $state.go('app.anuncios');
    }
  }


  $scope.signIn = function(usuario) {
    // Login.logar(usuario, $scope.redirecionaParaSistemaAposLogado);
    $state.go('app.anuncios');
  };

  $scope.redirecionaParaSistemaAposLogado = function(usuarioLogado) {
    $localStorage.usuario = usuarioLogado;
    $state.go('app.anuncios');
  };

});
