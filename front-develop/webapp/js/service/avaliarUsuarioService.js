app.service("avaliarUsuarioService", ["$http", "$rootScope", function($http, $rootScope) {

	var token = {headers: {"tokenUsuario": $rootScope.usuarioLogado.token}};

	return	{
		buscaUsuario: function(id){
			return $http.get('/pessoa/' + id);
		},
		avaliarAnunciante : function(avaliacaoAnunciante) {
			return $http.post('/pessoa-avaliacao/avaliar-anunciante/', avaliacaoAnunciante, token);
		},

		avaliarTransportador : function(avaliacaoTransportador) {
			return $http.post('/pessoa-avaliacao/avaliar-transportador', avaliacaoTransportador, token);
		},

		getAvaliacoesFeitasPor : function(idPessoa) {
			return $http.get('/pessoa-avaliacao/feitas-por/' + idPessoa, token);
		},

		getAvaliacoesFeitasParaPessoaComoAnunciante : function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/feitas-para/' + idPessoaAvaliada + '/comoAnunciante', token);
		},

		getAvaliacoesFeitasParaPessoaComoTransportador : function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/feitas-para/' + idPessoaAvaliada + '/comoTransportador', token);
		},

		getAvaliacaoById : function(idAvaliacao) {
			return $http.get('/pessoa-avaliacao/' + idAvaliacao, token);
		}
	};

}]);
