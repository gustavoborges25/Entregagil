package com.time06.escoladeti.anuncio;

import com.time06.escoladeti.anuncio.command.carga.*;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioAnimalCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioDomesticoCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioTelefoniaCommand;
import com.time06.escoladeti.anuncio.command.mudanca.*;
import com.time06.escoladeti.anuncio.command.outro.CriarAnuncioOutroCommand;
import com.time06.escoladeti.anuncio.command.veiculo.*;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio.entity.AnuncioRetornoDTO;
import com.time06.escoladeti.anuncio.type.TipoSubcategoria;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@RestController
@RequestMapping("/anuncio")
@CrossOrigin(origins = "*")
public class AnuncioController {

    @Autowired
    private AnuncioService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/carro/{subcategoria}")
    public void criarAnuncioCarro(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCarroCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCarro(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/moto/{subcategoria}")
    public void criarAnuncioMoto(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMotoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMoto(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/barco/{subcategoria}")
    public void criarAnuncioBarco(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioBarcoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioBarco(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/caminhao/{subcategoria}")
    public void criarAnuncioCaminhao(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCaminhaoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCaminhao(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/agricola/{subcategoria}")
    public void criarAnuncioAgricola(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioAgricolaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioAgricola(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/esporte/{subcategoria}")
    public void criarAnuncioEsporte(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioEsporteCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioEsporte(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/veiculo/peca/{subcategoria}")
    public void criarAnuncioPeca(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioPecaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioPeca(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/residencial/{subcategoria}")
    public void criarAnuncioMudancaResidencial(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaResidencialCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaResidencial(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/sobrado/{subcategoria}")
    public void criarAnuncioMudancaSobrado(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaResidencialSobradoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaSobrado(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/apartamento/{subcategoria}")
    public void criarAnuncioMudancaApartamento(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaResidencialApartamentoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaApartamento(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/comercial/{subcategoria}")
    public void criarAnuncioMudancaComercial(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaComercialCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaComercial(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/escritorio/{subcategoria}")
    public void criarAnuncioMudancaComercialEscritorio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaComercialEscritorioCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaComercialEscritorio(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/mudanca/industrial/{subcategoria}")
    public void criarAnuncioMudancaComercialIndustrial(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioMudancaComercialIndustrialCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioMudancaComercialIndustrial(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/carga/{subcategoria}")
    public void criarAnuncioCarga(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCargaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCarga(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/carga/fracionada/{subcategoria}")
    public void criarAnuncioCargaFracionada(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCargaFracionadaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCargaFracionada(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/carga/completa/{subcategoria}")
    public void criarAnuncioCargaCompleta(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCargaCompletaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCargaCompleta(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/carga/fragil/{subcategoria}")
    public void criarAnuncioCargaFragil(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCargaFragilCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCargaFragil(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/carga/container/{subcategoria}")
    public void criarAnuncioCargaContainer(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioCargaContainerCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioCargaContainer(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/domestico/{subcategoria}")
    public void criarAnuncioDomesticoGeral(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioDomesticoCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioDomesticoGeral(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/telefonia/{subcategoria}")
    public void criarAnuncioTelefonia(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioTelefoniaCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioTelefonia(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/animal/{subcategoria}")
    public void criarAnuncioAnimal(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioAnimalCommand command, @PathVariable("subcategoria") String subcategoria) {
        service.criarAnuncioAnimal(command, TipoSubcategoria.porString(subcategoria));
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/outro")
    public void criarAnuncioOutro(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CriarAnuncioOutroCommand command) {
        service.criarAnuncioOutro(command, TipoSubcategoria.OUTROS);
    }



    @RequestMapping(method = RequestMethod.GET)
    public List<Anuncio> pesquisar() {
        return service.pesquisar();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ultimos")
    public List<Anuncio> getUltimosDozeAnuncios() {
        return service.getUltimosDozeAnuncios();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AnuncioRetornoDTO pesquisar(@PathVariable String id) throws IllegalAccessException {
        Anuncio anuncio = service.pesquisar(id);

        Class clazz = anuncio.getItem().getClass();

        List<Map<String, Object>> result = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            HashMap hashMap = new HashMap();
            hashMap.put(fields[i].getAnnotation(NomeFrontEnd.class).nome(), fields[i].get(anuncio.getItem()).toString());
            result.add(hashMap);
        }

        return new AnuncioRetornoDTO(anuncio, result);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/pessoa/{idPessoa}")
    public List<Anuncio> pesquisarAnunciosDaPessoa(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idPessoa") String idPessoa) {
        return service.pesquisarAnunciosDaPessoa(idPessoa);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/transportador/{idPessoa}")
    public List<Anuncio> pesquisarAnunciosQuePessoaTransporta(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idPessoa") String idPessoa) {
        return service.pesquisarAnunciosQuePessoaTransporta(idPessoa);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categoria/{nomeCategoria}")
    public List<Anuncio> pesquisarAnunciosComItensDestaCategoria(@PathVariable String nomeCategoria) {
        return service.pesquisarAnunciosComItensDestaCategoria(nomeCategoria);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query/{query}")
    public List<Anuncio> pesquisarAnunciosPorQuery(@PathVariable String query) {
        return service.pesquisarAnunciosPorQuery(query);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/qtde-cadastrados/{idAnunciante}")
    public Integer getQuantidadeAnunciosCadastradosPeloAnunciante(@PathVariable String idAnunciante) {
        return service.getQuantidadeAnunciosCadastradosPeloAnunciante(idAnunciante);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/qtde-transportados/{idTransportador}")
    public Integer getQuantidadeAnunciosTransportadosPeloTransportador(@PathVariable String idTransportador) {
        return service.getQuantidadeAnunciosTransportadosPeloTransportador(idTransportador);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.DELETE, value = "/{idAnuncio}")
    public void cancelarAnuncio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAnuncio") String idAnuncio) {
        service.cancelarAnuncio(idAnuncio);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.DELETE, value = "/transporte/{idAnuncio}")
    public void cancelarFreteEmAnuncio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAnuncio") String idAnuncio) {
        service.cancelarTransporte(idAnuncio);
    }

}