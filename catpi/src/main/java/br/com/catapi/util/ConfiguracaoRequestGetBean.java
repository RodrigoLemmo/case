package br.com.catapi.util;

import java.io.IOException;
import java.util.Properties;

import br.com.catapi.exception.BusinessException;

public class ConfiguracaoRequestGetBean {

	private UtilProperties utilProperties = new UtilProperties();

	public ConfiguracaoRequestGetBean(String propFileName) throws BusinessException {

		Properties prop;
		try {
			prop = utilProperties.getProperitesFile(propFileName);
		

		protocoloTipo = prop.getProperty("cat.api.conf.procolo.tipo");
		tls = prop.getProperty("cat.api.conf.tls");
		tipo = prop.getProperty("cat.api.conf.tipo");
		contentType = prop.getProperty("cat.api.conf.content.type");
		contentTypeValue = prop.getProperty("cat.api.conf.content.type.value");
		chatset = prop.getProperty("cat.api.conf.chatset");
		chatsetValue = prop.getProperty("cat.api.conf.chatset.value");
		userAgent = prop.getProperty("cat.api.conf.useragent");
		userAgenteValue = prop.getProperty("cat.api.conf.useragente.value");
		url = prop.getProperty("cat.api.conf.url");
		
		} catch (IOException e) {
			throw new BusinessException ("[001] - NÃO FOI POSSÍVEL CARREGAR A CONFIGURAÇÃO:" + propFileName );
		
		}

	}

	private String protocoloTipo;
	private String tls;
	private String tipo;
	private String contentType;
	private String contentTypeValue;
	private String chatset;
	private String chatsetValue;
	private String userAgent;
	private String userAgenteValue;
	private String url;

	public String getProtocoloTipo() {
		return protocoloTipo;
	}

	public void setProtocoloTipo(String protocoloTipo) {
		this.protocoloTipo = protocoloTipo;
	}

	public String getTls() {
		return tls;
	}

	public void setTls(String tls) {
		this.tls = tls;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentTypeValue() {
		return contentTypeValue;
	}

	public void setContentTypeValue(String contentTypeValue) {
		this.contentTypeValue = contentTypeValue;
	}

	public String getChatset() {
		return chatset;
	}

	public void setChatset(String chatset) {
		this.chatset = chatset;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgenteValue() {
		return userAgenteValue;
	}

	public void setUserAgenteValue(String userAgenteValue) {
		this.userAgenteValue = userAgenteValue;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChatsetValue() {
		return chatsetValue;
	}

	public void setChatsetValue(String chatsetValue) {
		this.chatsetValue = chatsetValue;
	}
	

}
