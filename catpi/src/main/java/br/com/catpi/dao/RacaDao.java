package br.com.catpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.catapi.bean.RacaGatoBean;
import br.com.catapi.bean.RacaRetornoBean;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoDataSourcer;

public class RacaDao {

	private ConfiguracaoDataSourcer dataSourcer ;

	public boolean gravarRaca(RacaRetornoBean raca) throws BusinessException, TechnicalException{
		
		try {
			
 			if(localizarRacaPorId(raca.getId())!=null){

				return Boolean.TRUE;
				
			}
			
			dataSourcer = new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER);
			Connection conexao = 	Dao.getConection(dataSourcer);
			
			
		PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.RACA_INSERT);
		psmt.setString(1, raca.getWeight().getImperial());
		psmt.setString(2, raca.getWeight().getMetric());
		psmt.setString(3, raca.getId());
		psmt.setString(4, raca.getName());
		psmt.setString(5, raca.getCfaUrl());
		psmt.setString(6, raca.getVetStreetUrl());
		psmt.setString(7, raca.getTemperament());
		psmt.setString(8, raca.getOrigin());
		psmt.setString(9, raca.getCountryCode());
		psmt.setString(10, raca.getDescription());
		psmt.setString(11, raca.getLifeSpan());
		psmt.setString(12, raca.getIndoor());
		psmt.setString(13, raca.getIndoor());
		psmt.setString(14, raca.getLap());
		psmt.setString(15, raca.getAltNames());
		psmt.setString(16, raca.getAdaptability());
		psmt.setString(17, raca.getChildFriendly());
		psmt.setString(18, raca.getDogFriendly());
		psmt.setString(19, raca.getEnergyLevel());
		psmt.setString(20, raca.getGrooming());
		psmt.setString(21, raca.getHealthIssues());
		psmt.setString(22, raca.getIntelligence());
		psmt.setString(23, raca.getSheddingLevel());
		psmt.setString(24, raca.getSocialNeeds());
		psmt.setString(25, raca.getStrangerFriendly());
		psmt.setString(26, raca.getVocalisation());
		psmt.setString(27, raca.getExperimental());
		psmt.setString(28, raca.getHairless());
		psmt.setString(29, raca.getNatural());
		psmt.setString(30, raca.getRare());
		psmt.setString(31, raca.getRex());
		psmt.setString(32, raca.getSuppressedTail());
		psmt.setString(33, raca.getShortLegs());
		psmt.setString(34, raca.getWikipediaUrl());
		psmt.setString(35, raca.getHypoallergenic());
		
		boolean sucesso =  psmt.execute();
			
		return sucesso;
		
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._003_ERRO_AO_EXECUTAR_COMANDO_DE_INSERT);
			
		}
		
	}
	
	
public Long localizarRacaPorId (String  idRaca) throws TechnicalException, BusinessException {
		
		try {
			
			dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
			Connection conexao = 	Dao.getConection(dataSourcer);	
			PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.QUERY_CONSULTA_POR_ID_RACA);
			psmt.setString(1, idRaca);
			ResultSet result = psmt.executeQuery();
				
			if(result.next()){
				
				return result.getLong("ID_RACA_CD_RACAGATOS");

			}else{
				
				return null;

			}
				
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
			
		}

	}
	

public List<RacaGatoBean> listarRacas () throws BusinessException, TechnicalException{
	
	List<RacaGatoBean>  listaGatos = new ArrayList<RacaGatoBean>();
	try {

		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);	
		PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.QUERY_CONSULTA_TODAS_RACAS);	

	 ResultSet ret = psmt.executeQuery();
		
		while (ret.next()){
			RacaGatoBean racaGatoBean = new RacaGatoBean();
			racaGatoBean.setId(ret.getLong("ID_RACA_CD_RACAGATOS"));
			racaGatoBean.setNomeRaca(ret.getString("RACA_TX_NAME"));
			racaGatoBean.setExternalId(ret.getString("RACA_TX_ID"));
			racaGatoBean.setTemperamento(ret.getString("RACA_TX_TEMPERAMENT"));
			racaGatoBean.setOrigem(ret.getString("RACA_TX_ORIGEN"));
			racaGatoBean.setDescricao(ret.getString("RACA_TX_DESCRIPTION"));
			listaGatos.add(racaGatoBean);
		}
		
		return listaGatos;
	} catch (BusinessException businessExpection) {
		throw  businessExpection;	
	
	} catch (SQLException e) {
		throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
		
	}

}


