// app.service("privacidadeService", ["$http", function($http){
// 	return	{
// 		alterarSenha : function(token, usuario) {
// 			return $http.put('/privacidade' , usuario);
// 		},
// 		alterarEmail : function(token, usuario) {
// 			return $http.put('/privacidade', usuario, {headers: {'tokenUsuario': token}});
// 		},
// 		solicitarAlteracaoEmail : function(token, usuario) {
// 			return $http.put('/usuario/solicitar-alteracao-email', usuario, {headers: {'tokenUsuario': token}});
// 		},
// 		recuperaUsuarioPorToken : function(token){
// 			return $http.post('/usuario/alterar-email/' + token);
// 		}
// 	};
// }]);



app.service("privacidadeService", ["$http", function($http){
	return	{
		alterarSenha : function(token, usuario) {
			return $http.put('/usuario/alterar-senha' , usuario);
		},
		alterarEmail : function(token, usuario) {
			return $http.put('/usuario/alterar-email', usuario, {headers: {'tokenUsuario': token}});
		},
		solicitarAlteracaoEmail : function(token, usuario) {
			return $http.put('/usuario/solicitar-alteracao-email', usuario, {headers: {'tokenUsuario': token}});
		},
		recuperaUsuarioPorToken : function(token){
			return $http.post('/usuario/alterar-email/' + token);
		}
	};
}]);