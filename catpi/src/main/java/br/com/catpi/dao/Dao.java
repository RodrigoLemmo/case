package br.com.catpi.dao;

import java.sql.Connection;

import br.com.catapi.exception.TechnicalException;
import br.com.catapi.util.ConfiguracaoDataSourcer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class Dao {

	private static HikariDataSource dsCatApi;
	private static Connection con;

	private Dao() {
	}

	/**
	 * Retorna uma conexao de banco de dados utilizando as configuraçoes
	 * 
	 * @throws TechnicalException
	 * 
	 * */
	public static Connection getConection(ConfiguracaoDataSourcer confDataSoucer)
			throws TechnicalException {

		try {
			if (dsCatApi == null) {

				HikariConfig confCatapi = new HikariConfig();
				confCatapi.setJdbcUrl(confDataSoucer.getUrl());
				confCatapi.setUsername(confDataSoucer.getUserName());
				confCatapi.setPassword(confDataSoucer.getPassword());
				confCatapi.setDriverClassName(confDataSoucer.getDriveClasse());
				dsCatApi = new HikariDataSource(confCatapi);
				con = dsCatApi.getConnection();
			}

			return con;

		} catch (Throwable e) {

			throw new TechnicalException(
					TechnicalException._0005_ERRO_AO_CONECTAR_NO_BANCO_DE_DADOS);

		}
	}
}