public List<RacaGatoBean> listarInformacaoPorRaca(String idExterno) throws TechnicalException, BusinessException {

	List<RacaGatoBean>  listaGatos = new ArrayList<RacaGatoBean>();
	try {

		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);	
		PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.QUERY_CONSULTA_LISTAR_INFORMACAO_RACA);	
		psmt.setString(1, idExterno);
	 
		ResultSet ret = psmt.executeQuery();
		
		while (ret.next()){
			RacaGatoBean racaGatoBean = new RacaGatoBean();
			racaGatoBean.setId(ret.getLong("ID_RACA_CD_RACAGATOS"));
			racaGatoBean.setNomeRaca(ret.getString("RACA_TX_NAME"));
			racaGatoBean.setExternalId(ret.getString("RACA_TX_ID"));
			racaGatoBean.setTemperamento(ret.getString("RACA_TX_TEMPERAMENT"));
			racaGatoBean.setOrigem(ret.getString("RACA_TX_ORIGEN"));
			racaGatoBean.setDescricao(ret.getString("RACA_TX_DESCRIPTION"));
			listaGatos.add(racaGatoBean);
		}
		
		return listaGatos;
	
	} catch (BusinessException businessExpection) {
		throw  businessExpection;	
	
	} catch (SQLException e) {
		throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
		
	}
	
}


public List<RacaGatoBean> listarInformacaoPorTemperamento(String temperamento) throws TechnicalException, BusinessException {

	List<RacaGatoBean>  listaGatos = new ArrayList<RacaGatoBean>();
	try {

		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);	
		PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.QUERY_CONSULTA_LISTAR_INFORMACAO_TEMPERAMENTO);	
		psmt.setString(1, "%" + temperamento + "%");
	 
		ResultSet ret = psmt.executeQuery();
		
		while (ret.next()){
			RacaGatoBean racaGatoBean = new RacaGatoBean();
			racaGatoBean.setId(ret.getLong("ID_RACA_CD_RACAGATOS"));
			racaGatoBean.setNomeRaca(ret.getString("RACA_TX_NAME"));
			racaGatoBean.setExternalId(ret.getString("RACA_TX_ID"));
			racaGatoBean.setTemperamento(ret.getString("RACA_TX_TEMPERAMENT"));
			racaGatoBean.setOrigem(ret.getString("RACA_TX_ORIGEN"));
			racaGatoBean.setDescricao(ret.getString("RACA_TX_DESCRIPTION"));
			listaGatos.add(racaGatoBean);
		}
		
		return listaGatos;
	
	} catch (BusinessException businessExpection) {
		throw  businessExpection;	
	
	} catch (SQLException e) {
		throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
		
	}
	
}


public List<RacaGatoBean> listarInformacaoPorOrigem(String origem) throws TechnicalException, BusinessException {

	List<RacaGatoBean>  listaGatos = new ArrayList<RacaGatoBean>();
	try {

		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);	
		PreparedStatement psmt = conexao.prepareStatement(RacaoQueryDao.QUERY_CONSULTA_LISTAR_INFORMACAO_ORIGEM);	
		psmt.setString(1, origem);
	 
		ResultSet ret = psmt.executeQuery();
		
		while (ret.next()){
			RacaGatoBean racaGatoBean = new RacaGatoBean();
			racaGatoBean.setId(ret.getLong("ID_RACA_CD_RACAGATOS"));
			racaGatoBean.setNomeRaca(ret.getString("RACA_TX_NAME"));
			racaGatoBean.setExternalId(ret.getString("RACA_TX_ID"));
			racaGatoBean.setTemperamento(ret.getString("RACA_TX_TEMPERAMENT"));
			racaGatoBean.setOrigem(ret.getString("RACA_TX_ORIGEN"));
			racaGatoBean.setDescricao(ret.getString("RACA_TX_DESCRIPTION"));
			listaGatos.add(racaGatoBean);
		}
		
		return listaGatos;
	
	} catch (BusinessException businessExpection) {
		throw  businessExpection;	
	
	} catch (SQLException e) {
		throw new TechnicalException(TechnicalException._004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA);
		
	}
	
}
}
