package br.com.catpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import br.com.catapi.bean.GatoRetornoBean;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoDataSourcer;

public class ImagemGatoRacaDao {

	private ConfiguracaoDataSourcer dataSourcer ;
	private CategoriaDao categoriaDao = new CategoriaDao();
	private RacaDao racaDao = new RacaDao();

	public GatoRetornoBean gravarGato(GatoRetornoBean gatoRetornoBean, Map<String, String> buscaX) throws BusinessException, TechnicalException {
		
		try {
			dataSourcer = new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER);
		Connection conexao = 	Dao.getConection(dataSourcer);
			
		if(localizarRacaPorUrl(gatoRetornoBean)){
			
			return gatoRetornoBean;
			
		}
			
		PreparedStatement psmt = conexao.prepareStatement(ImagemGatoRacaQueryDao.QUERY_INSERT_IMAGEMRACAGATO);
		psmt.setString(1, gatoRetornoBean.getId());
		psmt.setString(2, gatoRetornoBean.getUrl());
		psmt.setString(3, gatoRetornoBean.getWidth());
		psmt.setString(4, gatoRetornoBean.getHeight());
		
		if(buscaX.get("category_ids") != null){
			psmt.setLong(5,categoriaDao.localizarCategoriaPorId(new Long(buscaX.get("category_ids"))));
			
		}else{
			psmt.setString(5,null);
		}

		if(buscaX.get("breed_id") != null){
			psmt.setLong(6,racaDao.localizarRacaPorId(buscaX.get("breed_id")));
			
		}else{
		
			psmt.setString(6,null);
		
		}
		
		psmt.execute();
		
		return gatoRetornoBean;
		
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._003_ERRO_AO_EXECUTAR_COMANDO_DE_INSERT);
			
		}
		
	}
	
	
	public Boolean localizarRacaPorUrl (GatoRetornoBean gatoRetornoBean) throws TechnicalException, BusinessException {
		
		try {
			
			dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
			Connection conexao = 	Dao.getConection(dataSourcer);	
			PreparedStatement psmt = conexao.prepareStatement(ImagemGatoRacaQueryDao.QUERY_CONSULTA_POR_ID_URL);
			psmt.setString(1, gatoRetornoBean.getUrl());
			ResultSet result = psmt.executeQuery();
				
			if(result.next()){
				
				return Boolean.TRUE;

			}else{
				
				return Boolean.FALSE;

			}
				
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
			
		}

	}



}
