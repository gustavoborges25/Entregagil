// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
app = angular.module('starter', ['ionic'
  , 'starter.controllers', 'starter.services'
  , 'starter.login.controller', 'starter.login.service'
  , 'starter.anuncio.controller', 'starter.anuncio.service'
  , 'ionic-toast','ngCordova'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})

.constant('API', {
  'url': 'http://127.0.0.1:8080'
})

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

    .state('login', {
      url: '/login',
      templateUrl: 'login/sign-in.html',
      controller: 'SignInCtrl'
    })
    .state('esquecisenha', {
      url: '/esqueci-minha-senha',
      templateUrl: 'templates/esqueci-minha-senha.html'
    })

  // setup an abstract state for the tabs directive
  // .state('tab', {
  //   url: '/tab',
  //   abstract: true,
  //   templateUrl: 'templates/tabs.html'
  // })
  //
  // // Each tab has its own nav history stack:
  //
  // .state('tab.dash', {
  //   url: '/dash',
  //   views: {
  //     'tab-dash': {
  //       templateUrl: 'templates/tab-dash.html',
  //       controller: 'DashCtrl'
  //     }
  //   }
  // })
  //
  // .state('tab.chats', {
  //     url: '/chats',
  //     views: {
  //       'tab-chats': {
  //         templateUrl: 'templates/tab-chats.html',
  //         controller: 'ChatsCtrl'
  //       }
  //     }
  //   })
  //   .state('tab.chat-detail', {
  //     url: '/chats/:chatId',
  //     views: {
  //       'tab-chats': {
  //         templateUrl: 'templates/chat-detail.html',
  //         controller: 'ChatDetailCtrl'
  //       }
  //     }
  //   })
  //
  // .state('tab.account', {
  //   url: '/account',
  //   views: {
  //     'tab-account': {
  //       templateUrl: 'templates/tab-account.html',
  //       controller: 'AccountCtrl'
  //     }
  //   }
  // })
  //
  // .state('tab.anuncio', {
  //   url: '/anuncio',
  //   views: {
  //     'tab-anuncio': {
  //       templateUrl: 'anuncio/anuncios.html',
  //       controller: 'AnuncioListagemCtrl'
  //     }
  //   }
  // })
  // .state('tab.anuncio-detail', {
  //   url: '/anuncio/:anuncioId',
  //   views: {
  //     'tab-anuncio': {
  //       templateUrl: 'anuncio/anuncio.html',
  //       controller: 'AnuncioDetalhesCtrl'
  //     }
  //   }
  // })
  // .state('tab.anuncio-detail-enderecoOrigem', {
  //     url: '/anuncio/:anuncioId/enderecoOrigem',
  //   views: {
  //     'tab-anuncio': {
  //       templateUrl: 'anuncio/endereco.html',
  //       controller: 'AnuncioEnderecoOrigemCtrl'
  //     }
  //   }
  // })
  // .state('tab.anuncio-detail-enderecoDestino', {
  //   url: '/anuncio/:anuncioId/enderecoDestino',
  //   views: {
  //     'tab-anuncio': {
  //       templateUrl: 'anuncio/endereco.html',
  //       controller: 'AnuncioEnderecoDestinoCtrl'
  //     }
  //   }
  // })
  // .state('tab.anuncio-detail-autor', {
  //   url: '/anuncio/:anuncioId/autor',
  //   views: {
  //     'tab-anuncio': {
  //       templateUrl: 'anuncio/pessoa.html',
  //       controller: 'AnuncioAutorCtrl'
  //     }
  //   }
  // })
  .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html',
    controller: 'DashCtrl'
  })
  .state('app.anuncios', {
    url: '/anuncios',
    views: {
      'menuContent': {
        templateUrl: 'templates/anuncios.html',
        controller: 'AnuncioDetalhesCtrl'
      }
    }
  })
  .state('app.transportes', {
    url: '/transportes',
    views: {
      'menuContent': {
        templateUrl: 'templates/transportes.html',
        controller: 'AnuncioDetalhesCtrl'
      }
    }
  })
  .state('app.detalhe', {
    url: '/detalhe',
    views: {
      'menuContent': {
        templateUrl: 'templates/detalhe-anuncio.html',
        controller: 'AnuncioDetalhesCtrl'
      }
    }
  })
  .state('app.lance', {
    url: '/lance',
    views: {
      'menuContent': {
        templateUrl: 'templates/lance.html',
        // controller: 'anuncio-controller'
      }
    }
  })
  .state('app.checkin', {
    url: '/checkin',
    views: {
      'menuContent': {
        templateUrl: 'templates/checkin.html',
        controller: 'CheckinController'
      }
    }
  })
  .state('app.notificacao', {
    url: '/notificacao',
    views: {
      'menuContent': {
        templateUrl: 'templates/notificacao.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.configuracao', {
    url: '/configuracao',
    views: {
      'menuContent': {
        templateUrl: 'templates/configuracao.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.configuracaoprivacidade', {
    url: '/configuracaoprivacidade',
    views: {
      'menuContent': {
        templateUrl: 'templates/configuracaoprivacidade.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.sobre', {
    url: '/sobre',
    views: {
      'menuContent': {
        templateUrl: 'templates/sobre.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.idioma', {
    url: '/idioma',
    views: {
      'menuContent': {
        templateUrl: 'templates/idioma.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.pesquisa', {
    url: '/pesquisa',
    views: {
      'menuContent': {
        templateUrl: 'templates/pesquisa.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })
  .state('app.checkins', {
    url: '/checkins',
    views: {
      'menuContent': {
        templateUrl: 'templates/checkins.html',
        // controller: 'PlaylistsCtrl'
      }
    }
  })

  $urlRouterProvider.otherwise('/login');

});
