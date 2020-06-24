package br.com.catapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.catapi.business.CatApiBusiness;
import br.com.catapi.exception.BusinessException;
import br.com.catapi.exception.TechnicalException;

@Configuration
@EnableScheduling
/**
 * 
 *  Agendador para atualização de lista de raça e categoria
 * 
 * 
 * */
public class ConfigTask {
	@Autowired
	private LogService log;
	private CatApiBusiness catApiBusiness = new CatApiBusiness();
	
	@Scheduled(fixedDelay = 600000)//10 min
	public void scheduleFixedDelayTask() {
	
		try {
			catApiBusiness.gravarTodasRacasGatos();
		
		} catch (BusinessException |  TechnicalException e ) {
			log.gravarLog("ERRO TASK", this.getClass().getSimpleName(), LogService.ERROR,e);

		
		} 
	
	}


}