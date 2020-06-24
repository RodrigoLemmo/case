package br.com.catapi.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** CONSULTOR GERENICO DE ARQUIVOS DE PROPERTIES*/

public class UtilProperties {

	
	public  Properties getProperitesFile(String propFileName) throws IOException{

		Properties prop = new Properties();
		
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("Arquivo não encontrado de configuração:" + propFileName + "");
		}
		
		
		return prop;
	}
	
	
}
