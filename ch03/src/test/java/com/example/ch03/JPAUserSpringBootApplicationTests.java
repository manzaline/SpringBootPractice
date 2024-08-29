package com.example.ch03;

import com.example.ch03.jpa.PagingRepository;
import com.example.ch03.jpa.UserRepository;
import com.example.ch03.jpa.domain.User;
import com.example.ch03.jpa.repository.CustomizedUserRepository;
import org.assertj.core.api.Condition;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JPAUserSpringBootApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CustomizedUserRepository customizedUserRepository;

  @Autowired
  private PagingRepository pagingRepository;

  @Test
  void 더미데이터입력() {
    User user1 = new User("스즈무라 아이리", "1111", 18);
    User user2 = new User("타카스기 마리", "2222", 20);
    User user3 = new User("쿠루루기 아오이", "3333", 22);
    User user4 = new User("치카 아리무라", "4444", 23);
    User user5 = new User("아카리 미타니", "5555", 22);
    User user6 = new User("진구지 나오", "5555", 21);
    User user7 = new User("사쿠라 마나", "5555", 23);

    userRepository.saveAll(java.util.Arrays.asList(user1, user2, user3, user4, user5, user6, user7));
  }

  @Test
  void 커스텀User레포지토리로사용자찾기() {
    User user = new User("스즈무라 아이리", "1234", 20);
    customizedUserRepository.save(user);

    assertThat(Arrays.asList(customizedUserRepository.findAll()).size()).isEqualTo(1);
  }

  @Test
  void 첫0페이지5개와다음1페이지데이터확인() {
    Pageable pageable = PageRequest.of(0, 5); // 페이지번호 0, 페이지당 데이터 건수는 5개
    assertThat(pagingRepository.findAll(pageable)).hasSize(5); // 현재 0페이지 5개의 데이터
    assertThat(pageable.getPageNumber()).isEqualTo(0); // 현재 페이지번호

    Pageable nextPageable = pageable.next();
    assertThat(pagingRepository.findAll(nextPageable)).hasSize(3); // 총 8개의 데이터가 있으므로 0페이지 5개 이후 다음 1페이지의 데이터는 3개다
    assertThat(nextPageable.getPageNumber()).isEqualTo(1); // 1페이지
  }

  @Test
  void 나이기준오름차순페이징과정렬() {
    Pageable pageable =
            PageRequest.of(0, 5, Sort.by(Sort.Order.asc("age"))); // age를 오름차순으로 정렬
    Condition<User> sortedFirstUserCondition = new Condition<>() {
      @Override
      public boolean matches(User user) {
        return user.getId() == 2
                && user.getName().equals("스즈무라 아이리");
      }
    };

    assertThat(pagingRepository.findAll(pageable)).first() // findAll 반환값은 iterable
            .has(sortedFirstUserCondition);
  }

  @Test
  void 나이내림차순이름오름차순페이징과정렬() {
    Pageable pageable =
            PageRequest.of(0, 5, Sort.by(Sort.Order.desc("age"), Sort.Order.asc("name")));

    pagingRepository.findAll(pageable).forEach(System.out::println);

    pageable = pageable.next();

    pagingRepository.findAll(pageable).forEach(System.out::println);

  }
}
