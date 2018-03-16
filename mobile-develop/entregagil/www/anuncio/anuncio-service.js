angular.module('starter.anuncio.service', [])

.factory('AnuncioService', function($http, ionicToast, API) {

  var anuncios = [];

  var _getAnuncios = function(){
    return $http.get(API.url + "/anuncio");
  };

  var _getItemFotos = function(item) {
    item.fotos = [];
    console.log('Pegando fotos do item ' + item.id);
    $http.get(API.url + "/anuncio-item-foto/" + item.id)
      .then(function (response) {
        console.log('Encontradas ' + response.data.length + ' fotos');
        for (var i = 0; i < response.data.length; i++) {
          item.fotos.push(response.data[i].foto);
        }
      }, function (error) {
        ionicToast.show("Erro ao buscar as fotos do item " + item.nome + " do anúncio: " + error.data.message, 'bottom', false, 2500);
      })
  };

  return {

    all: _getAnuncios,

    get: function(anuncioId) {
      var anuncio = {};
      console.log("Pegando anúncio id: " + anuncioId);
      for (var i = 0; i < anuncios.length; i++) {
        if (anuncios[i].id === anuncioId) {
          anuncio = anuncios[i];

          // Busca os itens do anúncio
          $http.get(API.url + "/anuncio-item/anuncio/" + anuncio.id)
            .then(function (response) {
              anuncio.itens = response.data;

              // Busca as fotos de cada item
              for (var j = 0; j < anuncio.itens.length; j++) {
                _getItemFotos(anuncio.itens[j]);
              }

            }, function (error) {
              ionicToast.show("Erro ao buscar itens do anúncio: " + error.data.message, 'bottom', false, 2500);
            });

        }
      }
      return anuncio;
    },

    guardaListaAnuncios: function (listaAnuncios) {
      anuncios = listaAnuncios;
    }

  }

});
