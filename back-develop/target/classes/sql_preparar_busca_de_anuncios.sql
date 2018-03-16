-- CRIANDO FUNÇÕES PARA CONVERTER TEXTO PARA BUSCA
CREATE FUNCTION to_ascii(bytea, name) RETURNS text AS 'to_ascii_encname' LANGUAGE internal STRICT;
CREATE FUNCTION simples(texto varchar) RETURNS varchar AS 'select lower(to_ascii(convert_to($1, ''latin1''), ''latin1''))' LANGUAGE sql IMMUTABLE STRICT;

-- PREPARANDO TABELA PESSOA
ALTER TABLE pessoa ADD b_nome tsvector;
CREATE INDEX b_pessoa_nome_gidx ON pessoa USING gin(b_nome);

ALTER TABLE pessoa ADD b_sobrenome tsvector;
CREATE INDEX b_pessoa_sobrenome_gidx ON pessoa USING gin(b_sobrenome);

-- PREPARANDO TABELA ENDERECO
ALTER TABLE endereco ADD b_cidade tsvector;
CREATE INDEX b_cidade_gidx ON endereco USING gin(b_cidade);

-- PREPARANDO TABELA ANUNCIO
ALTER TABLE anuncio ADD b_contato_origem tsvector;
CREATE INDEX b_contato_origem_gidx ON anuncio USING gin(b_contato_origem);

ALTER TABLE anuncio ADD b_contato_destino tsvector;
CREATE INDEX b_contato_destino_gidx ON anuncio USING gin(b_contato_destino);

ALTER TABLE anuncio ADD b_titulo tsvector;
CREATE INDEX b_titulo_gidx ON anuncio USING gin(b_titulo);

-- PREPARANDO TABELA ITENS
ALTER TABLE anuncio_item ADD b_observacao tsvector;
CREATE INDEX b_observacao_gidx ON anuncio_item USING gin(b_observacao);


-- PREENCHENDO OS CAMPOS QUE SERÃO UTILIZADOS NA BUSCA
UPDATE pessoa SET b_nome = to_tsvector(simples(nome));
UPDATE pessoa SET b_sobrenome = to_tsvector(simples(sobrenome));
UPDATE endereco SET b_cidade = to_tsvector(simples(cidade));
UPDATE anuncio SET b_contato_origem = to_tsvector(simples(contato_origem));
UPDATE anuncio SET b_contato_destino = to_tsvector(simples(contato_destino));
UPDATE anuncio_item SET b_observacao = to_tsvector(simples(observacao));