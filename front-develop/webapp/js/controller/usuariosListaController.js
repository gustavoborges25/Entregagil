app.controller('usuariosListaController', ['$scope', '$location', '$rootScope', '$localStorage', 'usuarioListaService', function($scope, $location, $rootScope, $localStorage, usuarioListaService){

  //Seta as variaveis de usuario como false e vazias, colocar em todos os controllers
  $rootScope.logado = false;
  $rootScope.usuarioLogado = "";
  //verifica se o usuario ta logado mesmo com f5
  if($localStorage.usuarioLogado){
    $rootScope.logado = true;
    $rootScope.usuarioLogado = $localStorage.usuarioLogado;
  }else {
    $location.url('/login');
  };

  $scope.listaUsuarios = [
    {
      codigo:1,
      nome:'leonardo',
      email:'leonardo@gmail.com'
    },
    {
      codigo:2,
      nome:'marcos',
      email:'marcos@gmail.com'
    },
    {
      codigo:3,
      nome:'leandro',
      email:'leandro@gmail.com'
    },
    {
      codigo:4,
      nome:'marcia',
      email:'marcia@gmail.com'
    }
  ]

}]);
