# roamstory

스프링 웹 프로젝트 구성
====================

1. 개발 패키지 구성
 - com.roamstory.domain
 - com.roamstory.service
 - com.roamstory.persistence
 - com.roamstory.controller
 - resources/mapper

2. 기본 라이브러리
 - spring-jdbc/test
 - mybatis 3.4.1
 - mybatis-spring 1.3.0
 - log4jdbc 1.16
 - javax.servlet-api 3.1.0
 - junit 4.12
 - mysql-connector-java 6.0.5
 - jackson-databind 2.8.4

3. tbl_board  테이블 생성 SQL
	create table tbl_board (
	   bbsno   INT          NOT NULL AUTO_INCREMENT,
	   title   VARCHAR(200) NOT NULL,
	   content TEXT             NULL,
	   writer  VARCHAR(50)  NOT NULL,
	   regdate TIMESTAMP    NOT NULL DEFAULT now(),
	   viewcnt INT                   DEFAULT 0,
	   primary key (bbsno)
	);
	
4. 테스트를 위한 SQL 문 준비

 - 게시물 등록 SQL
 insert into tbl_board (title, content, writer)
 values ('스프링이란?','스프링은....','user01');
 
 - 게시글 조회 SQL
 select * from tbl_board where bbsno = 1;
 
 - 게시글 목록 조회 SQL
 select * from tbl_board where bbsno > 0 order by bbsno desc;
 
 - 게시물 수정 SQL
 update tbl_board set title='스프링의 특징은?' where bbsno = 1;
 
 - 게시물 삭제 SQL
 delete from tbl_board where bbsno = 1;
 
	   