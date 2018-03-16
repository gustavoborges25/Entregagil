app.controller('residencialController', ['$scope', '$location', '$rootScope','$window', '$localStorage', 'residencialService',function($scope, $location, $rootScope, $window, $localStorage, residencialService){

    $scope.init = function() {
        $scope.count = 2;
        $window.scrollTo(0, 0);
        $scope.anuncio = {};
        $scope.anuncio.qtdeDormitorios = 1;
        $scope.anuncio.qtdeAbajur = 0;
        $scope.anuncio.qtdeArmarioArquivo = 0;
        $scope.anuncio.qtdeArmarioComum = 0;
        $scope.anuncio.qtdeAparelhoSom = 0;
        $scope.anuncio.qtdeAspiradorPo = 0;
        $scope.anuncio.qtdeArCondicionado = 0;
        $scope.anuncio.qtdeAquario = 0;
        $scope.anuncio.qtdeBancoAlto = 0;
        $scope.anuncio.qtdeBancoVaranda = 0;
        $scope.anuncio.qtdeBarzinho = 0;
        $scope.anuncio.qtdeBau = 0;
        $scope.anuncio.qtdeBerco = 0;
        $scope.anuncio.qtdeBicicleta = 0;
        $scope.anuncio.qtdeCadeira = 0;
        $scope.anuncio.qtdeCamaSolteiro = 0;
        $scope.anuncio.qtdeCamaCasal = 0;
        $scope.anuncio.qtdeCamaBeliche = 0;
        $scope.anuncio.qtdeComoda = 0;
        $scope.anuncio.qtdeCarrinhoMao = 0;
        $scope.anuncio.qtdeChurrasqueira = 0;
        $scope.anuncio.qtdeCaixaRoupas = 0;
        $scope.anuncio.qtdeCaixasPequenas = 0;
        $scope.anuncio.qtdeCaixasMedias = 0;
        $scope.anuncio.qtdeCaixasGrandes = 0;
        $scope.anuncio.qtdeCristaleira = 0;
        $scope.anuncio.qtdeEstante = 0;
        $scope.anuncio.qtdeEscrivaninha = 0;
        $scope.anuncio.qtdeEspelho = 0;
        $scope.anuncio.qtdeFogao = 0;
        $scope.anuncio.qtdeFrigobar = 0;
        $scope.anuncio.qtdeFreezer = 0;
        $scope.anuncio.qtdeGuardaRoupa = 0;
        $scope.anuncio.qtdeGuardaSol = 0;
        $scope.anuncio.qtdeInstrumentoMusical = 0;
        $scope.anuncio.qtdeLuminaria = 0;
        $scope.anuncio.qtdeLixeira = 0;
        $scope.anuncio.qtdeLavaLoucas = 0;
        $scope.anuncio.qtdeLavaRoupas = 0;
        $scope.anuncio.qtdeMesaMadeira = 0;
        $scope.anuncio.qtdeMesaVidro = 0;
        $scope.anuncio.qtdeMesaCentro = 0;
        $scope.anuncio.qtdeMicroondas = 0;
        $scope.anuncio.qtdePiano = 0;
        $scope.anuncio.qtdePoltrona = 0;
        $scope.anuncio.qtdePrateleira = 0;
        $scope.anuncio.qtdePenteadeira = 0;
        $scope.anuncio.qtdeRack = 0;
        $scope.anuncio.qtdeRefrigerador = 0;
        $scope.anuncio.qtdeSofa = 0;
        $scope.anuncio.qtdeSecadoraRoupas = 0;
        $scope.anuncio.qtdeTelevisao = 0;
        $scope.anuncio.qtdeTabuaPassar = 0;
        fotos = [];
    }

    $scope.salvarItem = function () {
        $rootScope.itemDoAnuncio = $scope.anuncio;
        $rootScope.itemDoAnuncio.fotos = fotos;
        $location.path('/anuncio/criar-anuncio');
    };

     $scope.menosDormitorio = function(){
        if($scope.anuncio.qtdeDormitorios>1){
            $scope.anuncio.qtdeDormitorios--;
        }
    }
    $scope.maisDormitorio = function(){
        if($scope.anuncio.qtdeDormitorios<10){
            $scope.anuncio.qtdeDormitorios++;
        }
    }
    $scope.menosAbajur = function(){
        if($scope.anuncio.qtdeAbajur>0){
            $scope.anuncio.qtdeAbajur--;
        }
    }
    $scope.maisAbajur = function(){
        if($scope.anuncio.qtdeAbajur<10){
            $scope.anuncio.qtdeAbajur++;
        }
    }
    $scope.menosArmarioArquivo = function(){
        if($scope.anuncio.qtdeArmarioArquivo>0){
            $scope.anuncio.qtdeArmarioArquivo--;
        }
    }
    $scope.maisArmarioArquivo = function(){
        if($scope.anuncio.qtdeArmarioArquivo<10){
            $scope.anuncio.qtdeArmarioArquivo++;
        }
    }
    $scope.menosArmarioComum = function(){
        if($scope.anuncio.qtdeArmarioComum>0){
            $scope.anuncio.qtdeArmarioComum--;
        }
    }
    $scope.maisArmarioComum = function(){
        if($scope.anuncio.qtdeArmarioComum<10){
            $scope.anuncio.qtdeArmarioComum++;
        }
    }
    $scope.menosAparelhoSom = function(){
        if($scope.anuncio.qtdeAparelhoSom>0){
            $scope.anuncio.qtdeAparelhoSom--;
        }
    }
    $scope.maisAparelhoSom = function(){
        if($scope.anuncio.qtdeAparelhoSom<10){
            $scope.anuncio.qtdeAparelhoSom++;
        }
    }
    $scope.menosAspiradorPo = function(){
        if($scope.anuncio.qtdeAspiradorPo>0){
            $scope.anuncio.qtdeAspiradorPo--;
        }
    }
    $scope.maisAspiradorPo = function(){
        if($scope.anuncio.qtdeAspiradorPo<10){
            $scope.anuncio.qtdeAspiradorPo++;
        }
    }
    $scope.menosArCondicionado = function(){
        if($scope.anuncio.qtdeArCondicionado>0){
            $scope.anuncio.qtdeArCondicionado--;
        }
    }
    $scope.maisArCondicionado = function(){
        if($scope.anuncio.qtdeArCondicionado<10){
            $scope.anuncio.qtdeArCondicionado++;
        }
    }
    $scope.menosAquario = function(){
        if($scope.anuncio.qtdeAquario>0){
            $scope.anuncio.qtdeAquario--;
        }
    }
    $scope.maisAquario = function(){
        if($scope.anuncio.qtdeAquario<10){
            $scope.anuncio.qtdeAquario++;
        }
    }
    $scope.menosBancoAlto = function(){
        if($scope.anuncio.qtdeBancoAlto>0){
            $scope.anuncio.qtdeBancoAlto--;
        }
    }
    $scope.maisBancoAlto = function(){
        if($scope.anuncio.qtdeBancoAlto<10){
            $scope.anuncio.qtdeBancoAlto++;
        }
    }
    $scope.menosBancoVaranda = function(){
        if($scope.anuncio.qtdeBancoVaranda>0){
            $scope.anuncio.qtdeBancoVaranda--;
        }
    }
    $scope.maisBancoVaranda = function(){
        if($scope.anuncio.qtdeBancoVaranda<10){
            $scope.anuncio.qtdeBancoVaranda++;
        }
    }
    $scope.menosBarzinho = function(){
        if($scope.anuncio.qtdeBarzinho>0){
            $scope.anuncio.qtdeBarzinho--;
        }
    }
    $scope.maisBarzinho = function(){
        if($scope.anuncio.qtdeBarzinho<10){
            $scope.anuncio.qtdeBarzinho++;
        }
    }
    $scope.menosBau = function(){
        if($scope.anuncio.qtdeBau>0){
            $scope.anuncio.qtdeBau--;
        }
    }
    $scope.maisBau = function(){
        if($scope.anuncio.qtdeBau<10){
            $scope.anuncio.qtdeBau++;
        }
    }
    $scope.menosBerco = function(){
        if($scope.anuncio.qtdeBerco>0){
            $scope.anuncio.qtdeBerco--;
        }
    }
    $scope.maisBerco = function(){
        if($scope.anuncio.qtdeBerco<10){
            $scope.anuncio.qtdeBerco++;
        }
    }
    $scope.menosBicicleta = function(){
        if($scope.anuncio.qtdeBicicleta>0){
            $scope.anuncio.qtdeBicicleta--;
        }
    }
    $scope.maisBicicleta = function(){
        if($scope.anuncio.qtdeBicicleta<10){
            $scope.anuncio.qtdeBicicleta++;
        }
    }
    $scope.menosCadeira = function(){
        if($scope.anuncio.qtdeCadeira>0){
            $scope.anuncio.qtdeCadeira--;
        }
    }
    $scope.maisCadeira = function(){
        if($scope.anuncio.qtdeCadeira<10){
            $scope.anuncio.qtdeCadeira++;
        }
    }
    $scope.menosCamaSolteiro = function(){
        if($scope.anuncio.qtdeCamaSolteiro>0){
            $scope.anuncio.qtdeCamaSolteiro--;
        }
    }
    $scope.maisCamaSolteiro = function(){
        if($scope.anuncio.qtdeCamaSolteiro<10){
            $scope.anuncio.qtdeCamaSolteiro++;
        }
    }
    $scope.menosCamaCasal = function(){
        if($scope.anuncio.qtdeCamaCasal>0){
            $scope.anuncio.qtdeCamaCasal--;
        }
    }
    $scope.maisCamaCasal = function(){
        if($scope.anuncio.qtdeCamaCasal<10){
            $scope.anuncio.qtdeCamaCasal++;
        }
    }
    $scope.menosCamaBeliche = function(){
        if($scope.anuncio.qtdeCamaBeliche>0){
            $scope.anuncio.qtdeCamaBeliche--;
        }
    }
    $scope.maisCamaBeliche = function(){
        if($scope.anuncio.qtdeCamaBeliche<10){
            $scope.anuncio.qtdeCamaBeliche++;
        }
    }
    $scope.menosComoda = function(){
        if($scope.anuncio.qtdeComoda>0){
            $scope.anuncio.qtdeComoda--;
        }
    }
    $scope.maisComoda = function(){
        if($scope.anuncio.qtdeComoda<10){
            $scope.anuncio.qtdeComoda++;
        }
    }
    $scope.menosCarrinhoMao = function(){
        if($scope.anuncio.qtdeCarrinhoMao>0){
            $scope.anuncio.qtdeCarrinhoMao--;
        }
    }
    $scope.maisCarrinhoMao = function(){
        if($scope.anuncio.qtdeCarrinhoMao<10){
            $scope.anuncio.qtdeCarrinhoMao++;
        }
    }
    $scope.menosChurrasqueira = function(){
        if($scope.anuncio.qtdeChurrasqueira>0){
            $scope.anuncio.qtdeChurrasqueira--;
        }
    }
    $scope.maisChurrasqueira = function(){
        if($scope.anuncio.qtdeChurrasqueira<10){
            $scope.anuncio.qtdeChurrasqueira++;
        }
    }
    $scope.menosCaixaRoupas = function(){
        if($scope.anuncio.qtdeCaixaRoupas>0){
            $scope.anuncio.qtdeCaixaRoupas--;
        }
    }
    $scope.maisCaixaRoupas = function(){
        if($scope.anuncio.qtdeCaixaRoupas<10){
            $scope.anuncio.qtdeCaixaRoupas++;
        }
    }
    $scope.menosCaixasPequenas = function(){
        if($scope.anuncio.qtdeCaixasPequenas>0){
            $scope.anuncio.qtdeCaixasPequenas--;
        }
    }
    $scope.maisCaixasPequenas = function(){
        if($scope.anuncio.qtdeCaixasPequenas<10){
            $scope.anuncio.qtdeCaixasPequenas++;
        }
    }
    $scope.menosCaixasMedias = function(){
        if($scope.anuncio.qtdeCaixasMedias>0){
            $scope.anuncio.qtdeCaixasMedias--;
        }
    }
    $scope.maisCaixasMedias = function(){
        if($scope.anuncio.qtdeCaixasMedias<10){
            $scope.anuncio.qtdeCaixasMedias++;
        }
    }
    $scope.menosCaixasGrandes = function(){
        if($scope.anuncio.qtdeCaixasGrandes>0){
            $scope.anuncio.qtdeCaixasGrandes--;
        }
    }
    $scope.maisCaixasGrandes = function(){
        if($scope.anuncio.qtdeCaixasGrandes<10){
            $scope.anuncio.qtdeCaixasGrandes++;
        }
    }
    $scope.menosCristaleira = function(){
        if($scope.anuncio.qtdeCristaleira>0){
            $scope.anuncio.qtdeCristaleira--;
        }
    }
    $scope.maisCristaleira = function(){
        if($scope.anuncio.qtdeCristaleira<10){
            $scope.anuncio.qtdeCristaleira++;
        }
    }
    $scope.menosEstante = function(){
        if($scope.anuncio.qtdeEstante>0){
            $scope.anuncio.qtdeEstante--;
        }
    }
    $scope.maisEstante = function(){
        if($scope.anuncio.qtdeEstante<10){
            $scope.anuncio.qtdeEstante++;
        }
    }
    $scope.menosEscrivaninha = function(){
        if($scope.anuncio.qtdeEscrivaninha>0){
            $scope.anuncio.qtdeEscrivaninha--;
        }
    }
    $scope.maisEscrivaninha = function(){
        if($scope.anuncio.qtdeEscrivaninha<10){
            $scope.anuncio.qtdeEscrivaninha++;
        }
    }
    $scope.menosEspelho = function(){
        if($scope.anuncio.qtdeEspelho>0){
            $scope.anuncio.qtdeEspelho--;
        }
    }
    $scope.maisEspelho = function(){
        if($scope.anuncio.qtdeEspelho<10){
            $scope.anuncio.qtdeEspelho++;
        }
    }
    $scope.menosFogao = function(){
        if($scope.anuncio.qtdeFogao>0){
            $scope.anuncio.qtdeFogao--;
        }
    }
    $scope.maisFogao = function(){
        if($scope.anuncio.qtdeFogao<10){
            $scope.anuncio.qtdeFogao++;
        }
    }
    $scope.menosFrigobar = function(){
        if($scope.anuncio.qtdeFrigobar>0){
            $scope.anuncio.qtdeFrigobar--;
        }
    }
    $scope.maisFrigobar = function(){
        if($scope.anuncio.qtdeFrigobar<10){
            $scope.anuncio.qtdeFrigobar++;
        }
    }
    $scope.menosFreezer = function(){
        if($scope.anuncio.qtdeFreezer>0){
            $scope.anuncio.qtdeFreezer--;
        }
    }
    $scope.maisFreezer = function(){
        if($scope.anuncio.qtdeFreezer<10){
            $scope.anuncio.qtdeFreezer++;
        }
    }
     $scope.menosGuardaRoupa = function(){
         if($scope.anuncio.qtdeGuardaRoupa>0){
             $scope.anuncio.qtdeGuardaRoupa--;
         }
     }
     $scope.maisGuardaRoupa = function(){
         if($scope.anuncio.qtdeGuardaRoupa<10){
             $scope.anuncio.qtdeGuardaRoupa++;
         }
     }
    $scope.menosGuardaSol = function(){
        if($scope.anuncio.qtdeGuardaSol>0){
            $scope.anuncio.qtdeGuardaSol--;
        }
    }
    $scope.maisGuardaSol = function(){
        if($scope.anuncio.qtdeGuardaSol<10){
            $scope.anuncio.qtdeGuardaSol++;
        }
    }
    $scope.menosInstrumentoMusical = function(){
        if($scope.anuncio.qtdeInstrumentoMusical>0){
            $scope.anuncio.qtdeInstrumentoMusical--;
        }
    }
    $scope.maisInstrumentoMusical = function(){
        if($scope.anuncio.qtdeInstrumentoMusical<10){
            $scope.anuncio.qtdeInstrumentoMusical++;
        }
    }
    $scope.menosLuminaria = function(){
        if($scope.anuncio.qtdeLuminaria>0){
            $scope.anuncio.qtdeLuminaria--;
        }
    }
    $scope.maisLuminaria = function(){
        if($scope.anuncio.qtdeLuminaria<10){
            $scope.anuncio.qtdeLuminaria++;
        }
    }
     $scope.menosLixeira = function(){
         if($scope.anuncio.qtdeLixeira>0){
             $scope.anuncio.qtdeLixeira--;
         }
     }
     $scope.maisLixeira = function(){
         if($scope.anuncio.qtdeLixeira<10){
             $scope.anuncio.qtdeLixeira++;
         }
     }
     $scope.menosLavaLoucas = function(){
         if($scope.anuncio.qtdeLavaLoucas>0){
             $scope.anuncio.qtdeLavaLoucas--;
         }
     }
     $scope.maisLavaLoucas = function(){
         if($scope.anuncio.qtdeLavaLoucas<10){
             $scope.anuncio.qtdeLavaLoucas++;
         }
     }
     $scope.menosLavaRoupas = function(){
         if($scope.anuncio.qtdeLavaRoupas>0){
             $scope.anuncio.qtdeLavaRoupas--;
         }
     }
     $scope.maisLavaRoupas = function(){
         if($scope.anuncio.qtdeLavaRoupas<10){
             $scope.anuncio.qtdeLavaRoupas++;
         }
     }       
    $scope.menosMesaMadeira = function(){
        if($scope.anuncio.qtdeMesaMadeira>0){
            $scope.anuncio.qtdeMesaMadeira--;
        }
    }
    $scope.maisMesaMadeira = function(){
        if($scope.anuncio.qtdeMesaMadeira<10){
            $scope.anuncio.qtdeMesaMadeira++;
        }
    }
    $scope.menosMesaVidro = function(){
        if($scope.anuncio.qtdeMesaVidro>0){
            $scope.anuncio.qtdeMesaVidro--;
        }
    }
    $scope.maisMesaVidro = function(){
        if($scope.anuncio.qtdeMesaVidro<10){
            $scope.anuncio.qtdeMesaVidro++;
        }
    }
    $scope.menosMesaCentro = function(){
        if($scope.anuncio.qtdeMesaCentro>0){
            $scope.anuncio.qtdeMesaCentro--;
        }
    }
    $scope.maisMesaCentro = function(){
        if($scope.anuncio.qtdeMesaCentro<10){
            $scope.anuncio.qtdeMesaCentro++;
        }
    }
    $scope.menosMicroondas = function(){
        if($scope.anuncio.qtdeMicroondas>0){
            $scope.anuncio.qtdeMicroondas--;
        }
    }
    $scope.maisMicroondas = function(){
        if($scope.anuncio.qtdeMicroondas<10){
            $scope.anuncio.qtdeMicroondas++;
        }
    }
    $scope.menosPiano = function(){
        if($scope.anuncio.qtdePiano>0){
            $scope.anuncio.qtdePiano--;
        }
    }
    $scope.maisPiano = function(){
        if($scope.anuncio.qtdePiano<10){
            $scope.anuncio.qtdePiano++;
        }
    }
    $scope.menosPoltrona = function(){
        if($scope.anuncio.qtdePoltrona>0){
            $scope.anuncio.qtdePoltrona--;
        }
    }
    $scope.maisPoltrona = function(){
        if($scope.anuncio.qtdePoltrona<10){
            $scope.anuncio.qtdePoltrona++;
        }
    }
    $scope.menosPrateleira = function(){
        if($scope.anuncio.qtdePrateleira>0){
            $scope.anuncio.qtdePrateleira--;
        }
    }
    $scope.maisPrateleira = function(){
        if($scope.anuncio.qtdePrateleira<10){
            $scope.anuncio.qtdePrateleira++;
        }
    }
    $scope.menosPenteadeira = function(){
        if($scope.anuncio.qtdePenteadeira>0){
            $scope.anuncio.qtdePenteadeira--;
        }
    }
    $scope.maisPenteadeira = function(){
        if($scope.anuncio.qtdePenteadeira<10){
            $scope.anuncio.qtdePenteadeira++;
        }
    }
    $scope.menosRack = function(){
        if($scope.anuncio.qtdeRack>0){
            $scope.anuncio.qtdeRack--;
        }
    }
    $scope.maisRack = function(){
        if($scope.anuncio.qtdeRack<10){
            $scope.anuncio.qtdeRack++;
        }
    }
    $scope.menosRefrigerador = function(){
        if($scope.anuncio.qtdeRefrigerador>0){
            $scope.anuncio.qtdeRefrigerador--;
        }
    }
    $scope.maisRefrigerador = function(){
        if($scope.anuncio.qtdeRefrigerador<10){
            $scope.anuncio.qtdeRefrigerador++;
        }
    }
    $scope.menosSofa = function(){
        if($scope.anuncio.qtdeSofa>0){
            $scope.anuncio.qtdeSofa--;
        }
    }
    $scope.maisSofa = function(){
        if($scope.anuncio.qtdeSofa<10){
            $scope.anuncio.qtdeSofa++;
        }
    }
    $scope.menosSecadoraRoupas = function(){
        if($scope.anuncio.qtdeSecadoraRoupas>0){
            $scope.anuncio.qtdeSecadoraRoupas--;
        }
    }
    $scope.maisSecadoraRoupas = function(){
        if($scope.anuncio.qtdeSecadoraRoupas<10){
            $scope.anuncio.qtdeSecadoraRoupas++;
        }
    }
     $scope.menosTelevisao = function(){
         if($scope.anuncio.qtdeTelevisao>0){
             $scope.anuncio.qtdeTelevisao--;
         }
     }
     $scope.maisTelevisao = function(){
         if($scope.anuncio.qtdeTelevisao<10){
             $scope.anuncio.qtdeTelevisao++;
         }
     }
    $scope.menosTabuaPassar = function(){
        if($scope.anuncio.qtdeTabuaPassar>0){
            $scope.anuncio.qtdeTabuaPassar--;
        }
    }
    $scope.maisTabuaPassar = function(){
        if($scope.anuncio.qtdeTabuaPassar<10){
            $scope.anuncio.qtdeTabuaPassar++;
        }
    }

}])