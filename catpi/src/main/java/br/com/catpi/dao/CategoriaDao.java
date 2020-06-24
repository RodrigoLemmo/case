package br.com.catpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.catapi.bean.CategoriaRetornoBean;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoDataSourcer;

public class CategoriaDao {
	
	private ConfiguracaoDataSourcer dataSourcer;

	public Boolean gravarCategoria(CategoriaRetornoBean categoria) throws BusinessException, TechnicalException {
		
		try {
		
			if(localizarCategoriaPorId(categoria.getId()) != null ){
				return Boolean.TRUE;
			}
			
		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);
		PreparedStatement psmt = conexao.prepareStatement(CategoriaQueryDao.QUERY_INSERT_CATEORIA);
		psmt.setLong(1, categoria.getId());
		psmt.setString(2, categoria.getName());
		
		Boolean sucesso = psmt.execute();
		
		return sucesso;
		
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._003_ERRO_AO_EXECUTAR_COMANDO_DE_INSERT);
			
		}
		
	}
	
	
	public Long localizarCategoriaPorId (Long idCategoria) throws TechnicalException, BusinessException {
		
		try {
			
			dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
			Connection conexao = 	Dao.getConection(dataSourcer);	
			PreparedStatement psmt = conexao.prepareStatement(CategoriaQueryDao.QUERY_CONSULTA_POR_ID_CATEORIA);
			psmt.setLong(1,  idCategoria);
			ResultSet result = psmt.executeQuery();
				
			if(result.next()){
				
				return	result.getLong("ID_CAIM_CD_CATEGORIAIMAGEM");
			}else{
				
				return null;
			}
				
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
			
		}

	}
	
}
