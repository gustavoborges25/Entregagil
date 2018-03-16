package com.time06.escoladeti.infraestrutura.criptografia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class CriptografarString 
{
	private static final String CHAVE_SECRETA = "entregAgilescoladetitime06";
    static Cipher ecipher;
    static Cipher dcipher;
    static byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    
    static int iterationCount = 19;
    
    public static String criptografar(String texto) {

		try {
			KeySpec keySpec = new PBEKeySpec(CHAVE_SECRETA.toCharArray(), salt, iterationCount);
	        SecretKey key;
			key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

	        ecipher = Cipher.getInstance(key.getAlgorithm());
	        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);      
	        String charSet="UTF-8";       
	        byte[] in = texto.getBytes(charSet);
	        byte[] out = ecipher.doFinal(in);
	        @SuppressWarnings("restriction")
			String encStr = new sun.misc.BASE64Encoder().encode(out);
	        return encStr;
			
		} catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException 
				| InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException 
				| BadPaddingException | UnsupportedEncodingException e) {
			
			throw new CriptografarStringException();
		}         
    }

	public static String descriptografar(String textoCriptografado) {
		try {
			KeySpec keySpec = new PBEKeySpec(CHAVE_SECRETA.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			dcipher = Cipher.getInstance(key.getAlgorithm());
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

			@SuppressWarnings("restriction")
			byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(textoCriptografado);
			byte[] utf8 = dcipher.doFinal(enc);
			String charSet = "UTF-8";
			String plainStr = new String(utf8, charSet);
			return plainStr;

		} catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {

			throw new DescriptografarStringException();
		}
	}
}
