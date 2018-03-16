app.service("certificarService", ["$http", function($http){
	
	return	{
		editar : function(token, usuario){
			return $http.put('/usuario' , usuario, {headers: {'tokenUsuario': token}});
		}
	};	

}]);