package catapi.integrador.teste;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.integrador.apiclient.CatApiIntegrador;

public class TesteIntegrador {

	private Map<String, String> parametrosConsulta = new HashMap<String, String>();
	private CatApiIntegrador catApiIntegrador = new CatApiIntegrador();

	
	
	@Test
	public void testeListarApiCatCategoria () throws BusinessException, TechnicalException{
		 Assert.assertNotNull("Categorio não encontrada",  catApiIntegrador.listarCategorias());
	}

	@Test
	public void testeListarApiCatRacas () throws BusinessException, TechnicalException{
		Assert.assertNotNull("Categorio não encontrada",  catApiIntegrador.listarRacas());
		
	}
	@Test
	public void testeConsultarPorRaca () throws BusinessException, TechnicalException{
		parametrosConsulta = new HashMap<String, String>();
		parametrosConsulta.put("breed_id", "aege");
		Assert.assertNotNull("Categorio não encontrada",  catApiIntegrador.consultarPorX(parametrosConsulta));
		
	}

	@Test
	public void testeConsultarPorCategoria () throws BusinessException, TechnicalException{
		parametrosConsulta = new HashMap<String, String>();
		parametrosConsulta.put("category_ids", "1"); //HATS
		Assert.assertNotNull("Categorio não encontrada",  catApiIntegrador.consultarPorX(parametrosConsulta));
	}
	
	
	
	
}
