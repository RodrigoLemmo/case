package br.com.catpi.dao;
public class LoginQueryDao {

	public final static String QUERY_CONSULTA_LOGIN_SENHA = " SELECT * FROM TL_NGTB_LOGINCATAPI_LOGI WHERE LOGI_TX_USUARIO = ? AND LOGI_TX_SENHA =?  " ;

}
