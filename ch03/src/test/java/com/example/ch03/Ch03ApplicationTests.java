package com.example.ch03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Ch03ApplicationTests {

  @Autowired
  private DataSource dataSource;

  @Test
  public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails()
          throws SQLException {

    assertThat(dataSource.getClass().getName()).contains("HikariDataSource");
    assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).contains("MySQL");;
  }
}
