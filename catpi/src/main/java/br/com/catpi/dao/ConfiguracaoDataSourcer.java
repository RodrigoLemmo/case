package br.com.catpi.dao;

import java.io.IOException;
import java.util.Properties;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.util.UtilProperties;

public class ConfiguracaoDataSourcer {

	private UtilProperties utilProperties = new UtilProperties();
	private String url;
	private String userName;
	private String password;
	private String driveClasse;

	public ConfiguracaoDataSourcer (String propFileName) throws BusinessException{
		
		Properties prop;
		try {
			prop = utilProperties.getProperitesFile(propFileName);
		

			url = prop.getProperty("datasoucer.jdbcurl");
			userName = prop.getProperty("datasoucer.username");
			password = prop.getProperty("datasoucer.password");
			driveClasse = prop.getProperty("datasoucer.driveclasse");
			} catch (IOException e) {
				throw new BusinessException (BusinessException._001_NÃO_FOI_POSSÍVEL_CARREGAR_A_CONFIGURAÇÃO + propFileName );
			
			}
		
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public UtilProperties getUtilProperties() {
		return utilProperties;
	}


	public void setUtilProperties(UtilProperties utilProperties) {
		this.utilProperties = utilProperties;
	}


	public String getDriveClasse() {
		return driveClasse;
	}


	public void setDriveClasse(String driveClasse) {
		this.driveClasse = driveClasse;
	}
	
	
	
	
}
