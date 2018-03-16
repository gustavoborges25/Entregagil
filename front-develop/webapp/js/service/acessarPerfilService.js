app.service("acessarPerfilService", ["$http", "$rootScope", function($http, $rootScope){


	return {
		buscaUsuario: function(id){
			return $http.get('/pessoa/' + id);
		},
		buscaQtdAnuncios: function(id){
			return $http.get('/anuncio/qtde-cadastrados/' + id);
		},
		buscaAvaliacoesComoAnunciante: function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/feitas-para/' + idPessoaAvaliada + '/comoAnunciante',
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			)
		},
		buscaAvaliacoesComoTransportador: function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/feitas-para/' + idPessoaAvaliada + '/comoTransportador',
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			)
		},
		mediaAvaliacoesAnunciante : function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/media-estrelas-anunciante/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			)
		},
		mediaAvaliacoesTransportador : function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/media-estrelas-transportador/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			)
		},
		buscaTransportesRealizados : function(idPessoaAvaliada) {
			return $http.get('/pessoa-avaliacao/qtde-transportes-finalizados/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			);
		},
		porcentagemPessoasRecomendamTransportador : function(idPessoaAvaliada) {
			return $http.get(' /pessoa-avaliacao/percentual-recomendacoes-transportador/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			);
		},
		mediaTempoEntrega : function(idPessoaAvaliada){
				return $http.get('/pessoa-avaliacao/media-tempo-entrega/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			);
		},
		mediaIntegridadeMercadoria : function(idPessoaAvaliada){
				return $http.get('/pessoa-avaliacao/media-integridade-mercadoria/' + idPessoaAvaliada,
				{headers: {'tokenUsuario': $rootScope.usuarioLogado.token}}
			);
		}
	}


}])
