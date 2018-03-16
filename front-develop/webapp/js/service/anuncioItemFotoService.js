app.service("anuncioItemFotoService", ["$http", function($http){

    return	{
        getFotoMiniaturaDoAnuncio : function(idAnuncio) {
            return $http.get('/anuncio-item-foto/thumbnail/' + idAnuncio);
        }
    };

}]);