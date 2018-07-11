package br.com.akira.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/usuariodb", "root", "123456");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
