app.service("loginService", ["$http", function($http) {
	
	baseUrl = '/login';

	return	{
		logar : function(usuario) {
			return $http.post(baseUrl, usuario);
		}
	};	

}]);