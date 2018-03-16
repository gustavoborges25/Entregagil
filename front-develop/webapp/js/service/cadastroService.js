app.service("cadastroService", ["$http", function($http){

	return	{
		cadastrar : function(usuario){
			return $http.post('/usuario/cadastrar-usuario', usuario);
		},
		buscaCep: function(cep){
			return  $http.get('//cep.republicavirtual.com.br/web_cep.php?cep='+cep+'&formato=json');
		},
		requisitaToken : function(usuario) {
			return $http.post('/login', usuario);
		}
	};	

}]);