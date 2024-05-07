package com.green.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.green.entity.Comments;

public interface CommentRepository 
    extends JpaRepository<Comments, Long>{

	// @Query 에노테이션으로 findByArticleId() 를 실행한다
	//  @Query 에노테이션는 Jpa 기능사용하지않고 @Queyr 안의 sql을 사용한다
	// findByArticleId() 함수는 Comments 테이블 칼럼을 사용해서 만든다
	// Native Query Method - oracle 전용 문법으로 작성된 쿼리를 입력하여 조회
	// nativeQuery = true   : 오라클 전용함수
	// nativeQuery = false  : JPQL 문법, JPA 함수
	// :articleId (파라미터)로 조회한다 
	// JPQL - jpa 용 sql - db 종류와 상관없이 
	// QueryDsl - JPA 에서 oracle 전용sql 문을 실행하는 기술
	@Query(value="SELECT * FROM comments WHERE article_id=:articleId",
			nativeQuery = true )
	List<Comments> findByArticleId(Long articleId); 
	
	// native query xml :
	// src/main/resources/META-INF/orm.xml // 폴더와 파일 생성해야한다
	// orm.xml 에 sql 을 저장해서 findByNickname() 함수 호출 
	List<Comments> findByNickname(String nickname);
}







