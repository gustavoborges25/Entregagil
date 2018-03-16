angular.module('starter.services', [])

.factory('Chats', function() {
  // Might use a resource here that returns a JSON array

  // Some fake testing data
  var chats = [{
    id: 0,
    titulo: 'Mudança',
    validadeAnuncio: '01/07/2016',
    prazoEntrega: '09/07/2016',
    destinatario: 'João',
    remetente: 'José',
    grupo: 'Mudança',
    subgrupo: 'Residencial',
    itens: [
      {
        "id": "0",
        "altura": "2,00 m",
        "largura": "0,40 m",
        "comprimento": "2,50 m",
        "peso": "60 kg",
        "montavel": "Sim",
        "fragil": "Não",
        "observacao": "Precisa desmontar"
      },
      {
        "id": "0",
        "altura": "1,40 m",
        "largura": "0,35 m",
        "comprimento": "1,00 m",
        "peso": "31 kg",
        "montavel": "Sim",
        "fragil": "Não",
        "observacao": "Armário de cozinha"
      }
    ]
  }, {
    id: 1,
    titulo: 'Cama',
    validadeAnuncio: '29/06/2016',
    prazoEntrega: '01/07/2016',
    destinatario: 'Jonas',
    remetente: 'Mário',
    grupo: 'Móveis',
    subgrupo: 'Quarto',
    itens: [
      {
        "id": "0",
        "altura": "0,40 m",
        "largura": "0,90 m",
        "comprimento": "1,90 m",
        "peso": "20 kg",
        "montavel": "Não",
        "fragil": "Não",
        "observacao": "Cama box"
      }
    ]
  }];

  return {
    all: function() {
      return chats;
    },
    remove: function(chat) {
      chats.splice(chats.indexOf(chat), 1);
    },
    get: function(chatId) {
      for (var i = 0; i < chats.length; i++) {
        if (chats[i].id === parseInt(chatId)) {
          return chats[i];
        }
      }
      return null;
    }
  };
});
