package com.time06.escoladeti.infraestrutura.email;

/**
 * Encapsula e facilita a construção do e-mail a ser enviado pelo GerenciadorEmail.
 */
public class Email {

    private String para;
    private String assunto;
    private String mensagemHTML;

    public Email para(String para) {
        this.para = para;
        return this;
    }

    public Email comAssunto(String assunto) {
        this.assunto = assunto;
        return this;
    }

    public Email comMensagemHTML(String mensagemHTML) {
        this.mensagemHTML = mensagemHTML;
        return this;
    }

    public String getPara() {
        return para;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getMensagemHTML() {
        return mensagemHTML;
    }

}