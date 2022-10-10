package com.program.dashboard.springsecuritydashboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


class SpringSecurityDashboardApplicationTests {

	@Test
	void testConnection() {

		String url = "jdbc:mysql://localhost/spring_customer_tracker";
		String username = "root";
		String password = "";
		try {

			Driver mSqlDriver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(mSqlDriver);

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("koneksi berhasil " + connection);
			//setiap selesai menggunakan database harus selalu diclose
			connection.close();
			System.out.println("Konesksi berhasil ditutup");
		}catch (SQLException exception)
		{
			exception.printStackTrace();
		}

	}

}
