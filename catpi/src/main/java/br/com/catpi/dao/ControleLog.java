package br.com.catpi.dao;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "log")
public class ControleLog {
	
	@Id
	private String idControleLog;
	private String logEntrada;
	private Date dataRegistroLogEntrada;
	private String tipo;
	private String authorsName;
	private String erro;
	
	public String getIdControleLog() {
		return idControleLog;
	}
	public void setIdControleLog(String idControleLog) {
		this.idControleLog = idControleLog;
	}
	public String getLogEntrada() {
		return logEntrada;
	}
	public void setLogEntrada(String logEntrada) {
		this.logEntrada = logEntrada;
	}
	public Date getDataRegistroLogEntrada() {
		return dataRegistroLogEntrada;
	}
	public void setDataRegistroLogEntrada(Date dataRegistroLogEntrada) {
		this.dataRegistroLogEntrada = dataRegistroLogEntrada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAuthorsName() {
		return authorsName;
	}
	public void setAuthorsName(String authorsName) {
		this.authorsName = authorsName;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	
	
}
