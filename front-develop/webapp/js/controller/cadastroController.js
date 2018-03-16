app.controller('cadastroController', ['$scope', '$location', '$rootScope','$localStorage','cadastroService', function($scope, $location, $rootScope, $localStorage, cadastroService){

	$scope.init = function(){
		$rootScope.showMenuUsuario = false;
		$rootScope.telaLogin = false;
		$scope.usuario = {};
		$scope.acao = "cadastrar";
		$scope.tipoForm = 'fisica';
		$scope.errorSenha = false;
		$scope.errorEmail = false;
		$scope.submitCadastro = false;
	};

	$scope.salvar = function(){
		if($scope.errorSenha & $scope.errorEmail){
			$.snackbar({content: "Campos incorretos", style: "toast erro"});
		}else{
			$scope.submitCadastro = true;
			$scope.usuario.tipoPessoa = $scope.tipoForm;
			$scope.usuario.foto = $('#imgUsuario').prop('src');
		cadastroService.cadastrar($scope.usuario).success(function(data){
			cadastroService.requisitaToken($scope.usuario).success(function(data){
				$localStorage.usuarioLogado = data;
				$rootScope.logado = true;
				$rootScope.usuarioLogado = $localStorage.usuarioLogado;
			})
			$.snackbar({content: "Usuário cadastrado com sucesso.", style: "toast sucesso"});
			$location.path('/usuario/certificar');
		}).error(function(data,status){
			$scope.submitCadastro = false;
			$.snackbar({content: data.message, style: "toast erro"});
		})
		}
	};

	$scope.validarTamanhoSenha = function(strSenha){
		$scope.errorSenha = false;

		if(strSenha == null || (strSenha.length < 6
			|| strSenha.length > 12)){
				$scope.errorSenha = true;
				$.snackbar({content: 'Senha deve conter de 6 à 12 dígitos.', style: "toast erro"});
				return false;
			}
			return true;
			$scope.errorSenha = false;
	};

	$scope.validaSenha = function(){
		$scope.errorSenha = false;

		var tamanhoCorreto = $scope.validarTamanhoSenha($scope.usuario.confirmacaoSenha);

		if (!tamanhoCorreto)
			return;

		if($scope.usuario.senha == $scope.usuario.confirmacaoSenha){
			return true;
			$scope.errorSenha = false;
		}else {
			$.snackbar({content: 'Senhas não são iguais.', style: "toast erro"});
			$scope.errorSenha = true;
			return false;
		}
	};


	$scope.validaEmail = function(){
		$scope.errorEmail = false;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(!filter.test($scope.usuario.email)){
			$scope.errorEmail = true;
			$.snackbar({content: 'Campo e-mail está incorreto', style: "toast erro"});
			return false
		}
	}

	$scope.validarCampo = function(campo, nomeCampo){
		var campo = document.getElementById(campo).value;

		if (campo == "") {
			$scope.errorCampo = true;
			$.snackbar({content: 'Campo ' + nomeCampo +  ' obrigatório.', style: "toast erro"});
			campo.focus();
		}
		$scope.errorCampo = false;
	}

	$scope.buscaCep = function(cep){

		cepNaoNulo = $scope.validarCampoObrigatorio('Cep', '#cep');

		if (!cepNaoNulo)
			return;

		if (cep.length > 8) {
            cadastroService.buscaCep(cep).success(function(data){

            	if (data.resultado_txt == "sucesso - cep não encontrado") {
            		$.snackbar({content: 'CEP não encontrado.', style: "toast erro"});
            		return;
            	}

            	$scope.usuario.endereco = data.tipo_logradouro +" "+ data.logradouro;
            	$scope.usuario.bairro = data.bairro;
            	$scope.usuario.cidade = data.cidade;
            	$scope.usuario.estado = data.uf;


            }).error(function(data,status){
            	$.snackbar({content: 'Não foi possível buscar o CEP, tente novamente.', style: "toast erro"});
            })
        }
        else
		$.snackbar({content: 'Campo CEP incorreto.', style: "toast erro"});
	}

	$scope.verificarCpf = function(strCPF, campo) {
		var cpfValido = validarCpf(strCPF, campo);

		setarCampoErro(campo, cpfValido, "CPF inválido.");
	}

	function validarCpf(strCPF, campo) {
	    var Soma;
	    var Resto;
	    Soma = 0;

	    if (strCPF == null)
	    	return false;
	    strCPF = removeMask(strCPF, 11);

	    if (strCPF.length != 11 || strCPF == "00000000000") return false;
	    for (i = 1; i <= 9; i++)
	    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
	    Resto = (Soma * 10) % 11;
	    if ((Resto == 10) || (Resto == 11)) Resto = 0;
	    if (Resto != parseInt(strCPF.substring(9, 10))) return false;
	    Soma = 0;
	    for (i = 1; i <= 10; i++)
	    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
	    Resto = (Soma * 10) % 11;
	    if ((Resto == 10) || (Resto == 11)) Resto = 0;
	    if (Resto != parseInt(strCPF.substring(10, 11))) return false;

	    return true;
	};

	function removeMask(strValue) {

		strValue = strValue.replace(".", "");
		strValue = strValue.replace(".", "");
		strValue = strValue.replace("-", "");
		strValue = strValue.replace("/", "");
		strValue = strValue.replace("/", "");

	    return strValue;
	}

	$scope.verificarCnpj = function(strCNPJ, campo) {
		var cnpjValido = validarCnpj(strCNPJ);

		setarCampoErro(campo, cnpjValido, "CNPJ inválido.");
	}

	function validarCnpj(cnpj) {
	 	if (cnpj == null)
		    return false;

	    cnpj = cnpj.replace(/[^\d]+/g,'');

	    if(cnpj == '') return false;

	    if (cnpj.length != 14)
	        return false;

	    // Elimina CNPJs invalidos conhecidos
	    if (cnpj == "00000000000000" ||
	        cnpj == "11111111111111" ||
	        cnpj == "22222222222222" ||
	        cnpj == "33333333333333" ||
	        cnpj == "44444444444444" ||
	        cnpj == "55555555555555" ||
	        cnpj == "66666666666666" ||
	        cnpj == "77777777777777" ||
	        cnpj == "88888888888888" ||
	        cnpj == "99999999999999")
	        return false;

	    tamanho = cnpj.length - 2
	    numeros = cnpj.substring(0,tamanho);
	    digitos = cnpj.substring(tamanho);
	    soma = 0;
	    pos = tamanho - 7;
	    for (i = tamanho; i >= 1; i--) {
	      soma += numeros.charAt(tamanho - i) * pos--;
	      if (pos < 2)
	            pos = 9;
	    }
	    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	    if (resultado != digitos.charAt(0))
	        return false;

	    tamanho = tamanho + 1;
	    numeros = cnpj.substring(0,tamanho);
	    soma = 0;
	    pos = tamanho - 7;
	    for (i = tamanho; i >= 1; i--) {
	      soma += numeros.charAt(tamanho - i) * pos--;
	      if (pos < 2)
	            pos = 9;
	    }
	    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	    if (resultado != digitos.charAt(1))
	          return false;

	    return true;
	}

	$scope.validarCampoObrigatorio = function(nomeCampo, campo) {
		var strCampo = $(campo).val();
		var campoValido = strCampo != null && strCampo != "";
		setarCampoErro(campo, campoValido, nomeCampo + " obrigatório.");
		return campoValido;
	}

	function setarCampoErro(campo, campoValido, msgErro) {

		if (campoValido) {
			$(campo).removeClass('error');
		}
		else {
			$(campo).addClass('error');
			$.snackbar({content: 'Campo ' + msgErro, style: "toast erro"});
		}
	}
}])
