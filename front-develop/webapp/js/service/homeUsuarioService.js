app.service("homeUsuarioService", ["$http","$rootScope", function($http, $rootScope){
	return	{
		getLog : function(token, idAnuncio){
			return $http.get('/anuncio-log/anuncio/'+ idAnuncio, {headers: {'tokenUsuario': token}});
		},

		getLocal : function(local){
			return $http.get('https://maps.googleapis.com/maps/api/geocode/json?latlng='+local+'&result_type=administrative_area_level_2&key=AIzaSyDWHw-23UMNAeyETNn7PtI9uMJFqnEiLEk');
		},

		getMenorLance : function(token, idAnuncio){
			return $http.get('/anuncio-lance/menor-lance/'+ idAnuncio, {headers: {'tokenUsuario': token}});
		},

		postCheckin : function(checkin, token){
			return $http.post('/anuncio-log', checkin, {headers: {'tokenUsuario': token}});
		},

		deleteAnuncio : function(id, token){
			return $http.delete('/anuncio/'+id, {headers: {'tokenUsuario': token}});
		},

		deleteTransporte : function(id, token){
			return $http.delete('/anuncio/transporte/'+id, {headers: {'tokenUsuario': token}});
		},

		mediaAvaliacoesAnunciante : function(idPessoaAvaliada) {
            return $http.get('/pessoa-avaliacao/media-estrelas-anunciante/' + idPessoaAvaliada, {headers: {'tokenUsuario': $rootScope.usuarioLogado.token}})
        },
	    mediaAvaliacoesTransportador : function(idPessoaAvaliada) {
	        return $http.get('/pessoa-avaliacao/media-estrelas-transportador/' + idPessoaAvaliada, {headers: {'tokenUsuario': $rootScope.usuarioLogado.token}})
	    },
	};
}]);