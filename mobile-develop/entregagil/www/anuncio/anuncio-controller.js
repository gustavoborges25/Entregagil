angular.module('starter.anuncio.controller', [])

.controller('AnuncioListagemCtrl', function($scope, $stateParams, $state, AnuncioService) {
  // Busca todos os anúncios
  AnuncioService.all()
    .then(function (response) {
      console.log("Encontrou " + response.data.length + " anúncios.");
      $scope.anuncios = response.data;
      AnuncioService.guardaListaAnuncios(response.data);
    }, function (error) {
      ionicToast.show(error.data.message, 'bottom', false, 2500);
    });

})
.controller('AnuncioDetalhesCtrl', function($rootScope, $scope, $stateParams, $state, AnuncioService) {

  $scope.fazerCheckin = function(){
    $rootScope.concluido = true;
    console.log($scope.concluido);
    $state.go('app.detalhe');
  }

  $scope.darLance = function(){
    $rootScope.concluido = false;
    console.log($scope.concluido);
    $state.go('app.detalhe');
  }
  // Visualiza os detalhes do anúncio
  // $scope.anuncio = AnuncioService.get($stateParams.anuncioId);

})
.controller('AnuncioEnderecoOrigemCtrl', function($scope, $stateParams, AnuncioService) {

  $scope.endereco = AnuncioService.get($stateParams.anuncioId).enderecoOrigem;

})
.controller('AnuncioEnderecoDestinoCtrl', function($scope, $stateParams, AnuncioService) {

  $scope.endereco = AnuncioService.get($stateParams.anuncioId).enderecoDestino;

})
.controller('AnuncioAutorCtrl', function($scope, $stateParams, AnuncioService) {

  $scope.autor = AnuncioService.get($stateParams.anuncioId).pessoa;

})
.controller('CheckinController', function($scope, $state, $cordovaGeolocation){

  $scope.date = new Date();
  $scope.hour = $scope.date;

  var options = {timeout: 10000, enableHighAccuracy: true};

  $cordovaGeolocation.getCurrentPosition(options).then(function(position){

    var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;

    var mapOptions = {
      center: latLng,
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    $scope.map = new google.maps.Map(document.getElementById("map"), mapOptions);


    var marker = new google.maps.Marker({
        map: $scope.map,
        animation: google.maps.Animation.DROP,
        position: latLng
    });

    var geocoder = new google.maps.Geocoder;

    var infoWindow = new google.maps.InfoWindow({

    });

    // google.maps.event.addListener(marker, 'load', function () {
        // infoWindow.open($scope.map, marker);
        geocodeLatLng(geocoder, $scope.map, infoWindow);
    // });

    function geocodeLatLng(geocoder, map, infoWindow) {
        var latlngStr = [];
        latlngStr[0] = latitude;
        latlngStr[1] = longitude;

        var latlng = { lat: latlngStr[0], lng: latlngStr[1]};
        geocoder.geocode({ 'location': latlng }, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                      var marker = new google.maps.Marker({
                        position: latlng,
                        map: map
                    });
                    infoWindow.setContent(results[0].formatted_address);
                    infoWindow.open(map, marker);
                } else {
                    window.alert('No results found');
                }
            } else {
                window.alert('Geocoder failed due to: ' + status);
            }
        });
    }

  }, function(error){
    console.log("Could not get location");
  });

})
