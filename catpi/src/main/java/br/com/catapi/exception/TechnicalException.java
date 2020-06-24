package br.com.catapi.exception;

public class TechnicalException extends Exception {

	
	 /**
	 * Exeception para erros de Tecnicos/Infra estrutura 
	 */
	private static final long serialVersionUID = -5306509250609801537L;
	public static final String _004_ERRO_AO_EXECUTAR_COMANDO_DE_CONSULTA = "[004] - ERRO AO EXECUTAR COMANDO DE CONSULTA";
	public static final String _003_ERRO_AO_EXECUTAR_COMANDO_DE_INSERT = "[003] - ERRO AO EXECUTAR COMANDO DE INSERT";
	public static final String _0005_ERRO_AO_CONECTAR_NO_BANCO_DE_DADOS = "[0005] ERRO AO CONECTAR NO BANCO DE DADOS";


	public TechnicalException(String errorMessage) {
	        super(errorMessage);
	    }
	
	
}
