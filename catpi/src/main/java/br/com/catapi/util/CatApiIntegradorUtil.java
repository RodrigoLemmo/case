package br.com.catapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.util.DataUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Motor de consulta da API
 * */

public class CatApiIntegradorUtil {
	
	static Logger logger = Logger.getLogger(CatApiIntegradorUtil.class.getName());

	

	public  static String requestAPIIntegrador (ConfiguracaoRequestGetBean conf, java.util.Map<String, String> parametrosConsulta ) throws BusinessException, TechnicalException {

		logger.info("--------------------------------------------------------------");
		logger.info("Inicio consulta"+ conf.getUrl() + "Data :" + DataUtil.dataHoraBrasileira(new Date()));		
		
		BufferedReader br = null;
		URL serverAddress;
		String json = "";
		br = null;
		
		
		try {
		
			
		serverAddress = new URL(formatUrl(conf.getUrl(),parametrosConsulta));
		System.setProperty(conf.getProtocoloTipo(), conf.getTls());
		HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod(conf.getTipo());
		connection.setRequestProperty(conf.getContentType(), conf.getContentTypeValue());
		connection.setRequestProperty(conf.getChatset(),conf.getChatsetValue() );
		connection.setRequestProperty( conf.getUserAgent(),conf.getUserAgenteValue());
		connection.connect();
		
		if (200 <= connection.getResponseCode()	&& connection.getResponseCode() <= 299) {	
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} else {
			
			br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			
			throw new TechnicalException("[0001] - ERRO TECNICO" + connection.getErrorStream());

		}
		json = org.apache.commons.io.IOUtils.toString(br);

		logger.info("--------------------------------------------------------------");
		logger.info("Fim consulta"+ conf.getUrl() + "Data :" + DataUtil.dataHoraBrasileira(new Date()));	
		
		} catch (IOException e) {

			throw new  BusinessException ("[0002] - ERRO DE FORMATAÇÃO DE URL");
		
		}catch(Exception e){
			
			throw new TechnicalException("[0001] - ERRO TECNICO" + e.getMessage());
		}
		
		
		return json;
	
	}
	

	public static List<?> convertJsonToList(String json,Class<?> className ) throws BusinessException{
	
		ObjectMapper mapper = new ObjectMapper();
		List<?> listObj;
		try {
			listObj = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, className));
		} catch (JsonParseException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_FORMAÇÃO_DE_RETORNO_DE_JSON);

			
		} catch (JsonMappingException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_MAPEAMENTO_DE_RETORNO_DE_JSON);

		} catch (IOException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_CONVERSAO_IO_DE_RETORNO_DE_JSON);

		}
	
		return  listObj;
	
	}
	
	public static Object convertJsonToObject(String json,Class<?> className ) throws BusinessException{
		ObjectMapper mapper = new ObjectMapper();
		Object obj = null;
		
		try {
			 obj =  mapper.readValue(json, className);
			
			
		} catch (JsonParseException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_FORMAÇÃO_DE_RETORNO_DE_JSON);

			
		} catch (JsonMappingException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_MAPEAMENTO_DE_RETORNO_DE_JSON);

		} catch (IOException e) {
			throw new  BusinessException (BusinessException._0003_ERRO_DE_CONVERSAO_IO_DE_RETORNO_DE_JSON);

		}
	
		return  obj;
		
	}
	
	private static String formatUrl (String url,  Map<String, String> parametrosConsulta){
		
		if(parametrosConsulta == null || parametrosConsulta.isEmpty()){
			
			return url;
			
		}else{
			
			List<String> keys = new  ArrayList<String>(parametrosConsulta.keySet());
			
			url += "?";
			
			for (String key : keys) {
				
				if(url.lastIndexOf("?") > 0){
					url += key +"="+parametrosConsulta.get(key);
				}else{
					url += "&"+ key +"="+parametrosConsulta.get(key);
				}
				
			}
			return url; 
			
		}
		
		
	}

}
