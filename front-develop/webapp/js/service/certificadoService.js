app.service("certificadoService", ["$http", function($http){
	
	return	{
		inicializarCertificado : function(token, idUsuario, proprietario){
			return $http.post('/certificacao/new/' + idUsuario + '/' + proprietario, null, {headers: {'tokenUsuario': token}});
		},
		addDocumento : function(token, idCertificado, documento){
			return $http.post('/certificacao/' + idCertificado + '/addDocumento', documento, {headers: {'tokenUsuario': token}});
		}
	};

}]);