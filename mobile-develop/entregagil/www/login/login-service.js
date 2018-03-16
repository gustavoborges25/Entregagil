angular.module('starter.login.service', [])

.factory('Login', function($http, ionicToast, API) {
  return {
    logar: function(usuario, redirecionaParaSistemaAposLogado) {
      if (!usuario) {
        ionicToast.show("Preencha o e-mail e senha.", 'bottom', false, 2500);
      } else {
        return $http.post(API.url + "/login", usuario).then(function(response) {
          redirecionaParaSistemaAposLogado(response.data);
          return response;
        }, function(error) {
          ionicToast.show(error.data.message, 'bottom', false, 2500);
        });
      }
    }
  }
});
