package br.com.catapi.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.catpi.dao.ControleLog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LogService {

	public static final String INFO = "INF";
	public static final String WARN = "WARN";
	public static final String ERROR = "ERRO";

	private ObjectMapper conversor = new ObjectMapper();

	@Autowired
	private LogRepository logRepository;

	@Async
	public void gravarLog(Object info, String classes, String tipo) {
		try {

			ControleLog controleLog = new ControleLog();
			controleLog.setDataRegistroLogEntrada(new Date());
			controleLog.setLogEntrada(conversor.writeValueAsString(info));
			controleLog.setAuthorsName(classes);
			controleLog.setTipo(tipo);
			logRepository.save(controleLog);

		} catch (JsonProcessingException e) {
			new LogService().gravarLog("Erro ao converter objeto para Json", this
					.getClass().getName(), LogService.ERROR,e);
		}
	}
	
	@Async
	public void gravarLog(Object info, String classes, String tipo, Exception exp) {
		try {
			
			ControleLog controleLog = new ControleLog();
			controleLog.setDataRegistroLogEntrada(new Date());
			controleLog.setLogEntrada(conversor.writeValueAsString(info));
			controleLog.setErro(exp.getMessage());
			controleLog.setAuthorsName(classes);
			controleLog.setTipo(tipo);
			logRepository.save(controleLog);
			
		} catch (JsonProcessingException e) {
			new LogService().gravarLog("Erro ao converter objeto para Json", this
					.getClass().getName(), LogService.ERROR,e);
		}
	}

}
