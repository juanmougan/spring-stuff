package com.github.juanmougan.springstuff.multitenancy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class SchemaMultiTenantConnectionProvider extends AbstractMultiTenantConnectionProvider {
  private ConnectionProvider connectionProvider;

  public SchemaMultiTenantConnectionProvider() throws IOException {
    this.connectionProvider = initConnectionProvider();
  }

  @Override
  protected ConnectionProvider getAnyConnectionProvider() {
    return connectionProvider;
  }

  @Override
  protected ConnectionProvider selectConnectionProvider(
    String tenantIdentifier) {

    return connectionProvider;
  }

  @Override
  public Connection getConnection(String tenantIdentifier)
    throws SQLException {

    Connection connection = super.getConnection(tenantIdentifier);
    connection.createStatement()
      .execute(String.format("SET SCHEMA %s;", tenantIdentifier));
    return connection;
  }

  private ConnectionProvider initConnectionProvider() throws IOException {
    Properties properties = new Properties();
    properties.load(getClass()
      .getResourceAsStream("/hibernate.properties"));

    DriverManagerConnectionProviderImpl connectionProvider
      = new DriverManagerConnectionProviderImpl();
    connectionProvider.configure(properties);
    return connectionProvider;
  }
}
