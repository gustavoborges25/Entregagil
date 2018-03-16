app.service("anuncioService", ["$http", function($http){


	return	{
		salvar : function(rota, anuncio, token) {
			return $http.post(rota, anuncio, {headers: {'tokenUsuario': token}});
		},
		buscaCep: function(cep){
			return  $http.get('//cep.republicavirtual.com.br/web_cep.php?cep='+cep+'&formato=json');
		},
		getAnuncio : function(token, idPessoa) {
			return $http.get('/anuncio/pessoa/' + idPessoa, {headers: {'tokenUsuario': token}});
		},
		getTransporte : function(token, idPessoa){
			return $http.get('/anuncio/transportador/' + idPessoa, {headers: {'tokenUsuario': token}});
		}

	};
}]);
