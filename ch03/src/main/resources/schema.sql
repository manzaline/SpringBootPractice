CREATE DATABASE IF NOT EXISTS practice_db;
USE practice_db;

CREATE TABLE IF NOT EXISTS user_tb (
  id int auto_increment primary key,
  name varchar(50)
);

select * from user_tb;
truncate table user_tb;
-- JPA 엔티티로 테이블을 생성해도 쿼리에서 반드시 기입을 해줘야 아래의 insert into 가 작동한다
-- 그렇지 않으면 서버가 무한재부팅되는 에러가 발생한다.


