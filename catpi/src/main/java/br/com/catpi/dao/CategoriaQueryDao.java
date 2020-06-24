package br.com.catpi.dao;

public class CategoriaQueryDao {

	public static final String QUERY_INSERT_CATEORIA = "INSERT INTO TL_LGTB_CATEGORIAIMAGEM_CAIM (CAIM_ID_EXTERNO,CAIM_TX_NAME) VALUES (?,?) " ;
	public static final String QUERY_CONSULTA_POR_ID_CATEORIA = "SELECT * FROM  TL_LGTB_CATEGORIAIMAGEM_CAIM WHERE  CAIM_ID_EXTERNO = ? " ;

}
