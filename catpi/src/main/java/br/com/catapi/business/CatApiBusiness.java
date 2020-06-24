package br.com.catapi.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import br.com.catapi.bean.CategoriaRetornoBean;
import br.com.catapi.bean.GatoRetornoBean;
import br.com.catapi.bean.RacaGatoBean;
import br.com.catapi.bean.RacaRetornoBean;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.integrador.apiclient.CatApiIntegrador;
import br.com.catpi.dao.CategoriaDao;
import br.com.catpi.dao.ImagemGatoRacaDao;
import br.com.catpi.dao.LoginDao;
import br.com.catpi.dao.RacaDao;

/**
 * 
 * Classe responsavel por geranciar as consultar para o serviço rest e persistir no banco de dados
 * */
public class CatApiBusiness {

	private CatApiIntegrador  catApiIntegrador = new CatApiIntegrador();
	private RacaDao racaDao = new RacaDao();
	private ImagemGatoRacaDao gatoDao  = new ImagemGatoRacaDao();
	private CategoriaDao categoriaDao = new CategoriaDao();
	private LoginDao loginDao = new LoginDao();
	
	
	
	public List<RacaRetornoBean> gravarTodasRacasGatos() throws BusinessException, TechnicalException{
		
	List<RacaRetornoBean>  listaRaca =  catApiIntegrador.listarRacas();

	for (RacaRetornoBean raca : listaRaca) {
		
		racaDao.gravarRaca(raca);
			
		}
	
		return listaRaca;	
		
	}
	
	public List<CategoriaRetornoBean> listarTodasCategorias () throws BusinessException, TechnicalException {
		
	List<CategoriaRetornoBean> listaCategorias = 	catApiIntegrador.listarCategorias();
	
	  for (CategoriaRetornoBean categoriaRetornoBean : listaCategorias) {
		  categoriaDao.gravarCategoria(categoriaRetornoBean);
	  	}
	
	  return listaCategorias;
	
		
	}
	
	
	public GatoRetornoBean gravarImagemPorX(Map<String, String> buscaX) throws BusinessException, TechnicalException{
		GatoRetornoBean gatoRetornoRest =  catApiIntegrador.consultarPorX(buscaX);

			return	gatoDao.gravarGato(gatoRetornoRest,buscaX);
			
	}
	
	public Boolean validarLogin(String authorizationHeader) throws BusinessException, TechnicalException{
		
	    String loginSenha = new String(DatatypeConverter.parseBase64Binary(authorizationHeader.replace("Basic ", "")));
	    String arrayLogin [] =  loginSenha.split(":");
	    
	    return loginDao.validarAcesso(arrayLogin[0],arrayLogin[1]);
	    
		
	}

	
	public List<GatoRetornoBean> gravarImagemPorRaca (Long quantidade) throws BusinessException, TechnicalException{

		//Lista Gatos por imagem;
		List<GatoRetornoBean> listaGatosRetorno = new ArrayList<GatoRetornoBean>();

		//Lista de Raças atualizada
		List<RacaRetornoBean> listaRacas =	gravarTodasRacasGatos();
				 
		
		 for (RacaRetornoBean raca : listaRacas) {
		
			 for (int i = 0; i < quantidade; i++) {
				 
				 HashMap<String, String> parametroPesqusisa = new HashMap<String, String>();
				 parametroPesqusisa.put("breed_id", raca.getId());
				 listaGatosRetorno.add(gravarImagemPorX(parametroPesqusisa)) ;
				 
			 }
		 }
	
		 return listaGatosRetorno;
	
	}
	
	
	
	public List<RacaGatoBean> listarRacas() throws BusinessException, TechnicalException{
		return racaDao.listarRacas();
	}

	public List<RacaGatoBean> listarInformacaoPorRaca(String idExterno) throws TechnicalException, BusinessException {

		return racaDao.listarInformacaoPorRaca(idExterno);
		
	}

	public List<RacaGatoBean> listarInformacaoPorTemperamento(
			String temperamento) throws TechnicalException, BusinessException {
		return racaDao.listarInformacaoPorTemperamento(temperamento);

	}

	public List<RacaGatoBean> listarInformacaoPorOrigem(String origem) throws TechnicalException, BusinessException {
		return racaDao.listarInformacaoPorOrigem(origem);
		
	}

	public List<GatoRetornoBean> gravarImagemCategoria(String categoria,Long quantidade) throws BusinessException, TechnicalException {

		List<GatoRetornoBean> listaGatosRetorno = new ArrayList<GatoRetornoBean>();
		
		 for (int i = 0; i < quantidade; i++) {
			 
			 HashMap<String, String> parametroPesqusisa = new HashMap<String, String>();
			 parametroPesqusisa.put("category_ids", categoria);
			 listaGatosRetorno.add(gravarImagemPorX(parametroPesqusisa)) ;
			 
		 }
		
		
		return listaGatosRetorno;
	}
			

}
