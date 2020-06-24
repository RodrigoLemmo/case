package br.com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String dataHoraBrasileira(Date data) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return df.format(data);
	}
}

