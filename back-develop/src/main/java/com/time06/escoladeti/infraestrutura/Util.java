package com.time06.escoladeti.infraestrutura;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe que contém códigos úteis utilizados entre o sistema inteiro.
 */

@Component
public final class Util {
	
	@Autowired
	private ServletContext context;
	
	private  static String diretorioAbsoluto; 

	public static String diretorioDeImagem; 
	 
	@Value("${diretorio.de.imagens}")
	private void setDiretorioDeImagem(String diretorio) {
		diretorioDeImagem = diretorio;
		diretorioAbsoluto = context.getRealPath("/" + diretorioDeImagem);
	};
	
    private Util() {
    }

    public static Boolean vazio(String string) {
        return (string == null || string.isEmpty());
    }
	
	public static String saveImage(String foto) {
		try {
			
 			String[] fotoNova = foto.split(",");
			byte[] imagemByte = Base64.decodeBase64(fotoNova[1]);
			ByteArrayInputStream bis = new ByteArrayInputStream(imagemByte);
			BufferedImage image = ImageIO.read(bis);
			
			if (image == null)
				throw new ImagemIOException();
			
			bis.close();
			String nome = UUID.randomUUID().toString() + ".png";
			String caminho = diretorioAbsoluto + "/" + nome;
			
			File file = new File(caminho);
			ImageIO.write(image, "png", file);
			
			return diretorioDeImagem + "/" + nome;
				
		} catch (Exception e) {
			throw new FileImagemException();
		}
	}
	
	public static void deleteImage(String diretorio) {
		File file = new File(diretorio);
		file.delete();
	}
	
}