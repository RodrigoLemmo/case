package br.com.catapi.util;

import java.io.IOException;
import java.util.Properties;

import br.com.catapi.exception.BusinessException;

public class ConfiguracaoElasticData {

	private UtilProperties utilProperties = new UtilProperties();
	private String servidorUrl;

	public ConfiguracaoElasticData(String propFileName)
			throws BusinessException {

		Properties prop;
		try {
			prop = utilProperties.getProperitesFile(propFileName);

			servidorUrl = prop.getProperty("servidor.url");

		} catch (IOException e) {
			throw new BusinessException(BusinessException._001_NÃO_FOI_POSSÍVEL_CARREGAR_A_CONFIGURAÇÃO							+ propFileName);

		}

	}

	public UtilProperties getUtilProperties() {
		return utilProperties;
	}

	public void setUtilProperties(UtilProperties utilProperties) {
		this.utilProperties = utilProperties;
	}


	public String getServidorUrl() {
		return servidorUrl;
	}

	public void setServidorUrl(String servidorUrl) {
		this.servidorUrl = servidorUrl;
	}

}
