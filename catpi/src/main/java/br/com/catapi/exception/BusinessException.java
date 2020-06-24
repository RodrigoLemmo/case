package br.com.catapi.exception;

public class BusinessException extends Exception {
	
	 /**
	 * Exeception para erros de negocios 
	 */
	private static final long serialVersionUID = -5306509250609801537L;
	public static final String _001_NÃO_FOI_POSSÍVEL_CARREGAR_A_CONFIGURAÇÃO = "[001] - NÃO FOI POSSÍVEL CARREGAR A CONFIGURAÇÃO:";
	public static final String _0003_ERRO_DE_CONVERSAO_IO_DE_RETORNO_DE_JSON = "[0003] - ERRO DE CONVERSAO/IO DE RETORNO DE JSON";
	public static final String _0003_ERRO_DE_MAPEAMENTO_DE_RETORNO_DE_JSON = "[0003] - ERRO DE MAPEAMENTO DE RETORNO DE JSON";
	public static final String _0003_ERRO_DE_FORMAÇÃO_DE_RETORNO_DE_JSON = "[0003] - ERRO DE FORMAÇÃO DE RETORNO DE JSON";
	
	public BusinessException(String errorMessage) {
	        super(errorMessage);
	    }
	

}
