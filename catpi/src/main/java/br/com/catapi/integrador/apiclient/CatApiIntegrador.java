package br.com.catapi.integrador.apiclient;

import java.util.List;
import java.util.Map;

import br.com.catapi.bean.CategoriaRetornoBean;
import br.com.catapi.bean.GatoRetornoBean;
import br.com.catapi.bean.RacaRetornoBean;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.CatApiIntegradorUtil;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoRequestGetBean;

/**
 * INTEGRADOR RESPONSAVEL POR REALIZAR CONSULTA NA API CAT
 *  */
public class CatApiIntegrador {
	
	
	
	/**
	 * Listar categorias de gatos
	 * @throws BusinessException 
	 * @throws TechnicalException 
	 * */
	public List<CategoriaRetornoBean> listarCategorias () throws BusinessException, TechnicalException {
		
		ConfiguracaoRequestGetBean confCategoria = new ConfiguracaoRequestGetBean(ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_CATALOGO);
	 	String json =  CatApiIntegradorUtil.requestAPIIntegrador(confCategoria,null);
		@SuppressWarnings("unchecked")
		List<CategoriaRetornoBean> listaCategoriaRetorno = (List<CategoriaRetornoBean>) CatApiIntegradorUtil.convertJsonToList(json, CategoriaRetornoBean.class);
	 	return listaCategoriaRetorno;
		
	 	
	}
	
	/**
	 * Listar raças de gatos
	 * @throws BusinessException 
	 * @throws TechnicalException 
	 * */
	public List<RacaRetornoBean> listarRacas () throws BusinessException, TechnicalException {
		
		ConfiguracaoRequestGetBean confCategoria = new ConfiguracaoRequestGetBean(ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_RACAS);
		String json =  CatApiIntegradorUtil.requestAPIIntegrador(confCategoria,null);
		@SuppressWarnings("unchecked")
		List<RacaRetornoBean> listaRacasRetorno = (List<RacaRetornoBean>) CatApiIntegradorUtil.convertJsonToList(json, RacaRetornoBean.class);
		return listaRacasRetorno;
		
		
	}
	
	
	/**
	 * Consulta por raças de gatos
	 * @throws BusinessException 
	 * @throws TechnicalException 
	 * */	
  public GatoRetornoBean consultarPorX (Map<String, String>  parametrosConsulta ) throws BusinessException, TechnicalException{
	
	  	ConfiguracaoRequestGetBean confCategoria = new ConfiguracaoRequestGetBean(ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_BUSCAR);
		String json =  CatApiIntegradorUtil.requestAPIIntegrador(confCategoria,parametrosConsulta);
		@SuppressWarnings("unchecked")
		List<GatoRetornoBean> gatoRetornoBean = (List<GatoRetornoBean>) CatApiIntegradorUtil.convertJsonToList(json, GatoRetornoBean.class);
	  
		if(gatoRetornoBean.size() > 0){
			
			return gatoRetornoBean.get(0);
		}
		
	  return null;
  }
	
	
	

}
