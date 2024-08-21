package com.example.ch03;

import com.example.ch03.jpa.domain.User;
import com.example.ch03.jpa.repository.CustomizedUserRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAUserSpringBootApplicationTests {

  @Autowired
  private CustomizedUserRepository customizedUserRepository;

  @Test
  public void 커스텀User레포지토리로사용자찾기() {
    User user = new User("스즈무라 아이리", "1234", 20);
    customizedUserRepository.save(user);

    assertThat(Arrays.asList(customizedUserRepository.findAll()).size()).isEqualTo(1);  }
}
