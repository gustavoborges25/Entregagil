app.controller('certificadoController', ['$scope', '$location', '$rootScope', '$localStorage', 'certificadoService', function($scope, $location, $rootScope, $localStorage, certificadoService) {

	$scope.idCertificadoUsuario;
	$scope.certificado = {};
	$scope.certificado.documentos = [];

	$scope.init = function() {
		$rootScope.telaLogin = false;
		$rootScope.showRodape = false;
		$rootScope.showMenuUsuario = false;
		//INICIACAO VARIAVEIS FUNCAO BARRA DE PROGRESSO
		ultimoBotao = '';
		porcentagem = 0;
		clicouBotao1 = false;
		clicouBotao2 = false;
		clicouBotao3 = false;
		clicouBotao4 = false;
		clicouBotao5 = false;
		clicouBotao6 = false;
		clicouBotao7 = false;
		$scope.noimages = true;
		//busca do usuario logado qual o tipo, fisico ou juridico
		// console.log($localStorage.usuarioLogado.usuario.pessoa);
		$scope.tipoForm = $localStorage.usuarioLogado.usuario.pessoa.tipoPessoa;
		certificadoService.inicializarCertificado($localStorage.usuarioLogado.token, $localStorage.usuarioLogado.usuario.id, false)
			.success(function(certificado){
				// console.log('Cadastrou CertificadoUsuario com ID: ' + certificado.id);
				$scope.idCertificadoUsuario = certificado.id;
			})
			.error(function(data){
				// console.log('Deu erro: ' + data.message);
				$.snackbar({content: data.message, style: "toast erro"});
			})
	};

	$scope.addDocumento = function () {
		// var documento = {
		// 	"nome" : "CNH - Carteira Nacional de Habilitação",
		// 	"arquivo" : $scope.fileModel.base64
		// };
        if ($localStorage.usuarioLogado.usuario.pessoa.tipoPessoa == "fisica") {
			$scope.certificado.documentos = [
				{
					"nome" : "CNH - Carteira Nacional de Habilitação",
					"arquivo" : $scope.certificado.carteiraMotorista.base64

				},
				{
					"nome" : "Comprovante de Endereço - Conta de Água, Luz ou Telefone",
					"arquivo" : $scope.certificado.comprovanteEndereco.base64
				},
				{
					"nome" : "CRLV - Certificado Registro e Licenciamento do veiculo",
					"arquivo" : $scope.certificado.crlv.base64
				}
			]		
		} else {
			$scope.certificado.documentos = [
				{
					"nome" : "Contrato Social e Alteraçõe",
					"arquivo" : $scope.certificado.contratoSocial.base64
				},
				{
					"nome" : "Cartão do CNPJ",
					"arquivo" : $scope.certificado.cartaoCnpj.base64
				},
				{
					"nome" : "Alvara de Funcionamento",
					"arquivo" : $scope.certificado.alvaraFuncionamento.base64
				},
				{
					"nome" : "CPF e RG do(s) Sócios(s)",
					"arquivo" : $scope.certificado.cpfRg.base64
				}
			]
		}
		
		certificadoService.addDocumento($localStorage.usuarioLogado.token, $scope.idCertificadoUsuario, $scope.certificado.documentos)
			.success(function(result){
				// console.log('Adicionou documento!');
				$location.path('/#/');
			})
			.error(function(data){
				// console.log('Deu erro: ' + data.message);
				$.snackbar({content: data.message, style: "toast erro"});
			})
	};

	// $scope.validarCampoObrigatorio = function(nomeCampo, campo) {
	// 	var strCampo = $(campo).val();
	// 	var campoValido = strCampo != null && strCampo != "";
	// 	setarCampoErro(campo, campoValido, nomeCampo + " obrigatório.");
	// 	return campoValido;
	// }

	$scope.validaFormComImagem = function(botao, p, campo){
		var strCampo = $(campo).val();
		var campoValido = strCampo != null && strCampo != "";
		setarCampoErro(campo, campoValido, 'Imagem' + " obrigatório.");

		$scope.barraProgresso(botao,p);
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

	$scope.removeBarra = function(btn, qtd){
		
		pAtual = porcentagem - qtd;
		porcentagem = pAtual;

    	setTimeout(function () { 
			$('.cont').css('width', porcentagem+'%');
		}, 500);

    	$scope.verificaPorcentagem();
    	//Fazer isso para cada botao 
    	if(btn = 'btnUm'){
    		$scope.clicouBotao1 = false;
    	}
    	if(btn = 'btnDois'){
    		$scope.clicouBotao2 = false;
    	}
    	if(btn = 'btnTres'){
    		$scope.clicouBotao3 = false;
    	}
    	if(btn = 'btnQuatro'){
    		$scope.clicouBotao4 = false;
    	}
    	if(btn = 'btnCinco'){
    		$scope.clicouBotao5 = false;
    	}
    	if(btn = 'btnSeis'){
    		$scope.clicouBotao6 = false;
    	}
    	if(btn = 'btnSete'){
    		$scope.clicouBotao7 = false;
    	}

    	
	}

	$scope.barraProgresso = function(botao, p){
	   	if ((botao == 'btnUm' && $scope.clicouBotao1)
	   		|| (botao == 'btnDois' && $scope.clicouBotao2)
	   		|| (botao == 'btnTres' && $scope.clicouBotao3)
	   		|| (botao == 'btnQuatro' && $scope.clicouBotao4)
	   		|| (botao == 'btnCinco' && $scope.clicouBotao5)
	   		|| (botao == 'btnSeis' && $scope.clicouBotao6)
	   		|| (botao == 'btnSete' && $scope.clicouBotao7)) {
	   		// console.log('botao repetido');
	   		temp = porcentagem - p;
	   		// console.log('porcentagem temporaria' + temp);
	    	$('.cont').css('width', temp+'%');
		
	    	setTimeout(function () { 
				$('.cont').css('width', porcentagem+'%');
    		}, 1000);
	   	}else{
	   		// console.log('novo botao');
	   		porcentagem += p;
	    	$('.cont').css('width', porcentagem+'%');
	   		
	   		if (!$scope.clicouBotao1 && botao == 'btnUm') {
				$scope.clicouBotao1 = true;
			}
			if (!$scope.clicouBotao2 && botao == 'btnDois') {
				$scope.clicouBotao2 = true;
			}
			if (!$scope.clicouBotao3 && botao == 'btnTres') {
				$scope.clicouBotao3 = true;
			}
			if (!$scope.clicouBotao4 && botao == 'btnQuatro') {
				$scope.clicouBotao4 = true;
			}
			if (!$scope.clicouBotao5 && botao == 'btnCinco') {
				$scope.clicouBotao5 = true;
			}
			if (!$scope.clicouBotao6 && botao == 'btnSeis') {
				$scope.clicouBotao6 = true;
			}
			if (!$scope.clicouBotao7 && botao == 'btnSete') {
				$scope.clicouBotao7 = true;
			}
	   	}
	   	//CADA VEZ QUE UMA IMAGEM É INSERIDA EU CHAMO A FUNCAO PARA VERIFICAR QUAL A PORCENTAGEM
	   	$scope.verificaPorcentagem();
	   


	}
	//FUNCAO QUE VERIFICA SE A PORCENTAGEM ATINGIU 99 OU SEJA SE TODAS AS IMAGENS FORAM UPLOADS
	$scope.verificaPorcentagem = function(){
		// console.log(porcentagem);
		if(porcentagem == 99.99 || porcentagem == 100){
			$scope.noimages = false;
		}else {
			$scope.noimages = true;
		}
	}




	!function(e)
	{var t=function(t,n){this.$element=e(t),this.type=this.$element.data("uploadtype")
	||(this.$element.find(".thumbnail").length>0?"image":"file"),this.$input=this.$element.find(":file");
	if(this.$input.length===0)return;this.name=this.$input.attr("name")
	||n.name,this.$hidden=this.$element.find('input[type=hidden][name="'+this.name+'"]'),this.$hidden.length===0&&(this.$hidden=e('<input type="hidden" />'),
	this.$element.prepend(this.$hidden)),
	this.$preview=this.$element.find(".fileupload-preview");
	var r=this.$preview.css("height");this.$preview.css("display")!="inline"&&r!="0px"&&r!="none"&&this.$preview.css("line-height",r),
	this.original={exists:this.$element.hasClass("fileupload-exists"),preview:this.$preview.html(),hiddenVal:this.$hidden.val()},this.$remove=this.$element.find
	('[data-dismiss="fileupload"]'),this.$element.find('[data-trigger="fileupload"]').on("click.fileupload",e.proxy(this.trigger,this)),this.listen()};t.prototype={listen:function(){this.$input.on
	("change.fileupload",e.proxy(this.change,this)),e(this.$input[0].form).on
	("reset.fileupload",e.proxy(this.reset,this)),this.$remove&&this.$remove.on("click.fileupload",e.proxy(this.clear,this))},
	change:function(e,t)
	{if(t==="clear")return;var n=e.target.files!==undefined?e.target.files[0]:e.target.value?{name:e.target.value.replace(/^.+\\/,"")}:null;
	if(!n){this.clear();return}this.$hidden.val(""),this.$hidden.attr("name",""),this.$input.attr("name",this.name);
	if(this.type==="image"&&this.$preview.length>0&&(typeof n.type!="undefined"?n.type.match("image.*"):n.name.match(/\.(gif|png|jpe?g)$/i))&&typeof FileReader!="undefined")
	{var r=new FileReader,i=this.$preview,s=this.$element;r.onload=function(e){i.html('<img src="'+e.target.result+'" '+(i.css("max-height")!="none"?'style="max-height: '+i.css("max-height")+';"':"")+" />"),
    s.addClass("fileupload-exists").removeClass("fileupload-new")},r.readAsDataURL(n)}else this.$preview.text(n.name),this.$element.addClass("fileupload-exists").removeClass("fileupload-new")},
    clear:function(e){this.$hidden.val(""),this.$hidden.attr("name",this.name),this.$input.attr("name","");if(navigator.userAgent.match(/msie/i))
    {var t=this.$input.clone(!0);this.$input.after(t),this.$input.remove(),this.$input=t}else this.$input.val("");this.$preview.html(""),this.$element.addClass("fileupload-new").removeClass("fileupload-exists"),
    e&&(this.$input.trigger("change",["clear"]),e.preventDefault())},
    reset:function(e){this.clear(),this.$hidden.val(this.original.hiddenVal),this.$preview.html(this.original.preview),this.original.exists?this.$element.addClass("fileupload-exists").removeClass("fileupload-new"):
    this.$element.addClass("fileupload-new").removeClass("fileupload-exists")},
    trigger:function(e){this.$input.trigger("click"),e.preventDefault()}},e.fn.
    fileupload=function(n){return this.each(function(){var r=e(this),i=r.data("fileupload");i||r.data("fileupload",i=new t(this,n)),typeof n=="string"&&i[n]()})},e.fn.fileupload.Constructor=t,
    e(document).on("click.fileupload.data-api",'[data-provides="fileupload"]',function(t){var n=e(this);if(n.data("fileupload"))return;n.fileupload(n.data());
	var r=e(t.target).closest('[data-dismiss="fileupload"],[data-trigger="fileupload"]');r.length>0&&(r.trigger("click.fileupload"),t.preventDefault())})}(window.jQuery)

}]);