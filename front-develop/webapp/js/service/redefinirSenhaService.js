app.service("redefinirSenhaService", ["$http", function($http){

	return	{
		//Rota para validar e-mail com o back
		validaEmail : function(usuario) {
			return $http.post('/redefinirSenha', usuario);
		},
		//Rota para receber do back o id do usuário caso token seja valido
		recuperaUsuarioPorToken : function(token){
			return $http.post('/redefinirSenha/' + token , null);
		},
		//rota para encaminhar nova senha para back salvar
		redefinirSenha : function(redefinirSenhaCommand){
			return $http.post('/redefinirSenha/novaSenha' , redefinirSenhaCommand);
		},
	};	

}]);