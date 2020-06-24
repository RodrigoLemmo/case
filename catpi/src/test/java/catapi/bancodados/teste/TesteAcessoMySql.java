package catapi.bancodados.teste;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoDataSourcer;
import br.com.catpi.dao.Dao;

public class TesteAcessoMySql {


	
	@Test
	public void testeAcessoMySql () throws BusinessException, TechnicalException, SQLException{
		 ConfiguracaoDataSourcer dataSourcer = new ConfiguracaoDataSourcer(ConfiguracaoAPI.CONF_PROPRIEDADES_DATASOUCER) ;	
		 Assert.assertNotNull("PROBLEMA AO CONECTAR NO BANCO DE DADOS",  Dao.getConection(dataSourcer));
	}

}
