app.controller('TransporteController', function($scope, $stateParams, $state, AnuncioService){

    $scope.fazerChekin = function(){
      $scope.concluido = 1;
      console.log($scope.concluido);
      $state.go('app.detalhe');
    }

});
