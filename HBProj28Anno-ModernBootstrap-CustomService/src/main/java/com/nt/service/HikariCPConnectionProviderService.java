package com.nt.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.Service;

import com.zaxxer.hikari.HikariDataSource;

import oracle.net.aso.h;

public class HikariCPConnectionProviderService implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("HikariCP DataSource Service...");
		
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setJdbcUrl("jdbc:mysql:///hibernate");
		hkDs.setUsername("root");
		hkDs.setPassword("root");
		hkDs.setConnectionTimeout(30000);
		
		return hkDs.getConnection();
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
	
		con.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
