package catapi.configuracao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.util.ConfiguracaoAPI;
import br.com.catapi.util.ConfiguracaoRequestGetBean;

/**
 * Classe JUNIT para realização de teste unitarios
 * */
public class TesteConfiguracao {

	private String[] caminhosConfiguracaoTest = {ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_CATALOGO,ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_RACAS,ConfiguracaoAPI.CONF_PROPRIEDADES_CATAPI_BUSCAR};

	
	@Test
	public void testarConfiguracaoIntegracaoRest() throws BusinessException{
		
		for (String caminhoUrl : caminhosConfiguracaoTest) {
			testeConfiguracaoParaIntegracaoRest(caminhoUrl);
		}
		
	}
	
	
	
	 private void testeConfiguracaoParaIntegracaoRest (String configuracao) throws BusinessException{
		
			 ConfiguracaoRequestGetBean conf = new ConfiguracaoRequestGetBean(configuracao);
		
			 Assert.assertNotNull("valor obrigatório PROTOCOLO TIPO", conf.getProtocoloTipo());
			 Assert.assertNotNull("valor obrigatório TLS", conf.getTls());
			 Assert.assertNotNull("valor obrigatório TIPO", conf.getTipo());
			 Assert.assertNotNull("valor obrigatório CONTENT TYPE ", conf.getContentType());
			 Assert.assertNotNull("valor obrigatório CONTENT TYPE VALUE ", conf.getContentTypeValue());
			 Assert.assertNotNull("valor obrigatório CHATSET ", conf.getChatset());
			 Assert.assertNotNull("valor obrigatório CHATSETVALUE ", conf.getChatsetValue());
			 Assert.assertNotNull("valor obrigatório USER AGENTE ", conf.getUserAgent());
			 Assert.assertNotNull("valor obrigatório USER AGENTE VALUE ", conf.getUserAgenteValue());
			 Assert.assertNotNull("valor obrigatório URL", conf.getUserAgenteValue());

	 }
	
}
