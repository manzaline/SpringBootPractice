package com.example.ch03;

import com.example.ch03.jpa.PagingRepository;
import com.example.ch03.jpa.domain.User;
import com.example.ch03.jpa.repository.CustomizedUserRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAUserSpringBootApplicationTests {

  @Autowired
  private CustomizedUserRepository customizedUserRepository;

  @Autowired
  private PagingRepository pagingRepository;

  @Test
  void 커스텀User레포지토리로사용자찾기() {
    User user = new User("스즈무라 아이리", "1234", 20);
    customizedUserRepository.save(user);

    assertThat(Arrays.asList(customizedUserRepository.findAll()).size()).isEqualTo(1);
  }

  @Test
  void 첫페이지5개불러오기() {
    Pageable pageable = PageRequest.of(0, 5); // 페이지번호 0, 페이지당 데이터 건수는 5개
    assertThat(pagingRepository.findAll(pageable)).hasSize(5);
    assertThat(pageable.getPageNumber()).isEqualTo(0);

    Pageable nextPageable = pageable.next();
    assertThat(pagingRepository.findAll(nextPageable)).hasSize(4);
    assertThat(nextPageable.getPageNumber()).isEqualTo(1);
  }
}
