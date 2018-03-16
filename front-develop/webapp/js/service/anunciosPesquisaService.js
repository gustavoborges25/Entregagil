app.service("anunciosPesquisaService", ["$http", function($http){

    return	{
        cadastrar : function(usuario) {
            return $http.post('/usuario/cadastrar-usuario', usuario);
        },

        getAnuncios : function(nomeCategoria) {
            return $http.get('/anuncio/categoria/' + nomeCategoria);
        },

        getAnunciosByQuery : function(query) {
            return $http.get('/anuncio/query/' + query);
        },

        getUltimosDezAnuncios : function(query) {
            return $http.get('/anuncio/ultimos');
        }
    };

}]);