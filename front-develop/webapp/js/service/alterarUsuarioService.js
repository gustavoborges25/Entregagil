app.service("alterarUsuarioService", ["$http", function($http){
	
	return	{
		editar : function(token, pessoa){
			return $http.put('/pessoa', pessoa, {headers: {'tokenUsuario': token}});
		},
		buscaCep: function(cep) {
			return $http.get('//cep.republicavirtual.com.br/web_cep.php?cep=' + cep + '&formato=json');
		},
		cadastrar : function(usuario){
			return $http.post('/usuario/alterar-usuario' , usuario);
		}
	};

}]);