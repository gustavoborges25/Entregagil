package com.time06.escoladeti.infraestrutura.criptografia;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public abstract class CriptografarSenha {
 
	private static final String SALT = "entregÁgil-escoladeti-time06";
	
	public static String gerarSenhaCriptografada(String senha) {
		return getTipoDeCodificacao().encodePassword(senha, SALT);
	} 
 
	private static MessageDigestPasswordEncoder getTipoDeCodificacao() {
		return new MessageDigestPasswordEncoder("MD5");
    }
 
    public static boolean validarSenhar(String senha, String hashPassword) {
        return getTipoDeCodificacao().isPasswordValid(hashPassword, senha, SALT);
    }

}