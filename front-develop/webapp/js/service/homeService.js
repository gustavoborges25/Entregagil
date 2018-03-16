app.service("homeService", ["$http", function($http){
	/*URL BASE DO SERVIDOR*/
	baseUrl = '/usuario';
	
	return	{
		listar : function(){
			return $http.get(baseUrl);//ROTA BACKEND
		},
		cadastrar : function(usuario){
			return $http.post(baseUrl , usuario);//ROTA BACKEND
		},
		excluir : function(id){
			return $http.delete(baseUrl +'/'+ id);//ROTA BACKEND
		},
		editar : function(usuario){
			return $http.put(baseUrl, usuario);//ROTA BACKEND
		},
		listaUm : function(id){
			return $http.get(baseUrl +'/'+ id);//ROTA BACKEND
		} 
	};	

}]);