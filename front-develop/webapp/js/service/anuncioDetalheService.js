 app.service("anuncioDetalheService", ["$http", function($http){
 	
 	return	{
 		buscaDadosDoAnuncio : function(idAnuncio) {
 			return $http.get('/anuncio/' + idAnuncio);
 		},
 
 		getFotoMiniaturaDoAnuncio : function(idAnuncioItem) {
             return $http.get('/anuncio-item-foto/thumbnail/' + idAnuncioItem);
         },
         buscaItensDoAnuncio : function(idAnuncio) {
             return $http.get('/anuncio-item/anuncio/' + idAnuncio);
         },
         buscaFotosDosItens : function(idAnuncioItem) {
             return $http.get('/anuncio-item-foto/' + idAnuncioItem);
         },
         buscaLancesdoAnuncio : function(idAnuncio, tokenUsuario) {
         	return $http.get('/anuncio-lance/anuncio/' + idAnuncio, {headers: {'tokenUsuario': tokenUsuario}});
         },
         efetuarLance : function(lanceCommand, tokenUsuario){
            return $http.post('/anuncio-lance/new', lanceCommand, {headers: {'tokenUsuario': tokenUsuario}});
        },
         cancelarLance : function(cancelarLanceCommand, tokenUsuario){
            return $http.post('/anuncio-lance/cancel', cancelarLanceCommand, {headers: {'tokenUsuario': tokenUsuario}});
        },
         aceitarLance : function(aceitarLanceCommand, tokenUsuario){
            return $http.post('/anuncio-lance/accept', aceitarLanceCommand, {headers: {'tokenUsuario': tokenUsuario}});
         },
         perguntar : function(pergunta, tokenUsuario){
            return $http.post('/anuncio-pergunta/perguntar', pergunta, {headers: {'tokenUsuario': tokenUsuario}});
         }, 
         buscaPerguntas : function(idAnuncio, tokenUsuario){
            return $http.get('/anuncio-pergunta/anuncio/' + idAnuncio, {headers: {'tokenUsuario' : tokenUsuario}})
         }
 	};
 }]);