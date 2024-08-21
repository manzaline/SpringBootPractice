package com.example.ch03;

import com.example.ch03.jpa.domain.User;
import com.example.ch03.jpa.UserRepository;
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

  @Autowired
  private UserRepository userRepository;

  @Test
  public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails()
          throws SQLException {

    assertThat(dataSource.getClass().getName()).contains("HikariDataSource");
    assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).contains("MySQL");;
  }

  @Test
  public void givenUserRepositoryThenSaveUser() {
    User user = new User("미나미 아이자와", "1234", 20);
    User saveUser = userRepository.save(user);
    userRepository.findById(saveUser.getId()).ifPresent(savedUser -> {
      assertThat(savedUser.getName()).isEqualTo(user.getName());
    });
  }

  @Test
  public void givenUpdateUserThenFindById() {
    User user = new User("미나미 아이자와", "1234", 20);
    userRepository.save(user);
    user.setName("미나미아이자와(변경)");
    User updatedUser = userRepository.save(user);
    userRepository.findById(updatedUser.getId()).ifPresent(savedUser -> {
      assertThat(savedUser.getName()).isEqualTo(user.getName());
    });
  }

  @Test
  public void givenDeleteUserThenFindById() {
    User user = new User("미나미 아이자와", "1234", 20);
    userRepository.save(user);
    assertThat(userRepository.findById(user.getId()).get()).isEqualTo(user);
    userRepository.deleteById(user.getId());
    assertThat(userRepository.findById(user.getId()).isPresent()).isFalse();
  }

}
