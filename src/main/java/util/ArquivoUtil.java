package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import entidade.Retorno;

public class ArquivoUtil {
	
	public static Retorno escrever(String nome, byte[] contents, String nomeUsuario) throws IOException {
		File file = new File(diretorioArquivo(nomeUsuario), nome);
		OutputStream saida = new FileOutputStream(file);
		
		Retorno result = new Retorno(file,file.getPath(),true);
		// Grava od bytes
		saida.write(contents);
		saida.close();
		
		return result;
	}
	
	public static File diretorioArquivo(String usuarioNome){
		File dir = new File(diretorioRaiz(), usuarioNome);
		
		// Se o diretorio n�o existir
				if(!dir.exists()){
					// Cria o diret�rio do arquivo
					dir.mkdirs();
				}
			System.out.println("diretorioArquivo " + dir);
			return dir;
	}
	
	public static File diretorioRaiz() {
		File dir = new File(System.getProperty("java.io.tmpdir"), "ArquivoBoletoUsuarios");
		
		// Se o diretorio n�o existir
		if(!dir.exists()){
			// Cria o diret�rio do arquivo
			dir.mkdirs();
		}
		System.out.println("diretorioRaiz " +  dir);
		return dir;
	}
	
}
