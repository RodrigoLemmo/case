package catapi.business.teste;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.catapi.bean.RacaRetornoBean;
import br.com.catapi.business.CatApiBusiness;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;

@RunWith(SpringJUnit4ClassRunner.class)
public class TesteBusiness {
	
	private CatApiBusiness catApiBusiness = new CatApiBusiness();
	
	private Integer qtsImagem = 3;
	private Map<String, String> parametroPesqusisa = null;
	
	
	@Test
	public void testeConsumirServicoGravarTodosGatos() throws BusinessException, TechnicalException, SQLException{
		catApiBusiness.gravarTodasRacasGatos();
	}
		
		
	@Test
	public void testeServicoCategoriaGravar () throws BusinessException, TechnicalException, SQLException{
		catApiBusiness.listarTodasCategorias();
	}
	
	@Test
	public void testeGravar3ImagemPorRaça () throws BusinessException, TechnicalException, SQLException{
	 List<RacaRetornoBean> listaRacas =	catApiBusiness.gravarTodasRacasGatos();
	 
	 for (RacaRetornoBean raca : listaRacas) {
	
		 for (int i = 0; i < qtsImagem; i++) {
			 
			 parametroPesqusisa =new HashMap<String, String>();
			 parametroPesqusisa.put("breed_id", raca.getId());
			 catApiBusiness.gravarImagemPorX(parametroPesqusisa) ;
			 
		 }
	 	}
	}
	
	@Test
	public void testeGravar3ImagemComChapeu () throws BusinessException, TechnicalException, SQLException{


	 for (int i = 0; i < qtsImagem; i++) {
			 parametroPesqusisa =new HashMap<String, String>();
			 parametroPesqusisa.put("category_ids", "1"); //chapeu hat
			 catApiBusiness.gravarImagemPorX(parametroPesqusisa) ;
		 }
	}
	
	
	@Test
	public void testeGravar3ImagemComOculo () throws BusinessException, TechnicalException, SQLException{
		
		
		for (int i = 0; i < qtsImagem; i++) {
			parametroPesqusisa =new HashMap<String, String>();
			parametroPesqusisa.put("category_ids", "4"); //chapeu hat
			catApiBusiness.gravarImagemPorX(parametroPesqusisa) ;
		}
	}
	

}
