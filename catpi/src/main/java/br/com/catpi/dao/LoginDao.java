package br.com.catpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoDataSourcer;

public class LoginDao {

	
	private ConfiguracaoDataSourcer dataSourcer;

	public Boolean validarAcesso(String login, String senha) throws BusinessException, TechnicalException {
		
		try {
		
		dataSourcer =  new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		Connection conexao = 	Dao.getConection(dataSourcer);
		PreparedStatement psmt = conexao.prepareStatement(LoginQueryDao.QUERY_CONSULTA_LOGIN_SENHA);

		psmt.setString(1,login);
		psmt.setString(2,senha);
		
		
		ResultSet ret = psmt.executeQuery();
		
		if(ret.next()){
			
			return Boolean.TRUE;
		}else{
			
			return Boolean.FALSE;
		}
		
		} catch (BusinessException businessExpection) {
			throw  businessExpection;	
		
		} catch (SQLException e) {
			throw new TechnicalException(TechnicalException._003_ERRO_AO_EXECUTAR_COMANDO_DE_INSERT);
			
		}
		
	}
	
}
