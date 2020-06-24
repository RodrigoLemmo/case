package cat.api.elaasticseacher.teste;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;
import br.com.catapi.services.ConfigElastic;
import br.com.catapi.services.LogRepository;
import br.com.catpi.dao.ControleLog;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigElastic.class)
public class TesteElasticSeacher {

	@Autowired
	private LogRepository logRepository;
	private Page<ControleLog> retorno;
	
	@Before
	 public void before() {
		
		ControleLog controleLog = new ControleLog();
		controleLog.setDataRegistroLogEntrada(new Date());
		controleLog.setLogEntrada("Teste Problemas");
		controleLog.setTipo("Error");
		logRepository.save(controleLog);
	}
	
	
	@Test
	public void testeConsulta () throws BusinessException, TechnicalException, SQLException{

		try {

			
			retorno =  logRepository.findByLogEntrada("ControllerCatApi", PageRequest.of(0, 10));
			
			for (ControleLog controleLog : retorno) {
				controleLog.getAuthorsName();
			}
			
			// Log de entrada
			String jsonEntrada = "Problemas";
			Page<ControleLog> retorno  = logRepository.findByLogEntrada(jsonEntrada, PageRequest.of(0, 10));
			
			for (ControleLog controleLog : retorno) {
				 controleLog.getAuthorsName();
			}
			
			
		
		}catch (Throwable e) {
			System.out.println(e);
		}
			
		
	}
	

  
	

}
